
package Arrays;

import java.util.Comparator;

public class ClaseComparatorAtributo2 implements Comparator<Persona>{

    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1.getAtributo2()>o2.getAtributo2()) {
            return 1;
        } else if (o1.getAtributo2()<o2.getAtributo2()) {
            return -1;
        }
        return 0;
    }

    public ClaseComparatorAtributo2() {
    }
    
    
    
}