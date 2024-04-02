package test.viikko7;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

public class tehtava1_valotolppa {
    // Luodaan nämä ennen alustajaa, jotta näihin voidaan viitata myöhemmissä
    // metodeissa.
    StackPane valotolppa = new StackPane();
    Circle ympyraPun = new Circle();
    Circle ympyraKelt = new Circle();
    Circle ympyraVihr = new Circle();
    public tehtava1_valotolppa(int koko) {
        ympyraPun.setRadius(koko);
        ympyraPun.setStroke(Color.BLACK);
        ympyraPun.setFill(Color.RED);

        ympyraKelt.setRadius(koko);
        ympyraKelt.setStroke(Color.BLACK);
        ympyraKelt.setFill(Color.YELLOW);

        ympyraVihr.setRadius(koko);
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
        VBox valotolppaVBox = new VBox();
        valotolppaVBox.getChildren().addAll(laatikkoJaPallot, jalka);
        valotolppaVBox.setAlignment(Pos.CENTER);

        // Sijoitetaan vielä VBox StackPanen sisälle, jotta ne pysyvät keskenään
        // paikoillaan. StackPane on nyt valmis palautettavaksi seuraavassa metodissa.
        valotolppa.getChildren().addAll(valotolppaVBox);
    }

    public StackPane getValotolppa() {  return valotolppa;  }

    public StackPane setPunainen() {
        ympyraPun.setFill(Color.RED);
        ympyraKelt.setFill(Color.BLACK);
        ympyraVihr.setFill(Color.BLACK);
        return valotolppa;
    }
    public StackPane setKeltainen() {
        ympyraPun.setFill(Color.BLACK);
        ympyraKelt.setFill(Color.YELLOW);
        ympyraVihr.setFill(Color.BLACK);
        return valotolppa;
    }
    public StackPane setVihrea() {
        ympyraPun.setFill(Color.BLACK);
        ympyraKelt.setFill(Color.BLACK);
        ympyraVihr.setFill(Color.GREEN);
        return valotolppa;
    }
    public void setRandom() {
        // Luodaan satunnainen luku väliltä [1,4[
        int arpa = ThreadLocalRandom.current().nextInt(1, 4);

        if (arpa == 1) this.setPunainen();
        else if (arpa == 2) this.setKeltainen();
        else if (arpa == 3) this.setVihrea();
    }
}
