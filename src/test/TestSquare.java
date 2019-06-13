package test;

import org.junit.*;
import quoridor.*;

import static org.junit.Assert.*;

public class TestSquare {
    @Test
    public static void TestSquare(){
        Square square = new Square(0,0);
        assertNotNull(square);
    }
}
