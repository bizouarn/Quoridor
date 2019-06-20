package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import gui.*;
import quoridor.Quoridor;

public class MenuGui {

    private MenuGuiListener menuGuiListener = new MenuGuiListener(this);

    ParametersPanel parametersPanel;

    private WelcomePanel welcomePanel;
    private MainMenu mainMenu;
    private CreditsPanel creditsPanel;
    private CardLayout cl;
    private JPanel panel;
    private JFrame jFrame;

    private Gui gui;

    public MenuGui() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAndShowMenuGui();
            }
        });
    }

    public void CreateAndShowMenuGui() {
        BufferedImage bg = null;
        try {
            bg = ImageIO.read(new File("./data/images/MENU.png"));
        } catch (IOException e) {
        }
        this.panel = new PanelWithBackgroundImage(bg);
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

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


    public WelcomePanel getWelcomePanel() {
        return this.welcomePanel;
    }

    public MainMenu getMainMenu() {
        return this.mainMenu;
    }

    public CreditsPanel getCreditsPanel() {
        return this.creditsPanel;
    }

    public JPanel getPanel() {
        return this.panel;
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
}
