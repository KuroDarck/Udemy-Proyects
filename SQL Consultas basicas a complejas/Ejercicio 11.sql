select email, char_length(email) from sakila.customer;

select concat(first_name," ",last_name," ",email) from sakila.customer;

select concat_ws(film_id,title,description,release_year,language_id,
original_language_id,rental_duration,rental_rate,length,replacement_cost,
rating,special_features,last_update
) from sakila.film;

select customer_id, round(avg(amount)) from sakila.payment group by customer_id;

select ucase(city) from sakila.city