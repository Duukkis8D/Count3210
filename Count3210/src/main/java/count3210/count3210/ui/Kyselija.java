
package count3210.count3210.ui;

import count3210.count3210.utils.Tiedostonlukija;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.util.Calendar;

public class Kyselija {
    private Tiedostonlukija lukija;
    
    public Kyselija() {
        lukija = new Tiedostonlukija();
        Calendar tapahtumanAika = Calendar.getInstance();
        kysy(tapahtumanAika);
    }
    
    public void kysy(Calendar tapahtumanAika) {
        // Kysy päiväyksen sekuntien, minuuttien, tuntien,
        // vuorokausien, kuukausien ja vuosien arvo käyttäjältä.
        System.out.print("sekunnit: ");
        int sek = lukija.lue();
        System.out.print("minuutit: ");
        int min = lukija.lue();
        System.out.print("tunnit: ");
        int tun = lukija.lue();
        System.out.print("vuorokaudet: ");
        int vrk = lukija.lue();
        System.out.print("kuukaudet: ");
        int kk = lukija.lue();
        System.out.print("vuodet: ");
        int vv = lukija.lue();

        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja(tapahtumanAika);
        
    }
}
