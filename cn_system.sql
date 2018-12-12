create tablespace EmpresaTextil 
datafile '/EmpresaTextil.dbf' 
size 30M 
autoextend on next 3M 
maxsize 34000K 
default storage(Initial 16K next 16K 
minextents 1 maxextents 3); 
commit; 
  
create temporary tablespace Temp_EmpresaTextil 
tempfile '/Temp_EmpresaTextil.dbf' 
size 6M 
autoextend on next 100K 
maxsize 7600K 
extent management local uniform size 300K; 
commit;

create user Ventocilla identified by ella 
default tablespace EmpresaTextil 
temporary tablespace Temp_EmpresaTextil 
quota unlimited on EmpresaTextil; 
commit; 
  
create user Aparcana identified by aparcana 
default tablespace EmpresaTextil 
temporary tablespace Temp_EmpresaTextil 
quota unlimited on EmpresaTextil; 
commit; 
  
create user Valencia identified by vale 
default tablespace EmpresaTextil 
temporary tablespace Temp_EmpresaTextil 
quota unlimited on EmpresaTextil; 
commit; 

CREATE ROLE DBD;
GRANT CREATE SESSION,
CREATE TABLE, CREATE PROCEDURE,
CREATE TRIGGER,CREATE SEQUENCE,
SELECT ANY TABLE to DBD;
COMMIT;

GRANT DBD TO APARCANA;
COMMIT;

CREATE ROLE PROGRAMADOR; 
GRANT DBA TO PROGRAMADOR; 
COMMIT;

GRANT PROGRAMADOR to Ventocilla,Valencia; 
GRANT SELECT ANY DICTIONARY TO VENTOCILLA;
COMMIT;
