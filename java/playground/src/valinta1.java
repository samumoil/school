
/*
public class valinta1 {
    public static void tiliNumeronValinta(){
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
}
*/