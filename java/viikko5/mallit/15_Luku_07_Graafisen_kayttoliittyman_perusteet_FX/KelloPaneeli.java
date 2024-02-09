import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
/**
   Kellopaneeli
*/
public class KelloPaneeli extends Pane
{
   private int tunti;
   private int minuutti;
   private int sekunti;
   // kellon leveys ja korkeus
   private double leveys = 250, korkeus = 250;
   // oletus alustaja
   public KelloPaneeli()
   {
      setOikeaAika();
   }
   // alustaja tietyll‰ kellonajalla
   public KelloPaneeli(int tunti, int minuutti, int sekunti)
   {
      this.tunti = tunti;
      this.minuutti = minuutti;
      this.sekunti = sekunti;
      piirraKello();
   }
   public int getTunti()
   {
      return this.tunti;
   }
   public void setTunti(int tunti)
   {
      this.tunti = tunti;
      piirraKello();
   }
   public int getMinuutti()
   {
      return this.minuutti;
   }
   public void setMinuutti(int minuutti)
   {
      this.minuutti = minuutti;
      piirraKello();
   }
   public int getSekunti()
   {
      return this.sekunti;
   }
   public void setSekunti(int sekunti)
   {
      this.sekunti = sekunti;
      piirraKello();
   }
   public double getLeveys()
   {
      return this.leveys;
   }
   public void setLeveys(double leveys)
   {
      this.leveys = leveys;
      piirraKello();
   }
   public double getKorkeus()
   {
      return this.korkeus;
   }
   public void setKorkeus(double korkeus)
   {
      this.korkeus = korkeus;
      piirraKello();
   }
   // asetetaan oikea kellonaika
   public void setOikeaAika()
   {  // luodaan gregoriaaninen kalenteri joka tiet‰‰ ajan
      Calendar kalenteri = new GregorianCalendar();
      // asetetaan kelloon aika
      this.tunti = kalenteri.get(Calendar.HOUR_OF_DAY);
      this.minuutti = kalenteri.get(Calendar.MINUTE);
      this.sekunti = kalenteri.get(Calendar.SECOND);
      // piirret‰‰n kello uudestaan
      piirraKello();
   }
   // piirret‰‰n kellotaulu ja siihen viisarit
   protected void piirraKello()
   {
      double kellonSade = Math.min(leveys, korkeus) * 0.8 * 0.5;
      double keskusX = leveys / 2;
      double keskusY = korkeus / 2;
      // piirret‰‰n kellotaulu
      Circle ympyra = new Circle(keskusX, keskusY, kellonSade);
      ympyra.setFill(Color.WHITE);
      ympyra.setStroke(Color.BLACK);
      Text t1 = new Text(keskusX -5, keskusY - kellonSade + 12, "12");
      Text t2 = new Text(keskusX - kellonSade + 3, keskusY + 5, "9");
      Text t3 = new Text(keskusX + kellonSade - 10, keskusY + 3, "3");
      Text t4 = new Text(keskusX -3, keskusY + kellonSade - 3, "6");
      // piirret‰‰n punainen sekuntiviisari
      double sPituus = kellonSade * 0.8;
      double sekuntiX = keskusX + sPituus * 
         Math.sin(sekunti * (2 * Math.PI / 60));
      double sekuntiY = keskusY - sPituus * 
         Math.cos(sekunti * (2 * Math.PI / 60));
      Line sViiva = new Line(keskusX, keskusY, sekuntiX, sekuntiY);
      sViiva.setStroke(Color.RED);   
      // piirret‰‰n minuuttiviisari joka lyhyempi ja sininen
      double mPituus = kellonSade * 0.65;
      double minuuttiX = keskusX + mPituus * 
         Math.sin(minuutti * (2 * Math.PI / 60));
      double minuuttiY = keskusY - mPituus * 
         Math.cos(minuutti * (2 * Math.PI / 60));
      Line mViiva = new Line(keskusX, keskusY, minuuttiX, minuuttiY);
      mViiva.setStroke(Color.BLUE);   
      // piirret‰‰n tuntiviisari joka lyhempi ja vihre‰
      double tPituus = kellonSade * 0.5;
      double tuntiX = keskusX + tPituus * 
         Math.sin((tunti % 12 + minuutti / 60.0) * (2 * Math.PI / 12));
      double tuntiY = keskusY - tPituus * 
         Math.cos((tunti % 12 + minuutti / 60.0) * (2 * Math.PI / 60));
      Line tViiva = new Line(keskusX, keskusY, tuntiX, tuntiY);
      tViiva.setStroke(Color.GREEN);   
      
      // tyhjennet‰‰n ja lis‰t‰‰n solmut
      getChildren().clear();
      getChildren().addAll(ympyra, t1, t2, t3, t4, sViiva, mViiva, tViiva);

   }
   
}