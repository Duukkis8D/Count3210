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
        DateTime aika = DateTime.now();
        aika.plusYears(1);
        String tapahtumanNimi = "Vuoden päästä";
        
        Tapahtuma tapahtuma = new Tapahtuma(tapahtumanNimi);
        tapahtuma.setTapahtumaAika(aika);
    
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja("testi.data");
        tallentaja.tallennaTiedostoon(tapahtuma);
    
        tiedosto = tallentaja.getTiedosto();
        
        assertEquals(tiedosto.exists(), true);
        tiedosto.delete();
    }
    
    @Test
    public void tallennuksenJalkeenTiedostoSisaltaaJotain() throws FileNotFoundException {
        DateTime aika = DateTime.now();
        aika.plusYears(1);
        String tapahtumanNimi = "Vuoden päästä";
        
        Tapahtuma tapahtuma = new Tapahtuma(tapahtumanNimi);
        tapahtuma.setTapahtumaAika(aika);
    
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja("testi.data");
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
    
    @Test
    public void tallenuksenJalkeenTiedostonSisaltoOikea() throws FileNotFoundException {
        DateTime aika1 = DateTime.now();
        aika1.plusYears(1);
        Tapahtuma vuodenPaasta = new Tapahtuma("Vuoden päästä");
        vuodenPaasta.setTapahtumaAika(aika1);
        
        DateTime aika2 = DateTime.now();
        aika2.plusYears(2);
        Tapahtuma kahdenVuodenPaasta = new Tapahtuma("Kahden vuoden päästä");
        kahdenVuodenPaasta.setTapahtumaAika(aika2);
    
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja("testi.data");
        tallentaja.tallennaTiedostoon(vuodenPaasta);
        tallentaja.tallennaTiedostoon(kahdenVuodenPaasta);
        
        tiedosto = tallentaja.getTiedosto();
        
        Scanner lukija = new Scanner(tiedosto);
        
        StringBuilder tapahtumat = new StringBuilder();
        while (lukija.hasNextLine()) {
            tapahtumat.append(lukija.nextLine() + "\n");
        }
        
        String ensimmaisenTapahtumanTulostus = "Vuoden päästä;"
                + aika1.getYear() + ";"
                + aika1.getMonthOfYear() + ";"
                + aika1.getDayOfMonth() + ";"
                + aika1.getHourOfDay() + ";"
                + aika1.getMinuteOfHour() + ";"
                + aika1.getSecondOfMinute() + ";toistuvuus?\n";
                
        String toisenTapahtumanTulostus = "Kahden vuoden päästä;"
                + aika2.getYear() + ";"
                + aika2.getMonthOfYear() + ";"
                + aika2.getDayOfMonth() + ";"
                + aika2.getHourOfDay() + ";"
                + aika2.getMinuteOfHour() + ";"
                + aika2.getSecondOfMinute() + ";toistuvuus?\n";
        
        assertEquals(tapahtumat.toString(), ensimmaisenTapahtumanTulostus
                + toisenTapahtumanTulostus);
        tiedosto.delete();
    }
    
    // Testaa vielä Tiedostoontallentajan konstruktoria ja poistaTapahtumaTiedostosta-metodia!
}
