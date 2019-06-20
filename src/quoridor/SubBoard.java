package quoridor;

// import project
import quoridor.Square;

// import java

/**
 * Class containing the subBoard object.
 * Each subBoard contains four squares and the two possible fences between them.
 * Each square may be in up to four subBoard.
 * @author Pierre-Galaad Naquet, Aymeric Bizouarn
 */
public class SubBoard implements java.io.Serializable{

  private Square SQR1; //upper left
  private Square SQR2; //upper right
  private Square SQR3; //lower left
  private Square SQR4; //lower right

  private Square[] sqrArray = new Square[4];

  int X;
  int Y;

  boolean verticalFence;
  boolean horizontalFence;

  /**
   * SubBoard constructor
   * Creates the SubBoard containing the four squares, from them, creates an array,
   * and get coordinates (X, Y) which are the upper left square's one.
   * It also containes the fences status.
   * @author Pierre-Galaad Naquet
   */
  public SubBoard(Square sqr1, Square sqr2, Square sqr3, Square sqr4) {
    if ((sqr1 != null) && (sqr2 != null) && (sqr3 != null) && (sqr4 != null)) {
      this.SQR1 = sqr1;
      this.SQR2 = sqr2;
      this.SQR3 = sqr3;
      this.SQR4 = sqr4;
      this.sqrArray[0] = this.SQR1;
      this.sqrArray[1] = this.SQR2;
      this.sqrArray[2] = this.SQR3;
      this.sqrArray[3] = this.SQR4;
      this.X = this.SQR1.getX();
      this.Y = this.SQR1.getY();
    }
  }

  /**
   * Set the SubBoard verticalFence.
   * @param bool true if the fence is set, false if it is pulled off .
   */
  public void setVerticalFence(boolean bool) {
    this.verticalFence = bool;
  }

  /**
   * Set the SubBoard horizontalFence.
   * @param bool true if the fence is set, false if it is pulled off .
   */
  public void setHorizontalFence(boolean bool) {
    this.horizontalFence = bool;
  }

  /**
   * return the SubBoard verticalFence status.
   * @return true if there is a vertical fence in this subBoard (2 units length), false otherwise
   */
  public boolean getVerticalFence() {
    return this.verticalFence;
  }

  /**
   * return the SubBoard horizontalFence status.
   * @return true if there is an horizontal fence in this subBoard (2 units length), false otherwise
   */
  public boolean getHorizontalFence() {
    return this.horizontalFence;
  }

  /**
   * return the SubBoard's square
   * @return the array of squares contained in the subBoard
   */
  public Square[] getSqrArray() {
    return this.sqrArray;
  }

  /**
   * return the  coordinates
   * @return the  value
   */
  public int getX() {
    return this.X;
  }

  /**
   * return the Y coordinates
   * @return the Y value
   */
  public int getY() {
    return this.Y;
  }
}
