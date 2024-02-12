
// Luodaan aliluokka D
public class D extends C {
    // A ja B kohdat
    private double d1;

    protected double d2;

    // Setterit ja getterit
    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }

    //Laske metodi joka korvaa yliluokan abstraktin metodin laske
    @java.lang.Override
    public double laske(int x, int y) {
        return getA()*getB();
    }

    public static void main(String[] args) {
        // Luodaan D olio, koska se toteuttaa myös luokan C ominaisuudet
        D olio = new D();
        olio.setA(3);
        olio.setB(2);
        // laske metodin sisälle olevia x ja y:tä ei käytetä mihinkään, outoa :P
        System.out.println(olio.laske(6,9));
        // Testataan vielä setterien ja getterien toimivuudet
        olio.setD1(1);
        olio.setD2(6);
        System.out.println("Tässä D1 arvo: " + olio.getD1());
        System.out.println("Tässä D2 arvo: " + olio.getD2());
    }
}
