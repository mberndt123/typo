"use strict";(self.webpackChunksite=self.webpackChunksite||[]).push([[9925],{4755:e=>{e.exports=JSON.parse('{"blogPosts":[{"id":"the-cost-of-implicits","metadata":{"permalink":"/typo/blog/the-cost-of-implicits","source":"@site/blog/2023-12-17-the-cost-of-implicits.mdx","title":"The compilation cost of implicits","description":"The compilation cost of implicits","date":"2023-12-17T00:00:00.000Z","formattedDate":"December 17, 2023","tags":[{"label":"typo","permalink":"/typo/blog/tags/typo"},{"label":"scala","permalink":"/typo/blog/tags/scala"},{"label":"doobie","permalink":"/typo/blog/tags/doobie"},{"label":"anorm","permalink":"/typo/blog/tags/anorm"},{"label":"zio-jdbc","permalink":"/typo/blog/tags/zio-jdbc"},{"label":"implicits","permalink":"/typo/blog/tags/implicits"},{"label":"compile-times","permalink":"/typo/blog/tags/compile-times"}],"readingTime":8.265,"hasTruncateMarker":true,"authors":[{"name":"\xd8yvind Raddum Berg","url":"https://github.com/oyvindberg","image_url":"https://github.com/oyvindberg.png","imageURL":"https://github.com/oyvindberg.png"}],"frontMatter":{"title":"The compilation cost of implicits","description":"The compilation cost of implicits","slug":"the-cost-of-implicits","authors":[{"name":"\xd8yvind Raddum Berg","url":"https://github.com/oyvindberg","image_url":"https://github.com/oyvindberg.png","imageURL":"https://github.com/oyvindberg.png"}],"tags":["typo","scala","doobie","anorm","zio-jdbc","implicits","compile-times"],"image":"https://i.imgur.com/mErPwqL.png","hide_table_of_contents":false},"nextItem":{"title":"Hello, ZIO","permalink":"/typo/blog/hello-zio"}},"content":"import ScalaCompileTimesChart from \'@site/src/components/ScalaCompileTimesChart\';\\nimport KeyTakeaway from \'@site/src/components/KeyTakeaway\';\\nimport CodeBlock from \'@theme/CodeBlock\';\\n\\n\\nI\'ve accidentally built a compilation benchmark harness for Scala 2 and 3 which can measure the cost (in compilation time)\\nfor having a codebase full of implicits which need to be resolved. Read on to see the results!\\n\\n\x3c!-- truncate --\x3e\\n\\n## Background\\n\\nTypo is a code-generation library for working with PostgreSQL in Scala.\\nYou can read more in the [introduction](https://oyvindberg.github.io/typo/docs/).\\n\\nIt was built to replace huge swatches of boilerplate in applications,\\nas well as to provide sorely needed type-safety to avoid having to test everything.\\n\\nA crucial design goal was to fit into your system such as it is.\\nThis means it generates code in the shared subset between Scala 2.12, 2.13 and 3.x,\\nand for three different database access libraries.\\n\\n### Typo output as a realistic compile speed test harness\\n\\nIn typical systems you may have a database layer, a business logic layer and a web layer,\\nwith each of them occupying about a third of the code base.\\n\\nThe structure of the database and web layers are often very similar -\\nbasically a bunch of case classes with type class instances and mapping code.\\n\\nSo let\'s say we take the database third of a typical system.\\nWe\'ll use the fact that Typo can generate it in its entirety to build a compile speed benchmark,\\nwhere we contrast different combinations of scala versions and database libraries.\\n\\nI\'ll stress that the code it generates is basically the same code I\'ve written again and again over the years,\\nwhich should make the benchmark interesting since this is so close to real-world application code.\\n\\nLet\'s see where it takes us!\\n\\n## The generated code\\n\\nIf you\'re curious about the generated code,\\nyou can expand this section to see some example code\\nfor an email address table in the [AdventureWorks database](https://github.com/lorint/AdventureWorks-for-Postgres),\\ngenerated for doobie.\\n\\nimport EmailaddressId from \'!!raw-loader!@site/blog/emailaddress/EmailaddressId.scala\';\\nimport EmailaddressRepo from \'!!raw-loader!@site/blog/emailaddress/EmailaddressRepo.scala\';\\nimport EmailaddressRepoImpl from \'!!raw-loader!@site/blog/emailaddress/EmailaddressRepoImpl.scala\';\\nimport EmailaddressRepoMock from \'!!raw-loader!@site/blog/emailaddress/EmailaddressRepoMock.scala\';\\nimport EmailaddressRow from \'!!raw-loader!@site/blog/emailaddress/EmailaddressRow.scala\';\\nimport EmailaddressRowUnsaved from \'!!raw-loader!@site/blog/emailaddress/EmailaddressRowUnsaved.scala\';\\n\\n<details><summary>EmailaddressId.scala</summary><CodeBlock language=\\"yaml\\" children={EmailaddressId}/></details>\\n<details><summary>EmailaddressRepo.scala</summary><CodeBlock language=\\"yaml\\" children={EmailaddressRepo}/></details>\\n<details><summary>EmailaddressRepoImpl.scala</summary><CodeBlock language=\\"yaml\\" children={EmailaddressRepoImpl}/></details>\\n<details><summary>EmailaddressRepoMock.scala</summary><CodeBlock language=\\"yaml\\" children={EmailaddressRepoMock}/></details>\\n<details><summary>EmailaddressRow.scala</summary><CodeBlock language=\\"yaml\\" children={EmailaddressRow}/></details>\\n<details><summary>EmailaddressRowUnsaved.scala</summary><CodeBlock language=\\"yaml\\" children={EmailaddressRowUnsaved}/></details>\\n\\n## Initial comparison of compile times\\n\\nEach benchmark is run three times, and in the graphs you can choose to se minimum or average compile times.\\n\\n<ScalaCompileTimesChart id=\\"groupedBarChart1\\">{`\\nlibrary,scala version, average compile time, minimum compile time\\nbaseline (only case class),scala212,false,2346,2289\\nbaseline (only case class),scala213,false,4273,2944\\nbaseline (only case class),scala3,false,4319,3050\\nzio-jdbc,scala212,false,9484,8919\\nzio-jdbc,scala213,false,10094,9058\\nzio-jdbc,scala3,false,8954,7500\\ndoobie,scala212,false,23452,22896\\ndoobie,scala213,false,26086,25723\\ndoobie,scala3,false,7862,7605\\nanorm,scala212,false,9912,9378\\nanorm,scala213,false,8900,8243\\nanorm,scala3,false,7645,7179\\n`}</ScalaCompileTimesChart>\\n\\n\\"baseline\\" is generating just case classes, no type class instances or repositories.\\n\\n\\nWe can make some observations right away:\\n- Scala 3 is ~always faster than Scala 2.12 and 2.13, only beaten by Scala 2.12 for baseline/just case classes\\n- doobie takes more than double the time to compile compared to anorm and zio-jdbc for Scala 2.x.\\n- zio-jdbc and anorm have similar compile times across scala versions.\\n- It\'s interesting to see the \\"cost\\" of adding type class instances and repositories\\n\\n<br/>\\n<KeyTakeaway>\\n    Scala 3 is consistently fast! Great job Scala team!\\n</KeyTakeaway>\\n<br/>\\nThe meat of this blog post will be to <b>investigate why the code for doobie takes so long for scala 2.x</b>.\\n\\n## So what\'s up with doobie with Scala 2.x?\\n\\nThe issue is composite. Let\'s take the biggest issue first - Automatic derivation of type class instances!\\n\\nLet\'s take something rather innocent:\\n<CodeBlock language=\\"scala\\">{\\n`case class A(v1: String, v2: String, v3: String, v4: String, v5: String, v6: String, v7: String)\\nsql\\"select 1,2,3,4,5,6,7\\".query[A].to[List]\\nsql\\"select 1,2,3,4,5,6,7\\".query[A].to[List]\\n`}\\n</CodeBlock>\\n\\nThis will compile and work, but an instance of `Read[A]` will be derived for each of the two queries.\\n\\nNo problem, we\'re taught that we can cache the `Read[A]` instance in the companion object.\\n<CodeBlock language=\\"scala\\">{`\\nobject A {\\n  implicit val read: Read[A] = Read.derived\\n}\\n`}\\n</CodeBlock>\\n\\nThe surprise is that (as far as I understand) this does not actually work in this case.\\nSince the automatic derivation is put in implicit scope in the companion object of the type class, it will be found before our cached instance.\\nWe actually need to specify the instance explicitly:\\n\\n<CodeBlock language=\\"scala\\">{`\\nsql\\"select 1,2,3,4,5,6,7\\".query(A.read).to[List]\\nsql\\"select 1,2,3,4,5,6,7\\".query(A.read).to[List]\\n`}\\n</CodeBlock>\\n\\nAnd boom! We\'ve solved the problem. I implemented this in Typo, and will refer to this as doobie with and without fix in subsequent tables.\\n\\n## Results without accidental automatic type class derivation for doobie\\n<ScalaCompileTimesChart id=\\"groupedBarChart2\\">{`\\nlibrary,scala version, inlined implicits, average compile time, minimum compile time\\nbaseline (only case class),scala212,false,2346,2289\\nbaseline (only case class),scala213,false,4273,2944\\nbaseline (only case class),scala3,false,4319,3050\\nzio-jdbc,scala212,false,9484,8919\\nzio-jdbc,scala213,false,10094,9058\\nzio-jdbc,scala3,false,8954,7500\\ndoobie (with fix),scala212,false,15463,14826\\ndoobie (with fix),scala213,false,16598,15467\\ndoobie (with fix),scala3,false,7814,7369\\ndoobie (without fix),scala212,false,23452,22896\\ndoobie (without fix),scala213,false,26086,25723\\ndoobie (without fix),scala3,false,7862,7605\\nanorm,scala212,false,9912,9378\\nanorm,scala213,false,8900,8243\\nanorm,scala3,false,7645,7179\\n`}</ScalaCompileTimesChart>\\n\\nFantastic! We\'ve cut the compile times almost in half for doobie for Scala 2.x - ten seconds is a lot of time if you suffer them often.\\n\\n<br/>\\n<KeyTakeaway>\\n    Automatic typeclass derivation is a bad idea, but only for Scala 2.x!\\n</KeyTakeaway>\\n<br/>\\n\\nBut doobie is still a lot slower, so let\'s dig a bit further!\\n\\n## Query interpolation woes.\\n\\nSo all of this extra time is spent in typer/resolving implicits. I wanted to see what could be done about it, and what causes it.\\n\\nThat\'s why I implemented an \\"inline implicits\\" mode for typo. I\'ll show a diff of what it does here, hopefully it\'ll be clear that it hardcodes some implicit resolution:\\n<CodeBlock language=\\"diff\\">{`\\n+import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite\\n+import doobie.util.Write\\n+import doobie.util.meta.Meta\\nclass EmailaddressRepoImpl extends EmailaddressRepo {\\n   override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {\\n     val compositeId = row.compositeId\\n     sql\\"\\"\\"update person.emailaddress\\n-          set \\"emailaddress\\" = \\\\${row.emailaddress},\\n-              \\"rowguid\\" = \\\\${row.rowguid}::uuid,\\n-              \\"modifieddate\\" = \\\\${row.modifieddate}::timestamp\\n-          where \\"businessentityid\\" = \\\\${compositeId.businessentityid} AND \\"emailaddressid\\" = \\\\${compositeId.emailaddressid}\\"\\"\\"\\n+          set \\"emailaddress\\" = \\\\${fromWrite(row.emailaddress)(Write.fromPutOption(Meta.StringMeta.put))},\\n+              \\"rowguid\\" = \\\\${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,\\n+              \\"modifieddate\\" = \\\\${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp\\n+          where \\"businessentityid\\" = \\\\${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND \\"emailaddressid\\" = \\\\${fromWrite(compositeId.emailaddressid)(Write.fromPut(Meta.IntMeta.put))}\\"\\"\\"\\n       .update\\n       .run\\n       .map(_ > 0)\\n    }\\n}`}\\n</CodeBlock>\\n\\nHere are the results with and without inlined implicits:\\n<ScalaCompileTimesChart id=\\"groupedBarChart3\\">{`\\nlibrary,scala version, inlined implicits, average compile time, minimum compile time\\nbaseline (only case class),scala212,false,2346,2289\\nbaseline (only case class),scala213,false,4273,2944\\nbaseline (only case class),scala3,false,4319,3050\\nzio-jdbc,scala212,false,9484,8919\\nzio-jdbc,scala213,false,10094,9058\\nzio-jdbc,scala3,false,8954,7500\\nzio-jdbc,scala212,true,8524,8250\\nzio-jdbc,scala213,true,7983,7761\\nzio-jdbc,scala3,true,7095,6954\\ndoobie (with fix),scala212,false,15463,14826\\ndoobie (with fix),scala213,false,16598,15467\\ndoobie (with fix),scala3,false,7814,7369\\ndoobie (with fix),scala212,true,8465,8213\\ndoobie (with fix),scala213,true,8560,8221\\ndoobie (with fix),scala3,true,7760,7708\\nanorm,scala212,false,9912,9378\\nanorm,scala213,false,8900,8243\\nanorm,scala3,false,7645,7179\\nanorm,scala212,true,7803,7678\\nanorm,scala213,true,7622,7593\\nanorm,scala3,true,7050,6948\\n`}</ScalaCompileTimesChart>\\n\\nThis brings the compile time for doobie down to about the same as for anorm and zio-jdbc.\\n\\nGreat! So what is going on?\\n\\nI honestly haven\'t dug into all the details, but I have a guess which looks obvious.\\nIn order to interpolate values into an SQL query, doobie needs to resolve a chain of implicits instead of just one.\\n\\nIn order to interpolate in the `emailaddress` field which has type `Option[String]`, this thing needs to be resolved:\\n<CodeBlock language=\\"scala\\">{`\\ndoobie.syntax.SqlInterpolator.SingleFragment.fromWrite(unsaved.emailaddress)(\\n  doobie.util.Write.fromPutOption(\\n    doobie.util.Put.metaProjectionWrite(\\n        doobie.util.meta.Meta.StringMeta\\n      )\\n  )\\n)\\n`}\\n</CodeBlock>\\n\\nI\'m sure this can cause the compiler to spend a lot of time looking around the companion objects of\\n`SingleFragment`, `Write`, `Put`, and `Meta`.\\n\\n<br/>\\n<KeyTakeaway>\\nMake the compiler\'s job easy! It probably shouldn\'t need to go through so many layers at all.\\n</KeyTakeaway>\\n<br/>\\n<KeyTakeaway>\\nScala 3 must have some caching of resolved implicits that Scala 2.x doesn\'t have.\\n</KeyTakeaway>\\n<br/>\\n\\n## Future work on benchmark\\n\\nHere are other things things I\'ve done to speed up compilation of generated code, based on observations as I was developing.\\nA future version of the benchmark could measure the effect of these changes as well. Reach out if you\'re interesting in contributing towards this.\\n\\n### Avoiding anonymous classes\\nLet\'s have a look at the code for `doobie.postgres.Text[A]`, it\'s basically this:\\n```scala\\ntrait Text[A] { outer =>\\n  def unsafeEncode(a: A, sb: StringBuilder): Unit\\n}\\nobject Text {\\n  def instance[A](f: (A, StringBuilder) => Unit): Text[A] =\\n    new Text[A] {\\n      def unsafeEncode(a: A, sb: StringBuilder) = f(a, sb)\\n    }\\n}\\n```\\nUsing `Text.instance` instead of `new Text[A]` saves some compilation because it generates less bytecode, though I don\'t have a benchmark for it.\\nIf you\'re a library author you should consider adding such a constructor method.\\n\\n### Avoiding automatic derivation of product type class instances\\nTypo reimplements the derivation of type class instances for product types, so the benchmark cannot measure the cost of this so far.\\nIf you expand `EmailaddressRow.scala` above, you\'ll see that `Read[EmailaddressRow]` is always implemented as `new Read(...)`.\\n\\nIt would be very interesting to measure the cost of deriving this automatically as well, we just need to patch `Typo` to use `Read.derived` instead of `new Read(...)`.\\n\\n## Final results and limitations\\n\\n### JSON libraries\\nThis last graph includes compilation time for three JSON libraries as well, basically just generating type class instances for them.\\nI excluded them for the text above since there was nothing interesting to say about the results.\\nYou can see how \\"inline implicits\\" mode also speeds up compilation of these JSON codecs.\\n\\n### Benchmark limitations\\nI think part of this improvement from \\"inlined implicits\\" is due to the fact that the compiler is a bit warmer the second time around.\\n\\nNote specifically that we get faster compiles for \\"baseline\\" with \\"inlined implicits\\" mode, although the generated code is the same.\\n\\nI didn\'t bother improving the benchmark more, because the interesting things mentioned above was very visible and consistent already.\\n\\n### Final graph\\n<ScalaCompileTimesChart id=\\"groupedBarChart4\\">{`\\nlibrary,scala version, inlined implicits, average compile time, minimum compile time\\nbaseline (only case class),scala212,false,2346,2289\\nbaseline (only case class),scala213,false,4273,2944\\nbaseline (only case class),scala3,false,4319,3050\\nbaseline (only case class),scala212,true,2245,2211\\nbaseline (only case class),scala213,true,2519,2312\\nbaseline (only case class),scala3,true,2347,2205\\nzio-jdbc,scala212,false,9484,8919\\nzio-jdbc,scala213,false,10094,9058\\nzio-jdbc,scala3,false,8954,7500\\nzio-jdbc,scala212,true,8524,8250\\nzio-jdbc,scala213,true,7983,7761\\nzio-jdbc,scala3,true,7095,6954\\ndoobie (with fix),scala212,false,15463,14826\\ndoobie (with fix),scala213,false,16598,15467\\ndoobie (with fix),scala3,false,7814,7369\\ndoobie (with fix),scala212,true,8465,8213\\ndoobie (with fix),scala213,true,8560,8221\\ndoobie (with fix),scala3,true,7760,7708\\ndoobie (without fix),scala212,false,23452,22896\\ndoobie (without fix),scala213,false,26086,25723\\ndoobie (without fix),scala3,false,7862,7605\\ndoobie (without fix),scala212,true,19465,19160\\ndoobie (without fix),scala213,true,19433,19221\\ndoobie (without fix),scala3,true,7888,7721\\nanorm,scala212,false,9912,9378\\nanorm,scala213,false,8900,8243\\nanorm,scala3,false,7645,7179\\nanorm,scala212,true,7803,7678\\nanorm,scala213,true,7622,7593\\nanorm,scala3,true,7050,6948\\nzio-json,scala212,false,5282,5100\\nzio-json,scala213,false,5356,5228\\nzio-json,scala3,false,5242,5179\\nzio-json,scala212,true,4602,4517\\nzio-json,scala213,true,4287,4234\\nzio-json,scala3,true,4562,4412\\ncirce,scala212,false,4761,4621\\ncirce,scala213,false,5677,5575\\ncirce,scala3,false,4923,4892\\ncirce,scala212,true,4028,4024\\ncirce,scala213,true,3953,3825\\ncirce,scala3,true,3660,3613\\nplay-json,scala212,false,4242,4182\\nplay-json,scala213,false,4488,4211\\nplay-json,scala3,false,4089,4007\\nplay-json,scala212,true,4162,4138\\nplay-json,scala213,true,4109,3993\\nplay-json,scala3,true,3656,3641\\n`}</ScalaCompileTimesChart>\\n\\n## Reproducing the results\\nYou can clone the [repo](https://github.com/oyvindberg/typo) and run `bleep compile-benchmarks` to reproduce the results.\\nThe benchmark code can be found in [CompileBenchmark.scala](https://github.com/oyvindberg/typo/blob/main/typo-scripts/src/scala/scripts/CompileBenchmark.scala)"},{"id":"hello-zio","metadata":{"permalink":"/typo/blog/hello-zio","source":"@site/blog/2023-11-24-hello-zio.md","title":"Hello, ZIO","description":"Typo ported to ZIO","date":"2023-11-24T00:00:00.000Z","formattedDate":"November 24, 2023","tags":[{"label":"typo","permalink":"/typo/blog/tags/typo"},{"label":"zio","permalink":"/typo/blog/tags/zio"}],"readingTime":1.8,"hasTruncateMarker":true,"authors":[{"name":"\xd8yvind Raddum Berg","url":"https://github.com/oyvindberg","image_url":"https://github.com/oyvindberg.png","imageURL":"https://github.com/oyvindberg.png"}],"frontMatter":{"title":"Hello, ZIO","description":"Typo ported to ZIO","slug":"hello-zio","authors":[{"name":"\xd8yvind Raddum Berg","url":"https://github.com/oyvindberg","image_url":"https://github.com/oyvindberg.png","imageURL":"https://github.com/oyvindberg.png"}],"tags":["typo","zio"],"image":"https://i.imgur.com/mErPwqL.png","hide_table_of_contents":false},"prevItem":{"title":"The compilation cost of implicits","permalink":"/typo/blog/the-cost-of-implicits"}},"content":"Thanks to the efforts of Jules Ivanic in [PR #57](https://github.com/oyvindberg/typo/pull/57),\\nTypo now supports using `zio-jdbc` as a database library.\\n\\n### Never heard of Typo? \\n\\nYou can check out the [introduction](https://oyvindberg.github.io/typo/docs/).\\nEssentially it\'s a code generator for database access code, which makes PostgreSQL integration type-safe and wonderful to use.\\n\\n### Maturity\\nNote that `zio-jdbc` is a bit less mature than `doobie` and `anorm`, so it\'s a bit more likely to be some rough edges.\\nIn particular, it handles nullable values [imperfectly](https://github.com/zio/zio-jdbc/issues/188).\\nWe fixed a bunch of issues while working on this PR, so it should be pretty close.\\n\\n### Implemented missing features in `zio-jdbc`\\n\\n`zio-jdbc` does not support postgres arrays, and it does not support\\nthe [COPY API for streaming inserts](/docs/other-features/streaming-inserts).\\n\\nTypo outputs code which implements both of these features.\\n\\nThis can likely be upstreamed as a postgres integration module in `zio-jdbc` at some point.\\n\\n\x3c!-- truncate --\x3e\\n\\n### Repository signatures\\n\\nTo give a taste of the code you\'ll get, consider this repository definition:\\n\\n```scala\\ntrait AddressRepo {\\n  def delete(addressid: AddressId): ZIO[ZConnection, Throwable, Boolean]\\n  def delete: DeleteBuilder[AddressFields, AddressRow]\\n  def insert(unsaved: AddressRow): ZIO[ZConnection, Throwable, AddressRow]\\n  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, AddressRow], batchSize: Int): ZIO[ZConnection, Throwable, Long]\\n  def insert(unsaved: AddressRowUnsaved): ZIO[ZConnection, Throwable, AddressRow]\\n  /* NOTE: this functionality requires PostgreSQL 16 or later! */\\n  def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, AddressRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long]\\n  def select: SelectBuilder[AddressFields, AddressRow]\\n  def selectAll: ZStream[ZConnection, Throwable, AddressRow]\\n  def selectById(addressid: AddressId): ZIO[ZConnection, Throwable, Option[AddressRow]]\\n  def selectByIds(addressids: Array[AddressId]): ZStream[ZConnection, Throwable, AddressRow]\\n  def update(row: AddressRow): ZIO[ZConnection, Throwable, Boolean]\\n  def update: UpdateBuilder[AddressFields, AddressRow]\\n  def upsert(unsaved: AddressRow): ZIO[ZConnection, Throwable, UpdateResult[AddressRow]]\\n}\\n```\\n\\nNotice how the signatures use `ZIO`, `ZStream`, `ZConnection`.\\n\\n### `zio-schema` is not used\\n\\nWe opted to *not* go through zio-schema for the generated code. It was not clear that it was possible to implement all\\nPostgreSQL features through `zio-schema`, and we wanted to generate code which is as [fast to compile](/docs/other-features/faster-compilation) as possible.\\n\\n### Also support for `zio-json`\\n\\nTypo supports generating [JSON codecs](/docs/other-features/json) for all the row types..\\nThe PR also adds support for `zio-json`, so you can get codecs like this:\\n\\n```scala\\nobject AddressRow {\\n  implicit lazy val jsonDecoder: JsonDecoder[AddressRow] = ???\\n  implicit lazy val jsonEncoder: JsonEncoder[AddressRow] = ???\\n}\\n```"}]}')}}]);