/*
Jos pävityksesi estyy safe update asetuksen päällä olon vuoksi, niin ota se pois käytöstä:
SELECT @@SQL_SAFE_UPDATES;  -- tarkistaa onko safe update käytössä
SET SQL_SAFE_UPDATES = 0; -- ottaa sen pois käytöstä

Yleisesti jos taulujen välillä on vierasavainviittauksia, niin viitatun arvon päivitys voi olla estetty.
Samoin viitatun arvon poisto onnistuu vain poistamalla ensin ko. arvoon viittaavat rivit.

Loppupään tehtävät ovat haastavampia.
*/
use sakila;
SET autocommit = 0;
SET SQL_SAFE_UPDATES = 0;
rollback;

-- Tehtävä 1: Lisää uusi asiakas


-- country_id 33
select * from country where country like "%inland";
-- city_id 601
select * from city where city like "%pio";

-- Lisätään uusi kaupunki "Kuopio", osoitetaan se country_id 33 = Finland
insert into city(city, country_id) values ("Kuopio", 33);

-- Poistetaan address-taulun location kolumni, jotta saadaan osoite liitettyä
alter table address drop column location;

-- Lisätään uusi osoite, osoitetaan se city_id 601 = Kuopio
insert into address(address, district, city_id, postal_code,phone) values
("10 Kirkkokatu", "Pohjois-Savo", 601, "70100", "0501234567");

-- Katsotaan, mikä oli edellisen toiminnon saama primary key
select last_insert_id();

-- Lisätään asiakas
insert into customer(store_id, first_name, last_name, email, address_id) values
(1, "JONI", "SEPPÄ", "joniseppa@hotmail.com", last_insert_id());

select * from customer where first_name like "JONI";
commit;

-- Tehtävä 2: Päivitä asiakkaan osoite
update sakila.address
set address = "11 Kirkkokatu"
where address_id = 
	(select address_id
    from customer
    where first_name like "JONI" and last_name like "SEPPÄ");
commit;

select * from address where address like "%katu";


-- Tehtävä 3: Transaktio: Vuokraa elokuva ja päivitä varaston saldo

-- Valitaan elokuvan film_id
select film_id 
into @film_id
from film 
where title like "BANGER PINOCCHIO"
limit 1;

-- Valitaan yksi (tällä kertaa pienin id-numero) kappale elokuvaa Banger Pinocchio
select min(inventory_id) 
into @inventory_id
from inventory 
where film_id = @film_id
    and store_id = 1
limit 1;

-- Kuka vuokraa @customer_id
select customer_id 
into @customer_id
from customer 
where first_name like "JONI"
limit 1;

-- Kuka on töissä? Store_id=1 antaa vain yhden työntekijän, eli staff_id=1
select staff_id 
into @staff_id
from staff 
where store_id=1
limit 1;

-- Paljonko vuokraus maksaa?
select rental_rate
into @rental_rate
from film
where film_id = @film_id;

select @staff_id, @inventory_id, @customer_id, @rental_rate, @film_id;

start transaction;
insert into rental(inventory_id, customer_id,staff_id) values
(@inventory_id, @customer_id, @staff_id);

select rental_id into @rental_id from rental where rental_id = (select last_insert_id());

insert into payment(customer_id, staff_id, rental_id, amount) values
(@customer_id, @staff_id, @rental_id, @rental_rate);

select * from payment where payment_id = last_insert_id();
commit;

-- Tehtävä 4: Poista vanhentunut maksu
DELETE FROM payment
WHERE payment_date < DATE_SUB(NOW(), INTERVAL 5 YEAR);
/*
date_sub(mistä_vähennetään, INTERVAL vähennettävä_määrä vähennettävän_määrän_yksikkö)
date_sub(now(), interval 5 day)
date_sub("2015-03-15 04:03:59", interval 2346 second)
date_add(...) toimii samalla tavalla
*/

-- Tehtävä 5: Transaktio: Lisää uusi elokuva ja päivitä näyttelijän tietoja
start transaction;
insert into film(title, release_year, language_id, rental_duration, rental_rate, replacement_cost) values
("ELOKUVAN NIMI", "2024", 1, 14, 19.99, 39.99);
commit;

select film_id 
into @film_id
from film 
where title like "ELOKUVAN%";

insert into film_actor(actor_id, film_id) values
(11, @film_id);

select * from actor where actor_id = 11;

update actor
set first_name = "NON-ZERO"
where actor_id = 11;
commit;

-- Tehtävä 6: Päivitä asiakkaan vuokraushistoria

-- Tehty jo?
select * from rental where customer_id = 
	(select customer_id from customer where first_name like "JONI");


-- Tehtävä 7: Poista käyttämätön elokuvakategoria

-- Kaikki elokuvakategoriat ovat käytössä:
select distinct category_id
from category c;

-- Tämä palauttaa tyhjän:
select * 
from category c
where not exists
	(select count(*)
    from film_category fg
    where fg.category_id = c.category_id);

/* Tehtävä 8: Lisää uusi henkilökunnan jäsen staff-tauluun ja päivitä hänen osoitetietonsa address-taulussa. 
Käytä transaktiota varmistaaksesi, että molemmat toimenpiteet suoritetaan onnistuneesti. 
Käytä paikallista muuttujaa tallentaaksesi address-tauluun lisätyn rivin ID:n ja käytä tätä ID:tä henkilökunnan jäsenen lisäämisessä.

Vihje 1 - Paikallisen muuttujan käyttö ID:n tallentamiseen:
Voit käyttää LAST_INSERT_ID()-funktiota saadaksesi viimeksi lisätyn rivin ID:n address-taulussa. 
Tallenna tämä arvo paikalliseen muuttujaan käyttämällä SET-komentoa. Esimerkki:
SET @uusi_address_id = LAST_INSERT_ID();

Vihje 2 - Geometry-arvon luominen:
location-sarake address-taulussa vaatii geometry-tyyppisen arvon. Voit luoda tämän arvon käyttämällä ST_GeomFromText()-funktiota. 
Esimerkki pisteen luomiseen:
ST_GeomFromText('POINT(24.9384 60.1699)')
*/

start transaction;
-- Lisätään osoite

select city_id
into @city_id
from city
where city like "Kuopio";

insert into
	address(address, district,city_id,postal_code,phone) values
    ("123 Kotiosoite","Pohjois-Savo", @city_id, "70100", "0441234567");

-- Tallennetaan osoite_id muuttujaan
select last_insert_id() into @address_id;

-- Lisätään työntekijä
insert into
	staff(first_name, last_name, address_id, store_id, active, username) values
    ("Mikko", "Mallikas", @address_id, 1, 1, "mikmal");
commit;

-- Tehtävä 9: Transaktio: Poista elokuva ja siihen liittyvät vuokraukset. Poista myös muista tauluista tiedot, jotka
-- viittaavat kyseiseen elokuvaan ja estävät elokuvan poistamisen. Tee kaikki yhdessä transaktiossa.

start transaction;

select film_id 
into @film_id
from film 
where title like "BERETS AGENT";

select * from film_actor where film_id = @film_id;
delete from film_actor where film_id = @film_id;

select * from film_category where film_id = @film_id;
delete from film_category where film_id = @film_id;

select * from rental where inventory_id = any 
	(select inventory_id from inventory where film_id = @film_id);
delete from rental where inventory_id = any
	(select inventory_id from inventory where film_id = @film_id);

select * from inventory where film_id = @film_id;
delete from inventory where film_id = @film_id;

select * from film where film_id = @film_id;
delete from film where film_id = @film_id;
commit;
