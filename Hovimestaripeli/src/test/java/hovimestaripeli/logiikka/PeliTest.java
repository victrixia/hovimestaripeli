package hovimestaripeli.logiikka;

import hovimestaripeli.logiikka.asiakas.Asiakas;
import hovimestaripeli.logiikka.asiakas.Maku;
import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
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
 *
 * @author amparkki
 */
public class PeliTest {

    Peli peli;
    Viini v;
    Ruokalaji rl;

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
        peli = new Peli();
        Hovimestari hm = new Hovimestari();
        peli.setHovimestari(hm);
        
        v = new Viini();
        rl= new Ruokalaji();
        
    }

    @After
    public void tearDown() {
    }

    @Test
    public void uusiKierrosKasvattaaKierroslukua(){
    
        peli.uusiKierros();
        
        assertEquals(2, peli.getKierrosluku());
    
    }
    
    @Test 
    public void uusiKierrosKomennonJalkeenKierrosNollaantuu(){
        peli.getKierros().siirrySeuraavaanRuokalajiin();
        peli.uusiKierros();
        assertEquals(peli.getKierros().getVaihe(), 1);
    }
    
  
}
