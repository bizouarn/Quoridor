package quoridor;

// import project
import quoridor.Board;
import quoridor.Mode;
import quoridor.Player;

// import java
import java.util.Scanner;

/**
 * This class contains the methods to initialize the game
 * @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
 */
public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Mode mode;

	/**
	 * Game constructor
	 * intiliaze the board, the two players and the mode
	 * The mode is choosen by the players with a scanner
	 * @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
	 */
	public Game() {
		initializeGame();
		start();
		endOfGame();
	}

	public Board getBoard() {
		return this.board;
	}

	public Player getPlayer1() {
		return this.player1;
	}

	public Player getPlayer2() {
		return this.player2;
	}

	/**
	 * Set the Game Board.
	 * @param board the desired board to play the game with.
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

	/**
	 * Initialize the game.
	 */
	public void initializeGame() {
		this.board = new Board();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name Player 1 : ");
		String name = scanner.nextLine();
		if(name.contains("auto")){
			this.player1 = new AutoPlayer(name,this);
		} else {
			this.player1 = new HumanPlayer(name,this);
		}
		System.out.println("Name Player 2 : ");
		name = scanner.nextLine();
		if(name.contains("auto")){
			this.player2 = new AutoPlayer(name,this);
		} else {
			this.player2 = new HumanPlayer(name,this);
		}
	}

	/**
	 * Choose randomly which player plays first
	 * @return the starting player
	 */
	public Player whoStarts() {
		int random = (int)(Math.random()*100);
		Player ret;
		if(random<=50){
			ret = this.player1;
		} else {
			ret = this.player2;
		}
		return ret;
	}

	/**
	 * Launch the game
	 */
	public void start() {
		Player playerWhoStart = this.whoStarts();
		int playerPlay = 1; //1 = for player1 play & 2 = for player2
		if(playerWhoStart == this.player1){
            playerPlay = 1;
        }else if(playerWhoStart == this.player2){
            playerPlay = 2;
        }
		while (!checkEndOfGame()){
		    Player playerActual = null;
		    if(playerPlay == 1){
		        playerActual = this.player1;
            } else if(playerPlay == 2) {
                playerActual = this.player2;
            }
		    System.out.println(this.board);
			System.out.println(playerActual.getName()+" : ");
		    playerActual.play();
		    playerPlay ++;
		    if(playerPlay > 2){playerPlay = 1;}
        }
	}

    /**
     * Check if the game was finish.
     * @return True if the game was finish.
     */
	public boolean checkEndOfGame(){
        boolean ret = false;
		if(this.board.getPlayer1Square().getY()==8){
			ret = true;
		} else if(this.board.getPlayer1Square().getY()==0){
			ret = true;
		}
        return ret;
    }
	/**
	 * End the game and launch the results procedure
	 */
	public void endOfGame() {
		// TODO - implement Game.endOfGame
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Game.toString
		throw new UnsupportedOperationException();
	}

}
