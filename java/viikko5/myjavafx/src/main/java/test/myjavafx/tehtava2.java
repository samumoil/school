package test.myjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tehtava2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        VBox vertikaaliLaatikko = new VBox(30);
        vertikaaliLaatikko.getChildren().addAll(
                new Button("Ylin"),
                new Button("Keskellä"),
                new Button("Alin")
        );
        Scene kehys = new Scene(vertikaaliLaatikko, 300,300);
        lava.setScene(kehys);
        lava.setTitle("Tehtävä 2");
        lava.show();
    }
}
