package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Creating the background image for the JFrame menuGui
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class PanelWithBackgroundImage extends JPanel {

    private Image bg;

    /**
     * Panel constructor
     *
     * @param bg pathFile to the desired image
     * @author Pierre-Galaad Naquet
     */
    PanelWithBackgroundImage(Image bg) {
        this.bg = bg;
    }

    /**
     * Paint the component on the JFrame
     *
     * @param g Graphics data
     * @author Pierre-Galaad Naquet
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
