import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NaytaGridPane extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      // luodaan paneeli 
      GridPane paneeli = new GridPane();
      paneeli.setAlignment(Pos.CENTER);
      paneeli.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
      paneeli.setHgap(5.5);
      paneeli.setVgap(5.5);
      
      // sijoitetaan paneeliin solmuja
      paneeli.add(new Label("Etunimi: "), 0, 0);
      paneeli.add(new TextField(), 1, 0);
      paneeli.add(new Label("Toinen nimi: "), 0, 1);
      paneeli.add(new TextField(), 1, 1);
      paneeli.add(new Label("Sukunimi:"), 0, 2);
      paneeli.add(new TextField(), 1, 2);
      Button btLisaa = new Button("Lis‰‰ nimi");
      paneeli.add(btLisaa, 1, 3);
      GridPane.setHalignment(btLisaa, HPos.RIGHT);  
           
      // sijoitetaan paneeli kehykseen
      Scene kehys = new Scene(paneeli);
      alkuIkkuna. setTitle("N‰yt‰ GridPane"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // n‰ytet‰‰n ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}      
   