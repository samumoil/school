package test.viikko8;

public class tehtava2_yield {
    private final static String lause1 = new String("Ensimmäinen on ensimmäinen!");
    private final static String lause2 = new String("Toinen jää kotiin...");
    private final static String lause3 = new String("Kolmas menee syömään.");


    static class Tulostaja implements Runnable {
        private String tulostettavaTeksti;
        public Tulostaja(String teksti) {
            this.tulostettavaTeksti = teksti;
        }
        @Override
        public void run(){
            int laskuri = 0;
            while (laskuri < 100) {
                laskuri++;
                System.out.println(tulostettavaTeksti + laskuri);
                Thread.yield();
            }
        }
    }


    public static void main(String[] args) {
        Thread saie1 = new Thread(new Tulostaja(lause1));
        Thread saie2 = new Thread(new Tulostaja(lause2));
        Thread saie3 = new Thread(new Tulostaja(lause3));

        saie1.start();
        saie2.start();
        saie3.start();
    }
}


