
package count3210.count3210.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
        JPanel tapahtumaPaneeli = luoTapahtumaPaneeli();
        tapahtumaPaneeli.add(otsikko1);
        container.add(tapahtumaPaneeli);
        luoTapahtumaRuutu(tapahtumaPaneeli);
        
        JTextArea otsikko2 = new JTextArea("Toiminnot");
        JPanel toimintoPaneeli = luoToimintoPaneeli();
        toimintoPaneeli.add(otsikko2);
        container.add(toimintoPaneeli);
        luoToimintoNappulat(toimintoPaneeli);
    }
    
    private JPanel luoTapahtumaPaneeli() {
        JPanel paneeli = new JPanel(new GridLayout(8, 1));
        
        return paneeli;
    }
    
    private JPanel luoToimintoPaneeli() {
        JPanel paneeli = new JPanel(new GridLayout(4, 1));
        
        return paneeli;
    }
    
    private void luoToimintoNappulat(JPanel toimintoPaneeli) {
        JButton lisaaTapahtuma = new JButton("lisää tapahtuma");
        JButton poistaKaikki = new JButton("poista kaikki tapahtumat");
        JButton tuoTapahtumia = new JButton("tuo tapahtumia Hotmail-kalenterista");
        
        toimintoPaneeli.add(lisaaTapahtuma);
        toimintoPaneeli.add(poistaKaikki);
        toimintoPaneeli.add(tuoTapahtumia);
    }
    
    private JPanel luoTapahtumaRuutu(JPanel tapahtumaPaneeli) {
        JPanel tapahtumaRuutu = new JPanel(new GridLayout(2, 3));
        // Kokoa ei pysty asettamaan ehkä siksi, koska tapahtumaPaneeli käyttää
        // GridLayoutia, jossa on ennalta määrätyn verran ruutuja.
//        tapahtumaRuutu.setSize(100, 100);
        tapahtumaRuutu.setBackground(Color.BLUE);
        JTextArea tapahtumanNimi = new JTextArea("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.BLUE);
        tapahtumanNimi.setForeground(Color.WHITE);
        tapahtumaRuutu.add(tapahtumanNimi);
        
        tapahtumaPaneeli.add(tapahtumaRuutu);
        
        return tapahtumaRuutu;
    }

    public JFrame getFrame() {
        return frame;
    }
    
}
