package test.viikko6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;

public class tehtava3 extends Application {
    private TextField tfSijoituksenMaara = new TextField();
    private TextField tfVuosienMaara = new TextField();
    private TextField tfVuosiKorko = new TextField();
    private TextField tfTuottoOdotus = new TextField();
    private Button btLaske = new Button("Laske");

    @Override
    public void start(Stage alkuIkkuna)
    {  // luodaan paneeli
        GridPane paneeli = new GridPane();
        // asetetaan tilaa solujen välille
        paneeli.setHgap(5);
        paneeli.setVgap(5);
        // lisätään solmut
        paneeli.add(new Label("Sijoituksen määrä: "),0,0);
        paneeli.add(tfSijoituksenMaara, 1, 0);
        paneeli.add(new Label("Vuosien määrä "),0,1);
        paneeli.add(tfVuosienMaara, 1, 1);
        paneeli.add(new Label("Vuosikorko % "), 0,2);
        paneeli.add(tfVuosiKorko, 1, 2);
        paneeli.add(btLaske, 1, 3);
        paneeli.add(new Label("Tuotto odotus: "), 0,4);
        paneeli.add(tfTuottoOdotus, 1,4);

        // määritellään asettelua
        paneeli.setAlignment(Pos.CENTER);
        tfSijoituksenMaara.setAlignment(Pos.BOTTOM_RIGHT);
        tfVuosiKorko.setAlignment(Pos.BOTTOM_RIGHT);
        tfVuosienMaara.setAlignment(Pos.BOTTOM_RIGHT);
        tfTuottoOdotus.setAlignment(Pos.BOTTOM_RIGHT);
        // asetetaan ettei voi muokata
        tfTuottoOdotus.setEditable(false);

        // käsitellään tapahtumat
        btLaske.setOnAction(e -> laskeTuottoOdotus());


        Scene kehys = new Scene(paneeli, 400, 250);
        alkuIkkuna.setTitle("Ja rahaa tulee");
        alkuIkkuna.setScene(kehys);
        alkuIkkuna.show();
    }

    private void laskeTuottoOdotus()
    {
        // luetaan arvot kentistä
        double korko = Double.parseDouble(tfVuosiKorko.getText());
        int vuosi = Integer.parseInt(tfVuosienMaara.getText());
        double sijoitusMaara = Double.parseDouble(tfSijoituksenMaara.getText());

        // muodostetaan sijoitusolio
        Sijoitus sijoitus1 = new Sijoitus(korko, vuosi, sijoitusMaara);

        // näytetään tiedot
        tfTuottoOdotus.setText(String.format("%.2f", sijoitus1.getTuottoOdotus()));
    }

    public static void main(String [] args)
    {
        Application.launch(args);
    }
}
