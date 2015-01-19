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
        asiakas = new Asiakas();
       
    
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

    public void setHovimestari(String nimi){
        this.hovimestari = new Hovimestari(nimi);
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
    
      
    
    
}
