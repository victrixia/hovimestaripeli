package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.tarjottavat.*;

/**
 * "Hot potato, office drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class Asiakas {

    private String nimi;
    private int budjetti;       //viinibudjetti, tähän ei kuulu ruoka eikä tippi

    private Maku maku;
    private int humala;         // humalan aste, 10 = 0,1 promillea.
    public int tyytyvaisyys;

    public Asiakas(String nimi, int budjetti, Maku maku) {
        this.nimi = nimi;
        this.budjetti = budjetti;

        this.maku = maku;
        this.humala = 0;
        this.tyytyvaisyys = 0;      // Välillä -100 - 100. Modifioi tipin määrää.
    }

    public void humallu(Viini viini) {       // asiakkaan humalatilan lisäys yhden juoman jäljiltä. Parametriksi tulee Viinin parametri 'vahvuus'.

        int lisays = 2 * viini.getVahvuus();

        this.humala += lisays;
    }

    public void reagoi(Viini viini) {
        int reaktio = 1;

        if (viini.getVari() == maku.yleismaku) {
            reaktio += 2;
        }

        if (viini.getHinta() < maku.getAlaraja() || viini.getHinta() > maku.getYlaraja()) {      // jos viini on liian halpa tai kallis
            reaktio -= 10;
        }

        if (onkoRypaleetListalla(maku.getSuosikki(), viini.getRypaleet())) {             // Teoriassa on mahdollista että samassa viinissä on suosikkia JA inhokkia, mutta suosikki voittaa tässä tapauksessa.
            reaktio += 20;
        } else if (onkoRypaleetListalla(maku.getInhokki(), viini.getRypaleet())) {
            reaktio -= 20;
        }

        reaktio += viini.getLaatu();

        if (humala > 20) {
            reaktio *= humala / 15;
        }

        tyytyvaisyys += reaktio;

        if (tyytyvaisyys < -100) {
            tyytyvaisyys = 100;
        }

        if (tyytyvaisyys > 100) {
            tyytyvaisyys = 100;
        }
    }

    public int annaTippiä() {            // tippi lasketaan uudelleen joka ruokalajin välissä

        int a = 1;
        int b = 1;
        
        if (this.humala > 20) {
            a = this.humala / 10;
        }
        
        if (this.tyytyvaisyys != 0){
            b = this.tyytyvaisyys/10;
        }

        return (this.budjetti / 30) * a * b;     // Pitää vielä tutkia tätä humalan ja tipin suhdetta
    }

    public boolean onkoRypaleetListalla(String[] omaMaku, String[] viininRypaleet) {         // tämä metodi nyt ei ole supertehokas, mutta listat ovat niin lyhyitä ettei haitanne vaikka aikavaativuus onkin vain O(n²) :P

        for (int i = 0; i < omaMaku.length; i++) {
            String a = omaMaku[i];
            for (int j = 0; j < viininRypaleet.length; j++) {
                String b = viininRypaleet[j];

                if (a.equals(b)) {
                    return true;
                }

            }

        }

        return false;
    }

    public int getHumala() {
        return humala;
    }

    public int getTyytyvaisyys() {
        return tyytyvaisyys;
    }

}
