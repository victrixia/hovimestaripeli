package hovimestaripeli.logiikka.tarjottavat;

/**
 * "Hot potato, office drawers, Puck will make amends!"
 * 
 * Saattaa olla turha luokka, katsotaan poistuuko kokonaan
 * @author amparkki
 */
class Ateria {

    private int[] ruokalajit;           // taulukossa kolme paikkaa ruokalajeille, numero yhdistää ruokalaji-id:hen
    
    public Ateria(){
        ruokalajit = new int[]{1,1,1};
    }
    
    public int getRuokalaji(int vaihe){  // eli siis aterian vaihe
        
        return ruokalajit[vaihe];
        
    }      
}
