package hovimestaripeli.kayttoliittyma;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class Kuvanlukija {
    
       public BufferedImage lueKuva(String kuvanPolku) {

        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(new File(kuvanPolku));
        } catch (IOException ex) {
            System.out.println("Kuvaa ei löytynyt");
        }

        return kuva;
    }

}
