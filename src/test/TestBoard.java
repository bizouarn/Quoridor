package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.Board;
import quoridor.Square;
import quoridor.SubBoard;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Run test for class Board
 */
public class TestBoard {
    private Board board;

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestBoard.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Before
    public void init() {
        this.board = new Board(2);
    }

    @Test
    public void testBoard() {
        Board board = new Board(2);
        assertNotNull(board);
    }

    @Test
    public void testListOfPossibilitiesFenceHorizontal() {
        ArrayList<SubBoard> possibilitiesFenceHorizontal = board.listOfPossibilitiesFenceHorizontal();
        assertNotNull(possibilitiesFenceHorizontal);
    }

    @Test
    public void testListOfPossibilitiesFenceVertical() {
        ArrayList<SubBoard> possibilitiesFenceVertical = board.listOfPossibilitiesFenceVertical();
        assertNotNull(possibilitiesFenceVertical);
    }

    @Test
    public void testListOfPossibilitiesPawn() {
        ArrayList<Square> arrayPossibilitiesPawn = board.listOfPossibilitiesPawn(board.getSquare(0, 0));
        assertNotNull(arrayPossibilitiesPawn);
        Assert.assertEquals(arrayPossibilitiesPawn.size(), 2);
        arrayPossibilitiesPawn = board.listOfPossibilitiesPawn(board.getSquare(4, 4));
        assertNotNull(arrayPossibilitiesPawn);
        Assert.assertEquals(arrayPossibilitiesPawn.size(), 4);
    }

    @Test
    public void testGetSubBoard() {
        SubBoard subBoard = board.getSubBoard(0, 0);
        assertNotNull(subBoard);
        subBoard = board.getSubBoard(8, 8);
        assertNull(subBoard);
        subBoard = board.getSubBoard(9, 9);
        assertNull(subBoard);
    }

    @Test
    public void testGetPlayerSquare() {
        Assert.assertNull(board.getPlayer3Square());
        Assert.assertNull(board.getPlayer4Square());
        Board board = new Board(4);
        Square square = board.getPlayer1Square();
        Assert.assertNotNull(square);
        Assert.assertEquals(square.getX(), 0);
        Assert.assertEquals(square.getY(), 4);
        square = board.getPlayer2Square();
        Assert.assertNotNull(square);
        Assert.assertEquals(square.getX(), 8);
        Assert.assertEquals(square.getY(), 4);
        square = board.getPlayer3Square();
        Assert.assertNotNull(square);
        Assert.assertEquals(square.getX(), 4);
        Assert.assertEquals(square.getY(), 0);
        square = board.getPlayer4Square();
        assertNotNull(square);
        Assert.assertEquals(square.getX(), 4);
        Assert.assertEquals(square.getY(), 8);
    }

    @Test
    public void testToString() {
        Assert.assertNotNull(board.toString());
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
        Assert.assertEquals(board.toString(), string);
    }
}
