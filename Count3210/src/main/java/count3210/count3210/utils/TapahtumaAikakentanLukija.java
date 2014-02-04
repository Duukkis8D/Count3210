package count3210.count3210.utils;

import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import org.joda.time.DateTime;

public class TapahtumaAikakentanLukija {

    private JTextField paivays;

    public TapahtumaAikakentanLukija(JTextField paivays) {
        this.paivays = paivays;
    }

    public int[] lueGUI() {
        // tapahtumanAika2 = new DateTime(vv, kk, vrk, tun, min, sek);
        // pp:kk:vvvv,tt:mm:ss
        int vrk = 0;
        int kk = 0;
        int v = 0;
        int t = 0;
        int min = 0;
        int sek = 0;
        
        try {
            vrk = Integer.parseInt(paivays.getText(0, 1));
            kk = Integer.parseInt(paivays.getText(3, 1));
            v = Integer.parseInt(paivays.getText(6, 3));
            t = Integer.parseInt(paivays.getText(11, 1));
            min = Integer.parseInt(paivays.getText(14, 1));
            sek = Integer.parseInt(paivays.getText(17, 1));
        } catch (BadLocationException e) {
            System.out.println("Tekstikentän päiväys ei ollut oikeassa muodossa.");
        }
        
        int[] tapahtumaAika = {vrk, kk, v, t, min, sek};

        return tapahtumaAika;
    }
}
