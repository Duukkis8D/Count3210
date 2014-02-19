
package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

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
            if (lukija.next().matches("[a-z]|å|ä|ö")) {
                StringBuilder nimenRakentaja = new StringBuilder();
//                nimenRakentaja.append
                Tapahtuma tapahtuma = new Tapahtuma(nimenRakentaja);
            }
            // Nimen tallennuksen jälkeen tapahtuma-muuttujaan tallennetaan
            // aika ja toistuvuus.
        }
        lukija.close();
        
        return tapahtumatiedot;
    }
}
