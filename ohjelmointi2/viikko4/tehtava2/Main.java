// ########## d-kohta ##########
public class Main {
        public static void main(String [] args) {
                Henkilo olio1 = new Henkilo("Pentti");
                System.out.println(olio1.getNimi());
                olio1.setNimi("Matti");
                System.out.println(olio1.getNimi());
        }
}
