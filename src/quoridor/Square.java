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
			this.fenceW = true;
		}
		if (y == 8) {
			this.fenceE = true;
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
		else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.N;
		}
		else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.NE;
		}
		else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.NS;
		}
		else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.NW;
		}
		else if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.E;
		}
		else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.ES;
		}
		else if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == true)) {
			this.statusFence = StatusFence.EW;
		}
		else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == false)) {
			this.statusFence = StatusFence.S;
		}
		else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.SW;
		}
		else if ((this.fenceN == false) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.W;
		}
		else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == false) && (this.fenceE == true)) {
			this.statusFence = StatusFence.NES;
		}
		else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == false)) {
			this.statusFence = StatusFence.NSW;
		}
		else if ((this.fenceN == false) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == true)) {
			this.statusFence = StatusFence.ESW;
		}
		else if ((this.fenceN == true) && (this.fenceS == false) && (this.fenceW == true) && (this.fenceE == true)) {
			this.statusFence = StatusFence.NEW;
		}
		else if ((this.fenceN == true) && (this.fenceS == true) && (this.fenceW == true) && (this.fenceE == true)) {
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
		String ret = this.statusFence.toString();
	 	if (this.status != Status.NONE) {
			ret += "Player";
		}
		return ;
	}
}
