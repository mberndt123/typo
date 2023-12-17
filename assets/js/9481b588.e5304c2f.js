"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[7856],{9012:(e,t,i)=>{i.d(t,{Z:()=>l});var o=i(7294),a=i(2949);const l=e=>{let{children:t}=e;const{isDarkTheme:i}=(0,a.I)(),l={backgroundColor:i?"#333":"#f0f0f0",color:i?"#fff":"#000",padding:"20px",borderRadius:"8px",display:"flex",alignItems:"center",justifyContent:"center"};return o.createElement("div",{style:l},o.createElement("svg",{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none",stroke:i?"#fff":"currentColor",strokeWidth:"2",strokeLinecap:"round",strokeLinejoin:"round",style:{marginRight:"10px"}},o.createElement("path",{d:"M7 20v1a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1v-1"}),o.createElement("path",{d:"M9 20h6"}),o.createElement("path",{d:"M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm1 16h-2v-2h2v2zm0-4h-2V8h2v6z"})),o.createElement("span",null,"Key takeaway: ",t))}},3728:(e,t,i)=>{i.d(t,{Z:()=>l});var o=i(7294),a=i(1809);const l=e=>{let{id:t,children:i}=e;const[l,n]=(0,o.useState)(null),[s,c]=(0,o.useState)("min");(0,o.useEffect)((()=>{const e=i.trim().split("\n").map((e=>e.split(","))),o=[...new Set(e.slice(1).map((e=>e[0])))],c=[...new Set(e.slice(1).map((e=>e[1])))],m=[...new Set(e.slice(1).map((e=>e[2])))],r=(e,t)=>`hsl(${"scala213"===e?200:"scala3"===e?40:"scala212"===e?120:0}, 70%, ${"true"===t?70:50}%)`;return(i=>{l&&l.destroy();const s={labels:o,datasets:c.flatMap((t=>m.map((a=>{const l=o.map((o=>{const l=e.find((e=>e[0]===o&&e[1]===t&&e[2]===a));return l?"avg"===i?parseFloat(l[3]):parseFloat(l[4]):0}));return{label:1===m.length?t:`${t} - Inlined: ${a}`,backgroundColor:r(t,a),data:l}})))).flat()},p=document.getElementById(t).getContext("2d"),d=new a.ZP(p,{type:"bar",data:s,options:{responsive:!0,maintainAspectRatio:!1,legend:{position:"top"},title:{display:!0,text:"avg"===i?"Average Compile Times (Seconds)":"Minimum Compile Times (Seconds)"},scales:{y:{stacked:!1,ticks:{beginAtZero:!0},title:{display:!0,text:"Milliseconds"}}}}});n(d)})(s),()=>{l&&l.destroy()}}),[s]);return o.createElement("div",{style:{width:"80%",margin:"auto"}},o.createElement("select",{id:"toggleView",onChange:e=>{c(e.target.value)},value:s},o.createElement("option",{value:"min"},"Minimum Compile Time"),o.createElement("option",{value:"avg"},"Average Compile Time")),o.createElement("div",{className:"chart-container"},o.createElement("canvas",{id:t,width:"800",height:"400"})))}},8544:(e,t,i)=>{i.r(t),i.d(t,{assets:()=>c,contentTitle:()=>n,default:()=>d,frontMatter:()=>l,metadata:()=>s,toc:()=>m});var o=i(7462),a=(i(7294),i(3905));i(3728),i(9012),i(614);const l={title:"The compilation cost of implicits",description:"The compilation cost of implicits",slug:"the-cost-of-implicits",authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png"}],tags:["typo","scala","doobie","anorm","zio-jdbc","implicits","compile-times"],image:"https://i.imgur.com/mErPwqL.png",hide_table_of_contents:!1},n=void 0,s={permalink:"/typo/blog/the-cost-of-implicits",source:"@site/blog/2023-12-17-the-cost-of-implicits.mdx",title:"The compilation cost of implicits",description:"The compilation cost of implicits",date:"2023-12-17T00:00:00.000Z",formattedDate:"December 17, 2023",tags:[{label:"typo",permalink:"/typo/blog/tags/typo"},{label:"scala",permalink:"/typo/blog/tags/scala"},{label:"doobie",permalink:"/typo/blog/tags/doobie"},{label:"anorm",permalink:"/typo/blog/tags/anorm"},{label:"zio-jdbc",permalink:"/typo/blog/tags/zio-jdbc"},{label:"implicits",permalink:"/typo/blog/tags/implicits"},{label:"compile-times",permalink:"/typo/blog/tags/compile-times"}],readingTime:8.965,hasTruncateMarker:!0,authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png",imageURL:"https://github.com/oyvindberg.png"}],frontMatter:{title:"The compilation cost of implicits",description:"The compilation cost of implicits",slug:"the-cost-of-implicits",authors:[{name:"\xd8yvind Raddum Berg",url:"https://github.com/oyvindberg",image_url:"https://github.com/oyvindberg.png",imageURL:"https://github.com/oyvindberg.png"}],tags:["typo","scala","doobie","anorm","zio-jdbc","implicits","compile-times"],image:"https://i.imgur.com/mErPwqL.png",hide_table_of_contents:!1},nextItem:{title:"Hello, ZIO",permalink:"/typo/blog/hello-zio"}},c={authorsImageUrls:[void 0]},m=[],r={toc:m},p="wrapper";function d(e){let{components:t,...i}=e;return(0,a.kt)(p,(0,o.Z)({},r,i,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("p",null,"I've accidentally built a compilation benchmark harness for Scala 2 and 3 which can measure the cost (in compilation time)\nfor having a codebase full of implicits which need to be resolved. Read on to see the results!"))}d.isMDXComponent=!0}}]);