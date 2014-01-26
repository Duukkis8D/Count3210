
package count3210.count3210.ui;

import count3210.count3210.domain.Lahtolaskenta;
import count3210.count3210.utils.Tiedostonlukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.util.Calendar;

public class Kyselija {
    private Tiedostonlukija lukija;
    private Calendar aikaNyt = Calendar.getInstance();
    private Calendar tapahtumanAika = Calendar.getInstance();
    
    public Kyselija() {
        lukija = new Tiedostonlukija();
    }
    
    public Calendar kysy() {
        
        // Tulostetaan kokeeksi tämänhetkinen päiväys.
        Lahtolaskenta.tulostaAika(aikaNyt);
        
        // Kysy päiväyksen sekuntien, minuuttien, tuntien,
        // vuorokausien, kuukausien ja vuosien arvo käyttäjältä.
        System.out.print("vuodet: ");
        int vv = lukija.lue();
        System.out.print("kuukaudet: ");
        int kk = lukija.lue();
        System.out.print("vuorokaudet: ");
        int vrk = lukija.lue();
        System.out.print("tunnit: ");
        int tun = lukija.lue();
        System.out.print("minuutit: ");
        int min = lukija.lue();
        System.out.print("sekunnit: ");
        int sek = lukija.lue();
        System.out.println();

        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        tiedostoontallentaja.setAika(tapahtumanAika, vv, kk, vrk, tun, min, sek);
        
        return tapahtumanAika;
    }
}
