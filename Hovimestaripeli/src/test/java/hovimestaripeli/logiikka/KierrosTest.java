

package hovimestaripeli.logiikka;

import hovimestaripeli.logiikka.tarjottavat.Ruokalaji;
import hovimestaripeli.logiikka.tarjottavat.Viini;
import java.util.ArrayList;
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
public class KierrosTest {
    
    private Peli peli;
    private Viini v;
    private Ruokalaji rl;
    private Kierros kierros;

    public KierrosTest() {
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
        kierros = peli.getKierros();
        
        v = new Viini();
        rl= new Ruokalaji();
    }

    @After
    public void tearDown() {
    }

   
    @Test
    public void viinienArpominenTuottaaOikeanKokoisenListan() {

        ArrayList<Viini> viinit = kierros.arvoViinit();

        assertEquals(3, viinit.size());
    }

    @Test
    public void arvotullaViinilistallaEiSamojaViineja() {
        
        ArrayList<Viini> viinit = kierros.arvoViinit();

        Viini a = viinit.get(0);
        Viini b = viinit.get(1);
        Viini c = viinit.get(2);

        assertEquals(false, (a.equals(b) && b.equals(c) && c.equals(a)));

    }
    
      @Test
    public void valitaReaktionJalkeenAsiakkaanReaktioOikein(){
       kierros.valitaReaktio(v);
        
        assertEquals(27, peli.getAsiakas().getTyytyvaisyys());
    
    }
    
    @Test
    public void valitaReaktionJalkeenAsiakkaanPotentiaalinenTippiOnKasvanutOikein(){
        kierros.valitaReaktio(v);
        
        assertEquals(12, kierros.getTippi());
    
    }
    
    @Test
    public void hovimestarinTippiEiKasvaAlkuJaPaaRuuanAikana(){
        kierros.valitaReaktio(v);
        kierros.siirrySeuraavaanRuokalajiin();
        kierros.valitaReaktio(v);
        
        assertEquals(0, peli.getHovimestari().getTippi());
    
    }
    
    @Test 
    public void hovimestarinTippiKasvaaJalkiruuanJalkeenJosAihetta(){
        kierros.valitaReaktio(v);
        kierros.setVaihe(3);
        kierros.siirrySeuraavaanRuokalajiin();
        
        assertTrue(peli.getHovimestari().getTippi() > 0);
    
    }

}