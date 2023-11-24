"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[5945],{3905:(e,t,r)=>{r.d(t,{Zo:()=>c,kt:()=>m});var n=r(7294);function o(e,t,r){return t in e?Object.defineProperty(e,t,{value:r,enumerable:!0,configurable:!0,writable:!0}):e[t]=r,e}function a(e,t){var r=Object.keys(e);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(e);t&&(n=n.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),r.push.apply(r,n)}return r}function i(e){for(var t=1;t<arguments.length;t++){var r=null!=arguments[t]?arguments[t]:{};t%2?a(Object(r),!0).forEach((function(t){o(e,t,r[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(r)):a(Object(r)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(r,t))}))}return e}function s(e,t){if(null==e)return{};var r,n,o=function(e,t){if(null==e)return{};var r,n,o={},a=Object.keys(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||(o[r]=e[r]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(n=0;n<a.length;n++)r=a[n],t.indexOf(r)>=0||Object.prototype.propertyIsEnumerable.call(e,r)&&(o[r]=e[r])}return o}var l=n.createContext({}),p=function(e){var t=n.useContext(l),r=t;return e&&(r="function"==typeof e?e(t):i(i({},t),e)),r},c=function(e){var t=p(e.components);return n.createElement(l.Provider,{value:t},e.children)},u="mdxType",d={inlineCode:"code",wrapper:function(e){var t=e.children;return n.createElement(n.Fragment,{},t)}},y=n.forwardRef((function(e,t){var r=e.components,o=e.mdxType,a=e.originalType,l=e.parentName,c=s(e,["components","mdxType","originalType","parentName"]),u=p(r),y=o,m=u["".concat(l,".").concat(y)]||u[y]||d[y]||a;return r?n.createElement(m,i(i({ref:t},c),{},{components:r})):n.createElement(m,i({ref:t},c))}));function m(e,t){var r=arguments,o=t&&t.mdxType;if("string"==typeof e||o){var a=r.length,i=new Array(a);i[0]=y;var s={};for(var l in t)hasOwnProperty.call(t,l)&&(s[l]=t[l]);s.originalType=e,s[u]="string"==typeof e?e:o,i[1]=s;for(var p=2;p<a;p++)i[p]=r[p];return n.createElement.apply(null,i)}return n.createElement.apply(null,r)}y.displayName="MDXCreateElement"},584:(e,t,r)=>{r.r(t),r.d(t,{assets:()=>l,contentTitle:()=>i,default:()=>d,frontMatter:()=>a,metadata:()=>s,toc:()=>p});var n=r(7462),o=(r(7294),r(3905));const a={title:"SQL is king!"},i=void 0,s={unversionedId:"what-is/sql-is-king",id:"what-is/sql-is-king",title:"SQL is king!",description:"In the realm of data operations, SQL reigns supreme.",source:"@site/docs/what-is/sql-is-king.md",sourceDirName:"what-is",slug:"/what-is/sql-is-king",permalink:"/typo/docs/what-is/sql-is-king",draft:!1,tags:[],version:"current",frontMatter:{title:"SQL is king!"},sidebar:"tutorialSidebar",previous:{title:"Introduction to Typo",permalink:"/typo/docs/"},next:{title:"Generated code for relations",permalink:"/typo/docs/what-is/relations"}},l={},p=[{value:"Parameters",id:"parameters",level:2},{value:"Updates",id:"updates",level:2}],c={toc:p},u="wrapper";function d(e){let{components:t,...r}=e;return(0,o.kt)(u,(0,n.Z)({},c,r,{components:t,mdxType:"MDXLayout"}),(0,o.kt)("p",null,"In the realm of data operations, SQL reigns supreme.\nThat's why the primary workflow in Typo revolves around writing SQL in dedicated SQL files."),(0,o.kt)("p",null,"Here's why this approach is a game-changer:"),(0,o.kt)("p",null,(0,o.kt)("strong",{parentName:"p"},"1. Fully Exploded Queries"),": Forget about the hassle of converting SQL queries to and from source code. With Typo,\nyour queries reside in their pure form, ready to be executed as intended."),(0,o.kt)("p",null,(0,o.kt)("strong",{parentName:"p"},"2. Superb Tooling Support"),": Typo's SQL-first approach unlocks unparalleled tooling support. Whether you're using an\nIDE or language model (LLM), you'll experience seamless integration, enhanced autocompletion, and precise error\nmessages."),(0,o.kt)("p",null,(0,o.kt)("strong",{parentName:"p"},"3. Parameter Support"),": Typo embraces the flexibility of SQL by allowing parameterization within your queries. It's\nnot just about static SQL; you can dynamically pass parameters to tailor your database interactions."),(0,o.kt)("p",null,(0,o.kt)("strong",{parentName:"p"},"4. Centralization"),": Picture this\u2014you can now gather and manage all your queries used across (or within parts of) a\nsystem in one centralized location. This is more than just convenience; it's a game-changer for collaboration and\nanalysis. Your DBA can effortlessly script analyses and optimizations."),(0,o.kt)("p",null,"But let's not stop at words\u2014let's dive right into a live example! In the video below, witness the magic as the generated\ncode seamlessly updates in real-time as you edit your SQL file. Experience the fluidity and power of Typo's SQL-first\napproach for yourself."),(0,o.kt)("video",{width:"100%",controls:!0,src:"https://github.com/oyvindberg/typo/assets/247937/df7c4f2d-b118-4081-81c6-dd03dfe62ee2"}),(0,o.kt)("h2",{id:"parameters"},"Parameters"),(0,o.kt)("p",null,"This video shows how you can use parameters. "),(0,o.kt)("p",null,"It also shows the syntax to ",(0,o.kt)("a",{parentName:"p",href:"/typo/docs/customization/customize-sql-files"},"override inferred nullability and types"),".\nWhile PostgreSQL is pretty good at both, it's not always exactly what you want.\nIn particular, parameters are optional by default. "),(0,o.kt)("video",{width:"100%",controls:!0,src:"https://github.com/oyvindberg/typo/assets/247937/b2965b74-8ee5-4475-8e40-5938ff44d385"}),(0,o.kt)("h2",{id:"updates"},"Updates"),(0,o.kt)("p",null,"You can also ",(0,o.kt)("inlineCode",{parentName:"p"},"update"),", ",(0,o.kt)("inlineCode",{parentName:"p"},"delete")," and so on in sql scripts.\nThose statements can also return columns, see this video"),(0,o.kt)("video",{width:"100%",controls:!0,src:"https://github.com/oyvindberg/typo/assets/247937/e8c3c34a-0691-4ad3-bd44-b73bb14d5997"}))}d.isMDXComponent=!0}}]);