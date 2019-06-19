package quoridor;

// import project

import gui.Gui;
import gui.PopUpEndOfGame;
// import java

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Player playerWhoStart;

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
        String name1;
        String name2;
        if (this.gui == true) {
          name1 = popUpEndInputPlayer1();
          name2 = popUpEndInputPlayer2();
        }
        else {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Name Player 1 : ");
          String name1 = scanner.nextLine();
          System.out.println("Name Player 2 : ");
          String name2 = scanner.nextLine();
        }

        if (name1 == "auto") {
            this.player1 = new AutoPlayer(name1, this);
        } else {
            this.player1 = new HumanPlayer(name1, this);
        }

        if (name2 == "auto") {
            this.player2 = new AutoPlayer(name2, this);
        } else {
            this.player2 = new HumanPlayer(name2, this);
        }
        
        this.board = new Board();
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
        this.playerWhoStart = this.whoStarts();
        return ret;
    }

    /**
     * Launch the game with the attributes as parameters.
     *
     * @author Aymeric Bizouarn
     */
    public void start() {
        int playerPlay = 1; //1 = for player1 play & 2 = for player2
        if (playerWhoStart == this.player1) {
            playerPlay = 1;
        } else if (playerWhoStart == this.player2) {
            playerPlay = 2;
        }
        Player playerActual = null;
        while (!checkEndOfGame()) {
            checkExistingPath();
            if (this.gui == true) {
                this.guiFrame.refresh();
            }
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
        endOfGame(playerActual);
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

        int choice = -1;
        if(this.gui = true) {
            choice = PopUpEndOfGame.popUpEndOfGame();
        } else {
            System.out.println("The player : " + player.getName() + "has won !");
            System.out.println();
            System.out.println("What do you want to do ?");
            System.out.println("1 - Rematch");
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
            }
        }

        if (choice == 1) {
            this.board = new Board();
            this.start();
        }
        if (choice == 2) {
            Game game = new Game(this.gui);
            game.start();
        }
        if (choice == 3) {
            System.exit(0);
        }
    }

    public boolean checkExistingPath() {
        boolean ret = false;
        ArrayList<String> listSquare = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                listSquare.add(i + "," + j);
            }
        }
        boolean resP1 = recExistingPath(this.board.getPlayer1Square(),2,listSquare);
        listSquare = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                listSquare.add(i + "," + j);
            }
        }
        boolean resP2 = recExistingPath(this.board.getPlayer2Square(), 2,listSquare);
        if (resP1 && resP2) {
            ret = true;
        }
        return ret;
    }

    public boolean recExistingPath(Square sqr, int player, ArrayList<String> listSquareTmp) {
        boolean ret = false;
        ArrayList<String> listSquare = listSquareTmp;
        listSquare.remove(sqr.getX() + "," + sqr.getY());
        ArrayList<Square> possibilitiesPawn = this.board.listOfPossibilitiesPawn(sqr);
        if (sqr.getX() == 8 && player == 1) {
            ret = true;
        } else if (sqr.getX() == 0 && player == 2) {
            ret = true;
        } else {
            for (Square sqrP : possibilitiesPawn) {
                if (sqrP != null) {
                    if (ret == false) {
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

    public int getNbMinMove(Square sqr, int player) {
        ArrayList<Integer> nbMove = new ArrayList<>();
        ArrayList<String> listSquare = new ArrayList<>();
        recNbMinMove(sqr, player, listSquare, nbMove, 1);
        int ret = 82;
        for (Integer val : nbMove) {
            if (val < ret) {
                ret = val;
            }
        }
        return ret;
    }

    private void recNbMinMove(Square sqr, int player, ArrayList<String> listSquare, ArrayList<Integer> nbMove, int deepMove) {
        ArrayList<String> listSquareTmp = new ArrayList<>(listSquare);
        ArrayList<Square> possibilitiesPawn = this.board.listOfPossibilitiesPawn(sqr);
        if (sqr.getX() == 8 && player == 1) {
            nbMove.add(deepMove);
        } else if (sqr.getX() == 0 && player == 2) {
            nbMove.add(deepMove);
        } else {
            int max = 82;
            for (Square sqrP : possibilitiesPawn) {
                String value = sqrP.getX() + "," + sqrP.getY();
                int min = 82;
                for (Integer val : nbMove) {
                    if (val < min) {
                        min = val;
                    }
                }
                if (listSquareTmp.indexOf(value) == -1 && deepMove < min) {
                    listSquareTmp.add(value);
                    recNbMinMove(sqrP, player, listSquareTmp, nbMove, deepMove + 1);
                }
            }
        }
    }

    public boolean getGui() {
        return this.gui;
    }

    public Gui getGuiFrame() {
        return guiFrame;
    }
}
