package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Bottom of the Gui Frame, contains actions buttons
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class ToolBar extends JPanel {

    /**
     * JButton used to activate the fence positioning
     */
    private JButton fence;
    /**
     * JButton used to activate the pawn action
     */
    private JButton pawn;
    /**
     * JButton used to swap the direction of the fence
     */
    private JButton direction;
    /**
     * JButton used to save and quit the game
     */
    private JButton save;
    /**
     * Current Gui
     */
    private Gui gui;

    /**
     * ToolBar constructor
     *
     * @param gui The current Gui
     * @author Pierre-Galaad Naquet
     */
    public ToolBar(Gui gui) {
        this.gui = gui;
        setLayout(new GridLayout(1, 3));
        initComponent();
        add(this.save);
        add(this.pawn);
        add(this.fence);
        add(this.direction);
        this.pawn.setEnabled(false);
        this.direction.setVisible(false);
    }

    /**
     * Initialize the panel components
     *
     * @author Pierre-Galaad Naquet
     */
    private void initComponent() {
        this.save = new JButton("Save game & quit");
        this.fence = new JButton("Fence");
        this.pawn = new JButton("Pawn");
        this.direction = new JButton("Direction : \u2014");
        this.save.addActionListener(this.gui.getGuiListener());
        this.fence.addActionListener(this.gui.getGuiListener());
        this.pawn.addActionListener(this.gui.getGuiListener());
        this.direction.addActionListener(this.gui.getGuiListener());
    }

    /**
     * get the JButton save
     *
     * @return the JButton save
     */
    public JButton getSave() {
        return this.save;
    }

    /**
     * get the JButton Direction
     *
     * @return the JButton Direction
     */
    public JButton getDirection() {
        return this.direction;
    }

    /**
     * get the JButton fence
     *
     * @return the JButton fence
     */
    public JButton getFence() {
        return this.fence;
    }

    /**
     * get the JButton Pawn
     *
     * @return the JButton Pawn
     */
    public JButton getPawn() {
        return this.pawn;
    }
}
