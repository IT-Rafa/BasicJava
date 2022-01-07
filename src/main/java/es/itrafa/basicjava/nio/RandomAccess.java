/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;

/**
 *
 * @author it-ra
 */
public class RandomAccess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "I was here!\n";
        byte data[] = s.getBytes();
        ByteBuffer out = ByteBuffer.wrap(data);

        ByteBuffer copy = ByteBuffer.allocate(12);
        Path resourcesPath = Paths.get("src\\main\\resources\\");
        Path exercisePath = Paths.get("NIO\\NIOChar\\");
        Path inFileName = Paths.get("input.txt");

        Path inFilePath = (resourcesPath.resolve(exercisePath)).resolve(inFileName);
        try (FileChannel fc = (FileChannel.open(inFilePath, READ, WRITE))) {
            // Read the first 12
            // bytes of the file.
            int nread;
            do {
                nread = fc.read(copy);
            } while (nread != -1 && copy.hasRemaining());

            // Write "I was here!" at the beginning of the file.
            fc.position(0);
            while (out.hasRemaining()) {
                fc.write(out);
            }
            out.rewind();

            // Move to the end of the file.  Copy the first 12 bytes to
            // the end of the file.  Then write "I was here!" again.
            long length = fc.size();
            fc.position(length - 1);
            copy.flip();
            while (copy.hasRemaining()) {
                fc.write(copy);
            }
            while (out.hasRemaining()) {
                fc.write(out);
            }
        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }
    }

}
