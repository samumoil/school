package test.viikko7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tehtava3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {

        BorderPane finalPane = new BorderPane();

        // Luodaan kellotaulun olio
        tehtava3_kellopaneeli kello = new tehtava3_kellopaneeli();

        // Tekstit ja kentät
        Text tekstiTunnit = new Text("Tunnit");
        Text tekstiMinuutit = new Text("Minuutit");
        Text tekstiSekunnit = new Text("Sekunnit");
        TextField kenttaTunnit = new TextField();
        TextField kenttaMinuutit = new TextField();
        TextField kenttaSekunnit = new TextField();
        HBox tekstiPaneeli = new HBox();
        tekstiPaneeli.getChildren().addAll(tekstiTunnit, kenttaTunnit,
                tekstiMinuutit, kenttaMinuutit, tekstiSekunnit, kenttaSekunnit);
        tekstiPaneeli.setSpacing(10);

        // Asetellaan asiat paikoilleen
        finalPane.setCenter(kello);
        finalPane.setTop(tekstiPaneeli);

        // Toiminnallisuudet
        kenttaTunnit.setOnAction(e -> {
            kello.setTunti(Integer.parseInt(kenttaTunnit.getText()));
            kenttaTunnit.clear();
        });
        kenttaMinuutit.setOnAction(e -> {
            kello.setMinuutti(Integer.parseInt(kenttaMinuutit.getText()));
            kenttaMinuutit.clear();
        });
        kenttaSekunnit.setOnAction(e -> {
            kello.setSekunti(Integer.parseInt(kenttaSekunnit.getText()));
            kenttaSekunnit.clear();
        });


        Scene kehys = new Scene(finalPane, 400,400);
        lava.setScene(kehys);
        lava.setTitle("Aseta kellolle aika");
        lava.show();
    }
}
