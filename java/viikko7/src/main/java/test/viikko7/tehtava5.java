package test.viikko7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tehtava5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {

        // Luodaan valmiiksi lopullinen BorderPane
        BorderPane finalPane = new BorderPane();

        // Kaikille yhteinen Insets, jottei tarvitse määritellä aina uudelleen
        Insets turvaVali = new Insets(10,10,10,10);

        // Yläosa
        TextField tekstiKokoKentta = new TextField("20");
        Text tekstiKokoOhje = new Text("Anna uusi koko tekstille:");
        BorderPane tekstiKokoPane = new BorderPane();
        tekstiKokoPane.setCenter(tekstiKokoOhje);
        tekstiKokoPane.setRight(tekstiKokoKentta);
        tekstiKokoPane.setPadding(turvaVali);
        finalPane.setTop(tekstiKokoPane);

        // Vasen laita
        RadioButton nappiPun = new RadioButton("Punainen");
        RadioButton nappiSin = new RadioButton("Sininen");
        RadioButton nappiMus = new RadioButton("Musta");
        RadioButton nappiOra = new RadioButton("Oranssi");
        RadioButton nappiVih = new RadioButton("Vihreä");
        ToggleGroup nappiRyhma = new ToggleGroup();
        nappiPun.setToggleGroup(nappiRyhma);
        nappiSin.setToggleGroup(nappiRyhma);
        nappiMus.setToggleGroup(nappiRyhma);
        nappiOra.setToggleGroup(nappiRyhma);
        nappiVih.setToggleGroup(nappiRyhma);
        VBox nappiVbox = new VBox(20, nappiPun, nappiSin, nappiMus, nappiOra, nappiVih);
        nappiVbox.setAlignment(Pos.CENTER_LEFT);
        nappiVbox.setPadding(turvaVali);
        finalPane.setLeft(nappiVbox);

        // Oikea laita
        CheckBox checkBold = new CheckBox("Bold");
        CheckBox checkItalic = new CheckBox("Italic");
        VBox checkVbox = new VBox(20, checkBold, checkItalic);
        checkVbox.setAlignment(Pos.CENTER_LEFT);
        checkVbox.setPadding(turvaVali);
        finalPane.setRight(checkVbox);

        // Alalaita
        TextField uusiTekstiKentta = new TextField("Lorem Ipsum");
        Text uusiTekstiOhje = new Text("Anna uusi teksti:");
        uusiTekstiKentta.setPrefWidth(1000);
        HBox uusiTekstiHbox = new HBox(uusiTekstiOhje, uusiTekstiKentta);
        uusiTekstiHbox.setPadding(turvaVali);
        finalPane.setBottom(uusiTekstiHbox);
        uusiTekstiHbox.setAlignment(Pos.CENTER);

        // Keskelle tuleva teksti
        String teksti = uusiTekstiKentta.getText();
        Text tekstiNaytto = new Text(teksti);
        Font fontNormal = Font.font("Arial", FontWeight.NORMAL, FontPosture.REGULAR, Integer.parseInt(tekstiKokoKentta.getText()));
        tekstiNaytto.setFont(fontNormal);

        finalPane.setCenter(tekstiNaytto);

        // Toiminnallisuus - Tekstin koko
        tekstiKokoKentta.setOnAction(e -> {
                int koko = Integer.parseInt(tekstiKokoKentta.getText());
                tekstiNaytto.setFont(Font.font(koko));
                });

        // Toiminnallisuus - Napit
        nappiPun.setOnAction(e -> tekstiNaytto.setFill(Color.RED));
        nappiSin.setOnAction(e -> tekstiNaytto.setFill(Color.BLUE));
        nappiMus.setOnAction(e -> tekstiNaytto.setFill(Color.BLACK));
        nappiOra.setOnAction(e -> tekstiNaytto.setFill(Color.ORANGE));
        nappiVih.setOnAction(e -> tekstiNaytto.setFill(Color.GREEN));

        // Toiminnallisuus - Checkbox
        EventHandler<ActionEvent> kasittelija = e -> {
            if (checkItalic.isSelected() && checkBold.isSelected()) {
                tekstiNaytto.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, Integer.parseInt(tekstiKokoKentta.getText())));
            }
            else if (checkItalic.isSelected()) {
                tekstiNaytto.setFont(Font.font("Arial", FontWeight.NORMAL, FontPosture.ITALIC, Integer.parseInt(tekstiKokoKentta.getText())));
            }
            else if (checkBold.isSelected()) {
                tekstiNaytto.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, Integer.parseInt(tekstiKokoKentta.getText())));
            }
            else {
                tekstiNaytto.setFont(fontNormal);
            }
        };
        checkItalic.setOnAction(kasittelija);
        checkBold.setOnAction(kasittelija);

        // Toiminnallisuus - Uusi teksti
        uusiTekstiKentta.setOnAction(e -> {
            String uusiTeksti = uusiTekstiKentta.getText();
            tekstiNaytto.setText(uusiTeksti);
        });

        Scene kehys = new Scene(finalPane, 600,400);
        lava.setScene(kehys);
        lava.setTitle("Muokataan tekstin ulkoasua");
        lava.show();
    }
}
