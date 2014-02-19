package count3210.count3210.ui;

import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoistaKaikkiKuuntelija implements ActionListener {

    private UI ui;

    public PoistaKaikkiKuuntelija(UI ui) {
        this.ui = ui;
    }

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
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja();
        tallentaja.poistaTiedosto();
    }

}
