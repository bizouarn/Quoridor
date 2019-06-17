package gui;

import quoridor.Board;
import quoridor.Square;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Center panel of the graphical representation. Contains the board and permits the player to play
 * @author Pierre-Galaad 'P(x)' Naquet , Aymeric Bizouarn
 */
public class GridPanel extends JPanel {

  private JButton[][] grid;
  private Board board;
  private Gui gui;

  private GuiListener guiListener;

  public GridPanel(Board board,Gui gui) {
    super(new GridLayout(board.getSIZE(),board.getSIZE()));
    this.gui = gui;
    this.board = board;
    grid = new JButton[board.getSIZE()][board.getSIZE()];
    this.setPreferredSize(new Dimension(565,565));
    this.setBackground(new Color(128, 142, 159));
    guiListener = new GuiListener(this.gui);
    initComponent();
  }

  public void initComponent() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        Square square = this.board.getSquare(i,j);
        String path = square.getStatus().toString();
        if(path.equals("P1")){
          path = "P1/";
        } else if(path.equals("P2")) {
          path = "P2/";
        } else {
          path = "";
        }
        grid[i][j] = new JButton(new ImageIcon("./data/images/"+path+square.getStatusFence().getImage()));
        grid[i][j].setBorder(null);
        grid[i][j].setBackground(new Color(102, 114, 131));
        grid[i][j].addActionListener(this.guiListener);
        this.add(this.grid[i][j]);
      }
    }
  }

  public void refresh(){
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        Square square = this.board.getSquare(i,j);
        String path = square.getStatus().toString();
        if(path.equals("P1")){
          path = "P1/";
        } else if(path.equals("P2")) {
          path = "P2/";
        } else {
          path = "";
        }
        grid[i][j].setIcon(new ImageIcon("./data/images/"+path+square.getStatusFence().getImage()));
      }
    }
  }

  public JButton[][] getGrid() {
    return grid;
  }

  public GuiListener getGuiListener() {
    return guiListener;
  }
}
