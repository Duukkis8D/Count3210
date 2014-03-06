
package count3210.count3210.ui.listeners;

import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.MuokattavaTapahtumaruutu;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.TapahtumaAikakentanLukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.joda.time.DateTime;

public class TallennaNapinKuuntelija implements ActionListener {
    private JTextField nimi;
    private JTextField paivays;
    private MuokattavaTapahtumaruutu muokattavaTapahtumaruutu;
    private UI ui;
    
    public TallennaNapinKuuntelija(JTextField nimi, JTextField paivays, 
            MuokattavaTapahtumaruutu muokattavaTapahtumaruutu, UI ui) {
        this.nimi = nimi;
        this.paivays = paivays;
        this.muokattavaTapahtumaruutu = muokattavaTapahtumaruutu;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Lahtolaskentaruutu lahtolaskentaruutu = lahtolaskentaruudunTapahtumanAsettaminen();
        
        tallennaMuutoksetTiedostoon(lahtolaskentaruutu);
        
        ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut().remove(muokattavaTapahtumaruutu);
        ui.poistaMuokattavaTapahtumaruutuTapahtumapaneelista(muokattavaTapahtumaruutu);
        
        lahtolaskentaruudunVisualisointi(lahtolaskentaruutu);
    }
    
    /** Metodi luo lähtölaskentaruudun ja asettaa sille tapahtuman.
     * 
     * @return Valmis lähtölaskentaruutu.
     */
    public Lahtolaskentaruutu lahtolaskentaruudunTapahtumanAsettaminen() {
        Lahtolaskentaruutu lahtolaskentaruutu = new Lahtolaskentaruutu(ui);
        lahtolaskentaruutu.setTapahtuma(luoLahtolaskentaruudunTapahtuma());
        lahtolaskentaruutu.luoRuutu();
        
        return lahtolaskentaruutu;
    }
    
    public Tapahtuma luoLahtolaskentaruudunTapahtuma() {
        DateTime tapahtumaAikaTallennettava = tapahtumaAikakentanLuku();
        
        Tapahtuma tapahtuma = new Tapahtuma(nimi.getText());
        tapahtuma.setTapahtumaAika(tapahtumaAikaTallennettava);
        tapahtuma.setToistuvuus("toistuvuus?");
        
        return tapahtuma;
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
        
        return onkoSyotettyTapahtumaAikaTulevaisuudessa(tapahtumaAikaTallennettava);
    }

    /** Metodi näyttää käyttäjälle ilmoituksen, jos hänen syöttämänsä tapahtuman
     * ajankohta on menneisyydessä tai samaan aikaan kuin nykyinen kellon aika.
     * 
     * @param syotettyTapahtumaAika Analysoitava tapahtuma-aika.
     * @return Jos syötetty tapahtuma-aika on nykyisen kellon ajan jälkeen,
     * metodi palauttaa sen. Muussa tapauksessa palautetaan null.
     */
    public DateTime onkoSyotettyTapahtumaAikaTulevaisuudessa(DateTime syotettyTapahtumaAika) {
        if (syotettyTapahtumaAika.isAfterNow()) {
            return syotettyTapahtumaAika;
        } else {
            JOptionPane.showMessageDialog(null, "Antamasi tapahtuman ajankohta on "
                    + "menneisyydessä tai samaan aikaan kuin nykyinen kellon aika."
                    + "\nSyötä tulevaisuudessa oleva ajankohta.", "Virhe", 
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void tallennaMuutoksetTiedostoon(Lahtolaskentaruutu lahtolaskentaruutu) {
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja("laskurit.data");
        tallentaja.tallennaTiedostoon(lahtolaskentaruutu.getTapahtuma());
    }
    
    /** Metodi lisää lähtölaskentaruudun näytölle ja aktivoi sen toiminnan.
     * 
     * @param lahtolaskentaruutu Tietyn tapahtuman lähtölaskentaa esittävä
     * lähtölaskentaruutu.
     */
    public void lahtolaskentaruudunVisualisointi(Lahtolaskentaruutu lahtolaskentaruutu) {
        ui.getTapahtumaruutujenJarjestelija().lisaaListaan(lahtolaskentaruutu);
        ui.lisaaLahtolaskentaruutuTapahtumapaneeliin(lahtolaskentaruutu);
        ui.paivitaLahtolaskentaruudunLahtolaskentaKentta(lahtolaskentaruutu);
    }
}
