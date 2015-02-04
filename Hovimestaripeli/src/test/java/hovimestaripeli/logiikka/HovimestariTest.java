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
    
     Hovimestari hm;

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
        hm = new Hovimestari();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void HovimestarinNimiOnOikein() {

        Hovimestari c = new Hovimestari("Carson");

        assertEquals("Carson", c.getNimi());
    }

    @Test
    public void HovimestarinTippiOnAlussaNolla() {

       
        assertEquals(0, hm.getTippi());
    }

    @Test
    public void TippiEiAlitaNollaa() {


        hm.muutaTippia(-10);

        assertEquals(0, hm.getTippi());
    }
    
    @Test
    public void tippiKasvaaKunAnnettavaTippiPositiivinen(){
    
        hm.muutaTippia(10);
        
        assertEquals(10, hm.getTippi());
        
    }
    
    @Test 
    public void tippiVaheneeKunAnnettavaTippiNegatiivinen(){
         
        hm.muutaTippia(12);
        hm.muutaTippia(-3);
        
        assertEquals(9, hm.getTippi());
    }

    @Test
    public void tippiVoiPudotaTasanNollaan() {

        
        hm.muutaTippia(10);
        hm.muutaTippia(-10);
        assertEquals(0, hm.getTippi());
    }

}
