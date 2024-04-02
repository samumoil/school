package test.viikko7;

import java.io.Serializable;
import java.util.Date;
public class tehtava6_tili implements Serializable {
    private int id;
    private double saldo;
    private static double vuosiKorko = 0;
    private Date luontiPaiva;

    public tehtava6_tili() {
        this.id = 0;
        this.saldo = 0;
        this.luontiPaiva = new Date();
    }

    public tehtava6_tili(int id, double saldo) {
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
        tehtava6_tili.vuosiKorko = vuosiKorko;
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
}

