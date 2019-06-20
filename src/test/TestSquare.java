package test;

import org.junit.Test;
import quoridor.Square;

import static org.junit.Assert.assertNotNull;

public class TestSquare {
    @Test
    public static void TestSquare() {
        Square square = new Square(0, 0);
        assertNotNull(square);
    }
}
