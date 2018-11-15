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
size 1M 
autoextend on next 100K 
maxsize 1600K 
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

create role PROGRAMADOR; 
grant DBA to PROGRAMADOR; 
commit;
grant PROGRAMADOR to Ventocilla,Aparcana,Valencia; 
commit;
