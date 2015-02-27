package hovimestaripeli.kayttoliittyma.tapahtumakuuntelija;

import hovimestaripeli.kayttoliittyma.GraafinenKali;
import hovimestaripeli.kayttoliittyma.HovimestarinLuonti;
import hovimestaripeli.kayttoliittyma.Pelitila;
import hovimestaripeli.logiikka.Hovimestari;
import hovimestaripeli.logiikka.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class HovimestarinLisaysKuuntelija implements ActionListener {

    private JTextField nimikentta;
    private GraafinenKali gk;
    private Peli peli;
    private final ButtonGroup bg;

    public HovimestarinLisaysKuuntelija(JTextField nimi, GraafinenKali gk, ButtonGroup bg) {

        this.nimikentta = nimi;
        this.gk = gk;
        this.peli = gk.getPeli();
        this.bg = bg;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Lisää tähän vielä virheen käsittely ts. jos yrittää antaa liian lyhyen nimen, peli ei hyväksy sitä
        if (nimikentta.getText().length() < 2) {
            JOptionPane.showMessageDialog(gk.getFrame(), "Nimen pitää olla ainakin kaksi merkkiä pitkä!");
            gk.paivitaPaneeli(new HovimestarinLuonti(gk));
        } else if (bg.getSelection().getActionCommand().isEmpty()){
            JOptionPane.showMessageDialog(gk.getFrame(), "Valitse jompikumpi kuva!");
            gk.paivitaPaneeli(new HovimestarinLuonti(gk));
        }{

            Hovimestari hm = new Hovimestari(nimikentta.getText());
            peli.setHovimestari(hm);
            gk.setHovimestarinKuva(bg.getSelection().getActionCommand());
            gk.paivitaPaneeli(new Pelitila(gk));
        }

    }

}
