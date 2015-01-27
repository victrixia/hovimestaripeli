
package hovimestaripeli.logiikka.tarjottavat;

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
public class ViiniTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void toStringToimiiOikein(){
    
        Viini v = new Viini();
        
        assertEquals(v.toString(), "Valkoviini, Saksa. Rypäleet: Riesling. Hinta: 10€, Laatu: 4 tähteä, Alkoholiprosentti: 12.");
    
    }
    
    @Test 
    public void toStringToimiiOikeinUseallaRypaleella(){
    
         Viini chardonnay = new Viini(2, new String[]{"Chardonnay", "Viognier"}, 7, 3, 14, "USA");
         
         assertEquals(chardonnay.toString(), "Valkoviini, USA. Rypäleet: Chardonnay, Viognier. Hinta: 7€, Laatu: 3 tähteä, Alkoholiprosentti: 14.");
        
    }
}
