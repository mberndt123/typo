"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[6497],{9193:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>c,contentTitle:()=>i,default:()=>u,frontMatter:()=>r,metadata:()=>a,toc:()=>l});var o=n(4848),s=n(8453);const r={title:"Constraints"},i=void 0,a={id:"other-features/constraints",title:"Constraints",description:"Typo covers a lot of ground in that it should generate all types correctly.",source:"@site/docs/other-features/constraints.md",sourceDirName:"other-features",slug:"/other-features/constraints",permalink:"/typo/docs/other-features/constraints",draft:!1,unlisted:!1,tags:[],version:"current",frontMatter:{title:"Constraints"},sidebar:"tutorialSidebar",previous:{title:"Clickable links",permalink:"/typo/docs/other-features/clickable-links"},next:{title:"Ready for Scala.js/native",permalink:"/typo/docs/other-features/scala-js-ready"}},c={},l=[];function p(e){const t={code:"code",p:"p",pre:"pre",...(0,s.R)(),...e.components};return(0,o.jsxs)(o.Fragment,{children:[(0,o.jsx)(t.p,{children:"Typo covers a lot of ground in that it should generate all types correctly.\nHowever, to safely insert or update data into PostgreSQL, you also need to satisfy contraints.\nTypo does a good job a helping out with foreign keys, but there are other types of constraints as well."}),"\n",(0,o.jsxs)(t.p,{children:["For now the constraints are picked up and output as field comments for the ",(0,o.jsx)(t.code,{children:"Row"})," types."]}),"\n",(0,o.jsx)(t.pre,{children:(0,o.jsx)(t.code,{className:"language-scala",children:"import adventureworks.person.businessentity.BusinessentityId\n\ncase class PersonRow(\n  /** Primary key for Person records.\n      Points to [[businessentity.BusinessentityRow.businessentityid]] */\n  businessentityid: BusinessentityId,\n  /** Primary type of person: SC = Store Contact, IN = Individual (retail) customer, SP = Sales person, EM = Employee (non-sales), VC = Vendor contact, GC = General contact\n      Constraint CK_Person_PersonType affecting columns \"persontype\":  (((persontype IS NULL) OR (upper((persontype)::text) = ANY (ARRAY['SC'::text, 'VC'::text, 'IN'::text, 'EM'::text, 'SP'::text, 'GC'::text])))) */\n  /** 0 = Contact does not wish to receive e-mail promotions, 1 = Contact does wish to receive e-mail promotions from AdventureWorks, 2 = Contact does wish to receive e-mail promotions from AdventureWorks and selected partners.\n      Constraint CK_Person_EmailPromotion affecting columns \"emailpromotion\":  (((emailpromotion >= 0) AND (emailpromotion <= 2))) */\n  emailpromotion: Int,\n)\n"})}),"\n",(0,o.jsx)(t.p,{children:"In the future, we can generate types for check constraints such as these to force you to use them correctly.\nit's not implemented yet, however."})]})}function u(e={}){const{wrapper:t}={...(0,s.R)(),...e.components};return t?(0,o.jsx)(t,{...e,children:(0,o.jsx)(p,{...e})}):p(e)}},8453:(e,t,n)=>{n.d(t,{R:()=>i,x:()=>a});var o=n(6540);const s={},r=o.createContext(s);function i(e){const t=o.useContext(r);return o.useMemo((function(){return"function"==typeof e?e(t):{...t,...e}}),[t,e])}function a(e){let t;return t=e.disableParentContext?"function"==typeof e.components?e.components(s):e.components||s:i(e.components),o.createElement(r.Provider,{value:t},e.children)}}}]);