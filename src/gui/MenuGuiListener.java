package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import quoridor.Quoridor;
import quoridor.Game;


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
            new Game(true);
        }
        if (e.getSource() == this.menuGui.getMainMenu().getCreds()) {
            this.menuGui.show("credits");
        }
    }
}
