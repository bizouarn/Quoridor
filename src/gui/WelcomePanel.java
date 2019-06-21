package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Initialization panel
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class WelcomePanel extends JPanel {

    private JButton startButton;
    private MenuGuiListener menuGuiListener;

    /**
     * WelcomePanel constructor
     *
     * @author Pierre-Galaad Naquet
     */
    public WelcomePanel(MenuGuiListener menuGuiListener) {
        super(new GridLayout(3, 1));
        this.menuGuiListener = menuGuiListener;
        initComponent();

        add(new JLabel(new ImageIcon("./data/images/Quoridor.png")));
        JPanel panel = new JPanel(new GridLayout());
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createMatteBorder(30,125,30,125,new Color(0,0,0,0)));
        panel.add(this.startButton);
        add(panel);

        setBackground(new Color(0, 0, 0, 0));
    }

    /**
     * Initialize the components
     *
     * @author Pierre-Galaad Naquet
     */
    private void initComponent() {
        this.startButton = new JButton();
        this.startButton.setText("Start");
        this.startButton.addActionListener(this.menuGuiListener);
    }

    /**
     * Get the start button
     *
     * @return the JButton start
     */
    public JButton getStartButton() {
        return this.startButton;
    }
}
