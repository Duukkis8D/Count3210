
package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import org.joda.time.DateTime;

public class Tiedostoontallentaja {
    
    
    public Tiedostoontallentaja() {
       
    }
    
    public void tallennaTiedostoon(Tapahtuma tapahtuma) {
        
        try {
            FileWriter tallentaja = new FileWriter("laskurit.txt", true);
            tallentaja.append(tapahtuma.getNimi() + "\n");
            tallentaja.append(tapahtuma.getTapahtuma().getYear() + ","
                            + tapahtuma.getTapahtuma().getMonthOfYear() + ","
                            + tapahtuma.getTapahtuma().getDayOfMonth() + ","
                            + tapahtuma.getTapahtuma().getHourOfDay() + ","
                            + tapahtuma.getTapahtuma().getMinuteOfHour() + ","
                            + tapahtuma.getTapahtuma().getSecondOfMinute());
            tallentaja.close();
        } catch (IOException e) {
            System.out.println("Tallennus ei onnistunut." + "\n"
                    + e.getMessage());
        }
        
    }
}
