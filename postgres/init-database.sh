#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    ALTER  USER postgres  WITH PASSWORD 'root';
	CREATE DATABASE osa;
    GRANT ALL PRIVILEGES ON DATABASE osa TO postgres;
    CREATE TABLE IF NOT EXISTS "oas"."public"."equipo" (
	  "id_equipo" SERIAL       NOT NULL,
	  PRIMARY KEY ("id_equipo"),
	  "nombre" VARCHAR(100) NOT NULL,
	  "ciudad" VARCHAR(100) NOT NULL,
	  "correo" VARCHAR(100) NOT NULL
	);

	CREATE TABLE IF NOT EXISTS "oas"."public"."partido" (
	  "id_partido" SERIAL       NOT NULL,
	  PRIMARY KEY ("id_partido"),
	  "goles_local" INT ,
	  "goles_adversario" INT ,
	  "id_equi_local" INT       NOT NULL,
	  CONSTRAINT "id_equi_local_FK"
			FOREIGN KEY ("id_equi_local")
				REFERENCES "oas"."public"."equipo" ("id_equipo")
				ON DELETE NO ACTION
				ON UPDATE NO ACTION,
	  "id_equi_adversario" INT       NOT NULL,
	  CONSTRAINT "id_equi_adversario_FK"
			FOREIGN KEY ("id_equi_adversario")
				REFERENCES "oas"."public"."equipo" ("id_equipo")
				ON DELETE NO ACTION
				ON UPDATE NO ACTION
	);



	CREATE TABLE IF NOT EXISTS "oas"."public"."puntuacion" (
	  "id_puntuacion" SERIAL       NOT NULL,
	  PRIMARY KEY ("id_puntuacion"),
	  "id_equipo" INT NOT NULL,
	   CONSTRAINT "id_equipo_FK"
			FOREIGN KEY ("id_equipo")
				REFERENCES "oas"."public"."equipo" ("id_equipo")
				ON DELETE NO ACTION
				ON UPDATE NO ACTION,
		"puntuacion" INT       NOT NULL
	);





EOSQL