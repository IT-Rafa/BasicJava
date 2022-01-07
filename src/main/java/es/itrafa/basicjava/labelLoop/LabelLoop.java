/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.labelLoop;

/**
 *
 * @author it-ra
 */
public class LabelLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        // limit search until the last char that can fit
        int max = searchMe.length()
                - substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i; // reference in string
            int k = 0; // reference in substring

            while (n-- != 0) {
                System.out.println("searching " + substring + " in " + searchMe.charAt(j));
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                }
            }
            foundIt = true;
            break;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }

}
