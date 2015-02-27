package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.Peli;
import hovimestaripeli.logiikka.asiakas.Asiakas;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    Kuvanlukija kl = new Kuvanlukija();

    public AsiakasPaneeli(GraafinenKali gk) {

        super();
        this.gk = gk;
        this.asiakas = gk.getPeli().getKierros().getAsiakas();
        this.peli = gk.getPeli();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        luoKomponentit();

    }

    private void luoKomponentit() {
        add(suosituksenTulos());

        JButton info = new JButton("Kysy asiakkaalta hänen viinimaustaan!");
        info.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(gk.getFrame(), asiakas.getEsittely(), asiakas.toString(), JOptionPane.PLAIN_MESSAGE);
            }
        });
        add(info);

        BufferedImage asiakkaanKuva = kl.lueKuva(asiakas.getKuvanPolku());
        JLabel kuva = new JLabel(new ImageIcon(asiakkaanKuva));

        add(kuva);
    }

    private JPanel suosituksenTulos() {
        JPanel tulos = new JPanel();
        tulos.setLayout(new BoxLayout(tulos, BoxLayout.Y_AXIS));
        
        tulos.add(new JLabel(asiakas.getHumalanKuvaus()));
        
        tulos.add(new JLabel("Asiakkaan tyytyväisyys tällä hetkellä " + asiakas.getTyytyvaisyys()));

        tulos.add(new JLabel(peli.getAsiakas().toString() + " on antamassa sinulle tippiä " + peli.getKierros().getTippi()));
        return tulos;

    }

}
