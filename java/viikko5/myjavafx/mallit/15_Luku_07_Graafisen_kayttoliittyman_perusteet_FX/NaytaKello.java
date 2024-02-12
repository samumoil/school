import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class NaytaKello extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {  // luodaan kellopaneeli oman luokan avulla
      KelloPaneeli kello = new KelloPaneeli();
      // merkkijono kellonajalle
      String aikaMerkkijono = kello.getTunti() + ":" + 
         kello.getMinuutti() + ":" + kello.getSekunti();
      Label lbOikeaAika = new Label(aikaMerkkijono);
      // sijoitetaan kello ja label paneeliin
      BorderPane paneeli = new BorderPane();
      paneeli.setCenter(kello);
      paneeli.setBottom(lbOikeaAika);
      BorderPane.setAlignment(lbOikeaAika, Pos.TOP_CENTER);
         
      // kehys ja sjoitetaan siihen paneeli
      Scene kehys = new Scene(paneeli, 250, 250);
      alkuIkkuna. setTitle("N‰yt‰ Kello"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}   


   