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
    private int level;

    public Asiakas(String nimi, int budjetti, Maku maku, int level) {
        this.nimi = nimi;
        this.budjetti = budjetti;
        this.level = level;
        this.maku = maku;
        this.humala = 0;
        this.tyytyvaisyys = 0;      // Välillä -100 - 100. Modifioi tipin määrää.
    }

    public void humallu(Viini viini) {       // asiakkaan humalatilan lisäys yhden juoman jäljiltä. Parametriksi tulee Viinin parametri 'vahvuus'.

        int lisays = 2 * viini.getVahvuus();

        this.humala += lisays;
    }

    public void reagoi(Viini viini, Ruokalaji rl) {         // onko tämä metodi liian pitkä? Sitä voi ehkä pilkkoa pienempiin osiin jos tarvitsee.

        int reaktio = 1;

        if (viini.getVari() == maku.yleismaku) {
            reaktio += 2;
        }

        reaktio += onkoLiianKallistaTaiHalpaa(viini);
        reaktio += onkoSuosikkiRypale(viini);
        if (this.level > 3) {                               // Korkeamman levelin asiakkaat osaavat arvioida, sopiiko viini tarjoiltuun ruokalajiin.
            reaktio += sopiikoRuokalajille(viini, rl);
        }
        reaktio += viini.getLaatu();

        if (humala > 20) {
            reaktio *= humala / 15;
        }

        tyytyvaisyys += reaktio;

        if (tyytyvaisyys <= -100) {
            tyytyvaisyys = -100;
        }

        if (tyytyvaisyys >= 100) {
            tyytyvaisyys = 100;
        }

        humallu(viini);                 // Reaktion lopuksi lasketaan viinin vaikutus asiakkaan humalatilaan seuraavaa kierrosta varten.
    }

    public int annaTippiä() {            // tippi lasketaan uudelleen joka ruokalajin välissä

        int a = 1;
        int b = 1;

        if (this.humala > 20) {         // 0.2 promillen tai sitä korkeampi humala nostaa tippikerrointa
            a = this.humala / 10;
        }

        if (this.tyytyvaisyys != 0) {
            b = this.tyytyvaisyys / 10;   // Jos tyytyväisyys ei ole nolla, tyytyväisyys tai tyytymättömyys antaa myös tippikertoimen - negatiivisen tai positiivisen!
        }

        return (this.budjetti / 30) * a * b;     // Pitää vielä tutkia tätä humalan ja tipin suhdetta, tällä hetkellä humalainen saattaa heittää kolmannen ruokalajin jälkeen ihan järjettömiä summia pöytään. Sitäpaitsi tippi meni nyt miinukselle vaikka ei saisi.
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

    private int onkoSuosikkiRypale(Viini viini) {

        if (onkoRypaleetListalla(maku.getSuosikki(), viini.getRypaleet())) {             // Teoriassa on mahdollista että samassa viinissä on suosikkia JA inhokkia, mutta suosikki voittaa tässä tapauksessa.
            return 20;
        } else if (onkoRypaleetListalla(maku.getInhokki(), viini.getRypaleet())) {
            return - 20;
        }

        return 0;
    }

    private int sopiikoRuokalajille(Viini viini, Ruokalaji rl) {

        int kerroin = 10 - level;
        if (level >= 11) {           // Ettei vahingossa tuu vääränmerkkinen kerroin jos asiakkaan leveli nousee liian korkealle, tosin levelcap on ainakin alustavasti 10
            kerroin = 0;
        }

        if (onkoRypaleetListalla(viini.getRypaleet(), rl.getPerfetto())) {           // Mitä matalampi leveli, sitä parempi reaktio hyvään viiniin - pitäähän sitä jotain vaikeustasoa olla
            return 10 + kerroin;
        } else if (onkoRypaleetListalla(viini.getRypaleet(), rl.getKamala())) {      // Korkeamman levelin asiakkaat reagoi isommalla negatiivisella huonosti sopivaan kuin matalamman, trolololoo
            return -(level * 2);
        }

        return 0;
    }

    private int onkoLiianKallistaTaiHalpaa(Viini viini) {

        if (viini.getHinta() < maku.getAlaraja() || viini.getHinta() > maku.getYlaraja()) {      // jos viini on liian halpa tai kallis
            return -10;
        }

        return 0;
    }

    public int getHumala() {
        return humala;
    }

    public int getTyytyvaisyys() {
        return tyytyvaisyys;
    }

    public int getLevel() {
        return level;
    }

}
