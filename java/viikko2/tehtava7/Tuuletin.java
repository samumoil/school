public class Tuuletin {
    private static int HIDAS = 1;
    private static int NORMAALI = 2;
    private static int NOPEA = 3;
    private int nopeus = HIDAS;
    private boolean kytketty = false;
    private double halkaisija = 5;
    private String vari = "blue";

    public void setNopeus(int nop) {  nopeus = nop;  }
    public int getNopeus() {  return nopeus;  }
    public void setKytketty(boolean kytk) {  kytketty = kytk;  }
    public boolean getKytketty() {  return kytketty; }
    public void setHalkaisija(double halk) {  halkaisija = halk;  }
    public double getHalkaisija() {  return halkaisija;  }
    public void setVari(String var) {  vari = var;  }
    public String getVari() {  return vari;  }

    public Tuuletin(){}

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