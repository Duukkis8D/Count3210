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
        // aikayksikkoja-muuttujan arvo ei pääse nollaan, vaikka kaikki
        // lähtölaskentakentässä olevat numerot olisivat nolla tai vähemmän
        // kuin nolla. Miksi?
        System.out.println(aikayksikkoja);
        if (aikayksikkoja == 0) {
            ajastin.stop();
        }

        Tapahtuma tapahtuma = lahtolaskentaruutu.getTapahtuma();
        DateTime tapahtumaAika = tapahtuma.getTapahtumaAika();
        DateTime aikaNyt = DateTime.now();

        ajanjakso = new Period(aikaNyt, tapahtumaAika);

        int[] aikayksikkoTaulukko = ajanjakso.getValues();
        aikayksikkoja = 0;
        for (int aikayksikko : aikayksikkoTaulukko) {
            aikayksikkoja = aikayksikkoja + aikayksikko;
        }
        lahtolaskentaruutu.setAikayksikkoja(aikayksikkoja);

        lahtolaskentaruutu.paivitaLahtolaskentaKentta(ajanjakso);
        ui.paivitaTapahtumapaneeli();
    }
}
