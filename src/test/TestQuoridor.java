package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import quoridor.Quoridor;

/**
 * Run test for class Quoridor
 */
public class TestQuoridor {
    private Quoridor quoridor;

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestQuoridor.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }

    @Test
    public void testQuoridor() {
        Quoridor quoridor = new Quoridor();
        Assert.assertNotNull(quoridor);
    }
}
