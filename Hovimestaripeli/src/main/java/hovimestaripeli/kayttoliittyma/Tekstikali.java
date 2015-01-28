package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.*;
import hovimestaripeli.logiikka.asiakas.Asiakas;
import hovimestaripeli.logiikka.tarjottavat.*;
import java.util.*;

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
                break;
            } else {
                System.out.println("Höpö höpö, otapa uudestaan!");
            }

        }

    }

    private void luoHovimestari() {
        while (true) {

            System.out.println("Anna hovimestarin nimi:");
            System.out.print(">");
            input = reader.nextLine();
            if (!input.isEmpty()) {
                break;
            }

        }

        peli.setHovimestari(new Hovimestari(input));

        System.out.println("Tervetuloa peliin, " + peli.getHovimestari().getNimi() + "!");

    }

    public void setPeli(Peli peli) {
        this.peli = peli;
    }

    public int tarjoile(Ruokalaji laji, ArrayList<Viini> v) {

        if (laji.getTyyppi() == 0) {
            System.out.print("Alkuruokana on ");
        } else if (laji.getTyyppi() == 1) {
            System.out.print("Pääruokana on ");
        } else {
            System.out.print("Jälkiruoaksi on ");
        }

        System.out.println(laji.getKuvaus() + ". Mitä viiniä suosittelet asiakkaalle? Vaihtoehdot ovat:");
        System.out.println("1: " + v.get(0));
        System.out.println("2: " + v.get(1));
        System.out.println("3: " + v.get(2));
        System.out.print(">");
        int a = Integer.parseInt(reader.nextLine());
        System.out.println("Kiitos!");

        return a - 1;

    }

    public void asiakkaanReaktio(Asiakas a) {
        System.out.println("Asiakkaan tyytyväisyys tarjoilemasi viinin jälkeen: " + a.getTyytyvaisyys());       // Reaktioista tulee taiteellisesti kiinnostavampia kunhan ehdin oikeasti tehdä asiakkaat. ;)
        System.out.println("Tippisi kasvoi " + a.annaTippiä() + " eurolla.");

        int al = 0;                 // muotoillaan promillet oikein
        int b = a.getHumala();
        if (b > 99) {
            al = 1;
            b -= 100;
        }

        System.out.println("Asiakkaan humalatila on tämän ruokalajin jälkeen " + al + "." + b + " promillea.");   

    }

}
