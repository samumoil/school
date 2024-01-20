### SQL KURSSI - VIIKKO 2 ###

## HOVI - TEHTÄVÄRYHMÄT 5 ##

################################
# 5 LIITOKSET # 
################################

-- 1. Hae henkil�n 2245 projektien nimet ja tuntim��r�t (tarvitaan kaksi taulua).
SELECT
	p.pnimi AS projekti,
    ph.tunnit AS "toteutuneet tunnit",
    ph.tunnit_suun AS "suunnitellut tunnit"
FROM hovi.proj_henk ph JOIN hovi.projekti p
	ON p.ptun = ph.ptun
WHERE htun = 2245;

-- 2. Hae projektien nimet, henkil�tunnukset, tehdyt tunnit ja suunnitellut tunnit. Lajittele pnimen mukaan. Taulut projekti ja proj_henk.
SELECT
	p.pnimi AS projekti,
    ph.htun AS henkilöID,
    ph.tunnit AS "tehdyt tunni",
    ph.tunnit_suun AS "suunnitellut tunnit"
FROM hovi.projekti p JOIN hovi.proj_henk ph
	ON p.ptun = ph.ptun
ORDER BY projekti;

-- 3. Hae osastojen nimet ja tunnukset sek� henkil�ist� snimi, enimi, kunta, palkka. Ota mukaan vain ne, joiden palkka on 2800. Lajittele osaston nimen ja henkil�n nimen mukaan.
SELECT
	os.osnimi AS osastonimi,
    os.ostun AS osastotunnus,
    h.snimi AS sukunimi,
    h.enimi AS etunimi,
    h.kunta AS kunta,
    h.palkka AS palkka
FROM hovi.osasto os JOIN hovi.henkilo h
	ON os.ostun = h.ostun
WHERE h.palkka = 2800
ORDER BY osastonimi, snimi, enimi;

-- 4. Hae projektien nimet, niiden henkil�t (nimell�) ja kunkin henkil�n tunnit per projekti (ei siis summia). Lajittele projektittain ja henkil�itt�in.
SELECT
	p.pnimi AS projekti,
    h.snimi AS sukunimi,
    h.enimi AS etunimi,
    ph.tunnit AS tunnit
FROM hovi.henkilo h JOIN hovi.proj_henk ph
	ON h.htun = ph.htun
JOIN hovi.projekti p
	ON p.ptun = ph.ptun
ORDER BY projekti, sukunimi, etunimi;

-- 5. (Listaa projektin P2 nimi ja sijainti sek� niiden projektien nimet, joilla on sama sijainti kuin P2:lla)
SELECT
    p2.pnimi AS projekti,
    p2.sijainti AS sijainti
FROM hovi.projekti p1 JOIN hovi.projekti p2
	ON p1.sijainti = p2.sijainti
WHERE p1.ptun = "P2";

-- 6. (Listaa projektin P4 nimi ja ne projektit, joiden prioriteetti on suurempi tai yht� suuri kuin projektin P4.)
SELECT pnimi AS projekti 
FROM hovi.projekti 
WHERE ptun = "P4"
UNION 
SELECT
	p2.pnimi
FROM hovi.projekti p1 JOIN hovi.projekti p2
	ON p2.priorit >= p1.priorit
WHERE p1.ptun = "P4";

-- 7. Hae kaikki projektit, niist� tunnus, nimi ja tunnit yhteens�. Ota mukaan my�s ne projektit, joilla ei ole tunteja (eli P5 ja P6). K�yt� ulkoliitosta.

SELECT
	p.ptun AS tunnus,
    p.pnimi AS nimi,
    SUM(ph.tunnit) AS "tunnit yhteensä"
FROM hovi.projekti p LEFT JOIN hovi.proj_henk ph
	ON p.ptun = ph.ptun
GROUP BY p.pnimi,p.ptun;
