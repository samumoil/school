public class Biisi {
    private String nimi;
    private String esittaja;
    private int spotifySoittomaara;

    public Biisi(){
    }
    public Biisi(String n, String e, int s){
        nimi = n;
        esittaja = e;
        spotifySoittomaara = s;
    }

    public void setNimi(String n){
        nimi = n;
    }
    public void setEsittaja(String e){
        esittaja = e;
    }
    public void setSpotifySoittomaara(int s){
        spotifySoittomaara = s;
    }

    public String getNimi(){
        return nimi;
    }
    public String getEsittaja(){
        return esittaja;
    }
    public int getSpotifySoittomaara(){
        return spotifySoittomaara;
    }
}
