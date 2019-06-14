package quoridor;

// import project
import quoridor.Square;

// import java

/**
 *
 */
public class SubBoard {

  final Square SQR1; //upper left
  final Square SQR2; //upper right
  final Square SQR3; //lower left
  final Square SQR4; //lower right

  final Square[] SQRARRAY;

  final int X;
  final int Y;

  boolean verticalFence;
  boolean horizontalFence;

  public SubBoard(Square sqr1, Square sqr2, Square sqr3, Square sqr4) {
    if ((sqr1 != null) && (sqr2 != null) && (sqr3 != null) && (sqr4 != null)) {
      this.SQR1 = sqr1;
      this.SQR2 = sqr2;
      this.SQR3 = sqr3;
      this.SQR4 = sqr4;
      this.SQRARRAY = {sqr1, sqr2, sqr3, sqr4};
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

  public boolean getVerticalFence(boolean bool) {
    return this.verticalFence;
  }

  public boolean getHorizontalFence(boolean bool) {
    return this.horizontalFence;
  }

  public Square[] getSqrArray() {
    return this.SQRARRAY;
  }

  public int getX() {
    return this.X;
  }

  public int getY() {
    return this.Y;
  }
}