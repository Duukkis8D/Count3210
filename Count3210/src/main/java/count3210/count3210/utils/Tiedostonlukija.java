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

    public Tiedostonlukija() {
        laskurit = new File("laskurit.data");

        try {
            lukija = new Scanner(laskurit);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt!");
        }
    }

    // Tämä tuo laskurit luokkaan UI, joka näyttää ne ruudulla.
    public ArrayList<Tapahtuma> tuoLahtolaskentalaskurit() {
        ArrayList<Tapahtuma> tapahtumatiedot = new ArrayList<Tapahtuma>();

        while (lukija.hasNextLine()) {
            // Miten kulloisenkin rivin ensimmäisen merkin voi tallentaa
            // StringBuilderilla, kun lukija.next() siirtää aina lukijan
            // sormea seuraavaan merkkiin?
            String tallennettuRivi = new String(lukija.nextLine());
            String[] rivi = tallennettuRivi.split(";");

            Tapahtuma tapahtuma = new Tapahtuma(rivi[0]);
            DateTime tapahtumaAika = new DateTime(Integer.parseInt(rivi[1]), 
                    Integer.parseInt(rivi[2]), Integer.parseInt(rivi[3]), 
                    Integer.parseInt(rivi[4]), Integer.parseInt(rivi[5]), 
                    Integer.parseInt(rivi[6]));
            tapahtuma.setTapahtumaAika(tapahtumaAika);
            tapahtuma.setToistuvuus(rivi[7]);
            
            tapahtumatiedot.add(tapahtuma);
        }
        lukija.close();

        return tapahtumatiedot;
    }
}
