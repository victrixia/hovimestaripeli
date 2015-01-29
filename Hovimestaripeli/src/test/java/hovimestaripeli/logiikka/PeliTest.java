

package hovimestaripeli.logiikka;

import hovimestaripeli.logiikka.tarjottavat.Viini;
import hovimestaripeli.varasto.*;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * "About as effective as a cat-flap in an elephant house."
 * Aika moni metodi lähinnä kutsuu muita metodeja joita on jo testattu tai jotka liittyvät käyttöliittymään. En oikein keksi, kuinka testata niitä!
 * @author amparkki
 */
public class PeliTest {

    public PeliTest() {
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
    public void viinienArpominenTuottaaOikeanKokoisenListan(){
        Peli peli = new Peli();
        ArrayList<Viini> viinit = peli.arvoViinit();
        
        assertEquals(3, viinit.size());
    }
    
    @Test 
    public void arvotullaViinilistallaEiSamojaViineja(){
        Peli peli = new Peli();
        ArrayList<Viini> viinit = peli.arvoViinit();
        
        Viini a = viinit.get(0);
        Viini b = viinit.get(1);
        Viini c = viinit.get(2);
        
        assertEquals (false, (a.equals(b) && b.equals(c) && c.equals(a)));
    
    }
    
    

}