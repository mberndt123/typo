"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[6214],{1111:(e,t,o)=>{o.r(t),o.d(t,{assets:()=>l,contentTitle:()=>i,default:()=>p,frontMatter:()=>r,metadata:()=>a,toc:()=>c});var n=o(4848),s=o(8453);const r={title:"Getting started"},i=void 0,a={id:"setup",title:"Getting started",description:"Database library",source:"@site/docs/setup.md",sourceDirName:".",slug:"/setup",permalink:"/typo/docs/setup",draft:!1,unlisted:!1,tags:[],version:"current",frontMatter:{title:"Getting started"},sidebar:"tutorialSidebar",previous:{title:"SQL DSL",permalink:"/typo/docs/what-is/dsl"},next:{title:"Limitations",permalink:"/typo/docs/limitations"}},l={},c=[{value:"Database library",id:"database-library",level:2},{value:"Getting started with DSL",id:"getting-started-with-dsl",level:2},{value:"example script",id:"example-script",level:2},{value:"Compiling the generated code",id:"compiling-the-generated-code",level:2},{value:"<code>selector</code>",id:"selector",level:2},{value:"<code>ProjectGraph</code>",id:"projectgraph",level:2},{value:"sbt plugin",id:"sbt-plugin",level:2}];function d(e){const t={a:"a",code:"code",h2:"h2",li:"li",p:"p",pre:"pre",strong:"strong",ul:"ul",...(0,s.R)(),...e.components};return(0,n.jsxs)(n.Fragment,{children:[(0,n.jsx)(t.h2,{id:"database-library",children:"Database library"}),"\n",(0,n.jsxs)(t.p,{children:["Note that you're supposed to ",(0,n.jsx)(t.a,{href:"/typo/docs/other-features/flexible",children:"bring your own database library"}),". You choose either anorm, doobie or zio-jdbc in ",(0,n.jsx)(t.code,{children:"Options"})," (see below),\nand you need to have that added to your build as well."]}),"\n",(0,n.jsx)(t.h2,{id:"getting-started-with-dsl",children:"Getting started with DSL"}),"\n",(0,n.jsxs)(t.p,{children:["If you want to use the ",(0,n.jsx)(t.a,{href:"/typo/docs/what-is/dsl",children:"SQL DSL"}),", you enable it by ",(0,n.jsx)(t.a,{href:"/typo/docs/customization/overview",children:"customizing"})," Typo by setting ",(0,n.jsx)(t.code,{children:"enableDsl = true"}),"."]}),"\n",(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-scala",children:'import typo.Options\nOptions(\n  pkg = "mypkg",\n  dbLib = None,\n  enableDsl = true\n)\n'})}),"\n",(0,n.jsx)(t.p,{children:"You also need to add a dependency to your build in that case, which varies by database library:"}),"\n",(0,n.jsxs)(t.ul,{children:["\n",(0,n.jsxs)(t.li,{children:["for doobie: ",(0,n.jsx)(t.a,{href:"https://mvnrepository.com/artifact/com.olvind.typo/typo-dsl-doobie",children:"https://mvnrepository.com/artifact/com.olvind.typo/typo-dsl-doobie"})]}),"\n",(0,n.jsxs)(t.li,{children:["for anorm: ",(0,n.jsx)(t.a,{href:"https://mvnrepository.com/artifact/com.olvind.typo/typo-dsl-anorm",children:"https://mvnrepository.com/artifact/com.olvind.typo/typo-dsl-anorm"})]}),"\n",(0,n.jsxs)(t.li,{children:["for zio-jdbc: ",(0,n.jsx)(t.a,{href:"https://mvnrepository.com/artifact/com.olvind.typo/typo-dsl-zio-jdbc",children:"https://mvnrepository.com/artifact/com.olvind.typo/typo-dsl-zio-jdbc"})]}),"\n"]}),"\n",(0,n.jsx)(t.h2,{id:"example-script",children:"example script"}),"\n",(0,n.jsx)(t.p,{children:"The Typo code generator is shipped as a library, the easiest way to get started is something like this scala-cli script:"}),"\n",(0,n.jsxs)(t.p,{children:["put it in ",(0,n.jsx)(t.code,{children:"gen-db.sc"})," and run ",(0,n.jsx)(t.code,{children:"scala-cli gen-db.sc"})]}),"\n",(0,n.jsx)(t.pre,{children:(0,n.jsx)(t.code,{className:"language-scala",children:'//\n// remember to give the project a github star if you like it <3\n//\n//> using dep "com.olvind.typo::typo:0.10.0"\n//> using scala "3.4.0"\n\nimport typo.*\n\n// adapt to your instance and credentials\nimplicit val c: java.sql.Connection =\n  java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:6432/postgres?user=postgres&password=password")\n\nval options = Options(\n  // customize package name for generated code\n  pkg = "org.foo.generated",\n  // pick your database library\n  dbLib = Some(DbLibName.Anorm),\n  jsonLibs = Nil,\n  // many more possibilities for customization here\n  // ...\n)\n\n// current folder, where you run the script from\nval location = java.nio.file.Path.of(sys.props("user.dir"))\n\n// destination folder. All files in this dir will be overwritten!\nval targetDir = location.resolve("myproject/src/main/scala/org/foo/generated")\n\n// where Typo will look for sql files\nval scriptsFolder = location.resolve("sql")\n\n// you can use this to customize which relations you want to generate code for, see below\nval selector = Selector.ExcludePostgresInternal\n\ngenerateFromDb(options, targetFolder = targetDir, selector = selector, scriptsPaths = List(scriptsFolder))\n  .overwriteFolder()\n\n// add changed files to git, so you can keep them under control\n//scala.sys.process.Process(List("git", "add", targetDir.toString)).!!\n'})}),"\n",(0,n.jsx)(t.h2,{id:"compiling-the-generated-code",children:"Compiling the generated code"}),"\n",(0,n.jsxs)(t.p,{children:["For ",(0,n.jsx)(t.strong,{children:"Scala 2"})," you need to set add ",(0,n.jsx)(t.code,{children:"-Xsource:3"})," to ",(0,n.jsx)(t.code,{children:"scalacOptions"}),", with a recent version of Scala 2.13.\nFor ",(0,n.jsx)(t.strong,{children:"Scala 3"})," you'll need 3.4.0 or later."]}),"\n",(0,n.jsx)(t.h2,{id:"selector",children:(0,n.jsx)(t.code,{children:"selector"})}),"\n",(0,n.jsxs)(t.p,{children:["You can customize which relations you generate code for, see ",(0,n.jsx)(t.a,{href:"/typo/docs/customization/customize-selected-relations",children:"customize selected relations"})]}),"\n",(0,n.jsx)(t.h2,{id:"projectgraph",children:(0,n.jsx)(t.code,{children:"ProjectGraph"})}),"\n",(0,n.jsxs)(t.p,{children:["If you want to split the generated code across multiple projects in your build, have a look at ",(0,n.jsx)(t.a,{href:"/typo/docs/other-features/generate-into-multiple-projects",children:"Generate code into multiple projects"})]}),"\n",(0,n.jsx)(t.h2,{id:"sbt-plugin",children:"sbt plugin"}),"\n",(0,n.jsx)(t.p,{children:"It's natural to think an sbt plugin would be a good match for Typo. This will likely be added in the future."})]})}function p(e={}){const{wrapper:t}={...(0,s.R)(),...e.components};return t?(0,n.jsx)(t,{...e,children:(0,n.jsx)(d,{...e})}):d(e)}},8453:(e,t,o)=>{o.d(t,{R:()=>i,x:()=>a});var n=o(6540);const s={},r=n.createContext(s);function i(e){const t=n.useContext(r);return n.useMemo((function(){return"function"==typeof e?e(t):{...t,...e}}),[t,e])}function a(e){let t;return t=e.disableParentContext?"function"==typeof e.components?e.components(s):e.components||s:i(e.components),n.createElement(r.Provider,{value:t},e.children)}}}]);