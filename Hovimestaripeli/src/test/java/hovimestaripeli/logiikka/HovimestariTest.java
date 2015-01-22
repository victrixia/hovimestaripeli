package hovimestaripeli.logiikka;

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
public class HovimestariTest {

    public HovimestariTest() {
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
    public void HovimestarinNimiOnOikein() {

        Hovimestari hm = new Hovimestari("Carson");

        assertEquals("Carson", hm.getNimi());
    }

    @Test
    public void HovimestarinTippiOnAlussaNolla() {

        Hovimestari hm = new Hovimestari();
        assertEquals(0, hm.getTippi());
    }

    @Test
    public void TippiEiAlitaNollaa() {

        Hovimestari hm = new Hovimestari();

        hm.setTippi(-10);

        assertEquals(0, hm.getTippi());
    }

    @Test
    public void tippiVoiPudotaTasanNollaan() {

        Hovimestari hm = new Hovimestari();
        hm.setTippi(10);
        hm.setTippi(-10);
        assertEquals(0, hm.getTippi());
    }

}
