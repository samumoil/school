/*
Jos pävityksesi estyy safe update asetuksen päällä olon vuoksi, niin ota se pois käytöstä:
SELECT @@SQL_SAFE_UPDATES;  -- tarkistaa onko safe update käytössä
SET SQL_SAFE_UPDATES = 0; -- ottaa sen pois käytöstä

Yleisesti jos taulujen välillä on vierasavainviittauksia, niin viitatun arvon päivitys voi olla estetty.
Samoin viitatun arvon poisto onnistuu vain poistamalla ensin ko. arvoon viittaavat rivit.

Loppupään tehtävät ovat haastavampia.
*/
-- Tehtävä 1: Lisää uusi asiakas

-- Tehtävä 2: Päivitä asiakkaan osoite

-- Tehtävä 3: Transaktio: Vuokraa elokuva ja päivitä varaston saldo


-- Tehtävä 4: Poista vanhentunut maksu


-- Tehtävä 5: Transaktio: Lisää uusi elokuva ja päivitä näyttelijän tietoja


-- Tehtävä 6: Päivitä asiakkaan vuokraushistoria



-- Tehtävä 7: Poista käyttämätön elokuvakategoria


/* Tehtävä 8: Lisää uusi henkilökunnan jäsen staff-tauluun ja päivitä hänen osoitetietonsa address-taulussa. 
Käytä transaktiota varmistaaksesi, että molemmat toimenpiteet suoritetaan onnistuneesti. 
Käytä paikallista muuttujaa tallentaaksesi address-tauluun lisätyn rivin ID:n ja käytä tätä ID:tä henkilökunnan jäsenen lisäämisessä.
Vihje 1 - Paikallisen muuttujan käyttö ID:n tallentamiseen:
Voit käyttää LAST_INSERT_ID()-funktiota saadaksesi viimeksi lisätyn rivin ID:n address-taulussa. 
Tallenna tämä arvo paikalliseen muuttujaan käyttämällä SET-komentoa. Esimerkki:
SET @uusi_address_id = LAST_INSERT_ID();

Vihje 2 - Geometry-arvon luominen:
location-sarake address-taulussa vaatii geometry-tyyppisen arvon. Voit luoda tämän arvon käyttämällä ST_GeomFromText()-funktiota. 
Esimerkki pisteen luomiseen:
ST_GeomFromText('POINT(24.9384 60.1699)')

*/
-- Tehtävä 9: Transaktio: Poista elokuva ja siihen liittyvät vuokraukset. Poista myös muista tauluista tiedot, jotka
-- viittaavat kyseiseen elokuvaan ja estävät elokuvan poistamisen. Tee kaikki yhdessä transaktiossa.


