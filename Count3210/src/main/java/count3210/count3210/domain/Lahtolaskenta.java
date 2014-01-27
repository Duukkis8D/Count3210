package count3210.count3210.domain;

import count3210.count3210.ui.Kyselija;
import java.util.Calendar;

public class Lahtolaskenta {

    public void kaynnista() {

        Calendar aikaNyt = Calendar.getInstance();
        // Tulostetaan kokeeksi tämänhetkinen päiväys.
        Lahtolaskenta.tulostaAika(aikaNyt);

        // Kysytään käyttäjältä päiväys.
        Kyselija kyselija = new Kyselija();
        Calendar tapahtumanAika = kyselija.kysy();

        tulostaAika(tapahtumanAika);

        aikaKulkeeAikojenErotuksesta(aikaNyt, tapahtumanAika);
    }

    public static void tulostaAika(Calendar aika) {

        // Tämä tulostaa väärin ainakin tapaukset, joissa kahden päiväyksen
        // erotuksessa on 0 kuukautta. Pitäisikö erotuksen tulostukseen
        // olla oma metodinsa, jossa kuukauteen ei summattaisi ykköstä?
        
        // Kuukausi pitänee tallentaa välillisesti muuttujaan,
        // jotta sen saa tulostettua oikein.
        int kk = aika.get(Calendar.MONTH) + 1;

        System.out.println("\n" + aika.get(Calendar.YEAR) + " vuotta "
                + kk + " kuukautta "
                + aika.get(Calendar.DAY_OF_MONTH) + " vuorokautta "
                + aika.get(Calendar.HOUR_OF_DAY) + " tuntia "
                + aika.get(Calendar.MINUTE) + " minuuttia "
                + aika.get(Calendar.SECOND) + " sekuntia\n");
    }
    
    public static void tulostaLahtolaskenta(Calendar aika) {
        System.out.println("\n" + aika.get(Calendar.YEAR) + " vuotta "
                + aika.get(Calendar.MONTH) + " kuukautta "
                + aika.get(Calendar.DAY_OF_MONTH) + " vuorokautta "
                + aika.get(Calendar.HOUR_OF_DAY) + " tuntia "
                + aika.get(Calendar.MINUTE) + " minuuttia "
                + aika.get(Calendar.SECOND) + " sekuntia\n");
    }

    public void aikaKulkeeAikojenErotuksesta(Calendar aikaNyt, Calendar tapahtumanAika) {
        // tapahtumaAika-olion aikaa ja aikaNyt-olion aikaa tulee verrata toisiinsa.

        // Jos tapahtuman aika on myöhemmin kuin nykyinen aika,
        // tehdään niiden erotus.
        if (aikaNyt.compareTo(tapahtumanAika) < 0) {
            Calendar aikaKulkee = tapahtumanAika;
            Calendar tallennettavaTapahtumaAika = Calendar.getInstance();
            // Tallenna tapahtuma-aika tiedostoon.
            tapahtumanAika = tallennettavaTapahtumaAika;

            // Ongelma on ehkä, että vuorokaudet loppuvat ykköseen, eivät nollaan.
            aikojenErotus(aikaNyt, aikaKulkee);
            System.out.println("Erotus:");
            tulostaLahtolaskenta(aikaKulkee);
            System.out.println("Lähtölaskenta:");
            // Tähän while-loop, calendar add -1 second ja tulostusta joka sekunti.
        }
    }

    public void aikojenErotus(Calendar aikaNyt, Calendar aikaKulkee) {
        // Tulisiko aikojen erotus aloittaa vuosista vai sekunneista?
        // Varmaan sekunneista.
        aikaKulkee.add(Calendar.SECOND, -aikaNyt.get(Calendar.SECOND));
        aikaKulkee.add(Calendar.MINUTE, -aikaNyt.get(Calendar.MINUTE));
        aikaKulkee.add(Calendar.HOUR_OF_DAY, -aikaNyt.get(Calendar.HOUR_OF_DAY));
        aikaKulkee.add(Calendar.DAY_OF_MONTH, -aikaNyt.get(Calendar.DAY_OF_MONTH));
        aikaKulkee.add(Calendar.MONTH, -aikaNyt.get(Calendar.MONTH));
        aikaKulkee.add(Calendar.YEAR, -aikaNyt.get(Calendar.YEAR));
    }

    public void aikaKulkeeSekuntiKerrallaan(Calendar tapahtumanAika) {

        int i = 0;
        while (i < 21) {
            tapahtumanAika.add(Calendar.SECOND, -1);

            try {
                Thread.sleep(1000);
                // Mikä on InterruptedException, jonka Thread.sleep voi heittää?
            } catch (InterruptedException e) {
                System.out.println("Ei onnistunut!");
            }

            tulostaAika(tapahtumanAika);
            i++;
        }
    }

    public void aikaKulkeeCalendarKokeilu(Calendar tapahtumanAika) {

        int i = 0;
        while (i < 5) {
            // Miinusta aikaa 5 minuuttia aikaNyt-oliosta kokeilun vuoksi.

            tapahtumanAika.add(Calendar.MINUTE, -1);
            i++;
        }

        tulostaAika(tapahtumanAika);
    }

    public void aikaKulkeeManuaalisesti(Laskuri tunnit, Laskuri minuutit, Laskuri sekunnit) {

        while (true) {

            if (tunnit.getArvo() > 0) {
                // 05:XX:XX
                if (minuutit.getArvo() > 0) {
                    // 05:25:XX
                    if (sekunnit.getArvo() > 0) {
                        // 05:25:38
                        sekunnit.seuraava();
                        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                        // 05:25:00
                    } else if (sekunnit.getArvo() == 0) {
                        minuutit.seuraava();
                        sekunnit.seuraava();
                        System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    }
                    // 05:00:00
                } else if (minuutit.getArvo() == 0 && sekunnit.getArvo() == 0) {
                    tunnit.seuraava();
                    minuutit.seuraava();
                    sekunnit.seuraava();
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                    // 05:00:38
                } else if (minuutit.getArvo() == 0 && sekunnit.getArvo() > 0) {
                    sekunnit.seuraava();
                    System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                }
                // 00:00:38
            } else if (tunnit.getArvo() == 0 && minuutit.getArvo() == 0
                    && sekunnit.getArvo() > 0) {
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                // 00:25:38
            } else if (tunnit.getArvo() == 0 && minuutit.getArvo() > 0
                    && sekunnit.getArvo() > 0) {
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
                // 00:25:00
            } else if (tunnit.getArvo() == 0 && minuutit.getArvo() > 0
                    && sekunnit.getArvo() == 0) {
                minuutit.seuraava();
                sekunnit.seuraava();
                System.out.println(tunnit + ":" + minuutit + ":" + sekunnit);
            }

            // Lopeta laskuri, kun kaikki arvot ovat nolla.
            if (tunnit.getArvo() == 0 && minuutit.getArvo() == 0 && sekunnit.getArvo() == 0) {
                break;
            }
        }
    }
}
