import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NaytaKuva extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan paneeli kuvien n‰ytt‰miseen
      Pane paneeli = new HBox(10);
      paneeli.setPadding(new Insets(5, 5, 5, 5));
      Image kuva = new Image("image/us.gif");
      paneeli.getChildren().add(new ImageView(kuva));
      
      ImageView kuvaNaytto2 = new ImageView(kuva);
      kuvaNaytto2.setFitHeight(100);
      kuvaNaytto2.setFitWidth(100);
      paneeli.getChildren().add(kuvaNaytto2);
      
      ImageView kuvaNaytto3 = new ImageView(kuva);
      kuvaNaytto3.setRotate(90);
      paneeli.getChildren().add(kuvaNaytto3);
      // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli);
      alkuIkkuna. setTitle("N‰yt‰Kuva"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   