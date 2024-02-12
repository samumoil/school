

public class Tentti implements Erinomainen {
    private double pisteet;

    public void setPisteet(double p) {
        this.pisteet = p;
    }

    public double getPisteet() {
        return this.pisteet;
    }

    public int getArvosana() {
        int arvosana;

        if (this.pisteet >= 90) {
            arvosana = 5;
        } else if (this.pisteet >= 80) {
            arvosana = 4;
        } else if (this.pisteet >= 70) {
            arvosana = 3;
        } else if (this.pisteet >= 60) {
            arvosana = 2;
        } else if (this.pisteet >= 50) {
            arvosana = 1;
        } else {
            arvosana = 0;
        }
        return arvosana;
    }

    // Tehtävä 4 jatkuu alle
    // Tulee rajapinnalta Erinomainen
    @Override
    public boolean onkoErinomainen() {
        return this.getArvosana()==5;
    }

    public static void main(String[] args) {
        Tentti t = new Tentti();
        t.setPisteet(98);
        System.out.print("Onko erinomainen: "+t.onkoErinomainen());
    }
}

