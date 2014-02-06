package count3210.count3210.domain;

import count3210.count3210.ui.Kyselija;
import org.joda.time.*;

public class Lahtolaskenta {

    public void kaynnista() {

//        Calendar aikaNyt = Calendar.getInstance();
        DateTime aikaNyt2 = new DateTime();
        // Tulostetaan kokeeksi tämänhetkinen päiväys.
//        System.out.println("Calendar:");
//        tulostaAikaCalendar(aikaNyt);
        System.out.println("DateTime:");
        tulostaAika(aikaNyt2);

        // Kysytään käyttäjältä päiväys.
        Kyselija kyselija = new Kyselija();
//        Calendar tapahtumanAika = kyselija.kysyCalendar();
        DateTime tapahtumanAika2 = kyselija.kysyAika();
        
//        tulostaAikaCalendar(tapahtumanAika);
        tulostaAika(tapahtumanAika2);
        
//        aikaKulkeeAikojenErotuksestaCalendar(aikaNyt, tapahtumanAika);
        aikaKulkeeAikojenErotuksestaDateTime(aikaNyt2, tapahtumanAika2);
        
    }

    public static void tulostaAika(Period ajanjakso) {
        
        System.out.println(ajanjakso.getYears() + " vuotta " 
                + ajanjakso.getMonths() + " kuukautta "
                + ajanjakso.getDays() + " vuorokautta "
                + ajanjakso.getHours() + " tuntia "
                + ajanjakso.getMinutes() + " minuuttia "
                + ajanjakso.getSeconds() + " sekuntia ");
    }
    
    public static void tulostaAika(DateTime aika) {
        System.out.println("\n" + aika.toString() + "\n");
//        DateTimeFormatter dtf = DateTimeFormat.forPattern(
//                "yyyy, MMMM");
//        System.out.println("\n" + dtf.print(aika) + "\n");
    }
    
    public void aikaKulkeeAikojenErotuksestaDateTime(DateTime aikaNyt2, DateTime tapahtumanAika2) {

        DateTime tallennettavaTapahtumaAika = new DateTime();
        tallennettavaTapahtumaAika = tapahtumanAika2;

        // Ajankulun kannalta tarkempi tapa voisi kuulemma olla synkronoida
        // ajan kulkua järjestelmän kellon tahtiin.
        int i = 0;
        while (i < 51) {
            Period ajanjakso = new Period(aikaNyt2, tapahtumanAika2);
            tulostaAika(ajanjakso);
            System.out.println();
            
            tapahtumanAika2 = tapahtumanAika2.minusSeconds(1);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Ei onnistunut!");
            }

            i++;
        }
        
        // Tämä toimii, jos aikayksikköinä tulostetaan vain vuorokaudet,
        // tunnit, minuutit ja sekunnit.
//        System.out.println("Erotus:");
//        
//        int i = 0;
//        while (i < 51) {
//            DateTime nyt = DateTime.now();
//
//            try {
//                Thread.sleep(1000);
//                // Mikä on InterruptedException, jonka Thread.sleep voi heittää?
//            } catch (InterruptedException e) {
//                System.out.println("Ei onnistunut!");
//            }
//            
//            System.out.println(Days.daysBetween(nyt, tapahtumanAika2).getDays() + " vuorokautta "
//                + Hours.hoursBetween(nyt, tapahtumanAika2).getHours() % 24 + " tuntia "
//                + Minutes.minutesBetween(nyt, tapahtumanAika2).getMinutes() % 60 + " minuuttia "
//                + Seconds.secondsBetween(nyt, tapahtumanAika2).getSeconds() % 60 + " sekuntia");
//            
//            i++;
//        }
        
    }
}
