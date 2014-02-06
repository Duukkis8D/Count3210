
package count3210.count3210.ui;

import count3210.count3210.domain.Tapahtuma;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MuokattavaTapahtumaruutu extends JPanel implements TapahtumapaneelinRuutu {
    private Tapahtuma tapahtuma;
    private UI ui;
    
    public MuokattavaTapahtumaruutu(UI ui) {
        this.ui = ui;
    }
    
    public void luoRuutu() {
        // Tähän koodia muokattavasta tapahtumaRuudusta, joka näkyy käyttäjälle
        // heti lisää tapahtuma -nappulasta painamisen jälkeen ja myös
        // tapahtuman muokkaa-nappulasta painaessa.
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        
        luoRuudunSisalto();
    }
    
    public void luoRuudunSisalto() {
        luoTapahtumanSelitekentta();
        JTextField nimi = luoMuokattavaTapahtumanNimiKentta();
        luoAjankohtaSelitekentta();
        JTextField paivays = luoAjankohtaKentta();
        luoToistuvuusSeliteKentta();
        luoToistuvuusValintalaatikko();
        luoAloitaNappula(nimi, paivays);
    }
    
    public void luoTapahtumanSelitekentta() {
        JLabel tapahtumanNimi = new JLabel("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.BLACK);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        this.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    public JTextField luoMuokattavaTapahtumanNimiKentta() {
        JTextField nimi = new JTextField("tapahtuman nimi");
        nimi.setBackground(Color.BLACK);
        nimi.setForeground(Color.WHITE);
        GridBagConstraints nimelle = new GridBagConstraints();
        nimelle.gridx = 1;
        nimelle.gridy = 0;
        this.add(nimi, nimelle);
        
        return nimi;
    }
    
    public void luoAjankohtaSelitekentta() {
        JLabel ajankohta = new JLabel("ajankohta");
        ajankohta.setBackground(Color.BLACK);
        ajankohta.setForeground(Color.WHITE);
        GridBagConstraints ajankohdalle = new GridBagConstraints();
        ajankohdalle.gridx = 0;
        ajankohdalle.gridy = 1;
        this.add(ajankohta, ajankohdalle);
    }
    
    public JTextField luoAjankohtaKentta() {
        JTextField paivays = new JTextField("pp:kk:vvvv,tt:mm:ss");
        paivays.setBackground(Color.BLACK);
        paivays.setForeground(Color.WHITE);
        GridBagConstraints paivaykselle = new GridBagConstraints();
        paivaykselle.gridx = 1;
        paivaykselle.gridy = 1;
        this.add(paivays, paivaykselle);
        
        return paivays;
    }
    
    public void luoToistuvuusSeliteKentta() {
        JLabel toistuvuus = new JLabel("toistuvuus");
        toistuvuus.setBackground(Color.BLACK);
        toistuvuus.setForeground(Color.WHITE);
        GridBagConstraints toistuvuudelle = new GridBagConstraints();
        toistuvuudelle.gridx = 0;
        toistuvuudelle.gridy = 2;
        this.add(toistuvuus, toistuvuudelle);
    }
    
    public void luoToistuvuusValintalaatikko() {
        String[] valinnat = {"kerran", "kerran sek", "kerran min"};
        JComboBox toistuvuusValinta = new JComboBox(valinnat);
        toistuvuusValinta.setBackground(Color.BLACK);
        toistuvuusValinta.setForeground(Color.WHITE);
        GridBagConstraints toistuvuusValinnalle = new GridBagConstraints();
        toistuvuusValinnalle.gridx = 1;
        toistuvuusValinnalle.gridy = 2;
        this.add(toistuvuusValinta, toistuvuusValinnalle);
    }
    
    public void luoAloitaNappula(JTextField nimi, JTextField paivays) {
        JButton aloita = new JButton("aloita");
        aloita.addActionListener(new AloitaNappulanKuuntelija(nimi, paivays, aloita, ui, this));
        GridBagConstraints aloitaNappulalle = new GridBagConstraints();
        aloitaNappulalle.gridx = 0;
        aloitaNappulalle.gridy = 3;
        aloitaNappulalle.gridwidth = 2;
        this.add(aloita, aloitaNappulalle);
    }
    
    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }
    
    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }
}
