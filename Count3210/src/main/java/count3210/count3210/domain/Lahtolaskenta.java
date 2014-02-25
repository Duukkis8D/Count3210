package count3210.count3210.domain;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.joda.time.*;

/** Luokka määrittelee, miten ohjelman ydintoiminto, lähtölaskenta, toimii.
 */
public class Lahtolaskenta implements ActionListener {

    private Period ajanjakso;
    private Lahtolaskentaruutu lahtolaskentaruutu;
    private UI ui;
    private Timer ajastin;

    public Lahtolaskenta(Lahtolaskentaruutu lahtolaskentaruutu, UI ui) {
        this.lahtolaskentaruutu = lahtolaskentaruutu;
        this.ui = ui;
    }

    public Period getAjanjakso() {
        return ajanjakso;
    }

    public void setAjastin(Timer ajastin) {
        this.ajastin = ajastin;
    }

    /** Metodi huolehtii tapahtumaketjusta, joka alkaa lähtölaskennan
     käynnistyessä.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        int aikayksikkoja = lahtolaskentaruutu.getAikayksikkoja();
        if (aikayksikkoja == 0) {
            ajastin.stop();
        }

        ajanjaksonLuonti();
        lahtolaskentaruudunPaivitys(aikayksikkoja);
        
        ui.paivitaTapahtumapaneeli();
    }

    /** Metodi luo käyttäjän luoman tapahtuman ja nykyisen kalenteriajan välisen
     erotuksen pituisen ajanjakson.
     */
    public void ajanjaksonLuonti() {
        Tapahtuma tapahtuma = lahtolaskentaruutu.getTapahtuma();
        DateTime tapahtumaAika = tapahtuma.getTapahtumaAika();
        DateTime aikaNyt = DateTime.now();

        ajanjakso = new Period(aikaNyt, tapahtumaAika);
    }

    /** Metodi päivittää lähtölaskentaruudun tapahtumaan jäljellä olevan ajan
     * näyttävän tekstikentän.
     * aikayksikkoja-muuttuja saa arvokseen ajanjakso-olion seuraavien
     kenttien arvot: vuodet, kuukaudet, viikot, vuorokaudet, tunnit,
     minuutit ja sekunnit.
     @param aikayksikkoja
     */
    public void lahtolaskentaruudunPaivitys(int aikayksikkoja) {
        aikayksikkoja = ajanjakso.getValue(0) + ajanjakso.getValue(1)
                + ajanjakso.getValue(2) + ajanjakso.getValue(3)
                + ajanjakso.getValue(4) + ajanjakso.getValue(5)
                + ajanjakso.getValue(6);

        lahtolaskentaruutu.setAikayksikkoja(aikayksikkoja);

        lahtolaskentaruutu.paivitaLahtolaskentaKentta(ajanjakso);
    }

    public void pysaytaAjastin() {
        ajastin.stop();
    }
}
