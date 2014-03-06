package count3210.count3210.ui;

import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.ui.listeners.TallennaNapinKuuntelija;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.joda.time.DateTime;

/**
 * Luokan tehtävänä on esittää käyttäjälle graafiset komponentit, joiden avulla
 * hän voi muokata aikaisemmin luomaansa tapahtumaa.
 */
public class MuokattavaTapahtumaruutu extends JPanel implements TapahtumapaneelinRuutu {

    private JTextField nimi;
    private JTextField paivays;
    private Tapahtuma tapahtuma;
    private UI ui;

    public MuokattavaTapahtumaruutu(UI ui) {
        this.ui = ui;
    }

    @Override
    public void luoRuutu() {
        luoRuudunUlkonako();
        luoRuudunSisalto();
    }

    @Override
    public void luoRuudunUlkonako() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        
        this.setPreferredSize(new Dimension(250, 300));
        this.setBackground(Color.DARK_GRAY);
        this.setForeground(Color.WHITE);
    }

    @Override
    public void luoRuudunSisalto() {
        luoTapahtumanSelitekentta();
        nimi = luoMuokattavaTapahtumanNimiKentta();
        luoAjankohtaSelitekentta();
        paivays = luoAjankohtaKentta();
        luoToistuvuusSeliteKentta();
        luoToistuvuusValintalaatikko();
        luoTallennaNappi();
    }

    /** Metodi luo tapahtuman selitekentän.
     */
    private void luoTapahtumanSelitekentta() {
        JLabel tapahtumanNimi = new JLabel("tapahtuman nimi");
        tapahtumanNimi.setBackground(Color.DARK_GRAY);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        this.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    private JTextField luoMuokattavaTapahtumanNimiKentta() {
        nimi = new JTextField(tapahtuma.getNimi());
        GridBagConstraints nimelle = muokattavanTapahtumanNimiKentanUlkoasu(nimi);
        this.add(nimi, nimelle);

        return nimi;
    }
    
    private GridBagConstraints muokattavanTapahtumanNimiKentanUlkoasu(JTextField nimi) {
        nimi.setBackground(Color.DARK_GRAY);
        nimi.setForeground(Color.WHITE);
        GridBagConstraints nimelle = new GridBagConstraints();
        nimelle.gridx = 1;
        nimelle.gridy = 0;

        return nimelle;
    }
    
    /** Metodi luo ajankohdan selitekentän.
     */
    private void luoAjankohtaSelitekentta() {
        JLabel ajankohta = new JLabel("ajankohta");
        ajankohta.setBackground(Color.DARK_GRAY);
        ajankohta.setForeground(Color.WHITE);
        GridBagConstraints ajankohdalle = new GridBagConstraints();
        ajankohdalle.gridx = 0;
        ajankohdalle.gridy = 1;
        this.add(ajankohta, ajankohdalle);
    }
    
    private JTextField luoAjankohtaKentta() {
        DateTime asetettavaTapahtumaAika = tapahtuma.getTapahtumaAika();
        String asetettavaPaivaysteksti = muokkaaAsetettavaTapahtumaAika(asetettavaTapahtumaAika);
        
        paivays = new JTextField(asetettavaPaivaysteksti);

        GridBagConstraints paivaykselle = ajankohtaKentanUlkoasu(paivays);
        this.add(paivays, paivaykselle);

        return paivays;
    }
    
    private String muokkaaAsetettavaTapahtumaAika(DateTime asetettavaTapahtumaAika) {
        String pp;
        String kk;
        String vvvv;
        String tt;
        String mm;
        String ss;
        
        if (asetettavaTapahtumaAika.getDayOfMonth() > 9) {
            pp = "" + asetettavaTapahtumaAika.getDayOfMonth();
        } else {
            pp = "0" + asetettavaTapahtumaAika.getDayOfMonth();
        }
        
        if (asetettavaTapahtumaAika.getMonthOfYear() > 9) {
            kk = "" + asetettavaTapahtumaAika.getMonthOfYear();
        } else {
            kk = "0" + asetettavaTapahtumaAika.getMonthOfYear();
        }
        
        // Vuosia ei tarvitse tutkia, koska ohjelma ei kuitenkaan anna käyttäjän
        // tallentaa tapahtumaa vuosiluvulla, joka olisi alle 1000.
        vvvv = "" + asetettavaTapahtumaAika.getYear();
        
        if (asetettavaTapahtumaAika.getHourOfDay() > 9) {
            tt = "" + asetettavaTapahtumaAika.getHourOfDay();
        } else {
            tt = "0" + asetettavaTapahtumaAika.getHourOfDay();
        }
        
        if (asetettavaTapahtumaAika.getMinuteOfHour() > 9) {
            mm = "" + asetettavaTapahtumaAika.getMinuteOfHour();
        } else {
            mm = "0" + asetettavaTapahtumaAika.getMinuteOfHour();
        }
        
        if (asetettavaTapahtumaAika.getSecondOfMinute() > 9) {
            ss = "" + asetettavaTapahtumaAika.getSecondOfMinute();
        } else {
            ss = "0" + asetettavaTapahtumaAika.getSecondOfMinute();
        }
        
        // pp:kk:vvvv,tt:mm:ss
        String asetettavaPaivaysteksti = pp + ":" + kk + ":" + vvvv + "," +
                tt + ":" + mm + ":" + ss;
        
        return asetettavaPaivaysteksti;
    }
    
    private GridBagConstraints ajankohtaKentanUlkoasu(JTextField paivays) {
        paivays.setBackground(Color.DARK_GRAY);
        paivays.setForeground(Color.WHITE);
        GridBagConstraints paivaykselle = new GridBagConstraints();
        paivaykselle.gridx = 1;
        paivaykselle.gridy = 1;

        return paivaykselle;
    }
    
    /** Metodi luo tapahtuman toistuvuusvalintaa osoittavan selitekentän.
     */
    private void luoToistuvuusSeliteKentta() {
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
    private void luoToistuvuusValintalaatikko() {
        String[] valinnat = {"kerran", "kerran sek", "kerran min"};
        JComboBox toistuvuusValinta = new JComboBox(valinnat);
        toistuvuusValinta.setBackground(Color.DARK_GRAY);
        toistuvuusValinta.setForeground(Color.WHITE);
        GridBagConstraints toistuvuusValinnalle = new GridBagConstraints();
        toistuvuusValinnalle.gridx = 1;
        toistuvuusValinnalle.gridy = 2;
        this.add(toistuvuusValinta, toistuvuusValinnalle);
    }
    
    // Aloita-nappi korvataan tallenna-napilla.
    private void luoTallennaNappi() {
        JButton tallenna = new JButton("tallenna");
        tallenna.addActionListener(new TallennaNapinKuuntelija(nimi, paivays, this, ui));
        GridBagConstraints tallennaNapille = new GridBagConstraints();
        tallennaNapille.gridx = 0;
        tallennaNapille.gridy = 3;
        tallennaNapille.gridwidth = 2;
        this.add(tallenna, tallennaNapille);
    }

    public void setTapahtuma(Tapahtuma tapahtuma) {
        this.tapahtuma = tapahtuma;
    }

    public Tapahtuma getTapahtuma() {
        return tapahtuma;
    }
}
