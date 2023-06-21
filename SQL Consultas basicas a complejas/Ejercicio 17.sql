use sakila;
update actor
set first_name="RIMALDO"
where actor_id=209;


update address
set district="PANAMA"
where address_id=606;

update category
set name="Anime"
where category_id=17;

update customer
set email="ejemploterribles@gmail.com"
where customer_id=600;

update film_text
set description="La Caida Del  Olimpo se Avecina Una Tormenta"
where film_id=1001
