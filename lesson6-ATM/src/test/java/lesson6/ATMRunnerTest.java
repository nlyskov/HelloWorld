package lesson6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lesson6.CellValues.FIVEHUNDRED;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMRunnerTest {
    Cell cell_500 = new Cell(10, FIVEHUNDRED);

    @Test
    @DisplayName("Проверка баланса")
    void balance() {
        assertEquals(5000, cell_500.count());
    }

    @Test
    @DisplayName("Пополнение баланса")
    void put_money() {
        cell_500.give(10);
        assertEquals(0, cell_500.count());
    }

    @Test
    @DisplayName("Снятие наличных")
    void get_money() {
        cell_500.get(10);
        assertEquals(10000, cell_500.count());
    }
}
