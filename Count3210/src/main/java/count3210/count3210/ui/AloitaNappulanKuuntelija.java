
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
        this.paivays = paivays;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        TapahtumaAikakentanLukija tapahtumaAikakentanLukija = new TapahtumaAikakentanLukija(paivays);
        
        int[] tapahtumaAika = tapahtumaAikakentanLukija.lueGUI();
        // pp:kk:vvvv,tt:mm:ss
        
        int vrk = tapahtumaAika[0];
        int kk = tapahtumaAika[1];
        int v = tapahtumaAika[2];
        int t = tapahtumaAika[3];
        int min = tapahtumaAika[4];
        int sek = tapahtumaAika[5];
        
        DateTime tapahtumaAikaTallennettava = new DateTime(v, kk, vrk, t, min, sek);
        Tapahtuma tapahtuma = new Tapahtuma(nimi.getText());
        tapahtuma.setTapahtuma(tapahtumaAikaTallennettava);
        
        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        tiedostoontallentaja.tallennaTiedostoon(tapahtuma);
        
        // Tapahtuman muokkausruudun pitäisi nyt muuttua ruuduksi, jota ei voi muokata.
        
        // Pitäisikö tapahtumaruudusta ja muokattavasta tapahtumaruudusta tehdä luokat, jotta
        // ne voisi luoda tietokoneen näytölle helpommin ymmärrettävässä muodossa?
    }
}
