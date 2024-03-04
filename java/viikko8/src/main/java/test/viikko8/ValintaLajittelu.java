package test.viikko8;

public class ValintaLajittelu {
    public static void valintaLajittelu(int [] lista) {
        if (lista.length > 1) {
            // lajitellaan ensimm�inen puolisko
            int[] ekaPuoli = new int[lista.length / 2];
            System.arraycopy(lista, 0, ekaPuoli, 0, lista.length / 2);
            valintaLajittelu(ekaPuoli);

            // lajitellaan toinen puolisto
            int toisenPuolenPituus = lista.length - lista.length / 2;
            int [] toinenPuoli = new int[toisenPuolenPituus];
            System.arraycopy(lista, lista.length / 2, toinenPuoli, 0, toisenPuolenPituus);
            valintaLajittelu(toinenPuoli);

            // yhdistetään ekapuoli ja toinenpuoli
            yhdista(ekaPuoli, toinenPuoli, lista);
        }
    }

    // yhdistetään kaksi lajiteltua listaa
    public static void yhdista(int[] lista1, int [] lista2, int [] tilap) {
        int nyk1 = 0; // listan 1 indeksi
        int nyk2 = 0; // listan 2 indeksi
        int nyk3 = 0; // listan 3 indeksi

        while (nyk1 < lista1.length && nyk2 < lista2.length) {
            if (lista1[nyk1] < lista2[nyk2])
                tilap[nyk3++] = lista1[nyk1++];
            else
                tilap[nyk3++] = lista2[nyk2++];
        }

        while (nyk1 < lista1.length)
            tilap[nyk3++] = lista1[nyk1++];

        while (nyk2 < lista2.length)
            tilap[nyk3++] = lista2[nyk2++];
    }

    // testi metodi
    public static void main(String [] args) {
        int[] lista = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        valintaLajittelu(lista);
        for (int i = 0; i < lista.length; i++)
            System.out.println(lista[i] + " ");
    }
}