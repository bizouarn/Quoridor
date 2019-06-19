package quoridor;

// import project

import gui.Gui;
import gui.PopUpEndOfGame;
import gui.PopUpInputPlayer;
import utilitary.RWFile;
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

    private Player playerActual;

    private boolean gui;
    private Gui guiFrame;

    /**
     * Game constructor
     * Launch either a swing game or a terminal one
     * @param gui true if the game has to be launched in the swing version, false otherwise
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
     * @return the current board
     */
    public Board getBoard() {
        return this.board;
    }

    /**
     * Get the player1
     * @return the player1
     */
    public Player getPlayer1() {
        return this.player1;
    }

    /**
     * Get the player2
     * @return the player2
     */
    public Player getPlayer2() {
        return this.player2;
    }

    /**
     * Set the Game Board.
     * @param board the desired board to play the game with.
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Initialize the game by creating a new board and by asking for players name.
     * @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
     */
    public void initializeGame() {
        String name1;
        String name2;
        if (this.gui == true) {
          name1 = PopUpInputPlayer.popUpPlayer1();
          name2 = PopUpInputPlayer.popUpPlayer2();
        }
        else {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Name Player 1 : ");
          name1 = scanner.nextLine();
          System.out.println("Name Player 2 : ");
          name2 = scanner.nextLine();
        }

        if (name1.equals("auto")) {
            this.player1 = new AutoPlayer(name1, this);
        } else {
            this.player1 = new HumanPlayer(name1, this);
        }

        if (name2.equals("auto")) {
            this.player2 = new AutoPlayer(name2, this);
        } else {
            this.player2 = new HumanPlayer(name2, this);
        }

        this.board = new Board();
    }

    /**
     * Choose randomly which player plays first
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
     * Launch the game and select the starting player with the attributes as parameters.
     * @author Aymeric Bizouarn
     */
    public void start() {
        int playerPlay = 1; //1 = for player1 play & 2 = for player2
        if (playerWhoStart == this.player1) {
            playerPlay = 1;
        } else if (playerWhoStart == this.player2) {
            playerPlay = 2;
        }
        this.playerActual = null;
        while (!checkEndOfGame()) {
            checkExistingPath();
            if (this.gui == true) {
                this.guiFrame.refresh();
            }
            if (playerPlay == 1) {
                this.playerActual = this.player1;
            } else if (playerPlay == 2) {
                this.playerActual = this.player2;
            }
            System.out.println(this.board);
            System.out.println(this.playerActual.getName() + " : ");
            this.playerActual.play();
            playerPlay++;
            if (playerPlay > 2) {
                playerPlay = 1;
            }
        }
        endOfGame(playerActual);
    }

    /**
     * Launch the game with the attributes as parameters and gives the hand to the currentplayer.
     * @author Pierre-Galaad 'P(x)' Naquet
     */
    public void startLoaded() {
      int playerPlay = 0;
      if (this.playerActual == this.player1) {
        playerPlay = 1;
      }
      if (this.playerActual == this.player2) {
        playerPlay = 2;
      }
      while (!checkEndOfGame()) {
          checkExistingPath();
          if (this.gui == true) {
              this.guiFrame.refresh();
          }
          if (playerPlay == 1) {
              this.playerActual = this.player1;
          } else if (playerPlay == 2) {
              this.playerActual = this.player2;
          }
          System.out.println(this.board);
          System.out.println(this.playerActual.getName() + " : ");
          this.playerActual.play();
          playerPlay++;
          if (playerPlay > 2) {
              playerPlay = 1;
          }
      }
      endOfGame(playerActual);
    }

    /**
     * Check if the game has ended
     * @return True if the game has ended, false otherwise
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

    /**
     * Checks if there is an existing path between the end and the player
     * @return True if a path exists, false otherwise
     * @author Aymeric Bizouarn
     */
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

    /**
     * Recursive methods checking the existing path.
     * @param sqr the current square
     * @param player the current player
     * @param listSquareTmp the current list of the path
     * @return True if there is an existing path, false otherwise
     * @author Aymeric Bizouarn
     */
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

    /**
     * get the path with the fewest tiles to the opposite side of the board
     * @param sqr the current square
     * @param player the current player
     * @return the number of tiles until the opposite sude of the board
     * @author Aymeric Bizouarn
     */
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

    /**
     * get the path with the fewest tiles to the opposite side of the board
     * @param sqr the current square
     * @param player the current player
     * @param listSquare
     * @param nbMove
     * @param deepMove
     * @author Aymeric Bizouarn
     */
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

    /**
     * Return the gui
     * @return the gui
     */
    public boolean getGui() {
        return this.gui;
    }

    /**
     * Return the guiFrame
     * @return the guiFrame
     */
    public Gui getGuiFrame() {
        return this.guiFrame;
    }

    /**
     * Return the actualPlayer
     * @return the actualPlayer
     */
    public Player getPlayerActual() {
      return this.playerActual;
    }

    /**
     * Save the current Game
     * @author Pierre-Galaad 'P(x)' Naquet
     */
     public void saveGame() {
       RWFile.writeFile("./data/save/SavedGame.bin", this);
     }
}
