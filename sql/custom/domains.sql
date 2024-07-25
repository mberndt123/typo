SELECT nsp.nspname                   as "schema?",
       typ.typname                   as "name",
       tt.typname                    as "type",
       pc.collname                   as "collation",
       typ.typnotnull                as "isNotNull",
       typ.typdefault                as "default",
       con.conname                   as "constraintName",
       pg_get_constraintdef(con.oid) as "constraintDefinition"
FROM pg_catalog.pg_type typ
         inner join pg_catalog.pg_namespace nsp ON nsp.oid = typ.typnamespace
         inner join pg_catalog.pg_type tt on typ.typbasetype = tt.oid
         left join pg_collation pc on typ.typcollation = pc.oid
         left JOIN pg_catalog.pg_constraint con ON con.contypid = typ.oid
