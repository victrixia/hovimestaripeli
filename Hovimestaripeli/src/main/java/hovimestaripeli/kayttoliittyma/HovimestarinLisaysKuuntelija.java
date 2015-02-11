package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.Hovimestari;
import hovimestaripeli.logiikka.Peli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class HovimestarinLisaysKuuntelija implements ActionListener{
    
    private JTextField syote;
    private GraafinenKali gk;
    private Peli peli;

    public HovimestarinLisaysKuuntelija(JTextField syote, GraafinenKali gk) {
        
        this.syote = syote;
        this.gk = gk;
        this.peli = gk.getPeli();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Hovimestari hm = new Hovimestari(syote.getText());
        peli.setHovimestari(hm);
        gk.paivitaPaneeli(new Pelitila(gk));
        
        
    }

}
