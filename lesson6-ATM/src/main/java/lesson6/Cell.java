package lesson6;


class Cell implements CellInterface {
    int amount;
    CellValues cellType;

    public Cell(int amount, CellValues cell_type) {
        this.amount = amount;
        this.cellType = cell_type;
    }

    @Override
    public void get(int amount) {
        this.amount = this.amount + amount;
    }

    @Override
    public boolean give(int amount) {
        boolean operationResult = false;
        if (this.amount >= amount) {
            this.amount = this.amount - amount;
            operationResult = true;
        }
        return operationResult;
    }

    @Override
    public int count() {
        return amount * cellType.value;
    }
}
