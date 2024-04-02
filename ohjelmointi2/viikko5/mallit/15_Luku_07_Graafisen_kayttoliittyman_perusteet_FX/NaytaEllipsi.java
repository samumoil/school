import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;

public class NaytaEllipsi extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      Pane paneeli = new Pane();
      // 3 suorakulmiota satunnaisilla väreillä
      // kallistettuna
      for (int i = 0; i < 16; i++)
      {
         Ellipse e1 = new Ellipse(150, 100, 100, 50);
         e1.setStroke(Color.color(Math.random(), Math.random(), 
            Math.random()));
         e1.setFill(Color.WHITE);   
         e1.setRotate(i * 180 / 16);   
         paneeli.getChildren().add(e1);   
      }
      // kehys ja sjoitetaan siihen paneeli
      Scene kehys = new Scene(paneeli, 300, 200);
      alkuIkkuna. setTitle("Näytä ellipsi"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // näytetään ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}   


   