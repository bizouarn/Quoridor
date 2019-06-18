import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import java.io.File;

public class FrameWithBG {

    public static void main(String[] args) throws Exception {

        final BufferedImage bg = ImageIO.read(new File("../data/images/MENU.png"));

        Runnable run = new Runnable() {

            @Override
            public void run() {
                JPanel panel = new PanelWithBackgroundImage(bg);
                panel.setBorder(new EmptyBorder(10, 10, 10, 10));

                CardLayout cl = new CardLayout();
                cl.addLayoutComponent(new WelcomePanel(), "welcome");
                cl.addLayoutComponent(new MainMenu(), "mainemenu");
                cl.addLayoutComponent(new CreditsPanel(), "credits");
                cl.addLayoutComponent(new ParametersPanel(), "parameters");

                show(cl, "welcome");

                JFrame frame = new JFrame(panel.getClass().getSimpleName());

                frame.add(c);
                frame.pack();
                frame.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency/initial.html
        SwingUtilities.invokeLater(run);
    }
}

class PanelWithBackgroundImage extends JPanel {

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
