// ########## i-kohta ##########
public class Main {
    public static void main(String[] args) {
        // Testataan oletusalustaja
        SaaAsema oletusOlio = new SaaAsema();
        System.out.println("\noletusOlio" + oletusOlio);

        // Testataan parametroitava alustaja
        SaaAsema asemaSI = new SaaAsema(12.3, 1.034);
        System.out.println("\nasemaSI" + asemaSI);

        // Testataan fahrenheit + PSI alustaja/metodi
        SaaAsema asemaFahrPSI = SaaAsema.luoSaaAsema(33, 15);
        System.out.println("\nasemaFahrPSI" + asemaFahrPSI);

        // Testataan set- ja get-metodit SI-järjestelmän muuttujille
        oletusOlio.setLampotila(10);
        oletusOlio.setPaine(1.5);
        System.out.println("\nTämän pitäisi antaa 10: " + oletusOlio.getLampotila());
        System.out.println("Tämän pitäisi antaa 1.5: " + oletusOlio.getPaine());

        // Testataan set- ja get-metodit höpö-järjestelmän muuttujille
        oletusOlio.setFahrenheit(40);
        oletusOlio.setPSI(20);
        System.out.println("\nTämän pitäisi antaa 40: " + oletusOlio.getFahrenheit());
        System.out.println("Tämän pitäisi antaa 20: " + oletusOlio.getPSI());
    }
}