import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NaytaHBoxVBoxPane extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan paneeli 
      BorderPane paneeli = new BorderPane();
      
      // sijoitetaan paneeliin solmuja
      paneeli.setTop(getHBox());
      paneeli.setLeft(getVBox());
         
      // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli);
      alkuIkkuna. setTitle("N‰yt‰ HBoxVBox"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   private HBox getHBox()
   {
      HBox hbox = new HBox(15);
      hbox.setPadding(new Insets(15, 15, 15, 15));
      hbox.setStyle("-fx-background-color: gold");
      hbox.getChildren().add(new Button("Tietojenk‰sittelytiede"));
      hbox.getChildren().add(new Button("Tilastotiede"));
      ImageView kuvaNakyma = new ImageView(new Image("image/us.gif"));
      hbox.getChildren().add(kuvaNakyma);
      return hbox;
   }
   
   private VBox getVBox()
   {
      VBox vbox = new VBox(15);
      vbox.setPadding(new Insets(15, 5, 5, 5));
      vbox.getChildren().add(new Label("Kurssit"));
      
      Label[] kurssit = {new Label("OH1"), new Label("OH2"), 
         new Label("JTT"), new Label("PHT")};
      
      for (Label kurssi: kurssit)
      {
         VBox.setMargin(kurssi, new Insets(0, 0, 0, 15));
         vbox.getChildren().add(kurssi);
      }
      return vbox;
   }
               
  
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
