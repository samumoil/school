
// ---------- Main.java ----------
import java.io.*;

public class Main {
        public static void main(String [] args) throws IOException {
                // ########## b-kohta ##########
                // Luodaan taulukko ja sijoitetaan sinne ympyra-oliot.
                Ympyra[] taulukko = new Ympyra[10];
                for (int i=0; i<taulukko.length; i++){
                        taulukko[i] = new Ympyra(i+1); // Pakko antaa jotain, joten annetaan ympyröiden säteeksi indeksi+1.
                }

                // Luodaan oliot kirjoitusta varten ja kirjoitetaan tiedostoon Ympyra-oliot.
                String tiedostoPolku = "Ympyra.dat";
                ObjectOutputStream olionMuuttajaOlio = null;
                try {
                        FileOutputStream tiedostoonVirta = new FileOutputStream(tiedostoPolku);
                        olionMuuttajaOlio = new ObjectOutputStream(tiedostoonVirta);
                        for (int i = 0; i < taulukko.length; i++){
                                olionMuuttajaOlio.writeObject(taulukko[i]);
                                System.out.println("Tällainen ympyrä lisättiin tiedostoon: " + taulukko[i]);
                        }
                } catch (Exception exception) {
                        exception.printStackTrace();
                } finally {
                        try {   // Suljetaan kirjoitusolio, jos se on olemassa.
                                if (olionMuuttajaOlio != null) {
                                        olionMuuttajaOlio.close();
                                }
                        } catch (IOException ex) {
                                ex.printStackTrace();
                        }
                }


                // ########## c-kohta ##########
                // Luodaan uusi taulukko luettaville olioille.
                Ympyra[] uusiTaulukko = new Ympyra[10];

                // Tarkistetaan, onko tiedostoa olemassa ja pysäytetään koodin ajo, jos sitä ei ole.
                File tarkistusOlio = new File(tiedostoPolku);
                if (!tarkistusOlio.exists()){  System.exit(1);  }

                // Luodaan oliot lukemista varten ja luetaan tiedostosta Ympyra-oliot.
                ObjectInputStream olioksiMuuttajaOlio = null;
                try {
                        FileInputStream tiedostostaVirta = new FileInputStream(tiedostoPolku);
                        olioksiMuuttajaOlio = new ObjectInputStream(tiedostostaVirta);
                        for (int i = 0; i < uusiTaulukko.length; i++) {
                                uusiTaulukko[i] = (Ympyra) olioksiMuuttajaOlio.readObject();
                        }
                } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                } catch (IOException ex) {
                        ex.printStackTrace();
                } finally {
                        try {
                                if (olioksiMuuttajaOlio != null) {
                                        olioksiMuuttajaOlio.close();
                                }
                        } catch (IOException ex) {
                                ex.printStackTrace();
                        }
                }

                // Tulostetaan luettu taulukko näkyviin.
                for (Ympyra ympyraOlio : uusiTaulukko) {
                        System.out.println("Tällainen ympyrä luettiin tiedostosta: " + ympyraOlio);
                }
        }
}
