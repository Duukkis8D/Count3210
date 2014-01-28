
package count3210.count3210.ui;

import count3210.count3210.domain.Lahtolaskenta;
import count3210.count3210.utils.Tiedostonlukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.util.Calendar;
import org.joda.time.DateTime;

public class Kyselija {
    private Tiedostonlukija lukija;
    private Calendar tapahtumanAika = Calendar.getInstance();
    private DateTime tapahtumanAika2;
    
    public Kyselija() {
        lukija = new Tiedostonlukija();
    }
    
    public Calendar kysyCalendar() {
        // Kysy päiväyksen sekuntien, minuuttien, tuntien,
        // vuorokausien, kuukausien ja vuosien arvo käyttäjältä.
        System.out.print("vuodet: ");
//        int vv = lukija.lue();
        int vv = 2016;
        System.out.print("kuukaudet: ");
//        int kk = lukija.lue();
        int kk = 4;
        System.out.print("vuorokaudet: ");
//        int vrk = lukija.lue();
        int vrk = 1;    
        System.out.print("tunnit: ");
//        int tun = lukija.lue();
        int tun = 0;
        System.out.print("minuutit: ");
//        int min = lukija.lue();
        int min = 0;
        System.out.print("sekunnit: ");
//        int sek = lukija.lue();
        int sek = 0;
        System.out.println();

        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        tiedostoontallentaja.setAikaCalendar(tapahtumanAika,
                vv, kk, vrk, tun, min, sek);
        
        return tapahtumanAika;
    }
    
    public DateTime kysyDateTime() {
        
        int vv = 2016;
        int kk = 4;
        int vrk = 1;
        int tun = 0;
        int min = 0;
        int sek = 0;
        
        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        tiedostoontallentaja.setAikaDateTime(tapahtumanAika2,
                vv, kk, vrk, tun, min, sek);
        
        return tapahtumanAika2;
    }
}
