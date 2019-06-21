package gui;

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

    private MenuGuiListener menuGuiListener = new MenuGuiListener(this);

    private WelcomePanel welcomePanel;
    private MainMenu mainMenu;
    private CreditsPanel creditsPanel;
    private CardLayout cl;
    private JPanel panel;
    private JFrame jFrame;

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
        //this.parametersPanel = new ParametersPanel();

        this.panel.add(this.welcomePanel);
        this.panel.add(this.mainMenu);
        this.panel.add(this.creditsPanel);

        this.show("welcome");

        this.jFrame = new JFrame(this.panel.getClass().getSimpleName());
        this.jFrame.add(this.panel);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }

    /**
     * Show the desired panel
     *
     * @author Aymeric Bizouarn
     */
    public void show(String panel) {
        this.mainMenu.setVisible(false);
        this.welcomePanel.setVisible(false);
        this.creditsPanel.setVisible(false);
        if (panel.equals("menu")) {
            this.mainMenu.setVisible(true);
        } else if (panel.equals("welcome")) {
            this.welcomePanel.setVisible(true);
        } else if (panel.equals("credits")) {
            this.creditsPanel.setVisible(true);
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
