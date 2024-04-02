// ---------- Pankki.java ----------
import java.io.*;
import java.util.Scanner;
public class Pankki {
    public static Scanner input = new Scanner(System.in);
    public static void tulostaValikko() {
        System.out.println("Mitä haluaisit tehdä: ");
        System.out.println("1. Tilin valinta (tilinumero väliltä 1-10)");
        System.out.println("2. Saldon tarkistus.");
        System.out.println("3. Rahan nosto tililtä.");
        System.out.println("4. Rahan tallennus tilille. ");
        System.out.println("5. Poistuminen ohjelmasta.");

    }
    public static int lueValinta() {
        int valinta = -1;
        valinta = Integer.parseInt(input.nextLine());
        while ((valinta < 1) || (valinta > 5)) {
            System.out.println("Virheellinen valinta. Anna luku väliltä 1-5. ");
            valinta = Integer.parseInt(input.nextLine());
        }
        return valinta;
    }

    public static void main(String[] args) {
        // alustetaan muutama tili
        Tili [] tilit = new Tili[10];

        // Tarkistetaan, onko tiedostoa olemassa. (b-kohta)
        String tiedostoPolku = "tilit.dat";
        File tiedostonTarkistaja = new File(tiedostoPolku);
        // ########## a-kohta ##########
        if (tiedostonTarkistaja.exists()){
                // Yritetään lukea Tili-oliot tiedostosta
                ObjectInputStream virrastaOlioksi;
                try {
                    FileInputStream tiedostostaVirta = new FileInputStream(tiedostoPolku);
                    virrastaOlioksi = new ObjectInputStream(tiedostostaVirta);
                    for (int i = 0; i < tilit.length; i++) {
                        tilit[i] = (Tili) virrastaOlioksi.readObject();
                    }
                    virrastaOlioksi.close(); // Suljetaan tiedosto
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
        }
        // ########## b-kohta ##########
        // Jos tiedostoa ei ole, täytetään tili-taulukko.
        else {
            for (int i = 0; i < 10; i++) {
                tilit[i] = new Tili( i+1, 100);
            }
        }

        int valinta = 0;
        double summa;
        int tili = 0; // oletustili 1
        while (valinta != 5) {
            tulostaValikko();
            valinta = lueValinta();

            if ((valinta > 0) && (valinta < 5)) {
                System.out.println("Käsitellään tiliä " + (tili+1));
                if (valinta == 1) {
                    System.out.println(("Mitä tiliä käsitellään?"));
                    tili = Integer.parseInt(input.nextLine())-1;
                    while ((tili<1) || (tili > 10)) {
                        System.out.println("Tiliä ei ole olemassa.");
                        System.out.println("Anna tilinumero 1-10: ");
                        System.out.println(("Mitä tiliä käsitellään?"));
                        tili = Integer.parseInt(input.nextLine());
                    }
                }
                if (valinta == 2) {
                    System.out.println("Tilin saldo on: " + tilit[tili].getSaldo());
                }
                if (valinta == 3) {
                    System.out.println("Mikä summa nostetaan?");
                    summa = Double.parseDouble(input.nextLine());
                    tilit[tili].nosta(summa);
                }
                if (valinta == 4) {
                    System.out.println("Paljonko talletetaan: ");
                    summa = Double.parseDouble(input.nextLine());
                    tilit[tili].talleta(summa);
                }
            }
        }

        System.out.println("Kiitos kun käytit tiliohjelmaa. ");

        // ########## c-kohta ##########
        ObjectOutputStream oliostaVirraksi;
        try {
            FileOutputStream virrastaTiedostoon = new FileOutputStream(tiedostoPolku);
            oliostaVirraksi = new ObjectOutputStream(virrastaTiedostoon);
            for (Tili tiliOlio : tilit) {
                oliostaVirraksi.writeObject(tiliOlio);
            }
            oliostaVirraksi.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}