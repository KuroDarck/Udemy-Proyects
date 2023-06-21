select store_id,first_name,last_name from sakila.customer;

select store_id as Tienda,first_name as Nombre,last_name as Apellido from sakila.customer;

select store_id as Tienda,first_name as Nombre,last_name as Apellido from sakila.customer order by Apellido desc;

select*from sakila.payment;

select distinct(amount)from sakila.payment order by amount;


