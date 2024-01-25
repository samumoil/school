import java.util.Date;
class Pankkitili {
    // ### a-kohta ###
    private int id;
    // ### b-kohta ###
    private double saldo;
    // ### c-kohta ###
    private double vuosiKorko;
    // ### d-kohta ###
    private Date luontiPaiva;

    // ### e-kohta ###
    public Pankkitili(){}
    // ### f-kohta ###

    /**
     * Method creates an object representing one bank account.
     *
     * @param tiliNumero    ID-number of the bank account.
     * @param sal           Current amount of money in the account.
     * @param vuoKor        Yearly interest of the account, percent.
     */
    public Pankkitili(int tiliNumero, double sal, double vuoKor){
        id = tiliNumero;
        saldo = sal;
        vuosiKorko = vuoKor;
        luontiPaiva = new Date();
    }

    // ### g-kohta alkaa ###
    public void setId(int tiliNumero) {  id = tiliNumero;  }
    public int getId() {  return id;  }
    public void setSaldo(double sal) {  saldo = sal;  }
    public double getSaldo() {  return saldo;  }
    public void setVuosiKorko(double kor) {  vuosiKorko = kor;  }
    public double getVuosiKorko() {  return vuosiKorko;  }

    // ### h-kohta ###
    public Date getLuontiPaiva() {  return luontiPaiva;  }

    // ### i-kohta ###
    public double getKuukausiKorkoProsentti() {  return vuosiKorko/12;  }
    // ### j-kohta ###
    public double getKuukausiKorko() {  return saldo*vuosiKorko/100/12;  }

    // ### k-kohta ###
    public void nosta(double nosto) {
        if (nosto <= saldo) {
            saldo -= nosto;
        }
    }

    // ### l-kohta ###
    public void talleta(double talletus) {  saldo += talletus;  }

    // ### Ekstraa viikon 3 tehtävää 7 varten:
    public String toString(){
        String palautus = "\nTilinumero: " + getId() +
                "\nTilin saldo: " + getSaldo();
        return palautus;
    }
}
