package hovimestaripeli.varasto;

import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import hovimestaripeli.logiikka.tarjottavat.ViininVari;
import java.util.*;

/**
 * Koska kurssi ei painotu tietokantoihin, toistaiseksi hoidetaan viinien ja
 * ruokalajien tallentaminen ihan näin kovakoodaamalla ne listoihin.Jos ois tosi
 * hifi niin vois tehdä enumin missä on rypäleiden ja/tai viinityyppien nimet,
 * mut olkoon nyt.
 *
 * @author amparkki
 */
public class TarjottavienValiaikaisvarasto {

    private ArrayList<Viini> viinit = new ArrayList<>(Arrays.asList(new Viini[]{new Viini(),
        new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA"),
        new Viini(ViininVari.VALKO, new String[]{"Sauvignon Blanc"}, 4, 0, 12, "Chile"),
        new Viini(ViininVari.PUNA, new String[]{"Pinot Noir"}, 12, 5, 13, "Uusi-Seelanti"),
        new Viini(ViininVari.PUNA, new String[]{"Tempranillo"}, 6, 2, 14, "Espanja"),
        new Viini(ViininVari.PUNA, new String[]{"Cabernet Sauvignon", "Merlot"}, 8, 3, 14, "Australia"),
        new Viini(ViininVari.KUOHU, new String[]{"Pinot Noir, Pinot Meunier, Chardonnay", "Shampanja"}, 18, 5, 12, "Ranska")}));

    private ArrayList<Ruokalaji> alkuruokalajit = new ArrayList<>(Arrays.asList(new Ruokalaji[]{new Ruokalaji(),
        new Ruokalaji(1, "Saltimbocca alla Romana, marsalaviinissä marinoitua vasikanleikettä.", new String[]{"Pinot Grigio", "Soave"}, new String[]{"Barolo", "Rivaner", "Muscat"}, ViininVari.VALKO),
        new Ruokalaji(1, "Vihersalaatti", new String[]{"Pinot Blanc", "Sauvignon Blanc", "Chenin Blanc"}, new String[]{"Carmenere", "Shiraz", "Cabernet Sauvignon"}, ViininVari.VALKO),
        new Ruokalaji(1, "Valkosipulietanat", new String[]{"Riesling"}, new String[]{"Cabernet Sauvignon", "Rivaner", "Muscat"}, ViininVari.VALKO)}));

    private ArrayList<Ruokalaji> paaruokalajit = new ArrayList<>(Arrays.asList(new Ruokalaji[]{
        new Ruokalaji(2, "Blinit Smetanalla, Muikunmädillä ja sipulisilpulla", new String[]{
            "Riesling", "Shampanja"}, new String[]{"Malbec", "Brunello", "Amarone"}, ViininVari.VALKO),
        new Ruokalaji(2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, ViininVari.VALKO)}));

    private ArrayList<Ruokalaji> jalkiruokalajit = new ArrayList<>(Arrays.asList(new Ruokalaji[]{
        new Ruokalaji(3, "Suklaakakku tyrnikastikkeella", new String[]{"Portviini", "Madeira", "Riesling Trockenbeerenauslese"}, new String[]{"Moscato d'Asti"}, ViininVari.JALKIRUOKA),
        new Ruokalaji(3, "Sitruunamarenkitartaletti mantelipohjalla", new String[]{"Moscato d'Asti"}, new String[]{"Tokaji", "Sauternes", "Portviini"}, ViininVari.JALKIRUOKA)}));

    private final ArrayList<Viini> jalkiruokaviinit = new ArrayList<>(Arrays.asList(new Viini[]{
        new Viini(ViininVari.JALKIRUOKA, new String[]{"Portviini"}, 13, 4, 16, "Portugali"),
        new Viini(ViininVari.JALKIRUOKA, new String[]{"Moscato d'Asti"}, 10, 3, 6, "Italia"),
        new Viini(ViininVari.JALKIRUOKA, new String[]{"Riesling Trockenbeerenauslese"}, 16, 4, 12, "Saksa"),
        new Viini(ViininVari.JALKIRUOKA, new String[]{"Sauternes"}, 16, 5, 12, "Ranska")
    }));

    public ArrayList<Viini> getViinit() {
        return viinit;
    }

    public ArrayList<Ruokalaji> getAlkuruokalajit() {
        return this.alkuruokalajit;
    }

    public ArrayList<Ruokalaji> getPaaruokalajit() {
        return this.paaruokalajit;
    }

    public ArrayList<Ruokalaji> getJalkiruokalajit() {
        return this.jalkiruokalajit;
    }

    public ArrayList<Viini> getJalkiruokaViinit() {
        return this.jalkiruokaviinit;
    }
}
