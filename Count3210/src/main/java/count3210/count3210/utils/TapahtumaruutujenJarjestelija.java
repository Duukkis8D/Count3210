
package count3210.count3210.utils;

import count3210.count3210.ui.Lahtolaskentaruutu;
import java.util.ArrayList;

/** Luokan tehtävänä on järjestää graafisen käyttöliittymän tapahtumaruudut
 * käyttäjän haluamaan järjestykseen. Ruudut voi järjestää tapahtuman
 * ajankohdan tai nimen mukaan.
 */
public class TapahtumaruutujenJarjestelija {
    private ArrayList<Lahtolaskentaruutu> tapahtumaruudut;
    
    public TapahtumaruutujenJarjestelija() {
        tapahtumaruudut = new ArrayList<Lahtolaskentaruutu>();
    }
    
    public void lisaaListaan(Lahtolaskentaruutu ruutu) {
        tapahtumaruudut.add(ruutu);
    }
    
    public void jarjesteleAjankohdanMukaan() {
        
    }
    
    public void jarjesteleTapahtumanNimenMukaan() {
        
    }
    
    public ArrayList<Lahtolaskentaruutu> getTapahtumaruudut() {
        return tapahtumaruudut;
    }
}
