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

case class UserMappingOptionsRow(
  /** Points to [[PgUserMappingsRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[String],
  /** Points to [[PgUserMappingsRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[String],
  /** Points to [[PgUserMappingsRow.foreignServerName]] */
  foreignServerName: Option[String],
  optionName: /* unknown nullability */ Option[String],
  optionValue: /* unknown nullability */ Option[String]
)

object UserMappingOptionsRow {
  implicit val rowParser: RowParser[UserMappingOptionsRow] = { row =>
    Success(
      UserMappingOptionsRow(
        authorizationIdentifier = row[Option[String]]("authorization_identifier"),
        foreignServerCatalog = row[Option[String]]("foreign_server_catalog"),
        foreignServerName = row[Option[String]]("foreign_server_name"),
        optionName = row[/* unknown nullability */ Option[String]]("option_name"),
        optionValue = row[/* unknown nullability */ Option[String]]("option_value")
      )
    )
  }

  
}
