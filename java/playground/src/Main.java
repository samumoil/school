// ########## d-kohta ##########
public class Main{
        public static void main (String [] args) {
// ########## d i-kohta ##########
                Tili tili1 = new Tili(123, 123.12);
                Tili tili2 = new Tili(234, 234.23);
                Tili tili3 = new Tili(tili1);

// ########## d ii-kohta ##########
                System.out.println(tili1);
                System.out.println(tili2);
                System.out.println(tili3);

// ########## d iii-kohta ##########
                System.out.println("Ovatko tilit 1 ja 2 samoja? " + tili1.equals(tili2));
                System.out.println("Ovatko tilit 1 ja 3 samoja? " + tili1.equals(tili3));
                System.out.println("Ovatko tilit 2 ja 3 samoja? " + tili2.equals(tili3));

// ########## d iv-kohta ##########
// Jos tileillä on saman verran rahaa, jää voimaan se, joka oli "suurin" ensimmäisenä.
                Tili suurin = tili1;
                if (tili2.suurempiKuin(suurin)){  suurin = tili2;  }
                if (tili3.suurempiKuin(suurin)){  suurin = tili3;  }
                System.out.println("Eniten rahaa on tilillä: " + suurin);
        }
}

