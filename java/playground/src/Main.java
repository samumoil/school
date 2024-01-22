
// ### i-kohta ###
public class Main {
    public static void main(String[] args) {
        Tuuletin tuuletin1 = new Tuuletin();
        Tuuletin tuuletin2 = new Tuuletin();

        tuuletin1.setNopeus(3);
        tuuletin1.setHalkaisija(10);
        tuuletin1.setVari("keltainen");
        tuuletin1.setKytketty(true);

        tuuletin2.setNopeus(2);
        tuuletin2.setHalkaisija(5);
        tuuletin2.setVari("blue");
        tuuletin2.setKytketty(false);

        System.out.println(tuuletin1.toString());
        System.out.printf(tuuletin2.toString());
    }
}

class Tuuletin {
    // ### a-kohta ###
    private static int HIDAS = 1;
    private static int NORMAALI = 2;
    private static int NOPEA = 3;
    // ### b-kohta ###
    private int nopeus = HIDAS;
    // ### c-kohta ###
    private boolean kytketty = false;
    // ### d-kohta ###
    private double halkaisija = 5;
    // ### e-kohta ###
    private String vari = "blue";

    // ### f-kohta alkaa ###
    public void setNopeus(int nop) {  nopeus = nop;  }
    public int getNopeus() {  return nopeus;  }
    public void setKytketty(boolean kytk) {  kytketty = kytk;  }
    public boolean getKytketty() {  return kytketty; }
    public void setHalkaisija(double halk) {  halkaisija = halk;  }
    public double getHalkaisija() {  return halkaisija;  }
    public void setVari(String var) {  vari = var;  }
    public String getVari() {  return vari;  }

    // ### g-kohta ###
    public Tuuletin(){}

    // ### h-kohta alkaa ###
    public String toString() {
        String palautus;
        if (kytketty) {
            String nopeusTeksti;
            if (nopeus == 1) {  nopeusTeksti = "HIDAS";  }
            else if (nopeus == 2) {  nopeusTeksti = "NORMAALI";  }
            else {  nopeusTeksti = "NOPEA";  }
            palautus = nopeusTeksti + " " + vari + " " + Double.toString(halkaisija/2);
        }
        else {
            palautus = vari + " " + Double.toString(halkaisija) + " tuuletin ei ole päällä";
        }
        return palautus;
    }
}
