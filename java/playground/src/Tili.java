import java.util.Date;

public class Tili {
    private int id;
    private double saldo;
    private static double vuosiKorko = 0;
    private Date luontiPaiva;

    public Tili() {
        this.id = 0;
        this.saldo = 0;
        this.luontiPaiva = new Date();
    }

    public Tili(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
        this.luontiPaiva = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static double getVuosiKorko() {
        return vuosiKorko;
    }

    public static void setVuosiKorko(double vuosiKorko) {
        Tili.vuosiKorko = vuosiKorko;
    }

    public Date getLuontiPaiva() {
        return luontiPaiva;
    }
    public double getKuukausiKorkoProsentti() {
        return getVuosiKorko() / 12;
    }
    public double getKuukausiKorko() {
        return saldo * getKuukausiKorkoProsentti()/100;
    }
    public void nosta(double summa) {
        if (summa <= saldo) {
            saldo = saldo - summa;
        }
        else {
            System.out.println("nostettiin " + saldo + "euroa. Tili tyhjä.");
            saldo = 0;
        }
    }
    public void talleta(double summa) {
        if (summa > 0) {
            saldo += summa;
        }
        else {
            System.out.println("ei voida tallettaa negatiivista summaa. ");
        }
    }
    public static void main(String[] args) {
        Tili tili1 = new Tili(1122, 20000);
        Tili.setVuosiKorko(4.5);
        tili1.nosta(2500);
        tili1.talleta(3000);
        System.out.println("Tilin " + tili1.getId() + " saldo on " + tili1.getSaldo()
                + ", tilin kuukausikorko on " + tili1.getKuukausiKorko()
                + ". Tili on luotu " + tili1.getLuontiPaiva());

    }

// ########## a-kohta ##########
    public Tili(Tili vanhaTili){
        this.id = vanhaTili.getId();
        this.saldo = vanhaTili.getSaldo();
        this.luontiPaiva = new Date();
    }
// ########## b-kohta ##########
    public boolean equals(Tili verrokki){
        boolean palautus = false;
        if (
                this.id == verrokki.getId() &&
                this.saldo == verrokki.getSaldo()
        ) {
            palautus = true;
        }
        return palautus;
    }
// ########## c-kohta ##########
    public boolean suurempiKuin(Tili verrokki){
        boolean palautus = false;
        if (this.saldo > verrokki.getSaldo()) {
            palautus = true;
        }
        return palautus;
    }
// ########## d ii-kohdan valmistelua ##########
    public String toString(){
        String palautus = "Tilin " + this.getId() + " saldo on " + this.getSaldo();
        return palautus;
    }
}