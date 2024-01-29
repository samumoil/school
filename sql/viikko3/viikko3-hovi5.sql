### SQL KURSSI - VIIKKO 3 ###

## HOVI - TEHTÄVÄRYHMÄT 7 ##

################################
# 7 Alikyselyt # 
################################

-- 1. Hae niiden projektien nimet, joilla on sama prioriteetti kuin P5:lla. K�yt� alikysely�.
select *
from hovi.projekti
where ptun != "P5" and
priorit = 
	(select priorit
	from hovi.projekti
	where ptun = "P5");


-- 2. Hae maksimipalkkaiset henkil�t: Nimi ja palkka.
select enimi,snimi,palkka
from hovi.henkilo
where palkka =
	(select max(palkka)
    from hovi.henkilo);

-- 3. Hae henkil�n 2134 projektien nimet.
select pnimi
from hovi.projekti
where ptun in 
	(select ptun
	from hovi.proj_henk
	where htun = 2134);

-- 4.  Anna niiden henkil�iden nimet, joiden projekteissa ainakin yksi on prioriteetiltaan 3 tai 1.
select enimi,snimi
from hovi.henkilo
where htun in
	(select htun
	from hovi.proj_henk
	where ptun in
		(select ptun
		from hovi.projekti
		where priorit = 3 or priorit = 1));

-- 5. Keill� henkil�ill� on pienempi palkka kuin kaikilla helsinkil�isill�?
select *
from hovi.henkilo
where palkka < all
	(select palkka
	from hovi.henkilo
	where kunta = "HELSINKI");


-- 6.Hae projektit, joiden prioriteetti  on suurempi tai yht� suuri kuin sijaintipaikkansa projektien prioriteettien keskiarvo.
select *
from hovi.projekti p1
where priorit >= 
	(select avg(priorit)
	from hovi.projekti p2
	where p1.sijainti = p2.sijainti);

-- 7. Hae sijaintipaikoittain korkeimmat prioriteetit omaavat projektit (nimi, sijainti, prioriteetti).
select pnimi as projekti,sijainti,priorit as prioriteetti
from hovi.projekti p1
where priorit =
	(select max(priorit)
    from hovi.projekti p2
    where p2.sijainti = p1.sijainti);


-- 8. Hae henkil�n 2245 projektien nimet  k�ytt�en EXISTS-alikysely�.
select *
from hovi.projekti p
where exists
	(select 'x'
    from hovi.proj_henk ph
    where htun = "2245" and p.ptun = ph.ptun );


-- 9. Keill� henkil�ill� on pienempi palkka kuin kaikilla helsinkil�isill�. K�yt� NOT EXISTS alikysely�.
select *
from hovi.henkilo h1
where not exists
	(select *
    from hovi.henkilo h2
    where palkka <
		(select min(palkka)
        from hovi.henkilo
        where kunta = "HELSINKI"));