package hovimestaripeli.logiikka;

import hovimestaripeli.logiikka.asiakas.Asiakas;
import hovimestaripeli.logiikka.asiakas.Maku;
import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import hovimestaripeli.varasto.TarjottavienValiaikaisvarasto;
import java.util.ArrayList;
import java.util.Random;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class Kierros {

    private Asiakas asiakas;
    private Peli peli;
    private TarjottavienValiaikaisvarasto t;
    private int vaihe;      // katsotaan mikä ruokalaji tarjoillaan; jos 4, kierros päättyy ja arvotaan uusi asiakas.
    private Ruokalaji rl;

    public Kierros(Peli p) {
        this.t = new TarjottavienValiaikaisvarasto();
        this.asiakas = new Asiakas("Assi Asiakas", 100, new Maku(), 1);
        arvoRuokalaji();
        this.peli = p;

        this.vaihe = 1;

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

    private void arvoRuokalaji() {            //Alku- pää- vai jälkiruoka
        Random random = new Random();

        ArrayList<Ruokalaji> arvottavat = t.getAlkuruokalajit();

        if (vaihe == 2) {
            arvottavat = t.getPaaruokalajit();
        } else if (vaihe == 3) {
            arvottavat = t.getJalkiruokalajit();
        }

        Ruokalaji laji = arvottavat.get(random.nextInt(arvottavat.size()));
        rl = laji;

    }

    public void siirrySeuraavaanRuokalajiin() {
        this.vaihe++;
        arvoRuokalaji();
        if (this.vaihe > 4) {
            vaihe = 4;
        }
    }

    public int getVaihe() {
        return vaihe;
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
        peli.getHovimestari().muutaTippia(asiakas.annaTippiä(peli.getHovimestari().getTippi()));

    }

    public Asiakas getAsiakas() {
        return this.asiakas;
    }

    public Ruokalaji getRuokalaji() {
        return this.rl;
    }

}
