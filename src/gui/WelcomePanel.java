package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {

  private JButton startButton;

  private MenuGui menuGui;
  public WelcomePanel(MenuGui menuGui) {
    this.menuGui = menuGui;
    initComponent();
    add(this.startButton);
    setBackground(null);
  }

  private void initComponent() {
    this.startButton = new JButton("Start");
    this.startButton.addActionListener(new MenuGuiListener(this.menuGui));
    this.startButton.setBackground(null);
  }

  public JButton getStartButton() {
    return this.startButton;
  }
}
