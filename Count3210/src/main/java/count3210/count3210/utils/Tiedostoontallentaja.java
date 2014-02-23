package count3210.count3210.utils;

import count3210.count3210.domain.Tapahtuma;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Luokan tehtävänä on tallentaa tiedostoon talteen käyttäjän luoman
 * lähtölaskentatapahtuman ominaisuudet.
 */
public class Tiedostoontallentaja {

    private File laskurit;

    public Tiedostoontallentaja(String tiedostonNimi) {
        laskurit = new File(tiedostonNimi);
    }

    public void tallennaTiedostoon(Tapahtuma tapahtuma) {
        // Testaa että tiedostoon tallentuu oikeat arvot.
        try {
            FileWriter tallentaja = new FileWriter(laskurit, true);
            tallentaja.append(tapahtuma.getNimi() + ";");
            tallentaja.append(tapahtuma.getTapahtumaAika().getYear() + ";"
                    + tapahtuma.getTapahtumaAika().getMonthOfYear() + ";"
                    + tapahtuma.getTapahtumaAika().getDayOfMonth() + ";"
                    + tapahtuma.getTapahtumaAika().getHourOfDay() + ";"
                    + tapahtuma.getTapahtumaAika().getMinuteOfHour() + ";"
                    + tapahtuma.getTapahtumaAika().getSecondOfMinute() + ";");
            tallentaja.append(tapahtuma.getToistuvuus() + "\n");
            tallentaja.close();
        } catch (IOException e) {
            System.out.println("Tallennus ei onnistunut." + "\n"
                    + e.getMessage());
        }
    }

    public void poistaTiedosto() {
        laskurit.delete();
    }
    
    public void poistaTapahtumaTiedostosta(Tapahtuma tapahtuma) {
        
    }
    
    public File getTiedosto() {
        return laskurit;
    }
}
