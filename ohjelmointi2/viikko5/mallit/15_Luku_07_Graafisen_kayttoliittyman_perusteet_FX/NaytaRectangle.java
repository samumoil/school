import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;

public class NaytaRectangle extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      Pane paneeli = new Pane();
      // luodaan suorakulmio ja lisätään paneeliin
      // reuna musta, sisältä valkea
      Rectangle r1 = new Rectangle(25, 10, 60, 30);
      r1.setStroke(Color.BLACK);
      r1.setFill(Color.WHITE);
      paneeli.getChildren().add(new Text(10, 27, "r1"));
      paneeli.getChildren().add(r1);
      // suorakulmio oletusväreillä
      Rectangle r2 = new Rectangle(25, 50, 60, 30);
      paneeli.getChildren().add(new Text(10, 67, "r2"));
      paneeli.getChildren().add(r2);
      // suorakulmio pyöristetyillä kulmilla
      Rectangle r3 = new Rectangle(25, 90, 60, 30);
      r3.setArcWidth(15);
      r3.setArcHeight(25);
      paneeli.getChildren().add(new Text(10, 107, "r3"));
      paneeli.getChildren().add(r3);
      // 3 suorakulmiota satunnaisilla väreillä
      // kallistettuna
      for (int i = 0; i < 4; i++)
      {
         Rectangle r = new Rectangle(100, 50, 100, 30);
         r.setRotate(i * 360 / 8);
         r.setStroke(Color.color(Math.random(), Math.random(), 
            Math.random()));
         r.setFill(Color.WHITE);
         paneeli.getChildren().add(r);   
      }
      // kehys ja sjoitetaan siihen paneeli
      Scene kehys = new Scene(paneeli, 250, 150);
      alkuIkkuna. setTitle("Näytä rectangle"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // näytetään ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}   


   