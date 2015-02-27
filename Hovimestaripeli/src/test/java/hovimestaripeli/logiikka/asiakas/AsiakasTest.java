package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.Hovimestari;
import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import hovimestaripeli.logiikka.tarjottavat.ViininVari;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * "About as effective as a cat-flap in an elephant house."
 *
 * @author amparkki
 */
public class AsiakasTest {

    Asiakas as;
    Viini v;
    Hovimestari hm;
    Ruokalaji rl;
    Ruokalaji kanapasta;
    Viini chardonnay;

    public AsiakasTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        as = new Asiakas("asiakas", 200, new Maku(), 1, "testi", null);
        v = new Viini();
        hm = new Hovimestari();
        rl = new Ruokalaji();
        kanapasta = new Ruokalaji(2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, ViininVari.VALKO);
        chardonnay = new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void humalaAlussaNolla() {

        assertEquals(0, as.getHumala());
    }

    @Test
    public void asiakasHumaltuuOikein() {

        as.humallu(v);

        assertTrue(as.getHumala() >= 24);

    }

    @Test
    public void asiakasReagoiViiniinOikein() {

        as.reagoi(v, rl);

        assertEquals(27, as.getTyytyvaisyys());

    }

    @Test                                         
    public void asiakasTippaaOikein() {

        as.humallu(v);

        as.reagoi(v, rl);

        assertTrue(as.annaTippiä(hm.getTippi()) >= 48);      // okei tää on liikaa, pitää tasapainottaa

    }

    @Test
    public void tippiEiPutoaMiinukselle() {

        Viini hyh = new Viini(ViininVari.PUNA, new String[]{"Cabernet Sauvignon"}, 20, 0, 14, "Venäjä");     // trololol

        as.reagoi(hyh, rl);
        int tippi = hm.getTippi();
        hm.muutaTippia(as.annaTippiä(tippi));

        assertEquals(0, hm.getTippi());

    }

    @Test
    public void asiakkaanLevelVaikuttaaTyytyvaisyyteen() {
        Maku uusimaku = new Maku(ViininVari.VALKO, new String[]{"Chardonnay", "Pinot Noir", "Pinot Grigio"}, new String[]{"Tempranillo"}, 5, 15);
        Asiakas a = new Asiakas("ABC", 100, uusimaku, 3, null, null);
        Asiakas b = new Asiakas("ABC", 100, uusimaku, 4, null, null);

        a.reagoi(chardonnay, kanapasta);
        b.reagoi(chardonnay, kanapasta);

        assertTrue(a.getTyytyvaisyys() != b.getTyytyvaisyys());

    }


    @Test
    public void josViiniEiOleSuosikkiEikaMuutenkaanHerataIntohimojaReaktioOnYksiPlusLaatu() {

        Viini vi = new Viini(ViininVari.ROSEE, new String[]{"Viinirypäle"}, 10, 2, 14, "Eurooppa");

        as.reagoi(vi, rl);

        assertEquals(as.getTyytyvaisyys(), 3);

    }

    @Test
    public void onkoLiianKallistaTaiHalpaaPalauttaaNegatiivistaKunViiniOnLiianHalpa() {

        Viini meh = new Viini(ViininVari.PUNA, new String[]{"Viinirypäle"}, 1, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(meh);

        assertEquals(-10, a);
    }

    @Test
    public void onkoLiianKallistaTaiHalpaaPalauttaaNegatiivistaKunViiniOnLiianKallis() {

        Viini huh = new Viini(ViininVari.PUNA, new String[]{"Viinirypäle"}, 100, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(huh);

        assertEquals(-10, a);
    }

    @Test
    public void kalleusTestiPalauttaaNollaKunViininHintaYlarajalla() {

        Viini v = new Viini(ViininVari.PUNA, new String[]{"Viinirypäle"}, 20, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(v);

        assertEquals(0, a);

    }

    @Test
    public void kalleusTestiPalauttaaNollaKunViininHintaAlarajalla() {

        Viini v = new Viini(ViininVari.PUNA, new String[]{"Viinirypäle"}, 7, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(v);

        assertEquals(0, a);

    }

    @Test
    public void ruokalajinSopivuusViiniinVaikuttaaPositiivisesti() {
        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 4, "testi", null);
        
        int a = as.sopiikoRuokalajille(chardonnay, kanapasta);

        assertTrue((a > 10));
    }

    @Test
    public void ruokalajinSopimattomuusViiniinVaikuttaaNegatiivisesti() {
        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 4, "testi", null);

        Viini tempranillo = new Viini(ViininVari.PUNA, new String[]{"Tempranillo"}, 7, 3, 14, "Espanja");

        int a = as.sopiikoRuokalajille(tempranillo, kanapasta);

        assertTrue((a < 0));
    }

    @Test
    public void josViiniEiOleHyvaEikaHuonoMuttaOikeaaVariaSaaPienenBonuksen() {
        Asiakas wau = new Asiakas("asiakas", 100, new Maku(), 4, "testi", null);
       
        Viini valkkari = new Viini(ViininVari.VALKO, new String[]{"Rypäle"}, 7, 3, 14, "Espanja");

        int a = wau.sopiikoRuokalajille(valkkari, kanapasta);

        assertEquals(3, a);

    }

}
