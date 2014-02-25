
package count3210.count3210.ui;

import count3210.count3210.domain.Lahtolaskenta;
import count3210.count3210.domain.Tapahtuma;
import count3210.count3210.ui.listeners.LahtolaskentaruudunPoistaNapinKuuntelija;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.joda.time.Period;

/** Luokan tehtävä on näyttää käyttäjälle hänen luomansa lähtölaskentatapahtuman
 * graafinen käyttöliittymä.
 */
public class Lahtolaskentaruutu extends JPanel implements TapahtumapaneelinRuutu {
    private Tapahtuma tapahtuma;
    private JTextArea tapahtumanNimi;
    private JTextArea lahtolaskentaKentta;
    private int aikayksikkoja;
    private Lahtolaskenta lahtolaskenta;
    private UI ui;
    
    /** Konstruktori asettaa aikayksikkoja-muuttujan arvoksi 99, joka on
     satunnaisesti valittu luku. Luvun tulee olla yli nolla, jotta UI-luokan
     (Timer) ajastin toimii.
     */
    public Lahtolaskentaruutu(UI ui) {
        this.ui = ui;
        this.aikayksikkoja = 99;
    }
    
    /** Metodi luo tämän olion ulkoiset puitteet ja sisällön.
     */
    public void luoRuutu() {
        luoRuudunUlkonako();
        luoRuudunSisalto();
        setTapahtumanNimi();
    }
    
    /** Metodi luo tämän olion ulkoiset puitteet.
     */
    public void luoRuudunUlkonako() {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        // Kokoa ei pysty asettamaan ehkä siksi, koska tapahtumaPaneeli käyttää
        // GridLayoutia, jossa on ennalta määrätyn verran ruutuja.
//        tapahtumaRuutu.setSize(100, 100);
        this.setBackground(Color.BLUE);
        this.setForeground(Color.WHITE);
    }
    
    /** Metodi luo tämän olion sisällön.
     */
    public void luoRuudunSisalto() {
        luoTapahtumaKentta();
        luoLahtolaskentaKentta();
        luoPoistaNappi();
        luoMuokkaaNappi();
        luoIlmoitinalue();
    }
    
    /** Metodi luo tämän olion tapahtumatekstikentän, jossa näkyy käyttäjän
     * syöttämä tapahtuman nimi. Toistaiseksi siinä näkyy kuitenkin vain teksti
     * "tapahtuman nimi".
     */
    public void luoTapahtumaKentta() {
        tapahtumanNimi = new JTextArea();
        tapahtumanNimi.setBackground(Color.BLUE);
        tapahtumanNimi.setForeground(Color.WHITE);
        GridBagConstraints tapahtumanNimelle = new GridBagConstraints();
        tapahtumanNimelle.gridx = 0;
        tapahtumanNimelle.gridy = 0;
        tapahtumanNimelle.gridwidth = 3;
        this.add(tapahtumanNimi, tapahtumanNimelle);
    }
    
    /** Metodi luo lähtölaskentatekstikentän, jossa näkyy jäljellä oleva
     aika käyttäjän luomaan tapahtumaan.
     */
    public void luoLahtolaskentaKentta() {
        lahtolaskentaKentta = new JTextArea("tähän lähtölaskenta");
        lahtolaskentaKentta.setBackground(Color.BLUE);
        lahtolaskentaKentta.setForeground(Color.WHITE);
        GridBagConstraints lahtolaskennalle = new GridBagConstraints();
        lahtolaskennalle.gridx = 0;
        lahtolaskennalle.gridy = 1;
        lahtolaskennalle.gridwidth = 3;
        this.add(lahtolaskentaKentta, lahtolaskennalle);
    }
    
    /** Metodi luo poista-napin, jolla voi poistaa koko
     * Lahtolaskentaruutu-luokan ilmentymän ohjelman muistista.
     */
    public void luoPoistaNappi() {
        JButton poista = new JButton("poista");
        poista.addActionListener(new LahtolaskentaruudunPoistaNapinKuuntelija(
                ui, this));
        GridBagConstraints poistaNapille = new GridBagConstraints();
        poistaNapille.gridx = 0;
        poistaNapille.gridy = 2;
        this.add(poista, poistaNapille);
    }
    
    /** Metodi luo muokkaa-napin, jolla voi muokata käyttäjän luomaa
     tapahtumaa graafisen käyttöliittymän kautta. Nykyisellään nappi ei
     kuitenkaan tee vielä mitään.
     */
    public void luoMuokkaaNappi() {
        JButton muokkaa = new JButton("muokkaa");
        GridBagConstraints muokkaaNapille = new GridBagConstraints();
        muokkaaNapille.gridx = 1;
        muokkaaNapille.gridy = 2;
        this.add(muokkaa, muokkaaNapille);
    }
    
    /** Metodi luo ilmoitinalueen, johon on myöhemmin tarkoitus tulla symbolit
     tapahtuman ominaisuuksille: hälytys ja toistuvuus.
     */
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
    
    public JTextArea getLahtolaskentaKentta() {
        return lahtolaskentaKentta;
    }

    /** Metodi päivittää lähtölaskentatekstikentän, jossa näkyy kulloinkin
     * jäljellä oleva aika tapahtuman alkuun.
     * 
     * @param ajanjakso Ajanjakso sisältää kaikki tapahtumaan jäljellä olevan
     * ajan aikayksiköt. Niistä metodissa tulostetaan vuodet, kuukaudet,
     * vuorokaudet, tunnit, minuutit ja sekunnit.
     */
    public void paivitaLahtolaskentaKentta(Period ajanjakso) {
        lahtolaskentaKentta.setText(ajanjakso.getYears() + " v "
                + ajanjakso.getMonths() + " kk "
                + ajanjakso.getWeeks() + " vkoa "
                + ajanjakso.getDays() + " vrk "
                + ajanjakso.getHours() + " t "
                + ajanjakso.getMinutes() + " min "
                + ajanjakso.getSeconds() + " sek");
        
        this.updateUI();
    }
    
    /** Metodi asettaa tapahtumanNimi-kenttään käyttäjän syöttämän tapahtuman
     nimen.
     */
    public void setTapahtumanNimi() {
        tapahtumanNimi.setText(tapahtuma.getNimi());
    }
    
    /** Metodi asettaa tälle oliolle aikayksikköarvon, joka saadaan
     summaamalla tietyt Period luokan ilmentymän kenttien arvot. (Kun
     * aikayksikkoja-muuttujan arvo vähenee nollaan, lähtölaskennan tulisi
     * pysähtyä.)
     * 
     * @param aikayksikkoja Aikayksikköjen lukumäärä.
     */
    public void setAikayksikkoja(int aikayksikkoja) {
        this.aikayksikkoja = aikayksikkoja;
    }
    
    public int getAikayksikkoja() {
        return aikayksikkoja;
    }

    public void setLahtolaskenta(Lahtolaskenta lahtolaskenta) {
        this.lahtolaskenta = lahtolaskenta;
    }
    
    public Lahtolaskenta getLahtolaskenta() {
        return lahtolaskenta;
    }
}
