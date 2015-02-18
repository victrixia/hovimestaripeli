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

    public Peli() {
        this.kierros = new Kierros(this);
    }

    public void siirryEteenpain() {
        kierros.siirrySeuraavaanRuokalajiin();
        if (kierros.getVaihe() == 4) {
            paatos();
        }
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

    private void paatos() {
        // joo tee tähän yhteenveto yhdestä kierroksesta ja käliin mahdollisuus pelata uusi kierros
    }

    public Kierros getKierros() {
        return this.kierros;
    }
    
    public void uusiKierros(){
        this.kierros = new Kierros(this);
    }

}
