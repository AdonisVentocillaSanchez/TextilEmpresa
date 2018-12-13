--insertar todo en la conexion aparcana
CREATE TABLE USUARIO
( 
	id_user              int PRIMARY KEY,
	dni_user             char(8)  NOT NULL,
	us_user              varchar2(50)  NOT NULL ,
	pass_user            varchar2(50)  NOT NULL ,
	tipo_user            char(15)  NOT NULL
);

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
