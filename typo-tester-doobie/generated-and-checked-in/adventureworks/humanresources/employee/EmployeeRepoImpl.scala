/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class EmployeeRepoImpl extends EmployeeRepo {
  override def delete: DeleteBuilder[EmployeeFields, EmployeeRow] = {
    DeleteBuilder("humanresources.employee", EmployeeFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from humanresources.employee where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    sql"""delete from humanresources.employee where "businessentityid" = ANY(${businessentityids})""".update.run
  }
  override def insert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow] = {
    sql"""insert into humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.nationalidnumber)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.loginid)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.jobtitle)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.birthdate)(Write.fromPut(TypoLocalDate.put))}::date, ${fromWrite(unsaved.maritalstatus)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.gender)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.hiredate)(Write.fromPut(TypoLocalDate.put))}::date, ${fromWrite(unsaved.salariedflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.vacationhours)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.sickleavehours)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.currentflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.organizationnode)(Write.fromPutOption(Meta.StringMeta.put))})
          returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"
       """.query(using EmployeeRow.read).unique
  }
  override def insert(unsaved: EmployeeRowUnsaved): ConnectionIO[EmployeeRow] = {
    val fs = List(
      Some((Fragment.const0(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const0(s""""nationalidnumber""""), fr"${fromWrite(unsaved.nationalidnumber)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""loginid""""), fr"${fromWrite(unsaved.loginid)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""jobtitle""""), fr"${fromWrite(unsaved.jobtitle)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""birthdate""""), fr"${fromWrite(unsaved.birthdate)(Write.fromPut(TypoLocalDate.put))}::date")),
      Some((Fragment.const0(s""""maritalstatus""""), fr"${fromWrite(unsaved.maritalstatus)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const0(s""""gender""""), fr"${fromWrite(unsaved.gender)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const0(s""""hiredate""""), fr"${fromWrite(unsaved.hiredate)(Write.fromPut(TypoLocalDate.put))}::date")),
      unsaved.salariedflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""salariedflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.vacationhours match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""vacationhours""""), fr"${fromWrite(value: TypoShort)(Write.fromPut(TypoShort.put))}::int2"))
      },
      unsaved.sickleavehours match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""sickleavehours""""), fr"${fromWrite(value: TypoShort)(Write.fromPut(TypoShort.put))}::int2"))
      },
      unsaved.currentflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""currentflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.organizationnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""organizationnode""""), fr"${fromWrite(value: Option[String])(Write.fromPutOption(Meta.StringMeta.put))}"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.employee default values
            returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into humanresources.employee(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"
         """
    }
    q.query(using EmployeeRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, EmployeeRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode") FROM STDIN""").copyIn(unsaved, batchSize)(using EmployeeRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, EmployeeRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using EmployeeRowUnsaved.text)
  }
  override def select: SelectBuilder[EmployeeFields, EmployeeRow] = {
    SelectBuilderSql("humanresources.employee", EmployeeFields.structure, EmployeeRow.read)
  }
  override def selectAll: Stream[ConnectionIO, EmployeeRow] = {
    sql"""select "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode" from humanresources.employee""".query(using EmployeeRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[EmployeeRow]] = {
    sql"""select "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode" from humanresources.employee where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(using EmployeeRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, EmployeeRow] = {
    sql"""select "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode" from humanresources.employee where "businessentityid" = ANY(${businessentityids})""".query(using EmployeeRow.read).stream
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, EmployeeRow]] = {
    selectByIds(businessentityids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[EmployeeFields, EmployeeRow] = {
    UpdateBuilder("humanresources.employee", EmployeeFields.structure, EmployeeRow.read)
  }
  override def update(row: EmployeeRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update humanresources.employee
          set "nationalidnumber" = ${fromWrite(row.nationalidnumber)(Write.fromPut(Meta.StringMeta.put))},
              "loginid" = ${fromWrite(row.loginid)(Write.fromPut(Meta.StringMeta.put))},
              "jobtitle" = ${fromWrite(row.jobtitle)(Write.fromPut(Meta.StringMeta.put))},
              "birthdate" = ${fromWrite(row.birthdate)(Write.fromPut(TypoLocalDate.put))}::date,
              "maritalstatus" = ${fromWrite(row.maritalstatus)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              "gender" = ${fromWrite(row.gender)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              "hiredate" = ${fromWrite(row.hiredate)(Write.fromPut(TypoLocalDate.put))}::date,
              "salariedflag" = ${fromWrite(row.salariedflag)(Write.fromPut(Flag.put))}::bool,
              "vacationhours" = ${fromWrite(row.vacationhours)(Write.fromPut(TypoShort.put))}::int2,
              "sickleavehours" = ${fromWrite(row.sickleavehours)(Write.fromPut(TypoShort.put))}::int2,
              "currentflag" = ${fromWrite(row.currentflag)(Write.fromPut(Flag.put))}::bool,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "organizationnode" = ${fromWrite(row.organizationnode)(Write.fromPutOption(Meta.StringMeta.put))}
          where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: EmployeeRow): ConnectionIO[EmployeeRow] = {
    sql"""insert into humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.nationalidnumber)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.loginid)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.jobtitle)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.birthdate)(Write.fromPut(TypoLocalDate.put))}::date,
            ${fromWrite(unsaved.maritalstatus)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.gender)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.hiredate)(Write.fromPut(TypoLocalDate.put))}::date,
            ${fromWrite(unsaved.salariedflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.vacationhours)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.sickleavehours)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.currentflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.organizationnode)(Write.fromPutOption(Meta.StringMeta.put))}
          )
          on conflict ("businessentityid")
          do update set
            "nationalidnumber" = EXCLUDED."nationalidnumber",
            "loginid" = EXCLUDED."loginid",
            "jobtitle" = EXCLUDED."jobtitle",
            "birthdate" = EXCLUDED."birthdate",
            "maritalstatus" = EXCLUDED."maritalstatus",
            "gender" = EXCLUDED."gender",
            "hiredate" = EXCLUDED."hiredate",
            "salariedflag" = EXCLUDED."salariedflag",
            "vacationhours" = EXCLUDED."vacationhours",
            "sickleavehours" = EXCLUDED."sickleavehours",
            "currentflag" = EXCLUDED."currentflag",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate",
            "organizationnode" = EXCLUDED."organizationnode"
          returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"
       """.query(using EmployeeRow.read).unique
  }
  override def upsertBatch(unsaved: List[EmployeeRow]): Stream[ConnectionIO, EmployeeRow] = {
    Update[EmployeeRow](
      s"""insert into humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")
          values (?::int4,?,?,?,?::date,?::bpchar,?::bpchar,?::date,?::bool,?::int2,?::int2,?::bool,?::uuid,?::timestamp,?)
          on conflict ("businessentityid")
          do update set
            "nationalidnumber" = EXCLUDED."nationalidnumber",
            "loginid" = EXCLUDED."loginid",
            "jobtitle" = EXCLUDED."jobtitle",
            "birthdate" = EXCLUDED."birthdate",
            "maritalstatus" = EXCLUDED."maritalstatus",
            "gender" = EXCLUDED."gender",
            "hiredate" = EXCLUDED."hiredate",
            "salariedflag" = EXCLUDED."salariedflag",
            "vacationhours" = EXCLUDED."vacationhours",
            "sickleavehours" = EXCLUDED."sickleavehours",
            "currentflag" = EXCLUDED."currentflag",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate",
            "organizationnode" = EXCLUDED."organizationnode"
          returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode""""
    )(using EmployeeRow.write)
    .updateManyWithGeneratedKeys[EmployeeRow]("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")(unsaved)(using catsStdInstancesForList, EmployeeRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, EmployeeRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table employee_TEMP (like humanresources.employee) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy employee_TEMP("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode") from stdin""").copyIn(unsaved, batchSize)(using EmployeeRow.text)
      res <- sql"""insert into humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")
                   select * from employee_TEMP
                   on conflict ("businessentityid")
                   do update set
                     "nationalidnumber" = EXCLUDED."nationalidnumber",
                     "loginid" = EXCLUDED."loginid",
                     "jobtitle" = EXCLUDED."jobtitle",
                     "birthdate" = EXCLUDED."birthdate",
                     "maritalstatus" = EXCLUDED."maritalstatus",
                     "gender" = EXCLUDED."gender",
                     "hiredate" = EXCLUDED."hiredate",
                     "salariedflag" = EXCLUDED."salariedflag",
                     "vacationhours" = EXCLUDED."vacationhours",
                     "sickleavehours" = EXCLUDED."sickleavehours",
                     "currentflag" = EXCLUDED."currentflag",
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate",
                     "organizationnode" = EXCLUDED."organizationnode"
                   ;
                   drop table employee_TEMP;""".update.run
    } yield res
  }
}
