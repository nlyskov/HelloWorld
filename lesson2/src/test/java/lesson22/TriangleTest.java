package lesson22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    Triangle triangle = new Triangle(3,4,5);

    @Test
    void perimetr() {
        assertEquals(12, triangle.perimetr());
    }

    @Test
    void area() {
        assertEquals(6, triangle.area());
    }

    @Test
    void name() {
        assertEquals("треугольник", triangle.name());
    }
}