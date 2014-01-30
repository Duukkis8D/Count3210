package count3210.count3210.domain;

import count3210.count3210.ui.Kyselija;
import java.util.Calendar;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class Lahtolaskenta {

    public void kaynnista() {

        Calendar aikaNyt = Calendar.getInstance();
        DateTime aikaNyt2 = new DateTime();
        // Tulostetaan kokeeksi tämänhetkinen päiväys.
        System.out.println("Calendar:");
        tulostaAikaCalendar(aikaNyt);
        System.out.println("DateTime:");
        tulostaAikaDateTime(aikaNyt2);

        // Kysytään käyttäjältä päiväys.
        Kyselija kyselija = new Kyselija();
//        Calendar tapahtumanAika = kyselija.kysyCalendar();
        DateTime tapahtumanAika2 = kyselija.kysyDateTime();
        
//        tulostaAikaCalendar(tapahtumanAika);
        tulostaAikaDateTime(tapahtumanAika2);
        
//        aikaKulkeeAikojenErotuksestaCalendar(aikaNyt, tapahtumanAika);
        aikaKulkeeAikojenErotuksestaDateTime(aikaNyt2, tapahtumanAika2);
        
    }

    public static void tulostaAikaPeriod(Period ajanjakso) {
        
        System.out.println(ajanjakso.getYears() + " vuotta " 
                + ajanjakso.getMonths() + " kuukautta "
                + ajanjakso.getDays() + " vuorokautta "
                + ajanjakso.getHours() + " tuntia "
                + ajanjakso.getMinutes() + " minuuttia "
                + ajanjakso.getSeconds() + " sekuntia ");
    }
    
    public static void tulostaAikaDateTime(DateTime aika) {
        System.out.println("\n" + aika.toString() + "\n");
//        DateTimeFormatter dtf = DateTimeFormat.forPattern(
//                "yyyy, MMMM");
//        System.out.println("\n" + dtf.print(aika) + "\n");
    }
    
    public static void tulostaLahtolaskentaDuration(Duration aika) {
        
    }
    
    public static void tulostaAikaCalendar(Calendar aika) {

        // Tämä tulostaa väärin ainakin tapaukset, joissa kahden päiväyksen
        // erotuksessa on 0 kuukautta. Erotuksen tulostukseen pitää olla
        // oma metodinsa, jossa kuukauteen ei summatta ykköstä.
        
        // Kuukausi pitänee tallentaa välillisesti muuttujaan,
        // jotta sen saa tulostettua oikein.
        int kk = aika.get(Calendar.MONTH) + 1;

        System.out.println("\n" + aika.get(Calendar.YEAR) + " vuotta "
                + kk + " kuukautta "
                + aika.get(Calendar.DAY_OF_MONTH) + " vuorokautta "
                + aika.get(Calendar.HOUR_OF_DAY) + " tuntia "
                + aika.get(Calendar.MINUTE) + " minuuttia "
                + aika.get(Calendar.SECOND) + " sekuntia\n");
    }
    
    public static void tulostaLahtolaskentaCalendar(Calendar aika) {
        System.out.println("\n" + aika.get(Calendar.YEAR) + " vuotta "
                + aika.get(Calendar.MONTH) + " kuukautta "
                + aika.get(Calendar.DAY_OF_MONTH) + " vuorokautta "
                + aika.get(Calendar.HOUR_OF_DAY) + " tuntia "
                + aika.get(Calendar.MINUTE) + " minuuttia "
                + aika.get(Calendar.SECOND) + " sekuntia\n");
    }
    
    public void aikaKulkeeAikojenErotuksestaDateTime(DateTime aikaNyt2, DateTime tapahtumanAika2) {

        DateTime tallennettavaTapahtumaAika = new DateTime();
        tallennettavaTapahtumaAika = tapahtumanAika2;
        
//        Period ajanjakso = new Period(aikaNyt2, tapahtumanAika2);
//        
//        System.out.println("Erotus:");
//        tulostaAikaPeriod(ajanjakso);       
//        System.out.println();
//
//        int i = 0;
//        while (i < 51) {
//            ajanjakso = ajanjakso.minusSeconds(1);
//
//            try {
//                Thread.sleep(1000);
//                // Mikä on InterruptedException, jonka Thread.sleep voi heittää?
//            } catch (InterruptedException e) {
//                System.out.println("Ei onnistunut!");
//            }
//
//            tulostaAikaPeriod(ajanjakso);
//            i++;
//        }
        System.out.println("Erotus:");
        
        int i = 0;
        while (i < 51) {
            DateTime nyt = DateTime.now();

            try {
                Thread.sleep(1000);
                // Mikä on InterruptedException, jonka Thread.sleep voi heittää?
            } catch (InterruptedException e) {
                System.out.println("Ei onnistunut!");
            }
            
            System.out.println(Days.daysBetween(nyt, tapahtumanAika2).getDays() + " vuorokautta "
                + Hours.hoursBetween(nyt, tapahtumanAika2).getHours() % 24 + " tuntia "
                + Minutes.minutesBetween(nyt, tapahtumanAika2).getMinutes() % 60 + " minuuttia "
                + Seconds.secondsBetween(nyt, tapahtumanAika2).getSeconds() % 60 + " sekuntia");
            
            i++;
        }
    }

    public void aikaKulkeeAikojenErotuksestaCalendar(Calendar aikaNyt, Calendar tapahtumanAika) {
        // tapahtumaAika-olion aikaa ja aikaNyt-olion aikaa tulee verrata toisiinsa.

        // Jos tapahtuman aika on myöhemmin kuin nykyinen aika,
        // tehdään niiden erotus.
        if (aikaNyt.compareTo(tapahtumanAika) < 0) {
            Calendar aikaKulkee = tapahtumanAika;
            Calendar tallennettavaTapahtumaAika = Calendar.getInstance();
            // Tallenna tapahtuma-aika tiedostoon.
            tapahtumanAika = tallennettavaTapahtumaAika; // Pitäisikö tämä olla toisinpäin niin kuin
                                                         // DateTime:n tapauksessa?

            // Ongelma on ehkä, että vuorokaudet loppuvat ykköseen, eivät nollaan.
            aikojenErotus(aikaNyt, aikaKulkee);
            System.out.println("Erotus:");
            tulostaLahtolaskentaCalendar(aikaKulkee);
            System.out.println("Lähtölaskenta:");
            // Tähän while-loop, calendar add -1 second ja tulostusta joka sekunti.
            // Ajankulun kannalta tarkempi tapa voisi kuulemma olla synkronoida
            // ajan kulkua järjestelmän kellon tahtiin.
        }
    }

    public void aikojenErotus(Calendar aikaNyt, Calendar aikaKulkee) {
        // Tulisiko aikojen erotus aloittaa vuosista vai sekunneista?
        // Varmaan sekunneista.
        aikaKulkee.add(Calendar.SECOND, -aikaNyt.get(Calendar.SECOND));
        aikaKulkee.add(Calendar.MINUTE, -aikaNyt.get(Calendar.MINUTE));
        aikaKulkee.add(Calendar.HOUR_OF_DAY, -aikaNyt.get(Calendar.HOUR_OF_DAY));
        // Jos vuorokausien erotus on 0, pitäisi se tulostaa 0:na, eikä
        // ykkösenä. Nyt tulostusmetodi on kuitenkin erikseen, enkä osaa yhdistää
        // tulostusta tähän metodiin oikein.
        aikaKulkee.add(Calendar.DAY_OF_MONTH, -aikaNyt.get(Calendar.DAY_OF_MONTH));        
        aikaKulkee.add(Calendar.MONTH, -aikaNyt.get(Calendar.MONTH));
        aikaKulkee.add(Calendar.YEAR, -aikaNyt.get(Calendar.YEAR));        
    }

    public void aikaKulkeeSekuntiKerrallaan(Calendar tapahtumanAika) {

        int i = 0;
        while (i < 21) {
            tapahtumanAika.add(Calendar.SECOND, -1);

            try {
                Thread.sleep(1000);
                // Mikä on InterruptedException, jonka Thread.sleep voi heittää?
            } catch (InterruptedException e) {
                System.out.println("Ei onnistunut!");
            }

            tulostaAikaCalendar(tapahtumanAika);
            i++;
        }
    }

    public void aikaKulkeeCalendarKokeilu(Calendar tapahtumanAika) {

        int i = 0;
        while (i < 5) {
            // Miinusta aikaa 5 minuuttia aikaNyt-oliosta kokeilun vuoksi.

            tapahtumanAika.add(Calendar.MINUTE, -1);
            i++;
        }

        tulostaAikaCalendar(tapahtumanAika);
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
