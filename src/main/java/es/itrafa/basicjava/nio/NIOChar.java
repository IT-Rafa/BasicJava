/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnmappableCharacterException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Copy a text file inside the project to another text file and counts groups of chars
 * using the charset of system.
 * 
 * @author it-ra
 */
public class NIOChar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path resourcesPath = Paths.get("src\\main\\resources\\");
        Path exercisePath = Paths.get("NIO\\NIOChar\\");
        Path inFileName = Paths.get("input.txt");
        Path outFileName = Paths.get("output.txt");

        Path inFilePath = (resourcesPath.resolve(exercisePath)).resolve(inFileName);
        Path outFilePath = (resourcesPath.resolve(exercisePath)).resolve(outFileName);
        String OS = System.getProperty("os.name").toLowerCase();
        Charset charset;
        if (OS.contains("win")) {
            charset = Charset.forName("Cp1252");
        } else if (OS.contains("nix")
                || OS.contains("nux")
                || OS.contains("aix")) {
            charset = Charset.forName("UTF-8");
        } else {
            System.err.println("Sistema Operativo desconocido");
            return;
        }

        try (
                BufferedReader reader = Files.newBufferedReader(inFilePath, charset);
                BufferedWriter writer = Files.newBufferedWriter(outFilePath, charset);) {
            int aChar;
            // Recorre datos en entrada(archivo) hasta que read devuelva -1 == EOF(END-OF-FILE)
            while ((aChar = reader.read()) != -1) {
                // cada caracter se escribe en salida(Archivo)
                writer.write(aChar);
            }// Al finalizar este bloque se cierran los recursos abiertos en try

        } catch (NoSuchFileException ex) {
            if (ex.getFile().equalsIgnoreCase(inFilePath.toString())) {
                System.err.format("ERROR IO Lectura: No existe el archivo: %s%n", ex.getFile());
            } else if (ex.getFile().equalsIgnoreCase(outFilePath.toString())) {
                System.err.format("ERROR IO Escritura: No existe el archivo: %s%n", ex.getFile());
            } else {
                System.err.format("ERROR IO: No existe el archivo: %s%n", ex.getFile());
            }

        } catch (AccessDeniedException ex) {
            if (ex.getFile().equalsIgnoreCase(inFilePath.toString())) {
                System.err.format("ERROR IO Lectura: Sistema no permite acceso al archivo: %s%n", ex.getFile());
            } else if (ex.getFile().equalsIgnoreCase(outFilePath.toString())) {
                System.err.format("ERROR IO Escritura: Sistema no permite acceso al archivo: %s%n", ex.getFile());
            } else {
                System.err.format("ERROR IO Acceso: Sistema no permite acceso al archivo: %s%n", ex.getFile());
            }

        } catch (UnmappableCharacterException ex) {
            System.err.format("ERROR CODIFICACIÓN CHARACTERES: La codificación %s no coincide con los caracteres%n", charset.displayName());

        } catch (IOException ex) {
            System.err.format("ERROR IO: %s%n", ex);
        }
    }

}
