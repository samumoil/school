package test.viikko8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class tehtava4 {
    private final static String lause = new String("Tulostettava lause.");
    private static Tulostaja tulostaja = new Tulostaja();


    public static class Tulostaja {
        public synchronized void tulosta(String teksti) {
        //public void tulosta(String teksti) {
            System.out.println(teksti);
        }
    }

    public static class Juoksija implements Runnable {
        String tulostettavaTeksti;
        int saikeenNro;
        public Juoksija(String teksti, int saikeenNro){
            this.tulostettavaTeksti = teksti;
            this.saikeenNro = saikeenNro;
        }
        /*
        @Override
        public void run() {
            int laskuri = 0;
            while (laskuri < 10) {
                try {
                    Thread.sleep(50);
                    laskuri++;
                    tulostaja.tulosta(tulostettavaTeksti + " " + saikeenNro + " " + laskuri);
                }
                catch (InterruptedException ex) {}
            }
        }
        */
        @Override
        public void run() {
            int laskuri = 0;
            while (laskuri < 10) {
                laskuri++;
                tulostaja.tulosta(tulostettavaTeksti + " " + saikeenNro + " " + laskuri);
                //Thread.yield();
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);
        //ExecutorService executor = Executors.newCachedThreadPool();

        int i = 0;
        while (i < 100) {
            i++;
            executor.execute(new Juoksija(lause, i));
        }

        executor.shutdown();
    }
}
