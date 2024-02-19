package test.viikko6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class tehtava5 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        // Luodaan olio apuluokasta.
        tehtava5_hirsipuu hirsipuuOlio = new tehtava5_hirsipuu();

        // Laitetaan tämän luokan käyttämä paneeli osoittamaan hirsipuu-olion
        // "paneeli"-muuttujan muistiosoitteeseen. Nyt hirsipuu-oliossa tehtävät
        // muutokset näkyvät täälläkin.
        Pane hirsipuuPaneeli = hirsipuuOlio.paneeli;
        //hirsipuuPaneeli.setOnMouseClicked(hirsipuuOlio);

        tehtava5_kirjainNaytto kirjainNayttoOlio = new tehtava5_kirjainNaytto("KIRJAIMET");
        FlowPane kirjainNayttoPaneeli = kirjainNayttoOlio.kirjainRivi;
        GridPane kirjainNayttoPaneeli2 = kirjainNayttoOlio.kirjainRivi2;

        StackPane yhdistettyPaneeli = new StackPane(hirsipuuPaneeli, kirjainNayttoPaneeli2);
        Scene kehys = new Scene(yhdistettyPaneeli);
        lava.setScene(kehys);
        lava.setHeight(432);
        lava.setWidth(321);
        lava.setTitle("Tehtävä 5");
        lava.show();
    }
}
