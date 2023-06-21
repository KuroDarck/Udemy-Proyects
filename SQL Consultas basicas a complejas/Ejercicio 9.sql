select customer_id ,max(rental_date) from sakila.rental
group by customer_id