
package count3210.count3210.ui.listeners;
import count3210.count3210.ui.MuokattavaTapahtumaruutu;
import count3210.count3210.ui.UI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Luokan tehtävänä on huolehtia lisää tapahtuma -napin painalluksen
 * jälkeisistä tapahtumista.
 */
public class LisaaTapahtumaKuuntelija implements ActionListener {
    private UI ui;
    
    public LisaaTapahtumaKuuntelija(UI ui) {
        this.ui = ui;
    }
    
    /** Metodi luo MuokattavaTapahtumaruutu-luokan ilmentymän ja tekee muutkin
     * toimeenpiteet, joilla tapahtumaruutu saadaan ruudulle näkyviin.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        MuokattavaTapahtumaruutu ruutu = new MuokattavaTapahtumaruutu(ui);
        ruutu.luoRuutu();
        
        ui.getTapahtumaruutujenJarjestelija().lisaaListaan(ruutu);
        
        ui.lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(ruutu);
    }
    
}
