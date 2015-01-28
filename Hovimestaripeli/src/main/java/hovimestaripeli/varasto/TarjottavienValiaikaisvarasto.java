package hovimestaripeli.varasto;

import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.util.*;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class TarjottavienValiaikaisvarasto {
    
    private ArrayList<Viini> viinit;
    private ArrayList<Ruokalaji> ruokalajit;
    
    public TarjottavienValiaikaisvarasto(){
        
        Viini[] v = new Viini[]{new Viini(), new Viini(2, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA"),new Viini(2, new String[]{"Sauvignon Blanc"}, 4, 0, 12, "Chile"), 
                new Viini(1, new String[]{"Pinot Noir"}, 12,5,13,"Uusi-Seelanti"), new Viini(1, new String[]{"Tempranillo"},6, 2, 14, "Espanja"), new Viini(1, new String[]{"Cabernet Sauvignon","Merlot"}, 8, 3, 14, "Australia"),
                new Viini(3, new String[]{"Pinot Noir, Pinot Meunier, Chardonnay"}, 18,5,12,"Ranska")};
        this.viinit= new ArrayList<>(Arrays.asList(v));
    
    }

    public ArrayList<Viini> getViinit() {
        return viinit;
    }
    
    

}


