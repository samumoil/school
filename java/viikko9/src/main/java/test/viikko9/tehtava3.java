package test.viikko9;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class tehtava3 {
    public static void main(String[] args) {

        // Määritellään kaupungit-apulista.
        String[] kaupungit = {"Helsinki", "Espoo", "Tampere", "Vantaa", "Oulu"};

        // Luodaan 5:n pituinen ArrayList<String> ja lisätään edellinen lista.
        ArrayList<String> kaupunkiLista = new ArrayList<>(5);
        kaupunkiLista.addAll(List.of(kaupungit));

        // Montako nimeä listalla on? Onko Helsinki listalla?
        System.out.println("Listalla on " + kaupunkiLista.size() + " kaupunkia.");
        System.out.println("Onko Helsinki listalla? " + kaupunkiLista.contains("Helsinki"));

        // Tulostetaan lista. Harjoitellaan iteraattorin käyttöä.
        ListIterator<String> iteraattori = kaupunkiLista.listIterator();
        while (iteraattori.hasNext())
            System.out.print(iteraattori.next() + " ");
    }
}