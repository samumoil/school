use HoviDWH;
use hovi;

-- Lisätään tiedot henkilo_dim tauluun
insert into HoviDWH.henkilo_dim (htun, kunta)
select distinct henk.htun, henk.kunta
from hovi.henkilo henk
join hovi.proj_henk ph on henk.htun = ph.htun
join hovi.projekti proj on ph.ptun = proj.ptun
where ph.tunnit_suun is not null;

-- Lisätään tiedot projekti_dim tauluun
insert into HoviDWH.projekti_dim (ptun, pnimi, sijainti)
select distinct proj.ptun, proj.pnimi, proj.sijainti
from hovi.henkilo henk
join hovi.proj_henk ph on henk.htun = ph.htun
join hovi.projekti proj on ph.ptun = proj.ptun
where ph.tunnit_suun is not null;

-- Lisätään tiedot fakta-tauluun
insert into HoviDWH.fakta (htun, ptun, tunnit_suunn, tunnit_toteut)
select distinct henk.htun, proj.ptun, ph.tunnit_suun, ph.tunnit
from hovi.henkilo henk
join hovi.proj_henk ph on henk.htun = ph.htun
join hovi.projekti proj on ph.ptun = proj.ptun
where ph.tunnit_suun is not null;

select * from HoviDWH.fakta;




-- Tee kysely, joka vertailee henkilöiden asuinpaikan perusteella keskiarvotunteja
use HoviDWH;
select avg(f.tunnit_suunn) as "Suunnitellut tunnit", avg(f.tunnit_toteut) as "Toteutuneet tunnit", h.kunta
from fakta f
join henkilo_dim h on f.htun = h.htun
group by h.kunta;

-- Tee kysely, joka vertailee henkilöiden asuinpaikan perusteella suunniteltujen ja toteutuneiden tuntien erotusta kussakin projektissa
select (avg(f.tunnit_toteut) - avg(f.tunnit_suunn)) as "Tuntien erotus", p.pnimi as "Projekti", h.kunta as "Kunta"
from fakta fauto
join henkilo_dim h on f.htun = h.htun
join projekti_dim p on f.ptun = p.ptun
group by h.kunta, p.pnimi;

