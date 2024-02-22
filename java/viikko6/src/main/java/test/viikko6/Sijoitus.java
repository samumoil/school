package test.viikko6;

import static java.lang.Double.parseDouble;

public class Sijoitus
{
    private double vuosiKorko;
    private int vuosienMaara;
    private double sijoituksenMaara;

    public Sijoitus()
    {
        this(2.5, 1, 1000);
    }

    public Sijoitus(double vuosiKorko, int vuosienMaara, double sijoituksenMaara)
    {
        this.vuosiKorko = vuosiKorko;
        this.vuosienMaara = vuosienMaara;
        this.sijoituksenMaara = sijoituksenMaara;
    }

    public double getVuosiKorko()
    {
        return this.vuosiKorko;
    }

    public void setVuosiKorko(double vuosiKorko)
    {
        this.vuosiKorko = vuosiKorko;
    }

    public int getVuosienMaara()
    {
        return this.vuosienMaara;
    }

    public void setVuosienMaara(int vuosienMaara)
    {
        this.vuosienMaara = vuosienMaara;
    }

    public double getSijoituksenMaara()
    {
        return this.sijoituksenMaara;
    }

    public void setSijoituksenMaara(double sijoituksenMaara)
    {
        this.sijoituksenMaara = sijoituksenMaara;
    }

    public double getTuottoOdotus() {
        return sijoituksenMaara * Math.pow((1+vuosiKorko/100), vuosienMaara);
    }
}