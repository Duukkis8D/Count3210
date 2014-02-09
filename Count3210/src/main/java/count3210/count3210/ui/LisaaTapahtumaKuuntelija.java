
package count3210.count3210.ui;

import count3210.count3210.utils.TapahtumaruutujenJarjestelija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Luokan tehtävänä on huolehtia lisää tapahtuma -napin painalluksen
 * jälkeisistä tapahtumista.
 */
public class LisaaTapahtumaKuuntelija implements ActionListener {
    private UI ui;
    private MuokattavaTapahtumaruutu ruutu;
    
    public LisaaTapahtumaKuuntelija(UI ui) {
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ruutu = new MuokattavaTapahtumaruutu(ui);
        ruutu.luoRuutu();
        
        ui.getTapahtumaruutujenJarjestelija().lisaaListaan(ruutu);
        
        ui.lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(ruutu);
    }
    
}
