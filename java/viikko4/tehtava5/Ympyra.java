// ---------- Ympyra.java ----------
    // ########## a-kohta ##########
import java.io.Serializable;
import java.util.Scanner;

public class Ympyra implements Serializable {
    private double sade;
    public Ympyra(double r) {
        sade = r;
    }
    public double getAla() {
        return Math.PI * sade * sade;
    }
    public double getSade() {
        return sade;
    }
    public String toString() {
        return "Ympyrän säde on " + sade + " ja pinta-ala on " + getAla();
    }
    public boolean equals(Ympyra y) {
        if (this.sade == y.getSade())
            return true;
        else
            return false;
    }
    public boolean suurempiKuin(Ympyra y) {
        if (this.getAla() > y.getAla())
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("anna ekan ympyr�n� s�de: ");
        double s1 = input.nextDouble();
        System.out.println("anna tokan ympyr�n� s�de: ");
        double s2 = input.nextDouble();
        Ympyra y1 = new Ympyra(s1);
        Ympyra y2 = new Ympyra(s2);
        System.out.println(y1);
        System.out.println(y2);
        if (y1.equals(y2))
            System.out.println("Ympyr�t samat");
        else
            System.out.println("Ympyr�t ei ole samat");
        if (y1.suurempiKuin(y2))
            System.out.println("Eka suurempi");
        else
            System.out.println("Eka ei ole suurempi");
    }
}