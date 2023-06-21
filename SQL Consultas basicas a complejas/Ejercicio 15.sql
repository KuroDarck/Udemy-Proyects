SELECT  fl.title as Titulo, concat(ct.first_name," ",last_name) as Nombre_Completo,ad.phone
 as Telefono from sakila.rental rt
	left join sakila.inventory iv on(rt.inventory_id=iv.inventory_id)
	left join sakila.film fl on(iv.film_id=fl.film_id)
	left join sakila.customer ct on(rt.customer_id=ct.customer_id)
	left join sakila.address ad on(ct.address_id=ad.address_id)
    
    where return_date=null or datediff(return_date,rental_date)>rental_duration