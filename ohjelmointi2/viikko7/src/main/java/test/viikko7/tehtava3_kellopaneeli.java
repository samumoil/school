package test.viikko7;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
/**
 Kellopaneeli
 */
public class tehtava3_kellopaneeli extends Pane
{
    private int tunti;
    private int minuutti;
    private int sekunti;
    // kellon leveys ja korkeus
    private double leveys = 250, korkeus = 250;
    // oletus alustaja
    public tehtava3_kellopaneeli()
    {
        this.tunti = 1;
        this.minuutti = 1;
        this.sekunti = 2;
        piirraKello();
    }
    // alustaja tietyllä kellonajalla
    public tehtava3_kellopaneeli(int tunti, int minuutti, int sekunti)
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
    // piirretään kellotaulu ja siihen viisarit
    protected void piirraKello()
    {
        double kellonSade = Math.min(leveys, korkeus) * 0.8 * 0.5;
        double keskusX = leveys / 2;
        double keskusY = korkeus / 2;
        // piirretään kellotaulu
        Circle ympyra = new Circle(keskusX, keskusY, kellonSade);
        ympyra.setFill(Color.WHITE);
        ympyra.setStroke(Color.BLACK);
        Text t1 = new Text(keskusX -5, keskusY - kellonSade + 12, "12");
        Text t2 = new Text(keskusX - kellonSade + 3, keskusY + 5, "9");
        Text t3 = new Text(keskusX + kellonSade - 10, keskusY + 3, "3");
        Text t4 = new Text(keskusX -3, keskusY + kellonSade - 3, "6");
        // piirretään punainen sekuntiviisari
        double sPituus = kellonSade * 0.8;
        double sekuntiX = keskusX + sPituus *
                Math.sin(sekunti * (2 * Math.PI / 60));
        double sekuntiY = keskusY - sPituus *
                Math.cos(sekunti * (2 * Math.PI / 60));
        Line sViiva = new Line(keskusX, keskusY, sekuntiX, sekuntiY);
        sViiva.setStroke(Color.RED);
        // piirretään minuuttiviisari joka lyhyempi ja sininen
        double mPituus = kellonSade * 0.65;
        double minuuttiX = keskusX + mPituus *
                Math.sin(minuutti * (2 * Math.PI / 60));
        double minuuttiY = keskusY - mPituus *
                Math.cos(minuutti * (2 * Math.PI / 60));
        Line mViiva = new Line(keskusX, keskusY, minuuttiX, minuuttiY);
        mViiva.setStroke(Color.BLUE);
        // piirretään tuntiviisari joka lyhempi ja vihreä
        double tPituus = kellonSade * 0.5;
        double tuntiX = keskusX + tPituus *
                Math.sin((tunti % 12 + minuutti / 60.0) * (2 * Math.PI / 12));
        double tuntiY = keskusY - tPituus *
                Math.cos((tunti % 12 + minuutti / 60.0) * (2 * Math.PI / 12));
        Line tViiva = new Line(keskusX, keskusY, tuntiX, tuntiY);
        tViiva.setStroke(Color.GREEN);

        // tyhjennetään ja lisätään solmut
        this.getChildren().clear();
        this.getChildren().addAll(ympyra, t1, t2, t3, t4, sViiva, mViiva, tViiva);
    }
}