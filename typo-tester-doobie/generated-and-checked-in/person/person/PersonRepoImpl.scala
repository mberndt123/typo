/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PersonRepoImpl extends PersonRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"delete from person.person where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("person.person", PersonFields)
  }
  override def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into person.person(businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate)
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.namestyle)(Write.fromPut(NameStyle.put))}::"public".NameStyle, ${fromWrite(unsaved.title)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.firstname)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.middlename)(Write.fromPutOption(Name.put))}::"public"."Name", ${fromWrite(unsaved.lastname)(Write.fromPut(Name.put))}::"public"."Name", ${fromWrite(unsaved.suffix)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.emailpromotion)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate::text
       """.query(PersonRow.read).unique
  }
  override def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s"persontype"), fr"${fromWrite(unsaved.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const(s"title"), fr"${fromWrite(unsaved.title)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"firstname"), fr"""${fromWrite(unsaved.firstname)(Write.fromPut(Name.put))}::"public"."Name"""")),
      Some((Fragment.const(s"middlename"), fr"""${fromWrite(unsaved.middlename)(Write.fromPutOption(Name.put))}::"public"."Name"""")),
      Some((Fragment.const(s"lastname"), fr"""${fromWrite(unsaved.lastname)(Write.fromPut(Name.put))}::"public"."Name"""")),
      Some((Fragment.const(s"suffix"), fr"${fromWrite(unsaved.suffix)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"additionalcontactinfo"), fr"${fromWrite(unsaved.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml")),
      Some((Fragment.const(s"demographics"), fr"${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml")),
      unsaved.namestyle match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"namestyle"), fr"""${fromWrite(value: NameStyle)(Write.fromPut(NameStyle.put))}::"public".NameStyle"""))
      },
      unsaved.emailpromotion match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"emailpromotion"), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.person default values
            returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.person(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate::text
         """
    }
    q.query(PersonRow.read).unique
    
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("person.person", PersonFields, PersonRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PersonRow] = {
    sql"select businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate::text from person.person".query(PersonRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PersonRow]] = {
    sql"select businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate::text from person.person where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}".query(PersonRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PersonRow] = {
    sql"select businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate::text from person.person where businessentityid = ANY(${businessentityids})".query(PersonRow.read).stream
  }
  override def update(row: PersonRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.person
          set persontype = ${fromWrite(row.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              namestyle = ${fromWrite(row.namestyle)(Write.fromPut(NameStyle.put))}::"public".NameStyle,
              title = ${fromWrite(row.title)(Write.fromPutOption(Meta.StringMeta.put))},
              firstname = ${fromWrite(row.firstname)(Write.fromPut(Name.put))}::"public"."Name",
              middlename = ${fromWrite(row.middlename)(Write.fromPutOption(Name.put))}::"public"."Name",
              lastname = ${fromWrite(row.lastname)(Write.fromPut(Name.put))}::"public"."Name",
              suffix = ${fromWrite(row.suffix)(Write.fromPutOption(Meta.StringMeta.put))},
              emailpromotion = ${fromWrite(row.emailpromotion)(Write.fromPut(Meta.IntMeta.put))}::int4,
              additionalcontactinfo = ${fromWrite(row.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml,
              demographics = ${fromWrite(row.demographics)(Write.fromPutOption(TypoXml.put))}::xml,
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where businessentityid = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("person.person", PersonFields, PersonRow.read)
  }
  override def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into person.person(businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.namestyle)(Write.fromPut(NameStyle.put))}::"public".NameStyle,
            ${fromWrite(unsaved.title)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.firstname)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.middlename)(Write.fromPutOption(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.lastname)(Write.fromPut(Name.put))}::"public"."Name",
            ${fromWrite(unsaved.suffix)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.emailpromotion)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml,
            ${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (businessentityid)
          do update set
            persontype = EXCLUDED.persontype,
            namestyle = EXCLUDED.namestyle,
            title = EXCLUDED.title,
            firstname = EXCLUDED.firstname,
            middlename = EXCLUDED.middlename,
            lastname = EXCLUDED.lastname,
            suffix = EXCLUDED.suffix,
            emailpromotion = EXCLUDED.emailpromotion,
            additionalcontactinfo = EXCLUDED.additionalcontactinfo,
            demographics = EXCLUDED.demographics,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate::text
       """.query(PersonRow.read).unique
  }
}
