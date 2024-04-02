// ########## a-kohta ##########
public class Kirjoitelma extends Tentti{
    // ########## a i-kohta ##########
    private double kielioppi, oikeinkirjoitus, pituus, sisalto;

    // Luodaan alustajat
    public Kirjoitelma(){}
    public Kirjoitelma(double kielioppi, double oikeinkirjoitus, double pituus, double sisalto){
        this.kielioppi = kielioppi;
        this.oikeinkirjoitus = oikeinkirjoitus;
        this.pituus = pituus;
        this.sisalto = sisalto;
        this.paivitaPisteet();
    }

    // Set-metodit kirjoitelman eri pisteille, jos on käytetty oletusalustajaa
    // tai halutaan muuttaa aiemmin merkittyjä pisteitä. Pisteiden lisäyksen jälkeen
    // päivitetään yhteispisteet.

    // ########## a i-kohta ##########
    public void setKielioppi(double kielioppi){
        if (kielioppi < 0 || kielioppi > 30){
            System.out.println("Kieliopin pistemäärä on 0-30 pistettä. Kirjataan 0 pistettä.");
        }
        else {
            this.kielioppi = kielioppi;
            this.paivitaPisteet();
        }
    }
    // ########## a ii-kohta ##########
    public void setOikeinkirjoitus(double oikeinkirjoitus){
        if (oikeinkirjoitus < 0 || oikeinkirjoitus > 20){
            System.out.println("Oikeinkirjoituksen pistemäärä on 0-20 pistettä. Kirjataan 0 pistettä.");
        }
        else {
            this.oikeinkirjoitus = oikeinkirjoitus;
            this.paivitaPisteet();
        }
    }
    // ########## a iii-kohta ##########
    public void setPituus(double pituus){
        if (pituus < 0 || pituus > 20) {
            System.out.println("Pituuden pistemäärä on 0-20 pistettä. Kirjataan 0 pistettä.");
        }
        else {
            this.pituus = pituus;
            this.paivitaPisteet();
        }
    }
    // ########## a iv-kohta ##########
    public void  setSisalto(double sisalto){
        if (sisalto < 0 || sisalto > 30){
            System.out.println("Sisällön pistemäärä on 0-30 pistettä. Kirjataan 0 pistettä.");
        }
        else {
            this.sisalto = sisalto;
            this.paivitaPisteet();
        }
    }

    // Get-metodit kirjoitelman eri pisteille
    public double getKielioppi(){  return this.kielioppi;  }
    public double getOikeinkirjoitus(){  return this.oikeinkirjoitus;  }
    public double getPituus(){  return this.pituus;  }
    public double getSisalto(){  return this.sisalto;  }

    /**
     * Tämä metodi laskee yhteen kirjoitelman eri pisteet ja asettaa yhteispisteet
     * olion muuttujaan "pisteet" käyttämällä setPisteet-metodia yläluokasta.
     */
    private void paivitaPisteet(){
        double yhteensa = this.oikeinkirjoitus + this.kielioppi + this.pituus + this.sisalto;
        this.setPisteet(yhteensa);
    }
}
