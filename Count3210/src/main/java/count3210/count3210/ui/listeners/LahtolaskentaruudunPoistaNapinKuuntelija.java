package count3210.count3210.ui.listeners;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.UI;
import count3210.count3210.utils.Tiedostoontallentaja;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Luokka tekee lähtölaskentaruudun lopulliseen poistamiseen liittyvät
 * toimenpiteet poista-nappia painettaessa.
 */
public class LahtolaskentaruudunPoistaNapinKuuntelija implements ActionListener {

    private UI ui;
    private Lahtolaskentaruutu lahtolaskentaruutu;

    public LahtolaskentaruudunPoistaNapinKuuntelija(UI ui, Lahtolaskentaruutu 
            lahtolaskentaruutu) {
        this.ui = ui;
        this.lahtolaskentaruutu = lahtolaskentaruutu;
    }

    /** Metodi poistaa lähtölaskentaruudun graafisesta käyttöliittymästä ja
     * muista ohjelman osista sekä pysäyttää sen lähtölaskennan.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        ui.poistaLahtolaskentaruutuTapahtumapaneelista(lahtolaskentaruutu);

        lahtolaskentaruutu.getLahtolaskenta().pysaytaAjastin();
        
        ui.getTapahtumaruutujenJarjestelija().poistaTapahtuma(
                lahtolaskentaruutu);
        
        Tiedostoontallentaja tallentaja = new Tiedostoontallentaja(
                "laskurit.data");
        tallentaja.poistaTapahtumaTiedostosta(lahtolaskentaruutu.getTapahtuma());
    }
}
