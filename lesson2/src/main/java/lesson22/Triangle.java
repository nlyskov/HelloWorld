package lesson22;

public class Triangle implements Shape{
    int side1;
    int side2;
    int side3;

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double perimetr() {
        return side1+side2+side3;
    }

    @Override
    public double area() {
        double perimetr = perimetr();
        double halfPerimetr = perimetr/2;
        return Math.sqrt(halfPerimetr*(halfPerimetr-side1)*(halfPerimetr-side2)*(halfPerimetr-side3));
    }

    @Override
    public String name() {
        return "треугольник";
    }
}
