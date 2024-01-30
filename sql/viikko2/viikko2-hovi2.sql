### SQL KURSSI - VIIKKO 2 ###

## HOVI - TEHTÄVÄRYHMÄT 2 + 3 ##

# 2 FUNKTIOT #

-- 1. Hae suurin ja pienin annettu prioriteetti. Laita otsikoksi maksimi ja minimi.
SELECT MAX(priorit) AS maksimi, MIN(priorit) AS minimi FROM hovi.projekti;

-- 2. Montako projektia on projekti-taulussa?
SELECT COUNT(*) FROM hovi.projekti;

-- 3. Mik� on veroprosenttien keskiarvo? Laita otsikoksi �ka�.
SELECT AVG(veropros) AS ka FROM hovi.henkilo;

-- 4. Paljonko tekee palkkapotti yhteens�, otsikoksi (sarakkeen aliasnimi) palkat_yht?
SELECT SUM(palkka) AS palkat_yht FROM hovi.henkilo;

-- 5. Montako erilaista tutkinto on henkilo-taulussa? Laita otsikoksi lkm.
SELECT COUNT(DISTINCT tutkinto) AS lkm FROM hovi.henkilo;

-- 6. Mit� eroa on seuraavissa prioriteettien keskiarvoa laskevissa k�skyiss� 
-- select avg(priorit) from projekti;
-- select sum(priorit)/count(*) from projekti;
/* AVG ei laske mukaan yhtä NULL arvon sisältävää riviä. COUNT laskee myös NULL arvon sisältävän
rivin mukaan jakolaskuun, jolloin tulos on väärä. */

-- 7. Hae henkilo-taulusta sukunimien 3 ensimm�ist� merkki�.
SELECT SUBSTRING(snimi, 1, 3) FROM hovi.henkilo;

-- 8. Hae projektien tunnus, nimi ja sijainti. Jos sijainti on null, korvaa se tekstill� 'ei ole'.
SELECT ptun, pnimi,
	CASE WHEN sijainti IS NULL THEN "ei ole"
    ELSE sijainti
    END AS sijainti
FROM hovi.projekti;

    -- Tai sitten näin:
SELECT ptun, pnimi, COALESCE(sijainti, 'ei ole')
FROM projekti;

-- 9. Hae henkilo-taulusta suku- ja etunimet yhdistettyn� seuraavan mallin mukaisesti: Virta, Jukka- Laita aliasnimeksi �nimi�.
SELECT CONCAT(snimi, ", ", enimi, "-") AS nimi FROM hovi.henkilo;

-- 10. Yrityksen henkil�iden tunniste muodostetaan ottamalla sukunimest� kaksi ja etunimest� kaksi merkki�; tunnisteen pit�� olla isoilla kirjaimilla. 
-- Esimerkki: Jukka Virta saa tunnuksen VIJU. Laita sarakkeen aliasnimeksi ht. Muodosta tunniste kaikille henkil�ille.
SELECT UPPER(
	CONCAT(
		SUBSTRING(snimi, 1, 2), SUBSTRING(enimi, 1, 2) 
        )
        ) 
        AS ht
FROM hovi.henkilo;

-- 11. Hae henkil�t, jotka ovat tulleet t�ihin (pvm) 12.5.1993.
SELECT enimi,snimi,pvm 
FROM hovi.henkilo
WHERE pvm = "1993-05-12";

################################
# 3 Ryhmittely #
################################

-- 1. Laske palkat yhteen kunnittain (hae kunta ja palkkasumma).
SELECT SUM(palkka), kunta
FROM hovi.henkilo
GROUP BY kunta;

-- 2. Montako projektia on kussakin sijaintipaikassa? Hae sijainti ja lukum��r� (otsikoksi lkm).
SELECT 
	COUNT(*) AS lkm,
    sijainti
FROM hovi.projekti
GROUP BY sijainti;

-- 3. Miss� sijaintipaikassa on v�hint��n kaksi projektia. Tulosta ko. sijaintipaikat ja projektien m��r�t
SELECT 
	COUNT(*) AS lkm,
    sijainti
FROM hovi.projekti
GROUP BY sijainti
HAVING lkm >= 2;

-- 4. Htun-sarakkeen toinen merkki tarkoittaa tietty� henkil�tyyppi�. 
-- Laske t�m�n tyyppi mukaan ryhmiteltyn� palkkasummat ja henkil�iden 
-- lukum��r� kyseist� tyyppi� kohti.
SELECT 
	SUBSTRING(htun, 2,1) AS tunnus,
	COUNT(*) AS lkm,
    ROUND(SUM(palkka)) AS palkkasumma 
FROM hovi.henkilo
GROUP BY tunnus
ORDER BY tunnus;
