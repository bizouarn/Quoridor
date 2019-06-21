package quoridor;

// import project
// import java

/**
 * Class containing the subBoard object.
 * Each subBoard contains four squares and the two possible fences between them.
 * Each square may be in up to four subBoard.
 *
 * @author Pierre-Galaad Naquet, Aymeric Bizouarn
 */
public class SubBoard implements java.io.Serializable {

    private int X;
    private int Y;
    private boolean verticalFence;
    private boolean horizontalFence;
    private Square[] sqrArray = new Square[4];

    /**
     * SubBoard constructor
     * Creates the SubBoard containing the four squares, from them, creates an array,
     * and get coordinates (X, Y) which are the upper left square's one.
     * It also containes the fences status.
     *
     * @author Pierre-Galaad Naquet
     */
    public SubBoard(Square sqr1, Square sqr2, Square sqr3, Square sqr4) {
        if ((sqr1 != null) && (sqr2 != null) && (sqr3 != null) && (sqr4 != null)) {
            this.sqrArray[0] = sqr1;
            this.sqrArray[1] = sqr2;
            this.sqrArray[2] = sqr3;
            this.sqrArray[3] = sqr4;
            this.X = sqr1.getX();
            this.Y = sqr1.getY();
        }
    }

    /**
     * return the SubBoard verticalFence status.
     *
     * @return true if there is a vertical fence in this subBoard (2 units length), false otherwise
     */
    public boolean getVerticalFence() {
        return this.verticalFence;
    }

    /**
     * Set the SubBoard verticalFence.
     *
     * @param bool true if the fence is set, false if it is pulled off .
     */
    public void setVerticalFence(boolean bool) {
        this.verticalFence = bool;
    }

    /**
     * return the SubBoard horizontalFence status.
     *
     * @return true if there is an horizontal fence in this subBoard (2 units length), false otherwise
     */
    public boolean getHorizontalFence() {
        return this.horizontalFence;
    }

    /**
     * Set the SubBoard horizontalFence.
     *
     * @param bool true if the fence is set, false if it is pulled off .
     */
    public void setHorizontalFence(boolean bool) {
        this.horizontalFence = bool;
    }

    /**
     * return the SubBoard's square
     *
     * @return the array of squares contained in the subBoard
     */
    public Square[] getSqrArray() {
        return this.sqrArray;
    }

    /**
     * return the  coordinates
     *
     * @return the  value
     */
    public int getX() {
        return this.X;
    }

    /**
     * return the Y coordinates
     *
     * @return the Y value
     */
    public int getY() {
        return this.Y;
    }
}
