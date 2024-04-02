import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;

public class NaytaKulma extends Application
{
   @Override // korvaa metodin start luokassa Application
   public void start(Stage alkuIkkuna)
   {
      Pane paneeli = new Pane();
      // pyöreä punainen kulma
      Arc kulma1 = new Arc(150, 100, 80, 80, 30, 35);
      kulma1.setFill(Color.RED);
      kulma1.setType(ArcType.ROUND);
      paneeli.getChildren().add(new Text(210, 40, "kulma1:round"));
      paneeli.getChildren().add(kulma1);
      // avoin valkea kulma
      Arc kulma2 = new Arc(150, 100, 80, 80, 30+90, 35);
      kulma2.setFill(Color.WHITE);
      kulma2.setType(ArcType.OPEN);
      kulma2.setStroke(Color.BLACK);
      paneeli.getChildren().add(new Text(20, 40, "kulma2:open"));
      paneeli.getChildren().add(kulma2);
      // chord valkea kulma
      Arc kulma3 = new Arc(150, 100, 80, 80, 30+180, 35);
      kulma3.setFill(Color.WHITE);
      kulma3.setType(ArcType.CHORD);
      kulma3.setStroke(Color.BLACK);
      paneeli.getChildren().add(new Text(20, 170, "kulma3:chord"));
      paneeli.getChildren().add(kulma3);
      // chord vihreä kulma
      Arc kulma4 = new Arc(150, 100, 80, 80, 30+270, 35);
      kulma4.setFill(Color.GREEN);
      kulma4.setType(ArcType.CHORD);
      kulma4.setStroke(Color.BLACK);
      paneeli.getChildren().add(new Text(210, 170, "kulma4:chord"));
      paneeli.getChildren().add(kulma4);
       // kehys ja sjoitetaan siihen paneeli
      Scene kehys = new Scene(paneeli, 300, 200);
      alkuIkkuna. setTitle("Näytä kulma"); // otsikko ikkunalle
      alkuIkkuna.setScene(kehys); // sijoitetaan kehys ikkunaan
      alkuIkkuna.show(); // näytetään ikkuna
   }
   
   public static void main(String [] args)
   {
      Application.launch(args);
   }   
}   


   