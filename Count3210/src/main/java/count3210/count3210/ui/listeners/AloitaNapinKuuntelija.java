package count3210.count3210.ui.listeners;

import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.TapahtumaruudunRunko;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.TapahtumaAikakentanLukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.joda.time.DateTime;

/** Luokka huolehtii tapahtumista, jotka alkavat käyttäjän painaessa aloita-nappia.
 * TapahtumaruudunRunko-luokan ilmentymä poistetaan tapahtumapaneelista, johon
 * lisätään sitten Lahtolaskentaruutu-luokan ilmentymä. Lahtolaskentaruutu-luokan
 * ilmentymlä on samat lähtölaskentaan liittyvät ominaisuudet kuin
 * TapahtumaruudunRunko-luokan ilmentymällä.
 */
public class AloitaNapinKuuntelija implements ActionListener {

    private JTextField nimi;
    private JTextField paivays;
    private TapahtumaruudunRunko runko;
    private UI ui;

    /** Konstruktorissa annetaan parametrina UI-luokan ilmentymä,
     * TapahtumaruudunRunko-luokan ilmentymä ja sen ominaisuuksia, joita tässä
     * luokassa tarvitaan.
  
     * @param nimi TapahtumaruudunRunko-luokan ilmentymän tapahtuman nimi.
     * @param paivays TapahtumaruudunRunko-luokan ilmentymän päiväystekstikenttä.
     * @param runko TapahtumaruudunRunko-luokan ilmentymä.
     * @param ui UI-luokan ilmentymä, joka tuottaa graafisen käyttöliittymän.
     */
    public AloitaNapinKuuntelija(JTextField nimi, JTextField paivays, UI ui,
            TapahtumaruudunRunko runko) {
        this.nimi = nimi;
        this.paivays = paivays;
        this.runko = runko;
        this.ui = ui;
    }

    /** Metodi huolehtii kunkin Lahtolaskentaruutu-luokan ilmentymän aloita-
     napin painalluksen jälkeisistä tapahtumista.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Tapahtuma tapahtuma = luoLahtolaskentaruudunTapahtuma();

        // Tämän voisi refaktoroida metodiin tallennaTapahtumaTiedostoon(tapahtuma).
        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja(
                "laskurit.data");
        tiedostoontallentaja.tallennaTiedostoon(tapahtuma);
        
        // Jostain syystä tapahtumaruudun runko ei poistu tapahtumapaneelista. 
       
        ui.poistaTapahtumaruudunRunkoTapahtumapaneelista(runko);
        
        Lahtolaskentaruutu lahtolaskentaruutu = 
                lahtolaskentaruudunTapahtumanAsettaminen(tapahtuma);
        
        ui.lisaaLahtolaskentaruutuTapahtumapaneeliin(lahtolaskentaruutu);
        
        ui.getTapahtumaruutujenJarjestelija().lisaaListaan(lahtolaskentaruutu);
        // Pitäisikö TapahtumaruudunRunko-luokan ilmentymä poistaa tässä
        // järjestelijän listalta?
        
        // Nyt kun lahtolaskentaruutu on lisätty listaan, voidaan lista järjestää
        // haluttuun järjestykseen, poistaa tapahtumapaneelista kaikki
        // Lahtolaskentaruudut ja lisätä listasta ne siihen uudelleen.
        
        ui.paivitaLahtolaskentaruudunLahtolaskentaKentta(lahtolaskentaruutu);
    }
    
    /** Metodi luo tapahtuman lähtölaskentaruutua varten.
     */
    public Tapahtuma luoLahtolaskentaruudunTapahtuma() {
        DateTime tapahtumaAikaTallennettava = tapahtumaAikakentanLuku();
        
        Tapahtuma tapahtuma = new Tapahtuma(nimi.getText());
        tapahtuma.setTapahtumaAika(tapahtumaAikaTallennettava);
        tapahtuma.setToistuvuus("toistuvuus?");
        
        return tapahtuma;
    }
    
    /** Metodi luo lähtölaskentaruudun ja asettaa sille tapahtuman.
     */
    public Lahtolaskentaruutu lahtolaskentaruudunTapahtumanAsettaminen(Tapahtuma tapahtuma) {
        Lahtolaskentaruutu lahtolaskentaruutu = new Lahtolaskentaruutu(ui);
        lahtolaskentaruutu.setTapahtuma(tapahtuma);
        lahtolaskentaruutu.luoRuutu();
        
        return lahtolaskentaruutu;
    }
    
    /** Metodi lukee käyttäjän syöttämän tekstin tapahtumaAikakentta-oliosta.
     * 
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
        
        DateTime tapahtumaAikaTallennettava = new DateTime(v, kk, vrk, t, min, sek);
        
        if (tapahtumaAikaTallennettava.isAfterNow()) {
            return tapahtumaAikaTallennettava;
        } else {
            JOptionPane.showMessageDialog(null, "Antamasi tapahtuman ajankohta on "
                    + "menneisyydessä tai samaan aikaan kuin nykyinen kellon aika."
                    + "\nSyötä tulevaisuudessa oleva ajankohta.", "Virhe", 
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
