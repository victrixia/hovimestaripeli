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
public class RuokalajiTest {

    Ruokalaji rl;

    public RuokalajiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        rl = new Ruokalaji(2, "Osso Bucco", new String[]{"Soave"}, new String[]{"Gewürztraminer"}, ViininVari.PUNA);
    }

    @After
    public void tearDown() {
    }

     @Test
    public void ruokalajinTyyppiPalautuuOikein() {

        assertEquals(2, rl.getTyyppi());

    }

    @Test
    public void ruokalajinKuvausOnOikein() {
        assertEquals("Osso Bucco", rl.getKuvaus());
    }
}
