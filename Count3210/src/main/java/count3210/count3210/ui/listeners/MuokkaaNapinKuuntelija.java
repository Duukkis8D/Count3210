package count3210.count3210.ui.listeners;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.MuokattavaTapahtumaruutu;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MuokkaaNapinKuuntelija implements ActionListener {

    private UI ui;
    private Lahtolaskentaruutu lahtolaskentaruutu;

    public MuokkaaNapinKuuntelija(UI ui, Lahtolaskentaruutu ruutu) {
        this.ui = ui;
        this.lahtolaskentaruutu = ruutu;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut().remove(lahtolaskentaruutu);

        ui.poistaLahtolaskentaruutuTapahtumapaneelista(lahtolaskentaruutu);
        
        poistaTapahtumaTiedostosta();

        MuokattavaTapahtumaruutu muokattavaTapahtumaruutu = luoMuokattavaTapahtumaruutu();

        ui.getTapahtumaruutujenJarjestelija().lisaaListaan(muokattavaTapahtumaruutu);
        ui.lisaaMuokattavaTapahtumaruutuTapahtumapaneeliin(muokattavaTapahtumaruutu);
    }
    
    public void poistaTapahtumaTiedostosta() {
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja("laskurit.data");
        tallentaja.poistaTapahtumaTiedostosta(lahtolaskentaruutu.getTapahtuma());
    }
    
    public MuokattavaTapahtumaruutu luoMuokattavaTapahtumaruutu() {
        MuokattavaTapahtumaruutu muokattavaTapahtumaruutu = new MuokattavaTapahtumaruutu(ui);
        muokattavaTapahtumaruutu.setTapahtuma(lahtolaskentaruutu.getTapahtuma());
        muokattavaTapahtumaruutu.luoRuutu();
        
        return muokattavaTapahtumaruutu;
    }
}