
package count3210.count3210.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        JPanel tapahtumaRuutu = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        tapahtumaRuutu.setLayout(layout);
        // Kokoa ei pysty asettamaan ehkä siksi, koska tapahtumaPaneeli käyttää
        // GridLayoutia, jossa on ennalta määrätyn verran ruutuja.
//        tapahtumaRuutu.setSize(100, 100);
        tapahtumaRuutu.setBackground(Color.BLUE);
        tapahtumaRuutu.setForeground(Color.WHITE);
        
        JTextArea tapahtumanNimi = new JTextArea("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.BLUE);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        tapahtumanNimelle.gridwidth = 3;
        tapahtumaRuutu.add(tapahtumanNimi, tapahtumanNimelle);
        
        JTextArea lahtolaskentaKentta = new JTextArea("tähän lähtölaskenta");
        lahtolaskentaKentta.setBackground(Color.BLUE);
        lahtolaskentaKentta.setForeground(Color.WHITE);
        GridBagConstraints lahtolaskennalle = new GridBagConstraints();
        lahtolaskennalle.gridx = 0;
        lahtolaskennalle.gridy = 1;
        lahtolaskennalle.gridwidth = 3;
        tapahtumaRuutu.add(lahtolaskentaKentta, lahtolaskennalle);
        
        JButton poista = new JButton("poista");
        GridBagConstraints poistaNappulalle = new GridBagConstraints();
        poistaNappulalle.gridx = 0;
        poistaNappulalle.gridy = 2;
        tapahtumaRuutu.add(poista, poistaNappulalle);
                
        JButton muokkaa = new JButton("muokkaa");
        GridBagConstraints muokkaaNappulalle = new GridBagConstraints();
        muokkaaNappulalle.gridx = 1;
        muokkaaNappulalle.gridy = 2;
        tapahtumaRuutu.add(muokkaa, muokkaaNappulalle);
        
        JTextArea ilmoitinalue = new JTextArea("ilmoitinalue");
        ilmoitinalue.setBackground(Color.BLUE);
        ilmoitinalue.setForeground(Color.WHITE);
        GridBagConstraints ilmoitinalueelle = new GridBagConstraints();
        ilmoitinalueelle.gridx = 2;
        ilmoitinalueelle.gridy = 2;
        tapahtumaRuutu.add(ilmoitinalue, ilmoitinalueelle);
        
        tapahtumaPaneeli.add(tapahtumaRuutu);
        
        return tapahtumaRuutu;
    }

    public JFrame getFrame() {
        return frame;
    }
    
}