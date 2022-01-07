/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package es.itrafa.basicjava.arbitraryNumberOfArgs;

/**
 *
 * @author it-ra
 */
public class Polygon {
    private Point[] corners;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Point p1 = new Point(10, 20);
        Point p2 = new Point(20, 30);
        Point p3 = new Point(30, 40);
        Point p4 = new Point(40, 50);
        Point p5 = new Point(50, 60);

        Polygon a = new Polygon();
        System.out.printf("a is a %s%n", a.getDescription());
        Polygon b = new Polygon(p1);
        System.out.printf("b is a %s%n", b.getDescription());

        Polygon c = new Polygon(p1, p2);
        System.out.printf("c is a %s%n", c.getDescription());

        Polygon d = new Polygon(p1, p2, p3, p4, p5);
        System.out.printf("d is a %s%n", d.getDescription());

    }

    Polygon(Point... corners) {
        this.corners = corners;
    }

    public String getDescription() {
        String description;
        int numberOfSides = corners.length;
        switch (numberOfSides) {
            case 0:
                description = "void";
                break;
            case 1:
                description = "point";
                break;
            case 2:
                description = "rect";
                break;
            case 3:
                description = "triangle";
                break;
            case 4:
                description = "rectangle";
                break;
            default:
                description = "polygon";
                break;
        }
        return description;
    }
}
