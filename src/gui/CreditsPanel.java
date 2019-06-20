package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

/**
 * Credits panel containing the info about the creators of this app.
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class CreditsPanel extends JPanel {

  private JLabel picAymer;
  private JLabel picPierr;
  private JLabel picClaud;
  private JLabel descAymer;
  private JLabel descPierr;
  private JLabel descClaud;

  private JButton retour;
  private MenuGuiListener menuGuiListener;


  /**
   * JPanel constructor
   * @param menuGuiListener The listeners of this panel
   * @author Pierre-Galaad Naquet
   */
  public CreditsPanel(MenuGuiListener menuGuiListener) {
    this.menuGuiListener = menuGuiListener;
    initComponent();
    setLayout(new GridLayout(4,2));
    add(this.picAymer);
    add(this.descAymer);
    add(this.picPierr);
    add(this.descPierr);
    add(this.picClaud);
    add(this.descClaud);
    add(this.retour);
    this.setPreferredSize(new Dimension(300,200));
    setBackground(new Color(0,0,0,0));
  }

  /**
   * Initialize all the components of the JPanel
   * @author Pierre-Galaad Naquet
   */
  private void initComponent() {
    this.picAymer = new JLabel("Mettre une photo");
    this.picPierr = new JLabel("Mettre une photo");
    this.picClaud = new JLabel("Mettre une photo");
    this.descAymer = new JLabel("Mettre une desc");
    this.descPierr = new JLabel("Mettre une desc");
    this.descClaud = new JLabel("Mettre une desc");
    this.retour = new JButton("Back");
    this.retour.addActionListener(this.menuGuiListener);
  }

  /**
   * Return the retour Button
   * @return the JButton retour.
   */
  public JButton getReturnButton() {
    return this.retour;
  }
}
