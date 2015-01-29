package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.Hovimestari;
import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
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

    }

    @After
    public void tearDown() {
    }

    @Test
    public void humalaAlussaNolla() {

        Asiakas a = new Asiakas("asiakas", 200, new Maku(), 1);

        assertEquals(0, a.getHumala());
    }

    @Test
    public void asiakasHumaltuuOikein() {

        Asiakas a = new Asiakas("asiakas", 200, new Maku(), 1);

        Viini v = new Viini();

        a.humallu(v);

        assertEquals(24, a.getHumala());

    }

    @Test
    public void asiakasReagoiViiniinOikein() {
        Asiakas a = new Asiakas("asiakas", 200, new Maku(), 1);

        Viini v = new Viini();
        Ruokalaji rl = new Ruokalaji();
        a.reagoi(v, rl);

        assertEquals(27, a.getTyytyvaisyys());

    }

    @Test
    public void asiakasTippaaOikein() {

        Asiakas a = new Asiakas("asiakas", 200, new Maku(), 1);
        Hovimestari hm = new Hovimestari();
        Viini v = new Viini();

        a.humallu(v);
        Ruokalaji rl = new Ruokalaji();
        a.reagoi(v, rl);

        assertEquals(48, a.annaTippiä(hm.getTippi()));      // okei tää on liikaa, pitää tasapainottaa

    }

    @Test
    public void tippiEiPutoaMiinukselle() {

        Asiakas a = new Asiakas("asiakas", 200, new Maku(), 1);
        Hovimestari hm = new Hovimestari();
        Viini v = new Viini(1, new String[]{"Cabernet Sauvignon"}, 20, 0, 14, "Venäjä");     // trololol

        Ruokalaji rl = new Ruokalaji();
        a.reagoi(v, rl);
        int tippi = hm.getTippi();
        hm.muutaTippia(a.annaTippiä(tippi));

        assertEquals(0, hm.getTippi());

    }

    @Test
    public void asiakkaanLevelVaikuttaaTyytyvaisyyteen() {
        Maku uusimaku = new Maku(2, new String[]{"Chardonnay", "Pinot Noir", "Pinot Grigio"}, new String[]{"Tempranillo"}, 5, 15);
        Asiakas a = new Asiakas("ABC", 100, uusimaku, 3);
        Asiakas b = new Asiakas("ABC", 100, uusimaku, 4);

        Ruokalaji kanapasta = new Ruokalaji(1, 2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, 2);

        Viini chardonnay = new Viini(2, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA");
        a.reagoi(chardonnay, kanapasta);
        b.reagoi(chardonnay, kanapasta);

        assertTrue(a.getTyytyvaisyys() != b.getTyytyvaisyys());

    }

    @Test
    public void onkoRypaleListallaPalauttaaFalseJosRypaleEiListalla() {
        String[] a = new String[]{"Riesling", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Carmenere", "Tempranillo"};

        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);

        assertEquals(false, as.onkoRypaleetListalla(a, b));

    }

    @Test
    public void onkoRypaleListallaPalauttaaTrueJosRypaleOnListalla() {
        String[] a = new String[]{"Malbec", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Carmenere", "Tempranillo"};

        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);

        assertEquals(true, as.onkoRypaleetListalla(a, b));

    }

    @Test
    public void onkoRypaleListallaPalauttaaTrueJosListallaUseampiSamaRypale() {
        String[] a = new String[]{"Malbec", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Pinot Noir", "Tempranillo"};

        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);

        assertEquals(true, as.onkoRypaleetListalla(a, b));
    }

    @Test
    public void josViiniEiOleSuosikkiEikaMuutenkaanHerataIntohimojaReaktioOnYksiPlusLaatu() {

        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);
        Viini v = new Viini(1, new String[]{"Viinirypäle"}, 10, 2, 14, "Eurooppa");
        Ruokalaji rl = new Ruokalaji();
        as.reagoi(v, rl);

        assertEquals(as.getTyytyvaisyys(), 3);

    }

    @Test
    public void onkoLiianKallistaTaiHalpaaPalauttaaNegatiivistaKunViiniOnLiianHalpa() {
        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);
        Viini v = new Viini(1, new String[]{"Viinirypäle"}, 1, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(v);

        assertEquals(-10, a);
    }

    @Test
    public void onkoLiianKallistaTaiHalpaaPalauttaaNegatiivistaKunViiniOnLiianKallis() {
        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);
        Viini v = new Viini(1, new String[]{"Viinirypäle"}, 100, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(v);

        assertEquals(-10, a);
    }

    @Test
    public void kalleusTestiPalauttaaNollaKunViininHintaYlarajalla() {
        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);
        Viini v = new Viini(1, new String[]{"Viinirypäle"}, 20, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(v);

        assertEquals(0, a);

    }

    @Test
    public void kalleusTestiPalauttaaNollaKunViininHintaAlarajalla() {
        Asiakas as = new Asiakas("asiakas", 100, new Maku(), 1);
        Viini v = new Viini(1, new String[]{"Viinirypäle"}, 7, 2, 14, "Eurooppa");

        int a = as.onkoLiianKallistaTaiHalpaa(v);

        assertEquals(0, a);

    }
    
    @Test
    public void ruokalajinSopivuusViiniinVaikuttaaPositiivisesti(){
        Asiakas as = new Asiakas ("asiakas", 100, new Maku(), 4);
        Ruokalaji kanapasta = new Ruokalaji(1, 2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, 2);

        Viini chardonnay = new Viini(2, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA");
        
        int a = as.sopiikoRuokalajille(chardonnay, kanapasta);
        
        assertEquals(true,(a >10));
    }
    
    @Test
    public void ruokalajinSopimattomuusViiniinVaikuttaaNegatiivisesti(){
        Asiakas as = new Asiakas ("asiakas", 100, new Maku(), 4);
        Ruokalaji kanapasta = new Ruokalaji(1, 2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, 2);

        Viini tempranillo = new Viini(1, new String[]{"Tempranillo"}, 7, 3, 14, "Espanja");
        
        int a = as.sopiikoRuokalajille(tempranillo, kanapasta);
        
        assertEquals(true,(a < 0));
    }
    
    @Test
    public void josViiniEiOleHyvaEikaHuonoMuttaOikeaaVariaSaaPienenBonuksen(){
       Asiakas as = new Asiakas ("asiakas", 100, new Maku(), 4);
        Ruokalaji kanapasta = new Ruokalaji(1, 2, "Kermainen kanapasta parmesanilla ja kirsikkatomaateilla", new String[]{"Chardonnay", "Viognier"}, new String[]{"Amarone", "Tempranillo", "Carmenere", "Ripasso"}, 2);

        Viini valkkari = new Viini(2, new String[]{"Rypäle"}, 7, 3, 14, "Espanja");
        
        int a = as.sopiikoRuokalajille(valkkari, kanapasta);
        
        assertEquals(3, a);
        
    }

}
