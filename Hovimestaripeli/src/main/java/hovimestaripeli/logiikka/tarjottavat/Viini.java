package hovimestaripeli.logiikka.tarjottavat;
import java.util.*;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class Viini {
    
    private int vari;            // 1: punaviini 2: valkoviini 3. kuohuviini 4. rosee 5. jälkiruokaviini
    private String[] rypaleet;
    private int hinta;           
    private int laatu;           // arvoja väliltä 0-5
    private int vahvuus;        //alkoholiprosentti
    private String maa;

    public Viini(int vari, String[] rypaleet, int hinta, int laatu, int vahvuus, String maa) {
        this.vari = vari;
        this.rypaleet = rypaleet;
        this.hinta = hinta;
        this.laatu = laatu;
        this.vahvuus = vahvuus;
        this.maa = maa;             // lisätään myöhemmin maan vaikutus suosikkeihin
    }
    
    public Viini (){
        this.vari = 2;
        this.rypaleet = new String[]{"Riesling"};
        this.hinta = 10;
        this.laatu = 4;
        this.vahvuus = 12;
        this.maa = "Saksa";
    
    }

    public int getHinta() {
        return hinta;
    }

    public int getLaatu() {
        return laatu;
    }

    public String[] getRypaleet() {
        
        
        return rypaleet;
    }
    
    public String getRypaleetString(){
        
        String r = "";
    
        for (int i = 0; i < rypaleet.length; i++) {
            r += rypaleet[i];
            if (i < rypaleet.length - 1){
                r += ", "; 
            }
            
        }
        
        return r;
    
    }

    public int getVahvuus() {
        return vahvuus;
    }

    public int getVari() {
        return vari;
    }

    @Override
    public String toString() {
        String v = "";
        
        if (vari == 1){
        v = "Punaviini";
        } else if (vari == 2){
        v = "Valkoviini";
        } else if (vari == 3) {
        v = "Kuohuviini";
        } else if (vari == 4){
        v = "Roseeviini";
        } else if (vari == 5){
        v = "Jälkiruokaviini";
        } else {
        v = "Muu";                  // Lähinnä varuilta, lopullisessa käyttöliittymässä väri valitaan valikosta, ei itse syöttämällä
        }
            
        
        
        return v + ", " + maa + ". Rypäleet: " + getRypaleetString() + ". Hinta: "
                + hinta + "€, Laatu: " + laatu + " tähteä, alkoholiprosentti " + vahvuus; 
    }
    
    

    
    
}

