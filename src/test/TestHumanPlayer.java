package test;

import org.junit.*;
import quoridor.*;

import static org.junit.Assert.*;

public class TestHumanPlayer {
    @Test
    public static void testHumanPlayer(){
        Board board = new Board();
        HumanPlayer humanPlayer = new HumanPlayer("joueur",board);
        assertNotNull(humanPlayer);
        assertEquals(humanPlayer,new HumanPlayer("joueur",board));
        humanPlayer = new HumanPlayer(null,null);
        assertNull(humanPlayer);
    }
}
