use inheritance;

select * from kayttaja;
insert into kayttaja(nimi, osoite, puhelinnumero) values
	("Matti Moikalainen", "Totterontie 1029, 09831 Jonokkolo", "12344556");
    
select * from kulkuneuvo;
insert into kulkuneuvo(rekisterinumero, merkki, malli, kulkuneuvo_tyyppi, kayttaja_kayttaja_id) values
 ("ABC-123", "Ford", "Fiesta", "auto", 1), ("1234567890", "Crescent", "JokuMalli", "pyörä", 1);
 
 select * from auto;
 insert into auto(rekisterinumero, moottorin_tilavuus, istumapaikkojen_maara, polttoainetyyppi) values
	("ABC-123", "1,6", "5", "bensa");
    
select * from polkupyora;
insert into polkupyora(rekisterinumero, runkonumero, sahkoavusteinen) values
	("1234567890", "09876", false);
    
select p.rekisterinumero, p.runkonumero, p.sahkoavusteinen, k.merkki, k.malli, k.kulkuneuvo_tyyppi, k.kayttaja_kayttaja_id
from polkupyora p
join kulkuneuvo k on p.rekisterinumero = k.rekisterinumero;