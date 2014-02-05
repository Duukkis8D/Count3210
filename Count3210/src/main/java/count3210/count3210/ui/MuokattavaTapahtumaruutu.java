
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

public class MuokattavaTapahtumaruutu {
    private JPanel tapahtumaPaneeli;
    private Tapahtuma tapahtuma;
    
    public MuokattavaTapahtumaruutu(JPanel tapahtumaPaneeli) {
        this.tapahtumaPaneeli = tapahtumaPaneeli;
    }
    
    public JPanel luoRuutu() {
        // Tähän koodia muokattavasta tapahtumaRuudusta, joka näkyy käyttäjälle
        // heti lisää tapahtuma -nappulasta painamisen jälkeen ja myös
        // tapahtuman muokkaa-nappulasta painaessa.
        JPanel tapahtumaRuutu = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        tapahtumaRuutu.setLayout(layout);
        tapahtumaRuutu.setBackground(Color.BLACK);
        tapahtumaRuutu.setForeground(Color.WHITE);
        
        luoRuudunSisalto(tapahtumaRuutu);
        
        tapahtumaPaneeli.add(tapahtumaRuutu);
        
        tapahtumaPaneeli.updateUI();
        
        return tapahtumaPaneeli;
    }
    
    public void luoRuudunSisalto(JPanel tapahtumaRuutu) {
        luoTapahtumanSelitekentta(tapahtumaRuutu);
        JTextField nimi = luoMuokattavaTapahtumanNimiKentta(tapahtumaRuutu);
        luoAjankohtaSelitekentta(tapahtumaRuutu);
        JTextField paivays = luoAjankohtaKentta(tapahtumaRuutu);
        luoToistuvuusSeliteKentta(tapahtumaRuutu);
        luoToistuvuusValintalaatikko(tapahtumaRuutu);
        luoAloitaNappula(tapahtumaRuutu, nimi, paivays);
    }
    
    public void luoTapahtumanSelitekentta(JPanel tapahtumaRuutu) {
        JLabel tapahtumanNimi = new JLabel("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.BLACK);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        tapahtumaRuutu.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    public JTextField luoMuokattavaTapahtumanNimiKentta(JPanel tapahtumaRuutu) {
        JTextField nimi = new JTextField("tapahtuman nimi");
        nimi.setBackground(Color.BLACK);
        nimi.setForeground(Color.WHITE);
        GridBagConstraints nimelle = new GridBagConstraints();
        nimelle.gridx = 1;
        nimelle.gridy = 0;
        tapahtumaRuutu.add(nimi, nimelle);
        
        return nimi;
    }
    
    public void luoAjankohtaSelitekentta(JPanel tapahtumaRuutu) {
        JLabel ajankohta = new JLabel("ajankohta");
        ajankohta.setBackground(Color.BLACK);
        ajankohta.setForeground(Color.WHITE);
        GridBagConstraints ajankohdalle = new GridBagConstraints();
        ajankohdalle.gridx = 0;
        ajankohdalle.gridy = 1;
        tapahtumaRuutu.add(ajankohta, ajankohdalle);
    }
    
    public JTextField luoAjankohtaKentta(JPanel tapahtumaRuutu) {
        JTextField paivays = new JTextField("pp:kk:vvvv,tt:mm:ss");
        paivays.setBackground(Color.BLACK);
        paivays.setForeground(Color.WHITE);
        GridBagConstraints paivaykselle = new GridBagConstraints();
        paivaykselle.gridx = 1;
        paivaykselle.gridy = 1;
        tapahtumaRuutu.add(paivays, paivaykselle);
        
        return paivays;
    }
    
    public void luoToistuvuusSeliteKentta(JPanel tapahtumaRuutu) {
        JLabel toistuvuus = new JLabel("toistuvuus");
        toistuvuus.setBackground(Color.BLACK);
        toistuvuus.setForeground(Color.WHITE);
        GridBagConstraints toistuvuudelle = new GridBagConstraints();
        toistuvuudelle.gridx = 0;
        toistuvuudelle.gridy = 2;
        tapahtumaRuutu.add(toistuvuus, toistuvuudelle);
    }
    
    public void luoToistuvuusValintalaatikko(JPanel tapahtumaRuutu) {
        String[] valinnat = {"kerran", "kerran sek", "kerran min"};
        JComboBox toistuvuusValinta = new JComboBox(valinnat);
        toistuvuusValinta.setBackground(Color.BLACK);
        toistuvuusValinta.setForeground(Color.WHITE);
        GridBagConstraints toistuvuusValinnalle = new GridBagConstraints();
        toistuvuusValinnalle.gridx = 1;
        toistuvuusValinnalle.gridy = 2;
        tapahtumaRuutu.add(toistuvuusValinta, toistuvuusValinnalle);
    }
    
    public void luoAloitaNappula(JPanel tapahtumaRuutu, JTextField nimi, JTextField paivays) {
        JButton aloita = new JButton("aloita");
        aloita.addActionListener(new AloitaNappulanKuuntelija(nimi, paivays, aloita, this));
        GridBagConstraints aloitaNappulalle = new GridBagConstraints();
        aloitaNappulalle.gridx = 0;
        aloitaNappulalle.gridy = 3;
        aloitaNappulalle.gridwidth = 2;
        tapahtumaRuutu.add(aloita, aloitaNappulalle);
    }
    
    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }
}
