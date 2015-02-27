package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.tarjottavat.ViininVari;

/**
 * Maku määrittelee asiakkaan yleismaun, suosikit, inhokit sekä budjetin ala- ja ylärajan. 
 * 
 * Yleismaku: Mistä viinityypistä pitää eniten, antaa pienen lisäbonuksen.
 * Budjetin alittaminen tai ylittäminen vähentää tippiä. Suosikit ja inhokit antavat suurehkon
 * bonuksen tai rangaistuksen.
 * 
 * @author amparkki
 */
public class Maku {
    
    String[] suosikki;
    String[] inhokki;
    int alaraja;            // minkä hintaista halvempaa pitää loukkaavana
    int ylaraja;            // miten kalliiseen ei suostu
    ViininVari yleismaku;          // Mikä viinityyppi maistuu parhaiten, pieni lisäbonus
    RypaleidenVertailu vertaa = new RypaleidenVertailu();
    

    public Maku(ViininVari yleismaku, String[] suosikki, String[] inhokki, int alaraja, int ylaraja) {
        this.suosikki = suosikki;
        this.inhokki = inhokki;
        this.ylaraja = ylaraja;
        this.alaraja = alaraja;
        this.yleismaku = yleismaku;
    }
    
    public Maku(){                                      // Testejä varten
        this.suosikki = new String[]{"Riesling"};
        this.inhokki = new String[]{"Cabernet Sauvignon"};
        this.ylaraja = 20;
        this.alaraja = 7;
        this.yleismaku = ViininVari.VALKO;
        
    }

    public int getAlaraja() {
        return alaraja;
    }

    public boolean onSuosikki(String[] rypaleet) {
        
        return vertaa.onkoRypaleetListalla(suosikki, rypaleet);
    }

    public boolean onInhokki(String[] rypaleet) {
        
        return vertaa.onkoRypaleetListalla(suosikki, rypaleet);
    }

    public int getYlaraja() {
        return ylaraja;
    }

    public ViininVari getYleismaku() {
        return yleismaku;
    }

  
    
    
    

}
