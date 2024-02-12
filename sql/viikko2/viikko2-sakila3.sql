### SQL KURSSI - VIIKKO 2 ###

## SAKILA - TEHTÄVÄRYHMÄ 3 ##

################################
# Osa 3 Liitoskyselyt # 
################################

-- 1.Hae asiakkaiden nimet ja osoitteet (address,district)  
-- lajittele alueen, sukunimen ja etunimen mukaan  
select c.first_name, c.last_name, a.address, a.district
from sakila.customer c join sakila.address a
	on c.address_id = a.address_id
order by district, last_name, first_name;

-- 2.Hae Buenos Airesissa asuvien asiakkaiden tekemät vuokraukset 
-- asiakkaan nimi, alue, inventory_id, vuokraus- ja palautuspäivämäärät 
select 
	c.last_name, c.first_name, a.district, r.inventory_id, 
    cast(r.rental_date as date), cast(r.return_date as date)
from sakila.customer c join sakila.address a
		on c.address_id = a.address_id
	join sakila.rental r
		on r.customer_id = c.customer_id
where a.district = "Buenos Aires";

-- 3. Hae Buenos Airesissa asuvien asiakkaiden tekemien vuokrausten lukumäärä 
select c.first_name, c.last_name, count(*)
from sakila.customer c join sakila.address a
		on c.address_id = a.address_id
	join sakila.rental r
		on r.customer_id = c.customer_id
where a.district = "Buenos Aires"
group by c.customer_id;

-- 4. hae ne asiakkaat, jotka ovat joskus vuokranneet filmin 'BERETS AGENT' 
-- näytä filmin nimi, asiakkaan nimi, vuokrauspäivä. Lajittele vuokrauspäivän mukaan. 

/* Omia muistiinpanoja jatkoa varten:
select * from sakila.film; 			-- title	film_id
select * from sakila.inventory;		-- film_id	inventory_id
select * from sakila.rental;		-- inventory_id	customer_id rental_date
select * from sakila.customer;		-- customer_id name
*/

select f.title, c.first_name, c.last_name, r.rental_date
from sakila.film f join sakila.inventory i
		on f.film_id = i.film_id
    join sakila.rental r
		on r.inventory_id = i.inventory_id
    join sakila.customer c
		on c.customer_id = r.customer_id
where f.title like "BERETS AGENT"
order by r.rental_date;


-- 5. Näytä kuinka isolla summalla näyttelijöiden filmejä on vuokrattu yhteensä  
-- lajittelu summan mukaan suurin ensin 

/* Omia muistiinpanoja jatkoa varten:
select * from sakila.actor;			-- actor_id		first_name	last_name
select * from sakila.film_actor;	-- actor_id		film_id
select * from sakila.inventory;		-- film_id 		inventory_id
select * from sakila.rental;		-- inventory_id	rental_id
select * from sakila.payment; 		-- rental_id	amount
*/

select a.first_name, a.last_name, sum(amount) as summa
from sakila.actor a join sakila.film_actor fa
		on a.actor_id = fa.actor_id
	join sakila.inventory i
		on i.film_id = fa.film_id
	join sakila.rental r
		on r.inventory_id = i.inventory_id
	join sakila.payment p
		on p.rental_id = r.rental_id
group by a.first_name, a.last_name
order by summa desc;
