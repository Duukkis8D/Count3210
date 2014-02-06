package count3210.count3210.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class UI implements Runnable {

    private JFrame frame;
    private JPanel tapahtumapaneeli;

    public UI() {

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
        JPanel paneeli = new JPanel(new GridLayout(4, 1));

        return paneeli;
    }

    private void luoToimintonappulat(JPanel toimintopaneeli) {
        JButton lisaaTapahtuma = new JButton("lisää tapahtuma");
        lisaaTapahtuma.addActionListener(new LisaaTapahtumaKuuntelija(this));
        JButton poistaKaikki = new JButton("poista kaikki tapahtumat");
        JButton tuoTapahtumia = new JButton("tuo tapahtumia Hotmail-kalenterista");

        toimintopaneeli.add(lisaaTapahtuma);
        toimintopaneeli.add(poistaKaikki);
        toimintopaneeli.add(tuoTapahtumia);
    }

    public void lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(MuokattavaTapahtumaruutu ruutu) {
        tapahtumapaneeli.add(ruutu);
        tapahtumapaneeli.updateUI();
    }
    
    public void poistaMuokattavaTapahtumaruutuTapahtumapaneelista(MuokattavaTapahtumaruutu ruutu) {
        tapahtumapaneeli.remove(ruutu);
        tapahtumapaneeli.updateUI();
    }

    public JFrame getFrame() {
        return frame;
    }

}
