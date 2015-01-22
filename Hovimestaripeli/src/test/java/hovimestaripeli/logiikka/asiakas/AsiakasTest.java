package hovimestaripeli.logiikka.asiakas;

import hovimestaripeli.logiikka.tarjottavat.Viini;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * "About as effective as a cat-flap in an elephant house."
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
    
    @Test
    public void asiakasReagoiViiniinOikein(){
        Asiakas a = new Asiakas("asiakas", 200, new Maku());
        
        Viini v = new Viini();
        
        a.reagoi(v);
        
        assertEquals (27, a.getTyytyvaisyys());
    
    }
    
    @Test 
    public void asiakasTippaaOikein(){
        
        Asiakas a = new Asiakas("asiakas", 200, new Maku());
        
        Viini v = new Viini();
        
        a.humallu(v);
        a.reagoi(v);
        
        assertEquals(24, a.annaTippiä());
        
       
    }
    
    @Test
    public void onkoRypaleListallaPalauttaaFalseJosRypaleEiListalla(){
        String[] a = new String[]{"Riesling", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Carmenere","Tempranillo"};
        
        Asiakas as = new Asiakas("asiakas", 100, new Maku());
        
        assertEquals(false, as.onkoRypaleetListalla(a, b));
    
    }
    
     @Test
    public void onkoRypaleListallaPalauttaaTrueJosRypaleOnListalla(){
        String[] a = new String[]{"Malbec", "Pinot Noir", "Garganega"};
        String[] b = new String[]{"Malbec", "Carmenere","Tempranillo"};
        
        Asiakas as = new Asiakas("asiakas", 100, new Maku());
        
        assertEquals(true, as.onkoRypaleetListalla(a, b));
    
    }
    
}
