### SQL KURSSI - VIIKKO 2 ###

## SAKILA - TEHTÄVÄRYHMÄ 2 ##

################################
# Osa 2 Selectin perusteet # 
################################

-- 1.Hae osoite ja alue(district) ehdolla että 
-- alue on California ja osoitteessa on 'Avenue' (address-taulu) 
select address, district
from sakila.address
where address like "%Avenue%" and district = "California";

-- 2.Hae osoite ja alue(district) ehdolla että 
-- alue on California ja osoitteessa on 'Avenue' (address-taulu) 
-- sekä katunumero on alle 1000 (vihje: katunumero on osoitteen alussa,  
-- lue neljä ensimmäistä merkkiä ja muunna kokonaisluvuksi) 
select address, district
from sakila.address
where 
	address like "%Avenue%" and 
    district = "California" and
    substring(address, 1,4) < 1000;

-- 3. Hae pisin lainausaika päivinä, minkä joku filmi on ollut vuokralla 
-- Muotoile tulos muotoon 'Pisin lainausaika on x pv' 
select  max(cast(return_date as date)-cast(rental_date as date)) AS "Pisin lainausaika on x pv"
from sakila.rental;

-- 4. Hae henkilökunnan jäsenet: nimitiedot, käyttäjätunnus ja salasana 
-- Jos salasanaa ei ole, tulosta ko. kohdassa 'ei asetettu' 
select first_name, last_name, username, 
	case 
		when password is null then "ei asetettu"
        else password
        end 
        as password
from sakila.staff;

-- 5. Hae montako osoitetta on kullakin alueella (district) 
-- Näytä tuloksessa alue ja osoitelukumäärä 
select district, count(address)
from sakila.address
group by district;

-- 6. Hae ne liikkeet, joilla on yli 300 asiakasta 
-- näytä liikkeen id ja asiakasmäärä 
-- Vihje: haku customer-taulusta 
select store_id, count(customer_id) as asiakasmaara
from sakila.customer
group by store_id
having asiakasmaara > 300;

-- 7. Tee kysely, jonka tulos näyttää tältä: (vihje: käytä unionia!)
select 
	max(amount) as "Suurin maksu",
    min(amount) as "Pienin maksu",
    count(payment_id) as "Maksutapahtuminen määrä",
    round(avg(amount), 2) as "Keskiarvomaksu"
from sakila.payment;