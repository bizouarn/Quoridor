package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

public class LeftPlayers extends JPanel {

  private PlayerPanel player1;
  private PlayerPanel player2;

  public LeftPlayers(Player player1, Player player2) {
    this.player1 = new PlayerPanel(player1);
    this.player2 = new PlayerPanel(player2);
    setLayout(new GridLayout(2, 1));
    add(this.player1);
    add(this.player2);
  }
}
