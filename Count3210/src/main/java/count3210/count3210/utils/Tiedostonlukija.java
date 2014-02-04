
package count3210.count3210.utils;

import java.util.Scanner;

// Nyt luokka ei lue vielä tiedostoa vaan käyttäjän syötettä.
public class Tiedostonlukija {
    private Scanner lukija;

    public Tiedostonlukija() {
        lukija = new Scanner(System.in);
    }

    public int lueTekstikayttoliittyma() {
        int luku = Integer.parseInt(lukija.nextLine());
        return luku;
    }
    
}
