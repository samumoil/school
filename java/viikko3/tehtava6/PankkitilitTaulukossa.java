public class PankkitilitTaulukossa {
    public static void main(String[] args) {

// ########## a-kohta ##########
        Pankkitili [] taulukko = new Pankkitili[10];
// ########## b-kohta ##########
        Pankkitili tili1 = new Pankkitili(123456, 123.456, 3.5);
        Pankkitili tili2 = new Pankkitili(234567, 234.567, 3.5);
        Pankkitili tili3 = new Pankkitili(345678, 345.678, 3.5);
        taulukko[1] = tili1;
        taulukko[2] = tili2;
        taulukko[3] = tili3;

// ########## c-kohta ##########
// Asetetaan kaikkiin saldoksi sata.
        taulukko[1].setSaldo(100);
        taulukko[2].setSaldo(100);
        taulukko[3].setSaldo(100);
// Nostetaan vaiheleva määrä rahaa kaikilta tileiltä.
        taulukko[1].nosta(10);
        taulukko[2].nosta(20);
        taulukko[3].nosta(30);
// Lisätään rahaa kaikille tileille.
        taulukko[1].talleta(60);
        taulukko[2].talleta(50);
        taulukko[3].talleta(40);
// Tulostetaan lopuksi saldot.
        System.out.println("Tilin 1 saldo on: " + taulukko[1].getSaldo());
        System.out.println("Tilin 2 saldo on: " + taulukko[2].getSaldo());
        System.out.println("Tilin 3 saldo on: " + taulukko[3].getSaldo());
    }
}
