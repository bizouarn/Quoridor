package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.AutoPlayer;
import quoridor.Game;
import quoridor.Player;

/**
 * Run test for class player
 */
public class TestPlayer {
    private Player player;

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestPlayer.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Before
    public void init() {
        this.player = new AutoPlayer("test", new Game());
    }

    @Test
    public void testPlayer() {
        Assert.assertNotNull(player);
        Assert.assertEquals(player.getName(), "test");
        Assert.assertEquals(player.checkNbRestingFences(), 10);
    }

    @Test
    public void testPlayFence() {
        player.playFence(0, 0, 1, 1, 1);
        player.playFence(1, 1, 2, 2, 2);
    }

    @Test
    public void testPlayPawn() {
        player.playPawn(1, 4);
    }
}
