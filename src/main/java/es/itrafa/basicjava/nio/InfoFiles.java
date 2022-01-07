/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.nio;

/**
 * Show properties about operate system in console
 * OS name, user name, local language, charset, java details, etc
 * 
 * @author it-ra
 */
public class InfoFiles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.getProperties().list(System.out);
    }
    
}
