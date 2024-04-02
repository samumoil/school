package test.viikko7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tehtava2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {

        String[] juuresLista = {"Porkkana", "Lanttu", "Punajuuri",
        "Nauris", "Retiisi", "Palsternakka", "Maa-artisokka"};
        ListView<String> listaNakyma = new ListView<>(
                FXCollections.observableArrayList(juuresLista));
        listaNakyma.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        String alkuTeksti = "Valitsit: ";
        Text tekstinNaytto = new Text(alkuTeksti);

        listaNakyma.getSelectionModel().selectedItemProperty().addListener(ov -> {
                    String uusiSana = alkuTeksti;
                    for (Integer i: listaNakyma.getSelectionModel().getSelectedIndices()) {
                        uusiSana = uusiSana + " " + juuresLista[i];
                    }
                    tekstinNaytto.setText(uusiSana);
                });

        BorderPane finalPane = new BorderPane();
        finalPane.setCenter(listaNakyma);
        finalPane.setBottom(tekstinNaytto);

        Scene kehys = new Scene(finalPane, 400,400);
        lava.setScene(kehys);
        lava.setTitle("Valitse juurekset kasviskeittoon:");
        lava.show();
    }
}
