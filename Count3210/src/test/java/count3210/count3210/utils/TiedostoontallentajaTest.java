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
        DateTime aika = DateTime.now();
        String tapahtumanNimi = "Tapahtuma";
        Tapahtuma tapahtuma = new Tapahtuma(tapahtumanNimi);
        tapahtuma.setTapahtuma(aika);
    
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja();
        tallentaja.tallennaTiedostoon(tapahtuma);
    
        tiedosto = tallentaja.getTiedosto();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void tiedostoonTallennuksenJalkeenTiedostoOnOlemassa() {
        
        assertEquals(tiedosto.exists(), true);
    }
    
    @Test
    public void tiedostoonTallennuksenJalkeenTiedostoSisaltaaJotain() throws FileNotFoundException {
        // Lue tässä, että tiedostossa on jotain sisältöä (char).
        Scanner lukija = new Scanner(tiedosto);
        
    }
}
