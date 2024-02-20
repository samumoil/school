package test.viikko6;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class tehtava6_mikro {
    // Reunus kuvalle
    private Rectangle reunus = new Rectangle(560, 210, Color.WHITE);

    // Mikron ovi ja sisällä näkyvä ruoka
    private Image ruoka = new Image("file:ruokalautanen.png", 200, 200, true, true);
    private ImageView ruokaNaytto = new ImageView(ruoka);
    private Rectangle oviSuorakulmio = new Rectangle(300, 200, Color.WHITE);
    StackPane paneeliOvi = new StackPane(oviSuorakulmio, ruokaNaytto); // Tämä ei voi olla private, jotta voi tehdä aktivaation hiirisijainnilla.
    // Tehtävän 6 vaihtoehtoiset tekstit kuvan tilalle:
    private Text kohtaValmis = new Text("Ruoka on kohta valmis");
    private Text ruokaValmis = new Text("Ruoka on valmista!");

    // Numeronäyttö
    private Rectangle numeroNaytonTausta = new Rectangle(150, 40, Color.WHITE);
    private String tekstiNumeroNayttoon = "0";
    private Text tekstiNode = new Text(tekstiNumeroNayttoon);
    private StackPane numeroNaytto = new StackPane(numeroNaytonTausta, tekstiNode);

    // Napit numeronäytön alla. Nämäkään eivät voi olla private, jotta aktivointi onnistuu.
    Button start = new Button("Start");
    Button stop = new Button("Stop");
    Button clear = new Button("Clear");
    private HBox nappiRivi = new HBox(start, stop, clear);

    // Teksti oikeaan alanurkkaan
    private Text MIKROAALTOUUNI = new Text("MIKROAALTOUUNI");

    // Asetellaan palaset paikoilleen. Sijainnit on määritelty .relocate-metodilla jokaiselle erikseen.
    Pane paneeliFinal = new Pane();

    // Alustaja mikroOliolle.
    public tehtava6_mikro() {
        tekstiNode.setFont(new Font(16)); // Säädetään fonttia isommaksi
        numeroNaytto.relocate(400, 5);
        paneeliOvi.relocate(40, 5); // Sijoitetaan ovi oikeaan kohtaan
        reunus.setStroke(Color.BLACK);
        oviSuorakulmio.setStroke(Color.BLACK);
        numeroNaytonTausta.setStroke(Color.BLACK);
        nappiRivi.relocate(400, 46);
        MIKROAALTOUUNI.setFont(new Font(16));
        MIKROAALTOUUNI.relocate(400, 180);

        paneeliFinal.getChildren().addAll(
                reunus,
                paneeliOvi,
                numeroNaytto,
                nappiRivi,
                MIKROAALTOUUNI
        );

    }

    public void setRuokakuva() {
        paneeliOvi.getChildren().clear();
        paneeliOvi.getChildren().addAll(oviSuorakulmio, ruokaNaytto);
    }
    public void setKohtaValmis() {
        paneeliOvi.getChildren().clear();
        paneeliOvi.getChildren().addAll(oviSuorakulmio, kohtaValmis);
    }
    public void setRuokaValmis() {
        paneeliOvi.getChildren().clear();
        paneeliOvi.getChildren().addAll(oviSuorakulmio, ruokaValmis);
    }
    public void setAika(String teksti) {
        tekstiNumeroNayttoon = teksti;
        tekstiNode.setText(tekstiNumeroNayttoon);
    }
    public int getAika() {  return Integer.parseInt(tekstiNumeroNayttoon);  }
    public void lisaaAikaa(String numero) {
        if (tekstiNumeroNayttoon.equals("0")) {  tekstiNumeroNayttoon = numero;  } // Ensimmäinen lisättävä numero.
        else { // Loput konkatenoidaan aiemmin lisättyjen perään. Maksimi 6 numeroa.
            if (tekstiNumeroNayttoon.length() < 6) tekstiNumeroNayttoon = tekstiNumeroNayttoon.concat(numero);
        }
        tekstiNode.setText(tekstiNumeroNayttoon); // Päivitetään node.
    }
}
