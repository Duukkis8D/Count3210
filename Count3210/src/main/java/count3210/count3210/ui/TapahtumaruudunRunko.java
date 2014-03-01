
package count3210.count3210.ui;

import count3210.count3210.ui.listeners.AloitaNapinKuuntelija;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Luokan tehtävä on näyttää käyttäjälle graafiset komponentit, joiden avulla
 * hän voi luoda lähtölaskentatapahtuman.
 */
public class TapahtumaruudunRunko extends JPanel implements TapahtumapaneelinRuutu {
    private UI ui;
    
    public TapahtumaruudunRunko(UI ui) {
        this.ui = ui;
    }
    
    /** Metodi luo tämän luokan ilmentymän kaiken sisällön.
     */
    @Override
    public void luoRuutu() {
        luoRuudunUlkonako();
        luoRuudunSisalto();
    }
    
    /** Metodi luo ruudulle ulkonäön.
     */
    @Override
    public void luoRuudunUlkonako() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.WHITE);
    }
    
    /** Metodi luo ruudulle sisällön. Sisältöön kuuluu useita eri komponentteja,
     * joiden luomiseen on omat metodinsa.
     */
    @Override
    public void luoRuudunSisalto() {
        luoTapahtumanSelitekentta();
        JTextField nimi = luoMuokattavaTapahtumanNimiKentta();
        luoAjankohtaSelitekentta();
        JTextField paivays = luoAjankohtaKentta();
        luoToistuvuusSeliteKentta();
        luoToistuvuusValintalaatikko();
        luoAloitaNappula(nimi, paivays);
    }
    
    /** Metodi luo tapahtuman selitekentän.
     */
    public void luoTapahtumanSelitekentta() {
        JLabel tapahtumanNimi = new JLabel("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.DARK_GRAY);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        this.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    /** Metodi luo nimikentän, johon käyttäjä voi syöttää tapahtuman
     nimen.
     * 
     * @return Tapahtuman nimi.
     */
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
    
    /** Metodi luo ajankohdan selitekentän.
     */
    public void luoAjankohtaSelitekentta() {
        JLabel ajankohta = new JLabel("ajankohta");
        ajankohta.setBackground(Color.DARK_GRAY);
        ajankohta.setForeground(Color.WHITE);
        GridBagConstraints ajankohdalle = new GridBagConstraints();
        ajankohdalle.gridx = 0;
        ajankohdalle.gridy = 1;
        this.add(ajankohta, ajankohdalle);
    }
    
    /** Metodi luo ajankohtakentän, johon käyttäjä voi syöttää tapahtuman
     * ajankohdan.
     * 
     * @return paivays Tapahtuman ajankohta.
     */
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
    
    /** Metodi luo tapahtuman toistuvuusvalintaa osoittavan selitekentän.
     */
    public void luoToistuvuusSeliteKentta() {
        JLabel toistuvuus = new JLabel("toistuvuus");
        toistuvuus.setBackground(Color.DARK_GRAY);
        toistuvuus.setForeground(Color.WHITE);
        GridBagConstraints toistuvuudelle = new GridBagConstraints();
        toistuvuudelle.gridx = 0;
        toistuvuudelle.gridy = 2;
        this.add(toistuvuus, toistuvuudelle);
    }
    
    /** Metodi luo tapahtuman toistuvuuden asettamista varten valintalaatikon.
     */
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
    
    /** Metodi luo aloita-napin, jolla tapahtuman lähtölaskenta aloitetaan.
     *
     * @param nimi Tapahtuman nimi.
     * @param paivays Tapahtuman ajankohta.
     */
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
    
    /** Metodi palauttaa aina false. Sille ei ole käyttöä, mutta se pitää olla
     * olemassa luokan toteuttaman TapahtumapaneelinRuutu-rajapinnan vuoksi.
     */
    @Override
    public boolean equals(Object olio) {
        return false;
    }
}
