package count3210.count3210.utils;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

/** Luokan tehtävänä on lukea käyttäjän syöte tapahtuma-aikatekstikentästä.
 */
public class TapahtumaAikakentanLukija {

    private JTextField paivays;

    public TapahtumaAikakentanLukija(JTextField paivays) {
        this.paivays = paivays;
    }
    
    // Tästä metodista voisi tehdä testejä.
    /** Metodi muuntaa String-tyyppisen merkkijonon int-lukuarvoksi, jota
     * ohjelman tapahtuma-ajoista huolehtiva DateTime-luokka ymmärtää.
     * 
     * @return DateTime-luokkaa varten muodostettu tapahtuma-ajan aikayksiköt
     * sisältävä taulukko.
     */
    public int[] lueGUI() {
        // pp:kk:vvvv,tt:mm:ss
        int vrk = 0;
        int kk = 0;
        int v = 0;
        int t = 0;
        int min = 0;
        int sek = 0;
        
        try {
            vrk = Integer.parseInt(paivays.getText(0, 2));
            kk = Integer.parseInt(paivays.getText(3, 2));
            v = Integer.parseInt(paivays.getText(6, 4));
            t = Integer.parseInt(paivays.getText(11, 2));
            min = Integer.parseInt(paivays.getText(14, 2));
            sek = Integer.parseInt(paivays.getText(17, 2));
        } catch (BadLocationException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Tekstikentän päiväys ei ollut oikeassa muodossa. Syötä "
                    + "päiväys muodossa\npäivät:kuukaudet:vuodet,tunnit:minuutit:sekunnit", 
                    "Virhe", JOptionPane.ERROR_MESSAGE);
        }
        
        int[] tapahtumaAika = {vrk, kk, v, t, min, sek};

        return tapahtumaAika;
    }
}
