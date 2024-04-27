"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[8686],{8681:(t,e,i)=>{i.r(e),i.d(e,{assets:()=>c,contentTitle:()=>l,default:()=>m,frontMatter:()=>a,metadata:()=>n,toc:()=>r});var o=i(4848),s=i(8453);i(6813),i(3026),i(1432);const a={title:"The compilation cost of implicits",description:"The compilation cost of implicits",slug:"the-cost-of-implicits",authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png"}],tags:["typo","scala","doobie","anorm","zio-jdbc","implicits","compile-times"],image:"https://i.imgur.com/mErPwqL.png",hide_table_of_contents:!1},l=void 0,n={permalink:"/typo/blog/the-cost-of-implicits",source:"@site/blog/2023-12-17-the-cost-of-implicits.mdx",title:"The compilation cost of implicits",description:"The compilation cost of implicits",date:"2023-12-17T00:00:00.000Z",tags:[{label:"typo",permalink:"/typo/blog/tags/typo"},{label:"scala",permalink:"/typo/blog/tags/scala"},{label:"doobie",permalink:"/typo/blog/tags/doobie"},{label:"anorm",permalink:"/typo/blog/tags/anorm"},{label:"zio-jdbc",permalink:"/typo/blog/tags/zio-jdbc"},{label:"implicits",permalink:"/typo/blog/tags/implicits"},{label:"compile-times",permalink:"/typo/blog/tags/compile-times"}],readingTime:8.965,hasTruncateMarker:!0,authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png",imageURL:"https://github.com/oyvindberg.png"}],frontMatter:{title:"The compilation cost of implicits",description:"The compilation cost of implicits",slug:"the-cost-of-implicits",authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png",imageURL:"https://github.com/oyvindberg.png"}],tags:["typo","scala","doobie","anorm","zio-jdbc","implicits","compile-times"],image:"https://i.imgur.com/mErPwqL.png",hide_table_of_contents:!1},unlisted:!1,nextItem:{title:"Hello, ZIO",permalink:"/typo/blog/hello-zio"}},c={authorsImageUrls:[void 0]},r=[];function p(t){const e={p:"p",...(0,s.R)(),...t.components};return(0,o.jsx)(e.p,{children:"I've accidentally built a compilation benchmark harness for Scala 2 and 3 which can measure the cost (in compilation time)\nfor having a codebase full of implicits which need to be resolved. Read on to see the results!"})}function m(t={}){const{wrapper:e}={...(0,s.R)(),...t.components};return e?(0,o.jsx)(e,{...t,children:(0,o.jsx)(p,{...t})}):p(t)}},3026:(t,e,i)=>{i.d(e,{A:()=>a});i(6540);var o=i(5293),s=i(4848);const a=t=>{let{children:e}=t;const{isDarkTheme:i}=(0,o.G)(),a={backgroundColor:i?"#333":"#f0f0f0",color:i?"#fff":"#000",padding:"20px",borderRadius:"8px",display:"flex",alignItems:"center",justifyContent:"center"};return(0,s.jsxs)("div",{style:a,children:[(0,s.jsxs)("svg",{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none",stroke:i?"#fff":"currentColor",strokeWidth:"2",strokeLinecap:"round",strokeLinejoin:"round",style:{marginRight:"10px"},children:[(0,s.jsx)("path",{d:"M7 20v1a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1v-1"}),(0,s.jsx)("path",{d:"M9 20h6"}),(0,s.jsx)("path",{d:"M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 16h-2v-2h2v2zm0-4h-2V8h2v6z"})]}),(0,s.jsxs)("span",{children:["Key takeaway: ",e]})]})}},6813:(t,e,i)=>{i.d(e,{A:()=>l});var o=i(6540),s=i(8293),a=i(4848);const l=t=>{let{id:e,children:i}=t;const[l,n]=(0,o.useState)(null),[c,r]=(0,o.useState)("min");(0,o.useEffect)((()=>{const t=i.trim().split("\n").map((t=>t.split(","))),o=[...new Set(t.slice(1).map((t=>t[0])))],a=[...new Set(t.slice(1).map((t=>t[1])))],r=[...new Set(t.slice(1).map((t=>t[2])))],p=(t,e)=>`hsl(${"scala213"===t?200:"scala3"===t?40:"scala212"===t?120:0}, 70%, ${"true"===e?70:50}%)`;return(i=>{l&&l.destroy();const c={labels:o,datasets:a.flatMap((e=>r.map((s=>{const a=o.map((o=>{const a=t.find((t=>t[0]===o&&t[1]===e&&t[2]===s));return a?"avg"===i?parseFloat(a[3]):parseFloat(a[4]):0}));return{label:1===r.length?e:`${e} - Inlined: ${s}`,backgroundColor:p(e,s),data:a}})))).flat()},m=document.getElementById(e).getContext("2d"),d=new s.Ay(m,{type:"bar",data:c,options:{responsive:!0,maintainAspectRatio:!1,legend:{position:"top"},title:{display:!0,text:"avg"===i?"Average Compile Times (Seconds)":"Minimum Compile Times (Seconds)"},scales:{y:{stacked:!1,ticks:{beginAtZero:!0},title:{display:!0,text:"Milliseconds"}}}}});n(d)})(c),()=>{l&&l.destroy()}}),[c]);return(0,a.jsxs)("div",{style:{width:"80%",margin:"auto"},children:[(0,a.jsxs)("select",{id:"toggleView",onChange:t=>{r(t.target.value)},value:c,children:[(0,a.jsx)("option",{value:"min",children:"Minimum Compile Time"}),(0,a.jsx)("option",{value:"avg",children:"Average Compile Time"})]}),(0,a.jsx)("div",{className:"chart-container",children:(0,a.jsx)("canvas",{id:e,width:"800",height:"400"})})]})}}}]);