package quoridor;

// import project


// import java

import controller.GuiListener;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classes invoked when it is a human player turn
 *
 * @author Aymeric Bizouarn , Pierre-Galaad Naquet
 */
public class HumanPlayer extends Player {

    /**
     * HumanPlayer constructor
     *
     * @param name The player name.
     * @param game The current game.
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
            if (this.getGame().getGui()) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.err.println("Humman player (play()): " + e);
                }
                GuiListener guiListener = this.getGame().getGuiFrame().getGuiListener();
                boolean condition = guiListener.getValue();
                if (condition) {
                    guiListener.setValue(false);
                    int x1 = guiListener.getX1();
                    int x2 = guiListener.getX2();
                    int y1 = guiListener.getY1();
                    int y2 = guiListener.getY2();
                    int pos;
                    if (guiListener.getHorizontal()) {
                        pos = 2;
                    } else {
                        pos = 1;
                    }
                    if (!guiListener.getFence()) {
                        for (Square sqr : possibilitiesPawn) {
                            if (sqr.getX() == x1 && sqr.getY() == y1) {
                                validPlay = playPawn(x1, y1);
                            }
                        }
                    } else {
                        ArrayList<SubBoard> possibilitiesFence = null;
                        if (pos == 1) {
                            possibilitiesFence = possibilitiesFenceH;
                        } else if (pos == 2) {
                            possibilitiesFence = possibilitiesFenceV;
                        }
                        for (SubBoard sb : possibilitiesFence) {
                            Square[] sqrArray = sb.getSqrArray();
                            if (sqrArray[0].getX() == x1 && sqrArray[0].getY() == y1 && sqrArray[3].getX() == x2 && sqrArray[3].getY() == y2) {
                                if (pos == 1 && !sb.getHorizontalFence()) {
                                    validPlay = playFence(x1, y1, x2, y2, pos);
                                } else if (pos == 2 && !sb.getVerticalFence()) {
                                    validPlay = playFence(x1, y1, x2, y2, pos);
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("Write : \n1 - For play pawn\n2 - For play fence\n3 - For save game & quit");
                String choix = sc.nextLine() + "";
                if (choix.equals("1")) {
                    for (Square sqr : possibilitiesPawn) {
                        System.out.print(sqr);
                        if (sqr != null) {
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
                                validPlay = playPawn(x, y);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input !");
                    }
                } else if (choix.equals("2")) {
                    try {
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
                        if (pos == 1) {
                            possibilitiesFence = possibilitiesFenceH;
                        } else if (pos == 2) {
                            possibilitiesFence = possibilitiesFenceV;
                        }
                        for (SubBoard sb : possibilitiesFence) {
                            Square[] sqrArray = sb.getSqrArray();
                            if (sqrArray[0].getX() == x1 && sqrArray[0].getY() == y1 && sqrArray[3].getX() == x2 && sqrArray[3].getY() == y2) {
                                if (pos == 1 && !sb.getHorizontalFence()) {
                                    validPlay = playFence(x1, y1, x2, y2, pos);
                                } else if (pos == 2 && !sb.getVerticalFence()) {
                                    validPlay = playFence(x1, y1, x2, y2, pos);
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input !");
                    }
                } else if (choix.equals("3")) {
                    this.getGame().saveGame();
                }
            }
        }
    }
}
