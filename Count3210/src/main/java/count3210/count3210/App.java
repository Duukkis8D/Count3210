package count3210.count3210;

import count3210.count3210.domain.Laskuri;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

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
        
        // Kysy päiväyksen sekuntien, minuuttien, tuntien,
        // vuorokausien, kuukausien ja vuosien arvo käyttäjältä.
        System.out.print("sekunnit: ");
        int sek = Integer.parseInt(lukija.nextLine());  
        System.out.print("minuutit: ");
        int min = Integer.parseInt(lukija.nextLine()); 
        System.out.print("tunnit: ");
        int tun = Integer.parseInt(lukija.nextLine());
        System.out.println("vuorokaudet: ");
        int vrk = Integer.parseInt(lukija.nextLine());
        System.out.println("kuukaudet: ");
        int kk = Integer.parseInt(lukija.nextLine());
        System.out.println("vuodet: ");
        int vv = Integer.parseInt(lukija.nextLine());

        Calendar aikaNyt = Calendar.getInstance();
        Calendar tapahtumanAika = Calendar.getInstance();
        tapahtumanAika.set
        
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
