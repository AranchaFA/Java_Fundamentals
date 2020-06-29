
package Arrays_Collections.Arrays;

import java.util.Comparator;

/**
 *
 * @author Arancha
 */
public class ClaseComparatorAtributo2 implements Comparator<Persona>{

    /**
     * Método compare sobreescrito: 
     * Compara dos objetos según un atributo especificado por nosotros.
     * @param o1
     * @param o2
     * @return 
     * 1 si o1 mayor que o2
     * -1 si o1 menor que o2
     * 0 si o1 igual que o2
     */
    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1.getAtributo2()>o2.getAtributo2()) {
            return 1;
        } else if (o1.getAtributo2()<o2.getAtributo2()) {
            return -1;
        }
        return 0;
    }

    /**
     * 
     */
    public ClaseComparatorAtributo2() {
    }
    
    
    
}