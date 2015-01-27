package hovimestaripeli.logiikka.tarjottavat;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class Ruokalaji {
    
    
    private int ruokalaji_id;
    private int tyyppi;
    private String kuvaus;
    private String[] perfetto;     // helpommille ruuille voisi olla useampi sopiva
    private String[] kamala;      // mitä vaikeampi, sitä useampia kamalia
    private int viinityyppi;    // yleisesti sopiva viinityyppi, neutraali valinta
    
    public Ruokalaji(){
        
        this.ruokalaji_id = 1;  // arvontaa varten
        this.tyyppi = 0;    // 0 on alkuruoka, 1 pääruoka, 2 jälkiruoka
       this.kuvaus = "Vitello tonnato";
        this.perfetto = new String[]{"Langhe Nebbiolo"};
        this.kamala = new String[]{"Carmenere"};
        this.viinityyppi = 2;
    
    }

    public Ruokalaji(int ruokalaji_id, int tyyppi, String kuvaus, String[] perfetto, String[] kamala, int viinityyppi) {
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

    public String[] getKamala() {
        return kamala;
    }

    public String[] getPerfetto() {
        return perfetto;
    }

    public String getKuvaus() {
        return kuvaus;
    }
    
    

}
