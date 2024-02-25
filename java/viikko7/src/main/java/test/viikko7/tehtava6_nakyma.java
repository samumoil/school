package test.viikko7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class tehtava6_nakyma {

    public BorderPane nakyma = new BorderPane();

    // Vasen laita
    ObservableList<String> tilit = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10");
    public ListView<String> tiliLista = new ListView<>(tilit);

    // Keskiosan tekstikenttä
    TextArea tekstiAlue = new TextArea();

    // Alaosan Hbox, napit, label sekä tekstikenttä
    public Button nappiNosta = new Button("Nosta");
    public Button nappiTalleta = new Button("Talleta");
    Label summaTeksti = new Label("Summa:");
    public TextField summaKentta = new TextField();
    public Button nappiLopeta = new Button("Lopeta");
    HBox laatikkoAlas = new HBox(nappiNosta, nappiTalleta, summaTeksti, summaKentta, nappiLopeta);

    public tehtava6_nakyma() {
        // Tehdään tarvittavat hienosäädöt esitettäviin asioihin ja liitetään ne BorderPaneen

        tiliLista.setPrefWidth(50);
        nakyma.setLeft(tiliLista);

        tekstiAlue.setText("Tervetuloa pankkiin! Ole hyvä ja valitse tili vasemmalta.");
        tekstiAlue.setWrapText(true);
        nakyma.setCenter(tekstiAlue);

        nakyma.setBottom(laatikkoAlas);
        laatikkoAlas.setPadding(new Insets(10,10,10,10));
        laatikkoAlas.setAlignment(Pos.CENTER);
    }
}
