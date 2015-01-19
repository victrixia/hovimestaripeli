package hovimestaripeli.logiikka.tarjottavat;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class Ruokalaji {
    
    private int tyyppi;
    private int ruokalaji_id;
    private String kuvaus;
    private String perfetto;     // helpommille ruuille voisi olla useampi sopiva
    private String kamala;      // mitä vaikeampi, sitä useampia kamalia
    private int viinityyppi;    // yleisesti sopiva viinityyppi, neutraali valinta
    
    public Ruokalaji(){
        this.tyyppi = 0;    // 0 on alkuruoka, 1 pääruoka, 2 jälkiruoka
        this.ruokalaji_id = 1;
        this.kuvaus = "Vitello tonnato";
        this.perfetto = "Langhe Nebbiolo";
        this.kamala = "Carmenere";
        this.viinityyppi = 2;
    
    }

    public Ruokalaji(int tyyppi, int ruokalaji_id, String kuvaus, String perfetto, String kamala, int viinityyppi) {
        this.tyyppi = tyyppi;
        this.ruokalaji_id = ruokalaji_id;
        this.kuvaus = kuvaus;
        this.perfetto = perfetto;
        this.kamala = kamala;
        this.viinityyppi = viinityyppi;
    }

    public int getRuokalaji_id() {
        return ruokalaji_id;
    }

    public int getTyyppi() {
        return tyyppi;
    }

    public int getViinityyppi() {
        return viinityyppi;
    }

    public String getKamala() {
        return kamala;
    }

    public String getPerfetto() {
        return perfetto;
    }

    public String getKuvaus() {
        return kuvaus;
    }
    
    

}
