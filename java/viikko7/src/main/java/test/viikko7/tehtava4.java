package test.viikko7;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tehtava4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        // Luodaan lopullinen paneeli jo tässä vaiheessa, jotta voidaan liittää siihen asiat.
        BorderPane finalPane = new BorderPane();

        // Teksti
        Text teksti = new Text("Muokkaa minua!");
        teksti.setFill(Color.rgb(255/2, 0, 255/2));
        teksti.setFont(Font.font(30));
        finalPane.setCenter(teksti);

        // Liukukytkimet
        Slider liukuVaaka = new Slider();
        Slider liukuPysty = new Slider();
        liukuPysty.setOrientation(Orientation.VERTICAL);
        finalPane.setRight(liukuPysty);
        finalPane.setBottom(liukuVaaka);

        // Toiminnallisuus
        liukuVaaka.valueProperty().addListener(e -> {
            int pun = (int) (255 * (liukuVaaka.getValue()/liukuVaaka.getMax()));
            int sin = (int) (255 * (1-liukuVaaka.getValue()/liukuVaaka.getMax()));
            teksti.setFill(Color.rgb(pun,0, sin));
        });
        liukuPysty.valueProperty().addListener(e -> {
            teksti.setFont(Font.font(
                    2+65*(liukuPysty.getValue()/liukuPysty.getMax())));
        });

        Scene kehys = new Scene(finalPane, 600,400);
        lava.setScene(kehys);
        lava.setTitle("Väriä elämään!");
        lava.show();
    }
}
