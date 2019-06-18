package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class menuGuiListener implements ActionListener {

  private MenuGui menuGui;

  public MenuGuiListener(MenuGui menuGui) {
      this.menuGui = menuGui;
  }

  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.menuGui.getWelcomePanel().getStartButton()) {
        this.menuGui.getCL().show(this.menuGui, "mainMenu");
      }
      if (e.getSource() == this.menuGui.getCreditsPanel().getReturnButton()) {
        this.menuGui.getCL().show(this.menuGui, "mainMenu");
      }
      if (e.getSource() == this.menuGui.getMainMenu().getLoadGame()) {
        System.out.println("I am vewy sowwy, I still need to be progwammed, (((（´・ω・；`）)))");
      }
      if (e.getSource() == this.menuGui.getMainMenu().getNewGame()) {
        System.out.println("I am vewy sowwy, I still need to be progwammed, (((（´・ω・；`）)))");
      }
      if (e.getSource() == this.menuGui.getMainMenu().getCreds()) {
        this.menuGui.getCL().show(this.menuGui, "credits");
      }
  }
}
