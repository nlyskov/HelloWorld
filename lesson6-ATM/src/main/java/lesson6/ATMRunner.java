package lesson6;
import static lesson6.CellValues.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMRunner {
    public static void main(String[] args) {

        Cell cell_100 = new Cell(10, ONEHUNDRED);
        Cell cell_500 = new Cell(10, FIVEHUNDRED);
        Cell cell_1000 = new Cell(10, THOUSAND);
        Cell cell_5000 = new Cell(10, FIVETHOUSAND);
        List<Cell> cellList = new ArrayList<>();

        cellList.add(cell_100);
        cellList.add(cell_500);
        cellList.add(cell_1000);
        cellList.add(cell_5000);

        Scanner s = new Scanner(System.in);
        while(true)
        {
            int balance = 0;
            System.out.println("\n\nДобрый день!");
            System.out.println("Нажмите 1 для пополнения баланса банкомата");
            System.out.println("Нажмите 2 для снятия наличных");
            System.out.println("Нажмите 3 для проверки баланса");
            System.out.println("Нажмите 4 для выхода из сеанса\n\n");
            System.out.print("Введите необходимую цифру: ");
            int n = s.nextInt();
            switch(n)
            {
                // Внесение денег в банкомат
                case 1:
                        System.out.println("Выберите, купюры какого номинала вы хотите добавить в банкомат: ");
                        cellList.forEach(cell -> {System.out.printf("Нажмите %s для купюр %s%n", cell.cell_type.id, cell.cell_type.name);});
                        int n1 = s.nextInt();
                        cellList.forEach(cell -> {
                            if (cell.cell_type.id == n1) {
                                System.out.print("\nВведите количество купюр: ");
                                int amount = s.nextInt();
                                cell.get(amount);
                                System.out.printf("\nЗачислено рублей: %s", amount*cell.cell_type.value);
                            }
                        });
                        break;

                // Снятие налички
                case 2:
                    System.out.println("Выберите, купюры какого номинала вы хотите снять: ");
                    cellList.forEach(cell -> {System.out.printf("Нажмите %s для купюр %s%n", cell.cell_type.id, cell.cell_type.name);});
                    int n2 = s.nextInt();
                    cellList.forEach(cell -> {
                        if (cell.cell_type.id == n2) {
                            System.out.print("\nВведите количество купюр: ");
                            int amount = s.nextInt();
                                boolean result = cell.give(amount);
                            if (result) {
                                System.out.printf("\nСнято рублей: %s", amount * cell.cell_type.value);
                            } else {
                                System.out.println("Произошла ошибка! В ячейке не хватает купюр!");
                            }
                        }
                    });
                    break;

                // Сумма всех средств в банкомате
                case 3:
                    for (Cell cell : cellList) {
                        balance = balance+cell.count();
                    }
                    System.out.printf("%nДоступный баланс в банкомате: %s%n",balance);
                    break;

                // Выход
                case 4:
                    System.exit(0);
            }
        }

    }
}
