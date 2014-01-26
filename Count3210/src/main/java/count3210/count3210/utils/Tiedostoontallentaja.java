
package count3210.count3210.utils;

import java.util.Calendar;

public class Tiedostoontallentaja {
    
    public Tiedostoontallentaja() {
    }
    
    public void setAika(Calendar tapahtumanAika,
            int vv, int kk, int vrk, int tun, int min, int sek) {
        tapahtumanAika.set(vv, kk, vrk, tun, min, sek);
    }
    
    public void tallennaTiedostoon() {
        
    }
}
