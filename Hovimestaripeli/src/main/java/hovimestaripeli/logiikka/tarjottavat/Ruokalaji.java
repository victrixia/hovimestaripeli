package hovimestaripeli.logiikka.tarjottavat;

import hovimestaripeli.logiikka.asiakas.RypaleidenVertailu;

/**
 * Asiakkaalle tarjoiltava ruokalaji, joka jaotellaan alku- pää- ja jälkiruokiin. 
 * Ruokalajilla on myös kaksi listaa viineistä; sopivat ja huonosti sopivat. Lisäksi 
 * ruokalajilla on yleissopiva  viinityyppi, joka menettelee vaikka rypäleet eivät aivan
 * natsaisikaan.
 * 
 * @author amparkki
 */
public class Ruokalaji {
    
    
    private int tyyppi;
    private String kuvaus;
    private String[] perfetto;     // helpommille ruuille voisi olla useampi sopiva
    private String[] kamala;      // mitä vaikeampi, sitä useampia kamalia
    private ViininVari viinityyppi;    // yleisesti sopiva viinityyppi, neutraali valinta
    private RypaleidenVertailu vertaa = new RypaleidenVertailu();
    
    public Ruokalaji(){
        
        this.tyyppi = 0;    // 0 on alkuruoka, 1 pääruoka, 2 jälkiruoka
       this.kuvaus = "Vitello tonnato";
        this.perfetto = new String[]{"Langhe Nebbiolo"};
        this.kamala = new String[]{"Carmenere"};
        this.viinityyppi = ViininVari.VALKO;
    
    }

    public Ruokalaji(int tyyppi, String kuvaus, String[] perfetto, String[] kamala, ViininVari viinityyppi) {
        this.tyyppi = tyyppi;
        this.kuvaus = kuvaus;
        this.perfetto = perfetto;
        this.kamala = kamala;
        this.viinityyppi = viinityyppi;
    }



    public int getTyyppi() {
        return tyyppi;
    }

    public ViininVari getViinityyppi() {
        return viinityyppi;
    }

    public boolean onkoKamala(String[] rypaleet) {
        return vertaa.onkoRypaleetListalla(kamala, rypaleet);
    }

    public boolean onkoPerfetto(String[] rypaleet) {
        return vertaa.onkoRypaleetListalla(perfetto, rypaleet);
    }

    public String getKuvaus() {
        return kuvaus;
    }
    
    @Override
    public String toString(){
        return getKuvaus();
    }

}
