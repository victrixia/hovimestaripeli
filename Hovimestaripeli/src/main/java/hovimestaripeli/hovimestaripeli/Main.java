package hovimestaripeli.hovimestaripeli;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import hovimestaripeli.varasto.*;
import java.util.*;

/**
 * "Macbeth."
 *
 * @author amparkki
 */
public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Tekstikali kali = new Tekstikali(reader);
        Peli peli = new Peli(kali);
        kali.setPeli(peli);
        Maku maku = new Maku(2, new String[]{"Sauvignon Blanc","Riesling","Pinot Noir"}, new String[]{"Tempranillo","Merlot"}, 6, 17);
        peli.setAsiakas(new Asiakas("Jokke", 100, maku, 2));
        
        peli.pelaa();
        

   

        
//        Random random = new Random();
//        
//        for (int i = 0; i < 10; i++) {
//           Viini v = peli.t.getViinit().get(random.nextInt(peli.t.getViinit().size() - 1));
//            
//            System.out.println(v);
//        }

    }

}
