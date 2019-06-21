package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.Square;
import quoridor.SubBoard;

/**
 * Run test for class subBoard
 */
public class TestSubBoard {
    private SubBoard subBoard;

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSubBoard.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Before
    public void init() {
        this.subBoard = new SubBoard(new Square(0, 0), new Square(0, 1), new Square(1, 0), new Square(1, 1));
    }

    @Test
    public void testSubBoard() {
        Assert.assertNotNull(subBoard);
    }

    @Test
    public void testGetSqrArray() {
        Square[] squares = subBoard.getSqrArray();
        Assert.assertNotNull(squares);
        Assert.assertEquals(squares.length, 4);
    }
}
