package hovimestaripeli.varasto;

import hovimestaripeli.logiikka.asiakas.Asiakas;
import hovimestaripeli.logiikka.asiakas.Maku;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import hovimestaripeli.logiikka.tarjottavat.ViininVari;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class Asiakasvarasto {

    private ArrayList<Asiakas> asiakkaat = new ArrayList<>(Arrays.asList(new Asiakas[]{
        new Asiakas("Pirre Pirteä", 25, new Maku(ViininVari.VALKO, new String[]{"Rivaner", "Muscat", "Riesling", "Chenin Blanc", "Pinot Blanc", "Pinot Grigio", "Moscato d'Asti"}, new String[]{"Pinot Noir", "Cabernet Sauvignon", "Tempranillo"}, 4, 12), 1, "Voi en mä tiedä näistä viineistä mitään, jotain valkosta ja makeeta vaan! Mä luotan suhun täysin!!", "src/main/resources/Pirre.jpg"),
        new Asiakas("Pera Korsosta", 30, new Maku(ViininVari.PUNA, new String[]{"Cabernet Sauvignon", "Tempranillo", "Nero d'Avola"}, new String[]{"Rivaner", "Muscat", "Sauvignon Blanc", "Chardonnay", "Pinot Noir", "Blaufränkisch", "Gamay"}, 6, 10), 3, "Eikö teiltä oikeasti saa olutta? No jotain punaviiniä sitten, mutta ei liian hapanta! Eikä mitään liian makeaa!", "src/main/resources/PeraKorsosta.jpg"),
        new Asiakas("Kiireinen Liikemies", 40, new Maku(ViininVari.KUOHU, new String[]{"Shampanja", "Chardonnay", "Cabernet Sauvignon", "Riesling", "Pinot Noir"}, new String[]{"Rivaner", "Sauvignon Blanc", "Verdejo", "Chenin Blanc"}, 8, 17), 5, "Joo hetkinen anteeks NIIN sähän täällä se asiantuntija olet, laita nyt vaan jotain mikä sopii JOO ei kun mä puhuin tarjoilijalle niin se diili sitten", "src/main/resources/PseudoObama.jpg"),
        new Asiakas("Päivi Pätevä", 50, new Maku(ViininVari.VALKO, new String[]{"Riesling", "Sauvignon Blanc", "Pinot Gris", "Bordeaux", "Pinot Noir"}, new String[]{"Muscat", "Tempranillo", "Malbec", "Merlot"}, 10, 25), 7, "Näyttääkö tämä kuohuviini sinusta jotenkin siniseltä? Yllätä mut, mutta laatua pitää olla! Mieluiten ranskalaista, kiitos.", "src/main/resources/Paivi.jpg"),
        new Asiakas("Nita Vainola", 40, new Maku (ViininVari.KUOHU, new String[]{"Shampanja","Bordeaux","Margaux","Pinot Noir"}, new String[]{"Riesling", "Rivaner", "Muscat", "Merlot", "Tempranillo", "Sauvignon Blanc", "Pinot Grigio", "Pinot Gris", "Chardonnay"}, 11, 20), 9, "Minulle vain kaikkein parasta! Mutta et sitten yritä liian kallista myydä! Ja ei mitään kissanpissavalkkaria sitten!", "src/main/resources/NitaVainola.jpg")
    }));

    public ArrayList<Asiakas> getAsiakkaat() {
        return asiakkaat;
    }

}
