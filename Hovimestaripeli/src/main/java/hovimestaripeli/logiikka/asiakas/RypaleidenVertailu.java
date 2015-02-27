package hovimestaripeli.logiikka.asiakas;

/**
 * "Hot potato, off his drawers, Puck will make amends!"
 * @author amparkki
 */
public class RypaleidenVertailu {
    
 
        
    /**
     * Yleismetodi tutkii, onko kahdessa String[]:issa samansisältöisiä alkioita, eli suomeksi 
     * sanottuna tarkistaa, onko jokin rypäle jollakin toisella listalla: esimerkiksi tarjottavan
     * viinin rypäleet asiakkaan suosikki- tai inhokkilistalla, tai ruokalajille erityisen hyvin sopivien
     * viinien listalla.
     * 
     * @param lista1
     * @param lista2
     * @return true jos yksikin rypäle löytyy listalta, muuten false
     */

    public boolean onkoRypaleetListalla(String[] lista1, String[] lista2) {         // tämä metodi nyt ei ole supertehokas, mutta listat ovat niin lyhyitä ettei haitanne vaikka aikavaativuus onkin vain O(n²) :P

        for (int i = 0; i < lista1.length; i++) {
            String a = lista1[i];
            for (int j = 0; j < lista2.length; j++) {
                String b = lista2[j];

                if (a.equals(b)) {
                    return true;
                }

            }

        }

        return false;
    }

}
