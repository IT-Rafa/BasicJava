/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.instance;

/**
 *
 * @author it-ra
 */
public class InitInstance {

    private int id;
    private String name;
    static int numOfInitInstances;

    {
        id = numOfInitInstances;
        name = "InitInstance_" + id;
    }

    static {
        numOfInitInstances = 10;
    }

    InitInstance() {
        numOfInitInstances++;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InitInstance a = new InitInstance();
        InitInstance b = new InitInstance();
        InitInstance c = new InitInstance();
        
        System.out.println("a = " + a.name);
        System.out.println("b = " + b.name);
        System.out.println("c = " + c.name);

    }

}
