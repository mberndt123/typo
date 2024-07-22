/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person.personphone;

import adventureworks.customtypes.Defaulted;
import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.businessentity.BusinessentityId;
import adventureworks.person.phonenumbertype.PhonenumbertypeId;
import adventureworks.public.Phone;
import cats.instances.list.catsStdInstancesForList;
import doobie.free.connection.ConnectionIO;
import doobie.postgres.syntax.FragmentOps;
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite;
import doobie.syntax.string.toSqlInterpolator;
import doobie.util.Write;
import doobie.util.fragment.Fragment;
import doobie.util.update.Update;
import fs2.Stream;
import typo.dsl.DeleteBuilder;
import typo.dsl.SelectBuilder;
import typo.dsl.SelectBuilderSql;
import typo.dsl.UpdateBuilder;

class PersonphoneRepoImpl extends PersonphoneRepo {
  def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow] = DeleteBuilder("person.personphone", PersonphoneFields.structure)
  def deleteById(compositeId: PersonphoneId): ConnectionIO[Boolean] = sql"""delete from person.personphone where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "phonenumber" = ${fromWrite(compositeId.phonenumber)(Write.fromPut(Phone.put))} AND "phonenumbertypeid" = ${fromWrite(compositeId.phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.put))}""".update.run.map(_ > 0)
  def deleteByIds(compositeIds: Array[PersonphoneId]): ConnectionIO[Int] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val phonenumber = compositeIds.map(_.phonenumber)
    val phonenumbertypeid = compositeIds.map(_.phonenumbertypeid)
    sql"""delete
          from person.personphone
          where ("businessentityid", "phonenumber", "phonenumbertypeid")
          in (select unnest(${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.arrayPut))}), unnest(${fromWrite(phonenumber)(Write.fromPut(Phone.arrayPut))}), unnest(${fromWrite(phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.arrayPut))}))
       """.update.run
  
  }
  def insert(unsaved: PersonphoneRow): ConnectionIO[PersonphoneRow] = {
    sql"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.phonenumber)(Write.fromPut(Phone.put))}::varchar, ${fromWrite(unsaved.phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.put))}::int4, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
       """.query(using PersonphoneRow.read).unique
  }
  def insert(unsaved: PersonphoneRowUnsaved): ConnectionIO[PersonphoneRow] = {
    val fs = List(
      Some((Fragment.const0(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
                      Some((Fragment.const0(s""""phonenumber""""), fr"${fromWrite(unsaved.phonenumber)(Write.fromPut(Phone.put))}::varchar")),
                      Some((Fragment.const0(s""""phonenumbertypeid""""), fr"${fromWrite(unsaved.phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.put))}::int4")),
    unsaved.modifieddate match {
      case Defaulted.UseDefault() => None
      case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
    }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.personphone default values
                            returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
                         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.personphone(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
                            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
                            returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
                         """
    }
    q.query(using PersonphoneRow.read).unique
  
  }
  def insertStreaming(unsaved: Stream[ConnectionIO, PersonphoneRow], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using PersonphoneRow.text)
  /** NOTE: this functionality requires PostgreSQL 16 or later! */
  def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersonphoneRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = new FragmentOps(sql"""COPY person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using PersonphoneRowUnsaved.text)
  def select: SelectBuilder[PersonphoneFields, PersonphoneRow] = SelectBuilderSql("person.personphone", PersonphoneFields.structure, PersonphoneRow.read)
  def selectAll: Stream[ConnectionIO, PersonphoneRow] = sql"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text from person.personphone""".query(using PersonphoneRow.read).stream
  def selectById(compositeId: PersonphoneId): ConnectionIO[Option[PersonphoneRow]] = sql"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text from person.personphone where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "phonenumber" = ${fromWrite(compositeId.phonenumber)(Write.fromPut(Phone.put))} AND "phonenumbertypeid" = ${fromWrite(compositeId.phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.put))}""".query(using PersonphoneRow.read).option
  def selectByIds(compositeIds: Array[PersonphoneId]): Stream[ConnectionIO, PersonphoneRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val phonenumber = compositeIds.map(_.phonenumber)
    val phonenumbertypeid = compositeIds.map(_.phonenumbertypeid)
    sql"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
          from person.personphone
          where ("businessentityid", "phonenumber", "phonenumbertypeid")
          in (select unnest(${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.arrayPut))}), unnest(${fromWrite(phonenumber)(Write.fromPut(Phone.arrayPut))}), unnest(${fromWrite(phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.arrayPut))}))
       """.query(using PersonphoneRow.read).stream
  
  }
  def selectByIdsTracked(compositeIds: Array[PersonphoneId]): ConnectionIO[Map[PersonphoneId, PersonphoneRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  def update: UpdateBuilder[PersonphoneFields, PersonphoneRow] = UpdateBuilder("person.personphone", PersonphoneFields.structure, PersonphoneRow.read)
  def update(row: PersonphoneRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.personphone
                          set "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
                          where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "phonenumber" = ${fromWrite(compositeId.phonenumber)(Write.fromPut(Phone.put))} AND "phonenumbertypeid" = ${fromWrite(compositeId.phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  def upsert(unsaved: PersonphoneRow): ConnectionIO[PersonphoneRow] = {
    sql"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.phonenumber)(Write.fromPut(Phone.put))}::varchar,
            ${fromWrite(unsaved.phonenumbertypeid)(Write.fromPut(PhonenumbertypeId.put))}::int4,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid", "phonenumber", "phonenumbertypeid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
       """.query(using PersonphoneRow.read).unique
  }
  def upsertBatch(unsaved: List[PersonphoneRow]): Stream[ConnectionIO, PersonphoneRow] = {
    Update[PersonphoneRow](
      s"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
          values (?::int4,?::varchar,?::int4,?::timestamp)
          on conflict ("businessentityid", "phonenumber", "phonenumbertypeid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text"""
    )(using PersonphoneRow.write)
    .updateManyWithGeneratedKeys[PersonphoneRow]("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")(unsaved)(using catsStdInstancesForList, PersonphoneRow.read)
  }
  /** NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: Stream[ConnectionIO, PersonphoneRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table personphone_TEMP (like person.personphone) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy personphone_TEMP("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using PersonphoneRow.text)
      res <- sql"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
                   select * from personphone_TEMP
                   on conflict ("businessentityid", "phonenumber", "phonenumbertypeid")
                   do update set
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table personphone_TEMP;""".update.run
    } yield res
  }
}