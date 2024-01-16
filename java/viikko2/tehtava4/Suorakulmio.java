public class Suorakulmio {
    private double leveys = 1;
    private double korkeus = 1;

    public Suorakulmio(){}
    public Suorakulmio(double lev, double kor){
        leveys = lev;
        korkeus = kor;
    }

    public double getAla(){
        return leveys * korkeus;
    }

    public double getYmparys(){
        return (2*leveys + 2*korkeus);
    }

}