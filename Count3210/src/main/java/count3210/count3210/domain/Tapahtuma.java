
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
    private String toistuvuus;
    
    public Tapahtuma(String nimi) {
        this.nimi = nimi;
    }
    
    public Tapahtuma(StringBuilder nimenRakentaja) {
        setNimi(nimenRakentaja.toString());
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
    
    public DateTime getTapahtumaAika() {
        return tapahtumaAika;
    }
    
    public String getToistuvuus() {
        return toistuvuus;
    }

    public void setToistuvuus(String toistuvuus) {
        this.toistuvuus = toistuvuus;
    }
}
