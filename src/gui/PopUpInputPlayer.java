package gui;

import javax.swing.*;

/**
 * pop up invoked before a new game to ask for the players
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class PopUpInputPlayer {

    /**
     * Creates a JOptionPane and ask for the player 1 name
     *
     * @return the name of the player
     * @author Pierre-Galaad Naquet
     */
    public static String popUpPlayer(int player) {
        String m = JOptionPane.showInputDialog("Type player "+player+" name, use 'auto' to have a bot");
        return m;
    }


}
