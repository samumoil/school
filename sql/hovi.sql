-- luodaan kanta merkistöllä UTF8
-- ja asetetaan kannan lajittelujärjestykseksi UTF8_SWEDISH_CI
-- => tällöin merkkijonojen lajittelu perustuu suomenkielen aakkostukseen
-- muuten järjestys olisi aäbc eikä abc...äö

DROP database if exists hovi;
create database hovi CHARACTER SET ='UTF8' COLLATE = 'UTF8_SWEDISH_CI';
use hovi;

create table hovi.osasto (ostun numeric(6) primary key,
osnimi varchar(15),
koodi varchar(30))
ENGINE = InnoDB;

create table hovi.henkilo (htun char(4) primary key,
enimi varchar(10),
snimi varchar(10),
kunta varchar(10),
tutkinto char(8),
palkka numeric(7,2),
veropros numeric(3,1),
pvm date,
ostun numeric(6),
constraint henkilo_osasto_fk foreign key (ostun) references osasto(ostun))
ENGINE = InnoDB;

create table hovi.projekti(
ptun char(4),
pnimi varchar(15),
priorit numeric(2),
sijainti varchar(15),
constraint primary key (ptun))
ENGINE = InnoDB;

create table hovi.proj_henk(ptun char(4),
htun char(4),
tunnit numeric(6),
tunnit_suun numeric(6),
constraint primary key (ptun, htun),
constraint proj_henk_projekti_fk foreign key (ptun) references projekti(ptun),
constraint proj_henk_henkilo_fk foreign key (htun) references henkilo(htun))
ENGINE = InnoDB;

insert into hovi.osasto values (1, 'Tietohallinto', 'asd_123456');
insert into hovi.osasto values (2, 'Talous toim', 's  dfg*234');
insert into hovi.osasto values (3, 'Tuotanto os', 'a_ss*8888');
insert into hovi.osasto values (4, 'Markkinointi', 'a%');

insert into hovi.projekti values ('P1', 'KIRJANPITO', 2, 'TURKU');
insert into hovi.projekti values ('P2', 'LASKUTUS', 1, 'HELSINKI');
insert into hovi.projekti values ('P3', 'VARASTO', 3, 'HELSINKI');
insert into hovi.projekti values ('P4', 'RESKONTRA', 2, 'TURKU');
insert into hovi.projekti values ('P5', 'ASIAKKAAT', 3, 'KUOPIO');
insert into hovi.projekti values ('P6', 'TILASTO', NULL, NULL);

insert into hovi.henkilo values ('2134', 'Jukka', 'Virta', 'TURKU', 'Yo', 2800, 22, '2004-03-03',3);
insert into hovi.henkilo values ('2234', 'Mikko', 'Metsä', 'TURKU', 'HuK', 3100, 33, '1993-10-15',1);
insert into hovi.henkilo values ('2245', 'Raili', 'Joki', 'HELSINKI', 'FK', 3100, 31, '1998-09-24',4);
insert into hovi.henkilo values ('2345', 'Leo', 'Meri', 'TURKU', NULL, 2800, 24.5, '2002-01-01',3);
insert into hovi.henkilo values ('2884', 'Jukka', 'Järvi', 'HELSINKI', 'FK', 2960, 31, '1993-05-12',NULL);
insert into hovi.henkilo values ('3546', 'Laura', 'Ranta', 'TAMPERE', 'Yo', 2650, 22, '2001-09-15',1);
insert into hovi.henkilo values ('3547', 'Lyly', 'Jokinen', 'TAMPERE', 'DI', 2800, 37, '1993-05-12',3);


insert into hovi.proj_henk values ('P1', '2134', 300, 300);
insert into hovi.proj_henk values ('P1', '2234', 200, NULL);
insert into hovi.proj_henk values ('P1', '2245', 200, 300);
insert into hovi.proj_henk values ('P1', '2345', 100, 100);
insert into hovi.proj_henk values ('P1', '2884', 100, 200);
insert into hovi.proj_henk values ('P1', '3546', 400, 500);
insert into hovi.proj_henk values ('P1', '3547', 300, 200);
insert into hovi.proj_henk values ('P2', '2134', 300, NULL);
insert into hovi.proj_henk values ('P2', '2245', 400, 500);
insert into hovi.proj_henk values ('P3', '2245', 900, 100);
insert into hovi.proj_henk values ('P4', '2884', 400, 600);
insert into hovi.proj_henk values ('P4', '2234', 300, 400);
insert into hovi.proj_henk values ('P4', '2245', 200, 200);