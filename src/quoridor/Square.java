package quoridor;

// import Project
import quoridor.StatusFence;
import quoridor.Status;

//import java

/**
* Permits to launch a session from which can be launch and saved games
* @author Pierre-Galaad 'P(x)' Naquet, Aymeric Bizouarn
*/
public class Square {

	private int x;
	private int y;

	private Status status; // if it contains player 1 / player 2 or none

	private StatusFence statusFence; // gets it from the enumeration statusFence

	// true if there is a fence, false otherwise
	private boolean fenceN;
	private boolean fenceE;
	private boolean fenceS;
	private boolean fenceW;


	/**
	 * Square constructor
	 * Square object which is a square on the board.
	 * It knows its coordinates, if there is a player or not and if their is fences around him
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public Square(int x, int y) {
		this.x = x;
		this.y = y;

		this.fenceN = false;
		this.fenceS = false;
		this.fenceW = false;
		this.fenceE = false;

		if (x == 0) {
			this.fenceN = true;
		}
		if (x == 8) {
			this.fenceS = true;
		}
		if (y == 0) {
			this.fenceE = false;
		}
		if (y == 8) {
			this.fenceW = false;
		}
	}

	/**
	 * refreshes the status fence
	 * @author Pierre-Galaad 'P(x)' Naquet
	 */
	public void refreshStatusFence() {
		if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.NONE;
		}
		if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.N;
		}
		if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.NE;
		}
		if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.NS;
		}
		if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.NW;
		}
		if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.N;
		}
		if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.E;
		}
		if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.ES;
		}
		if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == true)) {
			this.statusFence = StatusFence.EW;
		}
		if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.S;
		}
		if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.SW;
		}
		if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.W;
		}
		if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.NES;
		}
		if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.NSW;
		}
		if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == true)) {
			this.statusFence = StatusFence.ESW;
		}
		if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == true)) {
			this.statusFence = StatusFence.NEW;
		}
		if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == true)) {
			this.statusFence = StatusFence.NESW;
		}
	}

	public StatusFence getStatusFence() {
		return this.statusFence;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status getStatus() {
		return this.status;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean getFenceN() {
		return this.fenceN;
	}

	public boolean getFenceE() {
		return this.fenceE;
	}

	public boolean getFenceS() {
		return this.fenceS;
	}

	public boolean getFenceW() {
		return this.fenceW;
	}

	public void setFenceE(boolean fenceE) {
		this.fenceE = fenceE;
	}

	public void setFenceN(boolean fenceN) {
		this.fenceN = fenceN;
	}

	public void setFenceS(boolean fenceS) {
		this.fenceS = fenceS;
	}

	public void setFenceW(boolean fenceW) {
		this.fenceW = fenceW;
	}

	public String toString() {
		return this.statusFence.toString();
	}
}
