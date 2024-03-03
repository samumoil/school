package test.viikko8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class tehtava3 {
    private final static String lause = new String("Tulostettava lause.");
    private static Tulostaja tulostaja = new Tulostaja();


    public static class Tulostaja {
        public void tulosta(String teksti) {
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
        @Override
        public void run() {
            int laskuri = 0;
            while (laskuri < 10) {
                laskuri++;
                tulostaja.tulosta(tulostettavaTeksti + " " + saikeenNro + " " + laskuri);
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        int i = 0;
        while (i < 100) {
            i++;
            executor.execute(new Juoksija(lause, i));
        }

        executor.shutdown();
    }
}
