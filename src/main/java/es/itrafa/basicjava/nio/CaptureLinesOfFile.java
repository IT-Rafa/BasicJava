/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnmappableCharacterException;
import java.nio.file.AccessDeniedException;
import static java.nio.file.Files.readAllLines;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author it-ra
 */
public class CaptureLinesOfFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> lines;
        Path resourcesPath = Paths.get("src\\main\\resources\\");
        Path exercisePath = Paths.get("NIO\\CaptureLinesOfFile\\");
        Path inFileName = Paths.get("input.txt");

        Path inFilePath = (resourcesPath.resolve(exercisePath)).resolve(inFileName);

        lines = readFile(inFilePath);
        int i = 0;
        for (var l : lines) {
            System.out.println(++i + ": " + l);
        }

    }

    /**
     *
     * @param file
     * @return
     */
    public static List<String> readFile(Path file) {

        Charset charset;
        String OS = System.getProperty("os.name").toLowerCase();

        if (OS.contains("win")) {
            charset = Charset.forName("Cp1252");
        } else if (OS.contains("nix")
                || OS.contains("nux")
                || OS.contains("aix")) {
            charset = Charset.forName("UTF-8");
        } else {
            System.err.println("Sistema Operativo desconocido");
            return null;
        }

        try {
            return readAllLines(file, charset);

        } catch (NoSuchFileException ex) {
            System.err.format("ERROR IO Lectura: No existe el archivo: %s%n", ex.getFile());

        } catch (AccessDeniedException ex) {
            System.err.format("ERROR IO Lectura: Sistema no permite acceso al archivo: %s%n", ex.getFile());
        } catch (UnmappableCharacterException ex) {
            System.err.format("ERROR CODIFICACIÓN CHARACTERES: La codificación %s no coincide con los caracteres%n", charset.displayName());
        } catch (IOException ex) {
            System.err.format("ERROR IO: %s%n", ex);
        }

        return null;
    }

}
