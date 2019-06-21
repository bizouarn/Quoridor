package quoridor;

/**
 * Tile of the board. Contains its coordinates, if there is a player on it, and the fences around it.
 *
 * @author Pierre-Galaad Naquet, Aymeric Bizouarn
 */
public class Square implements java.io.Serializable {

    /**
     * coordinate x
     */
    private int x;
    /**
     * coordinate y
     */
    private int y;

    /**
     * Status of the square. If it contains player 1 / player 2 or none
     */
    private Status status;

    /**
     * Fence status. Gets it from from the enumeration StatusFence
     */
    private StatusFence statusFence; //

    /**
     * true if there is a fence, false otherwise
     */
    private boolean fenceN;
    /**
     * true if there is a fence, false otherwise
     */
    private boolean fenceE;
    /**
     * true if there is a fence, false otherwise
     */
    private boolean fenceS;
    /**
     * true if there is a fence, false otherwise
     */
    private boolean fenceW;


    /**
     * Square constructor
     * Square object which is a square on the board.
     * It knows its coordinates, if there is a player or not and if their is fences around him
     *
     * @author Pierre-Galaad Naquet
     */
    public Square(int x, int y) {
        this.x = x;
        this.y = y;

        this.fenceN = false;
        this.fenceS = false;
        this.fenceW = false;
        this.fenceE = false;

        if (x == 0) {
            this.fenceN = true;
        }
        if (x == 8) {
            this.fenceS = true;
        }
        if (y == 0) {
            this.fenceW = true;
        }
        if (y == 8) {
            this.fenceE = true;
        }
    }

    /**
     * refreshes the fence status
     *
     * @author Pierre-Galaad Naquet
     */
    public void refreshStatusFence() {
        if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == false)) {
            this.statusFence = StatusFence.NONE;
        } else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == false)) {
            this.statusFence = StatusFence.N;
        } else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == true)) {
            this.statusFence = StatusFence.NE;
        } else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == false)) {
            this.statusFence = StatusFence.NS;
        } else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == false)) {
            this.statusFence = StatusFence.NW;
        } else if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == true)) {
            this.statusFence = StatusFence.E;
        } else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == true)) {
            this.statusFence = StatusFence.ES;
        } else if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == true)) {
            this.statusFence = StatusFence.EW;
        } else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == false)) {
            this.statusFence = StatusFence.S;
        } else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == false)) {
            this.statusFence = StatusFence.SW;
        } else if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == false)) {
            this.statusFence = StatusFence.W;
        } else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == true)) {
            this.statusFence = StatusFence.NES;
        } else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == false)) {
            this.statusFence = StatusFence.NSW;
        } else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == true)) {
            this.statusFence = StatusFence.ESW;
        } else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == true)) {
            this.statusFence = StatusFence.NEW;
        } else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == true)) {
            this.statusFence = StatusFence.NESW;
        }
    }

    /**
     * Get the status fence of the square
     *
     * @return statusFence of the square.
     */
    public StatusFence getStatusFence() {
        return this.statusFence;
    }

    /**
     * Get the status of the square
     *
     * @return status of the square.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Set the square status.
     *
     * @param status the new status of the square.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get the coordinates x of the square on the board
     *
     * @return the coordinate x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Get the coordinates y of the square on the board
     *
     * @return the coordinate y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Get the status of the north fence of the square
     *
     * @return The square's north fence status.
     */
    public boolean getFenceN() {
        return this.fenceN;
    }

    /**
     * Set the square North fence.
     *
     * @param fenceN Boolean, true if there is a fence, false otherwise.
     */
    public void setFenceN(boolean fenceN) {
        this.fenceN = fenceN;
    }

    /**
     * Get the status of the eastern fence of the square
     *
     * @return The square's eastern fence status.
     */
    public boolean getFenceE() {
        return this.fenceE;
    }

    /**
     * Set the square East fence.
     *
     * @param fenceE Boolean, true if there is a fence, false otherwise.
     */
    public void setFenceE(boolean fenceE) {
        this.fenceE = fenceE;
    }

    /**
     * Get the status of the southern fence of the square
     *
     * @return The square's southern fence status.
     */
    public boolean getFenceS() {
        return this.fenceS;
    }

    /**
     * Set the square South fence.
     *
     * @param fenceS Boolean, true if there is a fence, false otherwise.
     */
    public void setFenceS(boolean fenceS) {
        this.fenceS = fenceS;
    }

    /**
     * Get the status of the western fence of the square
     *
     * @return The square's west fence status.
     */
    public boolean getFenceW() {
        return this.fenceW;
    }

    /**
     * Set the square West fence.
     *
     * @param fenceW Boolean, true if there is a fence, false otherwise.
     */
    public void setFenceW(boolean fenceW) {
        this.fenceW = fenceW;
    }

    /**
     * @return the String containing the data about the square.
     */
    public String toString() {
        String ret = this.statusFence.toString();
        if ((this.status == Status.Player1) || (this.status == Status.Player2)) {
            ret += "Player";
        }
        return ret;
    }
}
