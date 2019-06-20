import gui.*;
import quoridor.Game;
import quoridor.Quoridor;

import javax.swing.*;
import java.awt.*;

/**
 * Graphical launcher
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class LaunchGUI{
        public static void main(String[] args){
        String[] game = {"gui"};
        new Quoridor(game);
    }
}
