package test.viikko6;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
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
    GridPane kirjainRivi = new GridPane(5, 5);
    private String sana;
    private char[] sanaArray;

    public tehtava5_kirjainNaytto(String annettuSana) {
        this.sana = annettuSana.toLowerCase();
        sanaArray = new char[sana.length()];
        for (int i = 0; i < sana.length(); i++) {
            sanaArray[i] = (annettuSana.toLowerCase()).charAt(i);
            kirjainRivi.add(new Text("_"), i, 0);
        }
    }

    /*
    public boolean tarkistaja(char arvausLower) {
        boolean olikoOikein = false;
        for (int i = 0; i < sana.length(); i++) {
            char oikeaKirjain = sana.charAt(i);

            if (oikeaKirjain == "_" && oikeaKirjain == arvausLower) {
                kirjainRivi.add(new Text(Character.toString(oikeaKirjain)), i, 0);
                olikoOikein = true;
            }
            else {
                kirjainRivi.add(new Text("_"), i, 0);
            }
        }
        return olikoOikein;
    }
     */
    public boolean tarkistaja(char arvausLower) {
        boolean olikoOikein = false;
        kirjainRivi.getChildren().clear();
        for (int i = 0; i < sana.length(); i++) {
            if (Character.isUpperCase(sanaArray[i])) {
                kirjainRivi.add(new Text(Character.toString(sanaArray[i])), i, 0);
                //olikoOikein = true;
            }
            else {
                if (sanaArray[i] == arvausLower) {
                    sanaArray[i] = Character.toUpperCase(arvausLower);
                    kirjainRivi.add(new Text(Character.toString(sanaArray[i])), i, 0);
                    olikoOikein = true;
                }
                else {
                    kirjainRivi.add(new Text("_"), i, 0);
                }
            }
        }
        return olikoOikein;
    }
}
