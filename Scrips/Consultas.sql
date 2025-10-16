
create table Ciudades(
id serial primary key,
nombre_ciudad varchar (50)
);

INSERT into ciudades (nombre_ciudad)
values('Amazonas')

select * from ciudades

select ciudades from ciudades where nombre_ciudad = 'Cali' 
update ciudades set nombre_ciudad = 'Barranquila' where id = 5    
delete from ciudades where id = 4 

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
values ('Sofi', 'Sanchez', 963741852, 'sofi@gmail.com', 741852963, 1)

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
values ('2024-09-10', 35000, 5 ,2)

select * from ventas 


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
insert into detalles_venta(cantidad, precio_unitario, venta_id, producto_id)
values (4, 140000, 6 , 2)

select * from detalles_venta dv 


//--consultas avanzadas en sql
/JOINS
select vt.id as id_venta, c.nombre as nombreCliente, v.nombre as nombreVendedor, p.nombreProdu, dv.cantidad, dv.precio_unitario
from ventas vt 
join 
clientes c on vt.cliente_id = c.id
join 
vendedores v on vt.vendedor_id = v.id 
join 
detalles_venta dv on vt.id = dv.id
join 
productobase p on vt.id  = p.id 


SELECT * FROM detalles_venta WHERE venta_id = 3;


select cli.nombre as nombreCliente, c.nombre_ciudad as ciudad, p.nombreProdu as Producto
from clientes cli
join 
ciudades c on cli.ciudad_id = c.id 
join 
ventas vt on cli.id = vt.cliente_id 
join
detalles_venta dv on vt.id = dv.venta_id 
join
productobase p on dv.producto_id  = p.id
where
c.nombre_ciudad = 'Medellin' and p.nombreprodu = 'Gorra'

select CONCAT(v.nombre,' ' , v.apellido) as nombre_completo, CONCAT(cli.nombre,' ', cli.apellido) as nombre_Cliente 
from vendedores v 
join 
ventas vt on v.id = vt.vendedor_id 
join 
clientes cli on vt.cliente_id = cli.id 
order by v.nombre , cli.nombre 

--------------------------------------
--GROUP BY - ORDER BY

select CONCAT(v.nombre,' ',v.apellido) as nombre_vendedor, SUM(totalVenta) as total_ventas
from vendedores v 
join 
ventas vt on v.id = vt.vendedor_id 
group by nombre_vendedor 
order by total_ventas 

select p.nombreprodu , SUM(dv.cantidad * dv.precio_unitario) as Ingreso_Total
from productoBase p
join 
detalles_venta dv on p.id = dv.producto_id 
group by p.nombreprodu
order by ingreso_total desc

select p.nombreprodu, ci.nombre_ciudad , SUM(dv.cantidad) as unidades_vendidas
from ciudades ci
join 
clientes c on ci.id   = c.ciudad_id 
join
ventas vt on c.id = vt.cliente_id 
join
detalles_venta dv on vt.id = dv.venta_id 
join
productobase p on dv.producto_id  = p.id 
where ci.nombre_ciudad = 'Medellin'
group by p.nombreprodu , ci.nombre_ciudad 
order by unidades_vendidas desc

select ci.nombre_ciudad as Ciudad, count (vt.id) as totalVentas
from ciudades ci
join 
clientes c on ci.id = c.ciudad_id 
join ventas vt on c.id = vt.cliente_id  
group by ci.nombre_ciudad 
order by totalventas desc

select p.nombreprodu, SUM(dv.cantidad * dv.precio_unitario) * 0.19 as impuesto_total
from productobase p 
join 
detalles_venta dv on p.id = dv.producto_id 
group by p.nombreprodu 
order by impuesto_total desc


