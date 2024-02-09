package test.myjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class tehtava1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        Button nappi = new Button("Kokeile mua");
        StackPane panneeli = new StackPane();
        panneeli.getChildren().add(nappi);
        Scene kehys = new Scene(panneeli, 300,300);
        lava.setTitle("Tehtävä 1 ratkaisu");
        lava.setScene(kehys);
        lava.show();
    }
}
