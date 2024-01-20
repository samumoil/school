### SQL KURSSI - VIIKKO 2 ###

## HOVI - TEHTÄVÄRYHMÄT 4 + 6 ##

################################
# 4 LASKENTAA SARAKKEILLA # 
################################
-- 1. Laske henkil�iden verot palkan ja veroprosentin avulla. Sarakkeet htun, snimi, enimi, palkka, veroprosm vero. Lajittele lasketun veron mukaan laskevaan j�rjestykseen.
SELECT 
	htun, snimi, enimi, palkka, veropros,
    palkka * veropros / 100 AS vero
FROM hovi.henkilo
ORDER BY vero DESC;

-- 2. Mik� on minimi- ja maksimipalkan erotus ja montako prosenttia maksimipalkka on suurempi kuin minimipalkka.
SELECT 
	MAX(palkka) AS maksimipalkka, 
    MIN(palkka) AS minimipalkka,
    (MAX(palkka)-MIN(palkka))/MIN(palkka)*100 AS prosenttia
FROM hovi.henkilo;

-- 3. Hae nimet ja palkat niist� henkil�ist�, joiden palkka 10% korotettuna olisi yli 3000.
SELECT enimi, snimi, palkka
FROM hovi.henkilo
WHERE palkka * 1.1 > 3000;

################################
# 6 YHDISTE #
################################
-- 1. Hae samaan tulosjoukkoon sijaintipaikoittain kaikki henkil�t ja projektit (sijaintipaikka/kunta, htun/ptun). 
-- Rivill� pit�� n�ky�, onko kyseess� henkil� vai projekti. J�rjestys kunta nouseva, tun laskeva. Tuloksen malli  on alla:
/*
KUNTA		TUN		TYYPPI
HELSINKI		P2		PROJEKTI
HELSINKI		P3		PROJEKTI
HELSINKI		2245		HENKILO
....jne	
1. 
1-Sarakkeessa on joko henkil�n tai projektin kunta, 2-sarakkeessa on joko henkil�n tai projektin tunnus ja 3-sarakkeessa on joko teksti HENKIL� tai teksti PROJEKTI.
*/
SELECT 
	kunta AS KUNTA, 
    htun AS TUN, 
    "HENKILÖ" AS TYYPPI
FROM hovi.henkilo
UNION
SELECT 
	sijainti AS KUNTA, 
    ptun AS TUN, 
    "PROJEKTI" AS TYYPPI 
FROM hovi.projekti
ORDER BY KUNTA, TUN DESC;

-- 2. Hae projektien tunnus, nimi ja sijainti. Jos sijainti on null, korvaa se tekstill� 'ei ole'. Tee funktiolla tai unionilla.
SELECT
	ptun AS tunnus,
    pnimi AS nimi,
    CASE
		WHEN sijainti IS NULL THEN "ei ole"
        ELSE sijainti
        END AS sijainti
FROM hovi.projekti;

-- 3. Toiseen j�rjestelm��n teht�v�� otosta varten laitetaan alle 2800 tai tasan 2800 olevat palkat omaan sarakkeeseensa ja 
-- yli 2800 olevat omaansa, alla olevan mallin mukaisesti. Tee kysely.
/*
SNIMI		PIENIP	SUURIP
Joki		0		3100
Jokinen		2800		0
J�rvi		0		2960
...jne
*/
SELECT
	snimi AS SNIMI,
    palkka AS PIENIP,
    "0" AS SUURIP
FROM hovi.henkilo
WHERE palkka <= 2800
UNION
SELECT
	snimi AS SNIMI,
    "0" AS PIENIP,
    palkka AS SUURIP
FROM hovi.henkilo
WHERE palkka > 2800
ORDER BY SNIMI;
