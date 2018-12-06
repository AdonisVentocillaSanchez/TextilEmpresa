
SELECT DISTINCT TABLE_NAME FROM ALL_ALL_TABLES WHERE OWNER LIKE 'APARCANA'; 

SELECT V.NAME, V.VALUE VALUE, DECODE(ISSYS_MODIFIABLE, 'DEFERRED', 'TRUE', 'FALSE') ISSYS_MODIFIABLE, DECODE(V.ISDEFAULT, 'TRUE', 'YES', 'FALSE', 'NO') "DEFAULT", DECODE(ISSES_MODIFIABLE, 'IMMEDIATE', 'YES','FALSE', 'NO', 'DEFERRED', 'NO', 'YES') SES_MODIFIABLE, DECODE(ISSYS_MODIFIABLE, 'IMMEDIATE', 'YES', 'FALSE', 'NO', 'DEFERRED', 'YES','YES') SYS_MODIFIABLE , V.DESCRIPTION FROM V$PARAMETER V WHERE NAME NOT LIKE 'NLS%' ORDER BY 1;


SELECT PROGRAM APLICACION, COUNT(PROGRAM) NUMERO_SESIONES FROM V$SESSION GROUP BY PROGRAM ORDER BY NUMERO_SESIONES DESC;

SELECT USERNAME, MACHINE, STATUS,SQL_EXEC_START,LOGON_TIME FROM V$SESSION WHERE "TYPE" = 'USER';

SELECT * FROM V$SESSION;

SELECT SUM(BYTES)/1024/1024 MB FROM DBA_EXTENTS;


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

-- REALIZAR UN TRIGGER QUE ME AVISE CUANDO UN DATO SE HAYA DELETE EN ANY TABLE

select * from V$BACKUP

select * from V$DATABASE

select utl_inaddr.get_host_address IP
from dual


select username, action_name, priv_used, returncode
from dba_audit_trail



select name, value
from v$parameter
where name like 'audit_trail'



select b.sid, a.username, b.value Cursores_Abiertos
from v$session a,
v$sesstat b,
v$statname c
where c.name in ('opened cursors current')
and b.statistic# = c.statistic#
and a.sid = b.sid
and a.username is not null
and b.value >0
order by 3



select max(a.value) as highest_open_cur, p.value as max_open_cur
 from v$sesstat a, v$statname b, v$parameter p
 where a.statistic# = b.statistic#
  and b.name = 'opened cursors current'
   and p.name= 'open_cursors'
   group by p.value;
   
   
   SELECT c.sid, d.piece, c.serial#, c.username, d.sql_text
FROM v$session c, v$sqltext d
WHERE c.sql_hash_value = d.hash_value
and upper(d.sql_text) like '%WHERE CAMPO LIKE%'
ORDER BY c.sid, d.piece



kill 34;

