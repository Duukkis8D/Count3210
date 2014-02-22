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
//        System.out.println(aikayksikkoja);
        if (aikayksikkoja == 0) {
            ajastin.stop();
        }
        
        Tapahtuma tapahtuma = lahtolaskentaruutu.getTapahtuma();
        DateTime tapahtumaAika = tapahtuma.getTapahtumaAika();
        DateTime aikaNyt = DateTime.now();
//        System.out.println(tapahtumaAika + "\n" + aikaNyt + "\n");

        ajanjakso = new Period(aikaNyt, tapahtumaAika);
        System.out.println(ajanjakso.getYears() + " v " + ajanjakso.getMonths()
                + " kk " + ajanjakso.getWeeks() + " vkoa " + ajanjakso.getDays()
                + " vrk " + ajanjakso.getHours() + " t " 
                + ajanjakso.getMinutes() + " min " + ajanjakso.getSeconds()
                + " sek");
        
        aikayksikkoja = ajanjakso.getValue(0) + ajanjakso.getValue(1) +
                ajanjakso.getValue(2) + ajanjakso.getValue(3) +
                ajanjakso.getValue(4) + ajanjakso.getValue(5) +
                ajanjakso.getValue(6);
        
        lahtolaskentaruutu.setAikayksikkoja(aikayksikkoja);

        lahtolaskentaruutu.paivitaLahtolaskentaKentta(ajanjakso);
        ui.paivitaTapahtumapaneeli();
    }
    
    public void pysaytaAjastin() {
        ajastin.stop();
    }
}
