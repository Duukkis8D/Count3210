
package count3210.count3210.ui;

import count3210.count3210.domain.Lahtolaskenta;
import count3210.count3210.utils.Tiedostonlukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.util.Calendar;

public class Kyselija {
    private Tiedostonlukija lukija;
    private Calendar tapahtumanAika = Calendar.getInstance();
    
    public Kyselija() {
        lukija = new Tiedostonlukija();
    }
    
    public Calendar kysy() {
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
        tiedostoontallentaja.setAika(tapahtumanAika, vv, kk, vrk, tun, min, sek);
        
        return tapahtumanAika;
    }
}
