--insertar todo en la conexion aparcana
CREATE TABLE USUARIO
( 
	id_user              int PRIMARY KEY,
	dni_user             char(8)  NOT NULL,
	us_user              varchar2(50)  NOT NULL ,
	pass_user            varchar2(50)  NOT NULL ,
	tipo_user            char(15)  NOT NULL
);

--triggers
--Trigger para almacenar los datos de la tabla JEFEAREA en USUARIO

CREATE OR REPLACE TRIGGER TR_INSERTARENUSUARIO_JEFE
   BEFORE INSERT
   ON JEFEAREA
   FOR EACH ROW
DECLARE
   v_user VARCHAR2(50);
   v_pass VARCHAR2(50);
   v_dni CHAR(8);

BEGIN
   SELECT :NEW.user_jef 

     INTO v_user
     FROM DUAL ;
   SELECT :NEW.pass_jef 

     INTO v_pass
     FROM DUAL ;
   SELECT :NEW.dni_jef 

     INTO v_dni
     FROM DUAL ;
   INSERT INTO USUARIO
     ( dni_user, us_user, pass_user, tipo_user )
     VALUES ( v_dni, v_user, v_pass, 'ADMINISTRADOR' );

END;

--Trigger para eliminar los datos de la tabla USUARIO si se elimina en JEFEAREA
CREATE OR REPLACE TRIGGER TR_ELIMINARJEFE
   BEFORE DELETE
   ON JEFEAREA
   FOR EACH ROW

BEGIN
   DELETE us
    WHERE ROWID IN 
   ( SELECT us.ROWID
     FROM USUARIO us,
          us );

END;

--Trigger para almacenar los datos de la tabla EMPLEADO en USUARIO
CREATE OR REPLACE TRIGGER TR_INSERTARENUSUARIO_EMPLE
   BEFORE INSERT
   ON EMPLEADO
   FOR EACH ROW
DECLARE
   v_user VARCHAR2(50);
   v_pass VARCHAR2(50);
   v_dni CHAR(8);

BEGIN
   SELECT :NEW.user_emp 

     INTO v_user
     FROM DUAL ;
   SELECT :NEW.pass_emp 

     INTO v_pass
     FROM DUAL ;
   SELECT :NEW.dni_emp 

     INTO v_dni
     FROM DUAL ;
   INSERT INTO USUARIO
     ( dni_user, us_user, pass_user, tipo_user )
     VALUES ( v_dni, v_user, v_pass, 'EMPLEADO' );

END;

--Trigger para eliminar los datos de la tabla USUARIO si se elimina en EMPLEADO
CREATE OR REPLACE TRIGGER TR_ELIMINAREMPLE
   BEFORE DELETE
   ON JEFEAREA
   FOR EACH ROW

BEGIN
   DELETE us
    WHERE ROWID IN 
   ( SELECT us.id_user
     FROM USUARIO us,
          us );

END;

CREATE OR REPLACE PROCEDURE SP_LOGIN
(
  v_user IN VARCHAR2,
  v_pass IN VARCHAR2
)
AS
   v_cursor SYS_REFCURSOR;

BEGIN
   OPEN  v_cursor FOR
      SELECT u.tipo_user 
        FROM USUARIO u
       WHERE  u.us_user = v_user
                AND u.pass_user = v_pass ;
END;

                         
CREATE OR REPLACE PROCEDURE SP_NUEVOCLIENTE
(
  v_dni IN CHAR,
  v_nom IN VARCHAR2,
  v_ape IN VARCHAR2,
  v_dir IN VARCHAR2,
  v_telef IN CHAR
)
AS

BEGIN
   INSERT INTO CLIENTE
     VALUES ( v_dni, v_nom, v_ape, v_dir, v_telef );

END;

                         
CREATE OR REPLACE PROCEDURE SP_BUSCARCLIENTE
(
  v_busq IN VARCHAR2
)
AS
   v_cursor SYS_REFCURSOR;

BEGIN
   OPEN  v_cursor FOR
      SELECT * 
        FROM CLIENTE 
       WHERE  dni_clie LIKE v_busq
                OR nom_clie LIKE v_busq
                OR ape_clie LIKE v_busq
        ORDER BY ape_clie ASC ;

END;

                         
CREATE OR REPLACE PROCEDURE SP_CLIENTE
AS
   v_cursor SYS_REFCURSOR;

BEGIN
   OPEN  v_cursor FOR
      SELECT * 
        FROM CLIENTE 
        ORDER BY nom_clie ASC ;

END;

CREATE OR REPLACE PROCEDURE SP_ELIMINARCLIENTE
(
  v_inf IN VARCHAR2
)
AS

BEGIN
   DELETE CLIENTE

    WHERE  dni_clie = v_inf;

END;


CREATE OR REPLACE PROCEDURE SP_BUSCARCLIENTEXNOMBRE
(
  v_bus IN VARCHAR2
)
AS
   v_cursor SYS_REFCURSOR;

BEGIN
   OPEN  v_cursor FOR
      SELECT * 
        FROM CLIENTE 
       WHERE  nom_clie LIKE v_bus
        ORDER BY dni_clie ASC ;
END;

CREATE OR REPLACE PROCEDURE SP_MODIFICARCLIENTE
(
  v_dni IN CHAR,
  v_nom IN VARCHAR2,
  v_ape IN VARCHAR2,
  v_dir IN VARCHAR2,
  v_tel IN CHAR
)
AS

BEGIN
   UPDATE CLIENTE
      SET nom_clie = v_nom,
          ape_clie = v_ape,
          dir_clie = v_dir,
          telef_clie = v_tel
    WHERE  dni_clie = v_dni;

END;
