
public class Henkilo implements Niminen{
    private String nimi;


    @Override
    public void setNimi(String n) {
        this.nimi=n;
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    public static void main(String[] args) {
        Henkilo henk = new Henkilo();
        henk.setNimi("Jorma");
        System.out.println(henk.getNimi());
    }
}
