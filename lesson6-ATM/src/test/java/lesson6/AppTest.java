package lesson6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest{
    ATM CashMachine = new ATM(
            10,
            10,
            10,
            10,
            10,
            10
    );

    @Test
    void balance() {
        assertEquals(88000, CashMachine.balance());
    }
}
