package count3210.count3210.domain;

import count3210.count3210.ui.Kyselija;
import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.UI;
import javax.swing.JTextArea;
import org.joda.time.*;

public class Lahtolaskenta {

//    public void kaynnista() {

////        Calendar aikaNyt = Calendar.getInstance();
//        DateTime aikaNyt2 = new DateTime();
//        // Tulostetaan kokeeksi tämänhetkinen päiväys.
////        System.out.println("Calendar:");
////        tulostaAikaCalendar(aikaNyt);
//        System.out.println("DateTime:");
//        naytaLahtolaskenta(aikaNyt2);
//
//        // Kysytään käyttäjältä päiväys.
//        Kyselija kyselija = new Kyselija();
////        Calendar tapahtumanAika = kyselija.kysyCalendar();
//        DateTime tapahtumanAika2 = kyselija.kysyAika();
//        
////        tulostaAikaCalendar(tapahtumanAika);
//        naytaLahtolaskenta(tapahtumanAika2);
//        
////        aikaKulkeeAikojenErotuksestaCalendar(aikaNyt, tapahtumanAika);
//        aikaKulkeeAikojenErotuksestaDateTime(aikaNyt2, tapahtumanAika2);
        
//    }

    public static void naytaLahtolaskenta(Period ajanjakso,
            Lahtolaskentaruutu lahtolaskentaruutu, JTextArea lahtolaskentakentta) {
        
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
    
    public void kaynnista(Lahtolaskentaruutu lahtolaskentaruutu, 
            JTextArea lahtolaskentakentta, UI ui) {

        DateTime aikaNyt = DateTime.now();
        
        Tapahtuma tapahtuma = lahtolaskentaruutu.getTapahtuma();
        DateTime tapahtumaAika = tapahtuma.getTapahtumaAika();
        Period ajanjakso;
        int aikayksikkoja = 99;

        // Ajankulun kannalta tarkempi tapa voisi kuulemma olla synkronoida
        // ajan kulkua järjestelmän kellon tahtiin.
        
        while (aikayksikkoja > 0) {
            ajanjakso = new Period(aikaNyt, tapahtumaAika);
            
            int[] aikayksikkoTaulukko = ajanjakso.getValues();
            aikayksikkoja = 0;
            for (int aikayksikko : aikayksikkoTaulukko) {
                aikayksikkoja = aikayksikkoja + aikayksikko;
            }
                    
            ui.paivitaLahtolaskentaruudunLahtolaskentaKentta(lahtolaskentaruutu, 
                    ajanjakso);
            
            tapahtumaAika = tapahtumaAika.minusSeconds(1);
            tapahtuma.setTapahtumaAika(tapahtumaAika);
            lahtolaskentaruutu.setTapahtuma(tapahtuma);

            // Seuraava jumittaa ohjelman.
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Ei onnistunut!");
//            }
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
