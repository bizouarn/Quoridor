package quoridor;

import java.util.ArrayList;

/**
 * An Extend of Player make for play automatically.
 */
public class AutoPlayer extends Player {
    /**
     * AutoPlayer constructor
     *
     * @param name The player name.
     */
    public AutoPlayer(String name, Game game) {
        super(name, game);
    }

    /**
     * AI for the AutoPlayer
     * Choose between playFence and playPawn
     * Only one level of difficulty for now
     */
    public void play() {
        int p1 = this.getGame().getNbMinMove(this.getGame().getBoard().getPlayer1Square(), 1);
        int p2 = this.getGame().getNbMinMove(this.getGame().getBoard().getPlayer2Square(), 2);
        boolean contition = true;
        if (this == this.getGame().getPlayer1()) {
            if (p2 < p1) {
                contition = false;
            }
        } else {
            if (p1 < p2) {
                contition = false;
            }
        }
        boolean ret =false;
        if (this == this.getGame().getPlayer1()) {
            if (this.getGame().getBoard().getPlayer1Square().getX() == 1 && this.getGame().getBoard().getPlayer1Square().getY() == 4) {
                ArrayList<SubBoard> possibilitiesFenceH = this.getGame().getBoard().listOfPossibilitiesFenceHorizontal();
                Square sqr = this.getGame().getBoard().getSquare(0,4);
                for(SubBoard sb : possibilitiesFenceH){
                    if(this.getGame().getBoard().getSubBoard(0,4)==sb) {
                        System.out.println("|" + this.checkNbRestingFences());
                        ret = playFence(sqr.getX(), sqr.getY(), sqr.getX() + 1, sqr.getY() + 1, 1);
                        System.out.println("|" + this.checkNbRestingFences() + ret);
                    }
                }
            }
        } else if (this == this.getGame().getPlayer2()) {
            if (this.getGame().getBoard().getPlayer2Square().getX() == 7 && this.getGame().getBoard().getPlayer2Square().getY() == 4) {
                ArrayList<SubBoard> possibilitiesFenceH = this.getGame().getBoard().listOfPossibilitiesFenceHorizontal();
                Square sqr = this.getGame().getBoard().getSquare(7,4);
                for(SubBoard sb : possibilitiesFenceH){
                    if(this.getGame().getBoard().getSubBoard(7,4)==sb) {
                        System.out.println("|" + this.checkNbRestingFences());
                        ret = playFence(sqr.getX(), sqr.getY(), sqr.getX() + 1, sqr.getY() + 1, 1);
                        System.out.println("|" + this.checkNbRestingFences() + ret);
                    }
                }
            }
        }
        if(!ret) {
            if (contition) {
                autoPlayPawn();
            } else {
                if (!autoPlayFence()) {
                    autoPlayPawn();
                }
            }
        }
    }

    private boolean autoPlayFence() {
        boolean ret = false;
        if (!ret) {
            int pos = 2;
            Object[] playFence = getPlayFence(pos);
            SubBoard sb = (SubBoard) playFence[0];
            pos = (int) playFence[1];
            if (sb != null) {
                ret = playFence(sb.getSqrArray()[0].getX(), sb.getSqrArray()[0].getY(), sb.getSqrArray()[3].getX(), sb.getSqrArray()[3].getY(), pos);
            }
        }
        return ret;
    }

    private void autoPlayPawn() {
        ArrayList<Square> possibilitiesPawn = this.getGame().getBoard().listOfPossibilitiesPawn(this, this.getGame());
        int player;
        if (this == this.getGame().getPlayer1()) {
            player = 1;
        } else {
            player = 2;
        }
        Square res = possibilitiesPawn.get(0);
        int tmp = 81;
        for (Square sqr : possibilitiesPawn) {
            ArrayList<String> listSquare = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    listSquare.add(i + "," + j);
                }
            }
            int tmp2 = this.getGame().getNbMinMove(sqr, player);
            if (tmp2 < tmp) {
                tmp = tmp2;
                res = sqr;
            }
        }
        playPawn(res.getX(), res.getY());
    }

    private boolean playerInSubBoard(SubBoard subBoard, int player) {
        boolean ret = false;
        Square sqrPlayer = null;
        if (player == 1) {
            sqrPlayer = this.getGame().getBoard().getPlayer1Square();
        } else if (player == 2) {
            sqrPlayer = this.getGame().getBoard().getPlayer2Square();
        }
        for (Square sqr : subBoard.getSqrArray()) {
            if (sqr.getX() == sqrPlayer.getX() && sqr.getY() == sqrPlayer.getY()) {
                ret = true;
            }
        }
        return ret;
    }

    private int MinMovePlayFence(SubBoard sb, int pos, Square playerSqr, int player) {
        int ret = 82;
        Square square1;
        if (pos == 1) {
            sb.setHorizontalFence(true);
            sb.getSqrArray()[0].setFenceS(true);
            sb.getSqrArray()[1].setFenceS(true);
            sb.getSqrArray()[2].setFenceN(true);
            sb.getSqrArray()[3].setFenceN(true);
        } else if (pos == 2) {
            sb.setVerticalFence(true);
            sb.getSqrArray()[0].setFenceE(true);
            sb.getSqrArray()[1].setFenceW(true);
            sb.getSqrArray()[2].setFenceE(true);
            sb.getSqrArray()[3].setFenceW(true);
        }
        ret = this.getGame().getNbMinMove(playerSqr, player);
        if (pos == 1) {
            sb.setHorizontalFence(false);
            sb.getSqrArray()[0].setFenceS(false);
            sb.getSqrArray()[1].setFenceS(false);
            sb.getSqrArray()[2].setFenceN(false);
            sb.getSqrArray()[3].setFenceN(false);
        } else if (pos == 2) {
            sb.setVerticalFence(false);
            sb.getSqrArray()[0].setFenceE(false);
            sb.getSqrArray()[1].setFenceW(false);
            sb.getSqrArray()[2].setFenceE(false);
            sb.getSqrArray()[3].setFenceW(false);
        }
        return ret;
    }

    private Object[] getPlayFence(int pos) {
        SubBoard ret = null;
        Game game = (Game) ((Object) (this.getGame()));
        Board board = game.getBoard();
        ArrayList<SubBoard> possibilitiesFenceH = board.listOfPossibilitiesFenceHorizontal();
        ArrayList<SubBoard> possibilitiesFenceV = board.listOfPossibilitiesFenceVertical();
        int player;
        Square playerSqr = null;
        if (this == game.getPlayer1()) {
            player = 2;
            playerSqr = game.getBoard().getPlayer2Square();
        } else {
            player = 1;
            playerSqr = game.getBoard().getPlayer1Square();
        }
        int max = 0;
        for (SubBoard sb : possibilitiesFenceH) {
            if (playerInSubBoard(sb, player)) {
                int tmpVal = game.getNbMinMove(playerSqr, player);
                sb.setHorizontalFence(true);
                Square[] sqrArray = sb.getSqrArray();
                sqrArray[0].setFenceS(true);
                sqrArray[1].setFenceS(true);
                sqrArray[2].setFenceN(true);
                sqrArray[3].setFenceN(true);
                if (tmpVal > max) {
                    max = tmpVal;
                    pos = 1;
                    ret = sb;
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
                System.out.println("(" + sb.getX() + "," + sb.getY() + ")");
                sb.setVerticalFence(true);
                Square[] sqrArray = sb.getSqrArray();
                sqrArray[0].setFenceE(true);
                sqrArray[1].setFenceW(true);
                sqrArray[2].setFenceE(true);
                sqrArray[3].setFenceW(true);
                int tmpVal = game.getNbMinMove(playerSqr, player);
                System.out.println("val :" + tmpVal);
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
        System.out.println(">" + game.getNbMinMove(playerSqr, player));
        if (max == game.getNbMinMove(playerSqr, player)) {
            System.out.println("null");
            ret = null;
        }
        Object[] res = {ret, pos};
        return res;
    }
}
