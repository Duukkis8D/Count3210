package count3210.count3210.ui.listeners;

import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.MuokattavaTapahtumaruutu;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.TapahtumaAikakentanLukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import org.joda.time.DateTime;

/** Luokka huolehtii tapahtumista, jotka alkavat käyttäjän painaessa aloita-nappia.
 * MuokattavaTapahtumaruutu-luokan ilmentymä poistetaan tapahtumapaneelista, johon
 * lisätään sitten Lahtolaskentaruutu-luokan ilmentymä. Lahtolaskentaruutu-luokan
 * ilmentymällä on samat lähtölaskentaan liittyvät ominaisuudet kuin
 * MuokattavaTapahtumaruutu-luokan ilmentymällä.
 */
public class AloitaNapinKuuntelija implements ActionListener {

    private JTextField nimi;
    private JTextField paivays;
    private MuokattavaTapahtumaruutu ruutu;
    private UI ui;

    /** Konstruktorissa annetaan parametrina UI-luokan ilmentymä,
     * MuokattavaTapahtumaruutu-luokan ilmentymä ja sen ominaisuuksia, joita
     * tässä luokassa tarvitaan.
     * 
     * @param nimi MuokattavaTapahtumaruutu-luokan ilmentymän tapahtuman nimi.
     * @param paivays MuokattavaTapahtumaruutu-luokan ilmentymän
     * päiväys-tekstikenttä.
     * @param ruutu MuokattavaTapahtumaruutu-luokan ilmentymä.
     * @param ui UI-luokan ilmentymä, joka tuottaa graafisen käyttöliittymän.
     */
    public AloitaNapinKuuntelija(JTextField nimi, JTextField paivays, UI ui,
            MuokattavaTapahtumaruutu ruutu) {
        this.nimi = nimi;
        this.paivays = paivays;
        this.ruutu = ruutu;
        this.ui = ui;
    }

    /** Metodi huolehtii kunkin Lahtolaskentaruutu-luokan ilmentymän aloita-
     napin painalluksen jälkeisistä tapahtumista.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Tapahtuma tapahtuma = lahtolaskentaruudunAjanAsettaminen();

        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja(
                "laskurit.data");
        tiedostoontallentaja.tallennaTiedostoon(tapahtuma);

        ui.poistaMuokattavaTapahtumaruutuTapahtumapaneelista(ruutu);
        
        Lahtolaskentaruutu lahtolaskentaruutu = 
                lahtolaskentaruudunLuonti(tapahtuma);
        ui.lisaaLahtolaskentaruutuTapahtumapaneeliin(lahtolaskentaruutu);
        
        ui.getTapahtumaruutujenJarjestelija().lisaaListaan(lahtolaskentaruutu);
        // Nyt kun lahtolaskentaruutu on lisätty listaan, voidaan lista järjestää
        // haluttuun järjestykseen, poistaa tapahtumapaneelista kaikki
        // Lahtolaskentaruudut ja lisätä listasta ne siihen uudelleen.
        
        ui.paivitaLahtolaskentaruudunLahtolaskentaKentta(lahtolaskentaruutu);
    }
    
    public Tapahtuma lahtolaskentaruudunAjanAsettaminen() {
        DateTime tapahtumaAikaTallennettava = tapahtumaAikakentanLuku();

        Tapahtuma tapahtuma = new Tapahtuma(nimi.getText());
        tapahtuma.setTapahtumaAika(tapahtumaAikaTallennettava);

        ruutu.setTapahtuma(tapahtuma);
        return tapahtuma;
    }
    
    public Lahtolaskentaruutu lahtolaskentaruudunLuonti(Tapahtuma tapahtuma) {
        Lahtolaskentaruutu lahtolaskentaruutu = new Lahtolaskentaruutu(ui);
        lahtolaskentaruutu.setTapahtuma(tapahtuma);
        lahtolaskentaruutu.luoRuutu();
        
        return lahtolaskentaruutu;
    }
    
    /** Metodi lukee käyttäjän syöttämän tekstin tapahtumaAikakentta-oliosta.
     @return Tiedostoon tallennettava tapahtuma-aika.
     */
    public DateTime tapahtumaAikakentanLuku() {
        TapahtumaAikakentanLukija tapahtumaAikakentanLukija = 
                new TapahtumaAikakentanLukija(paivays);

        int[] tapahtumaAika = tapahtumaAikakentanLukija.lueGUI();
        // pp:kk:vvvv,tt:mm:ss

        int vrk = tapahtumaAika[0];
        int kk = tapahtumaAika[1];
        int v = tapahtumaAika[2];
        int t = tapahtumaAika[3];
        int min = tapahtumaAika[4];
        int sek = tapahtumaAika[5];

        DateTime tapahtumaAikaTallennettava = 
                new DateTime(v, kk, vrk, t, min, sek);
        return tapahtumaAikaTallennettava;
    }
}
