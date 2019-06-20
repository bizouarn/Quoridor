package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

/**
 * Initialization panel
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class WelcomePanel extends JPanel {

  private JButton startButton;
  private MenuGuiListener menuGuiListener;

  /**
   * WelcomePanel constructor
   * @author Pierre-Galaad Naquet
   */
  public WelcomePanel(MenuGuiListener menuGuiListener) {
    this.menuGuiListener = menuGuiListener;
    initComponent();
    add(this.startButton);
    setBackground(null);
  }

  /**
   * Initialize the components
   * @author Pierre-Galaad Naquet
   */
  private void initComponent() {
    this.startButton = new JButton("Start");
    this.startButton.addActionListener(this.menuGuiListener);
    this.startButton.setBackground(null);
  }

  /**
   * Get the start button
   * @return the JButton start
   */
  public JButton getStartButton() {
    return this.startButton;
  }
}
