
package count3210.count3210.ui;

import count3210.count3210.domain.Tapahtuma;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Lahtolaskentaruutu extends JPanel implements TapahtumapaneelinRuutu {
    private Tapahtuma tapahtuma;
    
    public Lahtolaskentaruutu() {
    }
    
    public void luoRuutu() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        // Kokoa ei pysty asettamaan ehkä siksi, koska tapahtumaPaneeli käyttää
        // GridLayoutia, jossa on ennalta määrätyn verran ruutuja.
//        tapahtumaRuutu.setSize(100, 100);
        this.setBackground(Color.BLUE);
        this.setForeground(Color.WHITE);
        
        luoRuudunSisalto();
    }
    
    public void luoRuudunSisalto() {
        luoTapahtumaKentta();
        luoLahtolaskentaKentta();
        luoPoistaNappula();
        luoMuokkaaNappula();
        luoIlmoitinalue();
    }
    
    public void luoTapahtumaKentta() {
        JTextArea tapahtumanNimi = new JTextArea("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.BLUE);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        tapahtumanNimelle.gridwidth = 3;
        this.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    public void luoLahtolaskentaKentta() {
        JTextArea lahtolaskentaKentta = new JTextArea("tähän lähtölaskenta");
        lahtolaskentaKentta.setBackground(Color.BLUE);
        lahtolaskentaKentta.setForeground(Color.WHITE);
        GridBagConstraints lahtolaskennalle = new GridBagConstraints();
        lahtolaskennalle.gridx = 0;
        lahtolaskennalle.gridy = 1;
        lahtolaskennalle.gridwidth = 3;
        this.add(lahtolaskentaKentta, lahtolaskennalle);
    }
    
    public void luoPoistaNappula() {
        JButton poista = new JButton("poista");
        GridBagConstraints poistaNappulalle = new GridBagConstraints();
        poistaNappulalle.gridx = 0;
        poistaNappulalle.gridy = 2;
        this.add(poista, poistaNappulalle);
    }
    
    public void luoMuokkaaNappula() {
        JButton muokkaa = new JButton("muokkaa");
        GridBagConstraints muokkaaNappulalle = new GridBagConstraints();
        muokkaaNappulalle.gridx = 1;
        muokkaaNappulalle.gridy = 2;
        this.add(muokkaa, muokkaaNappulalle);
    }
    
    public void luoIlmoitinalue() {
        JTextArea ilmoitinalue = new JTextArea("ilmoitinalue");
        ilmoitinalue.setBackground(Color.BLUE);
        ilmoitinalue.setForeground(Color.WHITE);
        GridBagConstraints ilmoitinalueelle = new GridBagConstraints();
        ilmoitinalueelle.gridx = 2;
        ilmoitinalueelle.gridy = 2;
        this.add(ilmoitinalue, ilmoitinalueelle);
    }
    
    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }
    
    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }
}