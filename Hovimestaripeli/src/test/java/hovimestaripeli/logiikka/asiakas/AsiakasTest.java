package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.tarjottavat.Viini;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ""
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

        Asiakas a = new Asiakas("asiakas", 200, new Maku());

        assertEquals(0, a.getHumala());
    }

    @Test
    public void asiakasHumaltuuOikein() {

        Asiakas a = new Asiakas("asiakas", 200, new Maku());
        
        Viini v = new Viini();
        
        a.humallu(v);
        
        assertEquals(24, a.getHumala());

    }
}
