package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import quoridor.Quoridor;


public class MenuGuiListener implements ActionListener {

    private MenuGui menuGui;

    public MenuGuiListener(MenuGui menuGui) {
        this.menuGui = menuGui;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.menuGui.getWelcomePanel().getStartButton()) {
            this.menuGui.show("menu");
        }
        if (e.getSource() == this.menuGui.getCreditsPanel().getReturnButton()) {
            this.menuGui.show("menu");
        }
        if (e.getSource() == this.menuGui.getMainMenu().getLoadGame()) {
            Gui gui = new Gui(Quoridor.loadOldGame());
            gui.getGame().startLoaded();
        }
        if (e.getSource() == this.menuGui.getMainMenu().getNewGame()) {
            //Game game = new Game(2);
            this.menuGui.getjFrame().dispose();
            try {
                FileWriter fw = new FileWriter(new File("./data/new.bin"), false);
                fw.write("gui");
                fw.close();
            } catch (Exception exc){

            }
        }
        if (e.getSource() == this.menuGui.getMainMenu().getCreds()) {
            this.menuGui.show("credits");
        }
    }
}
