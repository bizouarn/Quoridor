package test;

import org.junit.*;
import quoridor.*;

import static org.junit.Assert.*;

public class TestAutoPlayer {
    @Test
    public static void testAutoplayer(){
        Board board = new Board();
        AutoPlayer autoPlayer = new AutoPlayer("joueur",board);
        assertNotNull(autoPlayer);
        assertEquals(autoPlayer,new AutoPlayer("joueur",board));
        autoPlayer = new AutoPlayer(null,null);
        assertNull(autoPlayer);
    }
    @Test
    public static void testcheckNbRestingFences() {
        Board board = new Board();
        AutoPlayer autoPlayer = new AutoPlayer("joueur",board);
        autoPlayer.setNbFences(20);
        assertEquals(autoPlayer.checkNbRestingFences(),20);
        autoPlayer.setNbFences(0);
        assertEquals(autoPlayer.checkNbRestingFences(),0);
    }
}
