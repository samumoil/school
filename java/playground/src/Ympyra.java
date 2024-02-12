
import java.io.*;

// Lisätään Serializable joka suorittaa A kohdan
public class Ympyra implements Serializable {
    private double sade;
    public Ympyra(double r) {
        sade = r;
    }
    public double getAla() {
        return Math.PI * sade * sade;
    }
    public double getSade() {
        return sade;
    }
    public String toString() {
        return "Ympyrän säde on " + sade + " ja pinta-ala on " + getAla();
    }
    public boolean equals(Ympyra y) {
        if (this.sade == y.getSade())
            return true;
        else
            return false;
    }
    public boolean suurempiKuin(Ympyra y) {
        if (this.getAla() > y.getAla())
            return true;
        else
            return false;
    }
    // Muokataan testipääohjelmaa
    public static void main(String[] args) {
        // Luodaan 10 oliota ja sijoitetaan ne taulukkoon
        Ympyra[] ympyrat = new Ympyra[10];
        for (int i=0; i< ympyrat.length;i++){
            ympyrat[i]= new Ympyra(0.5*i);
        }
        // B kohdan tiedostonkirjoitus
        try (FileOutputStream fout = new FileOutputStream("Ympyrat.dat");
             ObjectOutputStream out = new ObjectOutputStream(fout)) {
            for (Ympyra ympyra: ympyrat) {
                out.writeObject(ympyra);
            }
            out.close();
            fout.close();
            System.out.println("Ympyrät kirjoitettu");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // C kohta
        Ympyra[] luetutYmpyrät = new Ympyra[10];
        try (FileInputStream fis = new FileInputStream("Ympyrat.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object o = null;
            int i = 0;
            while ((o = ois.readObject()) != null)   {
                if (o instanceof Ympyra)
                    luetutYmpyrät[i] = (Ympyra) o;
                i++;
            }
            // D kohdan Virhetilanteiden Catchit
        } catch (IOException e) {
            //Käsittele error
        } catch (ClassNotFoundException e) {
            //Käsittele error
        }
        for (Ympyra ympyra : luetutYmpyrät){
            System.out.println(ympyra);
        }
    }
}

