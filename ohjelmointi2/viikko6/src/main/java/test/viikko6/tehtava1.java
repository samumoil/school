package test.viikko6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class tehtava1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ikkuna) {

        // Luodaan laatikko ja käännetään se
        Rectangle laatikko = new Rectangle();
        laatikko.setHeight(110);
        laatikko.setWidth(60);
        laatikko.setFill(Color.WHITE);
        laatikko.setStroke(Color.BLACK);
        laatikko.setRotate(-45);

        // Luodaan nappi ja asetetaan sille toiminto
        Button nappi = new Button("Käännä");
        nappi.setOnAction(e -> laatikko.setRotate(laatikko.getRotate() + 45));

        // Luodaan paneeli ja asetetaan sisältö siihen
        BorderPane panneeli = new BorderPane();
        panneeli.setCenter(laatikko);
        panneeli.setLeft(nappi);
        BorderPane.setAlignment(nappi, Pos.CENTER_LEFT); // Tuodaan nappi keskelle ylä-ala-suunnssa

        // Asetetaan paneeli uuteen ikkunan sisältöön ja asetetaan ikkunan sisältö ikkunaan
        Scene ikkunanSisalto = new Scene(panneeli,500,500);
        ikkuna.setScene(ikkunanSisalto);
        ikkuna.setTitle("Kiännetään");
        ikkuna.show();
    }
}
