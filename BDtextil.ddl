-- Generado por Oracle SQL Developer Data Modeler 18.3.0.268.1208
--   en:        2018-12-02 19:13:48 COT
--   sitio:      Oracle Database 10g
--   tipo:      Oracle Database 10g



CREATE TABLE camion (
    mat_car    CHAR(7) NOT NULL,
    mod_car    VARCHAR2(50),
    tipo_car   VARCHAR2(50),
    pot_car    CHAR(5)
);

ALTER TABLE camion ADD CONSTRAINT xpkcamion PRIMARY KEY ( mat_car );

CREATE TABLE camionero (
    dni_cam     CHAR(8) NOT NULL,
    nom_cam     VARCHAR2(50),
    ape_cam     VARCHAR2(50),
    telef_cam   CHAR(9),
    dir_cam     VARCHAR2(100),
    sal_cam     INTEGER,
    pob_cam     VARCHAR2(30)
);

ALTER TABLE camionero ADD CONSTRAINT xpkcamionero PRIMARY KEY ( dni_cam );

CREATE TABLE cargo (
    cod_carg   CHAR(2) NOT NULL,
    dni_jef    CHAR(8) NOT NULL,
    nom_carg   VARCHAR2(20),
    dni_emp    CHAR(8) NOT NULL
);

ALTER TABLE cargo ADD CONSTRAINT xpkcargo PRIMARY KEY ( cod_carg );

CREATE TABLE cliente (
    dni_clie     CHAR(8) NOT NULL,
    nom_clie     VARCHAR2(50),
    ape_clie     VARCHAR2(50),
    dir_clie     VARCHAR2(50),
    telef_clie   CHAR(9)
);

ALTER TABLE cliente ADD CONSTRAINT xpkcliente PRIMARY KEY ( dni_clie );

CREATE TABLE compra (
    dni_clie    CHAR(8) NOT NULL,
    cod_prod    CHAR(5) NOT NULL,
    fecha_com   DATE NOT NULL,
    cant_com    DATE NOT NULL
);

ALTER TABLE compra ADD CONSTRAINT xpkcompra PRIMARY KEY ( dni_clie,
                                                          cod_prod );

CREATE TABLE conduce (
    mat_car       CHAR(7) NOT NULL,
    dni_cam       CHAR(8) NOT NULL,
    fstart_con    DATE,
    ffinish_con   DATE,
    partida_con   VARCHAR2(30),
    llegada_con   VARCHAR2(30)
);

ALTER TABLE conduce ADD CONSTRAINT xpkconduce PRIMARY KEY ( mat_car,
                                                            dni_cam );

CREATE TABLE empleado (
    dni_emp     CHAR(8) NOT NULL,
    nom_emp     VARCHAR2(50),
    ape_emp     VARCHAR2(50),
    telef_emp   CHAR(9),
    dir_emp     VARCHAR2(100),
    user_emp    VARCHAR2(50),
    pass_emp    VARCHAR2(50)
);

ALTER TABLE empleado ADD CONSTRAINT xpkempleado PRIMARY KEY ( dni_emp );

CREATE TABLE jefearea (
    dni_jef     CHAR(8) NOT NULL,
    nom_jef     VARCHAR2(50),
    ape_jef     VARCHAR2(50),
    telef_jef   CHAR(9),
    dir_jef     VARCHAR2(100),
    user_jef    VARCHAR2(50),
    pass_jef    VARCHAR2(50)
);

ALTER TABLE jefearea ADD CONSTRAINT xpkjefearea PRIMARY KEY ( dni_jef );

CREATE TABLE producto (
    cod_prod    CHAR(5) NOT NULL,
    nom_prod    VARCHAR2(50),
    prec_prod   INTEGER,
    desc_prod   VARCHAR2(50),
    cod_provi   INTEGER NOT NULL,
    dni_emp     CHAR(8) NOT NULL,
    nif_prove   VARCHAR2(20) NOT NULL,
    dni_cam     CHAR(8) NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT xpkproducto PRIMARY KEY ( cod_prod );

CREATE TABLE proveedor (
    nif_prove   VARCHAR2(20) NOT NULL,
    nom_prov    VARCHAR2(50),
    dir_prov    VARCHAR2(50)
);

ALTER TABLE proveedor ADD CONSTRAINT xpkproveedor PRIMARY KEY ( nif_prove );

CREATE TABLE provincia (
    cod_provi   INTEGER NOT NULL,
    nom_provi   VARCHAR2(50)
);

ALTER TABLE provincia ADD CONSTRAINT xpkprovincia PRIMARY KEY ( cod_provi );


     
ALTER TABLE producto
    ADD CONSTRAINT "R/9" FOREIGN KEY ( cod_provi )
        REFERENCES provincia ( cod_provi );

ALTER TABLE cargo
    ADD CONSTRAINT "R/1" FOREIGN KEY ( dni_jef )
        REFERENCES jefearea ( dni_jef );

ALTER TABLE cargo
    ADD CONSTRAINT "R/2" FOREIGN KEY ( dni_emp )
        REFERENCES empleado ( dni_emp );

ALTER TABLE compra
    ADD CONSTRAINT "R/3" FOREIGN KEY ( dni_clie )
        REFERENCES cliente ( dni_clie );

ALTER TABLE compra
    ADD CONSTRAINT "R/5" FOREIGN KEY ( cod_prod )
        REFERENCES producto ( cod_prod );

ALTER TABLE conduce
    ADD CONSTRAINT "R/6" FOREIGN KEY ( mat_car )
        REFERENCES camion ( mat_car );

ALTER TABLE conduce
    ADD CONSTRAINT "R/8" FOREIGN KEY ( dni_cam )
        REFERENCES camionero ( dni_cam );


ALTER TABLE producto
    ADD CONSTRAINT "R/10" FOREIGN KEY ( dni_emp )
        REFERENCES empleado ( dni_emp );

ALTER TABLE producto
    ADD CONSTRAINT "R/11" FOREIGN KEY ( nif_prove )
        REFERENCES proveedor ( nif_prove );

ALTER TABLE producto
    ADD CONSTRAINT "R/12" FOREIGN KEY ( dni_cam )
        REFERENCES camionero ( dni_cam );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            11
-- CREATE INDEX                             0
-- ALTER TABLE                             31
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
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
