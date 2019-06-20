package quoridor;

// project import

import gui.MenuGui;
import utilitary.RWFile;

import java.util.Scanner;

// java import

/**
 * Permits to launch a session from which can be launch and saved games
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class Quoridor {

    /**
     * The Game.
     */
    private Game game;
    /**
     * The save file name.
     */
    private final String fileName = "./data/save/SavedGame.bin";

    private int gui;

    /**
     * Quoridor constructor
     * Create an object Quoridor
     * Serve as a platform to load and launch games
     *
     * @author Aymeric Bizouarn , Pierre-Galaad Naquet
     */
    public Quoridor(String[] args) {
        this.gui = 0;
        for (String string : args) {
            if (string.equals("nogui")) {
                this.gui = 1;
            }
            if (string.equals("gui")) {
                this.gui = 2;
            }
            if (string.equals("load")) {
                this.gui = 3;
            }
        }
        if (this.gui == 1) {
            choice();
        } else if (this.gui == 2) {
            Game game = new Game(true);
            game.start();
        } else if (this.gui == 3) {
            Game game = RWFile.readFile(this.fileName);
            new Game(game, true);
        } else {
            new MenuGui();
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
            this.game = new Game(false);
            this.game.start();
        } else if (choice.equals("2")) {
            this.game = loadOldGame();

        }
    }

}
