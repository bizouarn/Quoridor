package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Credits panel containing the info about the creators of this app.
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class RulesPanel extends JPanel {

    private JLabel rulesPanel;

    private JButton retour;
    private MenuGuiListener menuGuiListener;


    /**
     * JPanel constructor
     *
     * @param menuGuiListener The listeners of this panel
     * @author Pierre-Galaad Naquet
     */
    public RulesPanel(MenuGuiListener menuGuiListener) {
        this.menuGuiListener = menuGuiListener;
        initComponent();
        setLayout(new FlowLayout());
        add(this.rulesPanel);
        add(this.retour);
        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * Initialize all the components of the JPanel
     *
     * @author Pierre-Galaad Naquet
     */
    private void initComponent() {
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("./data/images/RULES.png").getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH));
        this.rulesPanel = new JLabel();
        this.rulesPanel.setIcon(imageIcon);
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
