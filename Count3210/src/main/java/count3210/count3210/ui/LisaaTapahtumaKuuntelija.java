
package count3210.count3210.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

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
        ui.lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(ruutu);
    }
    
}
