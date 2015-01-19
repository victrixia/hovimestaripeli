package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.*;
import hovimestaripeli.logiikka.tarjottavat.*;
import java.util.Scanner;

/**
 * "Mille milliards de mille sabords!"
 *
 * @author amparkki
 */
public class Tekstikali {

    private Scanner reader;
    private String input = "";
    private Peli peli;

    public Tekstikali(Scanner reader) {

        this.reader = reader;

    }

    public void aloitusmenu() {


        System.out.println("Tervetuloa hovimestaripeliin! \n"
                + "Luo uusi hovimestari kirjoittamalla \'1\'. \n"
                + "poistu pelistä kirjoittamalla \'x\'");

        while (true) {

            System.out.print(">");
            input = reader.nextLine();

            if (input.equals("x")) {
                break;
            } else if (input.equals("1")) {
                luoHovimestari();
            } else {
                System.out.println("Höpö höpö, otapa uudestaan!");
            }

        }

    }

    private void luoHovimestari() {
        System.out.println("Anna hovimestarin nimi (jos et anna nimeä, sinulle arvotaan sellainen)");
        System.out.print(">");
        input = reader.nextLine();
        
        peli.setHovimestari(input);
        
        System.out.println("Tervetuloa peliin, " + peli.getHovimestari().getNimi() + "!");
        
        
    }
    
    public void setPeli(Peli peli){
        this.peli = peli;
    }

    public int tarjoile(Ruokalaji laji) {
        
        if (laji.getTyyppi() == 0){
            System.out.print("Alkuruokana on ");
        } else if (laji.getTyyppi() == 1){
            System.out.print("Pääruokana on ");
        } else {
            System.out.print("Jälkiruoaksi on ");
        }
    
        System.out.println(laji.getKuvaus() + ". Mitä viiniä suosittelet asiakkaalle?");
        System.out.print(">");
        int a = Integer.parseInt(reader.nextLine());
        System.out.println("Kiitos!");
        
        return a;
        
    }

}
