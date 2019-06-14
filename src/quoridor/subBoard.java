package quoridor;

// import project
import quoridor.Square;

// import java

public class subBoard {

  Square sqr1; //upper left
  Square sqr2; //upper right
  Square sqr3; //lower left
  Square sqr4; //lower right

  Square[] sqrArray;

  boolean verticalFence;
  boolean horizontalFence;

  public SubBoard(Square sqr1, Square sqr2, Square sqr3, Square sqr4) {
    if ((sqr1 != null) && (sqr2 != null) && (sqr3 != null) && (sqr4 != null)) {
      this.sqr1 = sqr1;
      this.sqr2 = sqr2;
      this.sqr3 = sqr3;
      this.sqr4 = sqr4;
      this.sqrArray = {sqr1, sqr2, sqr3, sqr4};
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
    return this.sqrArray;
  }
}
