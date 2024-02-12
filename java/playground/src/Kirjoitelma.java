public class Kirjoitelma extends Tentti{
    int kielioppi;
    int oikeinkirjoitus;
    int pituus;
    int sisalto;

    public Kirjoitelma() {
    }

    public Kirjoitelma(int kielioppi, int oikeinkirjoitus, int pituus, int sisalto) {
        this.kielioppi = kielioppi;
        this.oikeinkirjoitus = oikeinkirjoitus;
        this.pituus = pituus;
        this.sisalto = sisalto;
        this.setPisteet(this.kielioppi+this.oikeinkirjoitus+ this.pituus + this.sisalto);
    }

    public int getKielioppi() {
        return kielioppi;
    }

    public void setKielioppi(int kielioppi) {
        if (kielioppi <= 30) {
            this.kielioppi = kielioppi;
        }
        else this.kielioppi = 30;
    }

    public int getOikeinkirjoitus() {
        return oikeinkirjoitus;
    }

    public void setOikeinkirjoitus(int oikeinkirjoitus) {
        if (this.oikeinkirjoitus <= 20)
            this.oikeinkirjoitus = oikeinkirjoitus;
        else
            this.oikeinkirjoitus = 20;
    }

    public int getPituus() {
        return pituus;
    }

    public void setPituus(int pituus) {
        if (pituus <= 20) {
            this.pituus = pituus;
        }
        else this.pituus = 20;
    }

    public int getSisalto() {
        return sisalto;
    }

    public void setSisalto(int sisalto) {
        if (sisalto <= 30) {
            this.sisalto = sisalto;
        }
        else
            this.sisalto = 30;
    }
    public void setPisteet() {
        double pisteet = this.getKielioppi() + this.getOikeinkirjoitus() + this.getPituus() + this.getSisalto();
        this.setPisteet(pisteet);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Kirjoitelma{" +
                "kielioppi=" + kielioppi +
                ", oikeinkirjoitus=" + oikeinkirjoitus +
                ", pituus=" + pituus +
                ", sisalto=" + sisalto +
                '}';
    }

    public static void main(String[] args) {
        Kirjoitelma juttu = new Kirjoitelma();
        juttu.setKielioppi(40);
        juttu.setOikeinkirjoitus(10);
        juttu.setPituus(25);
        juttu.setSisalto(30);
        juttu.setPisteet(juttu.getKielioppi() + juttu.getOikeinkirjoitus() +
                juttu.getPituus() + juttu.getSisalto());
        // tai
        juttu.setPisteet();
        System.out.println(juttu);
        System.out.println("arvosana on " + juttu.getArvosana());



    }
}