package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.kayttoliittyma.tapahtumakuuntelija.HovimestarinLisaysKuuntelija;
import hovimestaripeli.kayttoliittyma.tapahtumakuuntelija.Siirry;
import hovimestaripeli.logiikka.Peli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class HovimestarinLuonti extends JPanel {
   
    private GraafinenKali gk;

    public HovimestarinLuonti(GraafinenKali gk) {
        super();
        
        this.gk = gk;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        luoKomponentit();
       
    }

    private void luoKomponentit() {
        JPanel placeholder = new JPanel();
        placeholder.setLayout(new BoxLayout(placeholder, BoxLayout.Y_AXIS));
        add(placeholder);

        placeholder.add(Box.createVerticalGlue());

        JPanel alareuna = new JPanel();
        alareuna.setAlignmentX(1f);
        alareuna.setLayout(new FlowLayout());

        JLabel nimitxt = new JLabel("Nimi: ");
        JTextField nimiKentta = new JTextField(20);
        

        JButton uusiNappi = new JButton("Allons-y!");
        
        
        uusiNappi.addActionListener(new HovimestarinLisaysKuuntelija(nimiKentta, gk));
//         uusiNappi.addActionListener(new Siirry(gk, new Pelitila(gk)));
        

        alareuna.add(nimitxt);
        
        alareuna.add(nimiKentta);
      
        alareuna.add(uusiNappi);
       
        
//        placeholder.add(alareuna);
        placeholder.add(Box.createRigidArea(new Dimension(0, 15)));
        
        this.add(placeholder);
        this.add(alareuna);
        
    }
   

}
