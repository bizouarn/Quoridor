package gui;

import quoridor.Game;

import javax.swing.*;
import java.awt.*;

public class Gui {

    private PlayerPanel playerPanel1;
    private PlayerPanel playerPanel2;
    private GridPanel gridPanel;

    private Game game;
    private JFrame jFrame;

    public Gui(Game game){
        this.game = game;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAndShowGui();
            }
        });
    }

    public void CreateAndShowGui(){
        jFrame = new JFrame("Quoridor");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.gridPanel = new GridPanel(game.getBoard());
        this.playerPanel1 = new PlayerPanel(game.getPlayer1());
        this.playerPanel2 = new PlayerPanel(game.getPlayer2());

        jFrame.add(this.gridPanel, BorderLayout.CENTER);
        jFrame.add(this.playerPanel1, BorderLayout.WEST);
        jFrame.add(this.playerPanel2, BorderLayout.EAST);

        jFrame.pack();
        jFrame.setVisible(true);
    }

    public void refresh(){
        this.playerPanel1 = new PlayerPanel(this.game.getPlayer1());
        this.playerPanel2 = new PlayerPanel(this.game.getPlayer2());
        this.gridPanel = new GridPanel(this.game.getBoard());
        this.jFrame.repaint();
    }


}
