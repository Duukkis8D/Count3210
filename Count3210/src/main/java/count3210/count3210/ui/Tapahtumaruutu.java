
package count3210.count3210.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Tapahtumaruutu {
    private JPanel tapahtumaPaneeli;
    
    public Tapahtumaruutu(JPanel tapahtumaPaneeli) {
        this.tapahtumaPaneeli = tapahtumaPaneeli;
    }
    
    public JPanel luoRuutu() {
        JPanel tapahtumaRuutu = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        tapahtumaRuutu.setLayout(layout);
        // Kokoa ei pysty asettamaan ehkä siksi, koska tapahtumaPaneeli käyttää
        // GridLayoutia, jossa on ennalta määrätyn verran ruutuja.
//        tapahtumaRuutu.setSize(100, 100);
        tapahtumaRuutu.setBackground(Color.BLUE);
        tapahtumaRuutu.setForeground(Color.WHITE);
        
        luoRuudunSisalto(tapahtumaRuutu);
        
        tapahtumaPaneeli.add(tapahtumaRuutu);
        
        tapahtumaPaneeli.updateUI();
        
        return tapahtumaRuutu;
    }
    
    public void luoRuudunSisalto(JPanel tapahtumaRuutu) {
        luoTapahtumaKentta(tapahtumaRuutu);
        luoLahtolaskentaKentta(tapahtumaRuutu);
        luoPoistaNappula(tapahtumaRuutu);
        luoMuokkaaNappula(tapahtumaRuutu);
        luoIlmoitinalue(tapahtumaRuutu);
    }
    
    public void luoTapahtumaKentta(JPanel tapahtumaRuutu) {
        JTextArea tapahtumanNimi = new JTextArea("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.BLUE);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        tapahtumanNimelle.gridwidth = 3;
        tapahtumaRuutu.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    public void luoLahtolaskentaKentta(JPanel tapahtumaRuutu) {
        JTextArea lahtolaskentaKentta = new JTextArea("tähän lähtölaskenta");
        lahtolaskentaKentta.setBackground(Color.BLUE);
        lahtolaskentaKentta.setForeground(Color.WHITE);
        GridBagConstraints lahtolaskennalle = new GridBagConstraints();
        lahtolaskennalle.gridx = 0;
        lahtolaskennalle.gridy = 1;
        lahtolaskennalle.gridwidth = 3;
        tapahtumaRuutu.add(lahtolaskentaKentta, lahtolaskennalle);
    }
    
    public void luoPoistaNappula(JPanel tapahtumaRuutu) {
        JButton poista = new JButton("poista");
        GridBagConstraints poistaNappulalle = new GridBagConstraints();
        poistaNappulalle.gridx = 0;
        poistaNappulalle.gridy = 2;
        tapahtumaRuutu.add(poista, poistaNappulalle);
    }
    
    public void luoMuokkaaNappula(JPanel tapahtumaRuutu) {
        JButton muokkaa = new JButton("muokkaa");
        GridBagConstraints muokkaaNappulalle = new GridBagConstraints();
        muokkaaNappulalle.gridx = 1;
        muokkaaNappulalle.gridy = 2;
        tapahtumaRuutu.add(muokkaa, muokkaaNappulalle);
    }
    
    public void luoIlmoitinalue(JPanel tapahtumaRuutu) {
        JTextArea ilmoitinalue = new JTextArea("ilmoitinalue");
        ilmoitinalue.setBackground(Color.BLUE);
        ilmoitinalue.setForeground(Color.WHITE);
        GridBagConstraints ilmoitinalueelle = new GridBagConstraints();
        ilmoitinalueelle.gridx = 2;
        ilmoitinalueelle.gridy = 2;
        tapahtumaRuutu.add(ilmoitinalue, ilmoitinalueelle);
    }
}
