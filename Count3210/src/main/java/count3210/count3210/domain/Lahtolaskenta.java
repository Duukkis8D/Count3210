package count3210.count3210.domain;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.UI;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
     * käynnistyessä. Kun aikayksikkoja-muuttujan arvo on nolla,
     * lähtölaskentaruudun ajastin pysäytetään.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        int aikayksikkoja = lahtolaskentaruutu.getAikayksikkoja();
        if (aikayksikkoja == 0) {
            ajastin.stop();
            ilmoitusTapahtumanAlkamisesta();
        }

        ajanjaksonLuonti();
        lahtolaskentaruudunPaivitys(aikayksikkoja);
        
        ui.paivitaTapahtumapaneeli();
    }
    
    /** Metodi näyttää käyttäjälle ilmoituksen tapahtuman alkamisesta.
     */
    private void ilmoitusTapahtumanAlkamisesta() {
        JPanel ilmoitus = new JPanel();
            ilmoitus.add(new JTextArea("Tapahtuma nimeltään\n" 
                    + lahtolaskentaruutu.getTapahtuma().getNimi() + "\nalkaa!"));
            // Miksi ilmoituksen maksimikoko ei toimi? Pitkä tapahtuman nimi ei mahdu ikkunaan.
            ilmoitus.setPreferredSize(new Dimension(300, 100));
            ilmoitus.setMaximumSize(new Dimension(800, 100));
            
            JOptionPane.showMessageDialog(null, ilmoitus, "Ilmoitus tapahtuman alkamisesta", 
                    JOptionPane.PLAIN_MESSAGE);
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
     * näyttävän tekstikentän. aikayksikkoja-muuttuja saa arvokseen
     * ajanjakso-olion seuraavien kenttien arvot: vuodet, kuukaudet, viikot,
     * vuorokaudet, tunnit, minuutit ja sekunnit.
     @param aikayksikkoja Muuttujan arvo määrää, milloin lähtölaskentaruudun
     * aikaa ei enää päivitetä.
     */
    public void lahtolaskentaruudunPaivitys(int aikayksikkoja) {
        aikayksikkoja = ajanjakso.getValue(0) + ajanjakso.getValue(1)
                + ajanjakso.getValue(2) + ajanjakso.getValue(3)
                + ajanjakso.getValue(4) + ajanjakso.getValue(5)
                + ajanjakso.getValue(6);

        lahtolaskentaruutu.setAikayksikkoja(aikayksikkoja);

        lahtolaskentaruutu.paivitaLahtolaskentaKentta(ajanjakso);
    }

    /** Metodi pysäyttää lähtölaskentaruudun ajastimen.
     */
    public void pysaytaAjastin() {
        ajastin.stop();
    }
}
