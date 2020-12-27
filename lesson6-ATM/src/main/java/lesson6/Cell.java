package lesson6;

public class Cell implements CellInterface{
    String name;
    int amount;
    int value;
    int id;

    public Cell(String name, int amount, int value, int id) {
        this.name = name;
        this.amount = amount;
        this.value = value;
        this.id = id;
    }

    @Override
    public void get(int amount) {
        this.amount = this.amount+amount;
    }

    @Override
    public void give(int amount) {
        this.amount = this.amount-amount;
    }

    @Override
    public int count() {
        return amount*value;
    }
}
