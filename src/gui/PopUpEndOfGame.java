package gui;

import quoridor.Player;

import javax.swing.*;

/**
 * Pop up invoked when the game end
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class PopUpEndOfGame extends JPanel {

    /**
     * popUpEndOfGame constructor
     *
     * @author Pierre-Galaad Naquet
     */
    public static int popUpEndOfGame(Player player) throws IllegalStateException {
        Object[] options = {"New Game", "Main Menu", "Leave"};
        int choice = JOptionPane.showOptionDialog(null,
                " " + player.getName() + " has won !",
                "Game has ended",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        int ret = 3;

        if (choice == JOptionPane.YES_OPTION) {
            ret = 1;
        }

        if (choice == JOptionPane.NO_OPTION) {
            ret = 2;
        }

        if (choice == JOptionPane.CANCEL_OPTION) {
            ret = 3;
        }
        return ret;
    }
}
