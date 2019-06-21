package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

/**
 * Listener for the menuGui
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class MenuGuiListener implements ActionListener {

    private MenuGui menuGui;

    /**
     * MenuGuiListener constructor
     *
     * @author Piere-Galaad Naquet
     */
    public MenuGuiListener(MenuGui menuGui) {
        this.menuGui = menuGui;
    }

    /**
     * invoked when there is an event on the menuGui
     *
     * @param e an action on the frame
     * @author Pierre-Galaad Naquet
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.menuGui.getWelcomePanel().getStartButton()) {
            this.menuGui.show("menu");
        }
        else if (e.getSource() == this.menuGui.getCreditsPanel().getReturnButton()) {
            this.menuGui.show("menu");
        }
        else if (e.getSource() == this.menuGui.getRulesPanel().getReturnButton()) {
            this.menuGui.show("menu");
        }
        else if (e.getSource() == this.menuGui.getMainMenu().getLoadGame()) {
            this.menuGui.getjFrame().dispose();
            try {
                FileWriter fw = new FileWriter(new File("./data/new.bin"), false);
                fw.write("load");
                fw.close();
            } catch (Exception exc) {
                System.out.println(e);
            }
        }
        else if (e.getSource() == this.menuGui.getMainMenu().getNewGame()) {
            try {
                FileWriter fw = new FileWriter(new File("./data/new.bin"), false);
                fw.write("gui");
                fw.close();
            } catch (Exception exc) {
                System.out.println(e);
            }
            this.menuGui.getjFrame().dispose();
        }
        else if (e.getSource() == this.menuGui.getMainMenu().getCreds()) {
            this.menuGui.show("credits");
        }
        else if (e.getSource() == this.menuGui.getMainMenu().getRules()) {
            this.menuGui.show("rules");
        }
        else if (e.getSource() == this.menuGui.getMainMenu().getQuit()) {
            System.exit(0);
        }
    }
}
