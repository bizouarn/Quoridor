package gui;

import quoridor.Board;
import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

  private Board board;
  private int x;
  private int y;
  private ImageIcon image;


  public ImagePanel(Board board, int x, int y) {
    this.board = board;
    this.x = x;
    this.y = y;

    this.image = this.board.getSquare(i,j).getStatusFence().getImage();

    this.add(image);
  }

}
