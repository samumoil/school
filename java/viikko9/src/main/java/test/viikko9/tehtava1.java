package test.viikko9;

public class tehtava1 {
    public static void main(String[] args ) {
        Double[] saldot = {940.42, 340.11, 42.00, 2056.44, 1593.47};
        String[] kaupungit = {"Helsinki", "Espoo", "Tampere", "Vantaa", "Oulu"};

        tehtava1.<Double>print(saldot);
        tehtava1.<String>print(kaupungit);
    }

    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
        System.out.println();
    }
}

