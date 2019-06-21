package quoridor;

import gui.Gui;
import gui.PopUpEndOfGame;
import gui.PopUpInputPlayer;
import utilitary.RWFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the methods to initialize the game
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class Game implements java.io.Serializable {

    /**
     * The game board
     */
    private Board board;
    /**
     * The player 1
     */
    private Player player1;
    /**
     * The player 2
     */
    private Player player2;
    /**
     * The player 3 (used only in 4 players game mode)
     */
    private Player player3;
    /**
     * The player 4 (used only in 4 players game mode)
     */
    private Player player4;

    /**
     * Player which is currently playing
     */
    private Player playerActual;
    /**
     * Number of the player playing
     */
    private int playerPlay;
    /**
     * Number of player in the game (either 2 or 4)
     */
    private int nbPlayer;

    /**
     * True if the gui is used
     */
    private boolean gui;
    /**
     * The gui used
     */
    private Gui guiFrame;

    /**
     * Game constructor
     * Launch either a swing game or a terminal one
     *
     * @param gui true if the game has to be launched in the swing version, false otherwise
     * @author Aymeric Bizouarn
     */
    public Game(boolean gui, int nbPlayer) {
        this.nbPlayer = nbPlayer;
        this.gui = gui;
        if (gui) {
            initializeGame();
            this.guiFrame = new Gui(this);
        } else {
            initializeGame();
        }
    }

    /**
     * Game constructor
     * Launch either a swing game or a terminal one
     *
     * @param game The game you would load.
     * @param gui  true if the game has to be launched in the swing version, false otherwise
     * @author Aymeric Bizouarn
     */
    public Game(Game game, boolean gui) {
        this.gui = gui;
        try {
            FileReader fw = new FileReader(new File("./data/save/Player.bin"));
            Scanner sc = new Scanner(fw);
            this.nbPlayer = Integer.parseInt(sc.nextLine());
            String name1 = sc.nextLine();
            int fence1 = Integer.parseInt(sc.nextLine());
            String name2 = sc.nextLine();
            int fence2 = Integer.parseInt(sc.nextLine());
            if (name1.equals("auto1")) {
                this.player1 = new AutoPlayer(name1, this);
            } else {
                this.player1 = new HumanPlayer(name1, this);
            }
            if (name2.equals("auto2")) {
                this.player2 = new AutoPlayer(name2, this);
            } else {
                this.player2 = new HumanPlayer(name2, this);
            }
            if (this.nbPlayer == 4) {
                String name3 = sc.nextLine();
                int fence3 = Integer.parseInt(sc.nextLine());
                String name4 = sc.nextLine();
                int fence4 = Integer.parseInt(sc.nextLine());
                if (name1.equals("auto3")) {
                    this.player3 = new AutoPlayer(name3, this);
                } else {
                    this.player3 = new HumanPlayer(name3, this);
                }
                if (name2.equals("auto4")) {
                    this.player4 = new AutoPlayer(name4, this);
                } else {
                    this.player4 = new HumanPlayer(name4, this);
                }
                this.player3.setNbFences(fence3);
                this.player4.setNbFences(fence4);
            }
            this.player1.setNbFences(fence1);
            this.player2.setNbFences(fence2);
            this.playerPlay = Integer.parseInt(sc.nextLine());
            fw.close();
        } catch (Exception e) {
            //System.out.println(e);
        }
        this.board = game.getBoard();
        if (gui) {
            this.guiFrame = new Gui(this);
            this.guiFrame.getjFrame().setVisible(true);
        }
        startLoaded();
    }

    /**
     * Get the board
     *
     * @return the current board
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Set the Game Board.
     *
     * @param board the desired board to play the game with.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Initialize the game by creating a new board and by asking for players name.
     *
     * @author Aymeric Bizouarn , Pierre-Galaad Naquet
     */
    private void initializeGame() {
        String name1 = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
        if (this.gui) {
            name1 = PopUpInputPlayer.popUpPlayer(1);
            name2 = PopUpInputPlayer.popUpPlayer(2);
            if (this.nbPlayer == 4) {
                name3 = PopUpInputPlayer.popUpPlayer(3);
                name4 = PopUpInputPlayer.popUpPlayer(4);
            }
        } else {
            Scanner scanner = new Scanner(System.in);
            while (name1.length() < 2) {
                System.out.println("Name Player 1 : ");
                name1 = scanner.nextLine();
                if (name1.length() < 2) {
                    System.out.println("Invalid input : The size of the name has minimum 2 characters");
                }
            }
            while (name2.length() < 2) {
                System.out.println("Name Player 2 : ");
                name2 = scanner.nextLine();
                if (name2.length() < 2) {
                    System.out.println("Invalid input : The size of the name has minimum 2 characters");
                }
            }
            if (this.nbPlayer == 4) {
                while (name3.length() < 2) {
                    System.out.println("Name Player 1 : ");
                    name3 = scanner.nextLine();
                    if (name3.length() < 2) {
                        System.out.println("Invalid input : The size of the name has minimum 2 characters");
                    }
                }
                while (name4.length() < 2) {
                    System.out.println("Name Player 1 : ");
                    name4 = scanner.nextLine();
                    if (name4.length() < 2) {
                        System.out.println("Invalid input : The size of the name has minimum 2 characters");
                    }
                }
            }
        }

        if (name1.equals("auto")) {
            this.player1 = new AutoPlayer(name1 + "1", this);
        } else {
            this.player1 = new HumanPlayer(name1, this);
        }

        if (name2.equals("auto")) {
            this.player2 = new AutoPlayer(name2 + "2", this);
        } else {
            this.player2 = new HumanPlayer(name2, this);
        }
        if (nbPlayer == 4) {
            if (name3.equals("auto")) {
                this.player3 = new AutoPlayer(name3 + "3", this);
            } else {
                this.player3 = new HumanPlayer(name3, this);
            }

            if (name4.equals("auto")) {
                this.player4 = new AutoPlayer(name4 + "4", this);
            } else {
                this.player4 = new HumanPlayer(name4, this);
            }
        }

        this.board = new Board(this.nbPlayer);
    }

    /**
     * Choose randomly which player plays first
     *
     * @return the starting player
     */
    public Player whoStarts() {
        int random = (int) (Math.random() * 100);
        Player ret;
        if (nbPlayer == 2) {
            if (random <= 50) {
                ret = this.player1;
            } else {
                ret = this.player2;
            }
        } else {
            if (random <= 25) {
                ret = this.player1;
            } else if (random <= 50) {
                ret = this.player2;
            } else if (random <= 75) {
                ret = this.player4;
            } else {
                ret = this.player3;
            }
        }
        return ret;
    }

    /**
     * Launch the game and select the starting player with the attributes as parameters.
     *
     * @author Aymeric Bizouarn
     */
    void start() {
        playerPlay = 1; //1 = for player1 play & 2 = for player2
        Player playerWhoStart = whoStarts();
        if (playerWhoStart == this.player1) {
            playerPlay = 1;
        } else if (playerWhoStart == this.player2) {
            playerPlay = 2;
        } else if (playerWhoStart == this.player3) {
            playerPlay = 3;
        } else {
            playerPlay = 4;
        }
        startLoaded();
    }

    /**
     * Launch the game with the attributes as parameters and gives the hand to the current player.
     *
     * @author Pierre-Galaad Naquet
     */
    private void startLoaded() {
        this.playerActual = null;
        while (!checkEndOfGame()) {
            if (playerPlay == 1) {
                this.playerActual = this.player1;
            } else if (playerPlay == 2) {
                this.playerActual = this.player2;
            } else if (playerPlay == 3) {
                this.playerActual = this.player3;
            } else {
                this.playerActual = this.player4;
            }
            System.out.println(this.board);
            System.out.println(this.playerActual.getName() + " : ");
            if (this.gui) {
                this.guiFrame.refresh();
            }
            this.playerActual.play();
            playerPlay++;
            if (playerPlay > nbPlayer) {
                playerPlay = 1;
            }
        }
        if (this.gui) {
            this.guiFrame.refresh();
        }
        endOfGame(playerActual);
    }

    /**
     * Check if the game has ended
     *
     * @return True if the game has ended, false otherwise
     * @author Aymeric Bizouarn
     */
    private boolean checkEndOfGame() {
        boolean ret = false;
        if (this.board.getPlayer1Square() != null && this.board.getPlayer2Square() != null) {
            if (this.board.getPlayer1Square().getX() == 8) {
                ret = true;
            } else if (this.board.getPlayer2Square().getX() == 0) {
                ret = true;
            }
            if (nbPlayer == 4) {
                if (this.board.getPlayer3Square().getY() == 8) {
                    ret = true;
                } else if (this.board.getPlayer4Square().getY() == 0) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    /**
     * End the game and launch the results procedure
     *
     * @author Pierre-Galaad Naquet
     */
    private void endOfGame(Player player) {

        Scanner scan;
        boolean bool = false;

        int choice = -1;
        if (this.gui) {
            choice = PopUpEndOfGame.popUpEndOfGame(player);
            if (choice == 1) {
                this.guiFrame.getjFrame().dispose();
                this.getPlayer1().setNbFences(10);
                this.getPlayer2().setNbFences(10);
                if (this.nbPlayer == 4) {
                    this.getPlayer3().setNbFences(10);
                    this.getPlayer4().setNbFences(10);
                }
                this.board = new Board(this.nbPlayer);
                this.guiFrame = new Gui(this);
                this.start();
            }
            if (choice == 2) {
                try {
                    guiFrame.getjFrame().dispose();
                    FileWriter fw = new FileWriter(new File("./data/new.bin"), false);
                    fw.write("menu");
                    fw.close();
                } catch (IOException e) {
                    System.err.println("Game (End of game) :" + e);
                }
            }
            if (choice == 3) {
                System.exit(0);
            }
        } else {
            System.out.println("The player : " + playerActual.getName() + " has won !");
            System.out.println(this.board);
            System.out.println();
            System.out.println("What do you want to do ?");
            System.out.println("1 - New Game");
            System.out.println("2 - Change Players");
            System.out.println("3 - Leave the program");

            while (!bool) {
                try {
                    scan = new Scanner(System.in);
                    choice = scan.nextInt();
                    if (choice > 0 && choice < 4) {
                        bool = true;
                    } else {
                        System.out.println("Please, select a valid option");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input !");
                }
                if (choice == 1) {
                    this.getPlayer1().setNbFences(10);
                    this.getPlayer2().setNbFences(10);
                    if (nbPlayer == 4) {
                        this.getPlayer3().setNbFences(10);
                        this.getPlayer4().setNbFences(10);
                    }
                    this.board = new Board(this.nbPlayer);
                    this.start();
                }
                if (choice == 2) {
                    Scanner scanner = new Scanner(System.in);
                    String choiceS = "";
                    while (!(choiceS.equals("1") || choiceS.equals("2"))) {
                        System.out.println("Write : \n1 - 2 Player \n2 - 4 Player");
                        choiceS = scanner.nextLine();
                        if (choiceS.equals("1")) {
                            this.nbPlayer = 2;
                        } else if (choiceS.equals("2")) {
                            this.nbPlayer = 4;
                        }
                    }
                    Game game = new Game(this.gui, this.nbPlayer);
                    game.start();
                }
                if (choice == 3) {
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Checks if there is an existing path between the end and the player
     *
     * @return True if a path exists, false otherwise
     * @author Aymeric Bizouarn
     */
    boolean checkExistingPath() {
        boolean ret = false;
        ArrayList<String> listSquare = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                listSquare.add(i + "," + j);
            }
        }
        boolean resP1 = recExistingPath(this.board.getPlayer1Square(), 1, new ArrayList<>(listSquare));
        boolean resP2 = recExistingPath(this.board.getPlayer2Square(), 2, new ArrayList<>(listSquare));
        if (nbPlayer == 2) {
            if (resP1 && resP2) {
                ret = true;
            }
        } else {
            boolean resP3 = recExistingPath(this.board.getPlayer3Square(), 3, new ArrayList<>(listSquare));
            boolean resP4 = recExistingPath(this.board.getPlayer4Square(), 4, new ArrayList<>(listSquare));
            System.out.print(resP4);
            if (resP1 && resP2 && resP3 && resP4) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Recursive methods checking the existing path.
     *
     * @param sqr           the current square
     * @param player        the current player
     * @param listSquareTmp the current list of the path
     * @return True if there is an existing path, false otherwise
     * @author Aymeric Bizouarn
     */
    private boolean recExistingPath(Square sqr, int player, ArrayList<String> listSquareTmp) {
        boolean ret = false;
        ArrayList<String> listSquare = new ArrayList<>(listSquareTmp);
        listSquare.remove(sqr.getX() + "," + sqr.getY());
        ArrayList<Square> possibilitiesPawn = this.board.listOfPossibilitiesPawn(sqr);
        if (sqr.getX() == 8 && player == 1) {
            ret = true;
        } else if (sqr.getX() == 0 && player == 2) {
            ret = true;
        } else if (sqr.getY() == 8 && player == 3) {
            ret = true;
        } else if (sqr.getY() == 0 && player == 4) {
            ret = true;
        } else {
            for (Square sqrP : possibilitiesPawn) {
                if (sqrP != null) {
                    if (!ret) {
                        String value = sqrP.getX() + "," + sqrP.getY();
                        if (listSquare.indexOf(value) != -1) {
                            ret = recExistingPath(sqrP, player, listSquare);
                        }
                    }
                }
            }
        }
        return ret;
    }

    /**
     * get the path with the fewest tiles to the opposite side of the board
     *
     * @param sqr    the current square
     * @param player the current player
     * @return the number of tiles until the opposite side of the board
     * @author Aymeric Bizouarn
     */
    int getNbMinMove(Square sqr, int player) {
        ArrayList<Square> possibilite = this.board.listOfPossibilitiesPawn(sqr);
        ArrayList<Object[]> squaresPossible = new ArrayList<>();
        Object[] value = {sqr, 0};
        squaresPossible.add(value);
        for (int i = 0; i < possibilite.size(); i++) {
            Square square = possibilite.get(i);
            Object[] value2 = {square, 1};
            squaresPossible.add(value2);
        }
        for (int k = 2; k <= 80; k++) {
            for (int j = 0; j < squaresPossible.size(); j++) {
                possibilite = new ArrayList<>(this.board.listOfPossibilitiesPawn((Square) squaresPossible.get(j)[0]));
                ArrayList<Object[]> squaresPossible2 = new ArrayList<>(squaresPossible);
                for (int i = 0; i < possibilite.size(); i++) {
                    boolean condition = true;
                    Square square = possibilite.get(i);
                    for (int l = 0; l < squaresPossible2.size(); l++) {
                        Square oldSquare = (Square) squaresPossible2.get(l)[0];
                        if (square.getX() == oldSquare.getX() && square.getY() == oldSquare.getY()) {
                            condition = false;
                        }
                    }
                    if (condition) {
                        Object[] value2 = {square, ((int) squaresPossible.get(j)[1] + 1)};
                        squaresPossible.add(value2);
                    }
                }
            }
        }
        int min = 82;
        int tmp = min;
        for (Object[] valuePrint : squaresPossible) {
            Square square = (Square) valuePrint[0];
            if (square.getX() == 8 && player == 1) {
                tmp = (int) valuePrint[1];
            } else if (square.getX() == 0 && player == 2) {
                tmp = (int) valuePrint[1];
            } else if (square.getY() == 8 && player == 3) {
                tmp = (int) valuePrint[1];
            } else if (square.getY() == 0 && player == 4) {
                tmp = (int) valuePrint[1];
            }
            if (tmp < min) {
                min = tmp;
            }
        }
        return min;
    }

    /**
     * Save the current Game
     *
     * @author Pierre-Galaad Naquet
     */
    public void saveGame() {
        try {
            RWFile.writeFile("./data/save/SavedGame.bin", this);
            FileWriter fw = new FileWriter(new File("./data/save/Player.bin"), false);
            fw.write(this.nbPlayer + "\n");
            fw.write(this.player1.getName() + "\n");
            fw.write(this.player1.checkNbRestingFences() + "\n");
            fw.write(this.player2.getName() + "\n");
            fw.write(this.player2.checkNbRestingFences() + "\n");
            if (nbPlayer == 4) {
                fw.write(this.player3.getName() + "\n");
                fw.write(this.player3.checkNbRestingFences() + "\n");
                fw.write(this.player4.getName() + "\n");
                fw.write(this.player4.checkNbRestingFences() + "\n");
            }
            fw.write(playerPlay + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.exit(1);
    }

    /**
     * Return the gui
     *
     * @return the gui
     */
    public boolean getGui() {
        return this.gui;
    }

    /**
     * Return the guiFrame
     *
     * @return the guiFrame
     */
    public Gui getGuiFrame() {
        return this.guiFrame;
    }

    /**
     * Return the actualPlayer
     *
     * @return the actualPlayer
     */
    public int getPlayerPlay() {
        return playerPlay;
    }

    /**
     * Get the player1
     *
     * @return the player1
     */
    public Player getPlayer1() {
        return this.player1;
    }

    /**
     * Get the player2
     *
     * @return the player2
     */
    public Player getPlayer2() {
        return this.player2;
    }

    /**
     * Return the player3
     *
     * @return the player3
     */
    public Player getPlayer3() {
        return this.player3;
    }

    /**
     * Return the player4
     *
     * @return the player4
     */
    public Player getPlayer4() {
        return this.player4;
    }

    /**
     * Return the player number.
     *
     * @return the player number.
     */
    public int getNbPlayer() {
        return this.nbPlayer;
    }
}
