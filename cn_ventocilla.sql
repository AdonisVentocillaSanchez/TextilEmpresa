--------------------------------------------------------
-- Archivo creado  - jueves-diciembre-13-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CAMION_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."CAMION_BAK" 
   (	"MAT_CAR" CHAR(7 BYTE), 
	"MOD_CAR" VARCHAR2(50 BYTE), 
	"TIPO_CAR" VARCHAR2(50 BYTE), 
	"POT_CAR" CHAR(5 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table CAMIONERO_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."CAMIONERO_BAK" 
   (	"DNI_CAM" CHAR(8 BYTE), 
	"NOM_CAM" VARCHAR2(50 BYTE), 
	"APE_CAM" VARCHAR2(50 BYTE), 
	"TELEF_CAM" CHAR(9 BYTE), 
	"DIR_CAM" VARCHAR2(100 BYTE), 
	"SAL_CAM" NUMBER(*,0), 
	"POB_CAM" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table CARGO_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."CARGO_BAK" 
   (	"COD_CARG" CHAR(2 BYTE), 
	"DNI_JEF" CHAR(8 BYTE), 
	"NOM_CARG" VARCHAR2(20 BYTE), 
	"DNI_EMP" CHAR(8 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table CLIENTE_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."CLIENTE_BAK" 
   (	"DNI_CLIE" CHAR(8 BYTE), 
	"NOM_CLIE" VARCHAR2(50 BYTE), 
	"APE_CLIE" VARCHAR2(50 BYTE), 
	"DIR_CLIE" VARCHAR2(50 BYTE), 
	"TELEF_CLIE" CHAR(9 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table COMPRA_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."COMPRA_BAK" 
   (	"DNI_CLIE" CHAR(8 BYTE), 
	"COD_PROD" CHAR(5 BYTE), 
	"FECHA_COM" DATE, 
	"CANT_COM" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table CONDUCE_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."CONDUCE_BAK" 
   (	"MAT_CAR" CHAR(7 BYTE), 
	"DNI_CAM" CHAR(8 BYTE), 
	"FSTART_CON" DATE, 
	"FFINISH_CON" DATE, 
	"PARTIDA_CON" VARCHAR2(30 BYTE), 
	"LLEGADA_CON" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table EMPLEADO_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."EMPLEADO_BAK" 
   (	"DNI_EMP" CHAR(8 BYTE), 
	"NOM_EMP" VARCHAR2(50 BYTE), 
	"APE_EMP" VARCHAR2(50 BYTE), 
	"TELEF_EMP" CHAR(9 BYTE), 
	"DIR_EMP" VARCHAR2(100 BYTE), 
	"USER_EMP" VARCHAR2(50 BYTE), 
	"PASS_EMP" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table JEFEAREA_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."JEFEAREA_BAK" 
   (	"DNI_JEF" CHAR(8 BYTE), 
	"NOM_JEF" VARCHAR2(50 BYTE), 
	"APE_JEF" VARCHAR2(50 BYTE), 
	"TELEF_JEF" CHAR(9 BYTE), 
	"DIR_JEF" VARCHAR2(100 BYTE), 
	"USER_JEF" VARCHAR2(50 BYTE), 
	"PASS_JEF" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table PRODUCTO_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."PRODUCTO_BAK" 
   (	"COD_PROD" CHAR(5 BYTE), 
	"NOM_PROD" VARCHAR2(50 BYTE), 
	"PREC_PROD" NUMBER(*,0), 
	"DESC_PROD" VARCHAR2(50 BYTE), 
	"COD_PROVI" NUMBER(*,0), 
	"DNI_EMP" CHAR(8 BYTE), 
	"NIF_PROVE" VARCHAR2(20 BYTE), 
	"DNI_CAM" CHAR(8 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table PROVEEDOR_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."PROVEEDOR_BAK" 
   (	"NIF_PROVE" VARCHAR2(20 BYTE), 
	"NOM_PROV" VARCHAR2(50 BYTE), 
	"DIR_PROV" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Table PROVINCIA_BAK
--------------------------------------------------------

  CREATE TABLE "VENTOCILLA"."PROVINCIA_BAK" 
   (	"COD_PROVI" NUMBER(*,0), 
	"NOM_PROVI" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for View VW_ALLSESSIONXPROGRAM
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_ALLSESSIONXPROGRAM" ("APLICACION", "NUMERO_SESIONES") AS 
  SELECT PROGRAM APLICACION, COUNT(PROGRAM) NUMERO_SESIONES FROM V$SESSION GROUP BY PROGRAM ORDER BY NUMERO_SESIONES DESC;

   COMMENT ON TABLE "VENTOCILLA"."VW_ALLSESSIONXPROGRAM"  IS 'Todas las sessiones por programa (incluye a ORACLE.EXE)';
--------------------------------------------------------
--  DDL for View VW_CONTROLUSER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_CONTROLUSER" ("SQL_TEXT", "SHARABLE_MEM", "PERSISTENT_MEM", "RUNTIME_MEM", "SORTS", "EXECUTIONS", "PARSE_CALLS", "MODULE", "BUFFER_GETS", "DISK_READS", "VERSION_COUNT", "USERS_OPENING", "LOADS", "FIRST_LOAD_TIME", "ADDRESS", "HASH_VALUE", "ROWS_PROCESSED", "COMMAND_TYPE", "PARSING_USER_ID", "OPTIMIZER_MODE", "PARSEUSER") AS 
  select distinct vs.sql_text, vs.sharable_mem, 
  vs.persistent_mem, vs.runtime_mem,  vs.sorts,
  vs.executions, vs.parse_calls, vs.module,  
  vs.buffer_gets, vs.disk_reads, vs.version_count, 
  vs.users_opening, vs.loads,  
  to_char(to_date(vs.first_load_time,
  'YYYY-MM-DD/HH24:MI:SS'),'MM/DD  HH24:MI:SS') first_load_time,  
  rawtohex(vs.address) address, vs.hash_value hash_value , 
  rows_processed  , vs.command_type, vs.parsing_user_id  , 
  OPTIMIZER_MODE  , au.USERNAME parseuser  
from v$sqlarea vs , all_users au   
where (parsing_user_id != 0)  AND 
(au.user_id(+)=vs.parsing_user_id)  
and (executions >= 1) order by   buffer_gets/executions desc;
--------------------------------------------------------
--  DDL for View VW_CURSORESABIERTOS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_CURSORESABIERTOS" ("SID", "USERNAME", "CURSORES_ABIERTOS") AS 
  select b.sid, a.username, b.value Cursores_Abiertos
from v$session a,
v$sesstat b,
v$statname c
where c.name in ('opened cursors current')
and b.statistic# = c.statistic#
and a.sid = b.sid
and a.username is not null
and b.value >0
order by 3;

   COMMENT ON TABLE "VENTOCILLA"."VW_CURSORESABIERTOS"  IS 'Muestra el SID, Username y los Cursores_Abiertos';
--------------------------------------------------------
--  DDL for View VW_DBASIZE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_DBASIZE" ("MB") AS 
  SELECT SUM(BYTES)/1024/1024 "MB" FROM DBA_EXTENTS;

   COMMENT ON TABLE "VENTOCILLA"."VW_DBASIZE"  IS 'MUESTRA SOLO UNA COUMNA Y FILA DEL TAMA�O DE LA DBA (xe)';
--------------------------------------------------------
--  DDL for View VW_DBA_USERS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_DBA_USERS" ("USERNAME", "USER_ID", "PASSWORD", "ACCOUNT_STATUS", "LOCK_DATE", "EXPIRY_DATE", "DEFAULT_TABLESPACE", "TEMPORARY_TABLESPACE", "CREATED", "PROFILE", "INITIAL_RSRC_CONSUMER_GROUP", "EXTERNAL_NAME", "PASSWORD_VERSIONS", "EDITIONS_ENABLED", "AUTHENTICATION_TYPE") AS 
  SELECT 
    "USERNAME","USER_ID","PASSWORD","ACCOUNT_STATUS","LOCK_DATE","EXPIRY_DATE","DEFAULT_TABLESPACE","TEMPORARY_TABLESPACE","CREATED","PROFILE","INITIAL_RSRC_CONSUMER_GROUP","EXTERNAL_NAME","PASSWORD_VERSIONS","EDITIONS_ENABLED","AUTHENTICATION_TYPE"
FROM 
    DBA_USERS;
--------------------------------------------------------
--  DDL for View VW_MAXIMOCURSORES
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_MAXIMOCURSORES" ("HIGHEST_OPEN_CUR", "MAX_OPEN_CUR") AS 
  select max(a.value) as highest_open_cur, p.value as max_open_cur
 from v$sesstat a, v$statname b, v$parameter p
 where a.statistic# = b.statistic#
  and b.name = 'opened cursors current'
   and p.name= 'open_cursors'
   group by p.value;

   COMMENT ON TABLE "VENTOCILLA"."VW_MAXIMOCURSORES"  IS 'Muestra el m�ximo de Cursores abiertos';
--------------------------------------------------------
--  DDL for View VW_SESSSIONXPROGRAM
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_SESSSIONXPROGRAM" ("APLICACION", "NUMERO_SESIONES") AS 
  SELECT PROGRAM APLICACION, COUNT(PROGRAM) NUMERO_SESIONES FROM V$SESSION  WHERE PROGRAM NOT LIKE 'ORACLE.EXE %' GROUP BY PROGRAM ORDER BY NUMERO_SESIONES DESC;

   COMMENT ON TABLE "VENTOCILLA"."VW_SESSSIONXPROGRAM"  IS 'sessiones por programa';
--------------------------------------------------------
--  DDL for View VW_STATUSUSER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_STATUSUSER" ("USUARIO", "DISPOSITIVO", "STATUS", "EJECUTO_SENTENCIA_EN", "SE_LOGEO_EN", "PUERTO") AS 
  SELECT USERNAME USUARIO, MACHINE DISPOSITIVO, STATUS,SQL_EXEC_START EJECUTO_SENTENCIA_EN ,LOGON_TIME SE_LOGEO_EN,PORT PUERTO FROM V$SESSION WHERE "TYPE" = 'USER';

   COMMENT ON TABLE "VENTOCILLA"."VW_STATUSUSER"  IS 'MUESTRA USUARIO,DISPOSITIVO, STATUS, EJECUTO_SENTENCIA_EN ,SE_LOGEO_EN, PUERTO DE UN USUARIO';
--------------------------------------------------------
--  DDL for View VW_TABLESPACE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "VENTOCILLA"."VW_TABLESPACE" ("Tablespace", "Estado", "MB Tama�o", "MB Usados", "MB Libres", "% incremento", "Fichero de datos") AS 
  Select t.tablespace_name  "Tablespace",  t.status "Estado",  
    ROUND(MAX(d.bytes)/1024/1024,2) "MB Tama�o",
    ROUND((MAX(d.bytes)/1024/1024) - 
    (SUM(decode(f.bytes, NULL,0, f.bytes))/1024/1024),2) "MB Usados",   
    ROUND(SUM(decode(f.bytes, NULL,0, f.bytes))/1024/1024,2) "MB Libres", 
    t.pct_increase "% incremento", 
    SUBSTR(d.file_name,1,80) "Fichero de datos"  
FROM DBA_FREE_SPACE f, DBA_DATA_FILES d,  DBA_TABLESPACES t  
WHERE t.tablespace_name = d.tablespace_name  AND 
    f.tablespace_name(+) = d.tablespace_name    
    AND f.file_id(+) = d.file_id GROUP BY t.tablespace_name,   
    d.file_name,   t.pct_increase, t.status ORDER BY 1,3 DESC;

   COMMENT ON TABLE "VENTOCILLA"."VW_TABLESPACE"  IS 'musetra las tablespae, tama�o(MB), oupado(MB), libre(MB), %de inremento y ruta donde se enuentra ubiado';
REM INSERTING into VENTOCILLA.CAMION_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.CAMIONERO_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.CARGO_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.CLIENTE_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.COMPRA_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.CONDUCE_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.EMPLEADO_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.JEFEAREA_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.PRODUCTO_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.PROVEEDOR_BAK
SET DEFINE OFF;
REM INSERTING into VENTOCILLA.PROVINCIA_BAK
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index XPKPROVINCIA
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKPROVINCIA" ON "VENTOCILLA"."PROVINCIA_BAK" ("COD_PROVI") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKPRODUCTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKPRODUCTO" ON "VENTOCILLA"."PRODUCTO_BAK" ("COD_PROD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKCONDUCE
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKCONDUCE" ON "VENTOCILLA"."CONDUCE_BAK" ("MAT_CAR", "DNI_CAM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKEMPLEADO
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKEMPLEADO" ON "VENTOCILLA"."EMPLEADO_BAK" ("DNI_EMP") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKCOMPRA
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKCOMPRA" ON "VENTOCILLA"."COMPRA_BAK" ("DNI_CLIE", "COD_PROD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKPROVEEDOR
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKPROVEEDOR" ON "VENTOCILLA"."PROVEEDOR_BAK" ("NIF_PROVE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKCAMION
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKCAMION" ON "VENTOCILLA"."CAMION_BAK" ("MAT_CAR") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKCLIENTE
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKCLIENTE" ON "VENTOCILLA"."CLIENTE_BAK" ("DNI_CLIE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKCARGO
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKCARGO" ON "VENTOCILLA"."CARGO_BAK" ("COD_CARG") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKJEFEAREA
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKJEFEAREA" ON "VENTOCILLA"."JEFEAREA_BAK" ("DNI_JEF") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  DDL for Index XPKCAMIONERO
--------------------------------------------------------

  CREATE UNIQUE INDEX "VENTOCILLA"."XPKCAMIONERO" ON "VENTOCILLA"."CAMIONERO_BAK" ("DNI_CAM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL" ;
--------------------------------------------------------
--  Constraints for Table PROVINCIA_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."PROVINCIA_BAK" ADD CONSTRAINT "XPKPROVINCIA" PRIMARY KEY ("COD_PROVI")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."PROVINCIA_BAK" MODIFY ("COD_PROVI" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CONDUCE_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."CONDUCE_BAK" ADD CONSTRAINT "XPKCONDUCE" PRIMARY KEY ("MAT_CAR", "DNI_CAM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."CONDUCE_BAK" MODIFY ("DNI_CAM" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."CONDUCE_BAK" MODIFY ("MAT_CAR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CLIENTE_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."CLIENTE_BAK" ADD CONSTRAINT "XPKCLIENTE" PRIMARY KEY ("DNI_CLIE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."CLIENTE_BAK" MODIFY ("DNI_CLIE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table JEFEAREA_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."JEFEAREA_BAK" ADD CONSTRAINT "XPKJEFEAREA" PRIMARY KEY ("DNI_JEF")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."JEFEAREA_BAK" MODIFY ("DNI_JEF" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CAMIONERO_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."CAMIONERO_BAK" ADD CONSTRAINT "XPKCAMIONERO" PRIMARY KEY ("DNI_CAM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."CAMIONERO_BAK" MODIFY ("DNI_CAM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PROVEEDOR_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."PROVEEDOR_BAK" ADD CONSTRAINT "XPKPROVEEDOR" PRIMARY KEY ("NIF_PROVE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."PROVEEDOR_BAK" MODIFY ("NIF_PROVE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COMPRA_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."COMPRA_BAK" ADD CONSTRAINT "XPKCOMPRA" PRIMARY KEY ("DNI_CLIE", "COD_PROD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."COMPRA_BAK" MODIFY ("CANT_COM" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."COMPRA_BAK" MODIFY ("FECHA_COM" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."COMPRA_BAK" MODIFY ("COD_PROD" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."COMPRA_BAK" MODIFY ("DNI_CLIE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CAMION_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."CAMION_BAK" ADD CONSTRAINT "XPKCAMION" PRIMARY KEY ("MAT_CAR")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."CAMION_BAK" MODIFY ("MAT_CAR" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table EMPLEADO_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."EMPLEADO_BAK" ADD CONSTRAINT "XPKEMPLEADO" PRIMARY KEY ("DNI_EMP")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."EMPLEADO_BAK" MODIFY ("DNI_EMP" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CARGO_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."CARGO_BAK" ADD CONSTRAINT "XPKCARGO" PRIMARY KEY ("COD_CARG")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."CARGO_BAK" MODIFY ("DNI_EMP" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."CARGO_BAK" MODIFY ("DNI_JEF" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."CARGO_BAK" MODIFY ("COD_CARG" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PRODUCTO_BAK
--------------------------------------------------------

  ALTER TABLE "VENTOCILLA"."PRODUCTO_BAK" ADD CONSTRAINT "XPKPRODUCTO" PRIMARY KEY ("COD_PROD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "EMPRESATEXTIL"  ENABLE;
  ALTER TABLE "VENTOCILLA"."PRODUCTO_BAK" MODIFY ("DNI_CAM" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."PRODUCTO_BAK" MODIFY ("NIF_PROVE" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."PRODUCTO_BAK" MODIFY ("DNI_EMP" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."PRODUCTO_BAK" MODIFY ("COD_PROVI" NOT NULL ENABLE);
  ALTER TABLE "VENTOCILLA"."PRODUCTO_BAK" MODIFY ("COD_PROD" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger TR_CAMIONBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_CAMIONBAK" 
BEFORE DELETE ON CAMION
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.CAMION_BAK(MAT_CAR,MOD_CAR,POT_CAR,TIPO_CAR) 
  VALUES (:old.MAT_CAR,:old.MOD_CAR,:old.POT_CAR,:old.TIPO_CAR);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_CAMIONBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_CAMIONEROBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_CAMIONEROBAK" 
BEFORE DELETE ON CAMIONERO
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.CAMIONERO_BAK(APE_CAM,DIR_CAM,NOM_CAM,SAL_CAM,TELEF_CAM,POB_CAM,DNI_CAM)
  VALUES(:old.APE_CAM,:old.DIR_CAM,:old.NOM_CAM,:old.SAL_CAM,:old.TELEF_CAM,:old.POB_CAM,:old.DNI_CAM);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_CAMIONEROBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_CARGOBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_CARGOBAK" 
BEFORE DELETE ON CARGO 
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.CARGO_BAK(COD_CARG,DNI_EMP,DNI_JEF,NOM_CARG)
  VALUES (:old.COD_CARG,:old.DNI_EMP,:old.DNI_JEF,:old.NOM_CARG);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_CARGOBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_CLIENTEBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_CLIENTEBAK" 
BEFORE DELETE ON CLIENTE 
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.CLIENTE_BAK(APE_CLIE,DIR_CLIE,DNI_CLIE,NOM_CLIE,TELEF_CLIE)
  VALUES (:old.APE_CLIE,:old.DIR_CLIE,:old.DNI_CLIE,:old.NOM_CLIE,:old.TELEF_CLIE);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_CLIENTEBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_COMPRABAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_COMPRABAK" 
BEFORE DELETE ON COMPRA
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.COMPRA_BAK(CANT_COM,COD_PROD,DNI_CLIE,FECHA_COM)
  VALUES (:old.CANT_COM,:old.COD_PROD,:old.DNI_CLIE,:old.FECHA_COM);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_COMPRABAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_CONDUCEBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_CONDUCEBAK" 
BEFORE DELETE ON CONDUCE 
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.CONDUCE_BAK(DNI_CAM,FFINISH_CON,FSTART_CON,LLEGADA_CON,MAT_CAR,PARTIDA_CON)
  VALUES (:old.DNI_CAM,:old.FFINISH_CON,:old.FSTART_CON,:old.LLEGADA_CON,:old.MAT_CAR,:old.PARTIDA_CON);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_CONDUCEBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_EMPLEADOBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_EMPLEADOBAK" 
BEFORE DELETE ON EMPLEADO 
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.EMPLEADO_BAK(DIR_EMP,DNI_EMP,NOM_EMP,PASS_EMP,TELEF_EMP,USER_EMP,APE_EMP)
  VALUES (:old.DIR_EMP,:old.DNI_EMP,:old.NOM_EMP,:old.PASS_EMP,:old.TELEF_EMP,:old.USER_EMP,:old.APE_EMP);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_EMPLEADOBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_JEFEAREABAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_JEFEAREABAK" 
BEFORE DELETE ON JEFEAREA
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.JEFEAREA_BAK (APE_JEF,DIR_JEF,DNI_JEF,NOM_JEF,PASS_JEF,TELEF_JEF,USER_JEF)
  VALUES (:old.APE_JEF,:old.DIR_JEF,:old.DNI_JEF,:old.NOM_JEF,:old.PASS_JEF,:old.TELEF_JEF,:old.USER_JEF);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_JEFEAREABAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_PRODUCTOBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_PRODUCTOBAK" 
BEFORE DELETE ON PRODUCTO
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.PRODUCTO_BAK (COD_PROD,COD_PROVI,DESC_PROD,DNI_CAM,DNI_EMP,NIF_PROVE,NOM_PROD,PREC_PROD)
  VALUES (:old.COD_PROD,:old.COD_PROVI,:old.DESC_PROD,:old.DNI_CAM,:old.DNI_EMP,:old.NIF_PROVE,:old.NOM_PROD,:old.PREC_PROD);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_PRODUCTOBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_PROVEEDORBAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_PROVEEDORBAK" 
BEFORE DELETE ON PROVEEDOR 
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.PROVEEDOR_BAK (DIR_PROV,NIF_PROVE,NOM_PROV)
  VALUES (:old.DIR_PROV,:old.NIF_PROVE,:old.NOM_PROV);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_PROVEEDORBAK" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_PROVINCIABAK
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "VENTOCILLA"."TR_PROVINCIABAK" 
BEFORE DELETE ON PROVINCIA 
FOR EACH ROW
BEGIN
  INSERT INTO VENTOCILLA.PROVINCIA_BAK (COD_PROVI,NOM_PROVI)
  VALUES (:old.COD_PROVI,:old.NOM_PROVI);
END;
/
ALTER TRIGGER "VENTOCILLA"."TR_PROVINCIABAK" ENABLE;
--------------------------------------------------------
--  DDL for Synonymn CAMIONERO_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."CAMIONERO_SIN" FOR "VENTOCILLA"."CAMIONERO_BAK";
--------------------------------------------------------
--  DDL for Synonymn CAMION_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."CAMION_SIN" FOR "VENTOCILLA"."CAMION_BAK";
--------------------------------------------------------
--  DDL for Synonymn CARGO_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."CARGO_SIN" FOR "VENTOCILLA"."CARGO_BAK";
--------------------------------------------------------
--  DDL for Synonymn CLIENTE_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."CLIENTE_SIN" FOR "VENTOCILLA"."CLIENTE_BAK";
--------------------------------------------------------
--  DDL for Synonymn COMPRA_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."COMPRA_SIN" FOR "VENTOCILLA"."COMPRA_BAK";
--------------------------------------------------------
--  DDL for Synonymn CONDUCE_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."CONDUCE_SIN" FOR "VENTOCILLA"."CONDUCE_BAK";
--------------------------------------------------------
--  DDL for Synonymn EMPLEADO_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."EMPLEADO_SIN" FOR "VENTOCILLA"."EMPLEADO_BAK";
--------------------------------------------------------
--  DDL for Synonymn JEFEAREA_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."JEFEAREA_SIN" FOR "VENTOCILLA"."JEFEAREA_BAK";
--------------------------------------------------------
--  DDL for Synonymn PRODUCTO_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."PRODUCTO_SIN" FOR "VENTOCILLA"."PRODUCTO_BAK";
--------------------------------------------------------
--  DDL for Synonymn PROVEEDOR_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."PROVEEDOR_SIN" FOR "VENTOCILLA"."PROVEEDOR_BAK";
--------------------------------------------------------
--  DDL for Synonymn PROVINCIA_SIN
--------------------------------------------------------

  CREATE OR REPLACE SYNONYM "VENTOCILLA"."PROVINCIA_SIN" FOR "VENTOCILLA"."PROVINCIA_BAK";
