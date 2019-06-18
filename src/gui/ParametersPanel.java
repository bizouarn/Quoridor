package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

public class ParametersPanel extends JPanel {

    private JButton mode2p;
    private JButton mode4p;
    private JButton return;

    public WelcomePanel() {
      initComponent();
      add(this.mode2p);
      add(this.mode4p);
      add(this.return);
      setBackground(null);
    }

    private void initComponent() {
      this.mode2p = new JButton("2 players");
      this.mode2p.setBackground(null);
      this.mode4p = new JButton("4 players");
      this.mode4p.setBackground(null);
      this.return = new JButton("back");
      this.return.setBackground(null);
    }
}
