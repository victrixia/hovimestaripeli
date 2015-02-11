package hovimestaripeli.kayttoliittyma;

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

    public AsiakasPaneeli() {

        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        luoKomponentit();

    }

    private void luoKomponentit() {

        add(new JLabel("Assi Asiakas"));
        
        //Tähän tulee asiakkaaseen liittyvä kuva
        add(new JLabel("Assin Ateria"));
        add(suosituksenTulos());
        add(new JLabel("Alkuruuaksi on x. Minkä viinin valitset tarjottavaksi?"));
        add(viinivalinta());
        JButton suositus = new JButton("Suosittele!");
        suositus.addActionListener(null);
        
        add(suositus);

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
        
        return valintalaatikko;
    }
    
    private JPanel suosituksenTulos(){
        JPanel tulos = new JPanel();
        tulos.add(new JLabel("Tähän tulee yhteenveto asiakkaan reaktiosta"));
        
        return tulos;
    
    }

}
