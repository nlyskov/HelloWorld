package lesson2;
import java.util.Scanner;

public class FigureCalculator {
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
            switch (type) {
                case 1:
                    Triangle trArea  = new Triangle();
                    trArea.calculate();
                    break;
                case 2:
                    Square sqArea  = new Square();
                    sqArea.calculate();
                    break;
                case 3:
                    Rectangle recArea  = new Rectangle();
                    recArea.calculate();
                    break;
                default: System.out.println("Фигура не определена");
                    break;
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
