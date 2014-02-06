
package count3210.count3210.ui;

import count3210.count3210.utils.TapahtumaAikakentanLukija;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AloitaNappulanKuuntelijaTest {
    private JTextField paivays;
    private int[] tapahtumaAika;
    private JTextField nimi;
    private JButton aloitaNappula;
    private UI ui;
    private MuokattavaTapahtumaruutu ruutu;
    
    public AloitaNappulanKuuntelijaTest() {
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
        AloitaNappulanKuuntelija kuuntelija = new AloitaNappulanKuuntelija(nimi,
                paivays, aloitaNappula, ui, ruutu);
        // Jatka tästä.
    }
}
