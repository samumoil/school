import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
public class NodeTyyliDemo extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan scene ja sijoitetaan siihen Button
      StackPane paneeli = new StackPane();
      Button pkOK = new Button("OK");
      pkOK.setStyle("-fx-border-color: blue;");
      paneeli.getChildren().add(pkOK);
      
      paneeli.setRotate(45);
      paneeli.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

      // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli, 200, 200);
      alkuIkkuna. setTitle("Kallistettu painike"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   