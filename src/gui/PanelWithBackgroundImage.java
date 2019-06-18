package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.io.File;
import gui.*;

public class PanelWithBackgroundImage extends JPanel {

    Image bg;

    PanelWithBackgroundImage(Image bg) {
        this.bg = bg;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
