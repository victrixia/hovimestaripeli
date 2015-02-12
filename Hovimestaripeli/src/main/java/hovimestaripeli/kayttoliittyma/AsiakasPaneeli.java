package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.Peli;
import hovimestaripeli.logiikka.asiakas.Asiakas;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
class AsiakasPaneeli extends JPanel {

    Peli peli;
    Asiakas asiakas;
    GraafinenKali gk;

    public AsiakasPaneeli(GraafinenKali gk) {

        super();
        this.gk = gk;
        this.asiakas = gk.getPeli().getAsiakas();
        this.peli = gk.getPeli();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        luoKomponentit();

    }

    private void luoKomponentit() {

        add(new JLabel("Asiakkaaksesi saapuu " + asiakas));

        //Tähän tulee asiakkaaseen liittyvä kuva
      

    }


}
