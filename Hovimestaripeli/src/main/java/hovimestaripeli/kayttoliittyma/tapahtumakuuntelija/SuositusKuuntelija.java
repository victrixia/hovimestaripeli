package hovimestaripeli.kayttoliittyma.tapahtumakuuntelija;

import hovimestaripeli.kayttoliittyma.GraafinenKali;
import hovimestaripeli.kayttoliittyma.HovimestarinLuonti;
import hovimestaripeli.kayttoliittyma.Pelitila;
import hovimestaripeli.kayttoliittyma.Pelivalikko;
import hovimestaripeli.logiikka.Peli;
import hovimestaripeli.logiikka.asiakas.Asiakas;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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

        peli.getKierros().valitaReaktio(valinta);

        peli.siirryEteenpain();

        if (peli.getKierros().getVaihe() == 4 || asiakas.getHumala() > 120) {

            gameOver();
        } else {

            gk.paivitaPaneeli(new Pelitila(gk));
        }
    }

    private void gameOver() {

        if (peli.getKierrosluku() >= 5) {
            peliPaattyi();
        } else {

            String viesti = "Onneksi olkoon, selvitit aterian kunnialla loppuun! \n"
                    + "Sait tältä asiakkaalta tippiä " + peli.getKierros().getTippi() + " euroa."
                    + "Haluatko kohdata seuraavan asiakkaan?";

            if (peli.getAsiakas().getHumala() > 120) {
                viesti = "Asiakkaasi alkoi käyttäytyä häiritsevästi ja hänet jouduttiin poistamaan ravintolasta. \n"
                        + "Pidä seuraavalla kerralla huoli, ettet tarjoile asiakkaallesi liian väkeviä juomia! \n"
                        + " Nyt menetit kaikki tippisi tältä kierrokselta.";

            } else if (peli.getKierros().getTippi() < 0) {
                viesti = "Aijai, ateria ei mennyt ihan putkeen ja jäit ilman tippiä. \n"
                        + "Yritä seuraavalla kerralla kuunnella asiakkaan makumieltymyksiä tarkemmin!";
            }

            Object[] options = {"Oui!",
                "Aloita alusta!"};
            int n = JOptionPane.showOptionDialog(gk.getFrame(),
                    viesti,
                    "Lopputilanne",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, //do not use a custom Icon
                    options, //the titles of buttons
                    options[0]); //default button title

            if (n == JOptionPane.YES_OPTION) {
                aloitaUusiKierros();
            } else {
                aloitaUusiPeli();
            }
        }
    }

    private void aloitaUusiPeli() {
        gk.restart();
        gk.paivitaPaneeli(new HovimestarinLuonti(gk));
    }

    private void aloitaUusiKierros() {

        peli.uusiKierros();
        gk.paivitaPeli(peli);

        gk.paivitaPaneeli(new Pelitila(gk));
    }

    private void peliPaattyi() {
        JOptionPane.showMessageDialog(gk.getFrame(), "Peli päättyi! Sait kasatuksi tippiä" + peli.getHovimestari().getTippi() + " euroa.");
        aloitaUusiPeli();

    }

}
