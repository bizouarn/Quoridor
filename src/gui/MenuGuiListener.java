package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            //Game game = new Game(true);
            try {
                Runtime.getRuntime().exec("java -jar Quoridor.jar Game");
                System.exit(0);
            } catch (Exception excep) { }
        }
        if (e.getSource() == this.menuGui.getMainMenu().getCreds()) {
            this.menuGui.show("credits");
        }
    }
}
