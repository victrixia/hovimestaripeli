package hovimestaripeli.kayttoliittyma.tapahtumakuuntelija;

import hovimestaripeli.kayttoliittyma.GraafinenKali;
import hovimestaripeli.kayttoliittyma.HovimestarinLuonti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class UusiPeliKuuntelija implements ActionListener{

    private GraafinenKali gk;
    
    public UusiPeliKuuntelija(GraafinenKali gk){
        this.gk = gk;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        gk.restart();
        gk.paivitaPaneeli(new HovimestarinLuonti(gk));
    }

}
