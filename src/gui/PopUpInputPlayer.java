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
    public static String popUpPlayer1() {
        String m = JOptionPane.showInputDialog("Type player 1 name, use 'auto' to have a bot");
        return m;
    }

    /**
     * Creates a JOptionPane and ask for the player 2 name
     *
     * @return the name of the player
     * @author Pierre-Galaad Naquet
     */
    public static String popUpPlayer2() {
        String m = JOptionPane.showInputDialog("Type player 2 name, use 'auto' to have a bot");
        return m;
    }


}
