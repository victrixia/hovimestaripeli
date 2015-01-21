

package hovimestaripeli.hovimestaripeli;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.util.Scanner;

/**
 * "Macbeth."
 * @author amparkki
 */
public class Main {

  
    public static void main(String[] args) {
      
//        Scanner reader = new Scanner(System.in);
        
//        Tekstikali kali = new Tekstikali(reader);
        
//        Peli peli = new Peli(kali);
//        kali.setPeli(peli);
//        
//        peli.pelaa();
        
        
        Hovimestari jeeves = new Hovimestari();
        
        
        Peli peli = new Peli();
        
        peli.setHovimestari(jeeves);
        
        Maku uusimaku = new Maku(2, new String[]{"Barbera","Pinot Noir","Pinot Grigio"},new String[]{"Chardonnay"},5,15);
        
        Asiakas ABC = new Asiakas("ABC", 100, uusimaku);     
        peli.setAsiakas(ABC);
        
        Viini chardonnay = new Viini(2, new String[]{"Chardonnay"}, 7, 3, 14, "USA");
        Viini pn = new Viini(2, new String[]{"Pinot Noir"}, 16,5,12, "Ranska");
        
        ABC.reagoi(chardonnay);
        System.out.println(ABC.tyytyvaisyys);
        ABC.reagoi(pn);
        System.out.println(ABC.tyytyvaisyys);
        System.out.println(ABC.annaTippiä());
        
    }

}
