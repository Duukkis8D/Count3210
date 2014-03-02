
package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedostonlukijaTest {
    private Tiedostonlukija lukija;
    
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
        lukija = new Tiedostonlukija("testi.data");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void onkoTiedostoaPalauttaaTrueJosTiedostoOnLuotu() throws IOException {
        File tiedosto = new File("testi.data");
        tiedosto.createNewFile();
        
        assertEquals(lukija.onkoTiedostoa(), true);
        tiedosto.delete();
    }
    
    @Test
    public void onkoTiedostossaTapahtumia() throws IOException {
        FileWriter kirjoittaja = new FileWriter("testi.data", true);
        kirjoittaja.append("Tapahtuma;2055;4;12;20;50;30;toistuvuus?\n");
        kirjoittaja.append("Tapahtuma 2;2056;3;11;12;45;50;toistuvuus?\n");
        kirjoittaja.close();
        
        ArrayList<Tapahtuma> tapahtumat = lukija.tuoLahtolaskentalaskurit();
        assertEquals(tapahtumat.size(), 2);
        lukija.getTiedosto().delete();
    }
}
