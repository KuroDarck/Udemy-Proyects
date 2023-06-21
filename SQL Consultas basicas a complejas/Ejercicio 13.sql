select customer_id,concat(first_name," " ,last_name) as Nombre_Completo,email 
from sakila.customer where customer_id in (
	select customer_id from sakila.rental where inventory_id in (
		select inventory_id from sakila.inventory where  film_id in (
			select  film_id from sakila.film_category where category_id =1
		)
	)
);


select customer_id as ID_Cliente,amount as Pago,count(customer_id) as Cantidad_Pagos_Sobre_Promedio
 from sakila.payment s where s.customer_id in(
	select c.customer_id from sakila.customer c where s.customer_id=c.customer_id
)
group by customer_id having amount>4.767778

