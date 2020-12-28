package lesson6;

public enum CellValues {
    ONEHUNDRED(100, "100 рублей", 1),
    FIVEHUNDRED(500, "500 рублей", 2),
    THOUSAND(1000, "1000 рублей", 3),
    FIVETHOUSAND(5000, "5000 рублей", 4);

    private final int value;
    private final String name;
    private final int id;

    CellValues(int value, String name, int id) {
        this.value = value;
        this.name = name;
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
