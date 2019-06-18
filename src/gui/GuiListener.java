package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiListener implements ActionListener {
    private boolean value = false;
    private boolean fence = false;
    private boolean horizontal = false;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Gui gui;

    public GuiListener(Gui gui) {
        this.gui = gui;
    }

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
            } else {
                this.horizontal = true;
            }
            System.out.println("Horizonatal :"+this.horizontal);
        }
        if (e.getSource() == this.gui.getToolBar().getFence()) {
            this.fence = true;
            this.gui.getToolBar().getPawn().setEnabled(true);
            this.gui.getToolBar().getFence().setEnabled(false);
            this.gui.getToolBar().getDirection().setVisible(true);
            System.out.println("|fence = " + this.fence + "|");
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

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public boolean getValue() {
        return this.value;
    }

    public boolean getFence() {
        return this.fence;
    }

    public boolean getHorizontal() {
        return this.horizontal;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
