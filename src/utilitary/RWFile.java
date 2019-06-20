package utilitary;

import quoridor.Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Aymeric Bizouarn
 */
public class RWFile {

    /**
     * Read Quoridor object into a file.
     *
     * @param fileName The file name.
     * @author Aymeric Bizouarn
     */
    public static Game readFile(String fileName) {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            return (Game) ois.readObject();
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /**
     * Write Quoridor object into a file.
     *
     * @param fileName The file name.
     * @author Aymeric Bizouarn
     */
    public static void writeFile(String fileName, Game game) {
        try {
            FileOutputStream fin = new FileOutputStream(fileName);
            ObjectOutputStream ois = new ObjectOutputStream(fin);
            ois.writeObject(game);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
