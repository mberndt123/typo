"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[4497],{3905:(e,n,t)=>{t.d(n,{Zo:()=>c,kt:()=>f});var a=t(7294);function o(e,n,t){return n in e?Object.defineProperty(e,n,{value:t,enumerable:!0,configurable:!0,writable:!0}):e[n]=t,e}function r(e,n){var t=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);n&&(a=a.filter((function(n){return Object.getOwnPropertyDescriptor(e,n).enumerable}))),t.push.apply(t,a)}return t}function i(e){for(var n=1;n<arguments.length;n++){var t=null!=arguments[n]?arguments[n]:{};n%2?r(Object(t),!0).forEach((function(n){o(e,n,t[n])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(t)):r(Object(t)).forEach((function(n){Object.defineProperty(e,n,Object.getOwnPropertyDescriptor(t,n))}))}return e}function s(e,n){if(null==e)return{};var t,a,o=function(e,n){if(null==e)return{};var t,a,o={},r=Object.keys(e);for(a=0;a<r.length;a++)t=r[a],n.indexOf(t)>=0||(o[t]=e[t]);return o}(e,n);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(a=0;a<r.length;a++)t=r[a],n.indexOf(t)>=0||Object.prototype.propertyIsEnumerable.call(e,t)&&(o[t]=e[t])}return o}var l=a.createContext({}),p=function(e){var n=a.useContext(l),t=n;return e&&(t="function"==typeof e?e(n):i(i({},n),e)),t},c=function(e){var n=p(e.components);return a.createElement(l.Provider,{value:n},e.children)},m="mdxType",d={inlineCode:"code",wrapper:function(e){var n=e.children;return a.createElement(a.Fragment,{},n)}},u=a.forwardRef((function(e,n){var t=e.components,o=e.mdxType,r=e.originalType,l=e.parentName,c=s(e,["components","mdxType","originalType","parentName"]),m=p(t),u=o,f=m["".concat(l,".").concat(u)]||m[u]||d[u]||r;return t?a.createElement(f,i(i({ref:n},c),{},{components:t})):a.createElement(f,i({ref:n},c))}));function f(e,n){var t=arguments,o=n&&n.mdxType;if("string"==typeof e||o){var r=t.length,i=new Array(r);i[0]=u;var s={};for(var l in n)hasOwnProperty.call(n,l)&&(s[l]=n[l]);s.originalType=e,s[m]="string"==typeof e?e:o,i[1]=s;for(var p=2;p<r;p++)i[p]=t[p];return a.createElement.apply(null,i)}return a.createElement.apply(null,t)}u.displayName="MDXCreateElement"},7325:(e,n,t)=>{t.r(n),t.d(n,{assets:()=>l,contentTitle:()=>i,default:()=>d,frontMatter:()=>r,metadata:()=>s,toc:()=>p});var a=t(7462),o=(t(7294),t(3905));const r={},i=void 0,s={unversionedId:"customization",id:"customization",title:"customization",description:"All customization is done through the typo.Options object passed to typo:",source:"@site/docs/customization.md",sourceDirName:".",slug:"/customization",permalink:"/typo/docs/customization",draft:!1,tags:[],version:"current",frontMatter:{},sidebar:"tutorialSidebar",previous:{title:"Compatible with your project",permalink:"/typo/docs/other-features/flexible"},next:{title:"patterns",permalink:"/typo/docs/patterns"}},l={},p=[{value:"Customize naming:",id:"customize-naming",level:2},{value:"Customize field names",id:"customize-field-names",level:3}],c={toc:p},m="wrapper";function d(e){let{components:n,...t}=e;return(0,o.kt)(m,(0,a.Z)({},c,t,{components:n,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"All customization is done through the ",(0,o.kt)("inlineCode",{parentName:"p"},"typo.Options")," object passed to typo:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},'import typo.*\n\nval options = Options(\n  pkg = "org.foo",\n  jsonLibs = List(JsonLibName.PlayJson),\n  dbLib = Some(DbLibName.Anorm)\n)\n// options: Options = Options(\n//   pkg = "org.foo",\n//   dbLib = Some(value = Anorm),\n//   jsonLibs = List(PlayJson),\n//   naming = typo.Options$$$Lambda$2114/0x00000008012d69b0@219ec4b6,\n//   typeOverride = typo.TypeOverride$$$Lambda$2115/0x00000008012d7388@cdc09d,\n//   nullabilityOverride = typo.NullabilityOverride$$$Lambda$2116/0x00000008012d79c8@31c29db1,\n//   generateMockRepos = typo.Selector$$$Lambda$2118/0x00000008012d88c0@751526a7,\n//   header = """/**\n//  * File has been automatically generated by `typo`.\n//  *\n//  * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.\n//  */\n// """,\n//   enableFieldValue = false,\n//   enableDsl = false,\n//   enableTestInserts = false,\n//   debugTypes = false,\n//   inlineImplicits = true,\n//   keepDependencies = false,\n//   silentBanner = false\n// )\n')),(0,o.kt)("h2",{id:"customize-naming"},"Customize naming:"),(0,o.kt)("p",null,"You provide a ",(0,o.kt)("inlineCode",{parentName:"p"},"typo.Naming")," instance in ",(0,o.kt)("inlineCode",{parentName:"p"},"typo.Options")," when running typo.\nThis is responsible for computing all scala names based on names from postgres."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},'val naming = new Naming(sc.QIdent("org.foo")) {\n  override def enumName(name: db.RelationName): sc.QIdent = tpe(name, suffix = "ENUM")\n}\n// naming: Naming = repl.MdocSession$App$$anon$2@2279e7c7\n\nsc.renderTree(naming.enumName(db.RelationName(Some("schema"), "foo")))\n// res0: String = "org.foo.schema.FooENUM"\n')),(0,o.kt)("h3",{id:"customize-field-names"},"Customize field names"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},'// say database uses `id_table` instead of `table_id`, this is how it can be reversed in scala code\nval fixIdPattern = new Naming(sc.QIdent("org.foo")) {\n  override def field(name: db.ColName): sc.Ident = {\n    val newName = if (name.value.startsWith("id_")) db.ColName(name.value.drop(3) + "_id") else name\n    super.field(newName)\n  }\n}\n// fixIdPattern: Naming = repl.MdocSession$App$$anon$5@4c5e123d\n\nsc.renderTree(fixIdPattern.field(db.ColName("id_flaff")))\n// res1: String = "flaffId"\n')))}d.isMDXComponent=!0}}]);