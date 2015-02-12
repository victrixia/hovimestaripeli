package hovimestaripeli.kayttoliittyma.tapahtumakuuntelija;
import hovimestaripeli.kayttoliittyma.GraafinenKali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class Siirry implements ActionListener {
    
    private JPanel panel;
    private GraafinenKali gk;
    
    public Siirry(GraafinenKali gk, JPanel panel){
        this.panel = panel;
        this.gk = gk;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        gk.paivitaPaneeli(panel);
    }

}
