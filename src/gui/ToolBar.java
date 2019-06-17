package gui;

import javax.swing.*;
import java.awt.*;

public class ToolBar extends JPanel {

  private JButton fence;
  private JButton pawn;
  private JButton direction;

  public ToolBar() {
    setLayout(new GridLayout(1,3));
    initComponent();
    add(this.fence);
    add(this.pawn);
    add(this.direction);
  }

  private void initComponent() {
    this.fence = new JButton("Fence");
    this.pawn = new JButton("Pawn");
    this.direction = new JButton("Direction");
  }

}
