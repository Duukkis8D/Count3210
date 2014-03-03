package count3210.count3210.utils;

import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TapahtumaAikakentanLukijaTest {
    private JTextField paivays;
    private int[] tapahtumaAika;

    public TapahtumaAikakentanLukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // pp:kk:vvvv,tt:mm:ss
        paivays = new JTextField();
        paivays.setText("11:12:2100,21:00:00");
        
        TapahtumaAikakentanLukija lukija = new TapahtumaAikakentanLukija(paivays);
        tapahtumaAika = lukija.lueGUI();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void vuorokaudetLuetaanOikein() {
        // Taulukon ensimmäinen arvo esittää vuorokausien lukumäärää.
        assertEquals(tapahtumaAika[0], 11);
    }
    
    @Test
    public void kuukaudetLuetaanOikein() {
        // Taulukon toinen arvo esittää kuukausien lukumäärää.
        assertEquals(tapahtumaAika[1], 12);
    }
    
    @Test
    public void vuodetLuetaanOikein() {
        // Taulukon kolmas arvo esittää vuosien lukumäärää.
        assertEquals(tapahtumaAika[2], 2100);
    }
    
    @Test
    public void tunnitLuetaanOikein() {
        // Taulukon neljäs arvo esittää tuntien lukumäärää.
        assertEquals(tapahtumaAika[3], 21);
    }
    
    @Test
    public void minuutitLuetaanOikein() {
        // Taulukon viides arvo esittää minuuttien lukumäärää.
        assertEquals(tapahtumaAika[4], 0);
    }
    
    @Test
    public void sekunnitLuetaanOikein() {
        // Taulukon kuudes eli viimeinen arvo esittää sekuntien lukumäärää.
        assertEquals(tapahtumaAika[5], 0);
    }
}
