package Shapes;

public class Parallelogram extends Shape {
    private double base, height, side;

    public Parallelogram(double base, double height, double side) {
        this.base = base;
        this.height = height;
        this.side = side;
    }

    @Override
    public double area() {
        return base * height;
    }

    @Override
    public double perimeter() {
        return 2 * (base + side);
    }
}