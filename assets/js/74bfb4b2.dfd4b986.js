"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[9733],{9012:(e,a,t)=>{t.d(a,{Z:()=>n});var i=t(7294),s=t(2949);const n=e=>{let{children:a}=e;const{isDarkTheme:t}=(0,s.I)(),n={backgroundColor:t?"#333":"#f0f0f0",color:t?"#fff":"#000",padding:"20px",borderRadius:"8px",display:"flex",alignItems:"center",justifyContent:"center"};return i.createElement("div",{style:n},i.createElement("svg",{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none",stroke:t?"#fff":"currentColor",strokeWidth:"2",strokeLinecap:"round",strokeLinejoin:"round",style:{marginRight:"10px"}},i.createElement("path",{d:"M7 20v1a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1v-1"}),i.createElement("path",{d:"M9 20h6"}),i.createElement("path",{d:"M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 16h-2v-2h2v2zm0-4h-2V8h2v6z"})),i.createElement("span",null,a,"\xa0"))}},3728:(e,a,t)=>{t.d(a,{Z:()=>n});var i=t(7294),s=t(1809);const n=e=>{let{id:a,children:t}=e;const[n,o]=(0,i.useState)(null),[l,d]=(0,i.useState)("min");(0,i.useEffect)((()=>{const e=t.trim().split("\n").map((e=>e.split(","))),i=[...new Set(e.slice(1).map((e=>e[0])))],d=[...new Set(e.slice(1).map((e=>e[1])))],r=[...new Set(e.slice(1).map((e=>e[2])))],m=(e,a)=>`hsl(${"scala213"===e?200:"scala3"===e?40:"scala212"===e?120:0}, 70%, ${"true"===a?70:50}%)`;return(t=>{n&&n.destroy();const l={labels:i,datasets:d.flatMap((a=>r.map((s=>{const n=i.map((i=>{const n=e.find((e=>e[0]===i&&e[1]===a&&e[2]===s));return n?"avg"===t?parseFloat(n[3]):parseFloat(n[4]):0}));return{label:1===r.length?a:`${a} - Inlined: ${s}`,backgroundColor:m(a,s),data:n}})))).flat()},c=document.getElementById(a).getContext("2d"),u=new s.ZP(c,{type:"bar",data:l,options:{responsive:!0,maintainAspectRatio:!1,legend:{position:"top"},title:{display:!0,text:"avg"===t?"Average Compile Times (Seconds)":"Minimum Compile Times (Seconds)"},scales:{y:{stacked:!1,ticks:{beginAtZero:!0},title:{display:!0,text:"Milliseconds"}}}}});o(u)})(l),()=>{n&&n.destroy()}}),[l]);return i.createElement("div",{style:{width:"80%",margin:"auto"}},i.createElement("select",{id:"toggleView",onChange:e=>{d(e.target.value)},value:l},i.createElement("option",{value:"min"},"Minimum Compile Time"),i.createElement("option",{value:"avg"},"Average Compile Time")),i.createElement("div",{className:"chart-container"},i.createElement("canvas",{id:a,width:"800",height:"400"})))}},4210:(e,a,t)=>{t.r(a),t.d(a,{assets:()=>b,contentTitle:()=>f,default:()=>k,frontMatter:()=>h,metadata:()=>y,toc:()=>g});var i=t(7462),s=(t(7294),t(3905)),n=t(3728),o=t(9012),l=t(614);const d="/**\n * File has been automatically generated by `typo`.\n *\n * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.\n */\npackage adventureworks\npackage person\npackage emailaddress\n\nimport adventureworks.person.businessentity.BusinessentityId\n\n/** Type for the composite primary key of table `person.emailaddress` */\ncase class EmailaddressId(businessentityid: BusinessentityId, emailaddressid: Int)\n\nobject EmailaddressId {\n  implicit lazy val ordering: Ordering[EmailaddressId] = Ordering.by(x => (x.businessentityid, x.emailaddressid))\n}",r="/**\n * File has been automatically generated by `typo`.\n *\n * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.\n */\npackage adventureworks\npackage person\npackage emailaddress\n\nimport doobie.free.connection.ConnectionIO\nimport fs2.Stream\nimport typo.dsl.DeleteBuilder\nimport typo.dsl.SelectBuilder\nimport typo.dsl.UpdateBuilder\n\ntrait EmailaddressRepo {\n  def delete(compositeId: EmailaddressId): ConnectionIO[Boolean]\n  def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow]\n  def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow]\n  def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow]\n  def select: SelectBuilder[EmailaddressFields, EmailaddressRow]\n  def selectAll: Stream[ConnectionIO, EmailaddressRow]\n  def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]]\n  def update(row: EmailaddressRow): ConnectionIO[Boolean]\n  def update: UpdateBuilder[EmailaddressFields, EmailaddressRow]\n  def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow]\n}\n",m='/**\n * File has been automatically generated by `typo`.\n *\n * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.\n */\npackage adventureworks\npackage person\npackage emailaddress\n\nimport adventureworks.customtypes.Defaulted\nimport adventureworks.customtypes.TypoLocalDateTime\nimport adventureworks.customtypes.TypoUUID\nimport doobie.free.connection.ConnectionIO\nimport doobie.syntax.string.toSqlInterpolator\nimport doobie.util.fragment.Fragment\nimport fs2.Stream\nimport typo.dsl.DeleteBuilder\nimport typo.dsl.SelectBuilder\nimport typo.dsl.SelectBuilderSql\nimport typo.dsl.UpdateBuilder\n\nclass EmailaddressRepoImpl extends EmailaddressRepo {\n  override def delete(compositeId: EmailaddressId): ConnectionIO[Boolean] = {\n    sql"""delete from person.emailaddress where "businessentityid" = ${compositeId.businessentityid} AND "emailaddressid" = ${compositeId.emailaddressid}""".update.run.map(_ > 0)\n  }\n  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {\n    DeleteBuilder("person.emailaddress", EmailaddressFields)\n  }\n  override def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {\n    sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")\n          values (${unsaved.businessentityid}::int4, ${unsaved.emailaddressid}::int4, ${unsaved.emailaddress}, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)\n          returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text\n       """.query(EmailaddressRow.read).unique\n  }\n  override def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow] = {\n    val fs = List(\n      Some((Fragment.const(s""""businessentityid""""), fr"${unsaved.businessentityid}::int4")),\n      Some((Fragment.const(s""""emailaddress""""), fr"${unsaved.emailaddress}")),\n      unsaved.emailaddressid match {\n        case Defaulted.UseDefault => None\n        case Defaulted.Provided(value) => Some((Fragment.const(s""""emailaddressid""""), fr"${value: Int}::int4"))\n      },\n      unsaved.rowguid match {\n        case Defaulted.UseDefault => None\n        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${value: TypoUUID}::uuid"))\n      },\n      unsaved.modifieddate match {\n        case Defaulted.UseDefault => None\n        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${value: TypoLocalDateTime}::timestamp"))\n      }\n    ).flatten\n    \n    val q = if (fs.isEmpty) {\n      sql"""insert into person.emailaddress default values\n            returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text\n         """\n    } else {\n      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")\n      sql"""insert into person.emailaddress(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})\n            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})\n            returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text\n         """\n    }\n    q.query(EmailaddressRow.read).unique\n    \n  }\n  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {\n    SelectBuilderSql("person.emailaddress", EmailaddressFields, EmailaddressRow.read)\n  }\n  override def selectAll: Stream[ConnectionIO, EmailaddressRow] = {\n    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from person.emailaddress""".query(EmailaddressRow.read).stream\n  }\n  override def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]] = {\n    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from person.emailaddress where "businessentityid" = ${compositeId.businessentityid} AND "emailaddressid" = ${compositeId.emailaddressid}""".query(EmailaddressRow.read).option\n  }\n  override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {\n    val compositeId = row.compositeId\n    sql"""update person.emailaddress\n          set "emailaddress" = ${row.emailaddress},\n              "rowguid" = ${row.rowguid}::uuid,\n              "modifieddate" = ${row.modifieddate}::timestamp\n          where "businessentityid" = ${compositeId.businessentityid} AND "emailaddressid" = ${compositeId.emailaddressid}"""\n      .update\n      .run\n      .map(_ > 0)\n  }\n  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {\n    UpdateBuilder("person.emailaddress", EmailaddressFields, EmailaddressRow.read)\n  }\n  override def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {\n    sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")\n          values (\n            ${unsaved.businessentityid}::int4,\n            ${unsaved.emailaddressid}::int4,\n            ${unsaved.emailaddress},\n            ${unsaved.rowguid}::uuid,\n            ${unsaved.modifieddate}::timestamp\n          )\n          on conflict ("businessentityid", "emailaddressid")\n          do update set\n            "emailaddress" = EXCLUDED."emailaddress",\n            "rowguid" = EXCLUDED."rowguid",\n            "modifieddate" = EXCLUDED."modifieddate"\n          returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text\n       """.query(EmailaddressRow.read).unique\n  }\n}\n',c='/**\n * File has been automatically generated by `typo`.\n *\n * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.\n */\npackage adventureworks\npackage person\npackage emailaddress\n\nimport doobie.free.connection.ConnectionIO\nimport doobie.free.connection.delay\nimport fs2.Stream\nimport scala.annotation.nowarn\nimport typo.dsl.DeleteBuilder\nimport typo.dsl.DeleteBuilder.DeleteBuilderMock\nimport typo.dsl.DeleteParams\nimport typo.dsl.SelectBuilder\nimport typo.dsl.SelectBuilderMock\nimport typo.dsl.SelectParams\nimport typo.dsl.UpdateBuilder\nimport typo.dsl.UpdateBuilder.UpdateBuilderMock\nimport typo.dsl.UpdateParams\n\nclass EmailaddressRepoMock(toRow: Function1[EmailaddressRowUnsaved, EmailaddressRow],\n                           map: scala.collection.mutable.Map[EmailaddressId, EmailaddressRow] = scala.collection.mutable.Map.empty) extends EmailaddressRepo {\n  override def delete(compositeId: EmailaddressId): ConnectionIO[Boolean] = {\n    delay(map.remove(compositeId).isDefined)\n  }\n  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {\n    DeleteBuilderMock(DeleteParams.empty, EmailaddressFields, map)\n  }\n  override def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {\n    delay {\n      val _ = if (map.contains(unsaved.compositeId))\n        sys.error(s"id ${unsaved.compositeId} already exists")\n      else\n        map.put(unsaved.compositeId, unsaved)\n    \n      unsaved\n    }\n  }\n  override def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow] = {\n    insert(toRow(unsaved))\n  }\n  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {\n    SelectBuilderMock(EmailaddressFields, delay(map.values.toList), SelectParams.empty)\n  }\n  override def selectAll: Stream[ConnectionIO, EmailaddressRow] = {\n    Stream.emits(map.values.toList)\n  }\n  override def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]] = {\n    delay(map.get(compositeId))\n  }\n  override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {\n    delay {\n      map.get(row.compositeId) match {\n        case Some(`row`) => false\n        case Some(_) =>\n          map.put(row.compositeId, row): @nowarn\n          true\n        case None => false\n      }\n    }\n  }\n  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {\n    UpdateBuilderMock(UpdateParams.empty, EmailaddressFields, map)\n  }\n  override def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {\n    delay {\n      map.put(unsaved.compositeId, unsaved): @nowarn\n      unsaved\n    }\n  }\n}\n',u="/**\n * File has been automatically generated by `typo`.\n *\n * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.\n */\npackage adventureworks\npackage person\npackage emailaddress\n\nimport adventureworks.customtypes.TypoLocalDateTime\nimport adventureworks.customtypes.TypoUUID\nimport adventureworks.person.businessentity.BusinessentityId\nimport doobie.enumerated.Nullability\nimport doobie.util.Get\nimport doobie.util.Read\nimport java.sql.ResultSet\n\ncase class EmailaddressRow(\n  /** Primary key. Person associated with this email address.  Foreign key to Person.BusinessEntityID\n      Points to [[person.PersonRow.businessentityid]] */\n  businessentityid: BusinessentityId,\n  /** Primary key. ID of this email address. */\n  emailaddressid: Int,\n  /** E-mail address for the person. */\n  emailaddress: Option[/* max 50 chars */ String],\n  rowguid: TypoUUID,\n  modifieddate: TypoLocalDateTime\n){\n   val compositeId: EmailaddressId = EmailaddressId(businessentityid, emailaddressid)\n }\n\nobject EmailaddressRow {\n  implicit lazy val read: Read[EmailaddressRow] =\n    new Read[EmailaddressRow](\n      gets = List(\n        (Get[BusinessentityId], Nullability.NoNulls),\n        (Get[Int], Nullability.NoNulls),\n        (Get[/* max 50 chars */ String], Nullability.Nullable),\n        (Get[TypoUUID], Nullability.NoNulls),\n        (Get[TypoLocalDateTime], Nullability.NoNulls)\n      ),\n      unsafeGet = (rs: ResultSet, i: Int) => EmailaddressRow(\n        businessentityid = Get[BusinessentityId].unsafeGetNonNullable(rs, i + 0),\n        emailaddressid = Get[Int].unsafeGetNonNullable(rs, i + 1),\n        emailaddress = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 2),\n        rowguid = Get[TypoUUID].unsafeGetNonNullable(rs, i + 3),\n        modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 4)\n      )\n    )\n  \n}\n",p="/**\n * File has been automatically generated by `typo`.\n *\n * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.\n */\npackage adventureworks\npackage person\npackage emailaddress\n\nimport adventureworks.customtypes.Defaulted\nimport adventureworks.customtypes.TypoLocalDateTime\nimport adventureworks.customtypes.TypoUUID\nimport adventureworks.person.businessentity.BusinessentityId\n\n/** This class corresponds to a row in table `person.emailaddress` which has not been persisted yet */\ncase class EmailaddressRowUnsaved(\n  /** Primary key. Person associated with this email address.  Foreign key to Person.BusinessEntityID\n    * Points to [[person.PersonRow.businessentityid]]\n    */\n  businessentityid: BusinessentityId,\n  /** E-mail address for the person. */\n  emailaddress: Option[/* max 50 chars */ String],\n  /** Default: nextval('person.emailaddress_emailaddressid_seq'::regclass)\n    * Primary key. ID of this email address.\n    */\n  emailaddressid: Defaulted[Int] = Defaulted.UseDefault,\n  /** Default: uuid_generate_v1() */\n  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,\n  /** Default: now() */\n  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault\n) {\n  def toRow(emailaddressidDefault: => Int, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): EmailaddressRow =\n    EmailaddressRow(\n      businessentityid = businessentityid,\n      emailaddress = emailaddress,\n      emailaddressid = emailaddressid match {\n                         case Defaulted.UseDefault => emailaddressidDefault\n                         case Defaulted.Provided(value) => value\n                       },\n      rowguid = rowguid match {\n                  case Defaulted.UseDefault => rowguidDefault\n                  case Defaulted.Provided(value) => value\n                },\n      modifieddate = modifieddate match {\n                       case Defaulted.UseDefault => modifieddateDefault\n                       case Defaulted.Provided(value) => value\n                     }\n    )\n}",h={title:"The compilation cost of implicits",description:"The compilation cost of implicits",slug:"the-cost-of-implicits",authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png"}],tags:["typo","scala","doobie","anorm","zio-jdbc","implicits","compile-times"],image:"https://i.imgur.com/mErPwqL.png",hide_table_of_contents:!1},f=void 0,y={permalink:"/typo/blog/the-cost-of-implicits",source:"@site/blog/2023-12-17-the-cost-of-implicits.mdx",title:"The compilation cost of implicits",description:"The compilation cost of implicits",date:"2023-12-17T00:00:00.000Z",formattedDate:"December 17, 2023",tags:[{label:"typo",permalink:"/typo/blog/tags/typo"},{label:"scala",permalink:"/typo/blog/tags/scala"},{label:"doobie",permalink:"/typo/blog/tags/doobie"},{label:"anorm",permalink:"/typo/blog/tags/anorm"},{label:"zio-jdbc",permalink:"/typo/blog/tags/zio-jdbc"},{label:"implicits",permalink:"/typo/blog/tags/implicits"},{label:"compile-times",permalink:"/typo/blog/tags/compile-times"}],readingTime:8.965,hasTruncateMarker:!0,authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png",imageURL:"https://github.com/oyvindberg.png"}],frontMatter:{title:"The compilation cost of implicits",description:"The compilation cost of implicits",slug:"the-cost-of-implicits",authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png",imageURL:"https://github.com/oyvindberg.png"}],tags:["typo","scala","doobie","anorm","zio-jdbc","implicits","compile-times"],image:"https://i.imgur.com/mErPwqL.png",hide_table_of_contents:!1},nextItem:{title:"Hello, ZIO",permalink:"/typo/blog/hello-zio"}},b={authorsImageUrls:[void 0]},g=[{value:"Background",id:"background",level:2},{value:"Typo output as a realistic compile speed test harness",id:"typo-output-as-a-realistic-compile-speed-test-harness",level:3},{value:"The generated code",id:"the-generated-code",level:2},{value:"Initial comparison of compile times",id:"initial-comparison-of-compile-times",level:2},{value:"So what&#39;s up with doobie with Scala 2.x?",id:"so-whats-up-with-doobie-with-scala-2x",level:2},{value:"Results without accidental automatic type class derivation for doobie",id:"results-without-accidental-automatic-type-class-derivation-for-doobie",level:2},{value:"Query interpolation woes.",id:"query-interpolation-woes",level:2},{value:"Observations",id:"observations",level:3},{value:"Great! So what is going on with doobie then?",id:"great-so-what-is-going-on-with-doobie-then",level:3},{value:"Future work on benchmark",id:"future-work-on-benchmark",level:2},{value:"Avoiding anonymous classes",id:"avoiding-anonymous-classes",level:3},{value:"Avoiding automatic derivation of product type class instances",id:"avoiding-automatic-derivation-of-product-type-class-instances",level:3},{value:"Avoiding type aliases",id:"avoiding-type-aliases",level:3},{value:"Final results and limitations",id:"final-results-and-limitations",level:2},{value:"JSON libraries",id:"json-libraries",level:3},{value:"Benchmark limitations",id:"benchmark-limitations",level:3},{value:"Final graph",id:"final-graph",level:3},{value:"Reproducing the results",id:"reproducing-the-results",level:2}],w={toc:g},v="wrapper";function k(e){let{components:a,...t}=e;return(0,s.kt)(v,(0,i.Z)({},w,t,{components:a,mdxType:"MDXLayout"}),(0,s.kt)("p",null,"I've accidentally built a compilation benchmark harness for Scala 2 and 3 which can measure the cost (in compilation time)\nfor having a codebase full of implicits which need to be resolved. Read on to see the results!"),(0,s.kt)("h2",{id:"background"},"Background"),(0,s.kt)("p",null,"Typo is a code-generation library for working with PostgreSQL in Scala.\nYou can read more in the ",(0,s.kt)("a",{parentName:"p",href:"https://oyvindberg.github.io/typo/docs/"},"introduction"),"."),(0,s.kt)("p",null,"It was built to replace huge swathes of boilerplate in applications,\nas well as to provide sorely needed type-safety to avoid having to test everything."),(0,s.kt)("p",null,"A crucial design goal was to fit into your system such as it is.\nThis means it generates code in the shared subset between Scala 2.12, 2.13 and 3.x,\nand for three different database access libraries."),(0,s.kt)("h3",{id:"typo-output-as-a-realistic-compile-speed-test-harness"},"Typo output as a realistic compile speed test harness"),(0,s.kt)("p",null,"In typical systems you may have a database layer, a business logic layer and a web layer,\nwith each of them occupying about a third of the code base."),(0,s.kt)("p",null,"The structure of the database and web layers are often very similar -\nbasically a bunch of case classes with type class instances and mapping code."),(0,s.kt)("p",null,"So let's say we take the database third of a typical system.\nWe'll use the fact that Typo can generate it in its entirety to build a compile speed benchmark,\nwhere we contrast different combinations of scala versions and database libraries."),(0,s.kt)("p",null,"I'll stress that the code it generates is basically the same code I've written again and again over the years,\nwhich should make the benchmark interesting since this is so close to real-world application code."),(0,s.kt)("p",null,"Let's see where it takes us!"),(0,s.kt)("h2",{id:"the-generated-code"},"The generated code"),(0,s.kt)("p",null,"If you're curious about the generated code,\nyou can expand this section to see some example code\nfor an email address table in the ",(0,s.kt)("a",{parentName:"p",href:"https://github.com/lorint/AdventureWorks-for-Postgres"},"AdventureWorks database"),",\ngenerated for doobie."),(0,s.kt)("details",null,(0,s.kt)("summary",null,"EmailaddressId.scala"),(0,s.kt)(l.Z,{language:"yaml",children:d,mdxType:"CodeBlock"})),(0,s.kt)("details",null,(0,s.kt)("summary",null,"EmailaddressRepo.scala"),(0,s.kt)(l.Z,{language:"yaml",children:r,mdxType:"CodeBlock"})),(0,s.kt)("details",null,(0,s.kt)("summary",null,"EmailaddressRepoImpl.scala"),(0,s.kt)(l.Z,{language:"yaml",children:m,mdxType:"CodeBlock"})),(0,s.kt)("details",null,(0,s.kt)("summary",null,"EmailaddressRepoMock.scala"),(0,s.kt)(l.Z,{language:"yaml",children:c,mdxType:"CodeBlock"})),(0,s.kt)("details",null,(0,s.kt)("summary",null,"EmailaddressRow.scala"),(0,s.kt)(l.Z,{language:"yaml",children:u,mdxType:"CodeBlock"})),(0,s.kt)("details",null,(0,s.kt)("summary",null,"EmailaddressRowUnsaved.scala"),(0,s.kt)(l.Z,{language:"yaml",children:p,mdxType:"CodeBlock"})),(0,s.kt)("p",null,"In total it's about this much:"),(0,s.kt)("pre",null,(0,s.kt)("code",{parentName:"pre"},"--------------------------------------------------------------------------------\n Language             Files        Lines        Blank      Comment         Code\n--------------------------------------------------------------------------------\n Scala                 1052        47011         3215         7436        36360\n--------------------------------------------------------------------------------\n")),(0,s.kt)("h2",{id:"initial-comparison-of-compile-times"},"Initial comparison of compile times"),(0,s.kt)("p",null,"Each benchmark is run three times, and in the graphs you can choose to see minimum or average compile times."),(0,s.kt)(n.Z,{id:"groupedBarChart1",mdxType:"ScalaCompileTimesChart"},"\nlibrary,scala version, average compile time, minimum compile time\nbaseline (only case class),scala212,false,2346,2289\nbaseline (only case class),scala213,false,4273,2944\nbaseline (only case class),scala3,false,4319,3050\nzio-jdbc,scala212,false,9484,8919\nzio-jdbc,scala213,false,10094,9058\nzio-jdbc,scala3,false,8954,7500\ndoobie,scala212,false,23452,22896\ndoobie,scala213,false,26086,25723\ndoobie,scala3,false,7862,7605\nanorm,scala212,false,9912,9378\nanorm,scala213,false,8900,8243\nanorm,scala3,false,7645,7179\n"),(0,s.kt)("p",null,'"baseline" is generating just case classes, no type class instances or repositories.'),(0,s.kt)("p",null,"We can make some observations right away:"),(0,s.kt)("ul",null,(0,s.kt)("li",{parentName:"ul"},"Scala 3 is ~always faster than Scala 2.12 and 2.13, only beaten by Scala 2.12 for baseline/just case classes"),(0,s.kt)("li",{parentName:"ul"},"doobie takes more than double the time to compile compared to anorm and zio-jdbc for Scala 2.x."),(0,s.kt)("li",{parentName:"ul"},"zio-jdbc and anorm have similar compile times across scala versions."),(0,s.kt)("li",{parentName:"ul"},'It\'s interesting to see the "cost" of adding type class instances and repositories')),(0,s.kt)("br",null),(0,s.kt)(o.Z,{mdxType:"KeyTakeaway"},"Scala 3 is consistently fast! Great job Scala team!"),(0,s.kt)("br",null),"The meat of this blog post will be to ",(0,s.kt)("b",null,"investigate why the code for doobie takes so long for scala 2.x"),".",(0,s.kt)("h2",{id:"so-whats-up-with-doobie-with-scala-2x"},"So what's up with doobie with Scala 2.x?"),(0,s.kt)("p",null,"The issue is composite. Let's take the biggest issue first - Automatic derivation of type class instances!"),(0,s.kt)("p",null,"Let's take something rather innocent:"),(0,s.kt)(l.Z,{language:"scala",mdxType:"CodeBlock"},'case class A(v1: String, v2: String, v3: String, v4: String, v5: String, v6: String, v7: String)\nsql"select 1,2,3,4,5,6,7".query[A].to[List]\nsql"select 1,2,3,4,5,6,7".query[A].to[List]\n'),(0,s.kt)("p",null,"This will compile and work, but an instance of ",(0,s.kt)("inlineCode",{parentName:"p"},"Read[A]")," will be derived for each of the two queries."),(0,s.kt)("p",null,"No problem, we're taught that we can cache the ",(0,s.kt)("inlineCode",{parentName:"p"},"Read[A]")," instance in the companion object."),(0,s.kt)(l.Z,{language:"scala",mdxType:"CodeBlock"},"\nobject A {\n  implicit val read: Read[A] = Read.derived\n}\n"),(0,s.kt)("p",null,"The surprise is that (as far as I understand) this does not actually work in this case.\nSince the automatic derivation is put in implicit scope in the companion object of the type class, it will be found before our cached instance.\nWe actually need to specify the instance explicitly:"),(0,s.kt)(l.Z,{language:"scala",mdxType:"CodeBlock"},'\nsql"select 1,2,3,4,5,6,7".query(A.read).to[List]\nsql"select 1,2,3,4,5,6,7".query(A.read).to[List]\n'),(0,s.kt)("p",null,"And boom! We've solved the problem. I implemented this in Typo, and will refer to this as doobie with and without fix in subsequent tables."),(0,s.kt)("h2",{id:"results-without-accidental-automatic-type-class-derivation-for-doobie"},"Results without accidental automatic type class derivation for doobie"),(0,s.kt)(n.Z,{id:"groupedBarChart2",mdxType:"ScalaCompileTimesChart"},"\nlibrary,scala version, inlined implicits, average compile time, minimum compile time\nbaseline (only case class),scala212,false,2346,2289\nbaseline (only case class),scala213,false,4273,2944\nbaseline (only case class),scala3,false,4319,3050\nzio-jdbc,scala212,false,9484,8919\nzio-jdbc,scala213,false,10094,9058\nzio-jdbc,scala3,false,8954,7500\ndoobie (with fix),scala212,false,15463,14826\ndoobie (with fix),scala213,false,16598,15467\ndoobie (with fix),scala3,false,7814,7369\ndoobie (without fix),scala212,false,23452,22896\ndoobie (without fix),scala213,false,26086,25723\ndoobie (without fix),scala3,false,7862,7605\nanorm,scala212,false,9912,9378\nanorm,scala213,false,8900,8243\nanorm,scala3,false,7645,7179\n"),(0,s.kt)("p",null,"Fantastic! We've cut the compile times almost in half for doobie for Scala 2.x - ten seconds is a lot of time if you suffer them often."),(0,s.kt)("br",null),(0,s.kt)(o.Z,{mdxType:"KeyTakeaway"},"Automatic typeclass derivation is a bad idea, but only for Scala 2.x!"),(0,s.kt)("br",null),(0,s.kt)("p",null,"But doobie is still a lot slower, so let's dig a bit further!"),(0,s.kt)("h2",{id:"query-interpolation-woes"},"Query interpolation woes."),(0,s.kt)("p",null,"So all of this extra time is spent in typer/resolving implicits. I wanted to see what could be done about it, and what causes it."),(0,s.kt)("p",null,"That's why I implemented an \"inline implicits\" mode for typo. I'll show a diff of what it does here, hopefully it'll be clear that it hardcodes some implicit resolution:"),(0,s.kt)(l.Z,{language:"diff",mdxType:"CodeBlock"},'\n+import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite\n+import doobie.util.Write\n+import doobie.util.meta.Meta\nclass EmailaddressRepoImpl extends EmailaddressRepo {\n   override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {\n     val compositeId = row.compositeId\n     sql"""update person.emailaddress\n-          set "emailaddress" = ${row.emailaddress},\n-              "rowguid" = ${row.rowguid}::uuid,\n-              "modifieddate" = ${row.modifieddate}::timestamp\n-          where "businessentityid" = ${compositeId.businessentityid} AND "emailaddressid" = ${compositeId.emailaddressid}"""\n+          set "emailaddress" = ${fromWrite(row.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))},\n+              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,\n+              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp\n+          where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "emailaddressid" = ${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}"""\n       .update\n       .run\n       .map(_ > 0)\n    }\n}'),(0,s.kt)("p",null,"Here are the results with and without inlined implicits:"),(0,s.kt)(n.Z,{id:"groupedBarChart3",mdxType:"ScalaCompileTimesChart"},"\nlibrary,scala version, inlined implicits, average compile time, minimum compile time\nbaseline (only case class),scala212,false,2346,2289\nbaseline (only case class),scala213,false,4273,2944\nbaseline (only case class),scala3,false,4319,3050\nzio-jdbc,scala212,false,9484,8919\nzio-jdbc,scala213,false,10094,9058\nzio-jdbc,scala3,false,8954,7500\nzio-jdbc,scala212,true,8524,8250\nzio-jdbc,scala213,true,7983,7761\nzio-jdbc,scala3,true,7095,6954\ndoobie (with fix),scala212,false,15463,14826\ndoobie (with fix),scala213,false,16598,15467\ndoobie (with fix),scala3,false,7814,7369\ndoobie (with fix),scala212,true,8465,8213\ndoobie (with fix),scala213,true,8560,8221\ndoobie (with fix),scala3,true,7760,7708\nanorm,scala212,false,9912,9378\nanorm,scala213,false,8900,8243\nanorm,scala3,false,7645,7179\nanorm,scala212,true,7803,7678\nanorm,scala213,true,7622,7593\nanorm,scala3,true,7050,6948\n"),(0,s.kt)("h3",{id:"observations"},"Observations"),(0,s.kt)("ul",null,(0,s.kt)("li",{parentName:"ul"},"This brings the compile time for doobie down to about the same as for anorm and zio-jdbc!"),(0,s.kt)("li",{parentName:"ul"},"We lose a handsome amount of compile time for zio-jdbc and anorm. But it's less clear that it's enough to be worth inlining manually.\nIt's a great conclusion actually, resolving implicits is fast as long as it's a straightforward process.")),(0,s.kt)("h3",{id:"great-so-what-is-going-on-with-doobie-then"},"Great! So what is going on with doobie then?"),(0,s.kt)("p",null,"I honestly haven't dug into all the details, but I have a guess which looks obvious.\nIn order to interpolate values into an SQL query, doobie needs to resolve a chain of implicits instead of just one."),(0,s.kt)("p",null,"In order to interpolate in the ",(0,s.kt)("inlineCode",{parentName:"p"},"emailaddress")," field which has type ",(0,s.kt)("inlineCode",{parentName:"p"},"Option[String]"),", this thing needs to be resolved:"),(0,s.kt)(l.Z,{language:"scala",mdxType:"CodeBlock"},"\ndoobie.syntax.SqlInterpolator.SingleFragment.fromWrite(unsaved.emailaddress)(\n  doobie.util.Write.fromPutOption(\n    doobie.util.Put.metaProjectionWrite(\n        doobie.util.meta.Meta.StringMeta\n      )\n  )\n)\n"),(0,s.kt)("p",null,"I'm sure this can cause the compiler to spend a lot of time looking around the companion objects of\n",(0,s.kt)("inlineCode",{parentName:"p"},"SingleFragment"),", ",(0,s.kt)("inlineCode",{parentName:"p"},"Write"),", ",(0,s.kt)("inlineCode",{parentName:"p"},"Put"),", and ",(0,s.kt)("inlineCode",{parentName:"p"},"Meta"),"."),(0,s.kt)("br",null),(0,s.kt)(o.Z,{mdxType:"KeyTakeaway"},"Make the compiler's job easy! It probably shouldn't need to go through so many layers at all."),(0,s.kt)("br",null),(0,s.kt)(o.Z,{mdxType:"KeyTakeaway"},"Scala 3 must have some caching of resolved implicits that Scala 2.x doesn't have."),(0,s.kt)("br",null),(0,s.kt)("h2",{id:"future-work-on-benchmark"},"Future work on benchmark"),(0,s.kt)("p",null,"Here are other things things I've done to speed up compilation of generated code, based on observations as I was developing.\nA future version of the benchmark could measure the effect of these changes as well. Reach out if you're interesting in contributing towards this."),(0,s.kt)("h3",{id:"avoiding-anonymous-classes"},"Avoiding anonymous classes"),(0,s.kt)("p",null,"Let's have a look at the code for ",(0,s.kt)("inlineCode",{parentName:"p"},"doobie.postgres.Text[A]"),", it's basically this:"),(0,s.kt)("pre",null,(0,s.kt)("code",{parentName:"pre",className:"language-scala"},"trait Text[A] { outer =>\n  def unsafeEncode(a: A, sb: StringBuilder): Unit\n}\nobject Text {\n  def instance[A](f: (A, StringBuilder) => Unit): Text[A] =\n    new Text[A] {\n      def unsafeEncode(a: A, sb: StringBuilder) = f(a, sb)\n    }\n}\n")),(0,s.kt)("p",null,"Using ",(0,s.kt)("inlineCode",{parentName:"p"},"Text.instance")," instead of ",(0,s.kt)("inlineCode",{parentName:"p"},"new Text[A]")," saves some compilation time because it generates less bytecode."),(0,s.kt)("p",null,"If you're a library author you should consider adding such a constructor method."),(0,s.kt)("h3",{id:"avoiding-automatic-derivation-of-product-type-class-instances"},"Avoiding automatic derivation of product type class instances"),(0,s.kt)("p",null,"Typo reimplements the derivation of type class instances for product types, so the benchmark cannot measure the cost of this so far.\nIf you expand ",(0,s.kt)("inlineCode",{parentName:"p"},"EmailaddressRow.scala")," above, you'll see that ",(0,s.kt)("inlineCode",{parentName:"p"},"Read[EmailaddressRow]")," is always implemented as ",(0,s.kt)("inlineCode",{parentName:"p"},"new Read(...)"),"."),(0,s.kt)("p",null,"It would be very interesting to measure the cost of deriving this automatically as well, we just need to patch ",(0,s.kt)("inlineCode",{parentName:"p"},"Typo")," to use ",(0,s.kt)("inlineCode",{parentName:"p"},"Read.derived")," instead of ",(0,s.kt)("inlineCode",{parentName:"p"},"new Read(...)"),"."),(0,s.kt)("h3",{id:"avoiding-type-aliases"},"Avoiding type aliases"),(0,s.kt)("p",null,"Doobie uses a pattern where ",(0,s.kt)("inlineCode",{parentName:"p"},"doobie.util.Read")," is exposed as ",(0,s.kt)("inlineCode",{parentName:"p"},"doobie.Read")," through a baroque mechanism:"),(0,s.kt)("pre",null,(0,s.kt)("code",{parentName:"pre",className:"language-scala"},"package object doobie\n  extends Aliases\n\ntrait Aliases extends Types with Modules\n\ntrait Types {\n  /** @group Type Aliases - Core */ type Read[A] = doobie.util.Read[A]\n}\n")),(0,s.kt)("p",null,"Typo always generates the fully qualified name ",(0,s.kt)("inlineCode",{parentName:"p"},"doobie.util.Read"),".\nIt would be interesting to measure if there is a cost associated with this as well."),(0,s.kt)("h2",{id:"final-results-and-limitations"},"Final results and limitations"),(0,s.kt)("h3",{id:"json-libraries"},"JSON libraries"),(0,s.kt)("p",null,'This last graph includes compilation time for three JSON libraries as well, basically just generating type class instances for them.\nI excluded them for the text above since there was nothing interesting to say about the results.\nYou can see how "inline implicits" mode also speeds up compilation of these JSON codecs.'),(0,s.kt)("h3",{id:"benchmark-limitations"},"Benchmark limitations"),(0,s.kt)("p",null,'I think part of this improvement from "inlined implicits" is due to the fact that the compiler is a bit warmer since it will just have finished compiling without inlined implicits.'),(0,s.kt)("p",null,'Note specifically that we get faster compiles for "baseline" with "inlined implicits" mode, although the generated code is the same.'),(0,s.kt)("p",null,"I didn't bother improving the benchmark more, because the interesting things mentioned above was very visible and consistent already."),(0,s.kt)("h3",{id:"final-graph"},"Final graph"),(0,s.kt)(n.Z,{id:"groupedBarChart4",mdxType:"ScalaCompileTimesChart"},"\nlibrary,scala version, inlined implicits, average compile time, minimum compile time\nbaseline (only case class),scala212,false,2346,2289\nbaseline (only case class),scala213,false,4273,2944\nbaseline (only case class),scala3,false,4319,3050\nbaseline (only case class),scala212,true,2245,2211\nbaseline (only case class),scala213,true,2519,2312\nbaseline (only case class),scala3,true,2347,2205\nzio-jdbc,scala212,false,9484,8919\nzio-jdbc,scala213,false,10094,9058\nzio-jdbc,scala3,false,8954,7500\nzio-jdbc,scala212,true,8524,8250\nzio-jdbc,scala213,true,7983,7761\nzio-jdbc,scala3,true,7095,6954\ndoobie (with fix),scala212,false,15463,14826\ndoobie (with fix),scala213,false,16598,15467\ndoobie (with fix),scala3,false,7814,7369\ndoobie (with fix),scala212,true,8465,8213\ndoobie (with fix),scala213,true,8560,8221\ndoobie (with fix),scala3,true,7760,7708\ndoobie (without fix),scala212,false,23452,22896\ndoobie (without fix),scala213,false,26086,25723\ndoobie (without fix),scala3,false,7862,7605\ndoobie (without fix),scala212,true,19465,19160\ndoobie (without fix),scala213,true,19433,19221\ndoobie (without fix),scala3,true,7888,7721\nanorm,scala212,false,9912,9378\nanorm,scala213,false,8900,8243\nanorm,scala3,false,7645,7179\nanorm,scala212,true,7803,7678\nanorm,scala213,true,7622,7593\nanorm,scala3,true,7050,6948\nzio-json,scala212,false,5282,5100\nzio-json,scala213,false,5356,5228\nzio-json,scala3,false,5242,5179\nzio-json,scala212,true,4602,4517\nzio-json,scala213,true,4287,4234\nzio-json,scala3,true,4562,4412\ncirce,scala212,false,4761,4621\ncirce,scala213,false,5677,5575\ncirce,scala3,false,4923,4892\ncirce,scala212,true,4028,4024\ncirce,scala213,true,3953,3825\ncirce,scala3,true,3660,3613\nplay-json,scala212,false,4242,4182\nplay-json,scala213,false,4488,4211\nplay-json,scala3,false,4089,4007\nplay-json,scala212,true,4162,4138\nplay-json,scala213,true,4109,3993\nplay-json,scala3,true,3656,3641\n"),(0,s.kt)("h2",{id:"reproducing-the-results"},"Reproducing the results"),(0,s.kt)("p",null,"You can clone the ",(0,s.kt)("a",{parentName:"p",href:"https://github.com/oyvindberg/typo"},"repo")," and run ",(0,s.kt)("inlineCode",{parentName:"p"},"bleep compile-benchmarks")," to reproduce the results.\nThe benchmark code can be found in ",(0,s.kt)("a",{parentName:"p",href:"https://github.com/oyvindberg/typo/blob/main/typo-scripts/src/scala/scripts/CompileBenchmark.scala"},"CompileBenchmark.scala")))}k.isMDXComponent=!0}}]);