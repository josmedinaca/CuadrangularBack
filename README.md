# CuadrangularBack
![alt text](https://github.com/josmedinaca/CuadrangularBack/blob/master/Captura.PNG)

## Comenzando 🚀

Instrucciones para obtener una copia del proyecto en funcionamiento en una máquina local para propósitos de desarrollo y pruebas.


### Pre-requisitos 📋

_Cosas necesarias para instalar el software y como instalarlas_

```
Docker versión 3
```

### Instalación 🔧

Construir la imagen de Docker Compose y crear la base datos oas
Ejecutar estas lineas una a una

```
docker-compose up -d
docker exec -it postgres psql -U postgres
ALTER  USER postgres  WITH PASSWORD 'root';
CREATE DATABASE oas;
\c oas
```

Las siguientes lineas pueden ejecutarse todas de una ves

```
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

CREATE SEQUENCE public.equipo_id_equipo_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.equipo_id_equipo_seq
    OWNER TO postgres;

CREATE SEQUENCE public.partido_id_partido_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.partido_id_partido_seq
    OWNER TO postgres;
	
CREATE SEQUENCE public.puntuacion_id_puntuacion_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE public.puntuacion_id_puntuacion_seq
    OWNER TO postgres;

\q
```

_Subir el Docker Compose_

```
docker-compose up
```

_El servidor se ejecuta en el puerto 6673
_http://localhost:8082/

## Construido con 🛠️

_Herramientas_

* [Spring Framework](https://beego.me/) - The Spring Framework is an application framework and inversion of control container for the Java platform.
* [PostgreSQL](https://www.postgresql.org/) - is a free and open-source relational database management system emphasizing extensibility and SQL compliance.

## Autor ✒️

* Johan Medina Cañizares - [josmedinaca](https://github.com/josmedinaca)