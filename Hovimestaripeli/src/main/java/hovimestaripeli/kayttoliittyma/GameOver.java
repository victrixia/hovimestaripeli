package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.kayttoliittyma.tapahtumakuuntelija.UusiKierrosKuuntelija;
import hovimestaripeli.kayttoliittyma.tapahtumakuuntelija.UusiPeliKuuntelija;
import hovimestaripeli.logiikka.Peli;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class GameOver extends JPanel{
    
    private Peli peli;
    private GraafinenKali gk;
    
    public GameOver(GraafinenKali gk){
        super();
        this.gk = gk;
        this.peli = gk.getPeli();
        
          this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        luoKomponentit();
    }

    private void luoKomponentit() {
        
        String viesti = "Onneksi olkoon, selvitit aterian kunnialla loppuun! \n"
                + "Sait tältä asiakkaalta tippiä " + peli.getKierros().getTippi() + " euroa."
                + "Haluatko kohdata seuraavan asiakkaan?";
        
        if (peli.getAsiakas().getHumala() > 150){
            viesti = "Asiakkaasi alkoi käyttäytyä häiritsevästi ja hänet jouduttiin poistamaan ravintolasta. \n"
                    + "Pidä seuraavalla kerralla huoli, ettet tarjoile asiakkaallesi liian väkeviä juomia! \n"
                    + " Nyt menetit kaikki tippisi tältä kierrokselta.";
            
            
        } else if (peli.getAsiakas().getTyytyvaisyys() < 0){
            viesti = "Aijai, ateria ei mennyt ihan putkeen ja jäit ilman tippiä. \n"
                    + "Yritä seuraavalla kerralla kuunnella asiakkaan makumieltymyksiä tarkemmin!";
        }
        
        
        add(new JLabel(viesti));
        
        JButton kylla = new JButton("Seuraava asiakas, kiitos!");
        kylla.addActionListener(new UusiKierrosKuuntelija(gk));
        JButton uusiPeli = new JButton ("Aloita uusi peli");
        uusiPeli.addActionListener(new UusiPeliKuuntelija(gk));
        
        add(kylla);
        add(uusiPeli);
        
    }
    
    
    
    

}
