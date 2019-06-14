package quoridor;

// import project


// import java

import java.util.ArrayList;
import java.util.Scanner;


public class HumanPlayer extends Player {

    /**
     * HumanPlayer constructor
     *
     * @param name The player name.
     * @author Aymeric Bizouarn
     */
    public HumanPlayer(String name, Game game) {
        super(name, game);
    }

    /**
     * Let the player choose between if he wants to play a fence or moves its pawn
     *
     * @author Aymeric Bizouarn
     */
    public void play() {
        ArrayList<Square> possibilitiesPawn = this.getGame().getBoard().listOfPossibilitiesPawn(this, this.getGame());
        Scanner sc = new Scanner(System.in);
        boolean validPlay = false;
        while (!validPlay) {
            System.out.println("Write : \n1 - For play pawn\n2 - For play fence");
            if (sc.nextLine().equals("1")) {
                try {
                    System.out.print(" x : ");
                    int x = Integer.parseInt(sc.nextLine());
                    System.out.print(" y : ");
                    int y = Integer.parseInt(sc.nextLine());
                    for (Square sqr : possibilitiesPawn) {
                        if (sqr.getX() == x && sqr.getY() == y) {
                            playPawn(x,y);
                            validPlay = true;
                        }
                    }
                } catch (Exception e) { }
            } else if (sc.nextLine().equals("2")) {

            }
        }
    }

    /**
     * Places a fence on the desired emplacement
     * The overlapping validity is checked by the square object by fenceStatus
     * The path validity is checked by the checkExistingPath method
     *
     * @author
     */
    private void playFence() {
        // TODO - implement AutoPlayer.playFence
        throw new UnsupportedOperationException();
    }

    /**
     * Moves the pawns to the desired direction.
     * The validity is checked by the current square fenceStatus
     *
     * @author
     */
    private void playPawn(int x,int y) {
        if (this.getGame().getPlayer1() == this) {
            this.getGame().getBoard().getPlayer1Square().setStatus(Status.NONE);
            this.getGame().getBoard().getSquare(x,y).setStatus(Status.Player1);
        } else if (this.getGame().getPlayer1() == this) {
            this.getGame().getBoard().getPlayer1Square().setStatus(Status.NONE);
            this.getGame().getBoard().getSquare(x,y).setStatus(Status.Player2);
        }
    }
}
