package test;

import org.junit.*;
import quoridor.*;

import static org.junit.Assert.*;

public class TestHumanPlayer {
    @Test
    public static void testHumanPlayer(){
        Board board = new Board();
        Game game = new Game();
        HumanPlayer humanPlayer = new HumanPlayer("joueur",game);
        assertNotNull(humanPlayer);
        assertEquals(humanPlayer,new HumanPlayer("joueur",game));
        humanPlayer = new HumanPlayer(null,null);
        assertNull(humanPlayer);
    }
}
