package test;

import org.junit.*;
import quoridor.*;

import static org.junit.Assert.*;

public class TestHumanPlayer {
    @Test
    public static void testHumanPlayer(){
        HumanPlayer humanPlayer = new HumanPlayer("joueur");
        assertNotNull(humanPlayer);
        assertEquals(humanPlayer,new HumanPlayer("joueur"));
        humanPlayer = new HumanPlayer(null);
        assertNull(humanPlayer);
    }
}
