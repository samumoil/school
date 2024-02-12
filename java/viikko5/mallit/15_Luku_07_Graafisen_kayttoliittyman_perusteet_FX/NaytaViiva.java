import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Line;

public class NaytaViiva extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // kehys ja sjoitetaan siihen paneeli
      Scene kehys = new Scene(new ViivaPaneeli(), 200, 200);
      alkuIkkuna. setTitle("N‰yt‰ teksti"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
      

   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}   

class ViivaPaneeli extends Pane
{
   public ViivaPaneeli()
   {
      // viiva on piste 10, 10
      Line viiva1 = new Line(10,10,10,10);
      // loppuX ja loppuY asetetaan paneelin toiseen reunaan
      viiva1.endXProperty().bind(widthProperty().subtract(10));
      viiva1.endYProperty().bind(heightProperty().subtract(10));
      // asetetaan leveys ja v‰ri
      viiva1.setStrokeWidth(5);
      viiva1.setStroke(Color.GREEN);
      getChildren().add(viiva1);
      
      Line viiva2 = new Line(10,10,10,10);
      // alkuX ja loppuY asetetaan paneelin toiseen reunaan
      viiva2.startXProperty().bind(widthProperty().subtract(10));
      viiva2.endYProperty().bind(heightProperty().subtract(10));
      viiva2.setStrokeWidth(5);
      viiva2.setStroke(Color.GREEN);
      getChildren().add(viiva2);
      
      
   }
}   
   