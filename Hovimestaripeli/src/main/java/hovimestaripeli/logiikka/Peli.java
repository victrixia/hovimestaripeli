package hovimestaripeli.logiikka;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.*;
import hovimestaripeli.varasto.TarjottavienValiaikaisvarasto;
import java.util.*;

/**
 * Luokka kokoaa kaiken pelilogiikan yhteen ja välittää kutsut eri luokkien
 * välillä. Lisäksi se kommunikoi käyttöliittymän kanssa.
 *
 * @author Anna Maria Parkkinen
 */
public class Peli {

    private Asiakas asiakas;
    private Hovimestari hovimestari;
    private Tekstikali kali;
    public TarjottavienValiaikaisvarasto t;

    public Peli(Tekstikali kali) {

        if (kali == null) {

            throw new Error("käyttöliittymää ei ole alustettu");
        }

        this.kali = kali;
        this.t = new TarjottavienValiaikaisvarasto();

    }

    public Peli() {                      // käyttöliittymätön testiversio
        this.t = new TarjottavienValiaikaisvarasto();
    }

    public void aloita() {

        kali.aloitusmenu();

    }

    /**
     * Metodi kutsuu lopullisessa muodossaan ruokalajin ja viinit arpovia
     * metodeja, ja välittää ne tarjoile()-metodille. Pelaaja päättää mikä viini
     * tarjoillaan, jonka jälkeen välitetään asiakkaan reaktio pelaajalle.
     *
     * @param kierros
     */
    public void kierros(int kierros) {

        Ruokalaji rl = new Ruokalaji();
        ArrayList<Viini> v = arvoViinit();

        int a = tarjoile(rl, v);
        valitaReaktio(v.get(a), rl);

    }

    public void lopetus() {
        kali.lopetus();
    }

    public void setHovimestari(Hovimestari hm) {

        this.hovimestari = hm;
    }

    /**
     * kutsuu käyttöliittymää. Tämä voisi olla ehkä private.
     *
     * @param laji
     * @param v
     * @return
     */
    public int tarjoile(Ruokalaji laji, ArrayList<Viini> v) {

        return kali.tarjoile(laji, v);

    }

    /**
     * Metodi pyöräyttää koko pelin läpi yhden asiakkaan osalta. Muokataan
     * myöhemmin niin, että asiakkaita voi olla useampia.
     */
    public void pelaa() {

        aloita();
        for (int i = 0; i < 3; i++) {
            kierros(i);

        }

        lopetus();
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
     * @param asiakas
     * @param viini
     * @param rl
     */
    public void valitaReaktio(Viini viini, Ruokalaji rl) {

        asiakas.reagoi(viini, rl);
        hovimestari.muutaTippia(asiakas.annaTippiä(hovimestari.getTippi()));

        if (!(kali == null)) {
            kali.asiakkaanReaktio(asiakas, hovimestari);
        }

    }

}
