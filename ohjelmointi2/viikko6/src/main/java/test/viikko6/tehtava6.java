package test.viikko6;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class tehtava6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        tehtava6_mikro mikroOlio = new tehtava6_mikro();
        Pane paneeliFinal = mikroOlio.paneeliFinal;
        Scene kehys = new Scene(paneeliFinal);

        // Hoidetaan ensin laskurin koodi.
        // Tämä on se asia, jota toistetaan.
        EventHandler<ActionEvent> vahennaLukua = e -> {
            String uusiAika = Integer.toString(mikroOlio.getAika()-1);
            mikroOlio.setAika(uusiAika);
            if (Integer.parseInt(uusiAika) == 0)
                mikroOlio.setRuokaValmis();
        };

        Timeline laskuri = new Timeline(new KeyFrame(Duration.seconds(1), vahennaLukua));

        // Nappien toiminta.
        mikroOlio.start.setOnAction(e -> {
            laskuri.setCycleCount(mikroOlio.getAika());
            laskuri.play();
        });
        mikroOlio.stop.setOnAction(e -> {
            laskuri.pause();
        });
        mikroOlio.clear.setOnAction(e -> {
            laskuri.stop();
            mikroOlio.setRuokakuva();
            mikroOlio.setAika("0");
        });

        // Lämmitysajan lisääminen.
        kehys.setOnKeyTyped(e -> {
            char painettuNappain = e.getCharacter().charAt(0);
            if (!(laskuri.getStatus() == Animation.Status.RUNNING)) { // Ei lisätä aikaa, jos laskuri on käynnissä.
                if (Character.isDigit(painettuNappain)) mikroOlio.lisaaAikaa(e.getCharacter()); // Varmistetaan, että painettu on numero ja lisätään se.
            }
        });

        // Hiiren sijainnilla aktivoituva teksti.
        mikroOlio.paneeliOvi.setOnMouseEntered(e -> mikroOlio.setKohtaValmis() );
        mikroOlio.paneeliOvi.setOnMouseExited(e -> mikroOlio.setRuokakuva() );

        lava.setScene(kehys);
        lava.setTitle("Tehtävä 6");
        lava.show();
    }
}


