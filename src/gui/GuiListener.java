package gui;

import quoridor.Square;
import quoridor.SubBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Listener for the game Frame (Gui)
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class GuiListener implements ActionListener, MouseListener, java.io.Serializable {
    private boolean value = false;
    private boolean fence = false;
    private boolean horizontal = false;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Gui gui;

    /**
     * GuiListener constructor
     *
     * @author Aymeric Bizouarn
     */
    public GuiListener(Gui gui) {
        this.gui = gui;
    }

    /**
     * Get the action event and modify the gui / game in consequence
     *
     * @param e The action event on the JFrame Gui
     * @author Aymeric Bizouarn
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.gui.getToolBar().getPawn()) {
            this.fence = false;
            this.gui.getToolBar().getPawn().setEnabled(false);
            this.gui.getToolBar().getFence().setEnabled(true);
            this.gui.getToolBar().getDirection().setVisible(false);
        }
        if (e.getSource() == this.gui.getToolBar().getDirection()) {
            if (this.horizontal) {
                this.horizontal = false;
                this.gui.getToolBar().getDirection().setText("Direction : \u2014");
            } else {
                this.horizontal = true;
                this.gui.getToolBar().getDirection().setText("Direction : |");
            }
        }
        if (e.getSource() == this.gui.getToolBar().getFence()) {
            this.fence = true;
            this.gui.getToolBar().getPawn().setEnabled(true);
            this.gui.getToolBar().getFence().setEnabled(false);
            this.gui.getToolBar().getDirection().setVisible(true);
        }

        if (e.getSource() == this.gui.getToolBar().getSave()) {
            this.gui.getGame().saveGame();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (e.getSource() == this.gui.getGridPanel().getGrid()[i][j]) {
                    this.x1 = i;
                    this.x2 = i + 1;
                    this.y1 = j;
                    this.y2 = j + 1;
                    this.value = true;
                }
            }
        }
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        Color green = new Color(12, 99, 34);
        Color red = new Color(255, 53, 34);
        JButton button = (JButton) e.getSource();
        if (this.fence) {
            int x = -1;
            int y = -1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (gui.getGridPanel().getGrid()[i][j] == button) {
                        x = i;
                        y = j;
                    }
                }
            }
            if (x != -1 && y != -1) {
                if (this.horizontal) {
                    ArrayList<SubBoard> subBoards = gui.getGame().getBoard().listOfPossibilitiesFenceVertical();
                    Color color = red;
                    for (SubBoard sb : subBoards) {
                        if (sb.getX() == x && sb.getY() == y) {
                            color = green;
                        }
                    }
                    gui.getGridPanel().getGrid()[x][y].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, color));
                    gui.getGridPanel().getGrid()[x][y + 1].setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, color));
                    gui.getGridPanel().getGrid()[x + 1][y].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, color));
                    gui.getGridPanel().getGrid()[x + 1][y + 1].setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, color));
                } else {
                    ArrayList<SubBoard> subBoards = gui.getGame().getBoard().listOfPossibilitiesFenceHorizontal();
                    Color color = red;
                    for (SubBoard sb : subBoards) {
                        if (sb.getX() == x && sb.getY() == y) {
                            color = green;
                        }
                    }
                    gui.getGridPanel().getGrid()[x][y].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, color));
                    gui.getGridPanel().getGrid()[x][y + 1].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, color));
                    gui.getGridPanel().getGrid()[x + 1][y].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, color));
                    gui.getGridPanel().getGrid()[x + 1][y + 1].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, color));
                }
            }
        } else {
            int x = -1;
            int y = -1;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (gui.getGridPanel().getGrid()[i][j] == button) {
                        x = i;
                        y = j;
                    }
                }
            }
            ArrayList<Square> squares = new ArrayList<>();
            if (gui.getGame().getPlayerPlay() == 1) {
                squares = gui.getGame().getBoard().listOfPossibilitiesPawn(gui.getGame().getPlayer1(), gui.getGame());
            } else if (gui.getGame().getPlayerPlay() == 2) {
                squares = gui.getGame().getBoard().listOfPossibilitiesPawn(gui.getGame().getPlayer2(), gui.getGame());
            } else if (gui.getGame().getPlayerPlay() == 3) {
                squares = gui.getGame().getBoard().listOfPossibilitiesPawn(gui.getGame().getPlayer4(), gui.getGame());
            } else if (gui.getGame().getPlayerPlay() == 4) {
                squares = gui.getGame().getBoard().listOfPossibilitiesPawn(gui.getGame().getPlayer4(), gui.getGame());
            }
            Color color = red;
            for (Square sqr : squares) {
                if (sqr.getX() == x && sqr.getY() == y) {
                    color = green;
                }
            }
            button.setBorder(BorderFactory.createLineBorder(color, 3, true));
        }
    }

    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (this.fence) {
            int x = -1;
            int y = -1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (gui.getGridPanel().getGrid()[i][j] == button) {
                        x = i;
                        y = j;
                    }
                }
                if (x != -1 && y != -1) {
                    gui.getGridPanel().getGrid()[x][y].setBorder(null);
                    gui.getGridPanel().getGrid()[x][y + 1].setBorder(null);
                    gui.getGridPanel().getGrid()[x + 1][y].setBorder(null);
                    gui.getGridPanel().getGrid()[x + 1][y + 1].setBorder(null);
                }
            }
        } else {
            button.setBorder(null);
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    /**
     * return the x1
     *
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * return the x2
     *
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * return the y1
     *
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * return the y2
     *
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * return the value
     *
     * @return the value
     */
    public boolean getValue() {
        return this.value;
    }

    /**
     * set the value (boolean)
     *
     * @param value the desired value
     */
    public void setValue(boolean value) {
        this.value = value;
    }

    /**
     * return fence
     *
     * @return true if there is a a fence, false otherwise
     */
    public boolean getFence() {
        return this.fence;
    }

    /**
     * return the fence status, used in AutoPlayer only
     *
     * @return true if there is an horizontal fence, false otherwise
     */
    public boolean getHorizontal() {
        return this.horizontal;
    }
}
