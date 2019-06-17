package gui;

import quoridor.Board;
import javax.swing.*;
import java.awt.*;

/**
 * Center panel of the graphical representation. Contains the board and permits the player to play
 * @author Pierre-Galaad 'P(x)' Naquet , Aymeric Bizouarn
 */
public class GridPanel extends JPanel {

  JButton[][] grid = new JButton[9][9];
  Board board;

  public GridPanel(Board board) {
    super(new GridLayout(9,9));
    this.board = board;

    initComponent();
  }

  public void initComponent() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j] = new JButton();
        this.add(grid[i][j]);
      }
    }
  }

}
