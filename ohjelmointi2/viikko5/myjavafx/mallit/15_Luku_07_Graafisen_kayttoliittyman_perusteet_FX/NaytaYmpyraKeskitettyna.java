import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
public class NaytaYmpyraKeskitettyna extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan paneeli ympyr‰lle
      Pane paneeli = new Pane();

      // luodaan ympyr‰ ja asetetaan sen ominaisuuksia
      Circle ympyra = new Circle();
      ympyra.centerXProperty().bind(paneeli.widthProperty().divide(2));
      ympyra.centerYProperty().bind(paneeli.heightProperty().divide(2));
      ympyra.setRadius(50);
      ympyra.setStroke(Color.BLACK);
      ympyra.setFill(Color.WHITE);
      
      paneeli.getChildren().add(ympyra);
      // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli, 200, 200);
      alkuIkkuna. setTitle("Ympyr‰"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   