import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class FontDemo extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan scene ja sijoitetaan siihen Button
      Pane paneeli = new StackPane();
    
      Circle ympyra = new Circle();
      ympyra.setRadius(50);
      ympyra.setStroke(Color.BLACK);
      //ympyra.setFill(Color.WHITE);
      ympyra.setFill(new Color(0.5,0.5,0.5,0.1));
      paneeli.getChildren().add(ympyra);
      
      Label teksti = new Label("JavaFX");
      teksti.setFont(Font.font("Times New Roman", 
           FontWeight.BOLD, FontPosture.ITALIC, 20));
      paneeli.getChildren().add(teksti);

            // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli, 200, 200);
      alkuIkkuna. setTitle("FonttiDemo"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   