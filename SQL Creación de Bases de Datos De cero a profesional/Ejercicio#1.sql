-- BORRADO DE LA BASE DE DATOS SI EXISTE
drop schema if exists Ejercicio1;

-- CREACION DE LA BASE DE DATOS SI NO EXISTE
create schema if not exists Ejercicio1; 

-- USO DE LA BASE DE DATOS
use Ejercicio1;

-- CREACION DE LA TABLA MASCOTAS
create table MASCOTAS(ID int not null,
NOMBRE varchar(20),
ID_DUEÑO int not null,
SERVICIO varchar(20)
);

-- CREACION DE LA TABLA PERSONAS
create table PERSONAS(ID int not null,
NOMBRE varchar(20),
APELLIDO varchar(20),
ZIP_CODE  int not null,
TLF int
);

-- CREACION DE LA TABLA DIRECION
create table DIRECCION(ZIP int not null,
NOMBRE_ZONA varchar(20),
RUTA varchar(20)
);

-- CREACION DE LAS PRIMARY KEY DE LAS TABLA MASCOTA Y PERSONAS
alter table MASCOTAS add primary key(ID);

alter table PERSONAS add primary key(ID);

alter table DIRECCION add primary key(ZIP);

-- CREACION DE LAS FOREING KEY DE LAS TABLA MASCOTA Y PERSONAS

alter table MASCOTAS add constraint FK_PERSONAS
foreign key(ID_DUEÑO) references PERSONAS(ID);

alter table PERSONAS add constraint FK_ZIP
foreign key(ZIP_CODE) references DIRECCION(ZIP);

-- AGREGANDO UNA COLUNNA A LA TABLA PERSONA
alter table PERSONAS add column EMAIL varchar(20);

-- AGREGAR UNA UNIQUE CONSTRAINT
alter table PERSONAS
add constraint EMAIL_UNICO unique (EMAIL);

-- CANBIAR EL NOMBRE A LA COLUNNA NOMBRE POR PRIMER_NOMBRE
alter table MASCOTAS change NOMBRE PRIMER_NOMBRE varchar(20);

-- CANBIAR EL DATA TYPE DE LA COLUNNA RUTA POR CHAR(12)
alter table DIRECCION modify  RUTA char(12);




