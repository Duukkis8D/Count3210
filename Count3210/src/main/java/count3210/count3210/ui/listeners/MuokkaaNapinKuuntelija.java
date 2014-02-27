/*
package count3210.count3210.ui.listeners;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.MuokattavaTapahtumaruutu;
import count3210.count3210.ui.TapahtumapaneelinRuutu;
import count3210.count3210.ui.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class MuokkaaNapinKuuntelija implements ActionListener {

    private UI ui;
    private Lahtolaskentaruutu lahtolaskentaruutu;

    public MuokkaaNapinKuuntelija(UI ui, Lahtolaskentaruutu ruutu) {
        this.ui = ui;
        this.lahtolaskentaruutu = ruutu;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Etsi TapahtumaruutujenJarjestelijan listalta oikea Lahtolaskentaruutu
        // ja poista se.
        
        Iterator<TapahtumapaneelinRuutu> iteraattori 
                = ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut().iterator();
        
        int lahtolaskentaruudunIndeksi = 0;
        
        while (iteraattori.hasNext()) {
            TapahtumapaneelinRuutu ruutu = iteraattori.next();
            
            if (ruutu.equals(lahtolaskentaruutu)) {
                lahtolaskentaruudunIndeksi = ui.getLahtolaskentaruudunIndeksi(lahtolaskentaruutu);
                // Kun tapahtumapaneelista poistetaan jotain ja lisätään jotain tilalle,
                // säilyvätkö paneelin sisältämien komponenttien indeksinumerot samoina?
                ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut().remove(ruutu);
            }
        }
        
        // Luodaan tapahtumapaneeliin uusi MuokattavaTapahtumaruutu
        // lähtölaskentaruudun tilalle.
        // Käytetään hyväksi tiedostoa, jossa on tapahtumat lisäysjärjestyksessä.
        
        ui.poistaLahtolaskentaruutuTapahtumapaneelista(lahtolaskentaruutu);
        
        MuokattavaTapahtumaruutu muokattavaTapahtumaruutu = new MuokattavaTapahtumaruutu(ui);
        muokattavaTapahtumaruutu.setTapahtuma(lahtolaskentaruutu.getTapahtuma());
        muokattavaTapahtumaruutu.luoRuutu();
        
        ui.lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(
                muokattavaTapahtumaruutu, lahtolaskentaruudunIndeksi);
        
        // Muokattavan tapahtumaruudun tallenna-napille täytyy tehdä tapahtuman-
        // kuuntelija.
    }
}
*/