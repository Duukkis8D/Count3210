package count3210.count3210.domain;

import count3210.count3210.ui.Lahtolaskentaruutu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.joda.time.*;

public class Lahtolaskenta implements ActionListener {

    private Period ajanjakso;
    private Lahtolaskentaruutu lahtolaskentaruutu;

    public Lahtolaskenta(Lahtolaskentaruutu lahtolaskentaruutu) {
    }

    public Period getAjanjakso() {
        return ajanjakso;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int aikayksikkoja = lahtolaskentaruutu.getAikayksikkoja();
        
        if (aikayksikkoja > 0) {
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
        }

        // Tämä toimii, jos aikayksikköinä tulostetaan vain vuorokaudet,
        // tunnit, minuutit ja sekunnit.
//        System.out.println("Erotus:");
//        
//        int i = 0;
//        while (i < 51) {
//            DateTime nyt = DateTime.now();
//
//            try {
//                Thread.sleep(1000);
//                // Mikä on InterruptedException, jonka Thread.sleep voi heittää?
//            } catch (InterruptedException e) {
//                System.out.println("Ei onnistunut!");
//            }
//            
//            System.out.println(Days.daysBetween(nyt, tapahtumanAika2).getDays() + " vuorokautta "
//                + Hours.hoursBetween(nyt, tapahtumanAika2).getHours() % 24 + " tuntia "
//                + Minutes.minutesBetween(nyt, tapahtumanAika2).getMinutes() % 60 + " minuuttia "
//                + Seconds.secondsBetween(nyt, tapahtumanAika2).getSeconds() % 60 + " sekuntia");
//            
//            i++;
//        }
    }
}
