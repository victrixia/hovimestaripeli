/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hovimestaripeli.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
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

    
    @Test public void HovimestarinNimiOnOikein(){
    
        Hovimestari hm = new Hovimestari("Carson");
        
        assertEquals("Carson", hm.getNimi());
    }
    
    @Test public void HovimestarinTippiOnAlussaNolla(){
    
        Hovimestari hm = new Hovimestari();
        assertEquals(0, hm.getTippi());
    }
}
