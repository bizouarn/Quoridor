package test;

import org.junit.*;
import quoridor.*;

import static org.junit.Assert.*;

public class TestAutoPlayer {
    @Test
    public static void testAutoplayer(){
        AutoPlayer autoPlayer = new AutoPlayer("joueur");
        assertNotNull(autoPlayer);
        assertEquals(autoPlayer,new AutoPlayer("joueur"));
        autoPlayer = new AutoPlayer(null);
        assertNull(autoPlayer);
    }
    @Test
    public static void testcheckNbRestingFences() {
        AutoPlayer autoPlayer = new AutoPlayer("joueur");
        autoPlayer.setNbFences(20);
        assertEquals(autoPlayer.checkNbRestingFences(),20);
        autoPlayer.setNbFences(0);
        assertEquals(autoPlayer.checkNbRestingFences(),0);
    }
}
