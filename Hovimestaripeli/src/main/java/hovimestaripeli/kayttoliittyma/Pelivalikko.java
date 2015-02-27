package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.kayttoliittyma.tapahtumakuuntelija.SuositusKuuntelija;
import hovimestaripeli.logiikka.Peli;
import hovimestaripeli.logiikka.asiakas.Asiakas;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
        this.asiakas = gk.getPeli().getKierros().getAsiakas();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        luoKomponentit();

    }

    private void luoKomponentit() {

        add(hovimestariInfo());
        add(new JLabel("Asiakkaalle tarjoillaan " + peli.getKierros().getRuokalaji().toString() + "." ));
        add(new JLabel("Minkä viinin valitset tarjottavaksi?"));
        add(viinivalinta());
    }

    private JPanel viinivalinta() {
        JPanel valintalaatikko = new JPanel();
        ArrayList<Viini> viinit;
        viinit = peli.getKierros().arvoViinit();
        valintalaatikko.setLayout(new BoxLayout(valintalaatikko, BoxLayout.Y_AXIS));
        JRadioButton eka = new JRadioButton(viinit.get(0).toString());
        eka.setActionCommand("0");
        JRadioButton toka = new JRadioButton(viinit.get(1).toString());
        toka.setActionCommand("1");
        JRadioButton kolmas = new JRadioButton(viinit.get(2).toString());
        kolmas.setActionCommand("2");

        ButtonGroup ryhma = new ButtonGroup();
        ryhma.add(eka);
        ryhma.add(toka);
        ryhma.add(kolmas);
        valintalaatikko.add(eka);
        valintalaatikko.add(toka);
        valintalaatikko.add(kolmas);

        JButton suositus = new JButton("Suosittele!");
        suositus.addActionListener(new SuositusKuuntelija(gk, ryhma, viinit));

        valintalaatikko.add(suositus);

        return valintalaatikko;
    }

    private JPanel hovimestariInfo() {
        JPanel hminfo = new JPanel();
        hminfo.setLayout(new BoxLayout(hminfo, BoxLayout.Y_AXIS));

        hminfo.add(new JLabel("Illan hovimestarina toimii " + peli.getHovimestari().getNimi() + "."));
        hminfo.add(new JLabel("Tippisi ennen nykyistä asiakasta: " + peli.getHovimestari().getTippi()));
        hminfo.add(new JLabel(new ImageIcon(gk.getHovimestarinKuva())));

        return hminfo;
    }

}
