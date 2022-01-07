/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.io;

import es.itrafa.basicjava.closeable.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it-ra
 */
public class IOBytes {

    /**
     * Demostración de lectura a nivel bytes.
     * Lee archivo indicado, a nivel de bytes, y escribe su contenido en otro archivo.
     * Conveniente para archivos binarios o, en el caso de archivos de caracteres,
     * cuando no se conoce el charset usado
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Almacena cada byte (últimos 8 bits del int)
        int aByte;
        // Ruta general archivos, dentro del proyecto (Esta ruta debe existir, no se crea)
        String resourcesFolder = "src\\main\\resources\\IO\\IOBytes\\";

        // usamos try-with-resources (autocloseable)
        try (
                // Crea stream para lectura(entrada) datos
                // busca archivo y crea conexión(stream)
                FileInputStream in
                = new FileInputStream(resourcesFolder + "input.txt");
                
                // Crea stream para escritura(salida) datos
                // Busca archivo, y si no existe, lo crea y crea conexión
                FileOutputStream out
                = new FileOutputStream(resourcesFolder + "output.exe")) {

            // Recorre datos en entrada(archivo) hasta que read devuelva -1 == EOF(END-OF-FILE)
            while ((aByte = in.read()) != -1) {
                // cada byte se escribe en salida(Archivo)
                out.write(aByte);
            }// Al finalizar este bloque se cierran los recursos abiertos en try

        } catch (NoSuchFileException ex) {
            // Acción a realizar si no aparece si no localiza el archivo
            Logger.getLogger(Closeable.class.getName()).log(Level.SEVERE, "Archivo no localizado. Modifica ruta en Main()",
                    ex);
        } catch (IOException ex) {
            // Acción a realizar si ocurre fallo de lectura en general
            Logger.getLogger(Closeable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
