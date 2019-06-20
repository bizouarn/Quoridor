package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import quoridor.Game;

/**
 * Listener for the game Frame (Gui)
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class GuiListener implements ActionListener , FocusListener , java.io.Serializable{
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
     * @author Aymeric Bizouarn
     */
    public GuiListener(Gui gui) {
        this.gui = gui;
    }

    /**
     * Get the action event and modify the gui / game in consequence
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

    /**
     * return the x1
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * return the x2
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * return the y1
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * return the y2
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * return the value
     * @return the value
     */
    public boolean getValue() {
        return this.value;
    }

    /**
     * return fence
     * @return true if there is a a fence, false otherwise
     */
    public boolean getFence() {
        return this.fence;
    }

    /**
     * return the fence status, used in AutoPlayer only
     * @return true if there is an horizontal fence, false otherwise
     */
    public boolean getHorizontal() {
        return this.horizontal;
    }

    /**
     * set the value (boolean)
     * @param value the desired value
     */
    public void setValue(boolean value) {
        this.value = value;
    }
}
