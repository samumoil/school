import java.util.Date;

public class Tili {
    private int id;
    private double saldo;
    private double vuosiKorko;
    private Date luontiPaiva;

    public Tili(){}
    public Tili(int tiliNumero, double sal, double vuoKor){
        id = tiliNumero;
        saldo = sal;
        vuosiKorko = vuoKor;
        luontiPaiva = new Date();
    }

    public void setId(int tiliNumero) {  id = tiliNumero;  }
    public int getId() {  return id;  }
    public void setSaldo(double sal) {  saldo = sal;  }
    public double getSaldo() {  return saldo;  }
    public void setVuosiKorko(double kor) {  vuosiKorko = kor;  }
    public double getVuosiKorko() {  return vuosiKorko;  }
    public Date getLuontiPaiva() {  return luontiPaiva;  }

    public double getKuukausiKorkoProsentti() {  return vuosiKorko/12;  }

    public double getKuukausiKorko() {  return saldo*vuosiKorko/100/12;  }

    public void nosta(double nosto) {
        if (nosto <= saldo) {
            saldo -= nosto;
        }
    }

    public void talleta(double talletus) {  saldo += talletus;  }
}