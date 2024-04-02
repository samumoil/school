package test.viikko9;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import java.io.Serializable;


/**
 * Luokka käynnistää ja ylläpitää pankkiautomaatin käyttöliittymää.
 */
public class PankkiKayttoLiittyma extends Application {
    /** Indeksi tilin valintaan */
    int iTili = 0;
    /** Muuttuja, johon poimitaan nostettava tai talletettava summa käyttöliittymältä. */
    double dSumma = 0;

    /**
     * Käynnistää java-koodin.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Luokan esittämä päänäkymä.
     *
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     */
    @Override
    public void start(Stage primaryStage) {
        Pankkiautomaatti automaatti = new Pankkiautomaatti();
        String [] sTilinumeroLista = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        BorderPane brPohja = new BorderPane();
        ListView<String> lv = new ListView<>
                (FXCollections.observableArrayList(sTilinumeroLista));
        lv.setPrefSize(50,300);
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        brPohja.setLeft(lv);

        TextArea taTiedot = new TextArea("Tilin tiedot");
        brPohja.setCenter(taTiedot);

        HBox hbPainikkeet = new HBox();
        Label lbTyhja = new Label("                ");
        Button btNosta = new Button("Nosta");
        Button btTalleta = new Button("Talleta");
        Label lbSumma = new Label("  Summa:");
        TextField tfSumma = new TextField();
        Button btLopeta = new Button("Lopeta");
        hbPainikkeet.setPadding(new Insets(10, 10, 10, 10));
        hbPainikkeet.getChildren().addAll(lbTyhja, btNosta, btTalleta, lbSumma, tfSumma, btLopeta);

        brPohja.setBottom(hbPainikkeet);

        lv.getSelectionModel().selectedItemProperty().addListener(
                ov -> {
                    //selitys = "Valitsit: ";
                    iTili = lv.getSelectionModel().getSelectedIndex();
                    taTiedot.setText("Tilin " + (iTili+1) + " tiedot\n" +automaatti.tilit[iTili].toString());
                });

        btNosta.setOnAction(e -> {
            dSumma = Double.parseDouble(tfSumma.getText());
            automaatti.tilit[iTili].nosta(dSumma);
            taTiedot.setText("Tilin " + (iTili+1) + " tiedot\n" +automaatti.tilit[iTili].toString());
        });
        btTalleta.setOnAction(e -> {
            dSumma = Double.parseDouble(tfSumma.getText());
            automaatti.tilit[iTili].talleta(dSumma);
            taTiedot.setText("Tilin " + (iTili+1) + " tiedot\n" +automaatti.tilit[iTili].toString());
        });
        btLopeta.setOnAction(e -> {
            automaatti.kirjoitaTiedostoon();
            System.exit(0);
        });

        Scene scene = new Scene(brPohja, 500, 400);
        primaryStage.setTitle("Käsittele pankkitiliä:");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

/**
 * Luokan oliot kuvaavat yhden pankkitilin tietoja.
 */
class Pankkitili implements Serializable {
    /** Muuttuja vuosikoron tallettamiseksi */
    private double vuosiKorko;

    /** Muuttuja saldon tallettamiseksi */
    private double saldo;

    /**
     * Alustaa pankkiilin annetulla alkusaldolla.
     * @param saldo
     */
    public Pankkitili(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Alustaa pankkitilin toisen pankkitili-olion saldolla.
     * @param tili
     */
    public Pankkitili(Pankkitili tili) {
        this.saldo = tili.getSaldo();
    }

    /**
     * Vuosikoron asetus
     * @param vuosiKorko
     */
    public void setVuosiKorko(double vuosiKorko) {
        this.vuosiKorko = vuosiKorko;
    }

    /**
     * Summan talletus tilille.
     * @param summa
     */
    public void talleta(double summa) {
        if (summa > 0){
            this.saldo += summa;
            System.out.println("Talletettiin " + summa);
        }
        else
            System.out.println("Rahamaaran pitaa olla positiivinen arvo!");
    }

    /**
     * Summan nosto tililta.
     * @param summa
     */
    public void nosta(double summa) {
        if (summa < 0)
            System.out.println("Rahamaaran pitaa olla positiivinen arvo!");
        else if (summa <= this.saldo) {
            this.saldo -= summa;
            System.out.println("Nostettiin " + summa);
        }
        else {
            System.out.println("Tililla ei ole riittavasti katetta.");
            System.out.println("Nostettiin " + this.saldo);
            this.saldo = 0;

        }
    }

    /**
     * Kuukausikoron lisays.
     */
    public void lisaaKorko() {
        this.saldo += (this.saldo * this.vuosiKorko / 100.0) / 12;
    }

    /**
     * Saldon tarkistus.
     * @return double saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Apumetodi tilin tietojen tulostukseen.
     * @return String-muotoinen tulostettava lause.
     */
    @Override
    public String toString() {
        return "vuosiKorko=" + vuosiKorko +
                "\nsaldo=" + saldo
                ;
    }
}

/**
 * Luokka tuottaa pankkiautomaatin toimintalogiikan.
 */
class Pankkiautomaatti {
    /** Taulukko tili-olioista. Tämä kuvastaa listaa tileistä. */
    public Pankkitili[] tilit = new Pankkitili[10];

    /**
     * Oletusalustaja luokan oliolle. Yrittää lukea "tilit.dat" tiedostosta olemassaolevat saldotiedot.
     * Tiedoston puuttuessa luo uuden tiedoston ja asettaa kaikkien tilien saldoksi 100.
     */
    public Pankkiautomaatti() { // tänne lisätty tiedoston käsittelyä
        try {
            File tiedosto = new File("tilit.dat");
            if (tiedosto.exists()) {
                FileInputStream tilitiedosto = new FileInputStream("tilit.dat");
                ObjectInputStream oliot2 = new ObjectInputStream(tilitiedosto);
                for (int i = 0; i < 10; i++) {
                    tilit[i] = (Pankkitili) oliot2.readObject();
                }
                tilitiedosto.close();
            } else
            {
                for (int i = 0; i < 10; i++) {
                    this.tilit[i] = new Pankkitili(100);
                }
                System.out.println("Lukeminen onnistui.");
            }
        }catch (Exception e) {
            System.out.println("virhe lukemisessa");
            System.out.println(e);
        }



    }

    /**
     * Tulostaa komentoriville halutin tilin saldon.
     * @param i on halutun tilin indeksi.
     */
    public void saldo(int i) {
        System.out.println("Tilin " + i + " saldo on " + this.tilit[i].getSaldo());
    }

    /**
     * Nostaa tietyltä tililtä annetun summan rahaa.
     * @param i on halutun tilin indeksi.
     * @param summa on nostettava rahamäärä.
     */
    public void nosto(int i, double summa) {
        this.tilit[i].nosta(summa);
    }

    /**
     * Tallettaa tietylle tilille annetun summan rahaa.
     * @param i on halutun tilin indeksi.
     * @param summa on talletettava rahamäärä.
     */
    public void pano(int i, double summa) {
        this.tilit[i].talleta(summa);
    }

    /**
     * Kysyy komentorivillä käyttäjältä, mitä tiliä halutaan käsitellä.
     */
    public static void kysy_tilinumero() {
        System.out.println("Mitä tiliä haluat käsitellä (1-10, 0 = lopetus)");
    }

    /**
     * Yrittää kirjoittaa saldotiedot tieostoon "tilit.dat".
     */
    public void kirjoitaTiedostoon() {
        try {
            FileOutputStream tilitiedosto = new FileOutputStream("tilit.dat");
            ObjectOutputStream oliot = new ObjectOutputStream(tilitiedosto);
            for (int i= 0; i < 10; i++) {
                oliot.writeObject(tilit[i]);
            }
            tilitiedosto.close();
            System.out.println("Kirjoitettiin tiedostoon onnistuneesti. ");
        } catch (Exception e ) {
            System.out.println("virhe kirjoituksessa.");
            System.out.println(e);

        }

    }

}

