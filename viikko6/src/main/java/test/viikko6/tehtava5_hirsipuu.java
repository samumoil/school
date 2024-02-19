package test.viikko6;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

class tehtava5_hirsipuu implements EventHandler<MouseEvent> {
    // Luodaan paneeli, hirsipuun osat sekä hahmo. Jostain syystä tässä ei voi
    // muuttaa niiden väriä.
    Pane paneeli = new Pane();
    Ellipse ellipsi = new Ellipse(160,350,160,60);
    Line pystypuu = new Line(90,10,90,300);
    Line poikkipuu = new Line(90,10,200,10);
    Line naru = new Line(180,10,180,40);
    Circle paa = new Circle(180,70,30, Color.RED);
    Line vartalo = new Line(180,100,180,200);
    Line kasiVasen = new Line(180,120,160,170);
    Line kasiOikea = new Line(180,120,200,170);
    Line jalkaVasen = new Line(180,200,160,240);
    Line jalkaOikea = new Line(180,200, 200, 240);

    // Hyödynnetään alustajaa, joka muuttaa värit oikein.
    public tehtava5_hirsipuu() {
        ellipsi.setFill(Color.YELLOW);
        ellipsi.setStroke(Color.BLACK);
        naru.setStroke(Color.RED);
        paa.setStroke(Color.BLACK);
        vartalo.setStroke(Color.RED);
        kasiVasen.setStroke(Color.RED);
        kasiOikea.setStroke(Color.RED);
        jalkaVasen.setStroke(Color.RED);
        jalkaOikea.setStroke(Color.RED);
    }

    // Tämä metodi hoitaa tapahtumien ohjaamisen.
    @Override
    public void handle(MouseEvent e) {
        if (!e.isShiftDown() && !paneeli.getChildren().contains(ellipsi))
            paneeli.getChildren().add(ellipsi);
        else if (!e.isShiftDown() && !paneeli.getChildren().contains(pystypuu))
            paneeli.getChildren().add(pystypuu);
        else if (!e.isShiftDown() && !paneeli.getChildren().contains(poikkipuu))
            paneeli.getChildren().add(poikkipuu);
        else if (!e.isShiftDown() && !paneeli.getChildren().contains(naru))
            paneeli.getChildren().add(naru);
        else if (e.isShiftDown() && paneeli.getChildren().contains(naru) && !paneeli.getChildren().contains(paa))
            paneeli.getChildren().add(paa);
        else if (e.isShiftDown() && paneeli.getChildren().contains(naru)  && !paneeli.getChildren().contains(vartalo))
            paneeli.getChildren().add(vartalo);
        else if (e.isShiftDown() && paneeli.getChildren().contains(naru)  && !paneeli.getChildren().contains(kasiVasen))
            paneeli.getChildren().add(kasiVasen);
        else if (e.isShiftDown() && paneeli.getChildren().contains(naru)  && !paneeli.getChildren().contains(kasiOikea))
            paneeli.getChildren().add(kasiOikea);
        else if (e.isShiftDown() && paneeli.getChildren().contains(naru)  && !paneeli.getChildren().contains(jalkaVasen))
            paneeli.getChildren().add(jalkaVasen);
        else if (e.isShiftDown() && paneeli.getChildren().contains(naru)  && !paneeli.getChildren().contains(jalkaOikea))
            paneeli.getChildren().add(jalkaOikea);
    }
}
