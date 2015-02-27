package hovimestaripeli.logiikka.tarjottavat;

import hovimestaripeli.logiikka.asiakas.RypaleidenVertailu;
import java.util.*;

/**
 * Pelin ydinasia. Viinintuntemus ratkaisee suurelta osin, voittaako vai
 * häviääkö pelin. Viinillä on väri (käytännössä viinityyppi: puna-, valko-,
 * kuohu-, rosee- ja jälkiruokaviini), lista rypäleistä, hinta, laatu (0-5),
 * vahvuus alkoholiprosenttina sekä valmistusmaa.
 *
 * @author amparkki
 */
public class Viini {

    private ViininVari vari;
    private String[] rypaleet;
    private int hinta;
    private int laatu;           // arvoja väliltä 0-5
    private int vahvuus;        //alkoholiprosentti
    private String maa;
    private RypaleidenVertailu vertaa = new RypaleidenVertailu();

    public Viini(ViininVari vari, String[] rypaleet, int hinta, int laatu, int vahvuus, String maa) {

        this.vari = vari;
        this.rypaleet = rypaleet;
        this.hinta = hinta;
        this.laatu = laatu;
        this.vahvuus = vahvuus;
        this.maa = maa;             // lisätään myöhemmin maan vaikutus suosikkeihin
    }

    public Viini() {
        this.vari = ViininVari.VALKO;
        this.rypaleet = new String[]{"Riesling"};
        this.hinta = 10;
        this.laatu = 4;
        this.vahvuus = 12;
        this.maa = "Saksa";

    }

    public int getHinta() {
        return hinta;
    }

    public int getLaatu() {
        return laatu;
    }

    public boolean loytyykoListalta(String[] lista) {
        return vertaa.onkoRypaleetListalla(lista, rypaleet);
    }

    public String[] getRypaleet() {
        return rypaleet;
    }
    
    

    public String getRypaleetString() {

        String r = "";

        for (int i = 0; i < rypaleet.length; i++) {
            r += rypaleet[i];
            if (i < rypaleet.length - 1) {
                r += ", ";
            }

        }

        return r;

    }

    public int getVahvuus() {
        return vahvuus;
    }

    public ViininVari getVari() {
        return vari;
    }

    @Override
    public String toString() {
        String v = "";

        if (vari == ViininVari.PUNA) {
            v = "Punaviini";
        } else if (vari == ViininVari.VALKO) {
            v = "Valkoviini";
        } else if (vari == ViininVari.KUOHU) {
            v = "Kuohuviini";
        } else if (vari == ViininVari.ROSEE) {
            v = "Roseeviini";
        } else if (vari == ViininVari.JALKIRUOKA) {
            v = "Jälkiruokaviini";
        }

        return v + ", " + maa + ". Rypäleet (ja tyyli): " + getRypaleetString() + ". Hinta: "
                + hinta + "€, Laatu: " + laatu + " tähteä, Alkoholiprosentti: " + vahvuus + ".";
    }

    /**
     *
     * Viineillä on hashCode() ja equals-metodit, jotta voidaan verrata
     * arvottaessa, onko sama viini tulossa listalle useamman kerran. Viinin
     * jokainen aspekti vaikuttaa samuuteen.
     *
     * @return
     */
    @Override
    public int hashCode() {
        return maa.length() * hinta + laatu + vahvuus;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Viini other = (Viini) obj;
        if (this.vari != other.vari) {
            return false;
        }
        if (!Arrays.deepEquals(this.rypaleet, other.rypaleet)) {
            return false;
        }
        if (this.hinta != other.hinta) {
            return false;
        }
        if (this.laatu != other.laatu) {
            return false;
        }
        if (this.vahvuus != other.vahvuus) {
            return false;
        }
        if (!Objects.equals(this.maa, other.maa)) {
            return false;
        }
        return true;
    }

}
