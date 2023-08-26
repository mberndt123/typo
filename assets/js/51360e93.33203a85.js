"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[326],{3905:(e,t,n)=>{n.d(t,{Zo:()=>c,kt:()=>m});var a=n(7294);function s(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function r(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function o(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?r(Object(n),!0).forEach((function(t){s(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):r(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function i(e,t){if(null==e)return{};var n,a,s=function(e,t){if(null==e)return{};var n,a,s={},r=Object.keys(e);for(a=0;a<r.length;a++)n=r[a],t.indexOf(n)>=0||(s[n]=e[n]);return s}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(a=0;a<r.length;a++)n=r[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(s[n]=e[n])}return s}var p=a.createContext({}),l=function(e){var t=a.useContext(p),n=t;return e&&(n="function"==typeof e?e(t):o(o({},t),e)),n},c=function(e){var t=l(e.components);return a.createElement(p.Provider,{value:t},e.children)},y="mdxType",u={inlineCode:"code",wrapper:function(e){var t=e.children;return a.createElement(a.Fragment,{},t)}},d=a.forwardRef((function(e,t){var n=e.components,s=e.mdxType,r=e.originalType,p=e.parentName,c=i(e,["components","mdxType","originalType","parentName"]),y=l(n),d=s,m=y["".concat(p,".").concat(d)]||y[d]||u[d]||r;return n?a.createElement(m,o(o({ref:t},c),{},{components:n})):a.createElement(m,o({ref:t},c))}));function m(e,t){var n=arguments,s=t&&t.mdxType;if("string"==typeof e||s){var r=n.length,o=new Array(r);o[0]=d;var i={};for(var p in t)hasOwnProperty.call(t,p)&&(i[p]=t[p]);i.originalType=e,i[y]="string"==typeof e?e:s,o[1]=i;for(var l=2;l<r;l++)o[l]=n[l];return a.createElement.apply(null,o)}return a.createElement.apply(null,n)}d.displayName="MDXCreateElement"},3013:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>p,contentTitle:()=>o,default:()=>u,frontMatter:()=>r,metadata:()=>i,toc:()=>l});var a=n(7462),s=(n(7294),n(3905));const r={title:"Typo types"},o=void 0,i={unversionedId:"type-safety/typo-types",id:"type-safety/typo-types",title:"Typo types",description:"typo generates some helper types if they are needed by your database schema.",source:"@site/docs/type-safety/typo-types.md",sourceDirName:"type-safety",slug:"/type-safety/typo-types",permalink:"/typo/docs/type-safety/typo-types",draft:!1,tags:[],version:"current",frontMatter:{title:"Typo types"},sidebar:"tutorialSidebar",previous:{title:"Defaulted types",permalink:"/typo/docs/type-safety/defaulted-types"},next:{title:"Type flow",permalink:"/typo/docs/type-safety/type-flow"}},p={},l=[],c={toc:l},y="wrapper";function u(e){let{components:t,...n}=e;return(0,s.kt)(y,(0,a.Z)({},c,n,{components:t,mdxType:"MDXLayout"}),(0,s.kt)("p",null,(0,s.kt)("inlineCode",{parentName:"p"},"typo")," generates some helper types if they are needed by your database schema."),(0,s.kt)("p",null,"There are multiple reasons why this is sometimes necessary:"),(0,s.kt)("ul",null,(0,s.kt)("li",{parentName:"ul"},"postgres driver has broken handling of offset date/time types. need to go through string in order to not lose offset/precision"),(0,s.kt)("li",{parentName:"ul"},"money type is broken in many interesting ways"),(0,s.kt)("li",{parentName:"ul"},"possibility of transferring instances of a ",(0,s.kt)("inlineCode",{parentName:"li"},"Row")," type to a platform which doesn't have the postgres driver jar available"),(0,s.kt)("li",{parentName:"ul"},"a type to hang otherwise orphan type classes on")),(0,s.kt)("p",null,"The full list is here:"),(0,s.kt)("pre",null,(0,s.kt)("code",{parentName:"pre",className:"language-scala"},"import java.time.*\n\n/** aclitem (via PGObject) */\ncase class TypoAclItem(value: String)\n/** anyarray (via PGObject) */\ncase class TypoAnyArray(value: String)\n/** This represents the box datatype in PostgreSQL */\ncase class TypoBox(x1: Double, y1: Double, x2: Double, y2: Double)\n/** This represents circle datatype in PostgreSQL, consisting of a point and a radius */\ncase class TypoCircle(center: TypoPoint, radius: Double)\n/** The text representation of an hstore, used for input and output, includes zero or more key => value pairs separated by commas */\ncase class TypoHStore(value: Map[String, String])\n/** inet (via PGObject) */\ncase class TypoInet(value: String)\n/** int2vector (via PGObject) */\ncase class TypoInt2Vector(value: String)\n/** Interval type in PostgreSQL */\ncase class TypoInterval(years: Int, months: Int, days: Int, hours: Int, minutes: Int, seconds: Double)\n/** json (via PGObject) */\ncase class TypoJson(value: String)\n/** jsonb (via PGObject) */\ncase class TypoJsonb(value: String)\n/** This implements a line represented by the linear equation Ax + By + C = 0 */\ncase class TypoLine(a: Double, b: Double, c: Double)\n/** This implements a line represented by the linear equation Ax + By + C = 0 */\ncase class TypoLineSegment(p1: TypoPoint, p2: TypoPoint)\n/** This is `java.time.LocalDate`, but transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */\ncase class TypoLocalDate(value: LocalDate)\n/** This is `java.time.LocalDateTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */\ncase class TypoLocalDateTime(value: LocalDateTime)\n/** This is `java.time.LocalTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */\ncase class TypoLocalTime(value: LocalTime)\n/** Money and cash types in PostgreSQL */\ncase class TypoMoney(value: BigDecimal)\n/** This is `java.time.OffsetDateTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */\ncase class TypoOffsetDateTime(value: OffsetDateTime)\n/** This is `java.time.OffsetTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */\ncase class TypoOffsetTime(value: OffsetTime)\n/** oidvector (via PGObject) */\ncase class TypoOidVector(value: String)\n/** This implements a path (a multiple segmented line, which may be closed) */\ncase class TypoPath(open: Boolean, points: List[TypoPoint])\n/** pg_node_tree (via PGObject) */\ncase class TypoPgNodeTree(value: String)\n/** Point datatype in PostgreSQL */\ncase class TypoPoint(x: Double, y: Double)\n/** Polygon datatype in PostgreSQL */\ncase class TypoPolygon(points: List[TypoPoint])\n/** regproc (via PGObject) */\ncase class TypoRegproc(value: String)\n/** regtype (via PGObject) */\ncase class TypoRegtype(value: String)\n/** xid (via PGObject) */\ncase class TypoXid(value: String)\n/** XML */\ncase class TypoXml(value: String)\n")))}u.isMDXComponent=!0}}]);