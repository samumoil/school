import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class MoniStageDemo extends Application
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
      
      Stage ikkuna = new Stage();
      ikkuna.setTitle("Toinen ikkuna");
      ikkuna.setScene(new Scene(new Button("Toinen ikkuna"), 100, 100));
      ikkuna.show();
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   