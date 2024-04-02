public class Main {
    public static void main(String[] args) {
// ########## e i-kohta ##########
    Suojaus sala = new Suojaus(1, 2);
    Suojaus julki = new Suojaus(3, 4);

// ########## e ii-kohta ##########
    // Tämä ei mene läpi kääntäjästä, koska kyseessä on salainen muuttuja:
    // System.out.println(sala.salainen());
    System.out.println(sala.puolinainen); // Tämä kyllä menee läpi.

// ########## e iii-kohta ##########
    // Hyvin onnistuu!
    System.out.println(julki.getSalainen());
    System.out.println(julki.getPuolinainen());

// ########## e iv-kohta ##########
    // sala.salainen = 5; // Tämä ei mene läpi!
    sala.puolinainen = 5; // Tämä onnistuu kyllä.
    System.out.println(sala.puolinainen);

// ########## e iv-kohta ##########
    julki.setSalainen(123);
    System.out.println(julki.getSalainen());
    julki.setPuolinainen(456);
    System.out.println(julki.getPuolinainen());
    }
}
