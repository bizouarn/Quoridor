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
    initFont();
    initComponent();
    setLayout(new GridLayout(3,3));
    add(this.picAymer);
    add(this.picPierr);
    add(this.picClaud);
    add(this.descAymer);
    add(this.descPierr);
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
    this.picAymer = new JLabel(new ImageIcon("./data/images/portraits/hamster.jpg"));
    this.picPierr = new JLabel(new ImageIcon("./data/images/portraits/slug.jpg"));
    this.picClaud = new JLabel(new ImageIcon("./data/images/portraits/lapin.jpg"));
    this.descAymer = new JLabel("Programer\n\nFrench student in the UIT of Vannes in IT.");
    this.descPierr = new JLabel("Programer\n\nFrench student in the UIT of Vannes in IT.");
    this.descClaud = new JLabel("Designer\n\nCanadian student in the ArtCenter college, Pasadena California, USA");
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
