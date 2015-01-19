package hovimestaripeli.logiikka;

/**
 * "Hot potato, office drawers, Puck will make amends!"
 * @author amparkki
 */
public class Hovimestari {
    
    private String nimi;
    private int tippi;
    
    public Hovimestari(String nimi) {
        this.nimi = nimi;
        tippi = 0;
    }
    
    public Hovimestari(){
        this("Jeeves");
    
    }

    public String getNimi() {
        return nimi;
    }
    
    

   

}
