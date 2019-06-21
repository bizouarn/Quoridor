package test;

import quoridor.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestBoard {
    @Test
    public void testBoard() {
        Board board = new Board(2);
        assertNotNull(board);
    }

    @Test
    public void testListOfPossibilitiesFence() {
        Board board = new Board(2);
        //ArrayList<Square> arrayPossibilitiesFence = board.listOfPossibilitiesFence();
        //assertNotNull(arrayPossibilitiesFence);
    }

    @Test
    public void testListOfPossibilitiesPawn() {
        Game game = new Game(false,2);
        Board board = new Board(2);
        Player player = new AutoPlayer("joueur", game);
        ArrayList<Square> arrayPossibilitiesPawn = board.listOfPossibilitiesPawn(player, game);
        assertNotNull(arrayPossibilitiesPawn);
        assertNull(board.listOfPossibilitiesPawn(null, null));
    }
}
