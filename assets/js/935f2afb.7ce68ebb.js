"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[53],{1109:e=>{e.exports=JSON.parse('{"pluginId":"default","version":"current","label":"Next","banner":null,"badge":false,"noIndex":false,"className":"docs-version-current","isLast":true,"docsSidebars":{"tutorialSidebar":[{"type":"category","label":"What is typo?","collapsible":true,"collapsed":false,"items":[{"type":"link","label":"Introduction to Typo","href":"/typo/docs/","docId":"readme"},{"type":"link","label":"SQL is king!","href":"/typo/docs/what-is/sql-is-king","docId":"what-is/sql-is-king"},{"type":"link","label":"Generated code for relations","href":"/typo/docs/what-is/relations","docId":"what-is/relations"},{"type":"link","label":"SQL DSL","href":"/typo/docs/what-is/dsl","docId":"what-is/dsl"}]},{"type":"link","label":"Getting started","href":"/typo/docs/setup","docId":"setup"},{"type":"link","label":"Limitations","href":"/typo/docs/limitations","docId":"limitations"},{"type":"category","label":"Type-safety","collapsible":true,"collapsed":false,"items":[{"type":"link","label":"Id types","href":"/typo/docs/type-safety/id-types","docId":"type-safety/id-types"},{"type":"link","label":"String enums","href":"/typo/docs/type-safety/string-enums","docId":"type-safety/string-enums"},{"type":"link","label":"Domains","href":"/typo/docs/type-safety/domains","docId":"type-safety/domains"},{"type":"link","label":"Arrays","href":"/typo/docs/type-safety/arrays","docId":"type-safety/arrays"},{"type":"link","label":"Date/time types","href":"/typo/docs/type-safety/date-time","docId":"type-safety/date-time"},{"type":"link","label":"Defaulted types","href":"/typo/docs/type-safety/defaulted-types","docId":"type-safety/defaulted-types"},{"type":"link","label":"Typo types","href":"/typo/docs/type-safety/typo-types","docId":"type-safety/typo-types"},{"type":"link","label":"Type flow","href":"/typo/docs/type-safety/type-flow","docId":"type-safety/type-flow"},{"type":"link","label":"User-selected types","href":"/typo/docs/type-safety/user-selected-types","docId":"type-safety/user-selected-types"}]},{"type":"category","label":"Other features","collapsible":true,"collapsed":false,"items":[{"type":"link","label":"Ready for Scala.js/native","href":"/typo/docs/other-features/scala-js-ready","docId":"other-features/scala-js-ready"},{"type":"link","label":"Testing with stubs","href":"/typo/docs/other-features/testing-with-stubs","docId":"other-features/testing-with-stubs"},{"type":"link","label":"Testing with random values","href":"/typo/docs/other-features/testing-with-random-values","docId":"other-features/testing-with-random-values"},{"type":"link","label":"JSON codecs","href":"/typo/docs/other-features/json","docId":"other-features/json"},{"type":"link","label":"Focus on fast(er) compiles","href":"/typo/docs/other-features/faster-compilation","docId":"other-features/faster-compilation"},{"type":"link","label":"Compatible with your project","href":"/typo/docs/other-features/flexible","docId":"other-features/flexible"},{"type":"link","label":"Clickable links","href":"/typo/docs/other-features/clickable-links","docId":"other-features/clickable-links"},{"type":"link","label":"Constraints","href":"/typo/docs/other-features/constraints","docId":"other-features/constraints"}]},{"type":"category","label":"Patterns","collapsible":true,"collapsed":false,"items":[{"type":"link","label":"Patterns: The multi-repo","href":"/typo/docs/patterns/multi-repo","docId":"patterns/multi-repo"},{"type":"link","label":"Patterns: Dynamic queries","href":"/typo/docs/patterns/dynamic-queries","docId":"patterns/dynamic-queries"}]},{"type":"category","label":"Customization","collapsible":true,"collapsed":false,"items":[{"type":"link","label":"Customizing typo","href":"/typo/docs/customization/overview","docId":"customization/overview"},{"type":"link","label":"Customize SQL files","href":"/typo/docs/customization/customize-sql-files","docId":"customization/customize-sql-files"},{"type":"link","label":"Customize naming","href":"/typo/docs/customization/customize-naming","docId":"customization/customize-naming"},{"type":"link","label":"Customize nullability for parameters and columns","href":"/typo/docs/customization/customize-nullability","docId":"customization/customize-nullability"},{"type":"link","label":"Customize column types","href":"/typo/docs/customization/customize-types","docId":"customization/customize-types"}]}]},"docs":{"customization":{"id":"customization","title":"customization","description":""},"customization/customize-naming":{"id":"customization/customize-naming","title":"Customize naming","description":"You provide a typo.Naming instance in typo.Options when running typo.","sidebar":"tutorialSidebar"},"customization/customize-nullability":{"id":"customization/customize-nullability","title":"Customize nullability for parameters and columns","description":"This is done inline in the SQL you write:","sidebar":"tutorialSidebar"},"customization/customize-sql-files":{"id":"customization/customize-sql-files","title":"Customize SQL files","description":"This is done inline in the SQL you write:","sidebar":"tutorialSidebar"},"customization/customize-types":{"id":"customization/customize-types","title":"Customize column types","description":"If you\'re not happy with the types postgres and typo has ended up with for a given column, you can override it.","sidebar":"tutorialSidebar"},"customization/overview":{"id":"customization/overview","title":"Customizing typo","description":"All customizations are done through the typo.Options object passed to typo:","sidebar":"tutorialSidebar"},"limitations":{"id":"limitations","title":"Limitations","description":"Stability","sidebar":"tutorialSidebar"},"multi-repo":{"id":"multi-repo","title":"Patterns: The multi-repo","description":"There has been some comments about how the generated repositories do not match with peoples preferences of what a repository should be."},"other-features/clickable-links":{"id":"other-features/clickable-links","title":"Clickable links","description":"typo discovers information about \\"dependencies\\" \u2014 flow of data through foreign keys or through column dependencies in views.","sidebar":"tutorialSidebar"},"other-features/constraints":{"id":"other-features/constraints","title":"Constraints","description":"typo covers a lot of ground in that it should generate all types correctly.","sidebar":"tutorialSidebar"},"other-features/faster-compilation":{"id":"other-features/faster-compilation","title":"Focus on fast(er) compiles","description":"If you have a big database schema, typo can easily produce tens to hundreds of thousands of lines of code.","sidebar":"tutorialSidebar"},"other-features/flexible":{"id":"other-features/flexible","title":"Compatible with your project","description":"Much care has been taken while developing typo to support many existing projects.","sidebar":"tutorialSidebar"},"other-features/json":{"id":"other-features/json","title":"JSON codecs","description":"Since typo has the entire schema in memory anyway, it can also generate JSON codecs for you.","sidebar":"tutorialSidebar"},"other-features/scala-js-ready":{"id":"other-features/scala-js-ready","title":"Ready for Scala.js/native","description":"If you want to move Row instances across the wire to a Scala.js app, you should be able to do so.","sidebar":"tutorialSidebar"},"other-features/testing-with-random-values":{"id":"other-features/testing-with-random-values","title":"Testing with random values","description":"This covers a lot of interesting ground, test-wise.","sidebar":"tutorialSidebar"},"other-features/testing-with-stubs":{"id":"other-features/testing-with-stubs","title":"Testing with stubs","description":"It can be incredibly tiring to write tests for the database layer.","sidebar":"tutorialSidebar"},"patterns":{"id":"patterns","title":"Patterns: The multi-repo","description":"There has been some comments about how the generated repositories do not match with peoples preferences of what a repository should be."},"patterns/dynamic-queries":{"id":"patterns/dynamic-queries","title":"Patterns: Dynamic queries","description":"If you use sql files, there is a very high chance you\'ll want some queries to","sidebar":"tutorialSidebar"},"patterns/multi-repo":{"id":"patterns/multi-repo","title":"Patterns: The multi-repo","description":"There has been some comments about how the generated repositories do not match with peoples preferences of what a repository should be.","sidebar":"tutorialSidebar"},"readme":{"id":"readme","title":"Introduction to Typo","description":"Typo is not just another source code generator; it\'s your trusted partner in database development. By harnessing the power of PostgreSQL schema definitions and your SQL code, Typo creates a seamless bridge between your database and your Scala application, all while putting type-safety and developer experience (DX) front and center.","sidebar":"tutorialSidebar"},"setup":{"id":"setup","title":"Getting started","description":"The typo code generator is shipped as a library, the easiest way to get started is something like this scala-cli script:","sidebar":"tutorialSidebar"},"type-safety/arrays":{"id":"type-safety/arrays","title":"Arrays","description":"Arrays are super useful in Postgres, but almost impossible to work with through JDBC, unfortunately.","sidebar":"tutorialSidebar"},"type-safety/date-time":{"id":"type-safety/date-time","title":"Date/time types","description":"typo uses its own wrapper types for date/time, which delegates to java.time.","sidebar":"tutorialSidebar"},"type-safety/defaulted-types":{"id":"type-safety/defaulted-types","title":"Defaulted types","description":"An interesting case is how to model inserting rows into tables with default values.","sidebar":"tutorialSidebar"},"type-safety/domains":{"id":"type-safety/domains","title":"Domains","description":"If you use domains in postgres like this:","sidebar":"tutorialSidebar"},"type-safety/id-types":{"id":"type-safety/id-types","title":"Id types","description":"For every table with primary keys, a corresponding id type is created.","sidebar":"tutorialSidebar"},"type-safety/string-enums":{"id":"type-safety/string-enums","title":"String enums","description":"If you use string enums in postgres like this:","sidebar":"tutorialSidebar"},"type-safety/type-flow":{"id":"type-safety/type-flow","title":"Type flow","description":"typo follows \\"dependencies\\" between postgres columns (foreign keys and view dependencies) so the","sidebar":"tutorialSidebar"},"type-safety/typo-types":{"id":"type-safety/typo-types","title":"Typo types","description":"typo generates some helper types if they are needed by your database schema.","sidebar":"tutorialSidebar"},"type-safety/user-selected-types":{"id":"type-safety/user-selected-types","title":"User-selected types","description":"If you\'re integrating the generated code into an existing codebase it may be beneficial to reuse existing types, in particular ID types.","sidebar":"tutorialSidebar"},"what-is/dsl":{"id":"what-is/dsl","title":"SQL DSL","description":"In the world of data retrieval, there are countless instances where swift and precise data extraction is paramount.","sidebar":"tutorialSidebar"},"what-is/relations":{"id":"what-is/relations","title":"Generated code for relations","description":"typo takes the chore out of writing repository code to access your PostgreSQL database relations by automatically","sidebar":"tutorialSidebar"},"what-is/sql-is-king":{"id":"what-is/sql-is-king","title":"SQL is king!","description":"In the realm of data operations, SQL reigns supreme.","sidebar":"tutorialSidebar"}}}')}}]);