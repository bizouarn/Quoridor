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

public class MenuGui{

    ParametersPanel parametersPanel;

    private WelcomePanel welcomePanel;
    private MainMenu mainMenu;
    private CreditsPanel creditsPanel;
    private CardLayout cl;
    private JPanel panel;

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
        } catch (IOException e) {}
        this.panel = new PanelWithBackgroundImage(bg);
        this.panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.welcomePanel = new WelcomePanel();
        this.mainMenu = new MainMenu();
        this.creditsPanel = new CreditsPanel();
        //this.parametersPanel = new ParametersPanel();

        this.panel.add(this.welcomePanel,"welcome");
        this.panel.add(this.mainMenu,"mainmenu");
        this.panel.add(this.creditsPanel,"credits");
        this.panel.setLayout(new CardLayout());

        this.cl= (CardLayout)panel.getLayout();
        cl.show(panel, "welcome");

        JFrame frame = new JFrame(this.panel.getClass().getSimpleName());
        frame.add(this.panel);
        frame.pack();
        frame.setVisible(true);

        MenuGuiListener menuGuiListener = new MenuGuiListener(this);
    }

    public CardLayout getCL() {
        return this.cl;
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
        return panel;
    }
}
