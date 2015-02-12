package hovimestaripeli.kayttoliittyma.tapahtumakuuntelija;

import hovimestaripeli.kayttoliittyma.GraafinenKali;
import hovimestaripeli.kayttoliittyma.Pelitila;
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
    
    private JTextField nimikentta;
    private GraafinenKali gk;
    private Peli peli;

    public HovimestarinLisaysKuuntelija(JTextField nimi, GraafinenKali gk) {
        
        this.nimikentta = nimi;
        this.gk = gk;
        this.peli = gk.getPeli();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        // Lisää tähän vielä virheen käsittely ts. jos yrittää antaa liian lyhyen nimen, peli ei hyväksy sitä
        Hovimestari hm = new Hovimestari(nimikentta.getText());
        peli.setHovimestari(hm);
        peli.kierros(1);
        gk.paivitaPaneeli(new Pelitila(gk));
        
        
    }

}
