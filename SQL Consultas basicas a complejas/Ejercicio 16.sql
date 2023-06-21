use Sakila;
insert into actor(first_name,last_name)
value("Gloria","Peñalosa");

insert into address(address,address2,district,city_id,postal_code,phone,location)
value("Calle 17 Santo Tomas"," ","Attika","38","83578",50762103425,point(-6.63442, 40.97840));

insert into category(name)
value("Anime");

insert into customer(store_id,first_name,last_name,email,address_id,active,create_date)
value(1,"Terrible","Ejemplo","terribleEje@hotmail.com",606,1,'2022-07-19 09:59:20');

insert into film_text(film_id,title,description)
value(1001,"FURIA DE TITANES","La Caida del  Olimpo se avecina Quien los puede ayudar un simple Semidios");