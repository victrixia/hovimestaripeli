package hovimestaripeli.logiikka;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.*;
import hovimestaripeli.varasto.TarjottavienValiaikaisvarasto;
import java.util.*;

/**
 * Luokka kokoaa kaiken pelilogiikan yhteen ja välittää kutsut eri luokkien
 * välillä. Käyttöliittymä tuntee suoraan vain yhden tämän luokan olion, kaikki muu 
 * tapahtuu tämän kautta.
 *
 * @author Anna Maria Parkkinen
 */
public class Peli {

    private Asiakas asiakas;
    private Hovimestari hovimestari;
    public TarjottavienValiaikaisvarasto t;

 

    public Peli() {      
        this.t = new TarjottavienValiaikaisvarasto();
    }


    /**
     * Kutsu tätä metodia jokaiselle uudelle kierrokselle.
     * 
    *Paitsi että!!! Tämä on pakko ulkoistaa omaksi luokakseen, jotta kommunikointi graafisen käyttöliittymän kanssa onnistuu.
     *
     * @param kierros
     */
    public void kierros(int kierros) {
        Asiakas uusiAsiakas = new Asiakas("Assi Asiakas", 100, new Maku(), 1);
        setAsiakas(uusiAsiakas);
        Ruokalaji rl = new Ruokalaji();
        ArrayList<Viini> v = arvoViinit();
       
    }
    
    /**
     * kutsuu valitaReaktion pelaajan valinnan mukaan.
     * 
     * @param viinit
     * @param rl
     * @param valinta 
     */
    
    public void tarjoile(ArrayList<Viini> viinit, Ruokalaji rl, int valinta){
         valitaReaktio(viinit.get(valinta), rl);
    }


    public void setHovimestari(Hovimestari hm) {

        this.hovimestari = hm;
    }

    /**
     * Metodi pyöräyttää koko pelin läpi yhden asiakkaan osalta. Muokataan
     * myöhemmin niin, että asiakkaita voi olla useampia.
     */
    public void pelaa() {

        for (int i = 0; i < 3; i++) {
            kierros(i);

        }
    }

    /**
     * Metodi arpoo viinien listalta kolme satunnaista viiniä, joista pelaaja
     * valitsee asiakkaalle ja hänen ruokalajilleen parhaiten sopivan.
     *
     * @return kolmen viinin lista;
     */
    public ArrayList<Viini> arvoViinit() {
        ArrayList<Viini> viinit = new ArrayList<>();

        Random r = new Random();

        while (viinit.size() < 3) {
            Viini v = t.getViinit().get(r.nextInt(t.getViinit().size() - 1));

            if (!viinit.contains(v)) {
                viinit.add(v);
            }

        }

        return viinit;

    }

    public Hovimestari getHovimestari() {
        return hovimestari;
    }

    public void setAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public Asiakas getAsiakas() {
        return asiakas;
    }

    /**
     * Metodi kutsuu asiakkaalle reaktiota tarjottuihin ruokalajiin ja viiniin.
     * Reaktion perusteella muutetaan hovimestarin tippiä.
     *
     * @param viini
     * @param rl
     */
    public void valitaReaktio(Viini viini, Ruokalaji rl) {

        asiakas.reagoi(viini, rl);
        hovimestari.muutaTippia(asiakas.annaTippiä(hovimestari.getTippi()));

    }

}
