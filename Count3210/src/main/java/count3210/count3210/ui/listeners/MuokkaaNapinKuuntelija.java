package count3210.count3210.ui.listeners;

import count3210.count3210.ui.Lahtolaskentaruutu;
import count3210.count3210.ui.TapahtumapaneelinRuutu;
import count3210.count3210.ui.UI;
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
        // Etsi TapahtumaruutujenJarjestelijan listalta oikea Lahtolaskentaruutu.
        Lahtolaskentaruutu etsittavaRuutu;
        
        for (TapahtumapaneelinRuutu ruutu
                : ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut()) {
            if (ruutu.getClass().getName().equals(
                    "count3210.count3210.ui.Lahtolaskentaruutu")) {
                // Tyyppimuunnos HaluttuTyyppi muuttuja = 
                // (HaluttuTyyppi) vanhaMuuttuja;
                etsittavaRuutu = (Lahtolaskentaruutu) ruutu;
                if (etsittavaRuutu.equals(lahtolaskentaruutu)) {
                    break;
                }
            }
        }
        
        // Sitten pitäisi poistaa oikea lähtölaskentaruutu listalta ja luoda
        // tilalle listan järjestystä muuttamatta uusi lähtölaskentaruutu.
        
//        TapahtumapaneelinRuutu poistettavaRuutu = (TapahtumapaneelinRuutu) etsittavaRuutu;
//        ui.getTapahtumaruutujenJarjestelija().getTapahtumaruudut().remove(poistettavaRuutu);
        
        // Kopioi lähtölaskentaruudun tiedot muokattavalle ruudulle.
        
        // Luo TapahtumaruudunRunko Lahtolaskentaruudun tilalle tapahtumapaneeliin.

        
        ui.poistaLahtolaskentaruutuTapahtumapaneelista(lahtolaskentaruutu);
    }
}
