package quoridor;

import java.util.ArrayList;
import quoridor.TerminalPrinting;

/**
 * Class for the initializing of the board.
 * Contains the grid and calls the GUI package to show the game
 *
 * @author Pierre-Galaad Naquet, Aymeric Bizouarn
 */
public class Board implements java.io.Serializable {

    /**
     * Size of the side of the square
     */
    private final int SIZE = 9;

    /**
     * The aggregation of squares
     */
    private ArrayList<Square> grid;
    /**
     * The aggregation of subBoard
     */
    private ArrayList<SubBoard> subBoards = new ArrayList<>();
    /**
     *  Number of player in the game
     */
    private int nbPlayer;

    /**
     * Board constructor
     * initialize a 81 squares board (9*9)
     * Initialize walls and position his players on their starting positions
     *
     * @author Pierre-Galaad Naquet
     */
    public Board(int nbPlayer) {
        this.nbPlayer = nbPlayer;
        initializeBoard();
        initializePlayers();
        initializeSubBoards();
    }

    public Square getSquare(int x, int y) {
        Square ret = null;
        for (Square sqr : this.grid) {
            if ((sqr.getX() == x) && (sqr.getY() == y)) {
                ret = sqr;
            }
        }
        return ret;
    }

    public int getSIZE() {
        return this.SIZE;
    }

    public ArrayList<Square> getGrid() {
        return this.grid;
    }

    public Square getPlayer1Square() {
        Square ret = null;
        for (Square sqr : this.grid) {
            if (sqr.getStatus() == Status.Player1) {
                ret = sqr;
            }
        }
        return ret;
    }

    public Square getPlayer2Square() {
        Square ret = null;
        for (Square sqr : this.grid) {
            if (sqr.getStatus() == Status.Player2) {
                ret = sqr;
            }
        }
        return ret;
    }

    public Square getPlayer3Square() {
        Square ret = null;
        for (Square sqr : this.grid) {
            if (sqr.getStatus() == Status.Player3) {
                ret = sqr;
            }
        }
        return ret;
    }

    public Square getPlayer4Square() {
        Square ret = null;
        for (Square sqr : this.grid) {
            if (sqr.getStatus() == Status.Player4) {
                ret = sqr;
            }
        }
        return ret;
    }

    public SubBoard getSubBoard(int x, int y) {
        SubBoard ret = null;
        for (SubBoard subBoard : this.subBoards) {
            if ((subBoard.getX() == x) && (subBoard.getY() == y)) {
                ret = subBoard;
            }
        }
        return ret;
    }

    /**
     * Board Initializer
     * intiliaze a 81 squares board (9*9)
     * Initialize walls and statuses
     *
     * @author Pierre-Galaad Naquet
     */
    private void initializeBoard() {
        this.grid = new ArrayList<>();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                Square sqr = new Square(x, y);
                sqr.setStatus(Status.NONE);
                this.grid.add(sqr);
            }
        }
        for (Square sqr : grid) {
            sqr.refreshStatusFence();
        }
    }

    /**
     * SubBoards Initializer
     * intiliaze every subBoard of the board
     *
     * @author Pierre-Galaad Naquet
     */
    public void initializeSubBoards() {
        Square[] sqrArray = new Square[4];
        Square sqr1;
        Square sqr2;
        Square sqr3;
        Square sqr4;
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                sqr1 = this.getSquare(x, y);
                sqr2 = this.getSquare(x, y + 1);
                sqr3 = this.getSquare(x + 1, y);
                sqr4 = this.getSquare(x + 1, y + 1);
                sqrArray[0] = sqr1;
                sqrArray[1] = sqr2;
                sqrArray[2] = sqr3;
                sqrArray[3] = sqr4;
                this.subBoards.add(new SubBoard(sqr1, sqr2, sqr3, sqr4));
            }
        }
    }

    /**
     * Board Initializer
     * Initialize players' pawns on the Board
     *
     * @author Pierre-Galaad Naquet
     */
    private void initializePlayers() {
        for (Square sqr : this.grid) {
            if ((sqr.getX() == 0) && (sqr.getY() == 4)) {
                sqr.setStatus(Status.Player1);
            }
            if ((sqr.getX() == 8) && (sqr.getY() == 4)) {
                sqr.setStatus(Status.Player2);
            }
            if (nbPlayer == 4) {
                if ((sqr.getX() == 4) && (sqr.getY() == 0)) {
                    sqr.setStatus(Status.Player3);
                }
                if ((sqr.getX() == 4) && (sqr.getY() == 8)) {
                    sqr.setStatus(Status.Player4);
                }
            }
        }
    }


    /**
     * Find and return all the SubBoards containing a playable vertical fence this turn.
     *
     * @return The arayList containing SubBoards
     * @author Pierre-Galaad Naquet
     */
    public ArrayList<SubBoard> listOfPossibilitiesFenceVertical() {
        ArrayList<SubBoard> ret = new ArrayList<SubBoard>();
        boolean bool;
        for (SubBoard subBoard : subBoards) {
            bool = true;
            if (subBoard.getHorizontalFence() || subBoard.getVerticalFence()) {
                bool = false;
            }
            if (getSubBoard(subBoard.getX() + 1, subBoard.getY()) != null) {
                if (getSubBoard(subBoard.getX() + 1, subBoard.getY()).getVerticalFence()) {
                    bool = false;
                }
            }
            if (getSubBoard(subBoard.getX() - 1, subBoard.getY()) != null) {
                if (getSubBoard(subBoard.getX() - 1, subBoard.getY()).getVerticalFence()) {
                    bool = false;
                }
            }
            if (bool) {
                ret.add(subBoard);
            }
        }
        return ret;
    }

    /**
     * Find and return all the SubBoards containing a playable horizontal fence this turn.
     *
     * @return The arayList containing SubBoards
     * @author Pierre-Galaad Naquet
     */
    public ArrayList<SubBoard> listOfPossibilitiesFenceHorizontal() {
        ArrayList<SubBoard> ret = new ArrayList<SubBoard>();
        boolean bool;
        for (SubBoard subBoard : subBoards) {
            bool = true;
            if (subBoard.getHorizontalFence() || subBoard.getVerticalFence()) {
                bool = false;
            }
            if (getSubBoard(subBoard.getX(), subBoard.getY() + 1) != null) {
                if (getSubBoard(subBoard.getX(), subBoard.getY() + 1).getHorizontalFence()) {
                    bool = false;
                }
            }
            if (getSubBoard(subBoard.getX(), subBoard.getY() - 1) != null) {
                if (getSubBoard(subBoard.getX(), subBoard.getY() - 1).getHorizontalFence()) {
                    bool = false;
                }
            }
            if (bool) {
                ret.add(subBoard);
            }
        }
        return ret;
    }

    /**
     * When called return an array list of square containing all of pawns deplacement possibilities.
     *
     * @param player current turn player
     * @param game   current game played
     * @return The ArrayList containing all the possibilities
     * @author Pierre-Galaad Naquet, Aymeric Bizouarn
     */
    public ArrayList<Square> listOfPossibilitiesPawn(Player player, Game game) {
        Square currSqr = null;
        ArrayList<Square> ret;
        if (player == game.getPlayer1()) {
            currSqr = getPlayer1Square();
        } else if (player == game.getPlayer2()) {
            currSqr = getPlayer2Square();
        } else if (nbPlayer == 4) {
            if (player == game.getPlayer3()) {
                currSqr = getPlayer3Square();
            } else if (player == game.getPlayer4()) {
                currSqr = getPlayer4Square();
            }
        }
        ret = listOfPossibilitiesPawn(currSqr);
        return ret;
    }

    public ArrayList<Square> listOfPossibilitiesPawn(Square currSqr) {
        ArrayList<Square> ret = new ArrayList<Square>();
        if (currSqr != null) {
            if (!currSqr.getFenceN()) {
                Square currSqr2 = this.getSquare(currSqr.getX() - 1, currSqr.getY());
                if (currSqr2 == null) {
                    ret.add(this.getSquare(currSqr.getX() - 1, currSqr.getY()));
                } else if (currSqr2.getStatus() != Status.NONE) {
                    if (currSqr2.getFenceN()) {
                        if (!currSqr2.getFenceW()) {
                            ret.add(this.getSquare(currSqr.getX() - 1, currSqr.getY() - 1));
                        }
                        if (!currSqr2.getFenceE()) {
                            ret.add(this.getSquare(currSqr.getX() - 1, currSqr.getY() + 1));
                        }
                    } else {
                        ret.add(this.getSquare(currSqr.getX() - 2, currSqr.getY()));
                    }
                } else {
                    ret.add(this.getSquare(currSqr.getX() - 1, currSqr.getY()));
                }
            }
            if (!currSqr.getFenceS()) {
                Square currSqr2 = this.getSquare(currSqr.getX() + 1, currSqr.getY());
                if (currSqr2 == null) {
                    ret.add(this.getSquare(currSqr.getX() + 1, currSqr.getY()));
                } else if (currSqr2.getStatus() != Status.NONE) {
                    if (currSqr2.getFenceS()) {
                        if (!currSqr2.getFenceW()) {
                            ret.add(this.getSquare(currSqr.getX() + 1, currSqr.getY() - 1));
                        }
                        if (!currSqr2.getFenceE()) {
                            ret.add(this.getSquare(currSqr.getX() + 1, currSqr.getY() + 1));
                        }
                    } else {
                        ret.add(this.getSquare(currSqr.getX() + 2, currSqr.getY()));
                    }
                } else {
                    ret.add(this.getSquare(currSqr.getX() + 1, currSqr.getY()));
                }
            }
            if (!currSqr.getFenceE()) {
                Square currSqr2 = this.getSquare(currSqr.getX(), currSqr.getY() + 1);
                if (currSqr2 == null) {
                    ret.add(this.getSquare(currSqr.getX(), currSqr.getY() + 1));
                } else if (currSqr2.getStatus() != Status.NONE) {
                    if (currSqr2.getFenceE()) {
                        if (!currSqr2.getFenceN()) {
                            ret.add(this.getSquare(currSqr.getX() - 1, currSqr.getY() + 1));
                        }
                        if (!currSqr2.getFenceS()) {
                            ret.add(this.getSquare(currSqr.getX() + 1, currSqr.getY() + 1));
                        }
                    } else {
                        ret.add(this.getSquare(currSqr.getX(), currSqr.getY() + 2));
                    }
                } else {
                    ret.add(this.getSquare(currSqr.getX(), currSqr.getY() + 1));
                }
            }
            if (!currSqr.getFenceW()) {
                Square currSqr2 = this.getSquare(currSqr.getX(), currSqr.getY() - 1);
                if (currSqr2 == null) {
                    ret.add(this.getSquare(currSqr.getX(), currSqr.getY() - 1));
                } else if (currSqr2.getStatus() != Status.NONE) {
                    if (currSqr2.getFenceW()) {
                        if (!currSqr2.getFenceN()) {
                            ret.add(this.getSquare(currSqr.getX() - 1, currSqr.getY() - 1));
                        }
                        if (!currSqr2.getFenceS()) {
                            ret.add(this.getSquare(currSqr.getX() + 1, currSqr.getY() - 1));
                        }
                    } else {
                        ret.add(this.getSquare(currSqr.getX(), currSqr.getY() - 2));
                    }
                } else {
                    ret.add(this.getSquare(currSqr.getX(), currSqr.getY() - 1));
                }
            }
        }
        return ret;
    }

    public String toString() {
        String str = TerminalPrinting.printBoard(this);
        return str;
    }

}
