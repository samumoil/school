public class Main {
    public static void main(String[] args) {
        Tuuletin tuuletin1 = new Tuuletin();
        Tuuletin tuuletin2 = new Tuuletin();

        tuuletin1.setNopeus(3);
        tuuletin1.setHalkaisija(10);
        tuuletin1.setVari("keltainen");
        tuuletin1.setKytketty(true);

        tuuletin2.setNopeus(2);
        tuuletin2.setHalkaisija(5);
        tuuletin2.setVari("blue");
        tuuletin2.setKytketty(false);

        System.out.println(tuuletin1.toString());
        System.out.printf(tuuletin2.toString());
    }
}
