package test.viikko7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;
public class tehtava1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {

        // Tämä on valotolpan koko. Jäänne valotolppa-tehtävästä aiemmalta viikolta.
        // Voit kokeilla muuttaa tätä.
        int koko = 20;

        // Luodaan olio luokasta tehtava1_valotolppa ja käytetään sen
        // getValotolppa-metodia, jolla saadaan pääohjelmaan liikennevalot
        // StackPane-muodossa.
        tehtava1_valotolppa valotolppaOlio = new tehtava1_valotolppa(koko);
        StackPane valotolppa = new StackPane(valotolppaOlio.getValotolppa());

        // Luodaan napit, nappiryhmä, paneeli napeille ja liitetään paneeliin.
        RadioButton nappiPun = new RadioButton("Punainen");
        RadioButton nappiKelt = new RadioButton("Keltainen");
        RadioButton nappiVihr = new RadioButton("Vihreä");
        RadioButton nappiJoku = new RadioButton("Joku");
        VBox nappiPaneeli = new VBox();
        nappiPaneeli.setPadding(new Insets(50,50,50,50));
        nappiPaneeli.setSpacing(10);
        nappiPaneeli.getChildren().addAll(nappiPun, nappiKelt, nappiVihr, nappiJoku);

        ToggleGroup nappiRyhma = new ToggleGroup();
        nappiPun.setToggleGroup(nappiRyhma);
        nappiKelt.setToggleGroup(nappiRyhma);
        nappiVihr.setToggleGroup(nappiRyhma);
        nappiJoku.setToggleGroup(nappiRyhma);

        // Nappien toiminnallisuus
        nappiPun.setOnAction(e -> valotolppaOlio.setPunainen());
        nappiKelt.setOnAction(e -> valotolppaOlio.setKeltainen());
        nappiVihr.setOnAction(e -> valotolppaOlio.setVihrea());
        nappiJoku.setOnAction(e -> valotolppaOlio.setRandom());

        // Asetellaan kaikki lopullisesti paikoilleen.
        BorderPane finalPane = new BorderPane();
        finalPane.setCenter(valotolppa);
        finalPane.setLeft(nappiPaneeli);
        nappiPaneeli.setAlignment(Pos.CENTER_LEFT);

        Scene kehys = new Scene(finalPane, (koko*10)+200,koko*20);
        lava.setScene(kehys);
        lava.setTitle("Aseta liikennevalo");
        lava.show();
    }
}
