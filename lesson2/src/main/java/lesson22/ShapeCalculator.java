package lesson22;

import java.util.Scanner;

public class ShapeCalculator {

    public static void main(String[] args) {
        for (; ;) {

            //Начало работы цикла
            int type = 0;
            System.out.println("Введите тип фигуры: 1 - треугольник, 2 - квадрат, 3 - прямоугольник");
            Scanner scan = new Scanner(System.in);
            try {
                type = scan.nextInt();
            }
            catch (java.util.InputMismatchException e){
                System.out.print("Вы ввели букву, а не число");
            }
            if (type == 1) {

                System.out.println("Введите длину первой стороны");
                int side1 = scan.nextInt();
                System.out.println("Теперь вторую");
                int side2 = scan.nextInt();
                System.out.println("И третью");
                int side3 = scan.nextInt();

                Shape shape = new Triangle(side1, side2, side3);

                System.out.println("Тип фигуры: " + shape.name());
                System.out.println("Площадь: "+ shape.area());
                System.out.println("Периметр "+ shape.perimetr());
            }
            if (type == 2) {
                    System.out.println("Введите длину стороны");
                    int side = scan.nextInt();

                    Shape shape = new Square(side);

                    System.out.println("Тип фигуры: " + shape.name());
                    System.out.println("Площадь: "+ shape.area());
                    System.out.println("Периметр "+ shape.perimetr());
            }
            if (type ==3) {
                    System.out.println("Введите длину первой стороны");
                    int side1 = scan.nextInt();
                    System.out.println("Теперь вторую");
                    int side2 = scan.nextInt();

                    Shape shape = new Rectangle(side1, side2);

                    System.out.println("Тип фигуры: " + shape.name());
                    System.out.println("Площадь: "+ shape.area());
                    System.out.println("Периметр "+ shape.perimetr());
            }
            //Спрашиваем пользователя о дальнейшей работе
            int answer = 1;
            try {
                System.out.println("Продолжим вычисления? 1 - Да, другое число - Нет");
                answer = scan.nextInt();
            }
            catch (java.util.InputMismatchException e){
                System.out.print("Вы ввели букву, а не число");
                System.exit(0);
            }
            if (answer != 1){
                System.exit(0);
            }
        }
    }

}
