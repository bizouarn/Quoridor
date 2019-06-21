package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.Square;

/**
 * Run test for class square
 */
public class TestSquare {

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSquare.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Test
    public void TestSquare() {
        Square square = new Square(0, 0);
        Assert.assertNotNull(square);
        Assert.assertEquals(square.getX(), 0);
        Assert.assertEquals(square.getY(), 0);
        square = new Square(8, 8);
        Assert.assertNotNull(square);
        Assert.assertEquals(square.getX(), 8);
        Assert.assertEquals(square.getY(), 8);
    }
}
