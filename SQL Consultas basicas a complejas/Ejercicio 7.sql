select Ad.address, Ct.city, Cn.country from sakila.address Ad
inner join sakila.city Ct on (Ad.city_id=Ct.city_id)
inner join sakila.country Cn on (Ct.country_id=Cn.country_id);

select cs.first_name,ad.address, st.store_id From sakila.customer cs 
left join sakila.store st on (cs.store_id=st.store_id)
left join sakila.address ad on (cs.address_id=ad.address_id);

select rt.rental_id,st.first_name From sakila.rental rt 
inner join sakila.staff st on (rt.staff_id=st.staff_id)

