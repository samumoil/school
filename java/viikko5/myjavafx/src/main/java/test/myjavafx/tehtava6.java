package test.myjavafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tehtava6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        // Reunus kuvalle
        Rectangle reunus = new Rectangle(560, 210, Color.WHITE);
        reunus.setStroke(Color.BLACK);

        // Mikron ovi ja sisällä näkyvä ruoka
        Image ruoka = new Image("file:ruokalautanen.png", 200, 200, true, true);
        ImageView ruokaNaytto = new ImageView(ruoka);
        Rectangle oviSuorakulmio = new Rectangle(300, 200, Color.WHITE);
        oviSuorakulmio.setStroke(Color.BLACK);
        StackPane paneeliOvi = new StackPane(oviSuorakulmio, ruokaNaytto);
        paneeliOvi.relocate(40, 5); // Sijoitetaan ovi oikeaan kohtaan

        // Numeronäyttö
        Rectangle numeroNaytonTausta = new Rectangle(150, 40, Color.WHITE);
        numeroNaytonTausta.setStroke(Color.BLACK);
        Text numeroNaytonNumerot = new Text("0:00");
        StackPane numeroNaytto = new StackPane(numeroNaytonTausta, numeroNaytonNumerot);
        numeroNaytonNumerot.setFont(new Font(16)); // Säädetään fonttia isommaksi
        numeroNaytto.relocate(400, 5);

        // Napit numeronäytön alla
        HBox nappiRivi = new HBox(new Button("Start"), new Button("Stop"), new Button("Clear"));
        nappiRivi.relocate(400, 46);

        // Teksti oikeaan alanurkkaan
        Text MIKROAALTOUUNI = new Text("MIKROAALTOUUNI");
        MIKROAALTOUUNI.setFont(new Font(16));
        MIKROAALTOUUNI.relocate(400, 180);

        // Asetellaan palaset paikoilleen. Sijainnit on määritelty .relocate-metodilla jokaiselle erikseen.
        Pane paneeliFinal = new Pane();
        paneeliFinal.getChildren().addAll(
                reunus,
                paneeliOvi,
                numeroNaytto,
                nappiRivi,
                MIKROAALTOUUNI
        );

        Scene kehys = new Scene(paneeliFinal);
        lava.setScene(kehys);
        lava.setTitle("Tehtävä 6");
        lava.show();
    }
}
