public class D extends C {
    // ########## a ja b-kohta ##########
    private double d1;
    protected double d2;

    // ########## c-kohta ##########
    public void setD1(double d1){  this.d1 = d1;  }
    public void setD2(double d2){  this.d2 = d2;  }
    public double getD1(){  return d1;  }
    public double getD2(){  return d2;  }

    // ########## Luodaan alustaja ##########
    public D(){}

    // ########## d-kohta ##########
    public double laske(int x, int y) {
        double palautus = x*y;
        return palautus;
    }
}