package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.kayttoliittyma.tapahtumakuuntelija.HovimestarinLisaysKuuntelija;
import hovimestaripeli.logiikka.Peli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class HovimestarinLuonti extends JPanel {

    private GraafinenKali gk;
    ButtonGroup ryhma; 
    private Kuvanlukija kl = new Kuvanlukija();

    public HovimestarinLuonti(GraafinenKali gk) {
        super();

        this.gk = gk;
        this.ryhma = null;
//        this.setLayout(new GridLayout(2, 1));
        luoKomponentit();

    }

    private void luoKomponentit() {

        add(kuvanValinta());
        add(nimensyotto());

    }

 

    private JPanel kuvanValinta() {

        JPanel kuvanValinta = new JPanel(new GridLayout(2, 2, 10, 10));

        BufferedImage pierre = kl.lueKuva("src/main/resources/HovimestariPierre.jpg");
        BufferedImage pierrette = kl.lueKuva("src/main/resources/HovimestariPierrette.jpg");

        JLabel ekaVaihtoehto = new JLabel(new ImageIcon(pierre));
        JLabel tokaVaihtoehto = new JLabel(new ImageIcon(pierrette));

        JRadioButton eka = new JRadioButton("Pierre");
        eka.setActionCommand("src/main/resources/HovimestariPierre.jpg");
        eka.setSelected(true);
        JRadioButton toka = new JRadioButton("Pierrette");
        toka.setActionCommand("src/main/resources/HovimestariPierrette.jpg");

        ryhma = new ButtonGroup();
        ryhma.add(eka);
        ryhma.add(toka);

        kuvanValinta.add(ekaVaihtoehto);
        kuvanValinta.add(eka);

        kuvanValinta.add(tokaVaihtoehto);
        kuvanValinta.add(toka);
        return kuvanValinta;
    }

    private JPanel nimensyotto() {
        JPanel nimensyotto = new JPanel();
        nimensyotto.setAlignmentX(1f);
        nimensyotto.setLayout(new BoxLayout(nimensyotto, BoxLayout.Y_AXIS));

        JLabel nimitxt = new JLabel("Nimi: ");
        JTextField nimiKentta = new JTextField(10);

        JButton uusiNappi = new JButton("Aloitetaan!");

        uusiNappi.addActionListener(new HovimestarinLisaysKuuntelija(nimiKentta, gk, ryhma));

        nimensyotto.add(new JLabel("Valitse Hovimestarisi kuva ja anna hänelle nimi!"));
        nimensyotto.add(nimitxt);

        nimensyotto.add(nimiKentta);

        nimensyotto.add(uusiNappi);

        return nimensyotto;
    }

}
