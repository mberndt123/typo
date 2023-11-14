/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelcatalogdescription

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class VproductmodelcatalogdescriptionViewRepoImpl extends VproductmodelcatalogdescriptionViewRepo {
  override def select: SelectBuilder[VproductmodelcatalogdescriptionViewFields, VproductmodelcatalogdescriptionViewRow] = {
    SelectBuilderSql("production.vproductmodelcatalogdescription", VproductmodelcatalogdescriptionViewFields, VproductmodelcatalogdescriptionViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[VproductmodelcatalogdescriptionViewRow] = {
    SQL"""select "productmodelid", "name", "Summary", "manufacturer", "copyright", "producturl", "warrantyperiod", "warrantydescription", "noofyears", "maintenancedescription", "wheel", "saddle", "pedal", "bikeframe", "crankset", "pictureangle", "picturesize", "productphotoid", "material", "color", "productline", "style", "riderexperience", "rowguid", "modifieddate"::text
          from production.vproductmodelcatalogdescription
       """.as(VproductmodelcatalogdescriptionViewRow.rowParser(1).*)
  }
}
