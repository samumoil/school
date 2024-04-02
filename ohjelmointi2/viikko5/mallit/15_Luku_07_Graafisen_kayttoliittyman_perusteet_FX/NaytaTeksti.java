import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;


public class NaytaTeksti extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan paneeli ja sijoitetaan siihen teksti
      Pane paneeli = new Pane();
      paneeli.setPadding(new Insets(5, 5, 5, 5));
      // teksti courier, bod, italics
      Text teksti1 = new Text(20, 20, "Ohjelmointi on kivaa");
      teksti1.setFont(Font.font("Courier", FontWeight.BOLD, 
         FontPosture.ITALIC, 15));
      paneeli.getChildren().add(teksti1);
      // pelkk‰ teksti
      Text teksti2 = new Text(60, 60, "Ohjelmointi on kivaa\nN‰yt‰ teksti");
      paneeli.getChildren().add(teksti2);
      // teksti punaisella alleviivattuna ja yliviivattuna
      Text teksti3 = new Text(10, 100, "Ohjelmointi on kivaa\nN‰yt‰ teksti");
      teksti3.setFill(Color.RED);
      teksti3.setUnderline(true);
      teksti3.setStrikethrough(true);
      paneeli.getChildren().add(teksti3);
      
      // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli);
      alkuIkkuna. setTitle("N‰yt‰ teksti"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
      

   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   