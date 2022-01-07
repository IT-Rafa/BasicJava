/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.valuereference;

/**
 * Show the difference between using a param by-value(int) or by-reference(array)
 * The by-value param don´t change the value of the argument, the by-reference param do.
 * 
 * @author it-ra
 */
public class ValueReferenceParams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num = 20;
        int[] initializedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        modifyAndShow(num, initializedArray);
        show(num, initializedArray);

    }

    private static void show(int n, int[] intToShow) {
        for (int i : intToShow) {
            System.out.printf("- %d%n", i);
        }
        System.out.printf("* %d%n", n);
    }

    private static void modifyAndShow(int n, int[] intToShow) {
        n = 40;
        intToShow[5] = 15;
        for (int i : intToShow) {
            System.out.printf("- %d%n", i);
        }
        System.out.printf("* %d%n", n);
    }
}
