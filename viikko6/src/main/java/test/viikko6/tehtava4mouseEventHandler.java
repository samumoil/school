package test.viikko6;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class tehtava4mouseEventHandler implements MouseEvent {

    public Pane paivitaPaneeli(Pane paneeli){


            /*
        Tämä voi olla vähän vaikealukuinen. Ensimmäiset neljä riviä tarkistavat vain,
        onko shift painettuna ja onko kyseisen rivin piirtämää osioita lisätty paneeliin.
        Osio lisätään vain, jos shift EI ole painettu EIKÄ osiota lisätty.
        Toisessa osiossa tarkistetaan shift toisinpäin, kyseinen osio samalla tavalla
        ja lisäksi varmistetaan, että hirsipuun viimeinen osio (naru) on varmasti lisätty,
        ennen kuin lisätään hahmon osia.
         */
        paneeli.setOnMouseClicked(e -> {
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
    });
    }

}
