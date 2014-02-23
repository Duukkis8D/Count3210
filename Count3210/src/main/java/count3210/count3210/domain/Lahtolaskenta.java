package count3210.count3210.domain;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.joda.time.*;

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

    public void ajanjaksonLuonti() {
        Tapahtuma tapahtuma = lahtolaskentaruutu.getTapahtuma();
        DateTime tapahtumaAika = tapahtuma.getTapahtumaAika();
        DateTime aikaNyt = DateTime.now();

        ajanjakso = new Period(aikaNyt, tapahtumaAika);
    }

    public void lahtolaskentaruudunPaivitys(int aikayksikkoja) {
        // aikayksikkoja-muuttuja saa arvokseen ajanjakso-olion seuraavien
        // kenttien arvot: vuodet, kuukaudet, viikot, vuorokaudet, tunnit,
        // minuutit ja sekunnit.
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
