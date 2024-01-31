import java.util.Scanner;

// ########## b-kohta ##########
public class Main {
        public static void main(String [] args) {
                Kirjoitelma kirj1 = new Kirjoitelma();
                Scanner skanneri = new Scanner(System.in);

                System.out.println("Anna pisteet kirjoitelman kieliopista: ");
                kirj1.setKielioppi(skanneri.nextDouble());
                System.out.println("Anna pisteet kirjoitelman oikeinkirjoituksesta: ");
                kirj1.setOikeinkirjoitus(skanneri.nextDouble());
                System.out.println("Anna pisteet kirjoitelman pituudesta: ");
                kirj1.setPituus(skanneri.nextDouble());
                System.out.println("Anna pisteet kirjoitelman sisällöstä: ");
                kirj1.setSisalto(skanneri.nextDouble());

                System.out.println("\nKirjoitelman pisteet olivat:" +
                        "\nKielioppi:\t\t" + kirj1.getKielioppi() +
                        "\nOikeinkirjoitus:" + kirj1.getOikeinkirjoitus() +
                        "\nPituus:\t\t\t" + kirj1.getPituus() +
                        "\nSisältö:\t\t" + kirj1.getSisalto() +
                        "\n\nYhteensä:\t\t" + kirj1.getPisteet()
                );

                // Odottaja jättää ohjelman pyörimään, kunnes käyttäjä painaa enteriä
                System.out.printf("\n(Paina Enter) " + skanneri.nextLine()); // Syödään edellisen valinnan lopusta rivinvaihto pois, jotta ao. odottaja toimii.
                skanneri.nextLine();
        }
}
