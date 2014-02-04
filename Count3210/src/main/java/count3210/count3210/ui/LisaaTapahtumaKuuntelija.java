
package count3210.count3210.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class LisaaTapahtumaKuuntelija implements ActionListener {
    private JPanel tapahtumaPaneeli;
    private UI ui;
    
    public LisaaTapahtumaKuuntelija(JPanel tapahtumaPaneeli, UI ui) {
        this.tapahtumaPaneeli = tapahtumaPaneeli;
        this.ui = ui;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ui.luoMuokattavaTapahtumaRuutu(tapahtumaPaneeli);
    }
    
}
