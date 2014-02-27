
package count3210.count3210.ui.listeners;
import count3210.count3210.ui.TapahtumapaneelinRuutu;
import count3210.count3210.ui.TapahtumaruudunRunko;
import count3210.count3210.ui.UI;
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
        
        // Testausta -->
        ArrayList<TapahtumapaneelinRuutu> ruudut = 
                ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut();
        for (TapahtumapaneelinRuutu ruutu : ruudut) {
            if (ruutu.toString().equals(runko)) {
                System.out.println("Tämä on oikea listalla oleva TapahtumaruudunRunko-luokan ilmentymä.");
                continue;
            }
            System.out.println(ruutu.getClass().getName());
        }
        // <--
        
        ui.lisaaTapahtumaruudunRunkoTapahtumapaneeliin(runko);
    }
    
}
