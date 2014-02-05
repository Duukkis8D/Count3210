package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TiedostoontallentajaTest {
    private File tiedosto;
    
    public TiedostoontallentajaTest() {
        
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
    public void tallennuksenJalkeenTiedostoOnOlemassa() {
        // Tallentaa tiedostoon nykyisen ajan.
        DateTime aika = DateTime.now();
        String tapahtumanNimi = "Tapahtuma";
        Tapahtuma tapahtuma = new Tapahtuma(tapahtumanNimi);
        tapahtuma.setTapahtumaAika(aika);
    
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja();
        tallentaja.tallennaTiedostoon(tapahtuma);
    
        tiedosto = tallentaja.getTiedosto();
        
        assertEquals(tiedosto.exists(), true);
        tiedosto.delete();
    }
    
    @Test
    public void tallennuksenJalkeenTiedostoSisaltaaJotain() throws FileNotFoundException {
        DateTime aika = DateTime.now();
        String tapahtumanNimi = "Tapahtuma";
        Tapahtuma tapahtuma = new Tapahtuma(tapahtumanNimi);
        tapahtuma.setTapahtumaAika(aika);
    
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja();
        tallentaja.tallennaTiedostoon(tapahtuma);
    
        tiedosto = tallentaja.getTiedosto();
        
        Scanner lukija = new Scanner(tiedosto);
        
        StringBuilder tekstiaToivonMukaan = new StringBuilder();
        while (lukija.hasNext()) {
            tekstiaToivonMukaan.append(lukija.next());
        }
       
        assertTrue(tekstiaToivonMukaan.length() > 0);
        tiedosto.delete();
    }
}
