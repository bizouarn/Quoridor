package gui;

import quoridor.Board;
import quoridor.Square;
import quoridor.Status;

import javax.swing.*;
import java.awt.*;

/**
 * Main panel of the graphical representation. Contains the board and permits the players to play
 *
 * @author Pierre-Galaad Naquet , Aymeric Bizouarn
 */
public class GridPanel extends JPanel {

    private JButton[][] grid;
    private Board board;
    private Gui gui;

    /**
     * GridPanel constructor
     *
     * @param board game Board
     * @param gui   The main frame
     * @author Aymeric Bizouarn
     */
    public GridPanel(Board board, Gui gui) {
        super(new GridLayout(board.getSIZE(), board.getSIZE()));
        this.gui = gui;
        this.board = board;
        grid = new JButton[board.getSIZE()][board.getSIZE()];
        this.setPreferredSize(new Dimension(565, 565));
        this.setBackground(new Color(128, 142, 159));
        initComponent();
    }

    /**
     * Initialize the components of the JPanel
     *
     * @author Aymeric Bizouarn
     */
    private void initComponent() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Square square = this.board.getSquare(i, j);
                String path;
                if(square.getStatus()!= Status.NONE) {
                    path = square.getStatus() + "/";
                } else {
                    path ="";
                }
                System.out.println("./data/images/" + path + square.getStatusFence().getImage());
                grid[i][j] = new JButton(new ImageIcon("./data/images/" + path + square.getStatusFence().getImage()));
                grid[i][j].setBorder(null);
                grid[i][j].setBackground(new Color(102, 114, 131));
                grid[i][j].addActionListener(this.gui.getGuiListener());
                grid[i][j].addMouseListener(this.gui.getGuiListener());
                this.add(this.grid[i][j]);
            }
        }
    }

    /**
     * Refreshes the representation of the board
     *
     * @author Aymeric Bizouarn
     */
    public void refresh() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Square square = this.board.getSquare(i, j);
                String path = square.getStatus().toString();
                if(square.getStatus()!= Status.NONE) {
                    path = square.getStatus() + "/";
                } else {
                    path ="";
                }
                grid[i][j].setIcon(new ImageIcon("./data/images/" + path + square.getStatusFence().getImage()));
            }
        }
    }

    /**
     * Return all the JButtons of the the grid
     *
     * @return the array of array of JButtons
     */
    public JButton[][] getGrid() {
        return grid;
    }
}
