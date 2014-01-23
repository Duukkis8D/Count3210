package count3210.count3210.domain;

import count3210.count3210.ui.Kyselija;
import java.util.Calendar;
import java.util.Scanner;

public class Lahtolaskenta {

    public void kaynnista() {

//        Laskuri sekunnit = new Laskuri(59);
//        Laskuri minuutit = new Laskuri(59);
//        Laskuri tunnit = new Laskuri(23);
        
//        int sek = 0;
//        int min = 0;
//        int tun = 3;
        
        // Tätä pitäisi muuttaa niin, että kysytään käyttäjältä päiväys.
//        System.out.print("sekunnit: ");
//        int sek = Integer.parseInt(lukija.nextLine());  // kysy sekuntien alkuarvo käyttäjältä
//        System.out.print("minuutit: ");
//        int min = Integer.parseInt(lukija.nextLine());  // kysy minuuttien alkuarvo käyttäjältä
//        System.out.print("tunnit: ");
//        int tun = Integer.parseInt(lukija.nextLine());  // kysy tuntien alkuarvo käyttäjältä
//        
//        sekunnit.asetaArvo(sek);
//        minuutit.asetaArvo(min);
//        tunnit.asetaArvo(tun);
//
//        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
        
//        aikaKulkee(tunnit, minuutit, sekunnit);
        
        Calendar aikaNyt = Calendar.getInstance();

        System.out.println("vuodet: " + aikaNyt.get(Calendar.YEAR) + "\n"
                + "kuukaudet: " + aikaNyt.get(Calendar.MONTH) + "\n"
                + "vuorokaudet: " + aikaNyt.get(Calendar.DAY_OF_MONTH) + "\n"
                + "tunnit: " + aikaNyt.get(Calendar.HOUR_OF_DAY) + "\n"
                + "minuutit: " + aikaNyt.get(Calendar.MINUTE) + "\n"
                + "sekunnit: " + aikaNyt.get(Calendar.SECOND) + "\n");

        Kyselija kyselija = new Kyselija();

        // Jäljellä oleva aika näytetään käyttäjälle muodossa
        // vuodet : kuukaudet : kuukauden vuorokaudet : vuorokauden tunnit : minuutit : sekunnit
        System.out.println("vuodet: " + tapahtumanAika.get(Calendar.YEAR) + "\n"
                + "kuukaudet: " + tapahtumanAika.get(Calendar.MONTH) + "\n"
                + "vuorokaudet: " + tapahtumanAika.get(Calendar.DAY_OF_MONTH) + "\n"
                + "tunnit: " + tapahtumanAika.get(Calendar.HOUR_OF_DAY) + "\n"
                + "minuutit: " + tapahtumanAika.get(Calendar.MINUTE) + "\n"
                + "sekunnit: " + tapahtumanAika.get(Calendar.SECOND));
        int i = 0;
        while (i < 5) {
            // Miinusta aikaa 5 minuuttia aikaNyt-oliosta kokeilun vuoksi.

            // Lopullisessa ohjelmassa tapahtumaAika-olion aikaa ja
            // aikaNyt-olion aikaa tulee verrata toisiinsa.
            i++;
        }

//        aikaKulkeeCalendar();
    }

    public static void aikaKulkeeCalendar() {

        Calendar aika = Calendar.getInstance();
        System.out.println(aika.get(Calendar.DATE));

        aika.add(Calendar.DATE, 5);
        System.out.println(aika.get(Calendar.DATE));

    }

    public static void aikaKulkee(Laskuri tunnit, Laskuri minuutit, Laskuri sekunnit) {

        while (true) {

            if (tunnit.getArvo() > 0) {
                // 05:XX:XX
                if (minuutit.getArvo() > 0) {
                    // 05:25:XX
                    if (sekunnit.getArvo() > 0) {
                        // 05:25:38
                        sekunnit.seuraava();
                        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                        // 05:25:00
                    } else if (sekunnit.getArvo() == 0) {
                        minuutit.seuraava();
                        sekunnit.seuraava();
                        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    }
                    // 05:00:00
                } else if (minuutit.getArvo() == 0 && sekunnit.getArvo() == 0) {
                    tunnit.seuraava();
                    minuutit.seuraava();
                    sekunnit.seuraava();
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    // 05:00:38
                } else if (minuutit.getArvo() == 0 && sekunnit.getArvo() > 0) {
                    sekunnit.seuraava();
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                }
                // 00:00:38
            } else if (tunnit.getArvo() == 0 && minuutit.getArvo() == 0
                    && sekunnit.getArvo() > 0) {
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                // 00:25:38
            } else if (tunnit.getArvo() == 0 && minuutit.getArvo() > 0
                    && sekunnit.getArvo() > 0) {
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                // 00:25:00
            } else if (tunnit.getArvo() == 0 && minuutit.getArvo() > 0
                    && sekunnit.getArvo() == 0) {
                minuutit.seuraava();
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
            }

            // Lopeta laskuri, kun kaikki arvot ovat nolla.
            if (tunnit.getArvo() == 0 && minuutit.getArvo() == 0 && sekunnit.getArvo() == 0) {
                break;
            }
        }
    }
}
