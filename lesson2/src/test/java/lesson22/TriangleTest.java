package lesson22;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @DisplayName("Имя фигуры: Треугольник")
    @Test
    void name() {
        String result = triangle.name();
        assertThat(result)
                .isNotEmpty()
                .endsWith( "ольник" );

    }
}