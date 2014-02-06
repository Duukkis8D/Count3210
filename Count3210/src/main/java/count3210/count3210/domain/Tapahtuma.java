
package count3210.count3210.domain;

import org.joda.time.*;

/** Luokan tehtävä on tallentaa eri lähtölaskentalaskurien ominaisuudet,
 * jotta niitä voi käyttää lähtölaskennan esittämiseen graafisessa
 * muodossa käyttäjälle.
 */
public class Tapahtuma {
    private String nimi;
    private DateTime tapahtumaAika;
    // Toistuvuus kerran, kerran viikossa, kuussa?
    
    public Tapahtuma(String nimi) {
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public void setTapahtumaAika(DateTime tapahtumaAika) {
        this.tapahtumaAika = tapahtumaAika;
    }
    
    public DateTime getTapahtuma() {
        return tapahtumaAika;
    }
}
