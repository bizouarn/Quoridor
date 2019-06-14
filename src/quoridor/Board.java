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
	private ArrayList<SubBoard> subBoards = new ArrayList<SubBoard>();

	/**
	 * Board constructor
	 * intiliaze a 81 squares board (9*9)
	 * Initialize walls and positionates players on their starting positions
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public Board() {
		initializeBoard();
		initializePlayers();
		initializeSubBoards();
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

	public SubBoard getSubBoard(int x, int y) {
		SubBoard ret = null;
		for (SubBoard subBoard : this.subBoards) {
			if ((subBoard.getX() == x) && (subBoard.getY() == y)) {
				ret = subBoard;
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

	public void initializeSubBoards() {
		Square[] sqrArray = new Square[4];
		Square sqr1;
		Square sqr2;
		Square sqr3;
		Square sqr4;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				sqr1 = this.getSquare(x, y);
				sqr2 = this.getSquare(x, y+1);
				sqr3 = this.getSquare(x+1, y);
				sqr4 = this.getSquare(x+1, y+1);
				sqrArray[0] = sqr1;
				sqrArray[1] = sqr2;
				sqrArray[2] = sqr3;
				sqrArray[3] = sqr4;
				this.subBoard.add(sqrArray);
			}
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


	public ArrayList<SubBoard> listOfPossibilitiesFenceVertical() {
		ArrayList<SubBoard> ret = new ArrayList<SubBoard>();
		boolean bool;
		for (SubBoard subBoard : subBoards) {
			bool = true;
			if ((subBoard.getHorizontalFence() == true) || (subBoard.getVerticalFence() == true)  {
				bool = false;
			}
			if (getSubBoard(subBoard.getX() + 1, subBoard.getY()) != null) {
				if (getSubBoard(subBoard.getX() + 1, subBoard.getY()).getVerticalFence() == true) {
					bool = false;
				}
			}
			if (getSubBoard(subBoard.getX() - 1, subBoard.getY()) != null) {
				if (getSubBoard(subBoard.getX() - 1, subBoard.getY()).getVerticalFence() == true) {
					bool = false;
				}
			}
			if (bool == true) {
				ret.add(subBoard);
			}
		}
		return ret;
	}

	public ArrayList<SubBoard> listOfPossibilitiesFenceHorizontal() {
		ArrayList<SubBoard> ret = new ArrayList<SubBoard>();
		boolean bool;
		for (SubBoard subBoard : subBoards) {
			bool = true;
			if ((subBoard.getVerticalFence() == true) || (subBoard.getHorizontalFence() == true)  {
				bool = false;
			}
			if (getSubBoard(subBoard.getX(), subBoard.getY() + 1) != null) {
				if (getSubBoard(subBoard.getX(), subBoard.getY() + 1).getHorizontalFence() == true) {
					bool = false;
				}
			}
			if (getSubBoard(subBoard.getX(), subBoard.getY() - 1) != null) {
				if (getSubBoard(subBoard.getX(), subBoard.getY() - 1).getHorizontalFence() == true) {
					bool = false;
				}
			}
			if (bool == true) {
				ret.add(subBoard);
			}
		}
		return ret;
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
		}
		else if (player == game.getPlayer2()) {
			currSqr = getPlayer2Square();
		}
		if (currSqr.getFenceN() == false) {
			ret.add(this.getSquare(currSqr.getX() - 1, currSqr.getY()));
		}
		if (currSqr.getFenceE() == false) {
			ret.add(this.getSquare(currSqr.getX(), currSqr.getY() - 1));
		}
		if (currSqr.getFenceS() == false) {
			ret.add(this.getSquare(currSqr.getX() + 1, currSqr.getY()));
		}
		if (currSqr.getFenceW() == false) {
			ret.add(this.getSquare(currSqr.getX(), currSqr.getY() + 1));
		}
		return ret;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				str += getSquare(i, j).toString() + "\t";
			}
			str += "\n";
		}
		return str;
	}

}
