package quoridor;

import gui.MenuGui;
import utilitary.RWFile;

import javax.swing.*;
import java.util.Scanner;

/**
 * Permits to launch a session from which can be launch and saved games
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class Quoridor {

    /**
     * The save file name.
     */
    private final String fileName = "./data/save/SavedGame.bin";
    /**
     * The Game.
     */
    private Game game;

    /**
     * Quoridor constructor
     * Create an object Quoridor
     * Serve as a platform to load and launch games
     *
     * @author Aymeric Bizouarn , Pierre-Galaad Naquet
     */
    public Quoridor(String[] args) {
        int gui = 0;
        for (String string : args) {
            if (string.equals("nogui")) {
                gui = 1;
            }
            if (string.equals("gui")) {
                gui = 2;
            }
            if (string.equals("load")) {
                gui = 3;
            }
        }
        if (gui == 1) {
            choice();
        } else if (gui == 2) {
            Object[] options = {"2 Player", "4 Player"};
            int choice = JOptionPane.showOptionDialog(null,
                    " Player number ? ",
                    " Player number ? ",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            int nbPlayer;
            if (choice == JOptionPane.YES_OPTION) {
                nbPlayer = 2;
            } else {
                nbPlayer = 4;
            }
            Game game = new Game(true, nbPlayer);
            game.start();
        } else if (gui == 3) {
            Game game = RWFile.readFile(this.fileName);
            new Game(game, true);
        } else {
            new MenuGui();
        }

    }

    /**
     * @return the previously saved game
     * @author Aymeric Bizouarn
     */
    public static Game loadOldGame() {
        Game savedGame = RWFile.readFile("./data/save/SavedGame.bin");
        savedGame = new Game(savedGame, false);
        return savedGame;
    }

    /**
     * Save the desired game into the saving file of the current Quoridor object
     *
     * @param game The desired game to save
     * @author Aymeric Bizouarn
     */
    public void saveGame(Game game) {
        RWFile.writeFile(this.fileName, game);
    }

    /**
     * In terminal mode permits to choose to create a new game, or to load the old one
     *
     * @author Aymeric Bizouarn
     */
    private void choice() {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3")) {
            System.out.println("Write : \n1 - For new game\n2 - For load old game");
            choice = scanner.nextLine();
        }
        if (choice.equals("1")) {
            choice = "";
            while (!(choice.equals("1") || choice.equals("2"))) {
                System.out.println("Write : \n1 - 2 Player \n2 - 4 Player");
                choice = scanner.nextLine();
                if (choice.equals("1")) {
                    this.game = new Game(false, 2);
                    this.game.start();
                } else if (choice.equals("2")) {
                    this.game = new Game(false, 4);
                    this.game.start();
                }
            }
        } else if (choice.equals("2")) {
            this.game = loadOldGame();

        }
    }

    /**
     * Get Quoridor Game.
     *
     * @return the Game of the current Quoridor.
     */
    public Game getGame() {
        return this.game;
    }

}
