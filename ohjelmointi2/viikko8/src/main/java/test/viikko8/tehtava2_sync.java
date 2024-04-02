package test.viikko8;

import java.util.SplittableRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class tehtava2_sync {
    private final static String lause1 = new String("Ensimmäinen on ensimmäinen!");
    private final static String lause2 = new String("Toinen jää kotiin...");
    private final static String lause3 = new String("Kolmas menee syömään.");
    private static Tulostaja tulostaja = new Tulostaja();


    public static class Tulostaja {
        public synchronized void tulosta(String teksti) {
            System.out.println(teksti);
        }
    }
    public static class Juoksija implements Runnable {
        String tulostettavaTeksti;
        public Juoksija(String teksti){
            this.tulostettavaTeksti = teksti;
        }
        @Override
        public void run() {
            int laskuri = 0;
            while (laskuri < 100) {
                laskuri++;
                tulostaja.tulosta(tulostettavaTeksti + laskuri);
            }
        }
    }
    public static void main(String[] args) {

        Thread saie1 = new Thread(new Juoksija(lause1));
        Thread saie2 = new Thread(new Juoksija(lause2));
        Thread saie3 = new Thread(new Juoksija(lause3));

        saie1.start();
        saie2.start();
        saie3.start();
    }
}
