package gui;

import quoridor.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{
    private Player player;

    private JLabel name;

    public PlayerPanel (Player player){
        super();
        this.player = player;
        this.name = new JLabel(this.player.getName());
        this.add(this.name);
        this.setBackground(new Color(128, 142, 159));
    }
}
