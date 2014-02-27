
package count3210.count3210.ui.listeners;
import count3210.count3210.ui.TapahtumapaneelinRuutu;
import count3210.count3210.ui.TapahtumaruudunRunko;
import count3210.count3210.ui.UI;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/** Luokan tehtävänä on huolehtia lisää tapahtuma -napin painalluksen
 * jälkeisistä tapahtumista.
 */
public class LisaaTapahtumaKuuntelija implements ActionListener {
    private UI ui;
    
    public LisaaTapahtumaKuuntelija(UI ui) {
        this.ui = ui;
    }
    
    /** Metodi luo TapahtumaruudunRunko-luokan ilmentymän ja tekee muutkin
    toimeenpiteet, joilla tapahtumaruutu saadaan ruudulle näkyviin.
    */
    @Override
    public void actionPerformed(ActionEvent ae) {
        TapahtumaruudunRunko runko = new TapahtumaruudunRunko(ui);
        runko.luoRuutu();
        
        ui.getTapahtumaruutujenJarjestelija().lisaaListaan(runko);
        
        ui.lisaaTapahtumaruudunRunkoTapahtumapaneeliin(runko);
        
        // Testausta -->
        Component[] ruudut = ui.getTapahtumapaneeli().getComponents();
        for (Component ruutu : ruudut) {
            System.out.println(ruutu.getClass().getName());
        }
        System.out.println();
        // <--
    }
    
}
