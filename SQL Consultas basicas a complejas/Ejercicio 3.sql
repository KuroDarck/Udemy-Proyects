select*from sakila.payment where customer_id=36 and amount>0.99 and staff_id=1;

select*from sakila.rental where not staff_id=1   and customer_id>250 and inventory_id<50;