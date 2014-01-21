package count3210.count3210;

import count3210.count3210.domain.Laskuri;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Laskuri sekunnit = new Laskuri(59);
        Laskuri minuutit = new Laskuri(59);
        Laskuri tunnit = new Laskuri(23);
        
        int sek = 3;
        int min = 5;
        int tun = 1;

//        System.out.print("sekunnit: ");
//        int sek = Integer.parseInt(lukija.nextLine());  // kysy sekuntien alkuarvo käyttäjältä
//        System.out.print("minuutit: ");
//        int min = Integer.parseInt(lukija.nextLine());  // kysy minuuttien alkuarvo käyttäjältä
//        System.out.print("tunnit: ");
//        int tun = Integer.parseInt(lukija.nextLine());  // kysy tuntien alkuarvo käyttäjältä

        // Jokaiselle oliolle tulee omat oliomuuttuja-arvonsa,
        // joita alla olevassa while-loopissa muutetaan metodin avulla.
        sekunnit.asetaArvo(sek);
        minuutit.asetaArvo(min);
        tunnit.asetaArvo(tun);

//        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
        aikaKulkee(tunnit, minuutit, sekunnit);

    }

    public static void aikaKulkee(Laskuri tunnit, Laskuri minuutit, Laskuri sekunnit) {
//        int i = 0;
        while (tunnit.arvo() > -1 && minuutit.arvo() > -1 && sekunnit.arvo() > -1) {
            System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);

            sekunnit.seuraava();

            if (sekunnit.arvo() == 0) {
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                minuutit.seuraava();
                sekunnit.seuraava();

                if (minuutit.arvo() == 0) {
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    tunnit.seuraava();
                    minuutit.seuraava();

                    // Tämä suoritetaan vasta sitten, kun sekunnit, minuutit ja tunnit ovat nolla,
                    // eli vuorokausi vaihtuu.
                    if (tunnit.arvo() == 0) {
                        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
//                        sekunnit.seuraava();
                    }
                }
            }
//            i++;
        }
    }
}
