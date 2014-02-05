
package count3210.count3210.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class LisaaTapahtumaKuuntelija implements ActionListener {
    private JPanel tapahtumaPaneeli;
    private MuokattavaTapahtumaruutu ruutu;
    
    public LisaaTapahtumaKuuntelija(JPanel tapahtumaPaneeli) {
        this.tapahtumaPaneeli = tapahtumaPaneeli;
        ruutu = new MuokattavaTapahtumaruutu(this.tapahtumaPaneeli);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        ruutu.luoRuutu();
    }
    
}
