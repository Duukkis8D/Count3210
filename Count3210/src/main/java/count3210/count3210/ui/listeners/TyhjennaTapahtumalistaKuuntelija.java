
package count3210.count3210.ui.listeners;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.TapahtumapaneelinRuutu;
import count3210.count3210.ui.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Luokka huolehtii tyhjennä tapahtumalista -napin painalluksen jälkeisistä
 * toimenpiteistä.
 */
public class TyhjennaTapahtumalistaKuuntelija implements ActionListener {
    private UI ui;

    public TyhjennaTapahtumalistaKuuntelija(UI ui) {
        this.ui = ui;
    }

    /** Metodi poistaa kaikki tapahtumapaneelin ruudut graafisesta
     * käyttöliittymästä, pysäyttää niiden ajastimet ja poistaa niiden tiedot
     * ohjelman väliaikaismuistista.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
         ui.poistaKaikkiTapahtumapaneelinRuudut();

        for (TapahtumapaneelinRuutu ruutu
                : ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut()) {
            if (ruutu.getClass().getName().equals(
                    "count3210.count3210.ui.Lahtolaskentaruutu")) {
                // Tyyppimuunnos HaluttuTyyppi muuttuja = 
                // (HaluttuTyyppi) vanhaMuuttuja;
                Lahtolaskentaruutu lahtolaskentaruutu
                        = (Lahtolaskentaruutu) ruutu;
                lahtolaskentaruutu.getLahtolaskenta().pysaytaAjastin();
            }
        }
        ui.getTapahtumaruutujenJarjestelija().poistaKaikkiTapahtumat();
    }
}
