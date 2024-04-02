// ########## f-kohta ##########
public class Main {
    public static void main(String[] args) {
        // Luodaan kaksi oliota
        Asiakas asiakas1 = new Asiakas(
                "Matti Meikäläinen",
                "Mattilaisenkatu 1",
                43,
                50
        );
        Asiakas asiakas2 = new Asiakas(
                "Taatto Tötterstön",
                "Hakkaraisentie 666",
                36,
                43
        );

        // Kopioidaan toisen asiakkaan tiedot kolmanteen
        Asiakas asiakas3 = asiakas2.copy();

        // Tutkitaan yhtäsuuruutta
        System.out.println(
                "Ovatko asiakas1 ja asiakas2 samoja? " + asiakas1.equals(asiakas2) +
                "\nOvatko asiakas1 ja asiakas3 samoja? " + asiakas1.equals(asiakas3) +
                "\nOvatko asiakas2 ja asiakas3 samoja? " + asiakas2.equals(asiakas3)
        );

        // Tulostetaan kaikkien olioiden tiedot
        System.out.println("\n" + asiakas1);
        System.out.println("\n" + asiakas2);
        System.out.println("\n" + asiakas3);
    }
}