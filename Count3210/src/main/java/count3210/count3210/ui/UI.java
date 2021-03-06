package count3210.count3210.ui;

import count3210.count3210.ui.listeners.TyhjennaTapahtumalistaKuuntelija;
import count3210.count3210.ui.listeners.PoistaKaikkiKuuntelija;
import count3210.count3210.ui.listeners.LisaaTapahtumaKuuntelija;
import count3210.count3210.domain.Lahtolaskenta;
import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.utils.TapahtumaruutujenJarjestelija;
import count3210.count3210.utils.Tiedostonlukija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * Luokan tehtävänä on luoda peruskomponentit käyttäjän näkemälle graafiselle
 * käyttöliittymälle ja poistaa niitä tarvittaessa.
 */
public class UI implements Runnable {

    private JFrame frame;
    private JPanel tapahtumapaneeli;
    private TapahtumaruutujenJarjestelija jarjestelija;

    public UI() {
        jarjestelija = new TapahtumaruutujenJarjestelija();
    }

    /** Ohjelman suoritus alkaa tästä metodista ja haarautuu muihin metodeihin
     ja luokkiin.
     */
    @Override
    public void run() {
        frame = new JFrame("Count 3210");
        frame.setPreferredSize(new Dimension(600, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    /** Metodi luo käyttöliittymäkomponentit, joita tarvitaan heti ohjelman
     käynnistyttyä.
     */
    private void luoKomponentit(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        
        luoTapahtumaosio(container);
        luoToimintoOsio(container);
    }
    
    /** Metodi luo ohjelman tapahtumaosion, johon tulee otsikko ja käyttäjän
     * lisäämät lähtölaskentalaskurit.
     */
    private void luoTapahtumaosio(Container container) {
        JTextArea otsikko1 = new JTextArea("Tapahtumat");
        tapahtumapaneeli = luoTapahtumapaneeli();
        tapahtumapaneeli.add(otsikko1);
        luoMuistissaOlevatLaskurit();
        
        container.add(tapahtumapaneeli);
    }
    
    /** Metodi luo ohjelman toiminto-osion, joka sisältää toimintonapit.
     */
    private void luoToimintoOsio(Container container) {
        JTextArea otsikko2 = new JTextArea("Toiminnot");
        JPanel toimintoPaneeli = luoToimintopaneeli();
        toimintoPaneeli.add(otsikko2);
        luoToimintoNapit(toimintoPaneeli);
        
        container.add(toimintoPaneeli);
    }

    /** Metodi luo tyhjän tapahtumapaneelin.
     */
    private JPanel luoTapahtumapaneeli() {
        JPanel paneeli = new JPanel(new GridLayout(8, 1));

        return paneeli;
    }

    /** Metodi luo tyhjän toimintopaneelin.
     */
    private JPanel luoToimintopaneeli() {
        JPanel paneeli = new JPanel(new GridLayout(6, 1));

        return paneeli;
    }

    /** Metodi luo ohjelman käyttöä varten tarpeelliset toimintonapit ja niiden
     * tapahtumankuuntelijat.
     */
    private void luoToimintoNapit(JPanel toimintopaneeli) {
        JButton lisaaTapahtuma = new JButton("lisää tapahtuma");
        lisaaTapahtuma.addActionListener(new LisaaTapahtumaKuuntelija(this));
        JButton jarjesta = new JButton("järjestä tapahtumat");
        JButton tyhjenna = new JButton("tyhjennä tapahtumalista");
        tyhjenna.addActionListener(new TyhjennaTapahtumalistaKuuntelija(this));
        JButton poistaKaikki = new JButton("poista kaikki tapahtumat");
        poistaKaikki.addActionListener(new PoistaKaikkiKuuntelija(this));
        JButton tuoTapahtumia = new JButton(
                "tuo tapahtumia Hotmail-kalenterista");

        lisaaToimintonapitToimintopaneeliin(toimintopaneeli, lisaaTapahtuma, jarjesta, tyhjenna,
                poistaKaikki, tuoTapahtumia);
    }
    
    /** Metodi lisää toimintonapit toimintopaneeliin.
     */
    private void lisaaToimintonapitToimintopaneeliin(JPanel toimintopaneeli, 
            JButton lisaaTapahtuma, JButton jarjesta, JButton tyhjenna, JButton poistaKaikki, 
            JButton tuoTapahtumia) {
        toimintopaneeli.add(lisaaTapahtuma);
        toimintopaneeli.add(jarjesta);
        toimintopaneeli.add(tyhjenna);
        toimintopaneeli.add(poistaKaikki);
        toimintopaneeli.add(tuoTapahtumia);
    }

    /** Metodi luo näytölle lähtölaskentalaskurit, jotka ovat tallennettu
     tiedostoon.
     */
    private void luoMuistissaOlevatLaskurit() {
        Tiedostonlukija lukija = new Tiedostonlukija("laskurit.data");

        if (lukija.onkoTiedostoa()) {
            ArrayList<Tapahtuma> tapahtumatiedot = lukija.tuoLahtolaskentalaskurit();
        
            for (Tapahtuma tapahtuma : tapahtumatiedot) {
                Lahtolaskentaruutu ruutu = new Lahtolaskentaruutu(this);
                ruutu.setTapahtuma(tapahtuma);
                ruutu.luoRuutu();

                lisaaLahtolaskentaruutuTapahtumapaneeliin(ruutu);
                jarjestelija.lisaaListaan(ruutu);

                paivitaLahtolaskentaruudunLahtolaskentaKentta(ruutu);
            }
        }
    }

    // Miten seuraavat lisää ja poista-metodit voisivat hyödyntää
    // TapahtumapaneelinRuutu-interfacea? Olisi kätevää, jos samaa metodia voisi
    // käyttää kaikkien interfacen toteuttavien luokkien (komponenttien)
    // lisäämiseen tai poistamiseen.
    
    /** Metodi lisää TapahtumaruudunRunko-luokan ilmentymän tapahtumapaneeliin
     ja päivittää näkymän.
     * 
     * @param runko Lisättävä TapahtumaruudunRunko-luokan ilmentymä.
     */
    public void lisaaTapahtumaruudunRunkoTapahtumapaneeliin(TapahtumaruudunRunko runko) {
        tapahtumapaneeli.add(runko);
        tapahtumapaneeli.updateUI();
    }

    /** Metodi poistaa TapahtumaruudunRunko-luokan ilmentymän tapahtumapaneelista
     ja päivittää näkymän.
     * 
     * @param runko Poistettava TapahtumaruudunRunko-luokan ilmentymä.
     */
    public void poistaTapahtumaruudunRunkoTapahtumapaneelista(TapahtumaruudunRunko runko) {
        tapahtumapaneeli.remove(runko);
        tapahtumapaneeli.updateUI();
    }

    /** Metodi lisää Lahtolaskentaruutu-luokan ilmentymän tapahtumapaneeliin
     ja päivittää näkymän.
     * 
     * @param lahtolaskentaruutu Lisättävä Lahtolaskentaruutu-luokan ilmentymä.
     */
    public void lisaaLahtolaskentaruutuTapahtumapaneeliin(Lahtolaskentaruutu lahtolaskentaruutu) {
        tapahtumapaneeli.add(lahtolaskentaruutu);
        tapahtumapaneeli.updateUI();
    }

    /** Metodi poistaa Lahtolaskentaruutu-luokan ilmentymän tapahtumapaneelista
     ja päivittää näkymän.
     * 
     * @param lahtolaskentaruutu Poistettava Lahtolaskentaruutu-luokan ilmentymä.
     */
    public void poistaLahtolaskentaruutuTapahtumapaneelista(Lahtolaskentaruutu lahtolaskentaruutu) {
        tapahtumapaneeli.remove(lahtolaskentaruutu);
        tapahtumapaneeli.updateUI();
    }
    
    public void lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(MuokattavaTapahtumaruutu 
            muokattavaTapahtumaruutu) {
        tapahtumapaneeli.add(muokattavaTapahtumaruutu);
        tapahtumapaneeli.updateUI();
    }
    
    public void poistaMuokattavaTapahtumaruutuTapahtumapaneelista(MuokattavaTapahtumaruutu
            muokattavaTapahtumaruutu) {
        tapahtumapaneeli.remove(muokattavaTapahtumaruutu);
        tapahtumapaneeli.updateUI();
    }

    public JFrame getFrame() {
        return frame;
    }

    // Tälle metodille voisi tehdä testit.
    /** Metodi poistaa kaikki ruudut tapahtumapaneelista.
     */
    public void poistaKaikkiTapahtumapaneelinRuudut() {
        ArrayList<TapahtumapaneelinRuutu> ruudut = 
                jarjestelija.getTapahtumaruudut();

        for (TapahtumapaneelinRuutu ruutu : ruudut) {
            // Tyyppimuunnos HaluttuTyyppi muuttuja = (HaluttuTyyppi) vanhaMuuttuja;
            JPanel poistettavaRuutu = (JPanel) ruutu;
            tapahtumapaneeli.remove(poistettavaRuutu);
        }

        tapahtumapaneeli.updateUI();
    }

    public TapahtumaruutujenJarjestelija getTapahtumaruutujenJarjestelija() {
        return jarjestelija;
    }

    // Tälle metodille voisi tehdä testit.
    /** Metodi päivittää lähtölaskentaruudun lähtölaskennan joka sekunti,
     kunnes tapahtuma alkaa.
     * 
     * @param lahtolaskentaruutu Päivitettävä lähtölaskentaruutu.
     */
    public void paivitaLahtolaskentaruudunLahtolaskentaKentta(Lahtolaskentaruutu 
            lahtolaskentaruutu) {
        Lahtolaskenta lahtolaskenta = new Lahtolaskenta(lahtolaskentaruutu, this);
        lahtolaskentaruutu.setLahtolaskenta(lahtolaskenta);

        int viive = 1000;
        Timer ajastin = new Timer(viive, lahtolaskenta);
        ajastin.setInitialDelay(0);
        lahtolaskenta.setAjastin(ajastin);
        ajastin.start();
    }
    
    public void paivitaTapahtumapaneeli() {
        tapahtumapaneeli.updateUI();
    }
    
    public JPanel getTapahtumapaneeli() {
        // Tämä metodi on vain debuggausta varten.
        return tapahtumapaneeli;
    }
}
