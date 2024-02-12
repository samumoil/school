
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;

public class Pankkiautomaatti {
    public Tili[] tilit = new Tili[10];
    // Tarkistetaan onko tilit.dat olemassa
    public Pankkiautomaatti() {
        if (Files.exists(Path.of("tilit.dat"))){
            try (FileInputStream fis = new FileInputStream("tilit.dat");
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                Object o = null;
                int i = 0;
                while ((o = ois.readObject()) != null)   {
                    if (o instanceof Tili)
                        this.tilit[i] = (Tili) o;
                    i++;
                }
            } catch (IOException e) {
                //Käsittele error
            } catch (ClassNotFoundException e) {
                //Käsittele error
            }
        }
        // Jos tilit.dat ei ole olemassa
        else {
            for (int i = 0; i < 10; i++) {
                this.tilit[i] = new Tili(i+1, 100);
            }
        }
    }

    public void saldo(int i) {
        System.out.println("Tilin " + i + " saldo on " + this.tilit[i].getSaldo());
    }
    public void nosto(int i, double summa) {
        this.tilit[i].nosta(summa);
    }
    public void pano(int i, double summa) {
        this.tilit[i].talleta(summa);
    }

    public static void kysy_tilinumero() {
        System.out.println("Mitä tiliä haluat käsitellä (1-10, 0 = lopetus)");
    }

    public static void tulostaValikko() {
        System.out.println("Mitä haluat tehdä: ");
        System.out.println("1. saldon tarkistus");
        System.out.println("2. nosto");
        System.out.println("3. pano");
        System.out.println("4. poistu");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String jatkatko;
        int valinta;
        int tili;
        double summa;
        boolean jatka;
        // alustetaan tilit
        Pankkiautomaatti pankki = new Pankkiautomaatti();

        do {
            kysy_tilinumero();
            tili = input.nextInt();
            if (tili > 0 && tili < 10) {
                jatka = true;

                do {
                    tulostaValikko();
                    valinta = input.nextInt();
                    switch (valinta) {
                        case 1: {
                            pankki.saldo(tili);
                            break;
                        }
                        case 2: {
                            System.out.println("Paljonko haluat nostaa?");
                            summa = input.nextDouble();
                            pankki.nosto(tili, summa);
                            break;
                        }

                        case 3: {
                            System.out.println("Paljonko talletat?");
                            summa = input.nextDouble();
                            pankki.pano(tili, summa);
                            break;
                        }

                        case 4:
                            jatka = false;
                    }
                } while (jatka);
            }

        } while (tili > 0 && tili < 10);
        try (FileOutputStream fout = new FileOutputStream("tilit.dat");
             ObjectOutputStream out = new ObjectOutputStream(fout)) {
            for (Tili kirjoitatili : pankki.tilit) {
                out.writeObject(kirjoitatili);
            }
            out.close();
            fout.close();
            System.out.println("Tilien saldot kirjoitettu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
