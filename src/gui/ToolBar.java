package gui;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {

  private JButton fence;
  private JButton pawn;
  private JButton direction;
  private JButton save;
  private Gui gui;

  public ToolBar(Gui gui) {
    this.gui = gui;
    setLayout(new GridLayout(1,3));
    initComponent();
    add(this.save);
    add(this.pawn);
    add(this.fence);
    add(this.direction);
    this.pawn.setEnabled(false);
    this.direction.setVisible(false);
  }

  private void initComponent() {
    this.save = new JButton("Save Game");
    this.fence = new JButton("Fence");
    this.pawn = new JButton("Pawn");
    this.direction = new JButton("Direction : \u2014");
    this.save = new addActionListener(this.gui.getGuiListener());
    this.fence.addActionListener(this.gui.getGuiListener());
    this.pawn.addActionListener(this.gui.getGuiListener());
    this.direction.addActionListener(this.gui.getGuiListener());
  }

  public JButton getSave() {
    return this.save;
  }

  public JButton getDirection() {
    return this.direction;
  }

  public JButton getFence() {
    return this.fence;
  }

  public JButton getPawn() {
    return this.pawn;
  }
}
