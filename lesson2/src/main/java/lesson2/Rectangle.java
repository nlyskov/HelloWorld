package lesson2;

import java.util.Scanner;

public class Rectangle extends Figure{
    public static void main(String[] args) {
    }

    @Override
    public void calculate() {
        System.out.println("Введите длину первой стороны");
        Scanner scan = new Scanner(System.in);
        double side1 = scan.nextDouble();
        System.out.println("Теперь вторую");
        double side2 = scan.nextDouble();
        double perimetr = 2*side1+2*side2;
        double area = side1*side2;
        System.out.println("Периметр равен: " + perimetr);
        System.out.println("Площадь равна: " + area);
    }
}
