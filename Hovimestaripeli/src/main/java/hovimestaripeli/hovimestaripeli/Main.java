

package hovimestaripeli.hovimestaripeli;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.*;
import java.util.Scanner;

/**
 * "Macbeth."
 * @author amparkki
 */
public class Main {

  
    public static void main(String[] args) {
      
        Scanner reader = new Scanner(System.in);
        
        Tekstikali kali = new Tekstikali(reader);
        
        Peli peli = new Peli(kali);
        kali.setPeli(peli);
        
        peli.pelaa();
        
    }

}
