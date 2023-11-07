# Verkkoluentomateriaalin harjoituksia:
set.seed(42)
data(trees)
dim(trees)
trees
trees[sample(1:31,5),]

sample(1:10,10,replace=TRUE)
sample(1:10,10)

# Tehtävä 1
15+80+4-35
(3+8+2)*(5+10+2+7)
2*5+2*10+2*2-5*5-5*10-5*2
(2*5)+(2*10)+(2*2)-(5*5)-(5*10)-(5*2)

(8-2)*(10-6)+(2-2)*(2-6)

### Tehtävä 2
library(datas4uef)
data("aineistoA_dat")
taul <-table(aineistoA_dat$tiedekunta,aineistoA_dat$tarpeellisuus)
taul
rowSums(taul)
colSums(taul)
sum(taul)

# Sijoitetaan taulukko muuttujaan x ja tarkastellaan sitä
x <- taul
x
# Sijoitetaan muuttujaan y taulukon sarakesummat ja tarkastellaan sitä
y <- rbind(x,colSums(taul))
y
# Tarkistetaan, että y-taulukon rivisummat ovat oikein
rowSums(y)
# Sijoitetaan muuttujaan z y-taulukko rivisummineen ja tarkastellaan sitä
z <- cbind(y,rowSums(y))
z

### Tehtävä 3
3/15*100 
5/15*100
7/15*100 

5/19*100  
7/19*100  
7/19*100  

9/16*100  
3/16*100  
4/16*100  

### Tehtävä 5

aineisto <- head(aineistoA_dat[,c("tarpeellisuus","opiskeluvuosi","ikä")],6)
aineisto$tarpeellisuus <- as.integer(aineisto$tarpeellisuus)
aineisto

### Opiskeluvuosi / tarpeellisuus
# Tarpeellisuus on järjestysasteikollinen, joten pakko käyttää Spearmania:
plot(aineisto$opiskeluvuosi, aineisto$tarpeellisuus)
cor(aineisto$opiskeluvuosi, aineisto$tarpeellisuus, method="spearman")

### Opiskeluvuosi / ikä
# Kumpikin muuttuja on vähintään välimatka-asteikollinen, joten käytetään Pearsonia:
plot(aineisto$opiskeluvuosi,aineisto$ikä)
cor(aineisto$opiskeluvuosi,aineisto$ikä)

### Ikä / tarpeellisuus
# Tarpeellisuus on järjestysasteikollinen, joten pakko käyttää Spearmania:
plot(aineisto$ikä, aineisto$tarpeellisuus)
cor(aineisto$ikä, aineisto$tarpeellisuus, method="spearman")


#### Mielenkiinnosta tehdään samat ajot koko aineistolla: ####
aineisto2 <- aineistoA_dat[,c("tarpeellisuus","opiskeluvuosi","ikä")]
aineisto2$tarpeellisuus <- as.integer(aineisto2$tarpeellisuus)

### Opiskeluvuosi / tarpeellisuus
# Tarpeellisuus on järjestysasteikollinen, joten pakko käyttää Spearmania:
plot(aineisto2$opiskeluvuosi, aineisto2$tarpeellisuus)
cor(aineisto2$opiskeluvuosi, aineisto2$tarpeellisuus, method="spearman")

### Opiskeluvuosi / ikä
# Kumpikin muuttuja on vähintään välimatka-asteikollinen, joten käytetään Pearsonia:
plot(aineisto2$opiskeluvuosi,aineisto2$ikä)
cor(aineisto2$opiskeluvuosi,aineisto2$ikä)

### Ikä / tarpeellisuus
# Tarpeellisuus on järjestysasteikollinen, joten pakko käyttää Spearmania:
plot(aineisto2$ikä, aineisto2$tarpeellisuus)
cor(aineisto2$ikä, aineisto2$tarpeellisuus, method="spearman")


### Tehtävä 6

2.54*6.5
6.895*361.8
2.54*1.3 
6.895*63.9
