package lesson22;

public class Rectangle implements Shape {
    double side1;
    double side2;

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double perimetr() {
        return 2*side1+2*side2;
    }

    @Override
    public double area() {
        return side1*side2;
    }

    @Override
    public void askShape() {

    }
}
