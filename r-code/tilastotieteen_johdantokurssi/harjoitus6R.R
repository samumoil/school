
### TEHTÄVÄ 2

### a) + b)

# n = "toistojen" lukumäärä = 4
n <- 4

# X voi saada arvot 0-4 (ei yhtään -> kaikki)
onnistumiset <- seq(0,4,1)

# p = onnistumisen todennäköisyys = 0.65 
p <- 0.65

# dbinom-funktio antaa tiheysfunktion eli todennäköisyyden 
todennakoisyys <- dbinom(onnistumiset,n,p)

# Luodaan data.frame niin saadaan nätimpi taulukko
# "todennakoisyys" kertoo kunkin onnistumismäärän todennäköisyyden
arvot.ja.todennakoisyydet <- data.frame(onnistumiset, todennakoisyys)
print(arvot.ja.todennakoisyydet, row.names = FALSE)


### c)

# Odotusarvo lasketaan E(X)=np
EX <-n*p
EX

### d)

# Varianssi on Var(X)=np(1-p)
# Keskihajonta on Var(X)^(1/2)
omega <- (n*p*(1-p))^(1/2)
omega

# Odotusarvo on 2.6 ja keskihajonta 0.95...
# Enintään keskihajonnan päässä odotusarvosta ovat arvot 2 ja 3
# Niiden yhteenlaskettu todennäköisyys on:
yhteensa <- arvot.ja.todennakoisyydet$todennakoisyys[3] + arvot.ja.todennakoisyydet$todennakoisyys[4]
yhteensa



### TEHTÄVÄ 3

# Syötetään pnorm-funktioon haluttu Z:n arvo ja 
# kerrotaan sadalla, jotta saadaan prosenttia
### a)
pnorm(-1)*100

### b)
# pnorm-tiheysfunktio kertoo montako prosenttia kuvaajalla on kohdan vasemmalla 
# puolella. Otetaan nyt käänteisenä, koska halutaan kohdan oikealla puolella
# oleva määrä.
(1-pnorm(1.65))*100

### c)
# Lasketaan kummankin hännän lukemat yhteen
(pnorm(-1.25)+(1-pnorm(1.8)))*100



### TEHTÄVÄ 4

### c)
# Standardointikaava:
# z = (x-myy)/omega
myy <- 266
omega <- 16
zfunktio <- function(x) (x-myy)/omega

zfunktio(250)
zfunktio(266)
zfunktio(280)


### d)
# Standardoitu arvo tarkoittaa, monenko keskihajonnan päässä lukema on 
# odotusarvosta. Standardoidun normaalijakauman x-akseli kuvaa samaa asiaa,
# joten voidaan käyttää pnorm-funktiota edellisen kohdan tuloksilla.
pnorm(zfunktio(280))*100
(1-pnorm(zfunktio(250)))*100

### e)
# Pisimmät 90% ovat pidempiä kuin lyhyimmät 10%. Käännetään zfunktio toisin
# päin, jotta saadaan x-arvo selville. qnorm(0.1)-funktio kertoo, kuinka monen
# keskihajonnan päässä on lyhyimmät 10% raskauksista. Pisimmät 90% raskauksista
# ovat siis pidempiä kuin:
kaanteinenfunktio <- function(z) z*omega+myy
kaanteinenfunktio(qnorm(0.1))


### TEHTÄVÄ 5

### a)
# Hyödynnetään edellisen tehtävä valmiita funktioita.
myy <- 298
omega <- 9^0.5
# Todennäköisyys, että yhden pullon sisältö on alle 295ml:
p <- pnorm(zfunktio(295))
p

### b) + c)
# Kuuden pullon tapauksessa odotusarvo on sama, mutta varianssi on pienempi,
# koska suuremman otoksen keskiarvo todennäköisemmin on lähempänä odotusarvoa.
# Uuden varianssin laskemiseen käytetään kaavaa:
varianssikaava <- function(n) (1/n)*p*(1-p)
# Kuuden pullon tapauksessa n=6
omega <- (varianssikaava(6))^0.5
pnorm(zfunktio(295))


### TEHTÄVÄ 6

# Odotusarvo lasketaan kaavalla E(X)=np
n <- 1000
p <- 0.19
myy <- n*p
myy

# Varianssi lasketaan kaavalla np(1-p)
VarX <- (n*p*(1-p))
# Keskihajonta saadaan varianssin neliöjuurella
omega <- VarX^0.5
omega

# Arvioidaan "korkeintaan 170" onnistumista standardoimalla tulos 170
zfunktio(170)
# Lasketaan sille todennäköisyys
pnorm(zfunktio(170))

