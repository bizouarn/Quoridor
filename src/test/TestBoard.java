package test;

import org.junit.Test;
import quoridor.*;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestBoard {
    @Test
    public void testBoard() {
        Board board = new Board();
        assertNotNull(board);
    }

    @Test
    public void testListOfPossibilitiesFence() {
        Board board = new Board();
        //ArrayList<Square> arrayPossibilitiesFence = board.listOfPossibilitiesFence();
        //assertNotNull(arrayPossibilitiesFence);
    }

    @Test
    public void testListOfPossibilitiesPawn() {
        Game game = new Game(false);
        Board board = new Board();
        Player player = new AutoPlayer("joueur", game);
        ArrayList<Square> arrayPossibilitiesPawn = board.listOfPossibilitiesPawn(player, game);
        assertNotNull(arrayPossibilitiesPawn);
        assertNull(board.listOfPossibilitiesPawn(null, null));
    }
}
