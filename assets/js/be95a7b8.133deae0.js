"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[14],{3905:(e,t,n)=>{n.d(t,{Zo:()=>p,kt:()=>f});var r=n(7294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function s(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function i(e,t){if(null==e)return{};var n,r,a=function(e,t){if(null==e)return{};var n,r,a={},o=Object.keys(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var l=r.createContext({}),c=function(e){var t=r.useContext(l),n=t;return e&&(n="function"==typeof e?e(t):s(s({},t),e)),n},p=function(e){var t=c(e.components);return r.createElement(l.Provider,{value:t},e.children)},u="mdxType",m={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},y=r.forwardRef((function(e,t){var n=e.components,a=e.mdxType,o=e.originalType,l=e.parentName,p=i(e,["components","mdxType","originalType","parentName"]),u=c(n),y=a,f=u["".concat(l,".").concat(y)]||u[y]||m[y]||o;return n?r.createElement(f,s(s({ref:t},p),{},{components:n})):r.createElement(f,s({ref:t},p))}));function f(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var o=n.length,s=new Array(o);s[0]=y;var i={};for(var l in t)hasOwnProperty.call(t,l)&&(i[l]=t[l]);i.originalType=e,i[u]="string"==typeof e?e:a,s[1]=i;for(var c=2;c<o;c++)s[c]=n[c];return r.createElement.apply(null,s)}return r.createElement.apply(null,n)}y.displayName="MDXCreateElement"},5435:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>l,contentTitle:()=>s,default:()=>m,frontMatter:()=>o,metadata:()=>i,toc:()=>c});var r=n(7462),a=(n(7294),n(3905));const o={title:"String enums"},s=void 0,i={unversionedId:"type-safety/string-enums",id:"type-safety/string-enums",title:"String enums",description:"If you use string enums in postgres like this:",source:"@site/docs/type-safety/string-enums.md",sourceDirName:"type-safety",slug:"/type-safety/string-enums",permalink:"/typo/docs/type-safety/string-enums",draft:!1,tags:[],version:"current",frontMatter:{title:"String enums"},sidebar:"tutorialSidebar",previous:{title:"Id types",permalink:"/typo/docs/type-safety/id-types"},next:{title:"Domains",permalink:"/typo/docs/type-safety/domains"}},l={},c=[],p={toc:c},u="wrapper";function m(e){let{components:t,...n}=e;return(0,a.kt)(u,(0,r.Z)({},p,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("p",null,"If you use string enums in postgres like this:"),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-postgresql"},"CREATE TYPE sector AS ENUM ('PUBLIC', 'PRIVATE', 'OTHER');\n")),(0,a.kt)("p",null,(0,a.kt)("inlineCode",{parentName:"p"},"typo")," will generate a type for it with the corresponding type class instances:"),(0,a.kt)("p",null,"Note that like all generated code from ",(0,a.kt)("inlineCode",{parentName:"p"},"typo")," it is in the scala 2/3 shared subset, so\nit doesn't use ",(0,a.kt)("inlineCode",{parentName:"p"},"enum")," for now."),(0,a.kt)("pre",null,(0,a.kt)("code",{parentName:"pre",className:"language-scala"},'/** Enum `myschema.sector`\n *  - PUBLIC\n *  - PRIVATE\n *  - OTHER\n */\nsealed abstract class Sector(val value: String)\n\nobject Sector {\n  def apply(str: String): Either[String, Sector] =\n    ByName.get(str).toRight(s"\'$str\' does not match any of the following legal values: $Names")\n  def force(str: String): Sector =\n    apply(str) match {\n      case Left(msg) => sys.error(msg)\n      case Right(value) => value\n    }\n  case object PUBLIC extends Sector("PUBLIC")\n  case object PRIVATE extends Sector("PRIVATE")\n  case object OTHER extends Sector("OTHER")\n  val All: List[Sector] = List(PUBLIC, PRIVATE, OTHER)\n  val Names: String = All.map(_.value).mkString(", ")\n  val ByName: Map[String, Sector] = All.map(x => (x.value, x)).toMap\n\n  // ...instances\n}\n')))}m.isMDXComponent=!0}}]);