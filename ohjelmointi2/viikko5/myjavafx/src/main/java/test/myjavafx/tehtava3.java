package test.myjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.security.auth.login.CredentialException;

public class tehtava3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {

        /*
        Tässä ratkaisussa olioita ei ole kiinnitetty X/Y-koordinaatistoon.
        Sen sijaan tässä luodaan osittain sisäkkäisiä olioita, jotka sijoitetaan
        ikkunan keskelle VBox ja StackPane -olioiden avulla. Kaikkien olioiden
        sekä ikkunan koko riippuu muuttujasta "koko", jolloin kuvaa voi helposti
        skaalata.
         */

        int koko = 30;

        Circle ympyraPun = new Circle(koko);
        ympyraPun.setStroke(Color.BLACK);
        ympyraPun.setFill(Color.RED);

        Circle ympyraKelt = new Circle(koko);
        ympyraKelt.setStroke(Color.BLACK);
        ympyraKelt.setFill(Color.YELLOW);

        Circle ympyraVihr = new Circle(koko);
        ympyraVihr.setStroke(Color.BLACK);
        ympyraVihr.setFill(Color.GREEN);

        // Sijoitetaan pallot päällekkäin ja keskelle ruutua.
        VBox vertikaaliPallot = new VBox(koko/2);
        vertikaaliPallot.setAlignment(Pos.CENTER); // Ilman tätä pallot sijoittuvat vasempaan yläkulmaan.
        vertikaaliPallot.getChildren().addAll(ympyraPun, ympyraKelt, ympyraVihr);

        // Luodaan laatikko, joka tulee valojen ympärille.
        Rectangle laatikko = new Rectangle(
                koko*3,
                koko*8,
                Color.WHITE);
        laatikko.setStroke(Color.BLACK);

        // Luodaan laatikon ja pallojen muodostama "yläosa".
        Pane laatikkoJaPallot = new StackPane();
        laatikkoJaPallot.getChildren().addAll(laatikko, vertikaaliPallot);

        // Valotolpan jalka. Tämän koko suhteessa yläosaan on saatu kokeilemalla.
        Rectangle jalka = new Rectangle(
                laatikko.getWidth()/3,
                laatikko.getHeight()/5*4,
                Color.BROWN);
        jalka.setStroke(Color.BLACK);

        // Sijoitetaan valotolpan yläosa ja jalka päällekkäin.
        VBox valotolppa = new VBox(laatikkoJaPallot, jalka);
        valotolppa.setAlignment(Pos.CENTER);

        Scene kehys = new Scene(valotolppa, koko*12,koko*20);
        lava.setScene(kehys);
        lava.setTitle("Tehtävä 3");
        lava.show();
    }
}
