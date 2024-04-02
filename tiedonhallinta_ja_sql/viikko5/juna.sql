create database juna;
use juna;

show tables;

create table Pysakki (
	pysakki varchar(40) not null  ,
    paikkakunta varchar(40) not null,
    on_sisatilat boolean not null,
    on_lipunmyynti boolean not null,
    constraint Pk_pysakki primary key (pysakki)
	);

insert into Pysakki(pysakki, paikkakunta, on_sisatilat, on_lipunmyynti) values
 	("siilinjärvi", "siilinjärvi", true, false),
    ("kuopio", "kuopio", true, true),
    ("pasila", "helsinki", true, true),
    ("tikkurila", "helsinki", true, true),
    ("helsinki","helsinki", true, true);

create table Junalinja (
	linjan_nro varchar(5) not null,
    voimassa_alkaen date not null,
    voimassa_kunnes date,
    constraint Pk_Junalinja primary key (linjan_nro)
	);

insert into Junalinja(linjan_nro,voimassa_alkaen) values
	("62", "2023-12-10"),
    ("69", "2023-12-10");

create table LinjallaPysakkeja (
	linjan_nro varchar(5),
    pysakki varchar(40),
    saapumisaika time,
    lahtoaika time,
    constraint pk primary key (linjan_nro, pysakki),
    constraint fk_linjan_nro foreign key (linjan_nro) references Junalinja(linjan_nro),
    constraint fk_pysakki foreign key (pysakki) references Pysakki(pysakki)
	);

insert into LinjallaPysakkeja(linjan_nro, pysakki, saapumisaika, lahtoaika) values
	("62", "siilinjärvi","05:09","05:10"),
    ("62","pasila","09:34","09:35"),
    ("62", "helsinki","09:40",null),
    ("69","helsinki",null,"15:19"),
    ("69","pasila","15:24","15:25"),
    ("69","kuopio","20:24","20:29");

create table Vaunumalli (
	vaunumallilyhenne char(6) primary key,
    nimitys varchar(30),
    paikkalkm int unsigned,
    suunnitteluvuosi int
    );
    
insert into Vaunumalli (vaunumallilyhenne, nimitys, paikkalkm, suunnitteluvuosi) values
	("ravi04","ravintolavaunu2004",49,2004),
    ("inte09","intercityvaunu2009",86,2009);

create table AjavaJuna (
	juna_id int unsigned primary key auto_increment,
    linjan_nro varchar(5),
    pvm date not null,
    constraint fk_ajava_juna_linjan_nro foreign key (linjan_nro) references Junalinja(linjan_nro)
    );

insert into AjavaJuna (linjan_nro, pvm) values
	("62","2024-02-16"),
    ("69","2024-02-16");

create table JunassaVaunuja (
	vaunumallilyhenne char(6),
    juna_id int unsigned,
    moneskovaunujunassa int unsigned not null,
    constraint pk_JunassaVaunuja primary key (vaunumallilyhenne, juna_id, moneskovaunujunassa),
    constraint fk_JunassaVaunuja_vaunumallilyhenne foreign key (vaunumallilyhenne) references Vaunumalli(vaunumallilyhenne),
    constraint fk_JunassaVaunuja_juna_id foreign key (juna_id) references AjavaJuna(juna_id)
    );

insert into JunassaVaunuja values
	("inte09",1,1),
    ("ravi04",1,2),
    ("inte09",1,3),
    ("inte09",2,1),
    ("inte09",2,2),
    ("ravi04",2,3),
    ("inte09",2,4);

select * from JunassaVaunuja;