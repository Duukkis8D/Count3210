
package count3210.count3210.utils;

import count3210.count3210.ui.TapahtumapaneelinRuutu;
import java.util.ArrayList;

/** Luokan tehtävänä on järjestää graafisen käyttöliittymän tapahtumaruudut
 * käyttäjän haluamaan järjestykseen. Ruudut voi järjestää tapahtuman
 * ajankohdan tai nimen mukaan.
 */
public class TapahtumaruutujenJarjestelija {
    private ArrayList<TapahtumapaneelinRuutu> tapahtumaruudut;
    
    public TapahtumaruutujenJarjestelija() {
        tapahtumaruudut = new ArrayList<TapahtumapaneelinRuutu>();
    }
    
    public void lisaaListaan(TapahtumapaneelinRuutu ruutu) {
        tapahtumaruudut.add(ruutu);
    }
    
    public void jarjesteleAjankohdanMukaan() {
        
    }
    
    public void jarjesteleTapahtumanNimenMukaan() {
        
    }
    
    public void poistaKaikkiTapahtumat() {
        tapahtumaruudut.clear();
    }
    
    public ArrayList<TapahtumapaneelinRuutu> getTapahtumaruudut() {
        return tapahtumaruudut;
    }
}
