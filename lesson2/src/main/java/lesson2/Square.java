package lesson2;

import java.util.Scanner;

public class Square extends Figure{
    public static void main(String[] args) {
    }

    @Override
    public void calculate() {
        System.out.println("Введите длину стороны квадрата");
        Scanner scan = new Scanner(System.in);
        double side = scan.nextDouble();
        double perimetr = 4*side;
        double area = side*side;
        System.out.println("Периметр равен: " + perimetr);
        System.out.println("Площадь равна: " + area);
    }
}
