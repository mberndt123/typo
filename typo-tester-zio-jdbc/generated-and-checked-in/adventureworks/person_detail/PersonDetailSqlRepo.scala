/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks.person_detail;

import adventureworks.customtypes.TypoLocalDateTime;
import adventureworks.person.businessentity.BusinessentityId;
import zio.jdbc.ZConnection;
import zio.stream.ZStream;

trait PersonDetailSqlRepo {
  def apply(businessentityid: /* user-picked */ BusinessentityId, modifiedAfter: TypoLocalDateTime): ZStream[ZConnection, Throwable, PersonDetailSqlRow]
}