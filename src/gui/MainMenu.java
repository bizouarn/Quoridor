package gui;

import controller.MenuGuiListener;

import javax.swing.*;
import java.awt.*;

/**
 * Main menu panel
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class MainMenu extends JPanel {

    /**
     * The listeners of the panel
     */
    private MenuGuiListener menuGuiListener;

    /**
     * JButton used to load a previous game
     */
    private JButton loadGame;
    /**
     * JButton used to launch a new Game
     */
    private JButton newGame;
    /**
     * JButton used to go to the rules page
     */
    private JButton rules;
    /**
     * JButton used to go to the credits
     */
    private JButton creds;
    /**
     * JButton used to quit the application
     */
    private JButton quit;

    /**
     * MainMenu Panel constructor
     * @param menuGuiListener Its listener
     * @author Pierre-Galaad Naquet
     */
    public MainMenu(MenuGuiListener menuGuiListener) {
        this.menuGuiListener = menuGuiListener;
        initComponent();
        setLayout(new GridLayout(5, 1));
        add(this.loadGame);
        add(this.newGame);
        add(this.rules);
        add(this.creds);
        add(this.quit);
        this.setPreferredSize(new Dimension(300, 200));
        setBackground(new Color(0,0,0,0));
    }

    /**
     * Initialize the panel's components
     * @author Pierre-Galaad Naquet
     */
    private void initComponent() {
        this.loadGame = new JButton("Load Game");
        this.loadGame.addActionListener(this.menuGuiListener);
        this.newGame = new JButton("New Game");
        this.newGame.addActionListener(this.menuGuiListener);
        this.creds = new JButton("Credits");
        this.creds.addActionListener(this.menuGuiListener);
        this.rules = new JButton("Rules");
        this.rules.addActionListener(this.menuGuiListener);
        this.quit = new JButton("Leave");
        this.quit.addActionListener(this.menuGuiListener);
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

    /**
     * Get the button Rules
     * @return the JButton Rules
     */
    public JButton getRules() {
        return rules;
    }
}
