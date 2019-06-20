package gui;

import quoridor.Game;
import quoridor.Player;

import javax.swing.*;
import java.awt.*;

/**
 * The main game frame, this frame contains the board
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class Gui implements java.io.Serializable{
    private GuiListener guiListener = new GuiListener(this);

    private PlayerPanel playerPanel1;
    private PlayerPanel playerPanel2;
    private LeftPlayers leftPlayers;
    private ToolBar toolBar;
    private GridPanel gridPanel;

    private Game game;
    private JFrame jFrame;


    /**
     * Gui (Main game frame) constructor
     * @param game The current Game
     * @author Aymeric Bizouarn
     */
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

    /**
     * set the BorderLayout
     * @author Aymeric Bizouarn
     */
    private void CreateAndShowGui(){
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.jFrame.add(this.gridPanel, BorderLayout.CENTER);
        this.jFrame.add(this.leftPlayers, BorderLayout.WEST);
        this.jFrame.add(this.toolBar,BorderLayout.SOUTH);

        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }

    /**
     * refresh the whole gui
     * @author Aymeric Bizouarn
     */
    public void refresh(){
        this.leftPlayers.refresh(this.game.getPlayer1().checkNbRestingFences(),this.game.getPlayer2().checkNbRestingFences());
        this.gridPanel.refresh();
        this.jFrame.repaint();
    }

    /**
     * Return the current grid panel
     * @return the current grid panel
     */
    public GridPanel getGridPanel() {
        return this.gridPanel;
    }

    /**
     * Return the gui's toolBar
     * @return the toolBar
     */
    public ToolBar getToolBar() {
        return this.toolBar;
    }

    /**
     * Return the gui's guiListener
     * @return the guiListener
     */
    public GuiListener getGuiListener() {
        return this.guiListener;
    }

    /**
     * Return the current Game
     * @return the current Game
     */
    public Game getGame() {
      return this.game;
    }

    /**
     * Return the current frame
     * @return the current frame
     */
    public JFrame getjFrame() {
        return this.jFrame;
    }
}
