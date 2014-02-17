package count3210.count3210.ui;

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
            // Tyyppimuunnos HaluttuTyyppi muuttuja = (HaluttuTyyppi) vanhaMuuttuja;
            
            // Alla oleva ei toimi, joten ehkä ruutu ei palauta luokkansa nimeä
            // oikeassa muodossa.
            if (ruutu.getClass().getName().equals("Lahtolaskenta")) {
                Lahtolaskentaruutu tapahtumaruutu = (Lahtolaskentaruutu) ruutu;
                tapahtumaruutu.getLahtolaskenta().pysaytaAjastin();
            }
        }
    }

}
