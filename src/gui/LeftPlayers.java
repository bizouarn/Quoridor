package gui;

import quoridor.Player;

import javax.swing.*;
import java.awt.*;

/**
 * Left player panel containing players data
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class LeftPlayers extends JPanel {

    private PlayerPanel player1;
    private PlayerPanel player2;
    private PlayerPanel player3;
    private PlayerPanel player4;

    /**
     * players panel constructor
     *
     * @param player1 the player 1 of the game
     * @param player2 the player 2 of the game
     * @author Pierre-Galaad Naquet
     */
    public LeftPlayers(Player player1, Player player2) {
        super(new GridLayout(2,1));
        this.player1 = new PlayerPanel(player1);
        this.player2 = new PlayerPanel(player2);
        this.player1.getPanel().setBackground(new Color(159, 210, 154));
        this.player2.getPanel().setBackground(new Color(236, 153, 122));
        this.setPreferredSize(new Dimension(200, 400));
        add(this.player1);
        add(this.player2);
    }
    public LeftPlayers(Player player1, Player player2,Player player3,Player player4) {
        super(new GridLayout(4,1));
        this.player1 = new PlayerPanel(player1);
        this.player2 = new PlayerPanel(player2);
        this.player3 = new PlayerPanel(player3);
        this.player4 = new PlayerPanel(player4);
        this.player1.getPanel().setBackground(new Color(159, 210, 154));
        this.player2.getPanel().setBackground(new Color(236, 153, 122));
        this.player3.getPanel().setBackground(new Color(206, 218, 225));
        this.player4.getPanel().setBackground(new Color(232, 236, 151));
        this.setPreferredSize(new Dimension(200, 400));
        add(this.player1);
        add(this.player2);
        add(this.player3);
        add(this.player4);
    }

    /**
     * Refreshes the players panel
     *
     * @param player1 the player 1 of the game
     * @param player2 the player 2 of the game
     * @author Aymeric Bizouarn
     */
    void refresh(int player1, int player2) {
        this.player1.refresh(player1);
        this.player2.refresh(player2);
        this.repaint();
    }
    void refresh(int player1, int player2,int player3,int player4) {
        this.player1.refresh(player1);
        this.player2.refresh(player2);
        this.player3.refresh(player3);
        this.player4.refresh(player4);
        this.repaint();
    }
}
