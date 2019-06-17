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
    this.Board = board;

    initComponent();
  }

  public void initComponent() {

    getContentPane().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    getContentPane().setLayout(new gridLayout(9,9));
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        grid[i][j] = new JButton();
      }
    }
  }

}
