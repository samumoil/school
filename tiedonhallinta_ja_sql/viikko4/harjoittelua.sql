use hovi;

create table turku_palkattu
select enimi, snimi, palkka+1000, curdate() as pvm
from henkilo
where kunta like "TURKU";

select * from turkulaiset;
select * from turku_palkattu;

create table asiakas1(
	asiakas_id integer unsigned auto_increment primary key,
    etunimi nvarchar(30),
    sukunimi nvarchar(30),
    syntynyt date,
    luottoraja numeric(7,2) default 1000.00);
    
insert into asiakas1(etunimi, sukunimi, syntynyt, luottoraja) values 
	("Matti", "Meikäläinen", "1990-03-20", 0.00),
    ("Matti", "Meikäläinen", "1990-03-20", 0.00),
    ("Matti", "Meikäläinen", "1990-03-20", 0.00);
    
select * from asiakas;

update asiakas
set postinumero = "70100"
where asiakasid = "3";

alter table asiakas1
add column testi1 char(5);

create table posti(
	postinro char(5) primary key,
    toimipaikka varchar(20));

insert into posti(postinro, toimipaikka) values
	("90100", "OULU"),
    ("70100", "KUOPIO"),
    ("00100", "HELSINKI");

select * from posti;

alter table asiakas
add constraint asiakas_fk1 foreign key (postinumero)
references posti(postinro) on update cascade;


create table asiakas3(
	id integer unsigned primary key auto_increment,
    kolumni1 nvarchar(20),
    kolumni2 nvarchar(20));
    
alter table asiakas1 
add column id2 char(10);

alter table asiakas1
add constraint asiakas1_fk1 foreign key (id2)
references asiakas2(id2) on update cascade;

insert into asiakas3(id2) values
	("12345");

select * from asiakas2;