
package count3210.count3210.ui;

import count3210.count3210.domain.Lahtolaskenta;
import count3210.count3210.domain.Tapahtuma;
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
//        int vv = lukija.lueTekstikayttoliittyma();
        int vv = 2016;
        System.out.print("kuukaudet: ");
//        int kk = lukija.lueTekstikayttoliittyma();
        int kk = 4;
        System.out.print("vuorokaudet: ");
//        int vrk = lukija.lueTekstikayttoliittyma();
        int vrk = 1;    
        System.out.print("tunnit: ");
//        int tun = lukija.lueTekstikayttoliittyma();
        int tun = 0;
        System.out.print("minuutit: ");
//        int min = lukija.lueTekstikayttoliittyma();
        int min = 0;
        System.out.print("sekunnit: ");
//        int sek = lukija.lueTekstikayttoliittyma();
        int sek = 0;
        System.out.println();

        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        
        return tapahtumanAika;
    }
    
    public DateTime kysyAika() {
        
        int vv = 2014;
        int kk = 1;
        int vrk = 30;
        int tun = 22;
        int min = 0;
        int sek = 0;
        String tapahtumanNimi = "Deadline";
        
        tapahtumanAika2 = new DateTime(vv, kk, vrk, tun, min, sek);
        Tapahtuma tapahtuma = new Tapahtuma(tapahtumanNimi);
        tapahtuma.setTapahtuma(tapahtumanAika2);
        
        // Olisi hyvä, jos tiedostoontallentaja luotaisi vain kerran.
        // Aina uusia tapahtumia lisättäessä käytettäisi samaa tallentajaa.
        Tiedostoontallentaja tiedostoontallentaja = new Tiedostoontallentaja();
        tiedostoontallentaja.tallennaTiedostoon(tapahtuma);
        
        return tapahtumanAika2;
    }
}
