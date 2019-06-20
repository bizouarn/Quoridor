package test;

import org.junit.Test;
import quoridor.Board;
import quoridor.Game;
import quoridor.HumanPlayer;

import static org.junit.Assert.*;

public class TestHumanPlayer {
    @Test
    public static void testHumanPlayer() {
        Board board = new Board();
        Game game = new Game(false);
        HumanPlayer humanPlayer = new HumanPlayer("joueur", game);
        assertNotNull(humanPlayer);
        assertEquals(humanPlayer, new HumanPlayer("joueur", game));
        humanPlayer = new HumanPlayer(null, null);
        assertNull(humanPlayer);
    }
}
