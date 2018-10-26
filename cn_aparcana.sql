create table empleado( 
idempleado int not null, 
nombres varchar2(50), 
apellidopaterno varchar2(50), 
apellidomaterno varchar2(50), 
sexo    char(1), 
estadocivil varchar2(50), 
fechanacimiento date, 
nacionalidad varchar2(50), 
direccion   varchar2(100), 
telefono    varchar2(9), 
dni varchar2(8), 
cargo   varchar2(50),
usuario_empleado varchar2(50),
contraseña_empleado varchar2(50),
constraint PK_Empleado  primary key (idempleado) 
); 
commit;

create table producto( 
idproducto int not null, 
nombre varchar2(50), 
descripcion varchar2(50), 
preciocompra number(8,2), 
precioventa number(8,2), 
constraint PK_Producto primary key (idproducto) 
); 
  
create table proveedor( 
idproveedor int not null, 
nombre varchar2(50), 
telefono char(7), 
direccion varchar2(100), 
celular char(9), 
constraint PK_Proveedor primary key(idproveedor) 
);
commit;
  
create table almacen( 
idalmacen   int not null, 
capacidadtotal  int, 
capacidadocupada    int, 
constraint PK_Almacen primary key(idalmacen) 
);
commit;
  
create table cliente( 
idcliente   int not null, 
nombre  varchar2(50), 
dni char(8), 
nombre_empresa  varchar2(40), 
celular char(9), 
telefono char(7),
usuario_cliente varchar2(50),
contraseña_cliente varchar2(50),
EMAIL varchar2(100),
constraint PK_Cliente primary key(idcliente) 
);
commit;


create table suministrar( 
idsuministrar   int not null, 
fecha date, 
cantidad    int, 
preciocompra number(8,2), 
idproducto  int, 
idproveedor int, 
constraint PK_Suministrar primary key(idsuministrar) 
);
commit;

create table almacenar( 
idalmacenar int not null, 
fecha date, 
cantidad    int, 
idproducto  int, 
idalmacen int, 
constraint PK_Almacenar primary key(idalmacenar) 
);
commit;

create table comprar( 
idcomprar int not null, 
fecha date, 
cantidad int, 
precioventa number(8,2), 
idcliente int, 
idproducto int, 
constraint PK_Comprar primary key(idcomprar) 
);
commit;

create table administrar( 
idproducto int, 
idempleado int 
);
commit; 
  
alter table Administrar add constraint FK_AdmProd  
foreign key (idproducto)references Producto(idproducto); 
alter table Administrar add constraint FK_AdmEmp 
foreign key (idempleado) references Empleado(idempleado); 
alter table Suministrar add constraint FK_SumiProv 
foreign key (idproveedor) references Proveedor(idproveedor); 
alter table Suministrar add constraint FK_SumiProd 
foreign key (idproducto) references Producto(idproducto); 
alter table Almacenar add constraint FK_AlmrProd 
foreign key (idproducto) references Producto(idproducto); 
alter table Almacenar add constraint FK_AlmrAlmn 
foreign key (idalmacen) references Almacen(idalmacen); 
alter table Comprar add constraint FK_CompProd 
foreign key (idproducto) references Producto(idproducto); 
alter table Comprar add constraint FK_CompClien 
foreign key (idcliente) references Cliente(idcliente); 
commit;

select * from Aparcana.Cliente;
delete from Aparcana.Cliente;
select * from Aparcana.Cliente where USUARIO_CLIENTE='Andres' and "CONTRASEÑA_CLIENTE"='123';
insert into Aparcana.Cliente(IDCLIENTE,USUARIO_CLIENTE,"CONTRASEÑA_CLIENTE") values(2,'NP','321');

