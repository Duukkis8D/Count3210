package count3210.count3210.domain;

import count3210.count3210.ui.Kyselija;
import java.util.Calendar;
import java.util.Scanner;

public class Lahtolaskenta {

    public void kaynnista() {
        
        // Kysytään käyttäjältä päiväys.
        Kyselija kyselija = new Kyselija();
        Calendar tapahtumanAika = kyselija.kysy();
        
        tulostaAika(tapahtumanAika);
        
        aikaKulkeeSekuntiKerrallaan(tapahtumanAika);
    }
    
    public static void tulostaAika(Calendar aika) {
        // Jäljellä oleva aika näytetään käyttäjälle muodossa
        // vuodet : kuukaudet : kuukauden vuorokaudet : vuorokauden tunnit : minuutit : sekunnit
        System.out.println(aika.get(Calendar.YEAR) + " vuotta "
                + aika.get(Calendar.MONTH) + " kuukautta "
                + aika.get(Calendar.DAY_OF_MONTH) + " vuorokautta "
                + aika.get(Calendar.HOUR_OF_DAY) + " tuntia "
                + aika.get(Calendar.MINUTE) + " minuuttia "
                + aika.get(Calendar.SECOND) + " sekuntia\n");
    }
    
    public void aikaKulkeeSekuntiKerrallaan(Calendar tapahtumanAika) {
        
        while (tapahtumanAika.get(Calendar.MINUTE) > 0 &&
                tapahtumanAika.get(Calendar.SECOND) > 0) {
            tapahtumanAika.add(Calendar.SECOND, -1);
            
            try {
                Thread.sleep(1000);
                // Mikä on InterruptedException, jonka Thread.sleep voi heittää?
            } catch (InterruptedException e) {
                System.out.println("Ei onnistunut!");
            }
            
            tulostaAika(tapahtumanAika);
        }
    }

    public void aikaKulkeeCalendar(Calendar tapahtumanAika) {

        int i = 0;
        while (i < 5) {
            // Miinusta aikaa 5 minuuttia aikaNyt-oliosta kokeilun vuoksi.

            tapahtumanAika.add(Calendar.MINUTE, -1);
            
            // Lopullisessa ohjelmassa tapahtumaAika-olion aikaa ja
            // aikaNyt-olion aikaa tulee verrata toisiinsa.
            i++;
        }
        
        tulostaAika(tapahtumanAika);
    }

    public void aikaKulkeeManuaalisesti(Laskuri tunnit, Laskuri minuutit, Laskuri sekunnit) {

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
