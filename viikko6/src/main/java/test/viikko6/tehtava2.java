package test.viikko6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderRepeat;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.CacheRequest;

public class tehtava2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ikkuna) {
        // Annetaan ikkunan koko ensin, jotta voidaan käyttää sitä myöhemmin parissa kohdassa.
        ikkuna.setWidth(500);
        ikkuna.setHeight(500);
        ikkuna.setTitle("Katso kuinka pallo liikkuu");

        // Ympyrän luonti ja sijoittaminen ikkunan keskelle.
        int ympyranHalkaisija = 100;
        Circle ympyra = new Circle(ympyranHalkaisija, Color.WHITE);
        ympyra.setStroke(Color.BLACK);
        ympyra.setCenterX(ikkuna.getWidth()/2);
        ympyra.setCenterY(ikkuna.getHeight()/2);
        Pane ympyraPane = new Pane();
        ympyraPane.getChildren().add(ympyra);

        // Napit, niiden BorderPane sekä sijoittelu omien lokeroiden keskelle.
        Button ylos = new Button("Ylös");
        Button alas = new Button("Alas");
        Button vasen = new Button("Vasen");
        Button oikea = new Button("Oikea");
        BorderPane nappiPaneeli = new BorderPane();
        nappiPaneeli.setLeft(vasen);
        nappiPaneeli.setRight(oikea);
        nappiPaneeli.setTop(ylos);
        nappiPaneeli.setBottom(alas);
        BorderPane.setAlignment(vasen, Pos.CENTER);
        BorderPane.setAlignment(oikea, Pos.CENTER);
        BorderPane.setAlignment(ylos, Pos.CENTER);
        BorderPane.setAlignment(alas, Pos.CENTER);

        // Nappipaneeli sekä ympyräpaneeli laitetaan päällekäin.
        StackPane keskitysPaneeli = new StackPane(ympyraPane, nappiPaneeli);
        Scene ikkunanSisalto = new Scene(keskitysPaneeli);
        ikkuna.setScene(ikkunanSisalto);
        ikkuna.show();

        // Toimintalogiikkka nappien painamiselle.
        int askel = 50;
        ylos.setOnAction(e -> {
            if (ympyra.getCenterY() > ympyranHalkaisija + askel) // Onko ympyrän keskipisteen ja laidan välissä tarpeeksi tilaa ottaa yksi "askel"?
                ympyra.setCenterY(ympyra.getCenterY() - askel); // Siirry yksi askel.
            else // Jos ei ole tarpeeksi tilaa kokonaiselle askeleelle, siirry koskettamaan reunaa.
                ympyra.setCenterY(ympyranHalkaisija);
        });
        vasen.setOnAction(e -> {
            if (ympyra.getCenterX() > ympyranHalkaisija + askel )
                ympyra.setCenterX(ympyra.getCenterX() - askel);
            else
                ympyra.setCenterX(ympyranHalkaisija);
        });
        alas.setOnAction(e -> {
            if (ympyra.getCenterY() < ikkuna.getHeight()-ympyranHalkaisija - askel) // Hyödynnetään tietoa ikkunan koosta.
                ympyra.setCenterY(ympyra.getCenterY() + askel);
            else
                ympyra.setCenterY(ikkuna.getHeight()-ympyranHalkaisija);
        });
        oikea.setOnAction(e -> {
            if (ympyra.getCenterX() < ikkuna.getWidth()-ympyranHalkaisija - askel)
                ympyra.setCenterX(ympyra.getCenterX() + askel);
            else
                ympyra.setCenterX(ikkuna.getWidth()-ympyranHalkaisija);
        });
    }
}
