public class Suojaus {

// ########## a-kohta ##########
    private int salainen;
// ########## b-kohta ##########
    int puolinainen;
// ########## c-kohta ##########
    public Suojaus(int salainen, int puolinainen){
        this.salainen = salainen;
        this.puolinainen = puolinainen;
    }

// ########## d-kohta ##########
    public int getSalainen(){  return salainen;  }
    public int getPuolinainen(){  return puolinainen;  }
    public void setSalainen(int salainen){  this.salainen = salainen;  }
    public void setPuolinainen(int puolinainen){  this.puolinainen = puolinainen;  }
}
