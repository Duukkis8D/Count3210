
package count3210.count3210.utils;

import java.util.Calendar;
import org.joda.time.DateTime;

public class Tiedostoontallentaja {
    
    public Tiedostoontallentaja() {
    }
    
    public void setAikaCalendar(Calendar tapahtumanAika,
            int vv, int kk, int vrk, int tun, int min, int sek) {
        tapahtumanAika.set(vv, kk, vrk, tun, min, sek);
    }
    
//    public void setAikaDateTime(DateTime tapahtumanAika,
//            int vv, int kk, int vrk, int tun, int min, int sek) {
//        tapahtumanAika = new DateTime(vv, kk, vrk, tun, min, sek);
//    }
    
    public void tallennaTiedostoon() {
        
    }
}
