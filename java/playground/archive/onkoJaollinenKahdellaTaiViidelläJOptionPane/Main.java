import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        String inputti = JOptionPane.showInputDialog("Anna kokonaisluku niin selvitämme, onko se jaollinen kahdella tai viidellä:");
        System.out.println(inputti);

        int luku = Integer.parseInt(inputti);

        if (luku%2 == 0 && luku%5 == 0){
            JOptionPane.showMessageDialog(null, "Antamasi luku on " +
                    luku + " ja se on jaollinen sekä kahdella että viidellä.");
        } else if (luku%5 == 0) {
            JOptionPane.showMessageDialog(null, "Antamasi luku on " +
                    luku + " ja se on jaollinen viidellä.");
        } else if (luku%2 == 0) {
            JOptionPane.showMessageDialog(null, "Antamasi luku on " +
                    luku + " ja se on jaollinen kahdella.");
        } else {
            JOptionPane.showMessageDialog(null, "Antamasi luku on " +
                    luku + " eikä se ole jaollinen kahdella tai viidellä.");

        }
    }
}