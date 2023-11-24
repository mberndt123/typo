"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[4863],{3905:(e,s,t)=>{t.d(s,{Zo:()=>l,kt:()=>m});var n=t(7294);function r(e,s,t){return s in e?Object.defineProperty(e,s,{value:t,enumerable:!0,configurable:!0,writable:!0}):e[s]=t,e}function a(e,s){var t=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);s&&(n=n.filter((function(s){return Object.getOwnPropertyDescriptor(e,s).enumerable}))),t.push.apply(t,n)}return t}function d(e){for(var s=1;s<arguments.length;s++){var t=null!=arguments[s]?arguments[s]:{};s%2?a(Object(t),!0).forEach((function(s){r(e,s,t[s])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(t)):a(Object(t)).forEach((function(s){Object.defineProperty(e,s,Object.getOwnPropertyDescriptor(t,s))}))}return e}function o(e,s){if(null==e)return{};var t,n,r=function(e,s){if(null==e)return{};var t,n,r={},a=Object.keys(e);for(n=0;n<a.length;n++)t=a[n],s.indexOf(t)>=0||(r[t]=e[t]);return r}(e,s);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(n=0;n<a.length;n++)t=a[n],s.indexOf(t)>=0||Object.prototype.propertyIsEnumerable.call(e,t)&&(r[t]=e[t])}return r}var i=n.createContext({}),p=function(e){var s=n.useContext(i),t=s;return e&&(t="function"==typeof e?e(s):d(d({},s),e)),t},l=function(e){var s=p(e.components);return n.createElement(i.Provider,{value:s},e.children)},u="mdxType",y={inlineCode:"code",wrapper:function(e){var s=e.children;return n.createElement(n.Fragment,{},s)}},c=n.forwardRef((function(e,s){var t=e.components,r=e.mdxType,a=e.originalType,i=e.parentName,l=o(e,["components","mdxType","originalType","parentName"]),u=p(t),c=r,m=u["".concat(i,".").concat(c)]||u[c]||y[c]||a;return t?n.createElement(m,d(d({ref:s},l),{},{components:t})):n.createElement(m,d({ref:s},l))}));function m(e,s){var t=arguments,r=s&&s.mdxType;if("string"==typeof e||r){var a=t.length,d=new Array(a);d[0]=c;var o={};for(var i in s)hasOwnProperty.call(s,i)&&(o[i]=s[i]);o.originalType=e,o[u]="string"==typeof e?e:r,d[1]=o;for(var p=2;p<a;p++)d[p]=t[p];return n.createElement.apply(null,d)}return n.createElement.apply(null,t)}c.displayName="MDXCreateElement"},6422:(e,s,t)=>{t.r(s),t.d(s,{assets:()=>i,contentTitle:()=>d,default:()=>y,frontMatter:()=>a,metadata:()=>o,toc:()=>p});var n=t(7462),r=(t(7294),t(3905));const a={title:"Patterns: The multi-repo"},d=void 0,o={unversionedId:"patterns",id:"patterns",title:"Patterns: The multi-repo",description:"There has been some comments about how the generated repositories do not match with peoples preferences of what a repository should be.",source:"@site/docs/patterns.md",sourceDirName:".",slug:"/patterns",permalink:"/typo/docs/patterns",draft:!1,tags:[],version:"current",frontMatter:{title:"Patterns: The multi-repo"}},i={},p=[{value:"So you write code yourself",id:"so-you-write-code-yourself",level:3},{value:"Example",id:"example",level:3},{value:"Isn&#39;t this a service at this point?",id:"isnt-this-a-service-at-this-point",level:2}],l={toc:p},u="wrapper";function y(e){let{components:s,...t}=e;return(0,r.kt)(u,(0,n.Z)({},l,t,{components:s,mdxType:"MDXLayout"}),(0,r.kt)("p",null,"There has been some comments about how ",(0,r.kt)("a",{parentName:"p",href:"/typo/docs/what-is/relations"},"the generated repositories")," do not match with peoples preferences of what a repository should be.\nFor instance you may prefer that your repositories coordinate multiple tables."),(0,r.kt)("p",null,"And that's more than fair - Often you need to coordinate multiple tables in a transaction.\nThe only snag is that typo does not have the knowledge to write that code for you."),(0,r.kt)("h3",{id:"so-you-write-code-yourself"},"So you write code yourself"),(0,r.kt)("p",null,"Enter the multi-repo pattern! "),(0,r.kt)("p",null,"Here you take low-level typo repositories as parameters, and you write the higher-level flow yourself. "),(0,r.kt)("p",null,"You still get huge benefits from using typo in this case:"),(0,r.kt)("ul",null,(0,r.kt)("li",{parentName:"ul"},"All of this is typesafe"),(0,r.kt)("li",{parentName:"ul"},"You get perfect auto-complete from your IDE"),(0,r.kt)("li",{parentName:"ul"},"Strongly typed ",(0,r.kt)("a",{parentName:"li",href:"/typo/docs/type-safety/id-types"},"Id types")," and ",(0,r.kt)("a",{parentName:"li",href:"/typo/docs/type-safety/type-flow"},"type flow")," ensure that you have to follow foreign keys correctly  "),(0,r.kt)("li",{parentName:"ul"},"It's fairly readable. "),(0,r.kt)("li",{parentName:"ul"},"It's testable! You can even wire in ",(0,r.kt)("a",{parentName:"li",href:"/typo/docs/other-features/testing-with-stubs"},"stub repositories")," and test it all without a running database.")),(0,r.kt)("p",null,"Just have a look at the example and think how long it would take you to write this without typo."),(0,r.kt)("p",null,"With typo, this example worked ",(0,r.kt)("em",{parentName:"p"},"the first time it was ran"),"."),(0,r.kt)("h3",{id:"example"},"Example"),(0,r.kt)("p",null,"The example repo below exposes one method, which coordinates updates to four tables. "),(0,r.kt)("p",null,"The details of what is done is probably not too important, but I tried to comment it anyway."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-scala"},"import adventureworks.person.address.*\nimport adventureworks.person.addresstype.*\nimport adventureworks.person.businessentityaddress.*\nimport adventureworks.person.countryregion.CountryregionId\nimport adventureworks.person.person.*\nimport adventureworks.public.Name\nimport java.sql.Connection\n\ncase class PersonWithAddresses(person: PersonRow, addresses: Map[Name, AddressRow])\n\nclass PersonWithAddressesRepo(\n   personRepo: PersonRepo,\n   businessentityAddressRepo: BusinessentityaddressRepo,\n   addresstypeRepo: AddresstypeRepo,\n   addressRepo: AddressRepo\n ) {\n\n  /* A person can have a bunch of addresses registered,\n   * and they each have an address type (BILLING, HOME, etc).\n   *\n   * This method syncs `PersonWithAddresses#addresses` to postgres,\n   * so that old attached addresses are removed,\n   * and the given addresses are attached with the chosen type\n   */\n  def syncAddresses(pa: PersonWithAddresses)(implicit c: Connection): List[BusinessentityaddressRow] = {\n    // update person\n    personRepo.update(pa.person)\n    // update stored addresses\n    pa.addresses.toList.foreach { case (_, address) => addressRepo.update(address) }\n\n    // addresses are stored in `PersonWithAddress` by a `Name` which means what type of address it is.\n    // this address type is stored in addresstypeRepo.\n    // In order for foreign keys to align, we need to translate from names to ids, and create rows as necessary\n    val oldStoredAddressTypes: Map[Name, AddresstypeId] =\n    addresstypeRepo.select\n      .where(r => r.name in pa.addresses.keys.toArray)\n      .toList\n      .map(x => (x.name, x.addresstypeid))\n      .toMap\n\n    val currentAddressesByType: Map[AddresstypeId, AddressRow] =\n      pa.addresses.map { case (addressTypeName, wanted) =>\n        oldStoredAddressTypes.get(addressTypeName) match {\n          case Some(addresstypeId) => (addresstypeId, wanted)\n          case None =>\n            val inserted = addresstypeRepo.insert(AddresstypeRowUnsaved(name = addressTypeName))\n            (inserted.addresstypeid, wanted)\n        }\n      }\n\n    // discover existing addresses attached to person\n    val oldAttachedAddresses: Map[(AddressId, AddresstypeId), BusinessentityaddressRow] =\n      businessentityAddressRepo.select\n        .where(x => x.businessentityid === pa.person.businessentityid)\n        .toList\n        .map(x => ((x.addressid, x.addresstypeid), x))\n        .toMap\n\n    // unattach old attached addresses\n    oldAttachedAddresses.foreach { case (_, ba) =>\n      currentAddressesByType.get(ba.addresstypeid) match {\n        case Some(address) if address.addressid == ba.addressid =>\n        case _ =>\n          businessentityAddressRepo.delete(ba.compositeId)\n      }\n    }\n    // attach new addresses\n    currentAddressesByType.map { case (addresstypeId, address) =>\n      oldAttachedAddresses.get((address.addressid, addresstypeId)) match {\n        case Some(bea) => bea\n        case None =>\n          val newRow = BusinessentityaddressRowUnsaved(pa.person.businessentityid, address.addressid, addresstypeId)\n          businessentityAddressRepo.insert(newRow)\n      }\n    }.toList\n  }\n}\n")),(0,r.kt)("p",null,"Here is example usage:"),(0,r.kt)("p",null,"Note that we can easily create a deep dependency graph with random data due to ",(0,r.kt)("a",{parentName:"p",href:"/typo/docs/other-features/testing-with-random-values"},"testInsert"),"."),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-scala"},'import adventureworks.{testInsert, withConnection}\nimport adventureworks.userdefined.FirstName\nimport scala.util.Random\n\n// set a fixed seed to get consistent values\nval testInsert = new testInsert(new Random(1))\n\nval businessentityRow = testInsert.personBusinessentity()\nval personRow = testInsert.personPerson(businessentityRow.businessentityid, FirstName("name"), persontype = "SC")\nval countryregionRow = testInsert.personCountryregion(CountryregionId("NOR"))\nval salesterritoryRow = testInsert.salesSalesterritory(countryregionRow.countryregioncode)\nval stateprovinceRow = testInsert.personStateprovince(countryregionRow.countryregioncode, salesterritoryRow.territoryid)\nval addressRow1 = testInsert.personAddress(stateprovinceRow.stateprovinceid)\nval addressRow2 = testInsert.personAddress(stateprovinceRow.stateprovinceid)\nval addressRow3 = testInsert.personAddress(stateprovinceRow.stateprovinceid)\n\nval repo = new PersonWithAddressesRepo(\npersonRepo = PersonRepoImpl,\nbusinessentityAddressRepo = BusinessentityaddressRepoImpl,\naddresstypeRepo = AddresstypeRepoImpl,\naddressRepo = AddressRepoImpl\n)\n')),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-scala"},'repo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1, Name("OFFICE") -> addressRow2)))\n// res1: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 308),\n//     addressid = AddressId(value = 305),\n//     addresstypeid = AddresstypeId(value = 296),\n//     rowguid = TypoUUID(value = 4e443e92-4e8b-11ee-8adc-0242ac1f0002),\n//     modifieddate = TypoLocalDateTime(value = 2023-09-08T23:04:31.243979)\n//   ),\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 308),\n//     addressid = AddressId(value = 306),\n//     addresstypeid = AddresstypeId(value = 297),\n//     rowguid = TypoUUID(value = 4e4691e2-4e8b-11ee-8adc-0242ac1f0002),\n//     modifieddate = TypoLocalDateTime(value = 2023-09-08T23:04:31.243979)\n//   )\n// )\n\n// check that it\'s idempotent\nrepo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1, Name("OFFICE") -> addressRow2)))\n// res2: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 308),\n//     addressid = AddressId(value = 305),\n//     addresstypeid = AddresstypeId(value = 296),\n//     rowguid = TypoUUID(value = 4e443e92-4e8b-11ee-8adc-0242ac1f0002),\n//     modifieddate = TypoLocalDateTime(value = 2023-09-08T23:04:31.243979)\n//   ),\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 308),\n//     addressid = AddressId(value = 306),\n//     addresstypeid = AddresstypeId(value = 297),\n//     rowguid = TypoUUID(value = 4e4691e2-4e8b-11ee-8adc-0242ac1f0002),\n//     modifieddate = TypoLocalDateTime(value = 2023-09-08T23:04:31.243979)\n//   )\n// )\n\n// remove one\nrepo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1)))\n// res3: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 308),\n//     addressid = AddressId(value = 305),\n//     addresstypeid = AddresstypeId(value = 296),\n//     rowguid = TypoUUID(value = 4e443e92-4e8b-11ee-8adc-0242ac1f0002),\n//     modifieddate = TypoLocalDateTime(value = 2023-09-08T23:04:31.243979)\n//   )\n// )\n\n// add one\nrepo.syncAddresses(PersonWithAddresses(personRow, Map(Name("HOME") -> addressRow1, Name("VACATION") -> addressRow3)))\n// res4: List[BusinessentityaddressRow] = List(\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 308),\n//     addressid = AddressId(value = 305),\n//     addresstypeid = AddresstypeId(value = 296),\n//     rowguid = TypoUUID(value = 4e443e92-4e8b-11ee-8adc-0242ac1f0002),\n//     modifieddate = TypoLocalDateTime(value = 2023-09-08T23:04:31.243979)\n//   ),\n//   BusinessentityaddressRow(\n//     businessentityid = BusinessentityId(value = 308),\n//     addressid = AddressId(value = 307),\n//     addresstypeid = AddresstypeId(value = 298),\n//     rowguid = TypoUUID(value = 4e4c21de-4e8b-11ee-8adc-0242ac1f0002),\n//     modifieddate = TypoLocalDateTime(value = 2023-09-08T23:04:31.243979)\n//   )\n// )\n')),(0,r.kt)("h2",{id:"isnt-this-a-service-at-this-point"},"Isn't this a service at this point?"),(0,r.kt)("p",null,"Maybe! You likely shouldn't use the generated ",(0,r.kt)("inlineCode",{parentName:"p"},"Row")," types at the service level, and there should likely be a transaction boundary.\nYou get to decide that, however."))}y.isMDXComponent=!0}}]);