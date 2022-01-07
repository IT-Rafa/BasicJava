/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.charencoding;

/**
 *
 * @author it-ra
 */

public class CharEncoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Según la codificación de caracteres que use la consola a la que se envían los
        // caracteres, algunos no saldrán correctamente, ya que no existen en esa codificación.
        // En mi  caso, con Windows en español de españa con codificación Windows-1252,
        // al enviar los caracteres \u0142 (ł - l(ele) con una barra transversal) y \u015B 
        // (ś - s con tilde) no salen correctamente, mientras que á (incluso sin código) y 
        // \u00fc (ü - u con dieresis) sí salen ok

        // charset encoding de Windows en español: cod https://es.wikipedia.org/wiki/Windows-1252
        String original = "a " + "A " + "á " + "\u00fc " + "\u0142 " + "\u015B ";
        System.out.printf("%s%n", original);
    }

}
