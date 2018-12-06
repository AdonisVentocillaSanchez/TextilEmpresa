--------------------------------------------------------
-- Archivo creado  - miércoles-diciembre-05-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for View VW_ALLSESSIONXPROGRAM
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_ALLSESSIONXPROGRAM" ("APLICACION", "NUMERO_SESIONES") AS 
  SELECT PROGRAM APLICACION, COUNT(PROGRAM) NUMERO_SESIONES FROM V$SESSION GROUP BY PROGRAM ORDER BY NUMERO_SESIONES DESC;

   COMMENT ON TABLE "APARCANA"."VW_ALLSESSIONXPROGRAM"  IS 'Todas las sessiones por programa (incluye a ORACLE.EXE)';
--------------------------------------------------------
--  DDL for View VW_CONTROLUSER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_CONTROLUSER" ("SQL_TEXT", "SHARABLE_MEM", "PERSISTENT_MEM", "RUNTIME_MEM", "SORTS", "EXECUTIONS", "PARSE_CALLS", "MODULE", "BUFFER_GETS", "DISK_READS", "VERSION_COUNT", "USERS_OPENING", "LOADS", "FIRST_LOAD_TIME", "ADDRESS", "HASH_VALUE", "ROWS_PROCESSED", "COMMAND_TYPE", "PARSING_USER_ID", "OPTIMIZER_MODE", "PARSEUSER") AS 
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

   COMMENT ON TABLE "APARCANA"."VW_CONTROLUSER"  IS 'Muestra las últimas setenias SQL y quién las realizó.';
--------------------------------------------------------
--  DDL for View VW_CURSORESABIERTOS
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_CURSORESABIERTOS" ("SID", "USERNAME", "CURSORES_ABIERTOS") AS 
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

   COMMENT ON TABLE "APARCANA"."VW_CURSORESABIERTOS"  IS 'Muestra el SID, Username y los Cursores_Abiertos';
--------------------------------------------------------
--  DDL for View VW_DBASIZE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_DBASIZE" ("MB") AS 
  SELECT SUM(BYTES)/1024/1024 "MB" FROM DBA_EXTENTS;

   COMMENT ON TABLE "APARCANA"."VW_DBASIZE"  IS 'MUESTRA SOLO UNA COUMNA Y FILA DEL TAMAÑO DE LA DBA (xe)';
--------------------------------------------------------
--  DDL for View VW_MAXIMOCURSORES
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_MAXIMOCURSORES" ("HIGHEST_OPEN_CUR", "MAX_OPEN_CUR") AS 
  select max(a.value) as highest_open_cur, p.value as max_open_cur
 from v$sesstat a, v$statname b, v$parameter p
 where a.statistic# = b.statistic#
  and b.name = 'opened cursors current'
   and p.name= 'open_cursors'
   group by p.value;

   COMMENT ON TABLE "APARCANA"."VW_MAXIMOCURSORES"  IS 'Muestra el máximo de Cursores abiertos';
--------------------------------------------------------
--  DDL for View VW_SESSSIONXPROGRAM
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_SESSSIONXPROGRAM" ("APLICACION", "NUMERO_SESIONES") AS 
  SELECT PROGRAM APLICACION, COUNT(PROGRAM) NUMERO_SESIONES FROM V$SESSION  WHERE PROGRAM NOT LIKE 'ORACLE.EXE %' GROUP BY PROGRAM ORDER BY NUMERO_SESIONES DESC;

   COMMENT ON TABLE "APARCANA"."VW_SESSSIONXPROGRAM"  IS 'sessiones por programa';
--------------------------------------------------------
--  DDL for View VW_STATUSUSER
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_STATUSUSER" ("USUARIO", "DISPOSITIVO", "STATUS", "EJECUTO_SENTENCIA_EN", "SE_LOGEO_EN", "PUERTO") AS 
  SELECT USERNAME USUARIO, MACHINE DISPOSITIVO, STATUS,SQL_EXEC_START EJECUTO_SENTENCIA_EN ,LOGON_TIME SE_LOGEO_EN,PORT PUERTO FROM V$SESSION WHERE "TYPE" = 'USER';

   COMMENT ON TABLE "APARCANA"."VW_STATUSUSER"  IS 'MUESTRA USUARIO,DISPOSITIVO, STATUS, EJECUTO_SENTENCIA_EN ,SE_LOGEO_EN, PUERTO DE UN USUARIO';
--------------------------------------------------------
--  DDL for View VW_TABLESPACE
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "APARCANA"."VW_TABLESPACE" ("Tablespace", "Estado", "MB Tamaño", "MB Usados", "MB Libres", "% incremento", "Fichero de datos") AS 
  Select t.tablespace_name  "Tablespace",  t.status "Estado",  
    ROUND(MAX(d.bytes)/1024/1024,2) "MB Tamaño",
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

   COMMENT ON TABLE "APARCANA"."VW_TABLESPACE"  IS 'musetra las tablespae, tamaño(MB), oupado(MB), libre(MB), %de inremento y ruta donde se enuentra ubiado';
