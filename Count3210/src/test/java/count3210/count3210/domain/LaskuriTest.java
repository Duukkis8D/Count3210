
package count3210.count3210.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaskuriTest {
    Laskuri sekunnit;
    Laskuri minuutit;
    Laskuri tunnit;
    Laskuri laskuri;
    
    public LaskuriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sekunnit = new Laskuri(59);
        laskuri = new Laskuri(0);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void laskurinArvoAluksiNolla() {
        assertEquals(0, laskuri.getArvo());
    }
    
    @Test
    public void laskurinArvoOikeinAsetuksellaNolla() {
        laskuri.asetaArvo(0);
        assertEquals(0, laskuri.getArvo());
    }
    
    @Test
    public void laskurinArvoOikeinAsetuksellaYksi() {
        laskuri.asetaArvo(1);
        assertEquals(1, laskuri.getArvo());
    }
    
    @Test
    public void laskurinArvoOikeinAsetuksellaMiinusYksi() {
        laskuri.asetaArvo(-1);
        assertEquals(0, laskuri.getArvo());
    }
    
    @Test
    public void laskurinArvoMerkkijononaNakyyOikeinArvollaYksi() {
        laskuri.asetaArvo(1);
        assertEquals("01", laskuri.toString());
    }
    
    @Test
    public void laskurinArvoMerkkijononaNakyyOikeinArvollaKymmenen() {
        laskuri.asetaArvo(10);
        assertEquals("10", laskuri.toString());
    }
    
    @Test
    public void sekunnitYlarajaOikein() {
        assertEquals(59, sekunnit.getYlaraja());
    }
}
