package gui;

import quoridor.Board;
import javax.swing.*;
import java.awt.*;

/**
 * Center panel of the graphical representation. Contains the board and permits the player to play
 * @author Pierre-Galaad 'P(x)' Naquet , Aymeric Bizouarn
 */
public class GridPanel extends JPanel {

  JPanel[][] grid;
  Board board;

  public GridPanel(Board board) {
    super(new GridLayout(board.getSIZE(),board.getSIZE()));
    this.board = board;
     grid = new JPanel[board.getSIZE()][board.getSIZE()];

    initComponent();
  }

  public void initComponent() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j] = new ImagePanel(this.board, i, j);
        this.add(grid[i][j]);
      }
    }
  }

  public void refresh() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j] = new ImagePanel(this.board, i, j);
      }
  }
}
