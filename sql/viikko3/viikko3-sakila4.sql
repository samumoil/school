-- Osa 4 Alikyselyt
-- 1.Hae Buenos Airesissa asuvien asiakkaiden nimet  alikyselyn avulla
-- lajittele alueen, sukunimen ja etunimen mukaan 
select first_name, last_name
from customer
where address_id in
	(select address_id from address where district like "Buenos Aires")
order by last_name,first_name;

-- 2. Hae alikyselyllä G-luokiteltujen filmien vuokraustuotto yhteensä, tulos oheiseen muotoon.
select concat("G-ratingin filmien tuotto: ", sum(amount)) as tuotto
from payment where rental_id in
	(select rental_id from rental where inventory_id = any
		(select inventory_id from inventory where film_id = any
			(select film_id from film where rating like "G")));

-- 3. Hae alikyselyllä päiväkohtaiset vuokrausten tuotot laskevasti lajiteltuna

select sum(amount) as tuotto, cast(payment_date as date) as date
from payment
/*where cast(payment_date as date) = any
	(select cast(payment_date as date)
	from payment)
    */
group by date
order by tuotto desc;


-- 4. tee näkymä Top10asiakkaat, jossa listaat kymmenen eniten tuottanutta asiakasta
-- tuoton mukaan laskevassa järjestyksessä. Hae ko. näkymän kautta kyseiset asiakkaat.
-- vihje: käytä liitoskyselyä
create view Top10asiakkaat as
	select c.first_name, c.last_name, sum(p.amount) as tuotto
	from customer c join payment p
		on c.customer_id = p.customer_id
	group by c.first_name, c.last_name
	order by tuotto desc
	limit 10;

select * from Top10asiakkaat;