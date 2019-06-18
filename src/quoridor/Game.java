package quoridor;

// import project

import gui.Gui;
// import java

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the methods to initialize the game
 *
 * @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
 */
public class Game {

    private Board board;
    private Player player1;
    private Player player2;

    private boolean gui;
    private Gui guiFrame;

    /**
     * Game constructor
     * intiliaze the board, the two players and the mode
     * The mode is choosen by the players with a scanner
     *
     * @author Aymeric Bizouarn
     */
    public Game(boolean gui) {
        this.gui = gui;
        initializeGame();
        if (gui) {
            this.guiFrame = new Gui(this);
        }
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
     * @author Aymeric Bizouarn
     */
    public void initializeGame() {
        this.board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name Player 1 : ");
        String name = scanner.nextLine();
        if (name.contains("auto")) {
            this.player1 = new AutoPlayer(name, this);
        } else {
            this.player1 = new HumanPlayer(name, this);
        }
        System.out.println("Name Player 2 : ");
        name = scanner.nextLine();
        if (name.contains("auto")) {
            this.player2 = new AutoPlayer(name, this);
        } else {
            this.player2 = new HumanPlayer(name, this);
        }
    }

    /**
     * Choose randomly which player plays first
     *
     * @return the starting player
     */
    public Player whoStarts() {
        int random = (int) (Math.random() * 100);
        Player ret;
        if (random <= 50) {
            ret = this.player1;
        } else {
            ret = this.player2;
        }
        return ret;
    }

    /**
     * Launch the game with the attributes as parameters.
     *
     * @author Aymeric Bizouarn
     */
    public void start() {
        Player playerWhoStart = this.whoStarts();
        int playerPlay = 1; //1 = for player1 play & 2 = for player2
        if (playerWhoStart == this.player1) {
            playerPlay = 1;
        } else if (playerWhoStart == this.player2) {
            playerPlay = 2;
        }
        while (!checkEndOfGame()) {
            System.out.println("rec path :"+checkExistingPath());
            this.guiFrame.refresh();
            Player playerActual = null;
            if (playerPlay == 1) {
                playerActual = this.player1;
            } else if (playerPlay == 2) {
                playerActual = this.player2;
            }
            System.out.println(this.board);
            System.out.println(playerActual.getName() + " : ");
            playerActual.play();
            playerPlay++;
            if (playerPlay > 2) {
                playerPlay = 1;
            }
        }
        this.guiFrame.refresh();
    }

    /**
     * Check if the game was finish.
     *
     * @return True if the game was finish.
     * @author Aymeric Bizouarn
     */
    public boolean checkEndOfGame() {
        boolean ret = false;
        if (this.board.getPlayer1Square() != null && this.board.getPlayer2Square() != null) {
            if (this.board.getPlayer1Square().getX() == 8) {
                ret = true;
            } else if (this.board.getPlayer2Square().getX() == 0) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * End the game and launch the results procedure
     *
     * @author Pierre-Galaad 'P(x)' Naquet
     */
    public void endOfGame(Player player) {

        Scanner scan;
        boolean bool = false;

        System.out.println("The player : " + player.getName() + "has won !");
        System.out.println();
        System.out.println("What do you want to do ?");
        System.out.println("1 - Rematch");
        System.out.println("2 - Change Players");
        System.out.println("3 - Leave the program");

        int choice = -1;
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
        }

        if (choice == 1) {
            this.board = new Board();
            this.start();
        }
        if (choice == 2) {
            new Game(this.gui);
        }
        if (choice == 3) {
            System.exit(0);
        }
    }

    public boolean checkExistingPath() {
        ArrayList<int[]> listSquare = new ArrayList<int[]>();
        for(int i = 0; i<9 ;i++){
            for(int j = 0; j<9 ; j++){
                int[] position = {i,j};
                listSquare.add(position);
            }
        }
        boolean resP1 = false;
        resP1 = recExistingPath(this.board.getPlayer1Square(), 1, 0,listSquare);
        boolean resP2 = false;
        resP2 = recExistingPath(this.board.getPlayer2Square(), 2, 0,listSquare);
        if(resP1 || resP2){
            return true;
        }
        boolean ret = false;
        return false;
    }

    public boolean recExistingPath(Square sqr, int player, int i,ArrayList<int[]> listSquare) {
        i++;
        boolean ret = false;
        if (i < 81) {
            listSquare.remove(sqr);
            System.out.println("index of :"+listSquare.indexOf(sqr));
            ArrayList<Square> possibilitiesPawn = this.board.listOfPossibilitiesPawn(sqr);
            if (sqr.getX()==8 && player == 1) {
                ret = true;
            } else if (sqr.getX()==0 && player == 2) {
                ret = true;
            } else {
                for (Square sqrP : possibilitiesPawn) {
                    if(listSquare.indexOf(sqr)!=-1) {
                        System.out.println("=1=");
                        ret = recExistingPath(sqrP, player, i,listSquare);
                    }
                }
            }
            System.out.println("rec i :"+i+" ret : "+ret+" sqr :"+sqr.getX()+","+sqr.getY());
        }
        return ret;
    }

    public boolean getGui() {
        return this.gui;
    }

    public Gui getGuiFrame() {
        return guiFrame;
    }
}
