
package count3210.count3210.utils;

import count3210.count3210.ui.MuokattavaTapahtumaruutu;
import java.util.ArrayList;

public class TapahtumaruutujenJarjestelija {
    private ArrayList<MuokattavaTapahtumaruutu> tapahtumaruudut;
    
    public TapahtumaruutujenJarjestelija() {
        tapahtumaruudut = new ArrayList<MuokattavaTapahtumaruutu>();
    }
    
    public void lisaaListaan(MuokattavaTapahtumaruutu ruutu) {
        tapahtumaruudut.add(ruutu);
    }
    
    public void jarjesteleAjankohdanMukaan() {
        
    }
    
    public void jarjesteleTapahtumanNimenMukaan() {
        
    }
}
