import javax.swing.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!\n");
        System.out.println("Anna suorakulmion mitat kokonaislukuna:\n");
        Scanner input = new Scanner(System.in);
        int input1 = input.nextInt();
        int input2 = input.nextInt();
        Laskuri olioLaskuri = new Laskuri(input1,input2);

        System.out.println(olioLaskuri.pintaAla());
    }
}