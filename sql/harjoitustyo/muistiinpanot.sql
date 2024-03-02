select * from partiolainen;
select * from suoritus;
select * from partiomerkki;

select * from partiolaisten_tiedot;
select * from ryhmarooli;
select * from ryhman_suoritukset;

SELECT pr.ryhman_nimi AS "Ryhmä"
FROM partioryhma pr;

-- CREATE VIEW `ryhman_tiedot` AS
SELECT pr.ryhman_nimi AS "Ryhmä", COUNT(rr.ryhma_id) AS "Jäseniä"
FROM partioryhma pr JOIN ryhmarooli rr
ON pr.ryhma_id = rr.ryhma_id
WHERE rr.rooli = "jäsen"
GROUP BY pr.ryhman_nimi;



