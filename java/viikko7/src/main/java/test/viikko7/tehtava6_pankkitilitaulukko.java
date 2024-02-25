package test.viikko7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.*;

public class tehtava6_pankkitilitaulukko {

    // alustetaan muutama tili
    tehtava6_tili[] tilit = new tehtava6_tili[10];

    // Luodaan tiedostopolku sekä tiedosto-olio
    String tiedostoPolku = "tilit.dat";
    File tiedostonTarkistaja = new File(tiedostoPolku);

    public tehtava6_pankkitilitaulukko() {
        // Tarkistetaan, onko tiedostoa olemassa
        if (tiedostonTarkistaja.exists()) {
            // Yritetään lukea Tili-oliot tiedostosta
            ObjectInputStream virrastaOlioksi;
            try {
                FileInputStream tiedostostaVirta = new FileInputStream(tiedostoPolku);
                virrastaOlioksi = new ObjectInputStream(tiedostostaVirta);
                for (int i = 0; i < tilit.length; i++) {
                    tilit[i] = (tehtava6_tili) virrastaOlioksi.readObject();
                }
                virrastaOlioksi.close(); // Suljetaan tiedosto
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        // Jos tiedostoa ei ole, täytetään tili-taulukko.
        else {
            for (int i = 0; i < 10; i++) {
                tilit[i] = new tehtava6_tili(i + 1, 100);
            }
        }
    }

    public void talletaTilit() {
        ObjectOutputStream oliostaVirraksi;
        try {
            FileOutputStream virrastaTiedostoon = new FileOutputStream(tiedostoPolku);
            oliostaVirraksi = new ObjectOutputStream(virrastaTiedostoon);
            for (tehtava6_tili tiliOlio : tilit) {
                oliostaVirraksi.writeObject(tiliOlio);
            }
            oliostaVirraksi.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
