import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner skanneri = new Scanner(System.in);
        int valinta;

        System.out.println("\nTämä on ohjelman alustaja: Kuinka monta tiliä luodaan? (1-999)");
        valinta = skanneri.nextInt();
        // Syötetään haluttu tilien määrä LuoMalliTilit luokan metodille luoTilit, joka palauttaa taulukon pääohjelman käyttöön.
        Pankkitili[] tiliTaulukko = LuoMalliTilit.luoTilit(valinta);

        // Tämän muotoisella odottajalla varmistetaan, että käyttäjä ehtii lukea ohjelman antamat tiedot.
        System.out.printf("(Paina Enter) " + skanneri.nextLine()); // Syödään edellisen valinnan lopusta rivinvaihto pois, jotta ao. odottaja toimii.
        skanneri.nextLine();

        boolean jatkuu = true;
        int valittuTilinumero = 0;
        int valitunTilinIndeksi = 9999;

        while (jatkuu == true){
            System.out.println("------------------------------------------------" +
                    "\nTervetuloa verkkopankkiin!\n" +
                    "Tällä hetkellä valittuna on tilinumero: " + valittuTilinumero +
                    "\n\nValitse toiminto 1-5:" +
                    "\n1) Anna tilinumero" +
                    "\n2) Tarkista saldo" +
                    "\n3) Nosta rahaa tililtä" +
                    "\n4) Talleta rahaa tilille" +
                    "\n5) Sulje ohjelma ja poistu verkkopankista");
            valinta = skanneri.nextInt();

            if (valinta == 1) {
                boolean validiTilinumero = false;
                // Tarkistetaan, onko annettu tilinumero olemassa
                while (!validiTilinumero) {
                    System.out.println("Toiminto 1\nValitse tili antamalla tilinumero: ");
                    valittuTilinumero = skanneri.nextInt();

                    // Poistutaan kierrokselta, jos käyttäjä valitsee "9999"
                    if (valittuTilinumero == 9999){
                        validiTilinumero = true;
                        valittuTilinumero = 0;
                    }

                    else {
                        System.out.println("Annoit tilinumeron: " + valittuTilinumero);

                        // Tarkistetaan, onko tilinumeroa olemassa. Samalla muunnetaan saatu tilinumero indeksimuotoon
                        for (int i = 0; i < tiliTaulukko.length; i++) {
                            if (tiliTaulukko[i].getId() == valittuTilinumero) {
                                valitunTilinIndeksi = i;
                                validiTilinumero = true;
                            }
                        }
                        if (!validiTilinumero) {
                            System.out.println("\nAnnettua tilinumeroa ei ole olemassa. Anna oikea tilinumero. Poistu antamalla numero \"9999\".\n");
                        }
                    }
                }

                System.out.printf("\n(Paina Enter) " + skanneri.nextLine()); // Syödään edellisen valinnan lopusta rivinvaihto pois, jotta ao. odottaja toimii.
                skanneri.nextLine();
            }

            else if (valinta == 2) {
                if (valittuTilinumero == 0) {
                    System.out.println("Virhe. Anna ensin tilinumero.");
                }
                else {
                    System.out.println("Toiminto 2\nValitun tilin saldo on " + tiliTaulukko[valitunTilinIndeksi].getSaldo() + " euroa.");
                }

                System.out.printf("\n(Paina Enter) " + skanneri.nextLine()); // Syödään edellisen valinnan lopusta rivinvaihto pois, jotta ao. odottaja toimii.
                skanneri.nextLine();
            }

            else if (valinta == 3) {
                if (valittuTilinumero == 0) {
                    System.out.println("Virhe. Anna ensin tilinumero.");
                }
                else {
                    System.out.println("Toiminto 3\n" +
                            "Kuinka paljon rahaa haluat nostaa tililtä?\n" +
                            "(Tilin saldo on nyt " + tiliTaulukko[valitunTilinIndeksi].getSaldo() + " euroa.)");
                    double nostoSumma = skanneri.nextDouble();
                    tiliTaulukko[valitunTilinIndeksi].nosta(nostoSumma);
                    System.out.println("Nostit " + nostoSumma + " euroa.\n" +
                            "Valitun tilin saldo on nyt " + tiliTaulukko[valitunTilinIndeksi].getSaldo() + " euroa.");
                }
                System.out.printf("\n(Paina Enter) " + skanneri.nextLine()); // Syödään edellisen valinnan lopusta rivinvaihto pois, jotta ao. odottaja toimii.
                skanneri.nextLine();
            }

            else if (valinta == 4) {
                if (valittuTilinumero == 0) {
                    System.out.println("Virhe. Anna ensin tilinumero.");
                }
                else {
                    System.out.println("Toiminto 4\n" +
                            "Kuinka paljon rahaa haluat tallettaa tilille?");
                    double talletusSumma = skanneri.nextDouble();
                    tiliTaulukko[valitunTilinIndeksi].talleta(talletusSumma);

                    System.out.println("Talletit " + talletusSumma + " euroa.\n" +
                            "Valitun tilin saldo on nyt " + tiliTaulukko[valitunTilinIndeksi].getSaldo() + " euroa.");
                }
                System.out.printf("\n(Paina Enter) " + skanneri.nextLine()); // Syödään edellisen valinnan lopusta rivinvaihto pois, jotta ao. odottaja toimii.
                skanneri.nextLine();

            }

            else if (valinta == 5) {
                System.out.println("Kiitos ja näkemiin!\n");
                jatkuu = false;
            }
        }
    }
}
