package gui;

import quoridor.Board;
import javax.swing.*;
import java.awt.*;

/**
 * Center panel of the graphical representation. Contains the board and permits the player to play
 * @author Pierre-Galaad 'P(x)' Naquet , Aymeric Bizouarn
 */
public class GridPanel extends JPanel {

  JButton[][] grid;
  Board board;

  public GridPanel(Board board) {
    super(new GridLayout(board.getSIZE(),board.getSIZE()));
    this.board = board;
     grid = new JButton[board.getSIZE()][board.getSIZE()]

    initComponent();
  }

  public void initComponent() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j] = new JButton();
        grid[i][j].setIcon(this.board.getSquare(i,j).getStatusFence().getImage());
        this.add(grid[i][j]);
      }
    }
  }

  public void refresh() {
    initComponent();
  }


}
