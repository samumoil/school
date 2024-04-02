package test.viikko9;

public class tehtava2 {
    public static void main(String[] args ) {

        // Määritellään kaupungit-apulista.
        String[] kaupungit = {"Helsinki", "Espoo", "Tampere", "Vantaa", "Oulu"};

        // Luodaan pinot.
        GenericStack<String> kaupunkiPino = new GenericStack<>();
        GenericStack<String> toinenPino = new GenericStack<>();

        // Sijoitetaan kaupungit ensimmäiseen pinoon.
        for (String kaupunki : kaupungit)
            kaupunkiPino.push(kaupunki);

        // Tulostetaan kaupunkiPinon päällimmäinen kaupunki. Lisätään se toiseen pinoon ja poistetaan ensimmäisestä.
        while (!kaupunkiPino.isEmpty()) {
            System.out.println(kaupunkiPino.peek());
            toinenPino.push(kaupunkiPino.pop());
        }

        System.out.println();

        // Kokeillaan vielä, mitä toiseen pinoon tuli laitettua.
        while (!toinenPino.isEmpty()) System.out.println(toinenPino.pop());
    }
}

/**
 * Tämä on suoraan kopioitu opettajan mallista.
 * @param <E>
 */
class GenericStack<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

