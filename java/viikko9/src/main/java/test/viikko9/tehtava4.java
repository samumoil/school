package test.viikko9;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class tehtava4 {
    public static void main(String[] args ) {
        // Luodaan kolme lisättävää lääkäriä.
        Laakari laakari1 = new Laakari();
        laakari1.setLaakarinro(1001);
        laakari1.setNimi("Matti Möttönen");
        laakari1.setOsasto("Sydänpoli");

        Laakari laakari2 = new Laakari();
        laakari2.setLaakarinro(1002);
        laakari2.setNimi("Martta Oikarinen");
        laakari2.setOsasto("Päivystys");

        Laakari laakari3 = new Laakari();
        laakari3.setLaakarinro(1003);
        laakari3.setNimi("Krista Kosonen");
        laakari3.setOsasto("Syke-osasto");

        // Luodaan lääkärilista ja isätään kolme lääkäriä listalle.
        LaakariLista lista = new LaakariLista();
        lista.lisaaLaakari(laakari1);
        lista.lisaaLaakari(laakari2);
        lista.lisaaLaakari(laakari3);

        // Tulostetaan listan sisältö.
        System.out.println(lista.toString());
    }
}


// Nämä seuraavat luokat on kopioitu suoraan mallista.


/**
 * @(#)Laakari.java
 *
 * Tämä luokka kuvaa yhden lääkärin tiedot.
 * Luokasta on viite listalla seuraavaan lääkäriin (linkitetty lista)
 * @author Marko ja muut
 * @version 1.00 2011/1/23
 */

class Laakari implements Serializable
{
    /** Muuttuja kuvaa lääkärin numeron, numerot ovat väliltä 1000-2999 */
    private int iLaakarinro;
    /** Muuttuja kuvaa lääkärin nimen, jos nimeä ei ole, on oletusarvo "Ei tiedossa" */
    private String sNimi;
    /** Muuttuja kuvaa lääkärin syntymäpäivän päiväyksen, jos syntymäpäivää ei ole, on oletusarvo 1.1.1900 */
    private Calendar cSyntymapaiva;
    /** Muuttuja kuvaa lääkärin osaston jolla hän työskentelee, jos nimeä ei ole, on oletusarvo "Ei tiedossa"  */
    private String sOsasto;
    /** Muuttuja seuraava on linkki listalla olevaan seuraavaan lääkäriin. Jos kyseessä on listan viimeinen lääkäri, viittaa muuttuja tyhjään (null-arvo) */
    private Laakari seuraava;

    // Konstruktorit

    /**
     * Tyhjä oletuskonstruktori
     * Lääkärin arvot asetetaan oletusarvoihinsa
     */
    public Laakari()
    {
        iLaakarinro = 0;
        sNimi = "";
        cSyntymapaiva = Calendar.getInstance();
        cSyntymapaiva.clear();
        cSyntymapaiva.set(0000, 0, 1);
        sOsasto = "";
    }

    /**
     * Konstruktori jossa asetetaan uuden lääkärin tiedot.
     * Tietojen asettamisessa käytetään set-metodeja.
     * @param iLaakarinro Lääkärin lääkärinumero (väliltä 1000-2999)
     * @param sNimi Lääkärin nimi
     * @param cSyntymapaiva Lääkärin syntymäpäivä
     * @param sOsasto Osasto jolla lääkäri työskentelee
     */
    public Laakari(int iLaakarinro, String sNimi, Calendar cSyntymapaiva, String sOsasto)
    {
        setLaakarinro(iLaakarinro);
        setNimi(sNimi);
        setSyntymapaiva(cSyntymapaiva);
        setOsasto(sOsasto);
    }

    // Pääsymetodit eli aksessorit (set ja get)
    public void setLaakarinro(int iLaakarinro)
    {
        if (iLaakarinro < 1000 | iLaakarinro > 2999)
            this.iLaakarinro = 0;
        else
            this.iLaakarinro = iLaakarinro;
    }
    /**
     *  Metodi asettaa lääkärin nimen.
     *  Jos parametri on tyhjä, asetetaan merkkijono "Ei tiedossa"
     *  @param sNimi Lääkärin nimi
     **/
    public void setNimi(String sNimi)
    {
        if (sNimi == null)
            this.sNimi = "Ei tiedossa";
        else
            this.sNimi = sNimi;
    }
    /**
     * Metodi asettaa parametrina tulleen Calendar -olion lääkärin syntymäpäiväksi
     * Jos parametri on tyhjä viite (null-arvo), asetetaan syntymäpäiväksi 1.1.1900
     * @param cSyntymapaiva Ilmaisee lääkärin syntymäpäivän (Calendar -olio)
     **/
    public void setSyntymapaiva(Calendar cSyntymapaiva)
    {
        if (cSyntymapaiva == null)
        {
            this.cSyntymapaiva = Calendar.getInstance();
            this.cSyntymapaiva.clear();
            this.cSyntymapaiva.set(1900, 0, 1);
        }
        else
            this.cSyntymapaiva = cSyntymapaiva;
    }

    public void setOsasto(String sOsasto)
    {
        if (sOsasto == null)
            this.sOsasto = "Ei tiedossa";
        else
            this.sOsasto = sOsasto;
    }

    // viittaus listan seuraavaan alkioon
    public void setSeuraava(Laakari seuraava)
    {
        this.seuraava = seuraava;
    }

    public int getLaakarinro()
    {
        return iLaakarinro;
    }

    /**
     * Metodi palauttaa lääkärin nimen
     * @return Lääkärin nimi (sNimi)
     **/
    public String getNimi()
    {
        return sNimi;
    }

    public Calendar getSyntymapaiva()
    {
        return cSyntymapaiva;
    }

    public String getOsasto()
    {
        return sOsasto;
    }

    // palauttaa viittauksen listan seuraavaan alkioon
    public Laakari getSeuraava()
    {
        return seuraava;
    }

    // toString()tulostaa yhden alkion tiedot
    public String toString()
    {
        String sLaakarituloste = "Lääkäri:";
        sLaakarituloste += " " + iLaakarinro;
        sLaakarituloste += " " + sNimi;
        SimpleDateFormat muunnos = new SimpleDateFormat("dd.MM.yyyy");
        sLaakarituloste += " " + muunnos.format(cSyntymapaiva.getTime());
        sLaakarituloste += " " + sOsasto;
        return sLaakarituloste;
    }
}

/**
 * @(#)LaakariLista.java
 *
 *
 * @author
 * @version 1.00 2011/1/31
 */


class LaakariLista implements Serializable
{
    // viittaus listan ensimmäiseen alkioon
    private Laakari ekaListalla;

    /** Alustaja luo tyhjän listan eli viittaus  = null
     */
    public LaakariLista()
    {
        ekaListalla = null;
    }

    /** Palauttaa kaikki listan alkiot yhtenä merkkijonona
     */
    public String toString()
    {
        String sTulostettava = "";
        Laakari seuraava = ekaListalla;
        while(seuraava != null)
        {
            sTulostettava += seuraava + "\n";
            seuraava = seuraava.getSeuraava();
        }
        return sTulostettava;
    }

    /** Lisää uuden alkion listan alkuun
     */
    public String lisaaLaakari(Laakari uusi)
    {
        // Tyhjä viite
        if(uusi == null)
            return "Tyhjä viite, lisäys epäonnistui!";

        uusi.setSeuraava(ekaListalla);
        ekaListalla = uusi;
        return "Lisäys onnistui!";
    }

    /** Etsii poistettavan alkion lääkärin numeron perusteella
     *  ja sitten päivittää linkit kohdalleen (ohittaa poistettavan)
     */
    public String poista(int iLaakariNro)
    {
        // Tyhjästä on paha nyhjästä
        if(ekaListalla == null)
            return "Poisto epäonnistui, lista on tyhjä!";

        // Poistettava ekana listalla
        if(ekaListalla.getLaakarinro() == iLaakariNro)
        {
            ekaListalla = ekaListalla.getSeuraava();
            return "Poisto onnistui";
        }

        // Poistettava on muualla
        Laakari hakuViite = ekaListalla;
        while(hakuViite.getSeuraava() != null)
        {
            if(hakuViite.getSeuraava().getLaakarinro() == iLaakariNro)
            {
                Laakari poistettava = hakuViite.getSeuraava();
                Laakari poistettavaaSeuraava = poistettava.getSeuraava();
                Laakari poistettavaaEdellinen = hakuViite;
                poistettavaaEdellinen.setSeuraava(poistettavaaSeuraava);


                //hakuViite.setSeuraava(hakuViite.getSeuraava().getSeuraava());
                return "Poisto onnistui";
            }
            hakuViite = hakuViite.getSeuraava();
        }

        return "Poisto epäonnistui";
    }

    /** Etsitään lääkäri "selaamalla" alusta listaa kunnes löytyy
     */
    public Laakari hae(int iLaakariNro)
    {
        Laakari hakuViite = ekaListalla;
        while(hakuViite != null)
        {
            if(hakuViite.getLaakarinro() == iLaakariNro)
                return hakuViite;
            hakuViite = hakuViite.getSeuraava();
        }
        return null;
    }

    /** Etsitään lääkärit "selaamalla" alusta lista läpi
     */
    public String hae(String sOsasto)
    {
        String sLaakarit = "";

        Laakari hakuViite = ekaListalla;
        while(hakuViite != null)
        {
            if(hakuViite.getOsasto().equals(sOsasto))
                sLaakarit += hakuViite;
            hakuViite = hakuViite.getSeuraava();
        }
        return sLaakarit;
    }
}