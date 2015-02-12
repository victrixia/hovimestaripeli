package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.Peli;
import hovimestaripeli.logiikka.asiakas.Asiakas;
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
public class Pelivalikko extends JPanel {

    GraafinenKali gk;
    Peli peli;
    Asiakas asiakas;
    
    public Pelivalikko(GraafinenKali gk) {
        super();
        this.gk = gk;
        this.peli = gk.getPeli();
        this.asiakas = gk.getPeli().getAsiakas();
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        luoKomponentit();

    }

    private void luoKomponentit() {
        add(suosituksenTulos());
        add(new JLabel("Alkuruuaksi on x. Minkä viinin valitset tarjottavaksi?"));
        add(viinivalinta());
    }

    private JPanel viinivalinta() {
        JPanel valintalaatikko = new JPanel();
        valintalaatikko.setLayout(new BoxLayout(valintalaatikko, BoxLayout.Y_AXIS));
        JRadioButton eka = new JRadioButton("eka vaihtoehto");
        JRadioButton toka = new JRadioButton("toka vaihtoehto");
        JRadioButton kolmas = new JRadioButton("kolmas vaihtoehto");

        ButtonGroup ryhma = new ButtonGroup();
        ryhma.add(eka);
        ryhma.add(toka);
        ryhma.add(kolmas);
        valintalaatikko.add(eka);
        valintalaatikko.add(toka);
        valintalaatikko.add(kolmas);
        
        JButton suositus = new JButton("Suosittele!");
        suositus.addActionListener(null);

        valintalaatikko.add(suositus);

        return valintalaatikko;
    }

    private JPanel suosituksenTulos() {
        JPanel tulos = new JPanel();
        tulos.add(new JLabel("Asiakkaan tyytyväisyys tällä hetkellä " + asiakas.getTyytyvaisyys()));
        tulos.add(new JLabel("Tippisi kierroksen jälkeen: " + peli.getHovimestari().getTippi()));
        return tulos;

    }
}
