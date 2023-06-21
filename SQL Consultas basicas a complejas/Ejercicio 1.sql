select store_id as Tienda,first_name as Nombre,last_name as Apellido 
from sakila.customer order by Apellido Desc;

select distinct(amount)from sakila.payment order by amount desc;