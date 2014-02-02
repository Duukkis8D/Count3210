
package count3210.count3210.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class UI implements Runnable {
    private JFrame frame;
    
    public UI() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame("Count 3210");
        frame.setPreferredSize(new Dimension(600, 800));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        

        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        
        JTextArea otsikko1 = new JTextArea("Tapahtumat");
        JPanel isoPaneeli1 = luoIsoPaneeli();
        container.add(isoPaneeli1.add(otsikko1));
        
        JTextArea otsikko2 = new JTextArea("Toiminnot");
        JPanel isoPaneeli2 = luoIsoPaneeli();
        container.add(isoPaneeli2.add(otsikko2));
        
        luoTapahtumaPaneeli(isoPaneeli1);
    }
    
    private JPanel luoIsoPaneeli() {
        JPanel paneeli = new JPanel();
        BoxLayout layout = new BoxLayout(paneeli, BoxLayout.Y_AXIS);
        paneeli.setLayout(layout);
        
        return paneeli;
    }
    
    private JPanel luoTapahtumaPaneeli(JPanel isoPaneeli) {
        JPanel tapahtumaPaneeli = new JPanel(new GridLayout(2, 3));
        isoPaneeli.add(tapahtumaPaneeli);
        
        return tapahtumaPaneeli;
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
