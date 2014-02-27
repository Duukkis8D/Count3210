
package count3210.count3210.ui;

import count3210.count3210.domain.Tapahtuma;
import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import org.joda.time.DateTime;

public class MuokattavaTapahtumaruutu extends TapahtumaruudunRunko
        implements TapahtumapaneelinRuutu {
    private JTextField nimi;
    private JTextField paivays;
    private Tapahtuma tapahtuma;
    private UI ui;
    
    public MuokattavaTapahtumaruutu(UI ui) {
        super(ui);
    }
    
    // Luokan tarkoituksena on esittää muokattavaa tapahtumaruutua. Ainut ero on
    // se, että aloita-nappi on korvattu tallenna-napilla.
    
    // Jostain syystä tämän luokan metodit sekoittivat ohjelman.
    
    @Override
    public JTextField luoMuokattavaTapahtumanNimiKentta() {
        nimi = new JTextField(tapahtuma.getNimi());
        GridBagConstraints nimelle = muokattavanTapahtumanNimiKentanUlkoasu(nimi);
        this.add(nimi, nimelle);
        
        return nimi;
    }
    
    public GridBagConstraints muokattavanTapahtumanNimiKentanUlkoasu(JTextField nimi) {
        nimi.setBackground(Color.DARK_GRAY);
        nimi.setForeground(Color.WHITE);
        GridBagConstraints nimelle = new GridBagConstraints();
        nimelle.gridx = 1;
        nimelle.gridy = 0;
        
        return nimelle;
    }
    
    @Override
    public JTextField luoAjankohtaKentta() {
        DateTime asetettavaTapahtumaAika = tapahtuma.getTapahtumaAika();
        String asetettavaPaivaysteksti = 
                  asetettavaTapahtumaAika.getDayOfMonth() + ":"
                + asetettavaTapahtumaAika.getMonthOfYear() + ":"
                + asetettavaTapahtumaAika.getYear() + ","
                + asetettavaTapahtumaAika.getHourOfDay() + ":"
                + asetettavaTapahtumaAika.getMinuteOfHour() + ":"
                + asetettavaTapahtumaAika.getSecondOfMinute();
        paivays = new JTextField(asetettavaPaivaysteksti);
        
        GridBagConstraints paivaykselle = ajankohtaKentanUlkoasu(paivays);
        this.add(paivays, paivaykselle);
        
        return paivays;
    }
    
    public GridBagConstraints ajankohtaKentanUlkoasu(JTextField paivays) {
        paivays.setBackground(Color.DARK_GRAY);
        paivays.setForeground(Color.WHITE);
        GridBagConstraints paivaykselle = new GridBagConstraints();
        paivaykselle.gridx = 1;
        paivaykselle.gridy = 1;
        
        return paivaykselle;
    }
}
