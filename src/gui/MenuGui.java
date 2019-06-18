package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.io.File;
import gui.*;
/*
public class MenuGui extends JPanel {

  CardLayout cl;
  WelcomePanel welcomePanel;
  MainMenu mainMenu;
  CreditsPanel creditsPanel;
  ParametersPanel parametersPanel;

    public static void main(String[] args) throws Exception {

        final BufferedImage bg = ImageIO.read(new File("../data/images/MENU.png"));

        Runnable run = new Runnable() {

            @Override
            public void run() {
                JPanel panel = new PanelWithBackgroundImage(bg);
                panel.setBorder(new EmptyBorder(10, 10, 10, 10));

                this.welcomePanel = new WelcomePanel();
                this.mainMenu = new MainMenu();
                this.creditsPanel = new CreditsPanel();
                //this.parametersPanel = new ParametersPanel();

                this.cl = new CardLayout();
                this.cl.addLayoutComponent(this.welcomePanel, "welcome");
                this.cl.addLayoutComponent(this.mainMenu, "mainmenu");
                this.cl.addLayoutComponent(this.creditsPanel, "credits");
                //this.cl.addLayoutComponent(this.parametersPanel, "parameters");

                show(this.cl, "welcome");

                JFrame frame = new JFrame(panel.getClass().getSimpleName());

                frame.add(panel);
                frame.pack();
                frame.setVisible(true);

                MenuGuiListener menuGuiListener = new MenuGuiListener(this);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(run);
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

}*/
