// ---------- Tentti.java ----------
// ########## b-kohta ##########
public class Tentti implements Erinomainen {
    private double pisteet;

    public void setPisteet(double p){
        this.pisteet = p;
    }

    public double getPisteet(){
        return this.pisteet;
    }

    public int getArvosana(){
        int arvosana;

        if (this.pisteet >= 90) {  arvosana = 5;  }
        else if (this.pisteet >= 80) {  arvosana = 4;  }
        else if (this.pisteet >= 70) {  arvosana = 3;  }
        else if (this.pisteet >= 60) {  arvosana = 2;  }
        else if (this.pisteet >= 50) {  arvosana = 1;  }
        else {  arvosana = 0;  }
        return arvosana;
    }

    public boolean onkoErinomainen(){
        boolean palautus = false;
        if (this.getArvosana() == 5){  palautus = true;  }
        return palautus;
    }
}