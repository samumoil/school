/**
 * Class/object representation of one customer's information.
 * This class doesn't have default constructor and it needs
 * to be constructed with parameters.
 *
 * @param   nimi    Customer's name
 * @param   osoite  Customer's address
 * @param   kengannumero    Customer's shoe size
 * @param   hatunkoko   Customer's hat size
 * @author Samu Moilanen
 */
public class Asiakas {

    // ########## a-kohta ##########
    private String nimi;
    private String osoite;
    private double kengannumero;
    private double hatunkoko;

    // ########## b-kohta ##########

    /**
     * Only constructor of this class.
     *
     * @param   nimi    Customer's name
     * @param   osoite  Customer's address
     * @param   kengannumero    Customer's shoe size
     * @param   hatunkoko   Customer's hat size
     */
    public Asiakas(String nimi, String osoite, double kengannumero, double hatunkoko){
        this.nimi = nimi;
        this.osoite = osoite;
        this.kengannumero = kengannumero;
        this.hatunkoko = hatunkoko;
    }

    // ########## c-kohta ##########
    public void setNimi(String nimi){  this.nimi = nimi;  }
    public void setOsoite(String osoite){  this.osoite = osoite;  }
    public void setKengannumero(double kengannumero){  this.kengannumero = kengannumero;  }
    public void setHatunkoko(double hatunkoko){  this.hatunkoko = hatunkoko;  }
    public String getNimi(){  return nimi;  }
    public String getOsoite(){ return osoite;  }
    public double getKengannumero(){  return kengannumero;  }
    public double getHatunkoko(){  return hatunkoko;  }

    // ########## d-kohta ##########
    public boolean equals(Asiakas verrokki){
        boolean palautus = false;
        if (
                this.nimi == verrokki.getNimi() &&
                        this.osoite == verrokki.getOsoite() &&
                        this.kengannumero == verrokki.getKengannumero() &&
                        this.hatunkoko == verrokki.getHatunkoko()
        )
            palautus = true;
        return palautus;
    }

    public Asiakas copy(){
        Asiakas palautus = new Asiakas(
                this.getNimi(),
                this.getOsoite(),
                this.getKengannumero(),
                this.getHatunkoko()
        );
        return palautus;
    }

    public String toString(){
        String palautus = "Asiakkaan nimi: " + this.nimi +
                "\nOsoite: " + this.osoite +
                "\nKengännumero: " + this.kengannumero +
                "\nHatunkoko: " + this.hatunkoko;
        return palautus;
    }
}
