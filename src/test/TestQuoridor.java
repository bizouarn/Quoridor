package test;

import org.junit.Test;
import quoridor.Quoridor;

import static org.junit.Assert.assertNotNull;

public class TestQuoridor {
    @Test
    public static void testQuoridor() {
        Quoridor quoridor = new Quoridor(null);
        assertNotNull(quoridor);
        quoridor = new Quoridor(null);
        assertNotNull(quoridor);
    }

    @Test
    public static void testLoadOldGameAndTestSaveGame() {
        Quoridor quoridor = new Quoridor(null);
        quoridor.saveGame(quoridor.getGame());
        assertNotNull(Quoridor.loadOldGame());
    }
}
