"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[226],{3905:(e,t,r)=>{r.d(t,{Zo:()=>u,kt:()=>y});var n=r(7294);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function i(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function a(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?i(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):i(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function s(e,t){if(null==e)return{};var r,n,o=function(e,t){if(null==e)return{};var r,n,o={},i=Object.keys(e);for(n=0;n<i.length;n++)r=i[n],t.indexOf(r)>=0||(o[r]=e[r]);return o}(e,t);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);for(n=0;n<i.length;n++)r=i[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(o[r]=e[r])}return o}var l=n.createContext({}),c=function(e){var t=n.useContext(l),r=t;return e&&(r="function"==typeof e?e(t):a(a({},t),e)),r},u=function(e){var t=c(e.components);return n.createElement(l.Provider,{value:t},e.children)},p="mdxType",m={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},d=n.forwardRef((function(e,t){var r=e.components,o=e.mdxType,i=e.originalType,l=e.parentName,u=s(e,["components","mdxType","originalType","parentName"]),p=c(r),d=o,y=p["".concat(l,".").concat(d)]||p[d]||m[d]||i;return r?n.createElement(y,a(a({ref:t},u),{},{components:r})):n.createElement(y,a({ref:t},u))}));function y(e,t){var r=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var i=r.length,a=new Array(i);a[0]=d;var s={};for(var l in t)hasOwnProperty.call(t,l)&&(s[l]=t[l]);s.originalType=e,s[p]="string"==typeof e?e:o,a[1]=s;for(var c=2;c<i;c++)a[c]=r[c];return n.createElement.apply(null,a)}return n.createElement.apply(null,r)}d.displayName="MDXCreateElement"},9820:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>l,contentTitle:()=>a,default:()=>m,frontMatter:()=>i,metadata:()=>s,toc:()=>c});var n=r(7462),o=(r(7294),r(3905));const i={title:"Customize column types"},a=void 0,s={unversionedId:"customization/customize-types",id:"customization/customize-types",title:"Customize column types",description:"Note that use of this feature is in general discouraged,",source:"@site/docs/customization/customize-types.md",sourceDirName:"customization",slug:"/customization/customize-types",permalink:"/typo/docs/customization/customize-types",draft:!1,tags:[],version:"current",frontMatter:{title:"Customize column types"},sidebar:"tutorialSidebar",previous:{title:"Customize nullability for parameters and columns",permalink:"/typo/docs/customization/customize-nullability"}},l={},c=[{value:"More structured version",id:"more-structured-version",level:3},{value:"Composing multiple column overrides:",id:"composing-multiple-column-overrides",level:3}],u={toc:c},p="wrapper";function m(e){let{components:t,...r}=e;return(0,o.kt)(p,(0,n.Z)({},u,r,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"Note that use of this feature is in general ",(0,o.kt)("strong",{parentName:"p"},"discouraged"),",\nsee note in ",(0,o.kt)("a",{parentName:"p",href:"/typo/docs/type-safety/user-selected-types"},"user-selected type"),"."),(0,o.kt)("p",null,"If you're not happy with the types PostgreSQL and Typo has ended up with for a given column, you can override it."),(0,o.kt)("p",null,"This is referred to within Typo as a ",(0,o.kt)("a",{parentName:"p",href:"/typo/docs/type-safety/user-selected-types"},"user-selected type"),"."),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},'import typo.{Options, TypeOverride}\n\nval rewriteColumnTypes = TypeOverride.relation {\n  case ("schema.table", "column") => "org.foo.ColumnId"\n}\n\nOptions(\n  pkg = "org.foo",\n  dbLib = None,\n  typeOverride = rewriteColumnTypes\n)\n')),(0,o.kt)("h3",{id:"more-structured-version"},"More structured version"),(0,o.kt)("p",null,'The version above is "simplified", in that is takes a descriptive type and explodes it into strings.\nYou may prefer the version below which is more cumbersome but more structured:'),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},'import typo.db.RelationName\n\nval rewriteMore = TypeOverride.of { \n  case (RelationName(Some(schema), tableName), colName) if schema.contains("foo") && colName.value.startsWith("foo") => "org.foo.Bar" \n}\n')),(0,o.kt)("h3",{id:"composing-multiple-column-overrides"},"Composing multiple column overrides:"),(0,o.kt)("pre",null,(0,o.kt)("code",{parentName:"pre",className:"language-scala"},"rewriteColumnTypes.orElse(rewriteMore)\n")))}m.isMDXComponent=!0}}]);