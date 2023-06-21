use sakila;
drop view if exists  lista_de_clientes;
create view lista_de_clientes as
select concat(cs.first_name," ",cs.last_name) as Nombre_Completo,ad.address as Direcccion
,ct.city as Ciudad,cy.country as Pais from sakila.customer cs
	left join sakila.address ad on(cs.address_id=ad.address_id)
	left join sakila.city ct on(ad.city_id=ct.city_id)
	left join sakila.country cy on(ct.country_id=cy.country_id)
