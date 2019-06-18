package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

      private JButton loadGame;
      private JButton newGame;
      private JButton creds;
      private JButton quit;

      public WelcomePanel() {
        initComponent();
        setLayout(new GridLayout(4,1));
        add(this.loadGame);
        add(this.newGame);
        add(this.creds);
        add(this.quit);
        setBackground(null);
      }

      private void initComponent() {
        this.loadGame = new JButton("Load Game");
        this.loadGame.setBackground(null);
        this.newGame = new JButton("New Game");
        this.newGame.setBackground(null);
        this.creds = new JButton("Credits");
        this.creds.setBackground(null);
        this.quit = new JButton("Leave");
        this.quit.setBackground(null);
      }

      public JButton getLoadGame() {
        return this.loadGame;
      }

      public JButton getNewGame() {
        return this.newGame;
      }

      public JButton getCreds() {
        return this.creds;
      }

      public JButton getQuit() {
        return this.quit;
      }
}
