package count3210.count3210.ui;

import count3210.count3210.utils.TapahtumaruutujenJarjestelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import org.joda.time.Period;

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

        JTextArea otsikko1 = new JTextArea("Tapahtumat");
        tapahtumapaneeli = luoTapahtumapaneeli();
        tapahtumapaneeli.add(otsikko1);
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
        JPanel paneeli = new JPanel(new GridLayout(5, 1));

        return paneeli;
    }

    private void luoToimintonappulat(JPanel toimintopaneeli) {
        JButton lisaaTapahtuma = new JButton("lisää tapahtuma");
        lisaaTapahtuma.addActionListener(new LisaaTapahtumaKuuntelija(this));
        JButton jarjesta = new JButton("järjestä tapahtumat");
        JButton poistaKaikki = new JButton("poista kaikki tapahtumat");
        poistaKaikki.addActionListener(new PoistaKaikkiKuuntelija(this));
        JButton tuoTapahtumia = new JButton("tuo tapahtumia Hotmail-kalenterista");

        toimintopaneeli.add(lisaaTapahtuma);
        toimintopaneeli.add(jarjesta);
        toimintopaneeli.add(poistaKaikki);
        toimintopaneeli.add(tuoTapahtumia);
    }

    // Miten tämä ja poista-metodi voisi hyödyntää TapahtumapaneelinRuutu-interfacea? Olisi
    // kätevää, jos samaa metodia voisi käyttää sekä MuokattavaTapahtumaruutu- että Lahtolaskenta-
    // ruutu-tyyppisten komponenttien lisäämiseen tai poistamiseen.
    public void lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(MuokattavaTapahtumaruutu ruutu) {
        tapahtumapaneeli.add(ruutu);
        tapahtumapaneeli.updateUI();
    }

    public void poistaMuokattavaTapahtumaruutuTapahtumapaneelista(MuokattavaTapahtumaruutu ruutu) {
        tapahtumapaneeli.remove(ruutu);
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

    public JFrame getFrame() {
        return frame;
    }

    public void poistaKaikkiTapahtumapaneelinRuudut() {
        ArrayList<TapahtumapaneelinRuutu> ruudut = jarjestelija.getTapahtumaruudut();

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

    public void paivitaLahtolaskentaruudunLahtolaskentaKentta(Lahtolaskentaruutu lahtolaskentaruutu,
            Period ajanjakso) {
        /*
         19:22 <@ransum> nyt sulla on toi Thread.sleep väärässä threadissa
         19:23 <@ransum> tää menee nyt vähän rinnakkaisohjelmoinnin puolelle, mut graafinen käli ja ohjelmalogiikka saatetaan suorittaa eri 
         threadeissa
         19:23 <@ransum> tl;dr: sun pitäis saada toi thread.sleep looppeineen kälin sisään
         19:24 <@ransum> esim. run()-metodin sisään tai sieltä kutsuttavaan omaan metodiinsa
         19:24 < duukkis> Eli pitäisi laittaa se odottaminen UI-luokkaan, joka on runnable.
         19:24 <@ransum> jeps
         19:25 < duukkis> Siinä onkin miettimistä.
         19:26 < duukkis> Mut eiköhän se onnistu. (:
         19:26 <@ransum> voit harkita vaikka jonkinlaista etene()-metodia, joka tulisi tuonne Lahtolaskenta-luokkaan
         19:26 <@ransum> jota sitten kutsuttaisiin kälin puolelta loopista
         19:26 <@ransum> tjsp
         */

        // Seuraava jumitti ohjelman, kun se oli Lahtolaskenta-luokassa.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Ei onnistunut!");
        }

        lahtolaskentaruutu.paivitaLahtolaskentaKentta(ajanjakso);

        tapahtumapaneeli.updateUI();
    }

}
