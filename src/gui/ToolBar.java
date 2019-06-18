package gui;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {

  private JButton fence;
  private JButton pawn;
  private JButton direction;
  private GuiListener guiListener;
  private Gui gui;

  public ToolBar(Gui gui,GuiListener guiListener) {
    this.gui = gui;
    this.guiListener = guiListener;
    setLayout(new GridLayout(1,3));
    initComponent();
    add(this.pawn);
    add(this.fence);
    add(this.direction);
  }

  private void initComponent() {
    this.fence = new JButton("Fence");
    this.pawn = new JButton("Pawn");
    this.direction = new JButton("Direction");
    this.fence.addActionListener(new GuiListener(this.gui));
    this.pawn.addActionListener(new GuiListener(this.gui));
    this.direction.addActionListener(new GuiListener(this.gui));
  }

  public JButton getDirection() {
    return direction;
  }

  public JButton getFence() {
    return fence;
  }

  public JButton getPawn() {
    return pawn;
  }
}
