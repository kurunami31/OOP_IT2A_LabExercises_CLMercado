package Shapes;

public class ShapesMain {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rectangle(4, 6),
            new Square(4),
            new Triangle(5, 6, 5, 6, 7),
            new Ellipse(5, 3),
            new Parallelogram(6, 4, 5),
            new Trapezoid(6, 4, 5, 3, 3),
            new Rhombus(5, 8, 6)
        };

        for (Shape shape : shapes) {
            System.out.println(shape.getClass().getSimpleName() + ":");
            shape.display();
            System.out.println();
        }
    }
}