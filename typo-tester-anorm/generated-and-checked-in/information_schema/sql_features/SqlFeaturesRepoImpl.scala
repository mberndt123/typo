/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_features

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

object SqlFeaturesRepoImpl extends SqlFeaturesRepo {
  override def delete: DeleteBuilder[SqlFeaturesFields, SqlFeaturesRow] = {
    DeleteBuilder("information_schema.sql_features", SqlFeaturesFields)
  }
  override def insert(unsaved: SqlFeaturesRow)(implicit c: Connection): SqlFeaturesRow = {
    SQL"""insert into information_schema.sql_features(feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments")
          values (${ParameterValue(unsaved.featureId, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.featureName, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.subFeatureId, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.subFeatureName, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.isSupported, null, ToStatement.optionToStatement(YesOrNo.toStatement, YesOrNo.parameterMetadata))}::information_schema.yes_or_no, ${ParameterValue(unsaved.isVerifiedBy, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data, ${ParameterValue(unsaved.comments, null, ToStatement.optionToStatement(CharacterData.toStatement, CharacterData.parameterMetadata))}::information_schema.character_data)
          returning feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments"
       """
      .executeInsert(SqlFeaturesRow.rowParser(1).single)
    
  }
  override def select: SelectBuilder[SqlFeaturesFields, SqlFeaturesRow] = {
    SelectBuilderSql("information_schema.sql_features", SqlFeaturesFields, SqlFeaturesRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SqlFeaturesRow] = {
    SQL"""select feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments"
          from information_schema.sql_features
       """.as(SqlFeaturesRow.rowParser(1).*)
  }
  override def update: UpdateBuilder[SqlFeaturesFields, SqlFeaturesRow] = {
    UpdateBuilder("information_schema.sql_features", SqlFeaturesFields, SqlFeaturesRow.rowParser)
  }
}
