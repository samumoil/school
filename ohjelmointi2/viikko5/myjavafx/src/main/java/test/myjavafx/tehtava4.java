package test.myjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class tehtava4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {

        Ellipse ellipsi = new Ellipse(160,350,160,60);
        ellipsi.setFill(Color.YELLOW);
        ellipsi.setStroke(Color.BLACK);

        Line pystypuu = new Line(90,10,90,300);
        Line poikkipuu = new Line(90,10,200,10);
        Line naru = new Line(180,10,180,40);
        naru.setStroke(Color.RED);

        Circle paa = new Circle(180,70,30, Color.RED);
        paa.setStroke(Color.BLACK);
        Line vartalo = new Line(180,100,180,200);
        vartalo.setStroke(Color.RED);
        Line kasiOikea = new Line(180,120,160,170);
        kasiOikea.setStroke(Color.RED);
        Line kasiVasen = new Line(180,120,200,170);
        kasiVasen.setStroke(Color.RED);
        Line jalkaVasen = new Line(180,200,160,240);
        jalkaVasen.setStroke(Color.RED);
        Line jalkaOikea = new Line(180,200, 200, 240);
        jalkaOikea.setStroke(Color.RED);

        Pane paneeli = new Pane();
        paneeli.getChildren().addAll(
                pystypuu, ellipsi, poikkipuu, naru, paa, vartalo,
                kasiOikea, kasiVasen, jalkaOikea, jalkaVasen);

        Scene kehys = new Scene(paneeli, 320, 450);
        lava.setScene(kehys);
        lava.setTitle("Tehtävä 4");
        lava.show();
    }
}
