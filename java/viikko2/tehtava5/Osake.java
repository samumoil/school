public class Osake {
    private String symboli;
    private String nimi;
    private double edellinenHinta;
    private double nykyinenHinta;

    public Osake(String sym, String nim){
        symboli = sym;
        nimi = nim;
    }
    public void setEdellinenHinta(double ede){
        edellinenHinta = ede;
    }
    public void setNykyinenHinta(double nyk){
        nykyinenHinta = nyk;
    }
    public String getSymboli(){ return  symboli; }
    public String getNimi(){
        return  nimi;
    }
    public double getEdellinenHinta() { return  edellinenHinta; }
    public double getNykyinenHinta(){
        return  nykyinenHinta;
    }
    public double getMuutosProsentti(){
        double palautus = (nykyinenHinta - edellinenHinta)/nykyinenHinta*100;
        return palautus;
    }
}