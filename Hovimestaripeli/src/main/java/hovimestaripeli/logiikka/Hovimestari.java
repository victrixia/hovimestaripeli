package hovimestaripeli.logiikka;

/**
 * Hovimestari on pelaajan hahmo. Pelaajan tavoite on kerätä mahdollisimman korkea tippi.
 *
 * @author amparkki
 */
public class Hovimestari {

    private String nimi;
    private int tippi;

    public Hovimestari(String nimi) {
        this.nimi = nimi;
        tippi = 0;
    }

    public Hovimestari() {
        this("Jeeves");

    }

    public String getNimi() {
        return nimi;
    }

    public int getTippi() {
        return tippi;
    }
    
    /**
     * Kasvattaa tai vähentää hovimestarin saamaa tippiä. 
     * 
     * @param t 
     */

    public void muutaTippia(int t) {

        if (tippi + t < 0) {             // koska tippi voi myös vähentyä illan aikana, tarkistetaan ettei tippi sentään tipu alle nollan.
            tippi = 0;
        } else {

            tippi += t;
        }

    }

}
