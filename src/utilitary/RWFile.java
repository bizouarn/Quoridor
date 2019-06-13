package utilitary;

import quoridor.Quoridor;

import java.io.*;

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
    public Quoridor readFile(String fileName) {
        try {
            FileInputStream fin = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fin);
            return (Quoridor) ois.readObject();
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
    public void writeFile(String fileName, Quoridor quoridor) {
        try {
            FileOutputStream fin = new FileOutputStream(fileName);
            ObjectOutputStream ois = new ObjectOutputStream(fin);
            ois.writeObject(quoridor);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
