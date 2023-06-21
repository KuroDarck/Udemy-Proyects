select*from sakila.payment
where (amount between 2.99 and 4.99) and staff_id=2 and customer_id in (1,2);

select*from sakila.address
where city_id between 300 and 350;

select*from sakila.film
where (rental_rate between 0.99 and 2.99) and length<=50 and replacement_cost <20