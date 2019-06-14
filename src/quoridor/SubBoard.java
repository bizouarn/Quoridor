package quoridor;

// import project
import quoridor.Square;

// import java

/**
 * Class containing the subBoard object.
 * Each subBoard contains four squares and the two possible fences between them.
 * Each square may be in up to four subBoard.
 * @author Pierre-Galaad 'P(x)' Naquet, Aymeric Bizouarn
 */
public class SubBoard {

  Square SQR1; //upper left
  Square SQR2; //upper right
  Square SQR3; //lower left
  Square SQR4; //lower right

  Square[] sqrArray = new Square[4];

  int X;
  int Y;

  boolean verticalFence;
  boolean horizontalFence;

  /**
   * SubBoard constructor
   * Creates the SubBoard containing the four squares, from them, creates an array,
   * and get coordinates (X, Y) which are the upper left square's one.
   * It also containes the fences status.
   * @author Pierre-Galaad 'P(x)' Naquet
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

  public void setVerticalFence(boolean bool) {
    this.verticalFence = bool;
  }

  public void setHorizontalFence(boolean bool) {
    this.horizontalFence = bool;
  }

  public boolean getVerticalFence() {
    return this.verticalFence;
  }

  public boolean getHorizontalFence() {
    return this.horizontalFence;
  }

  public Square[] getSqrArray() {
    return this.sqrArray;
  }

  public int getX() {
    return this.X;
  }

  public int getY() {
    return this.Y;
  }
}
