package hovimestaripeli.logiikka.asiakas;

/**
 * "Hot potato, office drawers, Puck will make amends!"
 * @author amparkki
 */
class Maku {
    
    String suosikki;
    String inhokki;
    Asiakas asiakas;

    public Maku(String suosikki, String inhokki, Asiakas asiakas) {
        this.suosikki = suosikki;
        this.inhokki = inhokki;
        this.asiakas = asiakas;
    }

    
    
    public Maku(Asiakas a){
        
        this("Shiraz","Muscat", a);
        
    }
    
    
    

}
