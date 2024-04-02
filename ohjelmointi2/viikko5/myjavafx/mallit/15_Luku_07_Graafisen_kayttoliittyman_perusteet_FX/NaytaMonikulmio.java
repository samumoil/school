import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

public class NaytaMonikulmio extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      Pane paneeli = new Pane();
      // luodaan "tyhj‰" monikulmio ja lis‰t‰‰n paneeliin
      Polygon monikulmio = new Polygon();
      paneeli.getChildren().add(monikulmio);
      monikulmio.setFill(Color.WHITE);
      monikulmio.setStroke(Color.BLACK);
      // lista monikulmion pisteille
      ObservableList<Double> lista = monikulmio.getPoints();
      // m‰‰ritell‰‰n sopiva alue ja sen keskipiste
      final double LEVEYS = 200, KORKEUS = 200;
      double keskusX = LEVEYS / 2, keskusY = KORKEUS / 2;
      double sade = Math.min(LEVEYS, KORKEUS) * 0.4;
      // lis‰t‰‰n pisteet monikulmioon
      for (int i = 0; i < 6; i++)
      {  // kuusikulmion pisteet suhteessa keskipisteeseen
         lista.add(keskusX - sade * Math.cos(2 * i * Math.PI / 6));// double arvo listalle
         lista.add(keskusY - sade * Math.sin(2 * i * Math.PI / 6));
      }
       // kehys ja sjoitetaan siihen paneeli
      Scene kehys = new Scene(paneeli, 300, 200);
      alkuIkkuna. setTitle("N‰yt‰ kulma"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}   


   