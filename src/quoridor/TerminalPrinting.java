package quoridor;

import java.util.ArrayList;

public class TerminalPrinting {

  private Board board;

  public TerminalPrinting(Board board) {
    this.board = board;
  }

  private String printBoard(Board board) {

    TerminalPrinting(board);

    String ret = "";
    String layer1 = "";
    String layer2 = "";
    String layer3 = "";

    for (int row = 0; row < this.board.getSIZE(); row++) {
      for (int col = 0; col < this.board.getSIZE(); col++) {
        if (this.board.getSquare(row, col).getFenceN() == true) {
          layer1 = layer1 + "  ##  ";
        }
        else {
          layer1 = layer1 + "  --  "
        }
        if (this.board.getSquare(row, col).getFenceW() == true) {
          layer2 = layer2 + " |";
        }
        else {
          layer2 = layer2 + " :";
        }

        layer2 = layer2 + this.board.getSquare(row, col).getStatus().toString();

        if (this.board.getSquare(row, col).getFenceE() == true) {
          layer2 = layer2 + "| ";
        }
        else {
          layer2 = layer2 + ": ";
        }
        if (this.board.getSquare(row, col).getFenceS() == true) {
          layer3 = layer3 + "  ##  ";
        }
        else {
          layer3 = layer3 + "  --  ";
        }
      }
      ret = ret + layer1+"\n" + layer2+"\n" + layer3+"\n"
    }
    return ret;
  }

}
