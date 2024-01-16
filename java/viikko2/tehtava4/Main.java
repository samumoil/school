public class Main {
    public static void main(String[] args) {
        Suorakulmio olio1 = new Suorakulmio(4,40);
        Suorakulmio olio2 = new Suorakulmio(3.5, 35.9);
        System.out.println("4 40 " + olio1.getAla() + " " + olio1.getYmparys());
        System.out.println("3.5 35.9 " + olio2.getAla() + " " + olio2.getYmparys());
    }
}