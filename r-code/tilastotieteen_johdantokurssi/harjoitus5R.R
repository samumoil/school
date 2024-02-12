# Harjoittelua
funktio <- function(x) -3/34*x^2+15/34*x
funktio
integrate(funktio, 1, 3)
plot(funktio,-100,100)
plot(funktio,1,3)
integrate(funktio, 1.5, 2)

### Tehtävä 3
# a)

# W = arvot 
W <- c(1,2) 
# pisteW = pistetodennäköisyysfunktio
pisteW <- c(0.35, 0.65) 

# ODOTUSARVO
EW <- sum(W*pisteW) 
EW 

# VARIANSSI
varW <- sum((W-EW)^2*pisteW)
varW

# KESKIHAJONTA
sdW <- sqrt(varW)
sdW

# b)

# Y = arvot
Y <- 3*W-2
Y

# Y pistetodennäköisyydet ovat samat kuin W
pisteY <- pisteW
pisteY

# ODOTUSARVO
EY <- sum(Y*pisteY) 
EY

# c)
# Hyödynnetään oppimateriaalin “lause 6.1” kohtia 1-2: 
# E(Y) = 3*E(W)-E(2)
EY1 <- 3*EW-2
EY1


### Tehtävä 5

# TIHEYSFUNKTIO
tiheys <- function(x) 1/15
tiheys

# Jatkuvan satunnaismuuttujan ODOTUSARVO
xtiheys <- function(x) x*tiheys(x)
EX <- integrate(xtiheys, 0, 15)$value
EX

# VARIANSSI
varfunction <- function(x) (x-EX)^2*tiheys(x)
varX <- integrate(varfunction, 0, 8)$value
varX


### Tehtävä 6
# TIHEYSFUNKTIO
tiheys <- function(x) (-3/34)*x^2+(15/34)*x
tiheys

# a)
# ODOTUSARVO
xtiheys <- function(x) x*tiheys(x)
EX <- integrate(xtiheys, 1, 3)$value
EX

# VARIANSSI
varfunction <- function(x) (x-EX)^2*tiheys(x)
varX <- integrate(varfunction, 1, 3)$value
varX

# b)
# MUUNNOS
muunnos <- function(x) log(x)
muunnos

# Muunnoksen ODOTUSARVO
muunnoskertaafunktio <- function(x) muunnos(x)*tiheys(x) 
Emuunnos <- integrate(muunnoskertaafunktio, 1, 3)$value
Emuunnos

# Muunnoksen VARIANSSI
varfunction <- function(x) (x-Emuunnos)^2*muunnos(x)
varmuunnos <- integrate(varfunction, 1, 3)$value
varmuunnos

# c)
# Odotusarvon logaritmi
log(EX)

### Tehtävä 7

# Arpojen lukumäärä per kategoria
lkmPerKategoria <- c(3,70,1000,3000,5000,130000,160000,450000,2250927)
lkmPerKategoria

# Arpojen lukumäärä suhteessa kaikkiin arpoihin, prosentteja
lkmSuhteessaKaikkiin <- lkmPerKategoria/3000000*100
lkmSuhteessaKaikkiin

# Kategorian voittomäärä per voittava arpa
voittoaPerArpa <- c(20000,1000,100,50,20,10,5,2,0)
voittoaPerArpa

# Kategorian voitot yhteensä
voittoaYhtPerKategoria <- lkmPerKategoria*voittoaPerArpa
voittoaYhtPerKategoria

# Kategorian voitot suhteessa kaikkiin voittoihin, prosentteja
voittoaSuhteessaKaikkiin <- voittoaYhtPerKategoria/3480000*100
voittoaSuhteessaKaikkiin

# Luodaan dataframe, joka sisältää voitonjakoprosentit per kategoria
voitonjakoprosentti <- data.frame(
  voittoaPerArpa,
  lkmSuhteessaKaikkiin,
  voittoaSuhteessaKaikkiin,
  stringsAsFactors = F
  )
voitonjakoprosentti

# Luodaan vielä dataframe, jossa on kaikki tiedot
tiedot.kaikki <- data.frame(
  voittoaPerArpa,
  lkmPerKategoria,
  lkmSuhteessaKaikkiin,
  voittoaYhtPerKategoria,
  voittoaSuhteessaKaikkiin,
  stringsAsFactors = F
)
tiedot.kaikki

# b) 

# ODOTUSARVO
# Summataan vaihtoehdot*niiden todennäköisyys
Evoitto <- sum(voitonjakoprosentti$voittoaPerArpa*(voitonjakoprosentti$lkmSuhteessaKaikkiin/100))
Evoitto
