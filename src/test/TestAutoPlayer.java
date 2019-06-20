package test;

import org.junit.Test;
import quoridor.AutoPlayer;
import quoridor.Board;
import quoridor.Game;

import static org.junit.Assert.*;

public class TestAutoPlayer {
    @Test
    public static void testAutoplayer() {
        Board board = new Board();
        Game game = new Game(false);
        AutoPlayer autoPlayer = new AutoPlayer("joueur", game);
        assertNotNull(autoPlayer);
        assertEquals(autoPlayer, new AutoPlayer("joueur", game));
        autoPlayer = new AutoPlayer(null, null);
        assertNull(autoPlayer);
    }

    @Test
    public static void testcheckNbRestingFences() {
        Board board = new Board();
        Game game = new Game(false);
        AutoPlayer autoPlayer = new AutoPlayer("joueur", game);
        autoPlayer.setNbFences(20);
        assertEquals(autoPlayer.checkNbRestingFences(), 20);
        autoPlayer.setNbFences(0);
        assertEquals(autoPlayer.checkNbRestingFences(), 0);
    }
}
