select a.address,c.city,cn.country from sakila.address a
inner join sakila.city c on (a.city_id=c.city_id) 
inner join sakila.country cn on(c.country_id=cn.country_id);

select c.first_name,a.address,s.store_id from sakila.customer c
left join sakila.store s on (c.store_id=s.store_id) 
left join sakila.address a on(c.address_id=a.address_id);

select r.rental_id,s.first_name from sakila.rental r
inner join sakila.staff s on (r.staff_id=s.staff_id) 
