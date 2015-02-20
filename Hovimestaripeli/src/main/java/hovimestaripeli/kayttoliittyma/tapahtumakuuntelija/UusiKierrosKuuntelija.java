package hovimestaripeli.kayttoliittyma.tapahtumakuuntelija;

import hovimestaripeli.kayttoliittyma.GraafinenKali;
import hovimestaripeli.kayttoliittyma.Pelitila;
import hovimestaripeli.logiikka.Kierros;
import hovimestaripeli.logiikka.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class UusiKierrosKuuntelija implements ActionListener {

    private Peli peli;
    private GraafinenKali gk;

    public UusiKierrosKuuntelija(GraafinenKali gk) {
        this.gk = gk;
        this.peli = gk.getPeli();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.uusiKierros();
        gk.paivitaPaneeli(new Pelitila(gk));
    }
}
