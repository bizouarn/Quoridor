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

    /**
     * players panel constructor
     *
     * @param player1 the player 1 of the game
     * @param player2 the player 2 of the game
     * @author Pierre-Galaad Naquet
     */
    public LeftPlayers(Player player1, Player player2) {
        super();
        this.player1 = new PlayerPanel(player1);
        this.player2 = new PlayerPanel(player2);
        this.setPreferredSize(new Dimension(200, 100));
        setLayout(new GridLayout(2, 1));
        add(this.player1);
        add(this.player2);
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
}
