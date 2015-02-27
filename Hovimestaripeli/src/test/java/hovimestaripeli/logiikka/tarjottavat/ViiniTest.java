package hovimestaripeli.logiikka.tarjottavat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * "About as effective as a cat-flap in an elephant house."
 *
 * @author amparkki
 */
public class ViiniTest {

    Viini chardonnay;

    public ViiniTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        chardonnay = new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void toStringToimiiOikein() {
        // Tätä ei liene järjellistä testata joka värille erikseen o_O

        Viini v = new Viini();

        assertEquals(v.toString(), "Valkoviini, Saksa. Rypäleet: Riesling. Hinta: 10€, Laatu: 4 tähteä, Alkoholiprosentti: 12.");

    }

    @Test
    public void toStringToimiiOikeinUseallaRypaleella() {

        assertEquals(chardonnay.toString(), "Valkoviini, USA. Rypäleet: Chardonnay, Viognier. Hinta: 7€, Laatu: 3 tähteä, Alkoholiprosentti: 14.");

    }

    @Test
    public void equalsPalauttaaTrueJosViinitSamoja() {
        Viini a = chardonnay;
        Viini b = chardonnay;

        assertTrue(a.equals(b));

    }

    @Test
    public void equalsPalauttaaFalseJosViinitEriVahvuisia() {
        Viini a = chardonnay;
        Viini b = new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Viognier"}, 7, 3, 13, "USA");    // pienikin muutos pitää riittää

        assertFalse(a.equals(b));
    }

    @Test
    public void equalsPalauttaaFalseJosViineissaEriRypaleet() {
        Viini a = chardonnay;
        Viini b = new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Semillon"}, 7, 3, 14, "USA");    // pienikin muutos pitää riittää

        assertFalse(a.equals(b));
    }

    @Test
    public void equalsPalauttaaFalseJosViinitEriHintaisia() {
        Viini a = chardonnay;
        Viini b = new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Viognier"}, 8, 3, 14, "USA");    // pienikin muutos pitää riittää

        assertFalse(a.equals(b));
    }

    @Test
    public void equalsPalauttaaFalseJosViineillaEriLaatu() {
        Viini a = chardonnay;
        Viini b = new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Viognier"}, 7, 1, 14, "USA");    // pienikin muutos pitää riittää

        assertFalse(a.equals(b));
    }

    @Test
    public void equalsPalauttaaFalseJosViinitEriMaasta() {
        Viini a = chardonnay;
        Viini b = new Viini(ViininVari.VALKO, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "Australia");    // pienikin muutos pitää riittää

        assertFalse(a.equals(b));
    }

}
