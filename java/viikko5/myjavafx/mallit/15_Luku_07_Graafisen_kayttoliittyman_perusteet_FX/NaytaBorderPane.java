import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class NaytaBorderPane extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan paneeli 
      BorderPane paneeli = new BorderPane();
      
      // sijoitetaan paneeliin solmuja
      paneeli.setTop(new CustomPaneeli("Top"));
      paneeli.setRight(new CustomPaneeli("Right"));
      paneeli.setBottom(new CustomPaneeli("Bottom"));
      paneeli.setLeft(new CustomPaneeli("Left"));
      paneeli.setCenter(new CustomPaneeli("Center"));
         
      // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli);
      alkuIkkuna. setTitle("N‰yt‰ BoderPane"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      

// m‰‰ritell‰‰n custom paneeli jossa on teksti keskell‰ paneelia
class CustomPaneeli extends StackPane
{
   public CustomPaneeli(String otsikko)
   {
      getChildren().add(new Label(otsikko));
      setStyle("-fx-border-color: red");
      setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
   }
}   