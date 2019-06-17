package gui;

import quoridor.Game;
import quoridor.Player;

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
        this.jFrame = new JFrame("Quoridor");

        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.gridPanel = new GridPanel(game.getBoard());
        this.playerPanel1 = new PlayerPanel(game.getPlayer1());
        this.playerPanel2 = new PlayerPanel(game.getPlayer2());

        this.jFrame.add(this.gridPanel, BorderLayout.CENTER);
        this.jFrame.add(this.playerPanel1, BorderLayout.WEST);
        this.jFrame.add(this.playerPanel2, BorderLayout.EAST);

        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }

    public void refresh(){

    }


}
