-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2018-11-14 22:47:23 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Producto
  (
    id_prod     INTEGER NOT NULL ,
    nombre_prod VARCHAR2 (50 BYTE) ,
    desc_prod CLOB ,
    preccomp_prod    NUMBER (8,2) ,
    preven_prod      NUMBER (8,2) ,
    categoria_id_cat INTEGER ,
    cant_prod        INTEGER ,
    imagen_prod BLOB ,
    id_alm INTEGER
  ) ;
COMMENT ON COLUMN Producto.imagen_prod
IS
  'imagen de la producto' ;
ALTER TABLE Producto ADD CONSTRAINT Producto_PK PRIMARY KEY ( id_prod ) ;


CREATE TABLE almacen
  (
    id_alm       INTEGER NOT NULL ,
    captotal_alm INTEGER ,
    capocu_alm   INTEGER
  ) ;
ALTER TABLE almacen ADD CONSTRAINT almacen_PK PRIMARY KEY ( id_alm ) ;


CREATE TABLE categoria
  (
    id_cat  INTEGER NOT NULL ,
    nom_cat VARCHAR2 (50) ,
    desc_cat CLOB
  ) ;
ALTER TABLE categoria ADD CONSTRAINT categoria_PK PRIMARY KEY ( id_cat ) ;


CREATE TABLE cliente
  (
    id_cli         INTEGER NOT NULL ,
    nomemp_cli     VARCHAR2 (30 BYTE) ,
    persona_id_per INTEGER NOT NULL ,
    codpostal_cli  CHAR (5)
  ) ;
CREATE UNIQUE INDEX cliente__IDX ON cliente
  (
    persona_id_per ASC
  )
  ;
ALTER TABLE cliente ADD CONSTRAINT cliente_PK PRIMARY KEY ( id_cli ) ;


CREATE TABLE comprar
  (
    Producto_id_prod   INTEGER NOT NULL ,
    proveedor_id_prove INTEGER NOT NULL ,
    prec_compra        NUMBER (8,2) ,
    cant_compra        NUMBER ,
    fecha_compra       DATE
  ) ;
COMMENT ON COLUMN comprar.prec_compra
IS
  'precio de compra de del producto en bruto' ;
  COMMENT ON COLUMN comprar.cant_compra
IS
  'Kg del material comprado' ;
  COMMENT ON COLUMN comprar.fecha_compra
IS
  'fecha de la compra del material bruro' ;
ALTER TABLE comprar ADD CONSTRAINT comprar_PK PRIMARY KEY ( Producto_id_prod, proveedor_id_prove ) ;


CREATE TABLE empleado
  (
    id_emp             INTEGER NOT NULL ,
    sexo_emp           CHAR (1 CHAR) ,
    estcivi_emp        VARCHAR2 (15 BYTE) ,
    persona_id_per     INTEGER NOT NULL ,
    tipocargo_id_cargo INTEGER NOT NULL
  ) ;
CREATE UNIQUE INDEX empleado__IDXv1 ON empleado
  (
    persona_id_per ASC
  )
  ;
ALTER TABLE empleado ADD CONSTRAINT empleado_PK PRIMARY KEY ( id_emp ) ;


CREATE TABLE nacionalidad
  (
    id_nadad   INTEGER NOT NULL ,
    pais_nadad VARCHAR2 (20 BYTE) ,
    nac_nadad  VARCHAR2 (40 BYTE)
  ) ;
ALTER TABLE nacionalidad ADD CONSTRAINT nacionalidad_PK PRIMARY KEY ( id_nadad ) ;


CREATE TABLE persona
  (
    id_per                INTEGER NOT NULL ,
    nom_per               VARCHAR2 (50 BYTE) ,
    apepat_per            VARCHAR2 (50 BYTE) ,
    apemat_per            VARCHAR2 (50 BYTE) ,
    fechanac_per          DATE ,
    dir_per               VARCHAR2 (100 BYTE) ,
    tel_per               CHAR (7 CHAR) ,
    cel_per               CHAR (9 CHAR) ,
    dni_per               CHAR (8 CHAR) ,
    pasa_per              CHAR (20 BYTE) ,
    usu_per               VARCHAR2 (50 BYTE) ,
    contra_per            VARCHAR2 (50 BYTE) ,
    email_per             VARCHAR2 (40 BYTE) ,
    nacionalidad_id_nadad INTEGER
  ) ;
ALTER TABLE persona ADD CONSTRAINT persona_PK PRIMARY KEY ( id_per ) ;


CREATE TABLE proveedor
  (
    id_prove                    INTEGER NOT NULL ,
    persona_id_per              INTEGER NOT NULL ,
    tipoproductobruto_id_tbruto INTEGER NOT NULL
  ) ;
CREATE UNIQUE INDEX proveedor__IDX ON proveedor
  (
    persona_id_per ASC
  )
  ;
ALTER TABLE proveedor ADD CONSTRAINT proveedor_PK PRIMARY KEY ( id_prove ) ;


CREATE TABLE tipocargo
  (
    id_cargo  INTEGER NOT NULL ,
    nom_cargo VARCHAR2 (20 BYTE)
  ) ;
ALTER TABLE tipocargo ADD CONSTRAINT tipocargo_PK PRIMARY KEY ( id_cargo ) ;


CREATE TABLE tipoproductobruto
  (
    id_tbruto  INTEGER NOT NULL ,
    nom_tbruto VARCHAR2 (20 BYTE)
  ) ;
ALTER TABLE tipoproductobruto ADD CONSTRAINT tipoproductobruto_PK PRIMARY KEY ( id_tbruto ) ;


CREATE TABLE vender
  (
    id_venta         INTEGER NOT NULL ,
    cliente_id_cli   INTEGER NOT NULL ,
    Producto_id_prod INTEGER NOT NULL ,
    prec_venta       NUMBER (8,2) ,
    cant_venta       NUMBER ,
    fecha_venta      DATE NOT NULL
  ) ;
COMMENT ON COLUMN vender.id_venta
IS
  'id de la venta realizada' ;
  COMMENT ON COLUMN vender.prec_venta
IS
  'precio de la venta en un momento específico' ;
  COMMENT ON COLUMN vender.cant_venta
IS
  'kg que se venden del producto específico' ;
  COMMENT ON COLUMN vender.fecha_venta
IS
  'fecha y hora de la compra' ;
ALTER TABLE vender ADD CONSTRAINT vender_PK PRIMARY KEY ( cliente_id_cli, Producto_id_prod, id_venta ) ;


ALTER TABLE vender ADD CONSTRAINT FK_ASS_16 FOREIGN KEY ( cliente_id_cli ) REFERENCES cliente ( id_cli ) ;

ALTER TABLE vender ADD CONSTRAINT FK_ASS_17 FOREIGN KEY ( Producto_id_prod ) REFERENCES Producto ( id_prod ) ;

ALTER TABLE comprar ADD CONSTRAINT FK_ASS_6 FOREIGN KEY ( Producto_id_prod ) REFERENCES Producto ( id_prod ) ;

ALTER TABLE comprar ADD CONSTRAINT FK_ASS_7 FOREIGN KEY ( proveedor_id_prove ) REFERENCES proveedor ( id_prove ) ;

ALTER TABLE Producto ADD CONSTRAINT Producto_categoria_FK FOREIGN KEY ( categoria_id_cat ) REFERENCES categoria ( id_cat ) ;

ALTER TABLE Producto ADD CONSTRAINT almacenar FOREIGN KEY ( id_alm ) REFERENCES almacen ( id_alm ) ;

ALTER TABLE cliente ADD CONSTRAINT cliente_persona_FK FOREIGN KEY ( persona_id_per ) REFERENCES persona ( id_per ) ;

ALTER TABLE empleado ADD CONSTRAINT empleado_persona_FK FOREIGN KEY ( persona_id_per ) REFERENCES persona ( id_per ) ;

ALTER TABLE empleado ADD CONSTRAINT empleado_tipocargo_FK FOREIGN KEY ( tipocargo_id_cargo ) REFERENCES tipocargo ( id_cargo ) ;

ALTER TABLE persona ADD CONSTRAINT persona_nacionalidad_FK FOREIGN KEY ( nacionalidad_id_nadad ) REFERENCES nacionalidad ( id_nadad ) ;

ALTER TABLE proveedor ADD CONSTRAINT proveedor_persona_FK FOREIGN KEY ( persona_id_per ) REFERENCES persona ( id_per ) ;

ALTER TABLE proveedor ADD CONSTRAINT proveedor_tipoproductobruto_FK FOREIGN KEY ( tipoproductobruto_id_tbruto ) REFERENCES tipoproductobruto ( id_tbruto ) ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            12
-- CREATE INDEX                             3
-- ALTER TABLE                             24
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
