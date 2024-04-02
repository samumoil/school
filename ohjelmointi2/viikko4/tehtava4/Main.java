// ---------- Main.java ----------
// ########## c-kohta ##########
public class Main {
        public static void main(String [] args) {
                Tentti olio1 = new Tentti();
                olio1.setPisteet(89);
                System.out.println("Tentin pisteet ovat " + olio1.getPisteet() +
                        " ja arvosana " + olio1.getArvosana() + ".\n" +
                        "Onko arvosana \"Erinomainen\"? " + olio1.onkoErinomainen());
                olio1.setPisteet(90);
                System.out.println("Tentin pisteet ovat " + olio1.getPisteet() +
                        " ja arvosana " + olio1.getArvosana() + ".\n" +
                        "Onko arvosana \"Erinomainen\"? " + olio1.onkoErinomainen());
        }
}