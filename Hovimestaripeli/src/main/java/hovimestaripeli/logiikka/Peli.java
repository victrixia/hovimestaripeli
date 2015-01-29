package hovimestaripeli.logiikka;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.*;
import hovimestaripeli.varasto.TarjottavienValiaikaisvarasto;
import java.util.*;

/**
 * "Hot potato, office drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class Peli {

    private Asiakas asiakas;
    private Hovimestari hovimestari;
    private Tekstikali kali;
    public TarjottavienValiaikaisvarasto t;

    public Peli(Tekstikali kali) {
        
        if (kali == null){
        
            throw new Error ("käyttöliittymää ei ole alustettu");
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

    public void kierros(int kierros) {

        Ruokalaji rl = new Ruokalaji();
        ArrayList<Viini> v = arvoViinit();

        int a = tarjoile(rl,v);
        valitaReaktio(asiakas, v.get(a), rl);

    }

    public void lopetus() {
        kali.lopetus();
    }

    public void setHovimestari(Hovimestari hm) {

        this.hovimestari = hm;
    }

    public int tarjoile(Ruokalaji laji, ArrayList<Viini> v) {

        return kali.tarjoile(laji, v);

    }

    public void pelaa() {

        aloita();
        for (int i = 0; i < 3; i++) {
            kierros(i);

        }

        lopetus();
    }

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

    private void valitaReaktio(Asiakas asiakas, Viini viini, Ruokalaji rl) {
        
        asiakas.reagoi(viini, rl);
        hovimestari.muutaTippia(asiakas.annaTippiä(hovimestari.getTippi()));
        kali.asiakkaanReaktio(asiakas, hovimestari);

    }

 

}
