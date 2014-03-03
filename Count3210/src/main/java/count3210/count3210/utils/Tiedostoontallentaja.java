package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/** Luokan tehtävänä on tallentaa tiedostoon käyttäjän luoman
 * lähtölaskentatapahtuman ominaisuudet.
 */
public class Tiedostoontallentaja {

    private Scanner lukija;
    private File laskurit;

    /** Konstruktori avaa lähtölaskentatapahtumat sisältävän tiedoston lukijan
     * käyttöön.
     * 
     * @param tiedostonNimi Avattavan tiedoston nimi tiedostojärjestelmässä.
     */
    public Tiedostoontallentaja(String tiedostonNimi) {
        laskurit = new File(tiedostonNimi);

        try {
            if (!laskurit.exists()) laskurit.createNewFile();
            lukija = new Scanner(laskurit);
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Tiedostonkäsittelyssä tapahtui virhe!" 
                    + "\n\n" + fnfe.getMessage(), "Virhe", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Tiedostonkäsittelyssä tapahtui virhe!" 
                    + "\n\n" + ioe.getMessage(), "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Metodi tallentaa tapahtuman tiedot tiedostoon.
     * 
     * @param tapahtuma Tallennettava tapahtuma.
     */
    public void tallennaTiedostoon(Tapahtuma tapahtuma) {
        // Testaa että tiedostoon tallentuu oikeat arvot.
        try {
            FileWriter tallentaja = new FileWriter(laskurit, true);
            tallentaja.append(tapahtuma.getNimi() + ";");
            tallentaja.append(tapahtuma.getTapahtumaAika().getYear() + ";"
                    + tapahtuma.getTapahtumaAika().getMonthOfYear() + ";"
                    + tapahtuma.getTapahtumaAika().getDayOfMonth() + ";"
                    + tapahtuma.getTapahtumaAika().getHourOfDay() + ";"
                    + tapahtuma.getTapahtumaAika().getMinuteOfHour() + ";"
                    + tapahtuma.getTapahtumaAika().getSecondOfMinute() + ";");
            tallentaja.append(tapahtuma.getToistuvuus() + "\n");
            tallentaja.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Tapahtumaa ei voitu tallentaa ohjelman muistiin." 
                    + "\n\n" + ioe.getMessage(), "Virhe", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Metodi poistaa kaikki lähtölaskentatapahtumat sisältävän tiedoston.
     */
    public void poistaTiedosto() {
        laskurit.delete();
    }

    /** Metodi poistaa tietyn tapahtuman tiedot ohjelman pitkäaikaismuistista
     * kirjoittamalla kokonaan uudestaan lähtölaskentatapahtumat sisältävän
     * tiedoston.
     * 
     * @param tapahtuma Poistettava tapahtuma.
     */
    public void poistaTapahtumaTiedostosta(Tapahtuma tapahtuma) {
        File valiaikainen = new File("valiaikainen.data");
        String tapahtumaTekstina = tapahtuma.getNimi() + ";"
                + tapahtuma.getTapahtumaAika().getYear() + ";"
                + tapahtuma.getTapahtumaAika().getMonthOfYear() + ";"
                + tapahtuma.getTapahtumaAika().getDayOfMonth() + ";"
                + tapahtuma.getTapahtumaAika().getHourOfDay() + ";"
                + tapahtuma.getTapahtumaAika().getMinuteOfHour() + ";"
                + tapahtuma.getTapahtumaAika().getSecondOfMinute();

        FileWriter valiaikaistallentaja;
        try {
            valiaikaistallentaja = new FileWriter(valiaikainen, true);

            while (lukija.hasNextLine()) {
                String luettavaRivi = lukija.nextLine();
                
                if (luettavaRivi.contains(tapahtumaTekstina)) {
                    continue;
                }
                valiaikaistallentaja.append(luettavaRivi + "\n");
            }
            valiaikaistallentaja.close();

        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Tapahtuman poistaminen ei onnistunut." 
                    + "\n\n" + ioe.getMessage(), "Virhe", JOptionPane.ERROR_MESSAGE);
        }
        lukija.close();

        laskurit.delete();
        valiaikainen.renameTo(laskurit);
    }

    public File getTiedosto() {
        return laskurit;
    }
}
