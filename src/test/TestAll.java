package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Test all class in package quoridor.
 */
public class TestAll {

    /**
     * Run test
     *
     * @param args optional arguments
     */
    public static void main(String[] args) {
        boolean ret = true;
        Result result = JUnitCore.runClasses(TestAutoPlayer.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestBoard.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestGame.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestHumanPlayer.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestPlayer.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestQuoridor.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestSquare.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestSubBoard.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        result = JUnitCore.runClasses(TestTerminalPrinting.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (!result.wasSuccessful()) {
            ret = false;
        }
        System.out.println(ret);
    }
}
