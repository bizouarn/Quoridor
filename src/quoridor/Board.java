package quoridor;

// import project
import quoridor.Square;
//import GUI.MainGUI;

// import java
import java.util.ArrayList;

/**
 * Class for the initializing of the board.
 * Contains the grid and calls the GUI package to show the game
 * @author Pierre-Galaad 'P(x)' Naquet, Aymeric Bizouarn
 */
public class Board {

	private final int SIZE = 9;
	private ArrayList<Square> grid;

	/**
	 * Board constructor
	 * intiliaze a 81 squares board (9*9)
	 * Initialize walls and positionates players on their starting positions
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public Board() {
		initializeBoard();
		initializePlayers();
	}

	public Square getSquare(int x, int y) {
		Square ret = null;
		for (Square sqr : this.grid) {
			if ((sqr.getX() == x) && (sqr.getY() == y)) {
				ret = sqr;
			}
		}
		return ret;
	}

	public int getSIZE() {
		return this.SIZE;
	}

	public ArrayList<Square> getGrid() {
		return this.grid;
	}

	public Square getPlayer1Square() {
		Square ret = null;
		for (Square sqr : this.grid) {
			if (sqr.getStatus() == Status.Player1) {
				ret = sqr;
			}
		}
		return ret;
	}

	public Square getPlayer2Square() {
		Square ret = null;
		for (Square sqr : this.grid) {
			if (sqr.getStatus() == Status.Player2) {
				ret = sqr;
			}
		}
		return ret;
	}

	/**
	 * Board Initializer
	 * intiliaze a 81 squares board (9*9)
	 * Initialize walls and statuses
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public void initializeBoard() {
		this.grid = new ArrayList<Square>();
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				this.grid.add(new Square(x, y));
			}
		}
		for (Square sqr : grid) {
			sqr.refreshStatusFence();
		}

	}

	/**
	 * Board Initializer
	 * intiliaze a 81 squares board (9*9)
	 * Initialize players
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public void initializePlayers() {
		for (Square sqr : this.grid) {
			if ((sqr.getX() == 0) && (sqr.getY() == 4)) {
				sqr.setStatus(Status.Player1);
			}
			if ((sqr.getX() == 8) && (sqr.getY() == 4)) {
				sqr.setStatus(Status.Player2);
			}
		}
	}


	public ArrayList<Square> listOfPossibilitiesFence() {
		// TODO - implement HumanPlayer.play
		throw new UnsupportedOperationException();
	}

	/**
	 * When called return an array list of square containing all of pawns deplacement possibilities.
	 * @param player current turn player
	 * @param game current game played
	 * @return The ArrayList containing all the possibilities
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public ArrayList<Square> listOfPossibilitiesPawn(Player player, Game game) {
		Square currSqr;
		ArrayList<Square> ret = new ArrayList<Square>();
		if (player == game.getPlayer1()) {
			currSqr = getPlayer1Square();
			if (currSqr.getFenceN() == false) {
				ret.add(grid.getSquare)
			}
		}
		if (player == game.getPlayer2()) {

		}
		return ret;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				str =+ getSquare(i, j).toString() + "\t";
			}
			str =+ "\n";
		}
		return str;
	}

}
