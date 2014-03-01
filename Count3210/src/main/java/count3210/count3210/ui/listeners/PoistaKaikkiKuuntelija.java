package count3210.count3210.ui.listeners;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.TapahtumapaneelinRuutu;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Luokka suorittaa poista kaikki -napin painalluksen jälkeiset toimenpiteet.
 */
public class PoistaKaikkiKuuntelija implements ActionListener {

    private UI ui;

    public PoistaKaikkiKuuntelija(UI ui) {
        this.ui = ui;
    }

    /** Metodi poistaa graafisesta käyttöliittymästä kaikki tapahtumaruudut,
     * pysäyttää niiden ajastimet ja poistaa niiden tiedot ohjelman
     * muistipaikoista.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        ui.poistaKaikkiTapahtumapaneelinRuudut();
        pysaytaKaikkiAjastimet();
        
        ui.getTapahtumaruutujenJarjestelija().poistaKaikkiTapahtumat();
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja(
                "laskurit.data");
        tallentaja.poistaTiedosto();
    }
    
    /** Metodi pysäyttää kaikkien lähtölaskentaruutujen ajastimet.
     */
    public void pysaytaKaikkiAjastimet() {
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
    }
}
