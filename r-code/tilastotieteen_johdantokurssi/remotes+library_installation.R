# Valmistellaan R-Studio ohjelmaa
install.packages("remotes")

# Asennettaan tietty paketti
remotes::install_github("jukop/datas4uef")

# Otetaan kirjasto käyttöön
library(datas4uef)

# Luodaan data.frame kirjaston tietystä osasta "aineistoA_dat"
data("aineistoA_dat")
