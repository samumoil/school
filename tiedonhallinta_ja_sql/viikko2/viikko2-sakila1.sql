### SQL KURSSI - VIIKKO 2 ###

## SAKILA - TEHTÄVÄRYHMÄ 1 ##

################################
# Osa 1 Selectin perusteet # 
################################

-- Hae actor-taulusta kaikki rivit ja kaikki sarakkeet  
select *
from sakila.actor;

-- Hae film-taulusta kaikki elokuvat, joiden vuokraushinta on alle 1 dollari  
select *
from sakila.film
where rental_rate < 1;

-- Hae film-taulusta elokuvien nimi, vuokraushinta ja luokitustieto. Lajittele hinnan mukaan laskevasti, nimen mukaan nousevasti.  
select title, rental_rate, rating
from sakila.film
order by rental_rate DESC, title;

-- Hae film-taulusta elokuvat, joiden rating on R,G tai PG.  
select *
from sakila.film
where rating = "R" OR rating = "G" OR rating = "PG";

-- Hae customer-taulusta kaikki asiakkaat, joiden sukunimi alkaa B-kirjaimella.  
select *
from sakila.customer
where last_name like "B%"; 

-- Hae film_text-taulusta kaikki elokuvanimikkeet, joiden kuvauksessa on sana ”epic”  
select title
from sakila.film_text
where description like "%epic%";

-- Hae montako vuokrausta on tehty 25.5.2005 (rental)  
select count(*)
from sakila.rental
where rental_date between '2005-05-25 00:00:00' and '2005-05-25 23:59:59';

-- Hae suurin vuokrausmaksu, joka on tehty (payment)  
select max(amount)
from sakila.payment;