create tablespace EmpresaTextil 
datafile '/EmpresaTextil.dbf' 
size 3M 
autoextend on next 1M 
maxsize 3400K 
default storage(Initial 16K next 16K 
minextents 1 maxextents 3); 
commit; 
  
create temporary tablespace Temp_EmpresaTextil 
tempfile '/Temp_EmpresaTextil.dbf' 
size 500K 
autoextend on next 50K 
maxsize 600K 
extent management local uniform size 100K; 
commit;

create role PROGRAMADOR; 
grant DBA to PROGRAMADOR; 
commit;
grant PROGRAMADOR to Ventocilla,Aparcana,Valencia; 
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