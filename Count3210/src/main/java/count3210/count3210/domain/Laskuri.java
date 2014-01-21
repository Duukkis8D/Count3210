package count3210.count3210.domain;

public class Laskuri {

    private int arvo;
    private int ylaraja;

    public Laskuri(int ylarajanAlkuarvo) {
        this.arvo = 0;
        this.ylaraja = ylarajanAlkuarvo;
    }

    public void seuraava() {
        // Pitäisikö laskurin käyttää koko ajan laskurin
        // ajan laskemiseen järjestelmän kelloa vai juoksisiko
        // aika sekunti kerrallaan, kunnes käyttäjä sulkee
        // ohjelman? Ohjelman uudelleen käynnistyksessä
        // järjestelmän kellon arvo taas luettaisiin ja aika
        // kulkisi sekunti kerrallaan.

        // Seuraavassa voisi vähentää this.arvo-muuttujan
        // arvoa yhdellä, kunnes sen arvo on 0. Arvon ollessa
        // nolla sen arvoksi asetetaan ylaraja apumuuttujan
        // avulla.
        if (arvo >= 1 && arvo <= ylaraja) {
            // Jos arvo on 1 - ylaraja.
            arvo--;
        } else {
            // Jos arvo on 0 tai jokin muu.
            int uusiArvo = ylaraja;
            arvo = uusiArvo;
        }

//        if (arvo < 0) {
//            int uusiArvo = ylaraja + 1;
//            arvo = uusiArvo;
//        } else if (arvo <= ylaraja + 1 || arvo >= 0) {
//            arvo--;
//        } 
    }

    @Override
    public String toString() {

        if (this.arvo < 10) {
            return "0" + this.arvo;
        } else {
            return "" + this.arvo;
        }
    }

    public int arvo() {
        // Tämä metodi ainoastaan palauttaa oliomuuttujan arvon,
        // jotta sitä voi käyttää main-luokassa.
        return this.arvo;
    }

    public void asetaArvo(int asetus) {
        // Tähän metodiin tulee tallennusluokan olion luonti ja
        // sen metodien käyttöä. Asetukset tallentuvat taustalle
        // ja näkyvä osa on lähtölaskenta, joka käyttää aloitus-
        // ajan laskuun järjestelmän kellonaikaa ja päivämäärää.

        // Aluksi tehdään asia yksinkertaisemmin.
        arvo = asetus;
    }
}
