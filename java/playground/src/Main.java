import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        char[] kirjaimet = new char[7];
        char kirjain = 'a';
        for (int i = 0; i < 7; i++){
           kirjaimet[i] = kirjain++;
           System.out.println(kirjaimet[i]);
        }

        int a = 5;
        int b = 6;
        int suurin = a;
        suurin = b;
        System.out.println(suurin);
    }
}