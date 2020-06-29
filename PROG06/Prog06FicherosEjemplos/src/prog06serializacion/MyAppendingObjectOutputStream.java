/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06serializacion;
 // bloque para abrir el fichero y evitar que se escriba una nueva cabecera al añadir nuevos registros en una nueva sesión
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

   
 public class MyAppendingObjectOutputStream extends ObjectOutputStream {
        //bloque que sobreescribe el metodo writeStreamHeader para que no vuelva a 
        //escribir la cabecera del fichero cada vez qeu abramos el fichero para 
        //añadir. Sobreescribirmos el método writeStremHeader con reset() y asi
        //no pone nueva cabecera al nuevo bloque de registros que escribamos

        public MyAppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
            }
    }