/*
Kurssi: Tiedonhallinta ja SQL, opettaja Keijo Kuosmanen 
Aika: 1.3.2024	TENTTI 
Tämän tentin maksimipistemäärä on 50p. Koko kurssin maksimipisteet ovat 100p, 
toiset 50p voi saada harjoitustyöstä (ohjeet kurssi-Moodlessa).

Kirjoita vastaukset tähän tiedostoon ja tallenna se sql-tiedostoksi ja palauta Moodleen. 
Ohje: Kirjoita jokaisen tehtävän perään ko. SQL-lause, joka suorittaa annetun tehtävän, 
ei sen palauttamaa vastausta. Esimerkiksi jos tehtävässä sanotaan: ”Hae kaikki osastot” niin vastauksena 
on 
-- vastaus tänne:
select * from osasto;
*/

-- HOVI-TIETOKANNAN TEHTÄVÄT

/* Tehtävä 1. (3p)
	Hae ne henkilöt joiden kunta on TURKU tai HELSINKI ja joiden palkka on 3100 tai 2800. 
    Haettavat sarakkeet: snimi, enimi, kunta, palkka. 
*/
-- vastaus tänne:

select snimi, enimi, kunta, palkka
from henkilo
where 
	(kunta = "HELSINKI" OR kunta = "TURKU")
    and (palkka = 3100 OR palkka = 2800);



/* Tehtävä 2. (3p)
	Hae ne projektit, joiden nimen neljäs kirjain on ’A’. Haettavat sarakkeet: ptun, pnimi.
*/
-- vastaus tänne:

select ptun, pnimi
from projekti
where pnimi like "___A%";



/* Tehtävä 3.(4p)
	Hae yhdellä lauseella kussakin projektissa työskentelevien henkilöiden lukumäärä proj_henk-taulusta. 
    Haettavat sarakkeet: ptun, lkm (lkm on sarakealias ko lukumäärälle)
*/
-- vastaus tänne:

select ptun, count(htun) as lkm
from proj_henk
group by ptun;



/* Tehtävä 4. (3p)
	Hae alikyselyllä ne henkilöt, jotka työskentelevät projektissa P2. Haettavat sarakkeet: snimi, enimi
*/
-- vastaus tänne:

select snimi, enimi
from henkilo
where htun = any
	(select htun
	from proj_henk
	where ptun = "P2");



/* Tehtävä 5. (4p)
	Tee taulu Asiakkaat, jossa on sarakkeet: astunnus (tee tästä automaattisesti toimiva pääavain) , 
    asnimi (merkkitietoa), ptun (tee tästä vierasavain, joka viittaa tauluun projekti)
*/
-- vastaus tänne:

create table Asiakkaat(
	astunnus int primary key auto_increment,
    asnimi varchar(40),
    ptun char(4),
    constraint asiakkaat_fk1 foreign key (ptun) references projekti(ptun)    
    );
    
    
    
/* Tehtävä 6. (3p)
	Lisää em. Asiakkaat -tauluun **yhdellä lauseella** kaksi riviä dataa: 
    asnimi=Kuntatieto, ptun=P2 ja 
    asnimi=Firma Oy, ptun=P6.
*/
-- vastaus tänne:

insert into Asiakkaat(asnimi, ptun) values
	("Kuntatieto", "P2"),
    ("Firma Oy", "P6");



/* Tehtävä 7. (4p)
	Tee näkymä Asiakasraportti, joka hakee kaikkien projektien asiakkaat 
    muodossa: ”Kuntatieto on asiakkaana projektille LASKUTUS”. Ko. tulossarake koostetaan siis 
    Asiakkaat-taulun asnimi-sarakkeen ja siihen liitetyn Projekti-taulun pnimi-sarakkeen tiedoista. 
    Anna tälle tulossarakkeelle nimeksi tulos.
    
    Kirjoita luontilauseen alle komento: ”select tulos from Asiakasraportti;”
*/
-- vastaus tänne:

create view Asiakasraportti (tulos) as
select concat(a.asnimi, " on asiakkaana projektille ", p.pnimi) as tulos
from Asiakkaat a join projekti p 
on a.ptun = p.ptun;
select tulos from Asiakasraportti;



/* Tehtävä 8. (2p)
	Poista em. Asiakkaat-taulusta projektin P6 asiakkaat.
*/
-- vastaus tänne:

delete
from Asiakkaat
where ptun = "P6";



-- SAKILA-TIETOKANNAN TEHTÄVÄT tästä eteenpäin

/* Tehtävä 9. (3p)
Listaa kaikkien elokuvien nimet ja vuokraushinnat, joiden vuokraushinta on yli 2. 
Järjestä tulokset vuokraushinnan mukaan laskevasti.
Käytettävät taulut: film
*/
-- vastaus tänne:

select title, rental_rate
from film
where rental_rate > 2
order by rental_rate desc;



/* Tehtävä 10. (4p)
Hae kaikki vuokraukset tietylle asiakkaalle (asiakas_id = 5), näytä vuokratun elokuvan nimi ja vuokrauspäivä. 
Käytä edellä mainittuja suomen kielisiä nimityksiä (elokuvan nimi ja vuokrauspäivä) sarakkeiden otsikkoina.
Järjestä vuokraukset uusimmasta vanhimpaan.
Käytettävät taulut: film, inventory, rental
*/
-- vastaus tänne:

select f.title as "elokuvan nimi", r.rental_date as "vuokrauspäivä"
from rental r join inventory i
on r.inventory_id = i.inventory_id
join film f
on f.film_id = i.film_id
where r.customer_id = 5
order by r.rental_date desc;



/*  Tehtävä 11. (4p)
Hae elokuvat, joita on vuokrattu vähintään 26 kertaa.
Näytä elokuvan nimi ja vuokrauskerrat.
Järjestä tulokset vuokrauskertojen mukaan laskevasti.
Käytettävät taulut: film, inventory, rental
*/
-- vastaus tänne:

select f.title, count(r.rental_id) as "vuokrauskerrat"
from rental r join inventory i
on r.inventory_id = i.inventory_id
join film f
on f.film_id = i.film_id
group by f.title
having vuokrauskerrat >= 26
order by vuokrauskerrat desc;



/*  Tehtävä 12. (4p)
Listaa kaikki asiakkaat, joilla EI ole yhtään aktiivista vuokrausta. Käytä EXISTS- tai NOT EXISTS tyyppistä ksyelyä.
Näytettävät tiedot: asiakkaan etu- ja sukunimi
Vinkki: Jos asiakkaalla on aktiivinen vuokraus, niin silloin kyseisen asiakkaan vuokraustiedoissa on palautuspäivä jätetty tyhjäksi.
Käytettävät taulut: customer, rental
*/
-- vastaus tänne:

select c.first_name, c.last_name
from customer c
where not exists
	(select "x"
	from rental r
	where return_date is null and r.customer_id = c.customer_id);



/*  Tehtävä 13. (3p)
Kerro mitä tämä triggeri tekee ja missä käyttötilanteissa se liipaistuu.
*/
DELIMITER $$

CREATE TRIGGER mytrigger
BEFORE INSERT ON film_actor FOR EACH ROW
BEGIN
    DECLARE somecount INT;
    SELECT COUNT(*) INTO somecount
    FROM film_actor
    WHERE NEW.film_id = film_id;
    
    IF somecount >= 50 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ilmoitus';
    END IF;
END$$

DELIMITER ;
-- vastaus tänne:

/*
Aktivoituu ennen jokaista lisättyä riviä film_actor tauluun.
Triggeri laskee, montako näyttelijää kyseiselle elokuvalle on jo merkitty.
Jos elokuvalle on jo merkitty 50 tai enemmän näyttelijöitä, triggeri antaa ilmoituksen.
*/



/*  Tehtävä 14. (3p)
Tee ikkunointifunktiolla kysely, joka näyttää kaikista elokuvista nimen, pituuden 
ja paljonko on kyseisen pituuden ja kyseisen elokuvan ratingin mukaisen keskiarvopituuden erotus kokonaisluvuksi pyöristettynä
*/
-- vastaus tänne:

select title, length, round(length-(avg(length)over(partition by rating))) as keskiarvopituuden_erotus
from film;



/*  Tehtävä 15. (3p)
Sekä Hovi- että Sakila-kannassa on kaupunkien nimiä eri tauluissa.
Tee yhdellä lauseella kysely, joka listaa kaikki Hovi-kannan henkilo-taulun kunnat sekä projekti-taulun sijainiit 
sekä Sakila-kannan city-taulun cityt. Estä tuplaesiintymät.
*/
-- vastaus tänne:

select distinct kunta as "kaupunki"
from hovi.henkilo
union
select distinct sijainti
from hovi.projekti
where sijainti is not null
union
select distinct city
from sakila.city;
