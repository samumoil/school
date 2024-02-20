package test.viikko6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tehtava5 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {

        String arvattavaSana = "kirjaimet";

        // Luodaan hirsipuu-olio apuluokasta.
        tehtava5_hirsipuu hirsipuuOlio = new tehtava5_hirsipuu();
        // Laitetaan tämän luokan käyttämä paneeli osoittamaan hirsipuu-olion
        // "paneeli"-muuttujan muistiosoitteeseen. Nyt hirsipuu-oliossa tehtävät
        // muutokset näkyvät täälläkin.
        Pane hirsipuuPaneeli = hirsipuuOlio.paneeli;
        //hirsipuuPaneeli.setOnMouseClicked(hirsipuuOlio);

        // Luodaan olio kirjainnäytöstä. Toteutetaan samanlainen muistiosoitteeseen viittaus tässäkin.
        tehtava5_kirjainNaytto kirjainNayttoOlio = new tehtava5_kirjainNaytto(arvattavaSana);
        GridPane kirjainNayttoPaneeli = kirjainNayttoOlio.kirjainRivi;

        VBox lopputulosNaytto = new VBox();
        lopputulosNaytto.setAlignment(Pos.TOP_RIGHT);

        StackPane yhdistettyPaneeli = new StackPane(hirsipuuPaneeli, kirjainNayttoPaneeli, lopputulosNaytto);
        Scene kehys = new Scene(yhdistettyPaneeli);

        kehys.setOnKeyTyped(e -> {
            char arvausLower = Character.toLowerCase(e.getCharacter().charAt(0));
            if (Character.isAlphabetic(arvausLower)) {
                if (!kirjainNayttoOlio.tarkistaja(arvausLower)) {
                    hirsipuuOlio.vaarinMeni();
                }
            }
            if (hirsipuuOlio.getHavisitPelin()) {
                lopputulosNaytto.getChildren().add(new Text("HÄVISIT!"));
            }
            if (kirjainNayttoOlio.getVoititPelin()) {
                lopputulosNaytto.getChildren().add(new Text("Oikea sana oli: \n" + kirjainNayttoOlio.getSana().toUpperCase() + "\nVoitit pelin!"));
            }
        });

        lava.setScene(kehys);
        lava.setHeight(432);
        lava.setWidth(321);
        lava.setTitle("Tehtävä 5");
        lava.show();
    }
}
