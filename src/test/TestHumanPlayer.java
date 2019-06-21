package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.Game;
import quoridor.HumanPlayer;

/**
 * Run test for class HumanPlayer
 */
public class TestHumanPlayer {
    private HumanPlayer humanPlayer;

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestHumanPlayer.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Before
    public void init() {
        this.humanPlayer = new HumanPlayer("test", new Game());
    }

    @Test
    public void testHumanPlayer() {
        Assert.assertNotNull(humanPlayer);
    }
}
