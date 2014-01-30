
package count3210.count3210.domain;

import org.joda.time.*;

public class Tapahtuma {
    private String nimi;
    private DateTime tapahtuma;
    // Toistuvuus kerran, kerran viikossa, kuussa?
    
    public Tapahtuma(String nimi) {
        this.nimi = nimi;
    }
    
    public String getNimi() {
        return nimi;
    }
    
    public void setTapahtuma(DateTime tapahtuma) {
        this.tapahtuma = tapahtuma;
    }
    
    public DateTime getTapahtuma() {
        return tapahtuma;
    }
}
