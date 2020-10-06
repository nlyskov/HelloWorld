package lesson22;

public class Square implements Shape {
    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double perimetr() {
        return 4*side;
    }

    @Override
    public double area() {
        return side*side;
    }

    @Override
    public String name() {
        return "квадрат";
    }
}
