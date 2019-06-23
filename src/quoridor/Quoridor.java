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
     * Quoridor constructor for Junit test
     * Create an object Quoridor
     * Serve as a platform to load and launch games
     */
    public Quoridor() {

    }

    /**
     * Quoridor constructor
     * Create an object Quoridor
     * Serve as a platform to load and launch games
     *
     * @param args The optional arguments.
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
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Write : \n1 - For new game\n2 - For load old game\n3 - For credits\n4 - For rules");
            choice = scanner.nextLine();
            if (choice.equals("3")) {
                System.out.println("=======================================================================================================\n" +
                        "Programmer :\n" +
                        "- Aymeric Bizouarn -> Student at UIT of Vannes in the IT, focus on the AI, playing input, and GUI.\n" +
                        "- Pierre-Galaad Naquat -> Student at UIT of Vannes in the IT, focused on the board, usability, documentation and GUI.\n" +
                        "Designer :\n" +
                        "- Shung ching 'Claudia' Fung -> Canadian student at the ArtCenter College,(Pasadena, California USA). Designed the visual of the whole playing board.\n" +
                        "=======================================================================================================");
            } else if (choice.equals("4")) {
                System.out.println("=======================================================================================================\n" +
                        "Rules :\n" +
                        "Prupose of the game -> To be the first to reach the line opposite to one's base line.\n" +
                        "Rules for two players -> Each player places his pawn in the center of his base line and gets 10 fences. A draw will determine who starts first.\n" +
                        "Rules for four player -> Each player is given 5 fences an it is forbidden to jump more than one pawn othewise the rules are the same.\n" +
                        "End of game -> The firs player who reaches one of 9 squares opposite his bes line is the winner.\n" +
                        "=======================================================================================================");
            }
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
