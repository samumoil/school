package test.viikko7;


import java.io.Serializable;

public class Pankkitili implements Serializable { // tähän lisäys
    private double vuosiKorko;
    private double saldo;
    /**
     * Pankkiili alkusaldolla.
     * @param saldo
     */
    public Pankkitili(double saldo) {
        this.saldo = saldo;
    }
    public Pankkitili(Pankkitili tili) {
        this.saldo = tili.getSaldo();
    }
    /**
     * Vuosikoron asetus
     * @param vuosiKorko
     */
    public void setVuosiKorko(double vuosiKorko) {
        this.vuosiKorko = vuosiKorko;
    }

    /**
     * Summan talletus tilille.
     * @param summa
     */
    public void talleta(double summa) {
        if (summa > 0){
            this.saldo += summa;
            System.out.println("Talletettiin " + summa);
        }
        else
            System.out.println("Rahamaaran pitaa olla positiivinen arvo!");
    }
    /**
     * Summan nosto tililta.
     * @param summa
     */
    public void nosta(double summa) {
        if (summa < 0)
            System.out.println("Rahamaaran pitaa olla positiivinen arvo!");
        else if (summa <= this.saldo) {
            this.saldo -= summa;
            System.out.println("Nostettiin " + summa);
        }
        else {
            System.out.println("Tililla ei ole riittavasti katetta.");
            System.out.println("Nostettiin " + this.saldo);
            this.saldo = 0;

        }
    }
    /**
     * Kuukausikoron lisays.
     */
    public void lisaaKorko() {
        this.saldo += (this.saldo * this.vuosiKorko / 100.0) / 12;
    }
    /**
     * Saldon tarkistus.
     * @return
     */
    public double getSaldo() {
        return saldo;
    }
    public double getVuosiKorko() {
        return vuosiKorko;
    }
}

