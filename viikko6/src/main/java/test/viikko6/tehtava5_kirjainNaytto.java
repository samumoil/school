package test.viikko6;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

class tehtava5_kirjainNaytto {
    FlowPane kirjainRivi = new FlowPane(5, 5);
    GridPane kirjainRivi2 = new GridPane(5, 5);
    private String sana;
/*
    public tehtava5_kirjainNaytto(String sana) {
        this.sana = sana;
        for (int i = 0; i < sana.length(); i++) {
            kirjainRivi.getChildren().add(new Text("_"));
        }
    }
*/

    public tehtava5_kirjainNaytto(String sana) {
        this.sana = sana;
        for (int i = 0; i < sana.length(); i++) {
            kirjainRivi2.add(new Text("_"), i, 0);
        }
    }



}
