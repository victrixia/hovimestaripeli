package hovimestaripeli.varasto;

import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.util.*;

/**
 * Koska kurssi ei painotu tietokantoihin, toistaiseksi hoidetaan viinien ja
 * ruokalajien tallentaminen ihan näin kovakoodaamalla ne listoihin.
 *
 * @author amparkki
 */
public class TarjottavienValiaikaisvarasto {

    private ArrayList<Viini> viinit;
    private ArrayList<Ruokalaji> alkuruokalajit;
    private ArrayList<Ruokalaji> paaruokalajit;
    private ArrayList<Ruokalaji> jalkiruokalajit;

    public TarjottavienValiaikaisvarasto() {

        Viini[] v = new Viini[]{new Viini(), new Viini(2, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA"), new Viini(2, new String[]{"Sauvignon Blanc"}, 4, 0, 12, "Chile"),
            new Viini(1, new String[]{"Pinot Noir"}, 12, 5, 13, "Uusi-Seelanti"), new Viini(1, new String[]{"Tempranillo"}, 6, 2, 14, "Espanja"), new Viini(1, new String[]{"Cabernet Sauvignon", "Merlot"}, 8, 3, 14, "Australia"),
            new Viini(3, new String[]{"Pinot Noir, Pinot Meunier, Chardonnay"}, 18, 5, 12, "Ranska")};
        this.viinit = new ArrayList<>(Arrays.asList(v));

        Ruokalaji[] r = new Ruokalaji[]{new Ruokalaji(), new Ruokalaji(1, "Saltimbocca alla Romana, marsalaviinissä marinoitua vasikanleikettä.", new String[]{"Pinot Grigio", "Soave"}, new String[]{"Barolo", "Rivaner", "Muscat"}, 2),
            new Ruokalaji(1, "Vihersalaatti", new String[]{"Pinot Blanc", "Sauvignon Blanc", "Chenin Blanc"}, new String[]{"Carmenere", "Shiraz", "Cabernet Sauvignon"}, 2),
            new Ruokalaji(1, "Valkosipulietanat", new String[]{"Riesling"}, new String[]{"Cabernet Sauvignon", "Rivaner", "Muscat"}, 2)};

        this.alkuruokalajit = new ArrayList<>(Arrays.asList(r));

        Ruokalaji[] pr = new Ruokalaji[]{
            new Ruokalaji(2, "Blinit Smetanalla, Muikunmädillä ja sipulisilpulla", new String[]{
                "Riesling", "Pinot Noir, Pinot Meunier, Chardonnay"}, new String[]{"Malbec", "Brunello", "Amarone"}, 2),
            new Ruokalaji(2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, 2)};
        
        this.paaruokalajit = new ArrayList<>(Arrays.asList(pr));
        
        Ruokalaji[] jr = new Ruokalaji[]{
        new Ruokalaji(3, "Suklaakakku tyrnikastikkeella", new String[]{"Portviini","Madeira","Riesling Trockenbeerenauslese"}, new String[]{"Moscato d'Asti"}, 5),
            new Ruokalaji(3, "Sitruunamarenkitartaletti mantelipohjalla", new String[]{"Moscato d'Asti"}, new String[]{"Tokaji","Sauternes","Portviini"},5)};
        
        this.jalkiruokalajit = new ArrayList<>(Arrays.asList(jr));
        }
    
    

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
}
