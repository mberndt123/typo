/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_parts

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.YesOrNo
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SqlPartsRepoImpl extends SqlPartsRepo {
  override def delete: DeleteBuilder[SqlPartsFields, SqlPartsRow] = {
    DeleteBuilder("information_schema.sql_parts", SqlPartsFields)
  }
  override def insert(unsaved: SqlPartsRow)(implicit c: Connection): SqlPartsRow = {
    SQL"""insert into information_schema.sql_parts(feature_id, feature_name, is_supported, is_verified_by, "comments")
          values (${ParameterValue(unsaved.featureId, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.featureName, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.isSupported, null, ToStatement.optionToStatement(YesOrNo.toStatement, YesOrNo.parameterMetadata))}::information_schema.yes_or_no, ${ParameterValue(unsaved.isVerifiedBy, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.comments, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data)
          returning feature_id, feature_name, is_supported, is_verified_by, "comments"
       """
      .executeInsert(SqlPartsRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[SqlPartsFields, SqlPartsRow] = {
    SelectBuilderSql("information_schema.sql_parts", SqlPartsFields, SqlPartsRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SqlPartsRow] = {
    SQL"""select feature_id, feature_name, is_supported, is_verified_by, "comments"
          from information_schema.sql_parts
       """.as(SqlPartsRow.rowParser(1).*)
  }
  override def update: UpdateBuilder[SqlPartsFields, SqlPartsRow] = {
    UpdateBuilder("information_schema.sql_parts", SqlPartsFields, SqlPartsRow.rowParser)
  }
}
