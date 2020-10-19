package lesson22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    Rectangle rectangle = new Rectangle(4, 5);

    @Test
    void perimetr() {
        assertEquals(18, rectangle.perimetr());
    }

    @Test
    void area() {
        assertEquals(20, rectangle.area());
    }

    @Test
    void name() {
        assertEquals("прямоугольник", rectangle.name());
    }
}