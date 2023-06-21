select*from sakila.actor where  first_name="Scarlett" ;

select*from sakila.actor a where  last_name like"Johansson";

select count(distinct(last_name)) as Apellidos_Distintos from sakila.actor ;

select ac.actor_id,ac.first_name,ac.last_name,count(ac.actor_id) as film_count
 from sakila.actor ac
 join sakila.film_actor using(actor_id)
group by actor_id
order by film_count desc;

select f.film_id,f.title,s.store_id,i.inventory_id from sakila.inventory i
join sakila.store s using(store_id)
join sakila.film f using(film_id)
where f.title="Academy Dinosaur" and s.store_id=1;


