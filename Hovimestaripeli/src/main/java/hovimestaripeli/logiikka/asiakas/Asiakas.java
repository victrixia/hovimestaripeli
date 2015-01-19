package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.tarjottavat.*;



/**
 * "Hot potato, office drawers, Puck will make amends!"
 * @author amparkki
 */
public class Asiakas {

    private String nimi;
    private int budjetti;
    
    private Maku maku;
    
    public Asiakas(){
        nimi = "testiasiakas";
        budjetti = 100;
        
        maku = new Maku(this);
    }
    
}
