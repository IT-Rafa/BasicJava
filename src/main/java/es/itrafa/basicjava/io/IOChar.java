/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it-ra
 */
public class IOChar {

    /**
     * Demostración de lectura a nivel carácter.
     * Los caracteres unicode ocupan 16 bits
     * Lee archivo indicado según charset local, lo transforma a unicode, 
     * lo vuelve a convertir al charset local y lo guarda en otro archivo.
     * 
     * Conveniente para archivos de texto que vayan a ser manipulados como tal.
     * Permite usar herramientas para clasificar caracteres según el charset local.
     * Ej: En Windows español reconocerá á como una letra
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Almacena cada unicode char (últimos 16 bits del int)
        int aChar;
        // Ruta general archivos, dentro del proyecto
        String resourcesFolder = "src\\main\\resources\\IO\\IOChar\\";

        // usamos try-with-resources (autocloseable)
        try (
                // Crea stream para lectura(entrada) datos
                // busca archivo y crea conexión(stream)
                FileReader in
                = new FileReader(resourcesFolder + "input.txt");
                
                // Crea stream para escritura(salida) datos
                // Busca archivo, y si no existe, lo crea y crea conexión
                FileWriter out
                = new FileWriter(resourcesFolder + "output.txt")) {

            // Recorre datos en entrada(archivo) hasta que read devuelva -1 == EOF(END-OF-FILE)
            while ((aChar = in.read()) != -1) {
                // cada byte se escribe en salida(Archivo)
                
                out.write(aChar);
            }// Al finalizar este bloque se cierran los recursos abiertos en try

        } catch (NoSuchFileException ex) {
            // Acción a realizar si no aparece si no localiza el archivo
            Logger.getLogger(IOChar.class.getName()).log(Level.SEVERE, "Archivo no localizado. Modifica ruta en Main()",
                    ex);
        } catch (IOException ex) {
            // Acción a realizar si ocurre fallo de lectura en general
            Logger.getLogger(IOChar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
