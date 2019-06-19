package gui;

import javax.swing.JOptionPane;

public class PopUpInputPlayer {

  public static String popUpPlayer1() {
    String m = JOptionPane.showInputDialog("Type player 1 name, use 'auto' to have a bot");
    return m;
  }

  public static String popUpPlayer2() {
    String m = JOptionPane.showInputDialog("Type player 2 name, use 'auto' to have a bot");
    return m;
  }


}
