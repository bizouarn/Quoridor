package quoridor;

import java.util.ArrayList;

/**
 * An Extend of Player make for play automatically.
 */
public class AutoPlayer extends Player {
	/**
	 * AutoPlayer constructor
	 * @param name The player name.
	 */
	public AutoPlayer(String name,Game game) {
		super(name,game);
	}

	/**
	 * AI for the AutoPlayer
	 * Choose between playFence and playPawn
	 * Only one level of difficulty for now
	 *
	 */
	public void play() {
		try {
			Thread.sleep(1000);
		} catch (Exception e){}

		ArrayList<Square> possibilitiesPawn = this.getGame().getBoard().listOfPossibilitiesPawn(this, this.getGame());
		ArrayList<SubBoard> possibilitiesFenceH = this.getGame().getBoard().listOfPossibilitiesFenceHorizontal();
		ArrayList<SubBoard> possibilitiesFenceV = this.getGame().getBoard().listOfPossibilitiesFenceVertical();
		int player;
		if(this == this.getGame().getPlayer1()){
			player = 1;
		} else {
			player = 2;
		}
		Square res = possibilitiesPawn.get(0);
		int tmp = 81;
		for(Square sqr : possibilitiesPawn){
			ArrayList<String> listSquare = new ArrayList<>();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					listSquare.add(i + "," + j);
				}
			}
			int tmp2 = this.getGame().getNbMinMove(sqr,player);
			if(tmp2 < tmp){
				tmp = tmp2;
				res = sqr;
			}
		}
		playPawn(res.getX(),res.getY());
	}

	/**
	 * Places a fence on the desired emplacement
	 * The overlapping validity is checked by the square object by fenceStatus
	 * The path validity is checked by the checkExistingPath method
	 *
	 */
	private void playFence() {
		// TODO - implement AutoPlayer.playFence
		throw new UnsupportedOperationException();
	}

	/**
	 * Moves the pawns to the desired direction.
	 * The validity is checked by the current square fenceStatus
	 *
	 */
	private void playPawn() {
		// TODO - implement AutoPlayer.playPawn
		throw new UnsupportedOperationException();
	}
}
