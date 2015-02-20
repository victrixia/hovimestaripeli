package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.Peli;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class Pelitila extends JPanel {

    GraafinenKali gk;
    Peli peli;

    public Pelitila(GraafinenKali gk) {

        super();
        this.setLayout(new GridLayout(3,1));
        this.gk = gk;
        this.peli = gk.getPeli();
        luoKomponentit();

    }

    private void luoKomponentit() {

        this.add(new JLabel("Uusi asiakas saapuu! Oletko valmis, " + peli.getHovimestari().getNimi() + "?" ));
        this.add(new AsiakasPaneeli(gk));
        this.add(new Pelivalikko(gk));
//        this.add(new ValikkoPaneeli());
    }
  
    
    

}
