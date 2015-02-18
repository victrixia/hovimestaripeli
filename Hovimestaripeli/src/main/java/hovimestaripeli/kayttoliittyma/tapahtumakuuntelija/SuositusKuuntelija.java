package hovimestaripeli.kayttoliittyma.tapahtumakuuntelija;

import hovimestaripeli.kayttoliittyma.GraafinenKali;
import hovimestaripeli.kayttoliittyma.Pelivalikko;
import hovimestaripeli.logiikka.Peli;
import hovimestaripeli.logiikka.asiakas.Asiakas;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class SuositusKuuntelija implements ActionListener {

    private Peli peli;
    private GraafinenKali gk;
    private Asiakas asiakas;
    private ButtonGroup bg;
    private ArrayList<Viini> viinit;

    public SuositusKuuntelija(GraafinenKali gk, ButtonGroup bg, ArrayList<Viini> viinit) {
        this.gk = gk;
        this.peli = gk.getPeli();
        this.asiakas = gk.getPeli().getAsiakas();
        this.bg = bg;
        this.viinit = viinit;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int numero = Integer.parseInt(bg.getSelection().getActionCommand());
        Viini valinta = viinit.get(numero);

//        System.out.println("valittiin viini:" + valinta);
            // jatka tästä: anna asiakkaalle reagoitavaksi valinta ja välitä reaktio eteenpäin kälille
    
        asiakas.reagoi(valinta, peli.getRuokalaji());
        peli.siirryEteenpain();
        gk.paivitaPaneeli(new Pelivalikko(gk));
    }

}
