/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package count3210.count3210.utils;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author duukkis
 */
public class TiedostonlukijaTest {
    
    public TiedostonlukijaTest() {
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
    public void onkoTiedostoaPalauttaaTrue() {
        Tiedostonlukija lukija = new Tiedostonlukija();
        
        assertEquals(lukija.onkoTiedostoa(), true);
    }
}
