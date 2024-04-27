"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[2800],{4972:(e,s,t)=>{t.r(s),t.d(s,{assets:()=>i,contentTitle:()=>a,default:()=>c,frontMatter:()=>r,metadata:()=>o,toc:()=>p});var n=t(4848),d=t(8453);const r={title:"Patterns: The multi-repo"},a=void 0,o={id:"multi-repo",title:"Patterns: The multi-repo",description:"There has been some comments about how the generated repositories do not match with peoples preferences of what a repository should be.",source:"@site/docs/multi-repo.md",sourceDirName:".",slug:"/multi-repo",permalink:"/typo/docs/multi-repo",draft:!1,unlisted:!1,tags:[],version:"current",frontMatter:{title:"Patterns: The multi-repo"}},i={},p=[{value:"So you write code yourself",id:"so-you-write-code-yourself",level:3},{value:"Example",id:"example",level:3},{value:"Isn&#39;t this a service at this point?",id:"isnt-this-a-service-at-this-point",level:2}];function l(e){const s={a:"a",code:"code",em:"em",h2:"h2",h3:"h3",li:"li",p:"p",pre:"pre",ul:"ul",...(0,d.R)(),...e.components};return(0,n.jsxs)(n.Fragment,{children:[(0,n.jsxs)(s.p,{children:["There has been some comments about how ",(0,n.jsx)(s.a,{href:"/typo/docs/what-is/relations",children:"the generated repositories"})," do not match with peoples preferences of what a repository should be.\nFor instance you may prefer that your repositories coordinate multiple tables."]}),"\n",(0,n.jsx)(s.p,{children:"And that's more than fair - Often you need to coordinate multiple tables in a transaction.\nThe only snag is that typo does not have the knowledge to write that code for you."}),"\n",(0,n.jsx)(s.h3,{id:"so-you-write-code-yourself",children:"So you write code yourself"}),"\n",(0,n.jsx)(s.p,{children:"Enter the multi-repo pattern!"}),"\n",(0,n.jsx)(s.p,{children:"Here you take low-level typo repositories as parameters, and you write the higher-level flow yourself."}),"\n",(0,n.jsx)(s.p,{children:"You still get huge benefits from using typo in this case:"}),"\n",(0,n.jsxs)(s.ul,{children:["\n",(0,n.jsx)(s.li,{children:"All of this is typesafe"}),"\n",(0,n.jsx)(s.li,{children:"You get perfect auto-complete from your IDE"}),"\n",(0,n.jsxs)(s.li,{children:["Strongly typed ",(0,n.jsx)(s.a,{href:"/typo/docs/type-safety/id-types",children:"Id types"})," and ",(0,n.jsx)(s.a,{href:"/typo/docs/type-safety/type-flow",children:"type flow"})," ensure that you have to follow foreign keys correctly"]}),"\n",(0,n.jsx)(s.li,{children:"It's fairly readable."}),"\n",(0,n.jsxs)(s.li,{children:["It's testable! You can even wire in ",(0,n.jsx)(s.a,{href:"/typo/docs/other-features/testing-with-stubs",children:"stub repositories"})," and test it all without a running database."]}),"\n"]}),"\n",(0,n.jsx)(s.p,{children:"Just have a look at the example and think how long it would take you to write this without typo."}),"\n",(0,n.jsxs)(s.p,{children:["With typo, this example worked ",(0,n.jsx)(s.em,{children:"the first time it was ran"}),"."]}),"\n",(0,n.jsx)(s.h3,{id:"example",children:"Example"}),"\n",(0,n.jsx)(s.p,{children:"The example repo below exposes one method, which coordinates updates to four tables."}),"\n",(0,n.jsx)(s.p,{children:"The details of what is done is probably not too important, but I tried to comment it anyway."}),"\n",(0,n.jsx)(s.pre,{children:(0,n.jsx)(s.code,{className:"language-scala",children:"import adventureworks.person.address.*\nimport adventureworks.person.addresstype.*\nimport adventureworks.person.businessentityaddress.*\nimport adventureworks.person.countryregion.CountryregionId\nimport adventureworks.person.person.*\nimport adventureworks.public.Name\nimport java.sql.Connection\n\ncase class PersonWithAddresses(person: PersonRow, addresses: Map[Name, AddressRow])\n\nclass PersonWithAddressesRepo(\n   personRepo: PersonRepo,\n   businessentityAddressRepo: BusinessentityaddressRepo,\n   addresstypeRepo: AddresstypeRepo,\n   addressRepo: AddressRepo\n ) {\n\n  /* A person can have a bunch of addresses registered,\n   * and they each have an address type (BILLING, HOME, etc).\n   *\n   * This method syncs `PersonWithAddresses#addresses` to postgres,\n   * so that old attached addresses are removed,\n   * and the given addresses are attached with the chosen type\n   */\n  def syncAddresses(pa: PersonWithAddresses)(implicit c: Connection): List[BusinessentityaddressRow] = {\n    // update person\n    personRepo.update(pa.person)\n    // update stored addresses\n    pa.addresses.toList.foreach { case (_, address) => addressRepo.update(address) }\n\n    // addresses are stored in `PersonWithAddress` by a `Name` which means what type of address it is.\n    // this address type is stored in addresstypeRepo.\n    // In order for foreign keys to align, we need to translate from names to ids, and create rows as necessary\n    val oldStoredAddressTypes: Map[Name, AddresstypeId] =\n    addresstypeRepo.select\n      .where(r => r.name in pa.addresses.keys.toArray)\n      .toList\n      .map(x => (x.name, x.addresstypeid))\n      .toMap\n\n    val currentAddressesByType: Map[AddresstypeId, AddressRow] =\n      pa.addresses.map { case (addressTypeName, wanted) =>\n        oldStoredAddressTypes.get(addressTypeName) match {\n          case Some(addresstypeId) => (addresstypeId, wanted)\n          case None =>\n            val inserted = addresstypeRepo.insert(AddresstypeRowUnsaved(name = addressTypeName))\n            (inserted.addresstypeid, wanted)\n        }\n      }\n\n    // discover existing addresses attached to person\n    val oldAttachedAddresses: Map[(AddressId, AddresstypeId), BusinessentityaddressRow] =\n      businessentityAddressRepo.select\n        .where(x => x.businessentityid === pa.person.businessentityid)\n        .toList\n        .map(x => ((x.addressid, x.addresstypeid), x))\n        .toMap\n\n    // unattach old attached addresses\n    oldAttachedAddresses.foreach { case (_, ba) =>\n      currentAddressesByType.get(ba.addresstypeid) match {\n        case Some(address) if address.addressid == ba.addressid =>\n        case _ =>\n          businessentityAddressRepo.delete(ba.compositeId)\n      }\n    }\n    // attach new addresses\n    currentAddressesByType.map { case (addresstypeId, address) =>\n      oldAttachedAddresses.get((address.addressid, addresstypeId)) match {\n        case Some(bea) => bea\n        case None =>\n          val newRow = BusinessentityaddressRowUnsaved(pa.person.businessentityid, address.addressid, addresstypeId)\n          businessentityAddressRepo.insert(newRow)\n      }\n    }.toList\n  }\n}\n"})}),"\n",(0,n.jsx)(s.p,{children:"Here is example usage:"}),"\n",(0,n.jsxs)(s.p,{children:["Note that we can easily create a deep dependency graph with random data due to ",(0,n.jsx)(s.a,{href:"/typo/docs/other-features/testing-with-random-values",children:"testInsert"}),"."]}),"\n",(0,n.jsx)(s.pre,{children:(0,n.jsx)(s.code,{className:"language-scala",children:'import adventureworks.{TestInsert, withConnection}\nimport adventureworks.userdefined.FirstName\nimport scala.util.Random\n\n// set a fixed seed to get consistent values\nval testInsert = new TestInsert(new Random(1))\n\nval businessentityRow = testInsert.personBusinessentity()\nval personRow = testInsert.personPerson(businessentityRow.businessentityid, FirstName("name"), persontype = "SC")\nval countryregionRow = testInsert.personCountryregion(CountryregionId("NOR"))\nval salesterritoryRow = testInsert.salesSalesterritory(countryregionRow.countryregioncode)\nval stateprovinceRow = testInsert.personStateprovince(countryregionRow.countryregioncode, salesterritoryRow.territoryid)\nval addressRow1 = testInsert.personAddress(stateprovinceRow.stateprovinceid)\nval addressRow2 = testInsert.personAddress(stateprovinceRow.stateprovinceid)\nval addressRow3 = testInsert.personAddress(stateprovinceRow.stateprovinceid)\n\nval repo = new PersonWithAddressesRepo(\npersonRepo = PersonRepoImpl,\nbusinessentityAddressRepo = BusinessentityaddressRepoImpl,\naddresstypeRepo = AddresstypeRepoImpl,\naddressRepo = AddressRepoImpl\n)\n'})}),"\n",(0,n.jsx)(s.pre,{children:(0,n.jsx)(s.code,{className:"language-scala",children:'repo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1, Name("OFFICE") -> addressRow2)))\n// res1: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 199),\n//     addressid = AddressId(value = 196),\n//     addresstypeid = AddresstypeId(value = 196),\n//     rowguid = aaad727c-4d7b-11ee-a9e2-0242ac1f0002,\n//     modifieddate = TypoLocalDateTime(value = 2023-09-07T14:40:03.132204)\n//   ),\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 199),\n//     addressid = AddressId(value = 197),\n//     addresstypeid = AddresstypeId(value = 197),\n//     rowguid = aab0628e-4d7b-11ee-a9e2-0242ac1f0002,\n//     modifieddate = TypoLocalDateTime(value = 2023-09-07T14:40:03.132204)\n//   )\n// )\n\n// check that it\'s idempotent\nrepo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1, Name("OFFICE") -> addressRow2)))\n// res2: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 199),\n//     addressid = AddressId(value = 196),\n//     addresstypeid = AddresstypeId(value = 196),\n//     rowguid = aaad727c-4d7b-11ee-a9e2-0242ac1f0002,\n//     modifieddate = TypoLocalDateTime(value = 2023-09-07T14:40:03.132204)\n//   ),\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 199),\n//     addressid = AddressId(value = 197),\n//     addresstypeid = AddresstypeId(value = 197),\n//     rowguid = aab0628e-4d7b-11ee-a9e2-0242ac1f0002,\n//     modifieddate = TypoLocalDateTime(value = 2023-09-07T14:40:03.132204)\n//   )\n// )\n\n// remove one\nrepo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1)))\n// res3: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 199),\n//     addressid = AddressId(value = 196),\n//     addresstypeid = AddresstypeId(value = 196),\n//     rowguid = aaad727c-4d7b-11ee-a9e2-0242ac1f0002,\n//     modifieddate = TypoLocalDateTime(value = 2023-09-07T14:40:03.132204)\n//   )\n// )\n\n// add one\nrepo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1, Name("VACATION") -> addressRow3)))\n// res4: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 199),\n//     addressid = AddressId(value = 196),\n//     addresstypeid = AddresstypeId(value = 196),\n//     rowguid = aaad727c-4d7b-11ee-a9e2-0242ac1f0002,\n//     modifieddate = TypoLocalDateTime(value = 2023-09-07T14:40:03.132204)\n//   ),\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 199),\n//     addressid = AddressId(value = 198),\n//     addresstypeid = AddresstypeId(value = 198),\n//     rowguid = aab7a436-4d7b-11ee-a9e2-0242ac1f0002,\n//     modifieddate = TypoLocalDateTime(value = 2023-09-07T14:40:03.132204)\n//   )\n// )\n'})}),"\n",(0,n.jsx)(s.h2,{id:"isnt-this-a-service-at-this-point",children:"Isn't this a service at this point?"}),"\n",(0,n.jsxs)(s.p,{children:["Maybe! You likely shouldn't use the generated ",(0,n.jsx)(s.code,{children:"Row"})," types at the service level, and there should likely be a transaction boundary.\nYou get to decide that, however."]})]})}function c(e={}){const{wrapper:s}={...(0,d.R)(),...e.components};return s?(0,n.jsx)(s,{...e,children:(0,n.jsx)(l,{...e})}):l(e)}},8453:(e,s,t)=>{t.d(s,{R:()=>a,x:()=>o});var n=t(6540);const d={},r=n.createContext(d);function a(e){const s=n.useContext(r);return n.useMemo((function(){return"function"==typeof e?e(s):{...s,...e}}),[s,e])}function o(e){let s;return s=e.disableParentContext?"function"==typeof e.components?e.components(d):e.components||d:a(e.components),n.createElement(r.Provider,{value:s},e.children)}}}]);