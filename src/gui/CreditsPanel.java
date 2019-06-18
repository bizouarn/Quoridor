package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

public class CreditsPanel extends JPanel {

  private JLabel picAymer;
  private JLabel picPierr;
  private JLabel picClaud;
  private JLabel descAymer;
  private JLabel descPierr;
  private JLabel descClaud;

  private JButton retour;

  public CreditsPanel() {
    initComponent();
    setLayout(new GridLayout(3,2));
    add(this.picAymer);
    add(this.picPierr);
    add(this.picClaud);
    add(this.descAymer);
    add(this.descPierr);
    add(this.descClaud);
    add(this.retour);
    setBackground(null);
  }

  private void initComponent() {
    this.picAymer = new JLabel("Mettre une photo");
    this.picPierr = new JLabel("Mettre une photo");
    this.picClaud = new JLabel("Mettre une photo");
    this.descAymer = new JLabel("Mettre une desc");
    this.descPierr = new JLabel("Mettre une desc");
    this.descClaud = new JLabel("Mettre une desc");
    this.retour = new JButton("Back");
  }

  public JButton getReturnButton() {
    return this.retour;
  }
}
