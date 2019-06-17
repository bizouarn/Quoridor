package test;

import org.junit.*;
import quoridor.*;

import static org.junit.Assert.*;

public class TestGame {
    @Test
    public static void testGame(){
        Game game = new Game(false);
        assertNotNull(game);
    }
    @Test
    public static void testWhoStarts(){
        Game game = new Game(false);
        assertNotNull(game.whoStarts());
    }
}
