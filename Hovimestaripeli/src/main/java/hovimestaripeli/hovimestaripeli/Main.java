package hovimestaripeli.hovimestaripeli;

import hovimestaripeli.kayttoliittyma.*;
import hovimestaripeli.logiikka.*;
import hovimestaripeli.logiikka.asiakas.*;
import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.util.Scanner;

/**
 * "Macbeth."
 *
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

//        Maku uusimaku = new Maku(2, new String[]{"Barbera", "Pinot Noir", "Pinot Grigio"}, new String[]{"Chardonnay"}, 5, 15);
//        
        Maku uusimaku = new Maku(2, new String[]{"Chardonnay", "Pinot Noir", "Pinot Grigio"}, new String[]{"Tempranillo"}, 5, 15);
        Asiakas ABC = new Asiakas("ABC", 100, uusimaku, 3);
//        peli.setAsiakas(ABC);

        Ruokalaji kanapasta = new Ruokalaji(1, 2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, 2);
//        
        Viini chardonnay = new Viini(2, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA");
//        Viini pn = new Viini(2, new String[]{"Pinot Noir"}, 16, 5, 12, "Ranska");
//        
        ABC.reagoi(chardonnay, kanapasta);
        System.out.println(ABC.tyytyvaisyys);
//        ABC.reagoi(pn);
//        System.out.println(ABC.tyytyvaisyys);
        System.out.println(ABC.annaTippiä());

//        Asiakas a = new Asiakas("Tyyppi", 200, new Maku());
//        peli.setAsiakas(a);
//        
//        Viini v = new Viini();
//        
//        a.humallu(v);
//        a.reagoi(v);
//        
//        System.out.println("Tyytyväisyys: " + a.getTyytyvaisyys());
//        System.out.println("Humala: " + a.getHumala());
//        System.out.println("Tippi: " + a.annaTippiä());
//        
//        System.out.println(chardonnay);
//        System.out.println(v);
    }

}
