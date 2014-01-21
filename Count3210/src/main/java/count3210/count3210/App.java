package count3210.count3210;

import count3210.count3210.domain.Laskuri;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Laskuri sekunnit = new Laskuri(59);
        Laskuri minuutit = new Laskuri(59);
        Laskuri tunnit = new Laskuri(23);

        int sek = 2;
        int min = 1;
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

        // Alla oleva logiikka ei vielä täysin toimi.
        int i = 0;

        while (i < 200) {

            if (tunnit.arvo() > 0) {
                // 05:XX:XX
                if (minuutit.arvo() > 0) {
                    // 05:25:XX
                    if (sekunnit.arvo() > 0) {
                        // 05:25:38
                        sekunnit.seuraava();
                        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    }
                    // 05:25:00
                    minuutit.seuraava();
                    sekunnit.seuraava();
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    // 05:00:00
                } else if (minuutit.arvo() == 0 && sekunnit.arvo() == 0) {
                    tunnit.seuraava();
                    minuutit.seuraava();
                    sekunnit.seuraava();
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    // 05:00:38
                } else if (minuutit.arvo() == 0 && sekunnit.arvo() > 0) {
                    sekunnit.seuraava();
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                }
                // 00:00:38
            } else if (tunnit.arvo() == 0 && minuutit.arvo() == 0
                    && sekunnit.arvo() > 0) {
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                // 00:25:00
            } else if (tunnit.arvo() == 0 && minuutit.arvo() > 0
                    && sekunnit.arvo() == 0) {
                minuutit.seuraava();
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
            }
            
            // Lopeta laskuri, kun kaikki arvot ovat nolla.
            if (tunnit.arvo() == 0 && minuutit.arvo() == 0 && sekunnit.arvo() == 0) {
                break;
            }

            i++;
        }

        // Pitäisikö alla oleva if-lauserakenne kirjoittaa yksinkertaisemmin ja
        // käänteisesti muotoon if tunnit --> if minuutit --> if sekunnit?
        //        int i = 0;
        /* while (tunnit.arvo() > 0 && minuutit.arvo() > 0 && sekunnit.arvo() > 0) {
         System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);

         sekunnit.seuraava();

         if (sekunnit.arvo() == 0) {
         System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
         minuutit.seuraava();
         sekunnit.seuraava();

         // Alla oleva ei toimi oikein tilanteessa 01:00:59 --> 00:59:59.
         if (minuutit.arvo() == 0 && tunnit.arvo() > 0) {
         System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
         sekunnit.seuraava();

         // Mitä tähän pitäisi laittaa?
         } else if (minuutit.arvo() == 0 && tunnit.arvo() == 0) {
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
         } */
    }
}
