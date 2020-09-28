package lesson2;

import java.util.Scanner;

public class Triangle extends Figure{
    public static void main(String[] args) {
    }

    @Override
    public void calculate() {
        System.out.println("Введите длину первой стороны");
        Scanner scan = new Scanner(System.in);
        double side1 = scan.nextDouble();
        System.out.println("Теперь вторую");
        double side2 = scan.nextDouble();
        System.out.println("И третью");
        double side3 = scan.nextDouble();
        double perimetr = side1+side2+side3;
        double halfPerimetr = perimetr/2;
        double area =  Math.sqrt(halfPerimetr*(halfPerimetr-side1)*(halfPerimetr-side2)*(halfPerimetr-side3));
        System.out.println("Периметр равен: " + perimetr);
        System.out.println("Площадь равна: " + area);
    }
}
