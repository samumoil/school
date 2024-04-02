import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class OmaJavaFX extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan scene olio ja 2sijoitetaan siihen button olio
      Button btOK = new Button("OK");
      Scene kehys = new Scene(btOK, 200, 500);
      alkuIkkuna. setTitle("Oma JavaFX"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   