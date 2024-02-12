package test.myjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class tehtava5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage lava) {
        // Jostain syystä tähän piti lisätä "file:", jotta se toimi minulla.
        // Se pitää mahdollisesti poistaa jonkun muun järjestelmässä?
        Image suomi = new Image("file:Suomi.jpg", 150, 100, false, true);
        ImageView suomiNaytto = new ImageView(suomi);
        Image ruotsi = new Image("file:Sverige.jpg", 150, 100, false, true);
        ImageView ruotsiNaytto = new ImageView(ruotsi);
        Image norja = new Image("file:Norge.jpg", 150, 100, false, true);
        ImageView norjaNaytto = new ImageView(norja);
        Image italia = new Image("file:italy.png", 150, 100, false, true);
        ImageView italiaNaytto = new ImageView(italia);
        Image ukraina = new Image("file:ukraine.png", 150, 100, false, true);
        ImageView ukrainaNaytto = new ImageView(ukraina);
        Image britannia = new Image("file:union-jack.jpg", 150, 100, false, true);
        ImageView britanniaNaytto = new ImageView(britannia);

        GridPane paneeli = new GridPane();
        paneeli.setGridLinesVisible(true);
        paneeli.setHgap(4);
        paneeli.setVgap(4);
        paneeli.add(suomiNaytto, 0, 0);
        paneeli.add(ruotsiNaytto, 1, 0);
        paneeli.add(norjaNaytto, 2, 0);
        paneeli.add(italiaNaytto, 0, 1);
        paneeli.add(ukrainaNaytto, 1, 1);
        paneeli.add(britanniaNaytto, 2, 1);

        Scene kehys = new Scene(paneeli, 600, 300);
        lava.setScene(kehys);
        lava.setTitle("Tehtävä 5");
        lava.show();
    }
}
