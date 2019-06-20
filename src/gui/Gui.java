package gui;

import quoridor.Game;
import quoridor.Player;

import javax.swing.*;
import java.awt.*;

public class Gui implements java.io.Serializable{
    private GuiListener guiListener = new GuiListener(this);

    private PlayerPanel playerPanel1;
    private PlayerPanel playerPanel2;
    private LeftPlayers leftPlayers;
    private ToolBar toolBar;
    private GridPanel gridPanel;

    private Game game;
    private JFrame jFrame;

    public Gui(Game game){
        this.game = game;

        this.jFrame = new JFrame("Quoridor");
        this.gridPanel = new GridPanel(game.getBoard(),this);
        this.playerPanel1 = new PlayerPanel(game.getPlayer1());
        this.playerPanel2 = new PlayerPanel(game.getPlayer2());
        this.toolBar = new ToolBar(this);
        this.leftPlayers = new LeftPlayers(this.game.getPlayer1(),this.game.getPlayer2());
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAndShowGui();
            }
        });
    }

    public void CreateAndShowGui(){
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.jFrame.add(this.gridPanel, BorderLayout.CENTER);
        this.jFrame.add(this.leftPlayers, BorderLayout.WEST);
        this.jFrame.add(this.toolBar,BorderLayout.SOUTH);

        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }

    public void refresh(){
        this.leftPlayers.refresh(this.game.getPlayer1().checkNbRestingFences(),this.game.getPlayer2().checkNbRestingFences());
        this.gridPanel.refresh();
        this.jFrame.repaint();
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }

    public ToolBar getToolBar() {
        return toolBar;
    }

    public GuiListener getGuiListener() {
        return guiListener;
    }

    public Game getGame() {
      return this.game;
    }

    public JFrame getjFrame() {
        return this.jFrame;
    }
}
