package hovimestaripeli.kayttoliittyma;

import hovimestaripeli.logiikka.Peli;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 *
 * @author amparkki
 */
public class GraafinenKali implements Runnable {

    private JFrame frame;
    public JPanel panel;
    private Peli peli;

    public GraafinenKali(Peli peli) {
        this.peli = peli;
    }

    @Override
    public void run() {

        frame = new JFrame("Hovimestaripeli");
        frame.setPreferredSize(new Dimension(500, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        aloitusruutu(frame.getContentPane());


        frame.pack();
        frame.setVisible(true);
    }


    private void aloitusruutu(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(new JLabel("Tervetuloa hovimestaripeliin!"));
        JButton uusiPeli = new JButton("Luo uusi hovimestari");
        uusiPeli.addActionListener(new Siirry(this, new HovimestarinLuonti(peli, this)));
        container.add(uusiPeli);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void paivitaPaneeli(Container container, JPanel panel) {
        frame.getContentPane().removeAll();
        container.add(panel);
        frame.pack();
        frame.setVisible(true);

    }
}
