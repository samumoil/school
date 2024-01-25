import java.util.Random;

public class LuoMalliTilit {
    /**
     * This static method returns an array which contains lkm amount of bank accounts.
     * Account ID is 1000 plus index number of said account, ie. 1000, 1001, 1002 etc.
     * Each account is created with a random balance of 1000-9999€ and interest of 3.5%.
     *
     * @param lkm   How many bank accounts are created.
     * @return
     */
    public static Pankkitili[] luoTilit(int lkm){
        Pankkitili [] palautettavaLista = new Pankkitili[lkm];
        Random arpa = new Random();
        int minimi = 1000, maksimi = 9999;
        for (int i = 0; i < lkm; i++){
            palautettavaLista[i] = new Pankkitili(
                    1001+i,
                    (arpa.nextInt(maksimi-minimi + 1) + minimi),
                    /* java.util.Random gives a random number between 0 and "bound". In this case "bound" is 8999 (+1).
                    After randomization we add the minimum value to the random value given by this method.*/
                    3.5);
        }
        System.out.println("Tulostetaan luotujen tilien tiedot: \n");
        for (int i = 0; i < palautettavaLista.length; i++){
            System.out.println("TILI "+ (i+1) + palautettavaLista[i] + "\n");
        }
        return palautettavaLista;
    }
}
