package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.AutoPlayer;
import quoridor.Game;

/**
 * Run test for class AutoPlayer
 */
public class TestAutoPlayer {
    private Game game;
    private AutoPlayer autoPlayer;

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestAutoPlayer.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Before
    public void init() {
        this.game = new Game();
        this.autoPlayer = new AutoPlayer("test", game);
    }

    @Test
    public void testAutoPlayer() {
        Assert.assertNotNull(autoPlayer);
    }

    @Test
    public void testPlay() {
        autoPlayer.play();
    }
}
