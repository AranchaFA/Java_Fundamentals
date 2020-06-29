/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed_demofile;

import java.io.File;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 *
 * @author Arancha
 */
public class Comparators {
    
    public class ComparadorLongitudNombre implements Comparator<File>{

        // Constructor
        public ComparadorLongitudNombre() {
        }

        // Métodos abstractos implementados del interface Comparator
        @Override
        public int compare(File o1, File o2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<File> reversed() {
            return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<File> thenComparing(Comparator<? super File> other) {
            return Comparator.super.thenComparing(other); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <U> Comparator<File> thenComparing(Function<? super File, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
            return Comparator.super.thenComparing(keyExtractor, keyComparator); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <U extends Comparable<? super U>> Comparator<File> thenComparing(Function<? super File, ? extends U> keyExtractor) {
            return Comparator.super.thenComparing(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<File> thenComparingInt(ToIntFunction<? super File> keyExtractor) {
            return Comparator.super.thenComparingInt(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<File> thenComparingLong(ToLongFunction<? super File> keyExtractor) {
            return Comparator.super.thenComparingLong(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Comparator<File> thenComparingDouble(ToDoubleFunction<? super File> keyExtractor) {
            return Comparator.super.thenComparingDouble(keyExtractor); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
