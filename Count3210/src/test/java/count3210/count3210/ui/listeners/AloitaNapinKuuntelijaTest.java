
package count3210.count3210.ui.listeners;
import count3210.count3210.ui.TapahtumaruudunRunko;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.TapahtumaAikakentanLukija;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AloitaNapinKuuntelijaTest {
    private JTextField paivays;
    private int[] tapahtumaAika;
    private JTextField nimi;
    private JButton aloitaNappula;
    private UI ui;
    private TapahtumaruudunRunko runko;
    
    public AloitaNapinKuuntelijaTest() {
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
    public void DateTimellaOnOikeaArvoVuorokausissa() {
        AloitaNapinKuuntelija kuuntelija = new AloitaNapinKuuntelija(nimi,
                paivays, ui, runko);
        DateTime lahtolaskennanAika = kuuntelija.tapahtumaAikakentanLuku();
        
        assertEquals(lahtolaskennanAika.getDayOfMonth(), 11);
    }
    
    @Test
    public void DateTimellaOnOikeaArvoKuukausissa() {
        AloitaNapinKuuntelija kuuntelija = new AloitaNapinKuuntelija(nimi,
                paivays, ui, runko);
        DateTime lahtolaskennanAika = kuuntelija.tapahtumaAikakentanLuku();
        
        assertEquals(lahtolaskennanAika.getMonthOfYear(), 12);
    }
    
    @Test
    public void DateTimellaOnOikeaArvoVuosissa() {
        AloitaNapinKuuntelija kuuntelija = new AloitaNapinKuuntelija(nimi, 
                paivays, ui, runko);
        DateTime lahtolaskennanAika = kuuntelija.tapahtumaAikakentanLuku();
        
        assertEquals(lahtolaskennanAika.getYear(), 2100);
    }
    
    @Test
    public void DateTimellaOnOikeaArvoTunneissa() {
        AloitaNapinKuuntelija kuuntelija = new AloitaNapinKuuntelija(nimi, 
                paivays, ui, runko);
        DateTime lahtolaskennanAika = kuuntelija.tapahtumaAikakentanLuku();
        
        assertEquals(lahtolaskennanAika.getHourOfDay(), 21);
    }
    
    @Test
    public void DateTimellaOnOikeaArvoMinuuteissa() {
        AloitaNapinKuuntelija kuuntelija = new AloitaNapinKuuntelija(nimi, 
                paivays, ui, runko);
        DateTime lahtolaskennanAika = kuuntelija.tapahtumaAikakentanLuku();
        
        assertEquals(lahtolaskennanAika.getMinuteOfHour(), 00);
    }
    
    @Test
    public void DateTimellaOnOikeaArvoSekunneissa() {
        AloitaNapinKuuntelija kuuntelija = new AloitaNapinKuuntelija(nimi,
                paivays, ui, runko);
        DateTime lahtolaskennanAika = kuuntelija.tapahtumaAikakentanLuku();
        
        assertEquals(lahtolaskennanAika.getSecondOfMinute(), 00);
    }
}
