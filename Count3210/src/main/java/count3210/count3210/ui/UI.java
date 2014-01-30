
package count3210.count3210.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class UI implements Runnable {
    private JFrame frame;
    
    public UI() {
        
    }
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(100, 300));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
