public class SaaAsema {

// ########## a-kohta ##########
    private double lampotila;
// ########## b-kohta ##########
    private double paine;

// ########## c-kohta ##########
    public SaaAsema(){
        this.lampotila = 0;
        this.paine = 1;
    }

// ########## d-kohta ##########
    public SaaAsema(double lampotila, double paine){
        this.lampotila = lampotila;
        this.paine = paine;
    }

// ########## e-kohta ##########
    public static SaaAsema luoSaaAsema(double lampoFahr, double painePSI){
        SaaAsema outoOlio = new SaaAsema();
        outoOlio.setFahrenheit(lampoFahr);
        outoOlio.setPSI(painePSI);
        return outoOlio;
    }

// ########## f-kohta ##########
    public double getLampotila(){  return lampotila;  }
    public double getPaine(){  return paine;  }
    public void setLampotila(double lampotila){  this.lampotila = lampotila;  }
    public void setPaine(double paine){  this.paine = paine;  }

// ########## g-kohta ##########
    public double getFahrenheit(){  return (lampotila*1.8)+32;  }
    public double getPSI(){  return paine/0.0689475729;  }

// ########## h-kohta ##########
    public void setFahrenheit(double lampoFahr){
        this.lampotila = (lampoFahr-32)/1.8;
    }
    public void setPSI(double painePSI){
        this.paine = painePSI*0.0689475729;
    }

// ########## ekstraa helpottamaan testausta pääohjelmassa ##########
    public String toString(){
        String palautus = "\nLämpötila celsius-asteina on: " + lampotila +
                "\nLämpötila fahrenheit-asteina on: " + this.getFahrenheit() +
                "\nPaine baareina on: " + paine +
                "\nPaine PSI on: " + this.getPSI();
        return palautus;
    }
}
