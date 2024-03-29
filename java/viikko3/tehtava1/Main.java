
class Kurssi {
    private int kurssikoodi;
    private double opintopisteet;
    public Kurssi(int kurssikoodi, double opintopisteet) {
        this.kurssikoodi = kurssikoodi;
        this.opintopisteet = opintopisteet;
    }
    public int getKurssikoodi() {
        return kurssikoodi;
    }
    public double getOpintopisteet() {
        return opintopisteet;
    }
    public boolean laaja() {
        if (this.opintopisteet > 5)
            return true;
        else
            return false;
    }

// ########## a-kohta ##########
    public String toString(){
        return kurssikoodi + " " + opintopisteet;
    }

// ########## b-kohta ##########
    public boolean equals(Kurssi olio) {
        boolean palautus = false;
        if ((olio.getKurssikoodi() == this.kurssikoodi) &&
                olio.getOpintopisteet() == this.opintopisteet)
            palautus = true;
        return palautus;
    }
// ########## c-kohta ##########
    public boolean suurempiKuin(Kurssi olio){
        boolean palautus = false;
        if (this.opintopisteet > olio.opintopisteet)
            palautus = true;
        return palautus;
    }
}

// ########## d-kohta ##########
public class Main {
    public static void main(String[] args) {
// ########## d i-kohta ##########
    Kurssi kurssi1 = new Kurssi(111, 1.1);
    Kurssi kurssi2 = new Kurssi(111, 1.1);
    Kurssi kurssi3 = new Kurssi(555, 5.5);

// ########## d ii-kohta ##########
    System.out.println("Kurssin 1 tiedot: " + kurssi1.toString());
    System.out.println("Kurssin 2 tiedot: " + kurssi2.toString());
    System.out.println("Kurssin 3 tiedot: " + kurssi3.toString());

// ########## d iii-kohta ##########
    System.out.println("Ovatko kurssit 1 ja 2 samanlaisia? " + kurssi1.equals(kurssi2));
    System.out.println("Ovatko kurssit 1 ja 3 samanlaisia? " + kurssi1.equals(kurssi3));
    System.out.println("Ovatko kurssit 2 ja 3 samanlaisia? " + kurssi2.equals(kurssi3));

// ########## d iv-kohta ##########
    Kurssi laajin = kurssi1;
    if (kurssi2.suurempiKuin(kurssi1) && kurssi2.suurempiKuin(kurssi3))
        laajin = kurssi2;
    else if (kurssi3.suurempiKuin(kurssi1) && kurssi3.suurempiKuin(kurssi2))
        laajin = kurssi3;
    System.out.println("Laajin kurssi on: " + laajin.toString());

    // ########## d v-kohta ##########
    System.out.println("Onko kurssi 1 laaja? " + kurssi1.laaja());
    System.out.println("Onko kurssi 2 laaja? " + kurssi2.laaja());
    System.out.println("Onko kurssi 3 laaja? " + kurssi3.laaja());
    }
}
