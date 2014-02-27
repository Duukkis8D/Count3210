
package count3210.count3210.ui;

import count3210.count3210.ui.listeners.AloitaNapinKuuntelija;
import count3210.count3210.domain.Tapahtuma;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Luokan tehtävä on näyttää käyttäjälle graafiset komponentit, joiden avulla
 * hän voi luoda lähtölaskentapahtuman tai muokata jo olemassa olevaa
 * lähtölaskentatapahtumaa.
 */
public class TapahtumaruudunRunko extends JPanel implements TapahtumapaneelinRuutu {
    private Tapahtuma tapahtuma;
    private UI ui;
    
    public TapahtumaruudunRunko(UI ui) {
        this.ui = ui;
    }
    
    public void luoRuutu() {
        // Tähän koodia muokattavasta tapahtumaRuudusta, joka näkyy käyttäjälle
        // heti lisää tapahtuma -nappulasta painamisen jälkeen ja myös
        // tapahtuman muokkaa-nappulasta painaessa.
        luoRuudunUlkonako();
        luoRuudunSisalto();
    }
    
    public void luoRuudunUlkonako() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.WHITE);
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
        tapahtumanNimi.setBackground(Color.DARK_GRAY);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        this.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    public JTextField luoMuokattavaTapahtumanNimiKentta() {
        JTextField nimi = new JTextField("tapahtuman nimi");
        nimi.setBackground(Color.DARK_GRAY);
        nimi.setForeground(Color.WHITE);
        GridBagConstraints nimelle = new GridBagConstraints();
        nimelle.gridx = 1;
        nimelle.gridy = 0;
        this.add(nimi, nimelle);
        
        return nimi;
    }
    
    public void luoAjankohtaSelitekentta() {
        JLabel ajankohta = new JLabel("ajankohta");
        ajankohta.setBackground(Color.DARK_GRAY);
        ajankohta.setForeground(Color.WHITE);
        GridBagConstraints ajankohdalle = new GridBagConstraints();
        ajankohdalle.gridx = 0;
        ajankohdalle.gridy = 1;
        this.add(ajankohta, ajankohdalle);
    }
    
    public JTextField luoAjankohtaKentta() {
        JTextField paivays = new JTextField("pp:kk:vvvv,tt:mm:ss");
        paivays.setBackground(Color.DARK_GRAY);
        paivays.setForeground(Color.WHITE);
        GridBagConstraints paivaykselle = new GridBagConstraints();
        paivaykselle.gridx = 1;
        paivaykselle.gridy = 1;
        this.add(paivays, paivaykselle);
        
        return paivays;
    }
    
    public void luoToistuvuusSeliteKentta() {
        JLabel toistuvuus = new JLabel("toistuvuus");
        toistuvuus.setBackground(Color.DARK_GRAY);
        toistuvuus.setForeground(Color.WHITE);
        GridBagConstraints toistuvuudelle = new GridBagConstraints();
        toistuvuudelle.gridx = 0;
        toistuvuudelle.gridy = 2;
        this.add(toistuvuus, toistuvuudelle);
    }
    
    public void luoToistuvuusValintalaatikko() {
        String[] valinnat = {"kerran", "kerran sek", "kerran min"};
        JComboBox toistuvuusValinta = new JComboBox(valinnat);
        toistuvuusValinta.setBackground(Color.DARK_GRAY);
        toistuvuusValinta.setForeground(Color.WHITE);
        GridBagConstraints toistuvuusValinnalle = new GridBagConstraints();
        toistuvuusValinnalle.gridx = 1;
        toistuvuusValinnalle.gridy = 2;
        this.add(toistuvuusValinta, toistuvuusValinnalle);
    }
    
    public void luoAloitaNappula(JTextField nimi, JTextField paivays) {
        JButton aloita = new JButton("aloita");
        aloita.addActionListener(new AloitaNapinKuuntelija(nimi, paivays, ui, 
                this));
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
    
    @Override
    public boolean equals(Object olio) {
        return false;
    }
}
