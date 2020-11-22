package lesson6;

public class App
{
    public static void main(String[] args) {
        ATM CashMachine = new ATM(
                10,
                10,
                10,
                10,
                10,
                10
        );
        CashMachine.run();
    }
}