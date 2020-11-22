package lesson6;
import java.util.Scanner;

public class ATM implements CashMachineInterface
{
    // Ячейки с количеством купюр внутри
    public int box_100;
    public int box_200;
    public int box_500;
    public int box_1000;
    public int box_2000;
    public int box_5000;
    public int balance;


    public ATM(int box_100, int box_200, int box_500, int box_1000, int box_2000, int box_5000) {
        this.box_100 = box_100;
        this.box_200 = box_200;
        this.box_500 = box_500;
        this.box_1000 = box_1000;
        this.box_2000 = box_2000;
        this.box_5000 = box_5000;
        this.balance = box_100*100+box_200*200+box_500*500+box_1000*1000+box_2000*2000+box_5000*5000;
    }

    @Override
    public void run()
    {
        Scanner s = new Scanner(System.in);
        while(true)
        {
            System.out.println("Добрый день!");
            System.out.println("Нажмите 1 для снятия наличных");
            System.out.println("Нажмите 2 для пополнения баланса");
            System.out.println("Нажмите 3 для проверки баланса");
            System.out.println("Нажмите 4 для выхода из сеанса");
            System.out.printf("Количество банкнот в ячейках: 5000: %s, 2000: %s, 1000: %s, 500: %s, 200: %s, 100: %s%n",
                    box_5000, box_2000, box_1000, box_500, box_200, box_100);
            System.out.print("Введите необходимую цифру:");
            int n = s.nextInt();
            switch(n)
            {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    balance();
                    break;
                case 4:
                    exit();
            }
        }
    }

    @Override
    public void exit() {
        System.exit(0);
    }

    public int balance() {
        System.out.println("Баланс: "+balance);
        System.out.println("");
        return balance;
    }

    @Override
    public void withdraw() {
        Scanner input = new Scanner(System.in);

        int withdraw;

        System.out.println("Введите сумму необходимую для снятия");
        withdraw = input.nextInt();
        if(balance >= withdraw)
        {

            balance = balance - withdrawCalculate(withdraw);
            System.out.println("Операция выполнена. Пожалуйста, заберите купюры");
        }
        else
        {
            System.out.println("");
            System.out.println("Отказ! Недостаточный баланс!");
        }
        System.out.println("");

    }

    @Override
    public void deposit() {
        Scanner input = new Scanner(System.in);
        int deposit;

        System.out.println("Количество 100 рублевых банкнот:");
        int val_100 = input.nextInt();
        box_100 = box_100+val_100;

        System.out.println("Количество 200 рублевых банкнот:");
        int val_200 = input.nextInt();
        box_200 = box_200+val_200;

        System.out.println("Количество 500 рублевых банкнот:");
        int val_500 = input.nextInt();
        box_500 = box_500+val_500;

        System.out.println("Количество 1000 рублевых банкнот:");
        int val_1000 = input.nextInt();
        box_1000 = box_1000+val_1000;

        System.out.println("Количество 2000 рублевых банкнот:");
        int val_2000 = input.nextInt();
        box_2000 = box_2000+val_2000;

        System.out.println("Количество 5000 рублевых банкнот:");
        int val_5000 = input.nextInt();
        box_5000 = box_5000+val_5000;

        deposit = val_100*100+val_200*200+val_500*500+val_1000*1000+val_2000*2000+val_5000*5000;
        balance = balance + deposit;
        System.out.println("Сумма была успешно внесена на счет");
        System.out.println("");
    }

    private int withdrawCalculate(int withdrawAmount) {
        int withdrawBalance = 0;
        if (withdrawAmount%100 == 0) {
            System.out.println("OK!!!");
            System.out.println("");
            while(withdrawAmount > 0) {
                if (withdrawAmount >= 5000 && box_5000 > 0){
                    withdrawAmount = withdrawAmount - 5000;
                    box_5000--;
                    withdrawBalance = withdrawBalance+5000;
                }
                if (withdrawAmount >= 2000 && box_2000 > 0){
                    withdrawAmount = withdrawAmount - 2000;
                    box_2000--;
                    withdrawBalance = withdrawBalance+2000;
                }
                if (withdrawAmount >= 1000 && box_1000 > 0){
                    withdrawAmount = withdrawAmount - 1000;
                    box_1000--;
                    withdrawBalance = withdrawBalance+1000;
                }
                if (withdrawAmount >= 500 && box_500 > 0){
                    withdrawAmount = withdrawAmount - 500;
                    box_500--;
                    withdrawBalance = withdrawBalance+500;
                }
                if (withdrawAmount >= 200 && box_200 > 0){
                    withdrawAmount = withdrawAmount - 200;
                    box_200--;
                    withdrawBalance = withdrawBalance+200;
                }
                if (withdrawAmount >= 100 && box_100 > 0){
                    withdrawAmount = withdrawAmount - 100;
                    box_100--;
                    withdrawBalance = withdrawBalance+100;
                }
            }
            if (withdrawAmount > 0) {
                System.out.println("В выдаче отказано! Не хватает купюр определенного номинала");
                System.out.println("");
                withdrawBalance = 0;
            }
        }
        else {
            System.out.println("Данную сумму невозможно выдать по причине отсутствия банкнот запрашиваемого номинала!!!");
            System.out.println("");
        }
        return withdrawBalance;
    }
}