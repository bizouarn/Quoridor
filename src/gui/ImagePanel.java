package gui;

import quoridor.Board;
import sun.java2d.pipe.DrawImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {

  private Board board;
  private int x;
  private int y;
  private ImageIcon image;
  private JButton button;


  public ImagePanel(Board board, int x, int y) {
    super();
    this.board = board;
    this.x = x;
    this.y = y;
    this.button = new JButton();
    this.image = this.board.getSquare(x,y).getStatusFence().getImage();

    JLabel imageL = new JLabel(image);

    this.add(imageL);
    this.add(this.button);
  }

}
