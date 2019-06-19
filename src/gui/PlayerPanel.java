package gui;

import quoridor.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel {
    private Player player;

    private JLabel name;
    private JLabel[] fences;
    private JPanel fencePanel;
    private JPanel panel;

    public PlayerPanel(Player player) {
        super();
        this.player = player;
        this.panel = new JPanel(new GridLayout(2,1));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.panel.setBorder(BorderFactory.createLineBorder(new Color(55, 62, 73),5,true));
        this.add(panel);
        initComponent();
    }

    private void initComponent() {
        this.name = new JLabel(this.player.getName(),SwingConstants.CENTER);
        this.fences = new JLabel[10];
        this.fencePanel = new JPanel(new FlowLayout());
        this.setLayout(new GridLayout(2, 1));
        this.panel.add(this.name);
        this.panel.add(this.fencePanel);
        for (int i = 0; i < this.fences.length; i++) {
            this.fences[i] = new JLabel();
            this.fences[i].setIcon(new ImageIcon("./data/images/fence.png"));
            this.fencePanel.add(this.fences[i]);
        }
    }

    public void refresh(int playerInfo) {
        setFences(playerInfo);
        this.repaint();
    }

    public void setFences(int fences) {
        for (int i = 0; i < this.fences.length; i++) {
            this.fences[i].setVisible(false);
            if(i<fences){
                this.fences[i].setVisible(true);
            }
        }
    }
}
