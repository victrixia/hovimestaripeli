package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.kayttoliittyma.tapahtumakuuntelija.Siirry;
import hovimestaripeli.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class GraafinenKali implements Runnable {

    private JFrame frame;
    private Peli peli;
    private BufferedImage hovimestarinKuva;
    private Kuvanlukija kl = new Kuvanlukija();

    public GraafinenKali(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {

        frame = new JFrame("Hovimestaripeli");
        frame.setPreferredSize(new Dimension(1000, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        aloitusruutu(frame.getContentPane());


        frame.pack();
        frame.setVisible(true);
    }


    private void aloitusruutu(Container container) {       
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        JOptionPane.showMessageDialog(frame, "Tervetuloa Chez Pierreen!"
                + "Olet ravintolasalin stara, Sommelier. Mikä on nimesi?");

        paivitaPaneeli(new HovimestarinLuonti(this));

    }

    public JFrame getFrame() {
        return frame;
    }

    public void paivitaPaneeli(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    public Peli getPeli() {
        return this.peli;
    
    }
    
    public void paivitaPeli(Peli peli){
        this.peli = peli;
    }
    
    public void restart(){
        this.peli = new Peli();
    }

    public BufferedImage getHovimestarinKuva() {
        return hovimestarinKuva;
    }

    public void setHovimestarinKuva(String polku) {
        this.hovimestarinKuva = kl.lueKuva(polku);
    }
    
   
    
    
    
    
}
