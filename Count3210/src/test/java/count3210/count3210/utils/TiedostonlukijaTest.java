
package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.joda.time.DateTime;
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
    public void luettujenRivienMaaraOikea() throws IOException {
        FileWriter kirjoittaja = new FileWriter("testi.data", true);
        kirjoittaja.append("Tapahtuma;2055;4;12;20;50;30;toistuvuus?\n");
        kirjoittaja.append("Tapahtuma 2;2056;3;11;12;45;50;toistuvuus?\n");
        kirjoittaja.close();
        
        ArrayList<Tapahtuma> tapahtumat = lukija.tuoLahtolaskentalaskurit();
        assertEquals(tapahtumat.size(), 2);
        lukija.getTiedosto().delete();
    }
    
    @Test
    public void tapahtumaAjatLuetaanOikein() throws IOException {
        FileWriter kirjoittaja = new FileWriter("testi.data", true);
        String kirjoitettavaTapahtuma1 = "Tapahtuma;2055;4;12;20;50;30;toistuvuus?\n";
        String kirjoitettavaTapahtuma2 = "Tapahtuma 2;2056;3;11;12;45;50;toistuvuus?\n";
        kirjoittaja.append(kirjoitettavaTapahtuma1);
        kirjoittaja.append(kirjoitettavaTapahtuma2);
        kirjoittaja.close();
        
        ArrayList<Tapahtuma> tapahtumat = lukija.tuoLahtolaskentalaskurit();
        DateTime tapahtuma1 = tapahtumat.get(0).getTapahtumaAika();
        DateTime tapahtuma2 = tapahtumat.get(1).getTapahtumaAika();
        
        String tapahtuma1Luettuna =
                + tapahtuma1.getYear() + ";"
                + tapahtuma1.getMonthOfYear() + ";"
                + tapahtuma1.getDayOfMonth() + ";"
                + tapahtuma1.getHourOfDay() + ";"
                + tapahtuma1.getMinuteOfHour() + ";"
                + tapahtuma1.getSecondOfMinute();
        
        String tapahtuma2Luettuna =
                + tapahtuma2.getYear() + ";"
                + tapahtuma2.getMonthOfYear() + ";"
                + tapahtuma2.getDayOfMonth() + ";"
                + tapahtuma2.getHourOfDay() + ";"
                + tapahtuma2.getMinuteOfHour() + ";"
                + tapahtuma2.getSecondOfMinute();
        
        assertEquals(tapahtuma1Luettuna, kirjoitettavaTapahtuma1.substring(10, 28));
        assertEquals(tapahtuma2Luettuna, kirjoitettavaTapahtuma2.substring(12, 30));
        lukija.getTiedosto().delete();
    }
    
    @Test
    public void toistuvuusLuetaanOikein() throws IOException {
        FileWriter kirjoittaja = new FileWriter("testi.data", true);
        String kirjoitettavaTapahtuma1 = "Tapahtuma;2055;4;12;20;50;30;toistuvuus?\n";
        String kirjoitettavaTapahtuma2 = "Tapahtuma 2;2056;3;11;12;45;50;toistuvuus?\n";
        kirjoittaja.append(kirjoitettavaTapahtuma1);
        kirjoittaja.append(kirjoitettavaTapahtuma2);
        kirjoittaja.close();
        
        ArrayList<Tapahtuma> tapahtumat = lukija.tuoLahtolaskentalaskurit();
        String tapahtuma1Toistuvuus = tapahtumat.get(0).getToistuvuus();
        String tapahtuma2Toistuvuus = tapahtumat.get(1).getToistuvuus();
        
        assertEquals(tapahtuma1Toistuvuus, kirjoitettavaTapahtuma1.substring(29, 40));
        assertEquals(tapahtuma2Toistuvuus, kirjoitettavaTapahtuma2.substring(31, 42));
        lukija.getTiedosto().delete();
    }
    
    @Test
    public void onkoLukijaSuljettuLukumisenJalkeen() throws IOException {
        FileWriter kirjoittaja = new FileWriter("testi.data", true);
        kirjoittaja.append("Tapahtuma;2055;4;12;20;50;30;toistuvuus?\n");
        kirjoittaja.append("Tapahtuma 2;2056;3;11;12;45;50;toistuvuus?\n");
        kirjoittaja.close();
        
        ArrayList<Tapahtuma> tapahtumat = lukija.tuoLahtolaskentalaskurit();
        
//        assertEquals(lukija.getLukija().ONKOSULJETTU)
    }
}
