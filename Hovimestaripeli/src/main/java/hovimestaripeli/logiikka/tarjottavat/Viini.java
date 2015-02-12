package hovimestaripeli.logiikka.tarjottavat;
import java.util.*;

/**
 * Pelin ydinasia. Viinintuntemus ratkaisee suurelta osin, voittaako vai häviääkö pelin.
 * Viinillä on väri (käytännössä viinityyppi: puna-, valko-, kuohu-, rosee- ja jälkiruokaviini),
 * lista rypäleistä, hinta, laatu (0-5), vahvuus alkoholiprosenttina sekä valmistusmaa.
 * 
 * @author amparkki
 */
public class Viini {
    
    private int vari;            // 1: punaviini 2: valkoviini 3. kuohuviini 4. rosee 5. jälkiruokaviini
    private String[] rypaleet;
    private int hinta;           
    private int laatu;           // arvoja väliltä 0-5
    private int vahvuus;        //alkoholiprosentti
    private String maa;

    public Viini (int vari, String[] rypaleet, int hinta, int laatu, int vahvuus, String maa) {
        
//        if (vari <= 0 || vari >=6){
//            throw new Error ("Värin voi määritellä väliltä 1-5");
//        }
//        
//        if (hinta <= 0){
//            throw new Error ("Et voi jakaa viiniä ilmaiseksi pois!");
//        }
//        
//        if (vahvuus < 0 || vahvuus >= 96 ){
//            throw new Error ("Viinin alkoholiprosentti ei voi olla negatiivinen eikä yli 96!");
//        }
//        
//        if (laatu < 0 || laatu > 5){
//            throw new Error ("Laadun voi määritellä väliltä 0-5");
//        }
        
        //  Koska viinejä ei voi luoda itse, on oikeastaan ihan sama onko ylläolevaa määritelty. Siispä pois.
        
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
                + hinta + "€, Laatu: " + laatu + " tähteä, Alkoholiprosentti: " + vahvuus +"."; 
    }

    /**
     *
     * Viineillä on hashCode() ja equals-metodit, jotta voidaan verrata arvottaessa,
     * onko sama viini tulossa listalle useamman kerran. Viinin jokainen aspekti vaikuttaa
     * samuuteen.
     */
    @Override
  public int hashCode(){
      return maa.length()*hinta+laatu+vahvuus;
  }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Viini other = (Viini) obj;
        if (this.vari != other.vari) {
            return false;
        }
        if (!Arrays.deepEquals(this.rypaleet, other.rypaleet)) {
            return false;
        }
        if (this.hinta != other.hinta) {
            return false;
        }
        if (this.laatu != other.laatu) {
            return false;
        }
        if (this.vahvuus != other.vahvuus) {
            return false;
        }
        if (!Objects.equals(this.maa, other.maa)) {
            return false;
        }
        return true;
    }
    

    
    
}

