package hovimestaripeli.logiikka;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.*;
import hovimestaripeli.varasto.TarjottavienValiaikaisvarasto;
import java.util.*;

/**
 * Luokka kokoaa kaiken pelilogiikan yhteen ja välittää kutsut eri luokkien
 * välillä. Käyttöliittymä tuntee suoraan vain yhden tämän luokan olion, kaikki
 * muu tapahtuu tämän kautta.
 *
 * @author Anna Maria Parkkinen
 */
public class Peli {

    private Hovimestari hovimestari;
    private Kierros kierros;
    private int kierrosluku;

    public Peli() {
        this.kierros = new Kierros(this);
        this.kierrosluku = 1;
    }

    public void siirryEteenpain() {
        kierros.siirrySeuraavaanRuokalajiin();
        
    }

 
    public void setHovimestari(Hovimestari hm) {            // tää pysyy tässä koska hovimestari on sama koko pelin ajan

        this.hovimestari = hm;
    }

    public Hovimestari getHovimestari() {
        return hovimestari;
    }

    

    public Asiakas getAsiakas() {
        return kierros.getAsiakas();
    }

    public Ruokalaji getRuokalaji() {
        return kierros.getRuokalaji();
    }

    public Kierros getKierros() {
        return this.kierros;
    }
    
    /**
     * Peli jatkuu uudella asiakkaalla ja uudella aterialla. Asiakkaan level määrittyy 
     * pelattujen kierrosten mukaan.
     */
    
    public void uusiKierros(){
        this.kierros = new Kierros(this);
        this.kierrosluku++;         // Kun asiakkaita on enemmän, tämä määrittelee seuraavan asiakkaan Levelin
    }
    
    public int getKierrosluku(){
        return this.kierrosluku;
    }

}
