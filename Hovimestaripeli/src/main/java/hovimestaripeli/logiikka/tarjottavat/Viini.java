package hovimestaripeli.logiikka.tarjottavat;
import java.util.*;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class Viini {
    
    private int vari;            // 1: punaviini 2: valkoviini 3. kuohuviini 4. rosee 5. jälkiruokaviini
    private String rypaleet;
    private int hinta;           
    private int laatu;           // arvoja väliltä 0-5

    public Viini(int vari, String rypaleet, int hinta, int laatu) {
        this.vari = vari;
        this.rypaleet = rypaleet;
        this.hinta = hinta;
        this.laatu = laatu;
    }

    
    
}

