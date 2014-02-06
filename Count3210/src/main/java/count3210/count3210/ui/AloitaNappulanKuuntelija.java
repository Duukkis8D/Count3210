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

/** Luokka huolehtii tapahtumista, jotka alkavat käyttäjän painaessa aloita-nappia.
 * MuokattavaTapahtumaruutu-luokan ilmentymä poistetaan tapahtumapaneelista, johon
 * lisätään sitten Lahtolaskentaruutu-luokan ilmentymä. Lahtolaskentaruutu-luokan
 * ilmentymällä on samat lähtölaskentaan liittyvät ominaisuudet kuin
 * MuokattavaTapahtumaruutu-luokan ilmentymällä.
 */
public class AloitaNappulanKuuntelija implements ActionListener {

    private JTextField nimi;
    private JTextField paivays;
    private JButton aloitaNappula;
    private MuokattavaTapahtumaruutu ruutu;
    private UI ui;

    public AloitaNappulanKuuntelija(JTextField nimi, JTextField paivays,
            JButton aloitaNappula, UI ui, MuokattavaTapahtumaruutu ruutu) {
        this.nimi = nimi;
        this.paivays = paivays;
        this.aloitaNappula = aloitaNappula;
        this.ruutu = ruutu;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        DateTime tapahtumaAikaTallennettava = tapahtumaAikakentanLuku();

        Tapahtuma tapahtuma = new Tapahtuma(nimi.getText());
        tapahtuma.setTapahtumaAika(tapahtumaAikaTallennettava);

        ruutu.setTapahtuma(tapahtuma);

        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        tiedostoontallentaja.tallennaTiedostoon(tapahtuma);

        ui.poistaMuokattavaTapahtumaruutuTapahtumapaneelista(ruutu);
        
        Lahtolaskentaruutu lahtolaskentaruutu = new Lahtolaskentaruutu();
        lahtolaskentaruutu.setTapahtuma(tapahtuma);
        lahtolaskentaruutu.luoRuutu();
        ui.lisaaLahtolaskentaruutuTapahtumapaneeliin(lahtolaskentaruutu);
        
        TapahtumaruutujenJarjestelija jarjestelija = new TapahtumaruutujenJarjestelija();
        jarjestelija.lisaaListaan(lahtolaskentaruutu);
        // Nyt kun lahtolaskentaruutu on lisätty listaan, voidaan lista järjestää
        // haluttuun järjestykseen, poistaa tapahtumapaneelista kaikki
        // Lahtolaskentaruudut ja lisätä listasta ne siihen uudelleen.
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
