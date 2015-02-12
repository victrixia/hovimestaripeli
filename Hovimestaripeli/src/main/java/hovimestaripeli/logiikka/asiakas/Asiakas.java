package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.tarjottavat.*;

/**
 * Asiakas on pelin NPC-hahmo, jota hovimestarin tulee miellyttää saadakseen mahdollisimman
 * korkea tippi. Asiakkaalla on nimi, budjetti jonka perusteella lasketaan tippi, ja jonka ylittäminen
 * asettaa asiakkaan noloon tilanteeseen - ja mikä pahinta, pilaa kierroksen pisteet. 
 * Asiakkaalla on myös Maku, joka määrittelee hänen mieltymyksensä ja yksittäisten lasien ala-
 * ja ylähintarajat.
 * 
 * Asiakas humaltuu nauttiessaan alkoholipitoisia juomia, ja hänen reaktionsa kasvavat 
 * humalatilan myötä. Kuitenkin jos humalatila kasvaa yli 150:n (eli 1.5 promillen), asiakas 
 * alkaa käyttäytyä häiritsevästi ja poistetaan ravintolasta - mikä sekin johtaa kierroksen 
 * häviämiseen.
 * 
 * Asiakkaalla on myös vaikeustaso, joka vaikuttaa hänen reaktioihinsa. Tasojen 1-3 asiakkaat
 * eivät osaa reagoida ruuan ja viinin yhteensopivuuteen.
 * 
 * Asiakkaan tyytyväisyys vaihtelee välillä -100 - 100, ja vaikuttaa tipin määrään. 
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

    /**
     * Asiakkaan humalatilaa kasvatetaan nautitun viinin alkoholiprosentin perusteella.
     * 
     * @param viini 
     */
    
    public void humallu(Viini viini) {       // asiakkaan humalatilan lisäys yhden juoman jäljiltä. Parametriksi tulee Viinin parametri 'vahvuus'.

        int lisays = 2 * viini.getVahvuus();

        this.humala += lisays;
    }
    
    /**
     * Luokan päämetodi, joka kutsuu kaikkia muita tarjoiltuun viiniin liittyviä metodeita 
     * ja lopuksi määrittelee asiakkaan tyytyväisyyden kierroksen jälkeen. Tämä taas vaikuttaa
     * suoraan annetun tipin määrään.
     * @param viini
     * @param rl 
     */

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

    /**
     * Metodi laskee hovimestarin tipin yhden kierroksen osalta. Tipin määrään vaikuttavat 
     * asiakkaan tyytyväisyys, humalatila ja budjetti. Tippi voi olla myös negatiivinen, mutta
     * tällöin korkeintaan samansuuruinen kuin jo olemassa olevat tippi, eli kokonaistippi ei
     * voi laskea alle nollan. 
     * 
     * @param hovimestarinTippi
     * @return summa, jolla hovimestarin tippiä muutetaan. 
     */
    
    public int annaTippiä(int hovimestarinTippi) {            // tippi lasketaan uudelleen joka ruokalajin välissä

        int a = 1;
        int b = 1;

        if (this.humala > 20) {         // 0.2 promillen tai sitä korkeampi humala nostaa tippikerrointa
            a = this.humala / 10;
        }

        if (this.tyytyvaisyys != 0) {
            b = this.tyytyvaisyys / 10;   // Jos tyytyväisyys ei ole nolla, tyytyväisyys tai tyytymättömyys antaa myös tippikertoimen - negatiivisen tai positiivisen!
        }
        
        int tippi = (this.budjetti / 30) * a * b;
        
        if ((hovimestarinTippi + tippi) < 0){
            tippi = -hovimestarinTippi;
        }

        return tippi;     // Pitää vielä tutkia tätä humalan ja tipin suhdetta, tällä hetkellä humalainen saattaa heittää kolmannen ruokalajin jälkeen ihan järjettömiä summia pöytään. Sitäpaitsi tippi meni nyt miinukselle vaikka ei saisi.
    }
    
    /**
     * Yleismetodi tutkii, onko kahdessa String[]:issa samansisältöisiä alkioita, eli suomeksi 
     * sanottuna tarkistaa, onko jokin rypäle jollakin toisella listalla: esimerkiksi tarjottavan
     * viinin rypäleet asiakkaan suosikki- tai inhokkilistalla, tai ruokalajille erityisen hyvin sopivien
     * viinien listalla.
     * 
     * @param omaMaku
     * @param viininRypaleet
     * @return true jos yksikin rypäle löytyy listalta, muuten false
     */

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
    
    /**
     * Tutkii, onko viini asiakkaan suosikki- tai inhokkilistalla. Suosikki päihittää inhokin, eli 
     * siinä tapauksessa että viinissä on sekä suosikki- että inhokkirypälettä, annetaan
     * pisteet suosikin mukaan.
     * 
     * @param viini
     * @return -20 tai 20 pistettä jos viini löytyy jommalta kummalta listalta, muuten 0.
     */

    public int onkoSuosikkiRypale(Viini viini) {

        if (onkoRypaleetListalla(maku.getSuosikki(), viini.getRypaleet())) {             // Teoriassa on mahdollista että samassa viinissä on suosikkia JA inhokkia, mutta suosikki voittaa tässä tapauksessa.
            return 20;
        } else if (onkoRypaleetListalla(maku.getInhokki(), viini.getRypaleet())) {
            return - 20;
        }

        return 0;
    }
    
    /**
     * Tutkii viinin sopivuuden ruokalajille ja suhteuttaa pistemäärän asiakkaan 
     * vaikeustason mukaan. Viinin sopivasta väristä saa hieman lisäpisteitä jos 
     * viini ei muuten ole sopivien listalla. 
     * 
     * @param viini
     * @param rl
     * @return negatiivisen tai positiivisen pistemäärän mikäli viini löytyy ruokalajille sopivien tai epäsopivien
     * viinien listalta; 3 jos on sopivan värinen eikä muuta; 0 mikäli viini on ruokalajin
     * kannalta täysin yhdentekevä.
     */

    public int sopiikoRuokalajille(Viini viini, Ruokalaji rl) {
        int lahto = 0;
        int kerroin = 10 - level;
        if (level >= 11) {           // Ettei vahingossa tuu vääränmerkkinen kerroin jos asiakkaan leveli nousee liian korkealle, tosin levelcap on ainakin alustavasti 10
            kerroin = 0;
        }
        if (viini.getVari() == rl.getViinityyppi()){
            lahto = 3;
        }
        if (onkoRypaleetListalla(viini.getRypaleet(), rl.getPerfetto())) {           // Mitä matalampi leveli, sitä parempi reaktio hyvään viiniin - pitäähän sitä jotain vaikeustasoa olla
            return lahto + 10 + kerroin;
        } else if (onkoRypaleetListalla(viini.getRypaleet(), rl.getKamala())) {      // Korkeamman levelin asiakkaat reagoi isommalla negatiivisella huonosti sopivaan kuin matalamman, trolololoo
            return -(level * 2);
        }

        return lahto;
    }
    
    /**
     * vertaa viinilasin hintaa asiakkaan ala- ja ylärajoihin. Mikäli lasillisen 
     * hinta on liian korkea tai matala, tulee miinuspisteitä.
     * 
     * @param viini
     * @return -10 jos viini on liian halpa tai kallis, muuten 0.
     */

    public int onkoLiianKallistaTaiHalpaa(Viini viini) {

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

    @Override
    public String toString(){
        
        // Tähän lisätään vielä jokaiseen asiakkaaseen liittyvä lyhyt kuvaus, joka antaa pelaajalle vinkkiä
        // siitä, mitä kannattaisi lähteä suosittelemaan.
        return nimi + " Level " + level; 
    }
}
