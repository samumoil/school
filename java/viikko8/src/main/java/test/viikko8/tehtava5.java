package test.viikko8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class tehtava5 extends Application {
    private static Rectangle laatikko = new Rectangle(50, 100, Color.RED);
    Laatikkosaie saataja = new Laatikkosaie();

    public static class Laatikkosaie implements Runnable {
        @Override
        public void run(){
            if (laatikko.getFill() == Color.RED) {
                laatikko.setFill(Color.BLUE);
            }
            else {
                laatikko.setFill(Color.RED);
            }
        }
    }

    public static void main(String[] args) {  launch(args);  }

    @Override
    public void start(Stage primaryStage) {
        System.out.println(Color.RED);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(500);
                        Platform.runLater(saataja);
                    }
                }
                catch (InterruptedException ex) {}
            }
        }).start();

        StackPane paneeliFinal = new StackPane(laatikko);
        Scene kehys = new Scene(paneeliFinal, 300, 400);
        primaryStage.setScene(kehys);
        primaryStage.setTitle("Laatikko vaihtaa väriä");
        primaryStage.show();
    }
}
