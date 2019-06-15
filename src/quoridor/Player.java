package quoridor;

import java.util.ArrayList;

/**
 * Make the player object for make action in the game.
 * @author Pierre-Galaad 'P(x)' Naquet, Aymeric Bizouarn
 */
public abstract class Player {
    /**
     * The Game
     */
    private Game game;
    /**
     * The player Name.
     */
    private String name;
    /**
     * The player nbFences.
     */
    private int nbFences;

    /**
     * Player constructor
     * it cans either be human or bot
     * it has a dedidcated pawn and a number of fences left.
     * @author Aymeric Bizouarn
     */
    public Player(String name,Game game) {
        this.name = name;
        this.nbFences = 10;
        this.game = game;
    }

    /**
     * Make player play.
     */
    public abstract void play();

    /**
     * Return the player name.
     * @return The player name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return number of player fence remaining.
     * @return the number of fences left playable by the player
     */
    public int checkNbRestingFences() {
        return this.nbFences;
    }

    /**
     * Set Player nbFences.
     * @param nbFences The player nbFences.
     */
    public void setNbFences(int nbFences) {
        this.nbFences = nbFences;
    }

    /**
     * Return the game run actually.
     * @return The game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Places a fence on the desired emplacement
     * The overlapping validity is checked by the square object by fenceStatus
     * The path validity is checked by the checkExistingPath method
     * @author Aymeric Bizouarn
     */
    protected void playFence(int x1, int y1, int x2,int y2, int pos) {
        ArrayList<SubBoard> possibilitiesFence = null;
        if(pos == 1){
            possibilitiesFence = this.getGame().getBoard().listOfPossibilitiesFenceHorizontal();
        } else if(pos == 2) {
            possibilitiesFence = this.getGame().getBoard().listOfPossibilitiesFenceVertical();
        }
        for(SubBoard sb : possibilitiesFence){
            Square[] sqrArray= sb.getSqrArray();
            if(sqrArray[0].getX()==x1 && sqrArray[0].getY()==y1 && sqrArray[3].getX()==x2 && sqrArray[3].getY()==y2){
                if(pos == 1 && !sb.getHorizontalFence()) {
                    sb.setHorizontalFence(true);
                    sqrArray[0].setFenceS(true);
                    sqrArray[1].setFenceS(true);
                    sqrArray[2].setFenceN(true);
                    sqrArray[3].setFenceN(true);
                } else if(pos == 2 && !sb.getVerticalFence()){
                    sb.setVerticalFence(true);
                    sqrArray[0].setFenceE(true);
                    sqrArray[1].setFenceW(true);
                    sqrArray[2].setFenceE(true);
                    sqrArray[3].setFenceW(true);
                }
                for(int k = 0;k<sqrArray.length;k++) {
                    sqrArray[k].refreshStatusFence();
                }
            }
        }
    }

    /**
     * Moves the pawns to the desired direction.
     * The validity is checked by the current square fenceStatus
     * @author Aymeric Bizouarn
     */
    protected void playPawn(int x,int y) {
        if (this.getGame().getPlayer1() == this) {
            this.getGame().getBoard().getPlayer1Square().setStatus(Status.NONE);
            this.getGame().getBoard().getSquare(x,y).setStatus(Status.Player1);
        } else if (this.getGame().getPlayer2() == this) {
            this.getGame().getBoard().getPlayer2Square().setStatus(Status.NONE);
            this.getGame().getBoard().getSquare(x,y).setStatus(Status.Player2);
        }
    }
}
