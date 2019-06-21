package gui;

import controller.MenuGuiListener;

import javax.swing.*;
import java.awt.*;

/**
 * Credits panel containing the info about the creators of this app.
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class CreditsPanel extends JPanel {

    /**
     * JLabel containing the image of credits
     */
    private JLabel creditsPanel;

    /**
     * Return button
     */
    private JButton retour;
    /**
     * Current menuGuiListener
     */
    private MenuGuiListener menuGuiListener;


    /**
     * JPanel constructor
     *
     * @param menuGuiListener The listeners of this panel
     * @author Pierre-Galaad Naquet
     */
    public CreditsPanel(MenuGuiListener menuGuiListener) {
        this.menuGuiListener = menuGuiListener;
        initComponent();
        setLayout(new FlowLayout());
        add(this.creditsPanel);
        add(this.retour);
        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * Initialize all the components of the JPanel
     *
     * @author Pierre-Galaad Naquet
     */
    private void initComponent() {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("./data/images/CREDITS.png").getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH));
        this.creditsPanel = new JLabel(imageIcon);
        this.retour = new JButton("Back");
        this.retour.addActionListener(this.menuGuiListener);
    }

    /**
     * Return the retour Button
     *
     * @return the JButton retour.
     */
    public JButton getReturnButton() {
        return this.retour;
    }
}
