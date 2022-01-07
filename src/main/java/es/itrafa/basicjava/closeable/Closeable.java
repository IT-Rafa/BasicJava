/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.closeable;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author it-ra
 */
public class Closeable {

    /**
     * Indicamos nombre del archivo zip a leer, lo muestra, lo lee, y guarda los
     * nombres del archivo en el archivo de texto indicado
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // NOTA: La ruta inicial de búsqueda de rutas es la de la raíz del proyecto
        String resourcesFolder = "src\\main\\resources\\closeable\\";
        // Llamada a función que lee contenido zip y lo guarda en archivo texto
        try {
            writeToFileZipFileContents(resourcesFolder + "zipFile.zip", resourcesFolder + "showZipFile.txt");

        } catch (NoSuchFileException ex) {
            Logger.getLogger(Closeable.class.getName()).log(Level.SEVERE, "Archivo no localizado. Modifica ruta en Main()", 
                    ex);
        } catch (IOException ex) {
            Logger.getLogger(Closeable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lee archivos contenidos en archivo zip y los nombres de esos archivos en
     * un archivo de texto
     *
     * @param zipFileName Texto con la ruta del archivo zip a leer
     * @param outputFileName Texto con la ruta del archivo de texto a escribir
     *
     * @throws java.io.IOException
     */
    public static void writeToFileZipFileContents(String zipFileName,
            String outputFileName)
            throws java.io.IOException {
        // Prepara para definir la codificación del textto
        java.nio.charset.Charset charset
                = java.nio.charset.StandardCharsets.US_ASCII;
        // Prepara objeto Path(Ruta) para localizar archivo
        java.nio.file.Path outputFilePath
                = java.nio.file.Paths.get(outputFileName);

        // try(listo of autocloseable objects)
        // { code where use the objects} // at end closeable objects will be closed
        // 
        // In Java 8, only new objects, in Java 9 can use final, or use-like-finals objects
        // Open zip file and create output file with 
        // try-with-resources statement
        try ( // create closeables objects

                // Crea y almacena representa el archivo zip
                java.util.zip.ZipFile zf
                = new java.util.zip.ZipFile(zipFileName);
                // Crea y almacena representa el flujo de escritura al archivo de texto
                java.io.BufferedWriter writer
                = java.nio.file.Files.newBufferedWriter(outputFilePath, charset);) {
            //block of try-with-resources (zona donde se manipulan los objetos closeable

            // Recorre lista archivos contenidos en el archivo zip
            for (java.util.Enumeration entries
                    = zf.entries(); entries.hasMoreElements();) {

                // Captura el caracter separador de rutas según el ssoo
                String newLine = System.getProperty("line.separator");
                // Captura el nombre de cada archivo
                String zipEntryName
                        = ((java.util.zip.ZipEntry) entries.nextElement()).getName()
                        + newLine;

                // Escribe el nombre del archivo en el disco
                writer.write(zipEntryName, 0, zipEntryName.length());
            } // all resources will be closed here
        }
    }
}
