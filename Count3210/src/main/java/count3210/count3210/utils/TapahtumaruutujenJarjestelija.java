
package count3210.count3210.utils;

import count3210.count3210.ui.Lahtolaskentaruutu;
import java.util.ArrayList;

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
}
