package test.viikko8;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class tehtava6 {

    public static void main(String [] args) {

        // Luodaan lista ValintaLajittelun käyttöön
        Random arpa = new Random();
        final int N = 7000000;
        int [] listaOpe = new int [N];
        for (int i = 0; i < listaOpe.length; i++)
            listaOpe[i] = arpa.nextInt(10000000);

        // Kopioidaan sama lista oman lajittelualgoritmin käyttöön
        int [] listaOma = new int [N];
        System.arraycopy(listaOpe, 0, listaOma, 0, listaOpe.length);

        // Mitataan ja ajetaan ValintaLajittelu
        long alkuaikaOpe = System.currentTimeMillis();
        ValintaLajittelu.valintaLajittelu(listaOpe);
        long loppuaikaOpe = System.currentTimeMillis();

        // Mitataan ja ajetaan oma lajittelu
        long alkuaikaOma = System.currentTimeMillis();
        lajittelija(listaOma);
        long loppuaikaOma = System.currentTimeMillis();

        // Tulostetaan oman lajittelun tulokset näkyviin
        //int tulostinLaskuri = 0;
        //for (int luku : listaOma) {
        //    System.out.println("Oman lajittelun luku indeksillä " + tulostinLaskuri++ + " on " + luku);
        //}

        // Tulostetaan aikavertailun tulokset
        System.out.println("\nValintaLajittelun nopeus oli " + (loppuaikaOpe-alkuaikaOpe) + " millisekuntia");
        System.out.println("Oman lajittelun nopeus oli " + (loppuaikaOma-alkuaikaOma) + " millisekuntia");
    }

    /**
     * Metodi perustaa haarautumispoolin ja käynnistää lajittelualgoritmin ensimmäisen iteraation.
     * @param lista on muotoa int[]
     */
    private static void lajittelija(int[] lista) {
        ForkJoinPool pooli = new ForkJoinPool();
        pooli.invoke(new LajitteluTehtava(lista));
    }

    /**
     * Lajittelualgoritmin ydin, joka haarauttaa itsensä, jos sen saaman listan pituus on suurempi kuin 500.
     */
    private static class LajitteluTehtava extends RecursiveAction {
        private final static int RAJA = 500;
        private int[] lista;

        /**
         * Constructor
         * @param lista
         */
        public LajitteluTehtava(int[] lista) {
            this.lista = lista;
        }

        /**
         * Kun tämä olio syötetään InvokeAll-metodille, niin tämä compute() ajetaan.
         */
        @Override
        public void compute() {
            if (lista.length < RAJA) {
                Arrays.sort(lista);
            }
            else {
                // valmistellaan ensimmäinen puolisko
                int[] ekaPuoli = new int[lista.length / 2];
                System.arraycopy(lista, 0, ekaPuoli, 0, lista.length / 2);

                // valmistellaan toinen puolisto
                int toisenPuolenPituus = lista.length - lista.length / 2;
                int [] toinenPuoli = new int[toisenPuolenPituus];
                System.arraycopy(lista, lista.length / 2, toinenPuoli, 0, toisenPuolenPituus);

                // Annetaan puoliskojen lajittelu uusille säikeille
                invokeAll(
                        new LajitteluTehtava(ekaPuoli),
                        new LajitteluTehtava(toinenPuoli)
                );

                // yhdistetään ekapuoli ja toinenpuoli
                ValintaLajittelu.yhdista(ekaPuoli, toinenPuoli, lista);
            }
        }
    }
}



