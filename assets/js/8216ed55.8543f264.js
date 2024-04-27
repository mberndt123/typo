"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[4141],{3352:(e,n,t)=>{t.r(n),t.d(n,{assets:()=>r,contentTitle:()=>a,default:()=>l,frontMatter:()=>o,metadata:()=>c,toc:()=>m});var i=t(4848),s=t(8453);const o={title:"Customize naming"},a=void 0,c={id:"customization/customize-naming",title:"Customize naming",description:"You provide a typo.Naming instance in typo.Options when running typo.",source:"@site/docs/customization/customize-naming.md",sourceDirName:"customization",slug:"/customization/customize-naming",permalink:"/typo/docs/customization/customize-naming",draft:!1,unlisted:!1,tags:[],version:"current",frontMatter:{title:"Customize naming"},sidebar:"tutorialSidebar",previous:{title:"Customize SQL files",permalink:"/typo/docs/customization/customize-sql-files"},next:{title:"Customize nullability for parameters and columns",permalink:"/typo/docs/customization/customize-nullability"}},r={},m=[{value:"Customize field names",id:"customize-field-names",level:3},{value:"Customize enum field names",id:"customize-enum-field-names",level:3}];function d(e){const n={code:"code",h3:"h3",p:"p",pre:"pre",...(0,s.R)(),...e.components};return(0,i.jsxs)(i.Fragment,{children:[(0,i.jsxs)(n.p,{children:["You provide a ",(0,i.jsx)(n.code,{children:"typo.Naming"})," instance in ",(0,i.jsx)(n.code,{children:"typo.Options"})," when running typo.\nThis is responsible for computing all scala names based on names from PostgreSQL."]}),"\n",(0,i.jsx)(n.h3,{id:"customize-field-names",children:"Customize field names"}),"\n",(0,i.jsxs)(n.p,{children:["As an example, say you you have some weird naming standard in your schemas, for instance ",(0,i.jsx)(n.code,{children:"id_table"})," instead of ",(0,i.jsx)(n.code,{children:"table_id"}),".\nThis is how it can be prettified in the generated scala code"]}),"\n",(0,i.jsx)(n.pre,{children:(0,i.jsx)(n.code,{className:"language-scala",children:'import typo.*\n\nval optsCustomId = Options(\n  pkg = "org.foo",\n  dbLib = None,\n  naming = pkg => new Naming(pkg) {\n    override def field(name: db.ColName): sc.Ident = {\n      val newName = if (name.value.startsWith("id_")) db.ColName(name.value.drop(3) + "_id") else name\n      super.field(newName)\n    }\n  }\n)\n'})}),"\n",(0,i.jsx)(n.pre,{children:(0,i.jsx)(n.code,{className:"language-scala",children:'// this incantation demos the effect, you don\'t have to write this in your code\nsc.renderTree(optsCustomId.naming(sc.QIdent(optsCustomId.pkg)).field(db.ColName("id_flaff")))\n// res0: String = "flaffId"\n'})}),"\n",(0,i.jsx)(n.h3,{id:"customize-enum-field-names",children:"Customize enum field names"}),"\n",(0,i.jsx)(n.p,{children:"Let's say you get a name clash between a string enum value and a typeclass instance name.\nThis is something which can happen currently"}),"\n",(0,i.jsx)(n.pre,{children:(0,i.jsx)(n.code,{className:"language-scala",children:'val optsCustomEnum = Options(\n  pkg = "org.foo",\n  dbLib = None,\n  naming = pkg => new Naming(pkg) {\n    override def enumValue(name: String): sc.Ident =\n      sc.Ident(if (name == "writes") "Writes" else name)\n  }\n)\n'})}),"\n",(0,i.jsx)(n.pre,{children:(0,i.jsx)(n.code,{className:"language-scala",children:'// this incantation demos the effect, you don\'t have to write this in your code\nsc.renderTree(optsCustomEnum.naming(sc.QIdent(optsCustomEnum.pkg)).enumValue("writes"))\n// res1: String = "Writes"\n'})})]})}function l(e={}){const{wrapper:n}={...(0,s.R)(),...e.components};return n?(0,i.jsx)(n,{...e,children:(0,i.jsx)(d,{...e})}):d(e)}},8453:(e,n,t)=>{t.d(n,{R:()=>a,x:()=>c});var i=t(6540);const s={},o=i.createContext(s);function a(e){const n=i.useContext(o);return i.useMemo((function(){return"function"==typeof e?e(n):{...n,...e}}),[n,e])}function c(e){let n;return n=e.disableParentContext?"function"==typeof e.components?e.components(s):e.components||s:a(e.components),i.createElement(o.Provider,{value:n},e.children)}}}]);