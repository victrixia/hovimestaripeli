package hovimestaripeli.kayttoliittyma;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
class Pelitila extends JPanel {

    GraafinenKali gk;

    public Pelitila(GraafinenKali gk) {

        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.gk = gk;
        luoKomponentit();

    }

    private void luoKomponentit() {

        this.add(new JLabel("Tervetuloa peliin!"));
        this.add(new AsiakasPaneeli());
        this.add(new ValikkoPaneeli());
    }

}
