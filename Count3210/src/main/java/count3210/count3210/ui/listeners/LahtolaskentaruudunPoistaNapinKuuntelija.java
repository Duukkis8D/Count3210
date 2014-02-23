package count3210.count3210.ui.listeners;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LahtolaskentaruudunPoistaNapinKuuntelija implements ActionListener {

    private UI ui;
    private Lahtolaskentaruutu lahtolaskentaruutu;

    public LahtolaskentaruudunPoistaNapinKuuntelija(UI ui, Lahtolaskentaruutu 
            lahtolaskentaruutu) {
        this.ui = ui;
        this.lahtolaskentaruutu = lahtolaskentaruutu;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Poista tässä lähtölaskentaruutu näytöltä.
        ui.poistaLahtolaskentaruutuTapahtumapaneelista(lahtolaskentaruutu);

        // Pysäytä sen lähtölaskenta.
        lahtolaskentaruutu.getLahtolaskenta().pysaytaAjastin();

        // Poista lähtölaskentaruutu tapahtumaruutujen järjestelijän listalta.
        ui.getTapahtumaruutujenJarjestelija().poistaTapahtuma(
                lahtolaskentaruutu);

        // Poista lähtölaskentaruudun tapahtuman tiedot tiedostosta.
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja(
                "laskurit.data");
        tallentaja.poistaTapahtumaTiedostosta(lahtolaskentaruutu.getTapahtuma());
    }
}
