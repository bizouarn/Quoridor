package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {

  private JButton startButton;

  private MenuGuiListener menuGuiListener;
  public WelcomePanel(MenuGuiListener menuGuiListener) {
    this.menuGuiListener = menuGuiListener;
    initComponent();
    add(this.startButton);
    setBackground(null);
  }

  private void initComponent() {
    this.startButton = new JButton("Start");
    this.startButton.addActionListener(this.menuGuiListener);
    this.startButton.setBackground(null);
  }

  public JButton getStartButton() {
    return this.startButton;
  }
}
