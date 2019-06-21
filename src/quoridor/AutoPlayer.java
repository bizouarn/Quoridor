package quoridor;

import java.util.ArrayList;

/**
 * Class extending Player, invoked to create a bot
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class AutoPlayer extends Player {
    /**
     * AutoPlayer constructor
     *
     * @param name The player name.
     * @param game the current game.
     */
    public AutoPlayer(String name, Game game) {
        super(name, game);
    }

    /**
     * AI for the AutoPlayer
     * Choose between playFence and playPawn
     * Only one level of difficulty for now
     *
     * @author Aymeric Bizouarn
     */
    public void play() {

        boolean validGame = false;
        while (!validGame) {
            boolean playFence = autoPlayFence();
            validGame = playFence;
            if (!playFence) {
                validGame = autoPlayPawn();
            }
        }
    }

    /**
     * Method permitting the auto player to play a fence
     *
     * @return true if the auto player has placed a fence.
     * @author Aymeric Bizouarn
     */
    private boolean autoPlayFence() {
        boolean ret = false;
        Object[] playFence = getPlayFence();
        SubBoard sb = (SubBoard) playFence[0];
        int pos = (int) playFence[1];
        if (sb != null) {
            ret = playFence(sb.getSqrArray()[0].getX(), sb.getSqrArray()[0].getY(), sb.getSqrArray()[3].getX(), sb.getSqrArray()[3].getY(), pos);
        }
        return ret;
    }

    /**
     * Method permitting the auto player to move its pawn
     *
     * @return true if the auto player has move pawn.
     * @author Aymeric Bizouarn
     */
    private boolean autoPlayPawn() {
        ArrayList<Square> possibilitiesPawn = this.getGame().getBoard().listOfPossibilitiesPawn(this, this.getGame());
        int player;
        if (this == this.getGame().getPlayer1()) {
            player = 1;
        } else if (this == this.getGame().getPlayer2()) {
            player = 2;
        } else if (this == this.getGame().getPlayer3()) {
            player = 3;
        } else {
            player = 4;
        }
        Square res = possibilitiesPawn.get(0);
        int tmp = 81;
        for (Square sqr : possibilitiesPawn) {
            int tmp2 = this.getGame().getNbMinMove(sqr, player);
            if (tmp2 < tmp) {
                tmp = tmp2;
                res = sqr;
            }
        }
        boolean ret = playPawn(res.getX(), res.getY());
        if (!ret) {
            int random = (int) (Math.random() * possibilitiesPawn.size());
            playPawn(possibilitiesPawn.get(random).getX(), possibilitiesPawn.get(random).getY());
        }
        return ret;
    }

    /**
     * method permitting to check if the player is currently or not in the subBoard
     *
     * @param subBoard the subBoard currently checked
     * @param player   the number of the player
     * @return true if the player is in the subBoard, false otherwise
     * @author Aymeric Bizouarn
     */
    private boolean playerInSubBoard(SubBoard subBoard, int player) {
        boolean ret = false;
        Square sqrPlayer = null;
        if (player == 1) {
            sqrPlayer = this.getGame().getBoard().getPlayer1Square();
        } else if (player == 2) {
            sqrPlayer = this.getGame().getBoard().getPlayer2Square();
        }
        if (player == 3) {
            sqrPlayer = this.getGame().getBoard().getPlayer3Square();
        } else if (player == 4) {
            sqrPlayer = this.getGame().getBoard().getPlayer4Square();
        }
        if (sqrPlayer != null) {
            for (Square sqr : subBoard.getSqrArray()) {
                if (sqr.getX() == sqrPlayer.getX() && sqr.getY() == sqrPlayer.getY()) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    /**
     * Get the fences placement possibles during this turn and return minimal number of movement for each.
     *
     * @return The SubBoard of the fence and his position in Object[2]={SubBoard,fence}
     * @author Aymeric Bizouarn
     */
    private Object[] getPlayFence() {
        int pos = 2;
        SubBoard ret = null;
        Game game = this.getGame();
        Board board = game.getBoard();
        ArrayList<SubBoard> possibilitiesFenceH = board.listOfPossibilitiesFenceHorizontal();
        ArrayList<SubBoard> possibilitiesFenceV = board.listOfPossibilitiesFenceVertical();
        int player;
        Square playerSqr;
        int minMovePlayer;
        if (this.getGame().getNbPlayer() == 2) {
            if (this == game.getPlayer1()) {
                player = 2;
                playerSqr = game.getBoard().getPlayer2Square();
            } else {
                player = 1;
                playerSqr = game.getBoard().getPlayer1Square();
            }
            minMovePlayer = game.getNbMinMove(playerSqr, player);
        } else {
            if (this == game.getPlayer1()) {
                player = 2;
                playerSqr = game.getBoard().getPlayer2Square();
            } else if (this == game.getPlayer2()) {
                player = 1;
                playerSqr = game.getBoard().getPlayer1Square();
            } else if (this == game.getPlayer3()) {
                player = 4;
                playerSqr = game.getBoard().getPlayer4Square();
            } else {
                player = 3;
                playerSqr = game.getBoard().getPlayer3Square();
            }
            minMovePlayer = game.getNbMinMove(playerSqr, player);
        }
        int max = 0;
        for (SubBoard sb : possibilitiesFenceH) {
            if (playerInSubBoard(sb, player)) {
                sb.setHorizontalFence(true);
                Square[] sqrArray = sb.getSqrArray();
                sqrArray[0].setFenceS(true);
                sqrArray[1].setFenceS(true);
                sqrArray[2].setFenceN(true);
                sqrArray[3].setFenceN(true);
                int tmpVal = game.getNbMinMove(playerSqr, player);
                if (tmpVal > minMovePlayer) {
                    if (tmpVal > max) {
                        max = tmpVal;
                        pos = 1;
                        ret = sb;
                    }
                }
                sb.setHorizontalFence(false);
                sqrArray[0].setFenceS(false);
                sqrArray[1].setFenceS(false);
                sqrArray[2].setFenceN(false);
                sqrArray[3].setFenceN(false);
            }
        }
        for (SubBoard sb : possibilitiesFenceV) {
            if (playerInSubBoard(sb, player)) {
                sb.setVerticalFence(true);
                Square[] sqrArray = sb.getSqrArray();
                sqrArray[0].setFenceE(true);
                sqrArray[1].setFenceW(true);
                sqrArray[2].setFenceE(true);
                sqrArray[3].setFenceW(true);
                int tmpVal = game.getNbMinMove(playerSqr, player);
                if (tmpVal > max) {
                    max = tmpVal;
                    pos = 2;
                    ret = sb;
                }
                sb.setVerticalFence(false);
                sqrArray[0].setFenceE(false);
                sqrArray[1].setFenceW(false);
                sqrArray[2].setFenceE(false);
                sqrArray[3].setFenceW(false);
            }
        }
        if (max == game.getNbMinMove(playerSqr, player)) {
            ret = null;
        }
        Object[] res = {ret, pos};
        return res;
    }
}
