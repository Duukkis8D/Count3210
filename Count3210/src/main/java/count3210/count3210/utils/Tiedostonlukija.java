package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.joda.time.DateTime;

public class Tiedostonlukija {

    private File laskurit;
    private Scanner lukija;

    public Tiedostonlukija(String tiedostonNimi) {
        laskurit = new File(tiedostonNimi);

        try {
            lukija = new Scanner(laskurit);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt! \n" + e.getMessage());
        }
    }

    public boolean onkoTiedostoa() {
        if (laskurit.exists()) {
            return true;
        } else {
            return false;
        }
    }

    // Tämä tuo laskurit luokkaan UI, joka näyttää ne ruudulla.
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
}
