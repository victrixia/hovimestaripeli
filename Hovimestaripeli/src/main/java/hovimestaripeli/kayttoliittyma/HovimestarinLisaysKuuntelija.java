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
    private Peli peli;

    public HovimestarinLisaysKuuntelija(JTextField syote, Peli peli) {
        
        this.syote = syote;
        this.peli = peli;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Hovimestari hm = new Hovimestari(syote.getText());
        peli.setHovimestari(hm);
        
    }

}
