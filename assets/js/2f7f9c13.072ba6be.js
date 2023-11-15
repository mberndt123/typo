"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[200],{3905:(e,t,n)=>{n.d(t,{Zo:()=>d,kt:()=>y});var o=n(7294);function r(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function a(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);t&&(o=o.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,o)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?a(Object(n),!0).forEach((function(t){r(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):a(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function s(e,t){if(null==e)return{};var n,o,r=function(e,t){if(null==e)return{};var n,o,r={},a=Object.keys(e);for(o=0;o<a.length;o++)n=a[o],t.indexOf(n)>=0||(r[n]=e[n]);return r}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(o=0;o<a.length;o++)n=a[o],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(r[n]=e[n])}return r}var l=o.createContext({}),c=function(e){var t=o.useContext(l),n=t;return e&&(n="function"==typeof e?e(t):i(i({},t),e)),n},d=function(e){var t=c(e.components);return o.createElement(l.Provider,{value:t},e.children)},p="mdxType",m={inlineCode:"code",wrapper:function(e){var t=e.children;return o.createElement(o.Fragment,{},t)}},u=o.forwardRef((function(e,t){var n=e.components,r=e.mdxType,a=e.originalType,l=e.parentName,d=s(e,["components","mdxType","originalType","parentName"]),p=c(n),u=r,y=p["".concat(l,".").concat(u)]||p[u]||m[u]||a;return n?o.createElement(y,i(i({ref:t},d),{},{components:n})):o.createElement(y,i({ref:t},d))}));function y(e,t){var n=arguments,r=t&&t.mdxType;if("string"==typeof e||r){var a=n.length,i=new Array(a);i[0]=u;var s={};for(var l in t)hasOwnProperty.call(t,l)&&(s[l]=t[l]);s.originalType=e,s[p]="string"==typeof e?e:r,i[1]=s;for(var c=2;c<a;c++)i[c]=n[c];return o.createElement.apply(null,i)}return o.createElement.apply(null,n)}u.displayName="MDXCreateElement"},9587:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>l,contentTitle:()=>i,default:()=>m,frontMatter:()=>a,metadata:()=>s,toc:()=>c});var o=n(7462),r=(n(7294),n(3905));const a={title:"JSON codecs"},i=void 0,s={unversionedId:"other-features/json",id:"other-features/json",title:"JSON codecs",description:"Since Typo has the entire schema in memory anyway, it can also generate JSON codecs for you.",source:"@site/docs/other-features/json.md",sourceDirName:"other-features",slug:"/other-features/json",permalink:"/typo/docs/other-features/json",draft:!1,tags:[],version:"current",frontMatter:{title:"JSON codecs"},sidebar:"tutorialSidebar",previous:{title:"Streaming inserts with COPY API",permalink:"/typo/docs/other-features/streaming-inserts"},next:{title:"Focus on fast(er) compiles",permalink:"/typo/docs/other-features/faster-compilation"}},l={},c=[],d={toc:c},p="wrapper";function m(e){let{components:t,...n}=e;return(0,r.kt)(p,(0,o.Z)({},d,n,{components:t,mdxType:"MDXLayout"}),(0,r.kt)("p",null,"Since Typo has the entire schema in memory anyway, it can also generate JSON codecs for you."),(0,r.kt)("p",null,"If you want to transfer the row objects anywhere else than to and from\nPostgreSQL or write some generic code across tables, it's very convenient to be able to use "),(0,r.kt)("p",null,"You add the wanted JSON libraries to ",(0,r.kt)("inlineCode",{parentName:"p"},"typo.Options")," when running typo to get the codecs."),(0,r.kt)("p",null,"Currently, you can choose between ",(0,r.kt)("inlineCode",{parentName:"p"},"play-json"),", ",(0,r.kt)("inlineCode",{parentName:"p"},"circe")," and ",(0,r.kt)("inlineCode",{parentName:"p"},"zio-json"),".\nIt's likely quite easy to add another one if you want to contribute! "),(0,r.kt)("p",null,"For instance:"),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-scala"},'import typo.*\n\nval options = Options(\n  pkg = "org.foo",\n  jsonLibs = List(JsonLibName.PlayJson), // or `Nil` if you don\'t want json\n  dbLib = Some(DbLibName.Anorm)\n)\n')),(0,r.kt)("p",null,"And you will get instances like this:"),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-scala"},'import adventureworks.customtypes.TypoLocalDateTime\nimport adventureworks.customtypes.TypoXml\nimport adventureworks.production.productmodel.ProductmodelId\nimport adventureworks.public.Name\nimport java.util.UUID\nimport play.api.libs.json.JsObject\nimport play.api.libs.json.JsResult\nimport play.api.libs.json.JsValue\nimport play.api.libs.json.OWrites\nimport play.api.libs.json.Reads\nimport play.api.libs.json.Writes\nimport scala.collection.immutable.ListMap\nimport scala.util.Try\n\ncase class ProductmodelRow(\n    /** Primary key for ProductModel records. */\n    productmodelid: ProductmodelId,\n    /** Product model description. */\n    name: Name,\n    /** Detailed product catalog information in xml format. */\n    catalogdescription: Option[TypoXml],\n    /** Manufacturing instructions in xml format. */\n    instructions: Option[TypoXml],\n    rowguid: UUID,\n    modifieddate: TypoLocalDateTime\n)\n\nobject ProductmodelRow {\n  implicit lazy val reads: Reads[ProductmodelRow] = Reads[ProductmodelRow](json => JsResult.fromTry(\n    Try(\n      ProductmodelRow(\n        productmodelid = json.\\("productmodelid").as(ProductmodelId.reads),\n        name = json.\\("name").as(Name.reads),\n        catalogdescription = json.\\("catalogdescription").toOption.map(_.as(TypoXml.reads)),\n        instructions = json.\\("instructions").toOption.map(_.as(TypoXml.reads)),\n        rowguid = json.\\("rowguid").as(Reads.uuidReads),\n        modifieddate = json.\\("modifieddate").as(TypoLocalDateTime.reads)\n      )\n    )\n  ),\n  )\n  implicit lazy val writes: OWrites[ProductmodelRow] = OWrites[ProductmodelRow](o =>\n    new JsObject(ListMap[String, JsValue](\n      "productmodelid" -> ProductmodelId.writes.writes(o.productmodelid),\n      "name" -> Name.writes.writes(o.name),\n      "catalogdescription" -> Writes.OptionWrites(TypoXml.writes).writes(o.catalogdescription),\n      "instructions" -> Writes.OptionWrites(TypoXml.writes).writes(o.instructions),\n      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),\n      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)\n    ))\n  )\n}\n')),(0,r.kt)("p",null,"Then you can go to and from JSON without doing any extra work:"),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-scala"},'import play.api.libs.json._\n\nJson.prettyPrint(\n  Json.toJson(\n    ProductmodelRow(\n      productmodelid = ProductmodelId(1),\n      name = Name("name"),\n      catalogdescription = None,\n      instructions = Some(TypoXml("<xml/>")),\n      rowguid = UUID.fromString("0cf84c1c-0a05-449c-8e09-562663d101ed"),\n      modifieddate = TypoLocalDateTime(java.time.LocalDateTime.parse("2023-08-08T22:50:48.377623"))\n    )\n  )\n)\n// res0: String = """{\n//   "productmodelid" : 1,\n//   "name" : "name",\n//   "catalogdescription" : null,\n//   "instructions" : "<xml/>",\n//   "rowguid" : "0cf84c1c-0a05-449c-8e09-562663d101ed",\n//   "modifieddate" : "2023-08-08T22:50:48.377623"\n// }"""\n')))}m.isMDXComponent=!0}}]);