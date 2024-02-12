public class Main {
    public static void main(String[] args) {
        Biisi lentoon = new Biisi("Lentoon", "Tiktak", 120000);
        System.out.println(lentoon.getNimi() + ", " +
            lentoon.getEsittaja() + ", " +
            lentoon.getSpotifySoittomaara());

        Biisi sutsisatsi = new Biisi("Sutsisatsi", "Fröbelin palikat", 401022);
        System.out.println(sutsisatsi.getNimi() + ", " +
                sutsisatsi.getEsittaja() + ", " +
                sutsisatsi.getSpotifySoittomaara());

        Biisi humalahullu = new Biisi("Humalahullu", "Vilma Jää", 61963);
        System.out.println(humalahullu.getNimi() + ", " +
                humalahullu.getEsittaja() + ", " +
                humalahullu.getSpotifySoittomaara());
    }
}