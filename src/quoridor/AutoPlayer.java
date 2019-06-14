package quoridor;

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
		// TODO - implement AutoPlayer.play
		this.getGame().getBoard().listOfPossibilitiesPawn(this,this.getGame());
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
