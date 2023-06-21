select rental_rate, 
case
when rental_rate<=1 then "Pelicula Mala"
when rental_rate>1 and rental_rate<=3 then "Pelicula Buena"
else "Pelicula Exelente"
end as Calificacion
from sakila.film
