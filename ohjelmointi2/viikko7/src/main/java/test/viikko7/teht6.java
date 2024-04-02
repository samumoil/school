package test.viikko7;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;

public class teht6 extends Application {
    private int tilinro;
    private Pankkitili[] tilit = new Pankkitili[10];
    private TextArea tilitiedot = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        lueTiedostosta();
        BorderPane paaPaneeli = new BorderPane();

        Pane pane = new Pane();
        ListView<Integer> tililista = new ListView<>();
        tililista.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tililista.setPrefWidth(50);
        tililista.setPrefHeight(400);

        for (int i = 0; i < tilit.length; i++) {
            tililista.getItems().add(i + 1);
        }
        pane.getChildren().add(tililista);

        tilitiedot.setPrefRowCount(3);
        tilitiedot.setPrefWidth(300);
        tilitiedot.setPrefHeight(300);

        tililista.getSelectionModel().selectedItemProperty().addListener((nyt, vanha, uusi) -> {
            String teksti = tililista.getSelectionModel().getSelectedItems().toString().replaceAll("(^\\[|]$)", "");
            tilinro = Integer.parseInt(teksti) - 1;
            tilitiedot.setText("Tilin " + (tilinro + 1) + " tiedot\nvuosikorko=" + tilit[tilinro].getVuosiKorko() + "\nsaldo=" + tilit[tilinro].getSaldo());
        });

        HBox hbox = new HBox(1);
        hbox.setPadding(new Insets(15));
        hbox.setAlignment(Pos.CENTER);
        Button Nosta = new Button("Nosta");
        Button Talleta = new Button("Talleta");
        Label Summa = new Label("Summa");
        Button Lopeta = new Button("Lopeta");
        TextField luku = new TextField();

        hbox.getChildren().addAll(Nosta, Talleta, Summa,luku, Lopeta);

        Nosta.setOnAction(e -> {
            tilit[tilinro].nosta(Double.parseDouble(luku.getText()));
            tilitiedot.setText("Tilin " + (tilinro + 1) + " tiedot\nvuosikorko=" + tilit[tilinro].getVuosiKorko() + "\nsaldo=" + tilit[tilinro].getSaldo());
        });
        Talleta.setOnAction(e -> {
            tilit[tilinro].talleta(Double.parseDouble(luku.getText()));
            tilitiedot.setText("Tilin " + (tilinro + 1) + " tiedot\nvuosikorko=" + tilit[tilinro].getVuosiKorko() + "\nsaldo=" + tilit[tilinro].getSaldo());
        });
        Lopeta.setOnAction(e -> {
            kirjoitaTiedostoon();
            System.exit(0);
        });
        paaPaneeli.setBottom(hbox);
        paaPaneeli.setLeft(pane);
        paaPaneeli.setCenter(tilitiedot);

        Scene scene = new Scene(paaPaneeli, 550, 450);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Käsittele pankkitiliä:");
        primaryStage.show();
    }

    public void kirjoitaTiedostoon() { // lisäys
        try {
            FileOutputStream tilitiedosto = new FileOutputStream("tilit.dat");
            ObjectOutputStream oliot = new ObjectOutputStream(tilitiedosto);
            for (int i = 0; i < 10; i++) {
                oliot.writeObject(tilit[i]);
            }
            tilitiedosto.close();
            System.out.println("Kirjoitettiin tiedostoon onnistuneesti. ");
        } catch (Exception e) {
            System.out.println("virhe kirjoituksessa.");
            System.out.println(e);

        }
    }
    public void lueTiedostosta() {
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
}
