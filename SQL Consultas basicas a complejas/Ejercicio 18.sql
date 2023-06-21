alter table film_text drop column category;
alter table film_text add column category varchar(24) default "Sin Categorisar";

update film_text
set  category="Action"
where film_id in(2,3);

update film_text
set  category="'Horror'"
where film_id in(1,4);

update film_text
set  category="Documentary"
where film_id in(5,8);

update film_text
set  category="Children"
where film_id in(7,10);

update film_text
set  category="Animation"
where film_id in(6,9);
