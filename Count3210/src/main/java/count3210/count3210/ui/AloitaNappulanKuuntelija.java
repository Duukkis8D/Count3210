
package count3210.count3210.ui;

import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.utils.TapahtumaAikakentanLukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import org.joda.time.DateTime;

public class AloitaNappulanKuuntelija implements ActionListener {
    private JTextField nimi;
    private JTextField paivays;
    
    public AloitaNappulanKuuntelija(JTextField nimi, JTextField paivays) {
        this.nimi = nimi;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        Tapahtuma tapahtuma = new Tapahtuma(nimi.getText());
        TapahtumaAikakentanLukija tapahtumaAikakentanLukija = new TapahtumaAikakentanLukija(paivays);
        
        int[] tapahtumaAika = tapahtumaAikakentanLukija.lueGUI();
        
        int vrk = 0;
        int kk = 0;
        int v = 0;
        int t = 0;
        int min = 0;
        int sek = 0;
        
        for (int aikaYksikko : tapahtumaAika) {
            
        }
        
        DateTime tapahtumaAikaTallennettava = new DateTime();
        
//        tapahtuma.setTapahtuma(DateTime tapahtuma);
//        tiedostoontallentaja.tallennaTiedostoon(Tapahtuma tapahtuma);
        
        // Tapahtuman muokkausruutu muuttuu ruuduksi, jota ei voi muokata.
    }
}
