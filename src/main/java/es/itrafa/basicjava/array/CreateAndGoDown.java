/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.array;

/**
 *
 * @author it-ra
 */
public class CreateAndGoDown {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Use if you know the size of array
        
        // create
        int[] a1;
        // initialize (all values = default)
        a1 = new int[10];

        // create and initialize array
        int[] a2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // go down the array. Way 1
        // you can choose the step
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i]);
            if (i != a1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // go down the array. Way 2
        // Limtations of this way:
        // will not modify the any array value, only in block
        // no control of index (don´t know index and can´t modify the step
        for (int i : a1) {
            System.out.print(a1[i]);
        }
        
        
    }

}
