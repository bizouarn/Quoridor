package quoridor;

// project import

import gui.MenuGui;
import quoridor.Game;
import utilitary.RWFile;

// java import
import java.awt.*;
import java.util.Scanner;

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
            new Game(game,true);
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
        savedGame.getGuiFrame().getjFrame().setVisible(true);
        return savedGame;
    }

    /**
     * Launch the chosen game
     *
     * @param game the desired game to launch
     * @author Aymeric Bizouarn
     */
    public void launchGame(Game game) {
        this.game.start();
    }

    /**
     * Save the desired game into the saving file of the current Quoridor object
     *
     * @param game The desired game to save
     * @author Aymeric Bizouarn
     */
    public void saveGame(Game game) {
        RWFile.writeFile(this.fileName, this.game);
    }

    /**
     * In terminal mode permits to choose to create a new game, or to load the old one
     *
     * @author Aymeric Bizouarn
     */
    public void choice() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice > 2 || choice < 1) {
            System.out.println("Write : \n1 - For new game\n2 - For load old game");
            choice = scanner.nextInt();
        }
        if (choice == 1) {
            this.game = new Game(false);
        } else if (choice == 2) {
            this.loadOldGame();
        }
        this.launchGame(this.game);
    }

}
