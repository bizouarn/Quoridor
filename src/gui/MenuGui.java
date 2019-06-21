package gui;

import controller.MenuGuiListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Frame for the menus
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class MenuGui {

    /**
     * The listener used for the page
     */
    private MenuGuiListener menuGuiListener = new MenuGuiListener(this);

    /**
     * WelcomePanel panel
     */
    private WelcomePanel welcomePanel;
    /**
     * MainMenu panel
     */
    private MainMenu mainMenu;
    /**
     * CreditsPanel panel
     */
    private CreditsPanel creditsPanel;
    /**
     * RulesPanel panel
     */
    private RulesPanel rulesPanel;
    /**
     * CardLayout containing the panels
     */
    private CardLayout cl;
    /**
     * Main panel
     */
    private JPanel panel;
    /**
     * Main Frame
     */
    private JFrame jFrame;

    /**
     * Game gui, used to launch the Gui
     */
    private Gui gui;

    /**
     * MenuGui constructor
     *
     * @author Aymeric Bizouarn
     */
    public MenuGui() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAndShowMenuGui();
            }
        });
    }

    /**
     * Initialize the MenuGui
     *
     * @author Aymeric Bizouarn , Pierre-Galaad Naquet
     */
    public void CreateAndShowMenuGui() {
        BufferedImage bg = null;
        try {
            bg = ImageIO.read(new File("./data/images/MENU.png"));
        } catch (IOException e) {
        }
        this.panel = new PanelWithBackgroundImage(bg);
        this.panel.setBorder(new EmptyBorder(100, 75, 100, 75));
        this.panel.setPreferredSize(new Dimension(700, 450));

        this.welcomePanel = new WelcomePanel(this.menuGuiListener);
        this.mainMenu = new MainMenu(this.menuGuiListener);
        this.creditsPanel = new CreditsPanel(this.menuGuiListener);
        this.rulesPanel = new RulesPanel(this.menuGuiListener);

        this.panel.add(this.welcomePanel);
        this.panel.add(this.mainMenu);
        this.panel.add(this.creditsPanel);
        this.panel.add(this.rulesPanel);

        this.show("welcome");

        this.jFrame = new JFrame("Quoridor : Menu");
        this.jFrame.add(this.panel);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
        this.jFrame.setLocationRelativeTo(null);
    }

    /**
     * Show the desired panel
     *
     * @author Aymeric Bizouarn , Pierre-Galaad Naquet
     */
    public void show(String panel) {
        this.mainMenu.setVisible(false);
        this.welcomePanel.setVisible(false);
        this.creditsPanel.setVisible(false);
        this.rulesPanel.setVisible(false);
        if (panel.equals("menu")) {
            this.mainMenu.setVisible(true);
        } else if (panel.equals("welcome")) {
            this.welcomePanel.setVisible(true);
        } else if (panel.equals("credits")) {
            this.creditsPanel.setVisible(true);
        } else if (panel.equals("rules")) {
          this.rulesPanel.setVisible(true);
        }

    }

    /**
     * Get the welcomePanel
     *
     * @return the welcomePanel
     */
    public WelcomePanel getWelcomePanel() {
        return this.welcomePanel;
    }

    /**
     * Get the mainMenu
     *
     * @return the mainMenu
     */
    public MainMenu getMainMenu() {
        return this.mainMenu;
    }

    /**
     * Get the creditsPanel
     *
     * @return the creditsPanel
     */
    public CreditsPanel getCreditsPanel() {
        return this.creditsPanel;
    }

    /**
     * Get the rulesPanel
     *
     * @return the creditsPanel
     */
    public RulesPanel getRulesPanel() {
        return this.rulesPanel;
    }

    /**
     * Get the panel
     *
     * @return the panel
     */
    public JPanel getPanel() {
        return this.panel;
    }

    /**
     * Get the frame
     *
     * @return the frame
     */
    public JFrame getjFrame() {
        return this.jFrame;
    }
}
