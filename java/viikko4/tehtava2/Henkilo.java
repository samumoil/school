// ########## c-kohta ##########
public class Henkilo implements Niminen
{
    private String nimi;
    public Henkilo(){}  // oletusalustaja
    public Henkilo(String n){  this.nimi = n;  } // alustaja

    public void setNimi(String n){  this.nimi = n;  }
    public String getNimi(){  return nimi;  }
}
