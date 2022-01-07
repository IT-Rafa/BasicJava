/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.instance;

/**
 *
 * @author it-ra
 */
public class InstanceOf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        // check right class
        System.out.println("obj1 instanceof Parent: "
                + (obj1 instanceof Parent));
        // check wrong class
        System.out.println("obj1 instanceof Child: "
                + (obj1 instanceof Child));

        // check wrong interface
        System.out.println("obj1 instanceof MyInterface: "
                + (obj1 instanceof MyInterface));

        // check right super class
        System.out.println("obj2 instanceof Parent: "
                + (obj2 instanceof Parent));

        // check right class
        System.out.println("obj2 instanceof Child: "
                + (obj2 instanceof Child));

        // check right interface
        System.out.println("obj2 instanceof MyInterface: "
                + (obj2 instanceof MyInterface));
    }

}

class Parent {
}

class Child extends Parent implements MyInterface {
}

interface MyInterface {
}
