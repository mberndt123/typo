/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success

case class ForeignDataWrappersRow(
  /** Points to [[PgForeignDataWrappersRow.foreignDataWrapperCatalog]] */
  foreignDataWrapperCatalog: Option[String],
  /** Points to [[PgForeignDataWrappersRow.foreignDataWrapperName]] */
  foreignDataWrapperName: Option[String],
  /** Points to [[PgForeignDataWrappersRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[String],
  libraryName: /* unknown nullability */ Option[String],
  /** Points to [[PgForeignDataWrappersRow.foreignDataWrapperLanguage]] */
  foreignDataWrapperLanguage: Option[String]
)

object ForeignDataWrappersRow {
  implicit val rowParser: RowParser[ForeignDataWrappersRow] = { row =>
    Success(
      ForeignDataWrappersRow(
        foreignDataWrapperCatalog = row[Option[String]]("foreign_data_wrapper_catalog"),
        foreignDataWrapperName = row[Option[String]]("foreign_data_wrapper_name"),
        authorizationIdentifier = row[Option[String]]("authorization_identifier"),
        libraryName = row[/* unknown nullability */ Option[String]]("library_name"),
        foreignDataWrapperLanguage = row[Option[String]]("foreign_data_wrapper_language")
      )
    )
  }

  
}
