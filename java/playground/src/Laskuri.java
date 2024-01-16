public class Laskuri {
    private int leveys;
    private int pituus;

    public Laskuri(){
    }
    public Laskuri(int pit,int lev){
        pituus = pit;
        leveys = lev;
    }
    public int pintaAla() {
        return pituus * leveys;
    }
    public void laskuriLevSet(int lev){
        leveys = lev;
    }
}
