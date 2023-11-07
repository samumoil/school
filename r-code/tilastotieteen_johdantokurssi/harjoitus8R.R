##########################################################
### TEHTÄVÄ 1

# Ryhmän koko kummallakin on 30
n <- 30

# Nitriittiryhmän keskiarvo on 7880
x1 <- 7880
# Kontrolliryhmän keskiarvo on 8112
x2 <- 8112

# Nitriittiryhmän keskihajonta on 1115
s1 <- 1115
# Kontrolliryhmän keskihajonta on 1250
s2 <- 1250

# poolattu varianssiestimaattori
s.toiseen <- ((30-1)*s1^2+(30-1)*s2^2)/(30+30-2)
s.toiseen

# riippumattomien otosten t-testi
t.obs <- (x1-x2)/(s.toiseen*(1/n+1/n))^0.5
t.obs


##########################################################
### TEHTÄVÄ 2

# Otokset vektoreina
koneA <- c(24, 25, 26, 24, 26, 27, 26, 26) 
koneB <- c(34, 30, 28, 25, 30, 28, 25, 28) 

# Otoskoot
n1 <- length(koneA)
n2 <- length(koneB)

# Otoskeskiarvot
x1 <- mean(koneA)
x2 <- mean(koneB)

# poolattua varianssiestimaattoria varten tarvitaan varianssit ja variansseja 
# varten tarvitaan odotusarvot. Odotusarvo on suoraan kunkin satunnaisotoksen 
# keskiarvo, koska todennäköisyys p kullekin arvolle on sama (1/n). 
E1 <- x1
E2 <- x2

# Varianssi lasketaan kaavalla
# Var(X) = (sum(X-E)^2)/(n-1)
var1 <- sum((koneA-E1)^2)/(n1-1)
var1
var2 <- sum((koneB-E2)^2)/(n2-1)
var2

# poolattu varianssiestimaattori
s.toiseen <- ((30-1)*var1+(30-1)*var2)/(30+30-2)
s.toiseen

# riippumattomien otosten t-testi
t.obs <- (x1-x2)/(s.toiseen*(1/n1+1/n2))^0.5
t.obs

# Lasketaan vielä p-arvo
2*(1-pt(abs(t.obs),n1+n2-2))

# Varmistellaan tulosta
t.test(koneA,koneB,alternative="two.sided",var.equal=TRUE)

##########################################################
### TEHTÄVÄ 3

kone.data <- data.frame(kone = rep(c("A","B"), each = length(koneA)), paino = c(koneA, koneB))
kone.data

boxplot(paino~kone, data=kone.data, xlab="Kone", ylab="Mitalien paino", 
        main="Mitalien painon viiksilaatikkokuvio")

hist(kone.data$paino[1:8], xlim=range(22:35), ylim=range(0:4), 
     main="Koneen A mitalien painojakauma", ylab="Kappaletta", xlab="Paino")
hist(kone.data$paino[9:16], xlim=range(22:35), ylim=range(0:4), 
     main="Koneen B mitalien painojakauma", ylab="Kappaletta", xlab="Paino")

##########################################################
### TEHTÄVÄ 4

# Syötetään mittausten tulokset
mittaus1 <- c(36,23,48,54,40,32,50,44,36)
mittaus2 <- c(21,24,36,30,32,35,43,40,30)

# Lasketaan erotus vähentämällä myöhemmistä arvoista ensimmäiset
erotus <- mittaus2-mittaus1
erotus

# Erotuksen keskiarvo
x.erotus <- mean(erotus)
x.erotus

# N eli mittausten lukumäärä
n <- length(erotus)
n

# Erotuksen varianssi
s2 <- var(erotus)
s2

# Hypoteesin perusteella erotuksen odotusarvo on 0
myy <- 0
myy

# Tarkastellaan erotuksen jakaumaa Q-Q -janalla ja todetaan muuttujan olevan
# lähellä normaalijakaumaa, kuvaaja tehtävän lopussa:
qqnorm((erotus))
qqline(erotus)

# Parittaisen t-testin kaava on:
# t = (x-myy)/((s2/n)^2)
t.obs <- (x.erotus-myy)/(sqrt(s2/n))
t.obs

# Lasketaan vielä p-arvo
2*(1-pt(abs(t.obs),length(erotus)-1))


##########################################################
### TEHTÄVÄ 5 

library(datas4uef)
data("aineistoA_dat")

koe1 <- aineistoA_dat$välikoe1
koe1
koe2 <- aineistoA_dat$välikoe2
koe2

# Lasketaan erotus vähentämällä myöhemmistä arvoista ensimmäiset
erotus <- koe2-koe1
erotus

# Erotuksen keskiarvo
x.erotus <- mean(erotus)
x.erotus

# N eli mittausten lukumäärä
n <- length(erotus)
n

# Erotuksen varianssi
s2 <- var(erotus)
s2

# Hypoteesin perusteella erotuksen odotusarvo on 0
myy <- 0
myy

# Tarkastellaan erotuksen jakaumaa Q-Q -janalla ja todetaan muuttujan olevan
# lähellä normaalijakaumaa, kuvaaja tehtävän lopussa:
qqnorm((erotus))
qqline(erotus)

# Parittaisen t-testin kaava on:
# t = (x-myy)/((s2/n)^2)
t.obs <- (x.erotus-myy)/(sqrt(s2/n))
t.obs

# Lasketaan vielä p-arvo
2*(1-pt(abs(t.obs),length(erotus)-1))


##########################################################
### TEHTÄVÄ 6

# Syötetään mittausten tulokset  
jussin <- c(1375, 1550, 1250, 1300, 900, 1500, 1750, 3600, 2250, 2800)  
toinen <- c(1250, 1300, 1250, 1200, 950, 1575, 1600, 3300, 2150, 2600)  

# Lasketaan erotus vähentämällä myöhemmistä arvoista ensimmäiset  
erotus <- jussin - toinen 
erotus  

# Erotuksen keskiarvo  
x.erotus <- mean(erotus)  
x.erotus  

# N eli mittausten lukumäärä  
n <- length(erotus)  
n  

# Erotuksen varianssi  
s2 <- var(erotus)  
s2  

# Hypoteesin perusteella erotuksen odotusarvo on 0  
myy <- 0  
myy  

# Tarkastellaan erotuksen jakaumaa Q-Q -janalla ja todetaan muuttujan olevan  
# lähellä normaalijakaumaa, kuvaaja tehtävän lopussa:  
qqnorm((erotus))  
qqline(erotus)  

# Parittaisen t-testin kaava on:  
# t = (x-myy)/(sqrt(s2/n))  
t.obs <- (x.erotus-myy)/(sqrt(s2/n))  
t.obs  

# Lasketaan vielä p-arvo  
2*(1-pt(abs(t.obs),length(erotus)-1))  

