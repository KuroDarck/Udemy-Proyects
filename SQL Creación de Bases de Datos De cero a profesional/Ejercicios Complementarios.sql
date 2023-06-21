select*from sakila.actor where first_name="Scarlett";

select*from sakila.actor where last_name="johansson";

select count(distinct last_name) from sakila.actor ;

select last_name,count(*) from sakila.actor group by last_name having count(*)=1;

select a.actor_id,a.first_name,a.last_name,count(actor_id) as film_coun from sakila.actor a 
join sakila.film_actor using(actor_id) group by a.actor_id order by film_coun desc;

select f.film_id,f.title,s.store_id,i.inventory_id from sakila.inventory i 
join sakila.store s using(store_id)join sakila.film f using (film_id)
where f.title ="Academy Dinosaur" and s.store_id=1