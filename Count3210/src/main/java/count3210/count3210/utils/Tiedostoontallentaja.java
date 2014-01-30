
package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import org.joda.time.DateTime;

public class Tiedostoontallentaja {
    private File laskurit;
    
    public Tiedostoontallentaja() {
       laskurit = new File("laskurit.data");
    }
    
    public void tallennaTiedostoon(Tapahtuma tapahtuma) {
        // Testaa että tiedostoon tallentuu oikeat arvot.
        try {
            FileWriter tallentaja = new FileWriter(laskurit, true);
            tallentaja.append(tapahtuma.getNimi() + "\n");
            tallentaja.append(tapahtuma.getTapahtuma().getYear() + ","
                            + tapahtuma.getTapahtuma().getMonthOfYear() + ","
                            + tapahtuma.getTapahtuma().getDayOfMonth() + ","
                            + tapahtuma.getTapahtuma().getHourOfDay() + ","
                            + tapahtuma.getTapahtuma().getMinuteOfHour() + ","
                            + tapahtuma.getTapahtuma().getSecondOfMinute() + "\n");
            tallentaja.close();
        } catch (IOException e) {
            System.out.println("Tallennus ei onnistunut." + "\n"
                    + e.getMessage());
        }
    }
    
    public File getTiedosto() {
        return laskurit;
    }
}
