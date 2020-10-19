package lesson22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    Square square = new Square(5);

    @Test
    void perimetr() {
        assertEquals(20, square.perimetr());
    }

    @Test
    void area() {
        assertEquals(25, square.area());
    }

    @Test
    void name() {
        assertEquals("квадрат", square.name());
    }
}