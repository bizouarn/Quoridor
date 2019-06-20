package gui;

import quoridor.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Players panel, part of the leftPanel in the Gui frame
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class PlayerPanel extends JPanel {

    private Player player;

    private JLabel name;
    private JLabel[] fences;
    private JPanel fencePanel;
    private JPanel panel;

    /**
     * PlayerPanel constructor
     *
     * @param player the player to represent
     * @author Pierre-Galaad Naquet
     */
    public PlayerPanel(Player player) {
        super();
        this.player = player;
        this.panel = new JPanel(new GridLayout(2, 1));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panel.setBorder(BorderFactory.createLineBorder(new Color(55, 62, 73), 5, true));
        this.add(panel);
        initComponent();
    }

    /**
     * Initialize the panel's components
     *
     * @author Pierre-Galaad Naquet
     */
    private void initComponent() {
        this.name = new JLabel(this.player.getName(), SwingConstants.CENTER);
        this.fences = new JLabel[10];
        this.fencePanel = new JPanel(new FlowLayout());
        this.setLayout(new GridLayout(2, 1));
        this.panel.add(this.name);
        this.panel.add(this.fencePanel);
        for (int i = 0; i < this.fences.length; i++) {
            this.fences[i] = new JLabel();
            this.fences[i].setIcon(new ImageIcon("./data/images/fence.png"));
            this.fencePanel.add(this.fences[i]);
        }
    }

    /**
     * Refreshes the panel
     *
     * @param playerInfo the number of fences left
     * @author Aymeric Bizouarn
     */
    void refresh(int playerInfo) {
        Color green = new Color(12, 99, 34);
        Color red = new Color(255, 53, 34);
        if (this.player.getGame().getPlayerPlay() == 1 && this.player == this.player.getGame().getPlayer1()) {
            this.panel.setBorder(BorderFactory.createLineBorder(green, 5, true));
        } else {
            this.panel.setBorder(BorderFactory.createLineBorder(red, 5, true));
        }
        if (this.player.getGame().getPlayerPlay() == 2 && this.player == this.player.getGame().getPlayer2()) {
            this.panel.setBorder(BorderFactory.createLineBorder(green, 5, true));
        } else {
            this.panel.setBorder(BorderFactory.createLineBorder(red, 5, true));
        }
        setFences(playerInfo);
        this.repaint();
    }

    /**
     * Set the number of fences for this player
     *
     * @param fences number of fences desired
     * @author Aymeric Bizouarn
     */
    private void setFences(int fences) {
        for (int i = 0; i < this.fences.length; i++) {
            this.fences[i].setVisible(false);
            if (i < fences) {
                this.fences[i].setVisible(true);
            }
        }
    }
}
