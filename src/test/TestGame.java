package test;

import org.junit.Test;
import quoridor.Game;

import static org.junit.Assert.assertNotNull;

public class TestGame {
    @Test
    public static void testGame() {
        Game game = new Game(false);
        assertNotNull(game);
    }

    @Test
    public static void testWhoStarts() {
        Game game = new Game(false);
        assertNotNull(game.whoStarts());
    }
}
