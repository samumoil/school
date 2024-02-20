package test.viikko6;

import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

class tehtava5_kirjainNaytto {
    GridPane kirjainRivi = new GridPane(5, 5);
    private String sana;
    private char[] sanaArray;
    private boolean voititPelin = false;

    public tehtava5_kirjainNaytto(String annettuSana) {
        this.sana = annettuSana.toLowerCase();
        sanaArray = new char[sana.length()];
        for (int i = 0; i < sana.length(); i++) {
            sanaArray[i] = (annettuSana.toLowerCase()).charAt(i);
            kirjainRivi.add(new Text("_"), i, 0);
        }
    }
    public boolean tarkistaja(char arvausLower) {
        boolean olikoOikein = false;
        kirjainRivi.getChildren().clear(); // Tyhjennetään gridpane ja seuraavaksi täytetään se uudestaan.

        // Tarkastus
        for (int i = 0; i < sana.length(); i++) { // Käydään läpi aiemmin tallennettu sana kirjain kerrallaan.
            if (Character.toLowerCase(sanaArray[i]) == arvausLower) { // Verrataan arvausta taulukosta löytyvään pieneen kirjaimeen.
                sanaArray[i] = Character.toUpperCase(arvausLower); // Merkitään uudet oikeat arvaukset isolla kirjaimella.
                olikoOikein = true;

                // Jokaisen oikean arvauksen jälkeen tarkastetaan, onko jäljellä arvattavia kirjaimia.
                boolean voittoTarkastaja = true;
                for (char j : sanaArray) {
                    if (Character.isLowerCase(j)) voittoTarkastaja = false;
                }
                if (voittoTarkastaja) voititPelin = true;
            }
        }
        // Uuden rivin kirjaus
        for (int i = 0; i < sana.length(); i++) {
            if (Character.isUpperCase(sanaArray[i])) {
                kirjainRivi.add(new Text(Character.toString(sanaArray[i])), i, 0); // Merkitään oikein arvattu kirjain taulukkoon isona.
            } else {
                kirjainRivi.add(new Text("_"), i, 0); // Väärät arvaukset on yhä merkitty alaviivalla.
            }

        }
        return olikoOikein;
    }

    public boolean getVoititPelin() {  return voititPelin;  }
    public String getSana() {  return sana;  }
}
