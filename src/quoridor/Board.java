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

	private int SIZE = 9;
	private ArrayList<Square> grid;

	/**
	 * Board constructor
	 * intiliaze a 81 squares board (9*9)
	 * Initialize walls and positionates players on their starting positions
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public Board() {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				grid.add(x, y);
			}
		}
		for (Square sqr : grid) {
			sqr.refreshStatusFence();
		}
	}

	public int getSIZE() {
		// TODO - implement Board.getSIZE
		throw new UnsupportedOperationException();
	}

	public ArrayList<Square> getGrid() {
		// TODO - implement Board.getGrid
		throw new UnsupportedOperationException();
	}

	public void initializeBoard() {
		// TODO - implement Board.initializeBoard
		throw new UnsupportedOperationException();
	}

	public ArrayList<Square> listOfPossibilitiesFence() {
		// TODO - implement Board.listOfPossibilitiesFence
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param player
	 */
	public ArrayList<Square> listOfPossibilitiesPawn(Player player) {
		// TODO - implement Board.listOfPossibilitiesPawn
		throw new UnsupportedOperationException();
	}

	public String toString() {
		// TODO - implement Board.toString
		throw new UnsupportedOperationException();
	}

}
