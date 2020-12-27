package lesson6;
import static lesson6.CellValues.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMRunner {
    public static void main(String[] args) {
        Cell cell_100 = new Cell(ONEHUNDRED.getName(), 10, ONEHUNDRED.getValue(), ONEHUNDRED.getId());
        Cell cell_500 = new Cell(FIVEHUNDRED.getName(), 10, FIVEHUNDRED.getValue(), FIVEHUNDRED.getId());
        Cell cell_1000 = new Cell(THOUSAND.getName(), 10, THOUSAND.getValue(), THOUSAND.getId());
        Cell cell_5000 = new Cell(FIVETHOUSAND.getName(), 10, FIVETHOUSAND.getValue(), FIVETHOUSAND.getId());
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
                        cellList.forEach(cell -> {System.out.printf("Нажмите %s для купюр %s%n", cell.id, cell.name);});
                        int n1 = s.nextInt();
                        cellList.forEach(cell -> {
                            if (cell.id == n1) {
                                System.out.print("\nВведите количество купюр: ");
                                int amount = s.nextInt();
                                cell.get(amount);
                                System.out.printf("\nЗачислено рублей: %s", amount*cell.value);
                            }
                        });
                        break;

                // Снятие налички
                case 2:
                    System.out.println("Выберите, купюры какого номинала вы хотите снять: ");
                    cellList.forEach(cell -> {System.out.printf("Нажмите %s для купюр %s%n", cell.id, cell.name);});
                    int n2 = s.nextInt();
                    cellList.forEach(cell -> {
                        if (cell.id == n2) {
                            System.out.print("\nВведите количество купюр: ");
                            int amount = s.nextInt();
                            if (cell.amount<amount){
                                System.out.printf("\nОшибка!!! Запрашиваемая сумма: %s рублей не может быть выдана, так как в ячейке не хватает купюр данного номинала", amount*cell.value);
                            }
                            else {
                                cell.give(amount);
                                System.out.printf("\nСнято рублей: %s", amount*cell.value);
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
