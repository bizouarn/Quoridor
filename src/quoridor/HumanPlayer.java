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
        ArrayList<SubBoard> possibilitiesFenceH = this.getGame().getBoard().listOfPossibilitiesFenceHorizontal();
        ArrayList<SubBoard> possibilitiesFenceV = this.getGame().getBoard().listOfPossibilitiesFenceVertical();
        Scanner sc = new Scanner(System.in);
        boolean validPlay = false;
        while (!validPlay) {
            System.out.println("Write : \n1 - For play pawn\n2 - For play fence");
            String choix = sc.nextLine()+"";
            if (choix.equals("1")) {
                for (Square sqr : possibilitiesPawn) {
                    System.out.print(sqr);
                    if(sqr != null) {
                        System.out.print("(" + sqr.getX() + ";" + sqr.getY() + ")");
                    }
                }
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
                } catch (Exception e) {
                    System.out.println("Invalid input !");
                }
            } else if (choix.equals("2")) {
                try{
                    System.out.print(" x : ");
                    int x1 = Integer.parseInt(sc.nextLine());
                    System.out.print(" y : ");
                    int y1 = Integer.parseInt(sc.nextLine());
                    System.out.print(" x : ");
                    int x2 = Integer.parseInt(sc.nextLine());
                    System.out.print(" y : ");
                    int y2 = Integer.parseInt(sc.nextLine());
                    System.out.print(" 1- Horizontal ; 2 - Vertical :");
                    int pos = Integer.parseInt(sc.nextLine());
                    ArrayList<SubBoard> possibilitiesFence = null;
                    if(pos == 1){
                        possibilitiesFence = possibilitiesFenceH;
                    } else if(pos == 2) {
                        possibilitiesFence = possibilitiesFenceV;
                    }
                    for(SubBoard sb : possibilitiesFence){
                        Square[] sqrArray= sb.getSqrArray();
                        if(sqrArray[0].getX()==x1 && sqrArray[0].getY()==y1 && sqrArray[3].getX()==x2 && sqrArray[3].getY()==y2){
                            if(pos == 1 && !sb.getHorizontalFence()) {
                                playFence(x1,y1,x2,y2,pos);
                                validPlay = true;
                            } else if(pos == 2 && !sb.getVerticalFence()){
                                playFence(x1,y1,x2,y2,pos);
                                validPlay = true;
                            }
                        }
                    }
                }
                catch (Exception e){
                    System.out.println("Invalid input !");
                }
            }
        }
    }

    /**
     * Places a fence on the desired emplacement
     * The overlapping validity is checked by the square object by fenceStatus
     * The path validity is checked by the checkExistingPath method
     *
     * @author Aymeric Bizouarn
     */
    private void playFence(int x1, int y1, int x2,int y2, int pos) {
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
     *
     * @author Aymeric Bizouarn
     */
    private void playPawn(int x,int y) {
        if (this.getGame().getPlayer1() == this) {
            this.getGame().getBoard().getPlayer1Square().setStatus(Status.NONE);
            this.getGame().getBoard().getSquare(x,y).setStatus(Status.Player1);
        } else if (this.getGame().getPlayer2() == this) {
            this.getGame().getBoard().getPlayer1Square().setStatus(Status.NONE);
            this.getGame().getBoard().getSquare(x,y).setStatus(Status.Player2);
        }
    }
}
