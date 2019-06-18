package gui;

import quoridor.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{
    private Player player;

    private JLabel name;

    private JLabel fences;

    public PlayerPanel (Player player){
        super();
        this.player = player;
        this.name = new JLabel(this.player.getName());
        this.add(this.name);
        this.fences = new JLabel("10");
        initComponent();
    }

    private void initComponent() {
      this.setLayout(new GridLayout(2, 1));
      this.add(name);
      this.add(fences);
    }

    public void refresh(int playerInfo){
        this.fences.setText(playerInfo+"");
        this.repaint();
    }

    public void setFences(int fences) {
      this.fences.setText(fences+"");
    }
}
