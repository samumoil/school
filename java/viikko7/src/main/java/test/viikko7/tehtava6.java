package test.viikko7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class tehtava6 extends Application {

    // Luodaan näkymä apuluokan avulla. Katso näkymän yksityiskohdat tiedostosta tehtava6_nakyma.java
    tehtava6_nakyma nakymaOlio = new tehtava6_nakyma();
    BorderPane finalPane = nakymaOlio.nakyma;

    // Luodaan/luetaan pankkitilit apuluokan avulla. Katso yksityiskohdat tiedostosta tehtava6_pankkitilitaulukko.java
    tehtava6_pankkitilitaulukko tilitaulukkoOlio = new tehtava6_pankkitilitaulukko();

    // Muuttuja käsiteltävän tilin valintaan
    int valittuTiliIndeksi = -1;

    /**
     * Tämä metodi päivittää keskellä näkyvän tekstialueen sisällön.
     */
    void paivitaNaytto() {
        nakymaOlio.tekstiAlue.setText("Tilin " + (valittuTiliIndeksi +1) + " tiedot" +
                "\nVuosikorko = " + tilitaulukkoOlio.tilit[valittuTiliIndeksi].getVuosiKorko() +
                "\nSaldo = " + tilitaulukkoOlio.tilit[valittuTiliIndeksi].getSaldo());
    }

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage lava) {

        // Tilivalinnan toiminnallisuus
        nakymaOlio.tiliLista.getSelectionModel().selectedItemProperty().addListener(e -> {
            valittuTiliIndeksi = nakymaOlio.tiliLista.getSelectionModel().getSelectedIndex();
            paivitaNaytto();
        });

        // Nappien toiminnallisuus
        nakymaOlio.nappiNosta.setOnAction(e -> {
            double nostoSumma = Double.parseDouble(nakymaOlio.summaKentta.getText());
            tilitaulukkoOlio.tilit[valittuTiliIndeksi].nosta(nostoSumma);
            paivitaNaytto();
        });
        nakymaOlio.nappiTalleta.setOnAction(e -> {
            double talletusSumma = Double.parseDouble(nakymaOlio.summaKentta.getText());
            tilitaulukkoOlio.tilit[valittuTiliIndeksi].talleta(talletusSumma);
            paivitaNaytto();
        });
        nakymaOlio.nappiLopeta.setOnAction(e -> {
            tilitaulukkoOlio.talletaTilit();
            System.exit(0);
        });


        Scene kehys = new Scene(finalPane, 600,400);
        lava.setScene(kehys);
        lava.setTitle("Käsittele pankkitiliä:");
        lava.show();
    }

}
