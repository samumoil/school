public class Main {
    public static void main(String[] args) {
        Tili uusiTili = new Tili(1122, 20000, 4.5);
        uusiTili.nosta(2500);
        uusiTili.talleta(3000);
        System.out.println(uusiTili.getSaldo());
        System.out.println(uusiTili.getKuukausiKorko());
        System.out.println(uusiTili.getLuontiPaiva());
    }
}