
package hovimestaripeli.logiikka.tarjottavat;

/**
 *  Viinin värin määrittely, ettei tarvitse käyttää numeroita
 * @author amparkki
 */
public enum ViininVari {
    PUNA ("punaviini"), VALKO ("valkoviini"), KUOHU ("kuohuviini"), ROSEE ("roseeviini"), JALKIRUOKA ("jälkiruokaviini");

    private final String nimi;
    ViininVari(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() { return this.nimi; }
}
