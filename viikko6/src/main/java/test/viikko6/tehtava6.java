package test.viikko6;

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
        tehtava6_mikro mikroOlio = new tehtava6_mikro();
        Pane paneeliFinal = mikroOlio.paneeliFinal;
        Scene kehys = new Scene(paneeliFinal);


        // setRuokakuva()
        // setKohtaValmis()
        // setRuokaValmis()
        // setNumeroNaytonNumerot(String teksti)

        mikroOlio.paneeliOvi.setOnMouseEntered(e -> mikroOlio.setKohtaValmis() );
        mikroOlio.paneeliOvi.setOnMouseExited(e -> mikroOlio.setRuokakuva() );

        mikroOlio.clear.setOnAction(e -> {
            mikroOlio.setRuokakuva();
            mikroOlio.setNumeroNaytonNumerot("0");
        });

        lava.setScene(kehys);
        lava.setTitle("Tehtävä 6");
        lava.show();
    }
}
