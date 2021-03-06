package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.joda.time.DateTime;

/** Luokka lukee tapahtumatiedot ohjelman pitkäaikaisesta muistista.
 */
public class Tiedostonlukija {

    private File laskurit;
    private Scanner lukija;

    /** Konstruktori avaa lähtölaskentatapahtumat sisältävän tiedoston lukijan
     * käyttöön.
     * 
     * @param tiedostonNimi Avattavan tiedoston nimi tiedostojärjestelmässä.
     */
    public Tiedostonlukija(String tiedostonNimi) {
        laskurit = new File(tiedostonNimi);

        try {
            if (!onkoTiedostoa()) laskurit.createNewFile();
            lukija = new Scanner(laskurit);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Tiedostoa ei löytynyt! \n" + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("Tiedostoa ei voitu luoda! \n" + ioe.getMessage());
        }
    }

    /** Metodi tarkistaa, onko pyydettyä tiedostoa olemassa.
     * 
     * @return true: Tiedosto on olemassa. false: Tiedostoa ei ole olemassa.
     */
    public boolean onkoTiedostoa() {
        if (laskurit.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /** Metodi tuo tapahtumatiedot ohjelman väliaikaismuistiin, josta ne
     * myöhemmin luetaan graafisen käyttöliittymän kautta käyttäjän nähtäville.
     * 
     * @return Lista ohjelmaan tallennetuista tapahtumista.
     */
    public ArrayList<Tapahtuma> tuoLahtolaskentalaskurit() {
        ArrayList<Tapahtuma> tapahtumatiedot = new ArrayList<>();

        // Testeissä while-rivi heittää NullPointerException. Ohjelma kuitenkin
        // toimii halutunlaisesti. Mistä johtuu?
        while (lukija.hasNextLine()) {
            String tallennettuRivi = lukija.nextLine();
            String[] tapahtumaTekstina = tallennettuRivi.split(";");
            teeTapahtumatoimenpiteet(tapahtumaTekstina, tapahtumatiedot);
        }
        lukija.close();

        return tapahtumatiedot;
    }

    /** Metodi erottelee luetun tapahtumatietorivin tapahtumatiedot ja tallentaa
     * ne tapahtuman tietokenttiin.
     * 
     * @param tapahtumaTekstina Tapahtuman nimi, ajankohta ja toistuvuus
     * merkkijonomuodossa.
     * @param tapahtumatiedot Lista tapahtumista.
     */
    public void teeTapahtumatoimenpiteet(String[] tapahtumaTekstina,
            ArrayList<Tapahtuma> tapahtumatiedot) {
        Tapahtuma tapahtuma = new Tapahtuma(tapahtumaTekstina[0]);
        DateTime tapahtumaAika = new DateTime(
                Integer.parseInt(tapahtumaTekstina[1]),
                Integer.parseInt(tapahtumaTekstina[2]), 
                Integer.parseInt(tapahtumaTekstina[3]),
                Integer.parseInt(tapahtumaTekstina[4]), 
                Integer.parseInt(tapahtumaTekstina[5]),
                Integer.parseInt(tapahtumaTekstina[6]));
        tapahtuma.setTapahtumaAika(tapahtumaAika);
        tapahtuma.setToistuvuus(tapahtumaTekstina[7]);

        tapahtumatiedot.add(tapahtuma);
    }
    
    public File getTiedosto() {
        return laskurit;
    }
    
    public Scanner getLukija() {
        return lukija;
    }
}
