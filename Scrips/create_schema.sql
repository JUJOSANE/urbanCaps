
create table Ciudades(
id serial primary key,
nombre_ciudad varchar (50)
);

INSERT into ciudades (nombre_ciudad)
values('Cali')

select * from ciudades

create table Clientes(
id serial primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
telefono integer,
correo varchar(100) not null,
cedula integer not null unique,
ciudad_id integer not null references ciudades(id)
)

insert into clientes (nombre, apellido, telefono, correo, cedula, ciudad_id)
values ('Mario', 'Sanchez', 987654, 'casan@gmail.com', 345678, 5)

select * from clientes c 

create table Vendedores(
id serial primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
telefono integer,
cedula integer not null unique
)
insert into vendedores(nombre, apellido, telefono,cedula)
values('Felipe', 'Molina', 313424789,325647891)

select * from vendedores v

create table ProductoBase(
id serial primary key,
nombreProdu varchar (50) not null,
marca varchar(20) not null,
stock integer not null,
precio decimal (10, 2) not null

)

insert into productobase (nombreProdu, marca, stock, precio)
values ('Tenni', 'Nike', 15, 150000)

select * from productobase p 

create table Ventas(
id serial primary key,
fecha date not null,
totalVenta decimal (10,2) not null,
cliente_id integer not null references clientes(id),
vendedor_id integer not null references vendedores(id)

);
insert into ventas(fecha, totalVenta, cliente_id, vendedor_id)
values ('2025-10-10', 300000, 3 ,1)

select * from ventas v


create table detalles_venta(
id serial primary key,
cantidad integer not null,
precio_unitario decimal (10,2) not null,

venta_id integer not null references ventas(id),
producto_id integer not null references productoBase(id)
)

insert into detalles_venta(cantidad, precio_unitario, venta_id, producto_id)
values (2, 75000, 2, 1)
insert into detalles_venta(cantidad, precio_unitario, venta_id, producto_id)
values (2, 35000, 3, 2)
insert into detalles_venta(cantidad, precio_unitario, venta_id, producto_id)
values (2, 150000, 4, 3)

select * from detalles_venta dv 

