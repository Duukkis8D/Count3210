
package count3210.count3210.utils;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.listeners.AloitaNapinKuuntelija;
import count3210.count3210.ui.TapahtumapaneelinRuutu;
import java.util.ArrayList;

/** Luokan tehtävänä on järjestää graafisen käyttöliittymän tapahtumaruudut
 * käyttäjän haluamaan järjestykseen väliaikaismuistin avulla. Ruudut voi
 * järjestää tapahtuman ajankohdan tai nimen mukaan.
 */
public class TapahtumaruutujenJarjestelija {
    private ArrayList<TapahtumapaneelinRuutu> tapahtumaruudut;
    
    public TapahtumaruutujenJarjestelija() {
        tapahtumaruudut = new ArrayList<TapahtumapaneelinRuutu>();
    }
    
    /** Metodi lisää ruudun ohjelman väliaikaismuistiin.
     * 
     * @param ruutu Lisättävä ruutu voi olla useaa eri tyyppiä, kunhan se
     * toteuttaa TapahtumapaneelinRuutu-rajapinnan.
     */
    public void lisaaListaan(TapahtumapaneelinRuutu ruutu) {
        tapahtumaruudut.add(ruutu);
    }
    
    public void lisaaListaan(TapahtumapaneelinRuutu ruutu, 
            AloitaNapinKuuntelija kuuntelija) {
        
    }
    public void jarjesteleAjankohdanMukaan() {
        
    }
    
    public void jarjesteleTapahtumanNimenMukaan() {
        
    }
    
    public void poistaKaikkiTapahtumat() {
        tapahtumaruudut.clear();
    }
    
    /** Metodi poistaa lähtölaskentaruudun ohjelman väliaikaismuistista.
     * 
     * @param lahtolaskentaruutu Poistettava lähtölaskentaruutu.
     */
    public void poistaTapahtuma(Lahtolaskentaruutu lahtolaskentaruutu) {
        tapahtumaruudut.remove(lahtolaskentaruutu);
        // Pitäisikö myös lähtölaskentaruutuun liittyvä TapahtumaruudunRunko-
        // luokan ilmentymä poistaa?
    }
    
    public ArrayList<TapahtumapaneelinRuutu> getTapahtumaruudut() {
        return tapahtumaruudut;
    }
}
