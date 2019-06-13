package quoridor;

// import project
import quoridor.Board;
import quoridor.Mode;
import quoridor.Player;

// import java
import java.util.Scanner;

/**
 * This class contains the methods to initialize the game
 * @author
 */
public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Mode mode;

	private Scanner scan;

	/**
	 * Game constructor
	 * intiliaze the board, the two players and the mode
	 * The mode is choosen by the players with a scanner
	 * @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
	 */
	public Game() {
		// TODO - implement Game.Game
		throw new UnsupportedOperationException();
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
		if(name.indexOf("auto")!=-1){
			this.player1 = new AutoPlayer(name,this.board);
		} else {
			this.player1 = new HumanPlayer(name,this.board);
		}
		System.out.println("Name Player 2 : ");
		name = scanner.nextLine();
		if(name.indexOf("auto")!=-1){
			this.player1 = new AutoPlayer(name,this.board);
		} else {
			this.player1 = new HumanPlayer(name,this.board);
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
		// TODO - implement Game.start
		throw new UnsupportedOperationException();
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
