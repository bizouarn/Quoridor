package gui;

import gui.PlayerPanel;
import quoridor.*;

import javax.swing.*;
import java.awt.*;

/**
 * Main menu panel
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class MainMenu extends JPanel {

    private MenuGuiListener menuGuiListener;

    private JButton loadGame;
    private JButton newGame;
    private JButton creds;
    private JButton quit;

    /**
     * MainMenu Panel constructor
     * @param menuGuiListener Its listener
     * @author Pierre-Galaad Naquet
     */
    public MainMenu(MenuGuiListener menuGuiListener) {
        this.menuGuiListener = menuGuiListener;
        initComponent();
        setLayout(new GridLayout(4, 1));
        add(this.loadGame);
        add(this.newGame);
        add(this.creds);
        add(this.quit);
        setBackground(null);
    }

    /**
     * Initialize the panel's components
     * @author Pierre-Galaad Naquet
     */
    private void initComponent() {
        this.loadGame = new JButton("Load Game");
        this.loadGame.setBackground(null);
        this.loadGame.addActionListener(this.menuGuiListener);
        this.newGame = new JButton("New Game");
        this.newGame.setBackground(null);
        this.newGame.addActionListener(this.menuGuiListener);
        this.creds = new JButton("Credits");
        this.creds.setBackground(null);
        this.creds.addActionListener(this.menuGuiListener);
        this.quit = new JButton("Leave");
        this.quit.setBackground(null);
    }

    /**
     * Get the button Load Game
     * @return the JButton LoadGame
     */
    public JButton getLoadGame() {
        return this.loadGame;
    }

    /**
     * Get the button New Game
     * @return the JButton NewGame
     */
    public JButton getNewGame() {
        return this.newGame;
    }

    /**
     * Get the button credits
     * @return the JButton creds
     */
    public JButton getCreds() {
        return this.creds;
    }

    /**
     * Get the button Quit
     * @return the JButton quit
     */
    public JButton getQuit() {
        return this.quit;
    }
}
