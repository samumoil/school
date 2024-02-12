library(datas4uef)
data("aineistoA_dat")
summary(aineistoA_dat)
head(aineistoA_dat)

# Tehtävä 1
sort(aineistoA_dat$ikä)
50*0.25
50*0.75

#Tehtävä 2
median(aineistoA_dat$ikä)
quantile(aineistoA_dat$ikä)
boxplot(aineistoA_dat$ikä,horizontal=1)

#Tehtävä 3
head(aineistoA_dat$matem_pisteet, 4)
(90+99+99+104)/4
((90-98)^2+(99-98)^2+(99-98)^2+(104-98)^2)/3
34^(1/2)
(90+99+99+104)

mean(head(aineistoA_dat$matem_pisteet, 4))
var(head(aineistoA_dat$matem_pisteet, 4))
sd(head(aineistoA_dat$matem_pisteet, 4))

#Tehtävä 4
x <- c(5.2, 9.3, 9.7, 8.0, 10.1, 7.5)
mean(x)
sd(x)

3+2*x
y <- 3+2*x

6.2^2
2^2
2.8^2
-0.6^2
3.6^2
-1.6^2

6.2^2 + 2^2 + 2.8^2 + 0.6^2 + 3.6^2 + 1.6^2
((6.2^2 + 2^2 + 2.8^2 + 0.6^2 + 3.6^2 + 1.6^2)/5)^(1/2)

3+(2*8.3)
2*1.818791

sd(y)
