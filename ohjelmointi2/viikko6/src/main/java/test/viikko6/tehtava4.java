package test.viikko6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class tehtava4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        // Luodaan olio apuluokasta.
        tehtava4_hirsipuu hirsipuu = new tehtava4_hirsipuu();

        // Laitetaan tämän luokan käyttämä paneeli osoittamaan hirsipuu-olion
        // "paneeli"-muuttujan muistiosoitteeseen. Nyt hirsipuu-oliossa tehtävät
        // muutokset näkyvät täälläkin.
        Pane paneeli = hirsipuu.paneeli;

        paneeli.setOnMouseClicked(hirsipuu);

        Scene kehys = new Scene(paneeli);
        lava.setScene(kehys);
        lava.setHeight(432);
        lava.setWidth(321);
        lava.setTitle("Tehtävä 4");
        lava.show();
    }
}
