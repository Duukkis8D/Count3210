
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
    }
    
}
