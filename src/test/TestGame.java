package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.Game;

/**
 * Run test for class Game
 */
public class TestGame {
    private Game game;

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestGame.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Before
    public void init() {
        this.game = new Game();
    }

    @Test
    public void testGame() {
        Assert.assertNotNull(game);
    }

    @Test
    public void testWhoStarts() {
        Assert.assertNotNull(game.whoStarts());
    }

    @Test
    public void testExistingPath() {
        Assert.assertTrue(game.checkExistingPath());
    }

    @Test
    public void testGetMinMove() {
        int value = game.getNbMinMove(game.getBoard().getPlayer1Square(), 1);
        Assert.assertEquals(value, 8);
    }
}
