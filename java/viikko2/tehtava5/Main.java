public class Main {
    public static void main(String[] args) {
        Osake nok = new Osake("NOK", "Nokia OYJ");
        nok.setEdellinenHinta(34.5);
        nok.setNykyinenHinta(34.35);

        System.out.println(nok.getSymboli());
        System.out.println(nok.getNimi());
        System.out.println(nok.getEdellinenHinta());
        System.out.println(nok.getNykyinenHinta());
        System.out.println(nok.getMuutosProsentti() + " %");
    }
}