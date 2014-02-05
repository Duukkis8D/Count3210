
package count3210.count3210.ui;

import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.utils.TapahtumaAikakentanLukija;
import count3210.count3210.utils.TapahtumaruutujenJarjestelija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import org.joda.time.DateTime;

public class AloitaNappulanKuuntelija implements ActionListener {
    private JTextField nimi;
    private JTextField paivays;
    private JButton aloitaNappula;
    private MuokattavaTapahtumaruutu ruutu;
    
    public AloitaNappulanKuuntelija(JTextField nimi, JTextField paivays,
            JButton aloitaNappula, MuokattavaTapahtumaruutu ruutu) {
        this.nimi = nimi;
        this.paivays = paivays;
        this.aloitaNappula = aloitaNappula;
        this.ruutu = ruutu;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        DateTime tapahtumaAikaTallennettava = tapahtumaAikakentanLuku();
        
        Tapahtuma tapahtuma = new Tapahtuma(nimi.getText());
        tapahtuma.setTapahtumaAika(tapahtumaAikaTallennettava);
        
        ruutu.setTapahtuma(tapahtuma);
        
        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        tiedostoontallentaja.tallennaTiedostoon(tapahtuma);
        
        TapahtumaruutujenJarjestelija jarjestelija = new
                TapahtumaruutujenJarjestelija();
        jarjestelija.lisaaListaan(ruutu);
        // Kun listaan tallennus on tehty, samalle paikalle listassa voisi luoda ruudun,
        // jota ei voi muokata mutta jolla on sama Tapahtuma-olio. Toisaalta koko
        // listasysteemi ei välttämättä ole tarpeellinen, jos poiston ja korvaamisen
        // pystyy tekemään LayoutManagerin avulla. Olisiko kaikkien LayoutManagerien
        // yhteisestä removeLayoutComponent-metodista hyötyä?
    }
    
    public DateTime tapahtumaAikakentanLuku() {
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
        return tapahtumaAikaTallennettava;
    }
}
