package hovimestaripeli.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Taidan korvata tän menubarilla kuitenkin.
 * @author amparkki
 */
public class ValikkoPaneeli extends JPanel{
    
      public ValikkoPaneeli() {
          
        super(new GridLayout(1, 3));
        luoKomponentit();
    }

    private void luoKomponentit() {
        add(new JButton("Aloita peli"));
        add(new JButton("Töttöröö"));
        add(new JButton("Apuva"));
    }

}
