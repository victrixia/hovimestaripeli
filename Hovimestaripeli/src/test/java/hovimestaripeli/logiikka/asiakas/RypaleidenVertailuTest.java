

package hovimestaripeli.logiikka.asiakas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * "About as effective as a cat-flap in an elephant house."
 * @author amparkki
 */
public class RypaleidenVertailuTest {
    
    private RypaleidenVertailu vertaa = new RypaleidenVertailu();

    public RypaleidenVertailuTest() {
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
    public void onkoRypaleListallaPalauttaaFalseJosRypaleEiListalla() {
        String[] a = new String[]{"Riesling", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Carmenere", "Tempranillo"};

        assertEquals(false, vertaa.onkoRypaleetListalla(a, b));

    }

    @Test
    public void onkoRypaleListallaPalauttaaTrueJosRypaleOnListalla() {
        String[] a = new String[]{"Malbec", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Carmenere", "Tempranillo"};

        assertEquals(true, vertaa.onkoRypaleetListalla(a, b));

    }

    @Test
    public void onkoRypaleListallaPalauttaaTrueJosListallaUseampiSamaRypale() {
        String[] a = new String[]{"Malbec", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Pinot Noir", "Tempranillo"};

        assertEquals(true, vertaa.onkoRypaleetListalla(a, b));
    }

}