package hovimestaripeli.logiikka;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.*;

/**
 * "Hot potato, office drawers, Puck will make amends!"
 * @author amparkki
 */
public class Peli {
    
    private Asiakas asiakas;
    private Hovimestari hovimestari;
    private Tekstikali kali;
    
    
    public Peli(Tekstikali kali){
    
        this.kali = kali;
    
    }
    
    public Peli(){                      // käyttöliittymätön testiversio
    
        
    }
    
    public void aloita(){
    
            kali.aloitusmenu();
     
    }
    
    public void aterioi(){
        
           Ruokalaji laji = new Ruokalaji();
           
           tarjoile(laji); 
           
        
    
    }

    public void lopetus() {
        System.out.println("Kiitos kun pelasit, chin chin!");
    }

    public void setHovimestari(Hovimestari hm){
        
        this.hovimestari = hm;
    }
    
    public void tarjoile(Ruokalaji laji){
    
        kali.tarjoile(laji);
        
    }

    public void pelaa() {
        
        aloita();
        aterioi();
        lopetus();
    }

    public Hovimestari getHovimestari() {
        return hovimestari;
    }

    public void setAsiakas(Asiakas asiakas) {
        this.asiakas = asiakas;
    }

    public Asiakas getAsiakas() {
        return asiakas;
    }
    

    
      
    
    
}
