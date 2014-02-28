package count3210.count3210.ui;

import count3210.count3210.ui.listeners.TyhjennaTapahtumalistaKuuntelija;
import count3210.count3210.ui.listeners.PoistaKaikkiKuuntelija;
import count3210.count3210.ui.listeners.LisaaTapahtumaKuuntelija;
import count3210.count3210.domain.Lahtolaskenta;
import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.utils.TapahtumaruutujenJarjestelija;
import count3210.count3210.utils.Tiedostonlukija;
import java.awt.Component;
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
 * käyttöliittymälle.
 */
public class UI implements Runnable {

    private JFrame frame;
    private JPanel tapahtumapaneeli;
    private TapahtumaruutujenJarjestelija jarjestelija;

    public UI() {
        jarjestelija = new TapahtumaruutujenJarjestelija();
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

        // Refaktoroi koodi kahdeksi uudeksi metodiksi:
        // luoTapahtumaosio ja luoToimintoOsio.
        JTextArea otsikko1 = new JTextArea("Tapahtumat");
        tapahtumapaneeli = luoTapahtumapaneeli();
        tapahtumapaneeli.add(otsikko1);
        luoMuistissaOlevatLaskurit();
        container.add(tapahtumapaneeli);

        JTextArea otsikko2 = new JTextArea("Toiminnot");
        JPanel toimintoPaneeli = luoToimintopaneeli();
        toimintoPaneeli.add(otsikko2);
        container.add(toimintoPaneeli);
        luoToimintonappulat(toimintoPaneeli);
    }

    private JPanel luoTapahtumapaneeli() {
        JPanel paneeli = new JPanel(new GridLayout(8, 1));

        return paneeli;
    }

    private JPanel luoToimintopaneeli() {
        JPanel paneeli = new JPanel(new GridLayout(6, 1));

        return paneeli;
    }

    private void luoToimintonappulat(JPanel toimintopaneeli) {
        JButton lisaaTapahtuma = new JButton("lisää tapahtuma");
        lisaaTapahtuma.addActionListener(new LisaaTapahtumaKuuntelija(this));
        JButton jarjesta = new JButton("järjestä tapahtumat");
        JButton tyhjenna = new JButton("tyhjennä tapahtumalista");
        tyhjenna.addActionListener(new TyhjennaTapahtumalistaKuuntelija(this));
        JButton poistaKaikki = new JButton("poista kaikki tapahtumat");
        poistaKaikki.addActionListener(new PoistaKaikkiKuuntelija(this));
        JButton tuoTapahtumia = new JButton(
                "tuo tapahtumia Hotmail-kalenterista");

        toimintopaneeli.add(lisaaTapahtuma);
        toimintopaneeli.add(jarjesta);
        toimintopaneeli.add(tyhjenna);
        toimintopaneeli.add(poistaKaikki);
        toimintopaneeli.add(tuoTapahtumia);
    }

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

    // Miten tämä ja poista-metodi voisi hyödyntää TapahtumapaneelinRuutu-interfacea? Olisi
    // kätevää, jos samaa metodia voisi käyttää kaikkien interfacen toteuttavien
    // luokkien (komponenttien) lisäämiseen tai poistamiseen.
    public void lisaaTapahtumaruudunRunkoTapahtumapaneeliin(TapahtumaruudunRunko runko) {
        tapahtumapaneeli.add(runko);
        tapahtumapaneeli.updateUI();
    }

    public void poistaTapahtumaruudunRunkoTapahtumapaneelista(TapahtumaruudunRunko runko) {
        tapahtumapaneeli.remove(runko);
        
        // Debuggausta -->
//        for (Component komponentti : tapahtumapaneeli.getComponents()) {
//            if (komponentti.getClass().getName().contains("TapahtumaruudunRunko")) {
//                TapahtumaruudunRunko verrattavaRuutu = (TapahtumaruudunRunko) komponentti;
//                if (verrattavaRuutu.equals(runko)) {    // Tee equals-metodi
//                                                        // TapahtumaruudunRunko-luokalle tai
//                                                        // jokin muu erottelutapa.
//                    System.out.println("Ruudun poistaminen ei onnistunut.");
//                }
//            }
//        }
        // <--
        
        tapahtumapaneeli.updateUI();
    }

    public void lisaaLahtolaskentaruutuTapahtumapaneeliin(Lahtolaskentaruutu lahtolaskentaruutu) {
        tapahtumapaneeli.add(lahtolaskentaruutu);
        tapahtumapaneeli.updateUI();
    }

    public void poistaLahtolaskentaruutuTapahtumapaneelista(Lahtolaskentaruutu lahtolaskentaruutu) {
        tapahtumapaneeli.remove(lahtolaskentaruutu);
        tapahtumapaneeli.updateUI();
    }
    
//    public void lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(
//            MuokattavaTapahtumaruutu ruutu, int indeksi) {
//        tapahtumapaneeli.add(ruutu, indeksi);
//        
//        // setComponentZOrder(Component comp, int index)
//        //Moves the specified component to the specified z-order index in the container.
//    }
    
    public int getLahtolaskentaruudunIndeksi(Lahtolaskentaruutu ruutu) {
//        getComponentZOrder(Component comp)
//Returns the z-order index of the component inside the container.

        return tapahtumapaneeli.getComponentZOrder(ruutu);
    }

    public JFrame getFrame() {
        return frame;
    }

    // Tälle metodille voisi tehdä testit.
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
