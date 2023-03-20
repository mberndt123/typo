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

case class AdministrableRoleAuthorizationsRow(
  /** Points to [[ApplicableRolesRow.grantee]] */
  grantee: Option[String],
  /** Points to [[ApplicableRolesRow.roleName]] */
  roleName: Option[String],
  /** Points to [[ApplicableRolesRow.isGrantable]] */
  isGrantable: Option[String]
)

object AdministrableRoleAuthorizationsRow {
  implicit val rowParser: RowParser[AdministrableRoleAuthorizationsRow] = { row =>
    Success(
      AdministrableRoleAuthorizationsRow(
        grantee = row[Option[String]]("grantee"),
        roleName = row[Option[String]]("role_name"),
        isGrantable = row[Option[String]]("is_grantable")
      )
    )
  }

  
}
