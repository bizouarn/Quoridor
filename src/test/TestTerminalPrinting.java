package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.Board;
import quoridor.TerminalPrinting;

/**
 * Run test for class TestTerminalPrinting
 */
public class TestTerminalPrinting {

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestTerminalPrinting.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Test
    public void testTerminalPrinting() {
        Board board = new Board(2);
        Assert.assertNotNull(TerminalPrinting.printBoard(board));
        String string = "  ==    ==    ==    ==    ==    ==    ==    ==    ==  \n" +
                "||<>|  |<>|  |<>|  |<>|  |P1|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |P2|  |<>|  |<>|  |<>|  |<>||\n" +
                "  ==    ==    ==    ==    ==    ==    ==    ==    ==  ";
        Assert.assertEquals(TerminalPrinting.printBoard(board), string);
        board = new Board(4);
        Assert.assertNotNull(TerminalPrinting.printBoard(board));
        string = "  ==    ==    ==    ==    ==    ==    ==    ==    ==  \n" +
                "||<>|  |<>|  |<>|  |<>|  |P1|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||P3|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |P4||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>|  |<>||\n" +
                "  --    --    --    --    --    --    --    --    --  \n" +
                "||<>|  |<>|  |<>|  |<>|  |P2|  |<>|  |<>|  |<>|  |<>||\n" +
                "  ==    ==    ==    ==    ==    ==    ==    ==    ==  ";
        Assert.assertEquals(TerminalPrinting.printBoard(board), string);
    }
}
